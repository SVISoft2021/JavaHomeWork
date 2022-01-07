package com.pb.sibikovskij.hw14;

import java.io.*;
import java.net.*;
import java.util.LinkedList;

class ServerSomthing extends Thread {

    private Socket socket; // сокет, через який сервер спілкується із клієнтом
    private BufferedReader in; // потік читання із сокету
    private BufferedWriter out; // потік запису в сокет


    public ServerSomthing(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Server.story.printStory(out); // передача історії останніх 10 повідомлень новому з'єднанню
        start(); //
    }
    @Override
    public void run() {
        String word;
        try {
            // перше повідомлення відправлене - це нікнейм
            word = in.readLine();
            try {
                out.write(word + "\n");
                out.flush(); // flush() потрібен для виштовхування даних, що залишилися, і очищення потоку для нових повідомлень
            } catch (IOException ignored) {}
            try {
                while (true) {
                    word = in.readLine();
                    if(word.equals("stop")) {
                        this.downService(); //
                        break;
                    }
                    System.out.println("повідомлення " + word);
                    Server.story.addStoryEl(word);
                    for (ServerSomthing vr : Server.serverList) {
                        vr.send(word);
                    }
                }
            } catch (NullPointerException ignored) {}


        } catch (IOException e) {
            this.downService();
        }
    }

    private void send(String msg) {
        try {
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ignored) {}

    }

    //закриття сервера
    private void downService() {
        try {
            if(!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
                for (ServerSomthing vr : Server.serverList) {
                    if(vr.equals(this)) vr.interrupt();
                    Server.serverList.remove(this);
                }
            }
        } catch (IOException ignored) {}
    }
}

//Історія
class Story {

    private LinkedList<String> story = new LinkedList<>();

    public void addStoryEl(String el) {
        // якщо повідомлень більше 10, видаляємо перше та додаємо нове інакше просто додати
        if (story.size() >= 10) {
            story.removeFirst();
            story.add(el);
        } else {
            story.add(el);
        }
    }

    public void printStory(BufferedWriter writer) {
        if(story.size() > 0) {
            try {
                writer.write("Історія переписки" + "\n");
                for (String vr : story) {
                    writer.write(vr + "\n");
                }
                writer.write("/...." + "\n");
                writer.flush();
            } catch (IOException ignored) {}

        }

    }
}

public class Server {

    public static final int PORT = 8080;
    public static LinkedList<ServerSomthing> serverList = new LinkedList<>(); // список всіх ліній - екземплярів сервера для коджного клиента
    public static Story story; // історія переписки

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        story = new Story();
        System.out.println("Сервер стартував");
        try {
            while (true) {
                // Блокується до появи нової сполуки:
                Socket socket = server.accept();
                try {
                    serverList.add(new ServerSomthing(socket)); // додати нове з'єднання до списку
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }
}