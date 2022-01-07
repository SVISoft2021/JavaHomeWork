package com.pb.sibikovskij.hw14;

import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class ClientSomthing {

    private Socket socket;
    private BufferedReader in; // потік читання із сокету
    private BufferedWriter out; // потік читання в сокет
    private BufferedReader inputUser; // потік читання з консолі
    private String addr; // ip адрес клієнта
    private int port; // порт з'єднання
    private String nickname; // ім'я клієнта
    private Date time;
    private String dtime;
    private SimpleDateFormat dt1;


    public ClientSomthing(String addr, int port) {
        this.addr = addr;
        this.port = port;
        try {
            this.socket = new Socket(addr, port);
        } catch (IOException e) {
            System.err.println("Помилка Socket");
        }
        try {
            // потоки читання з сокету / записи в сокет, та читання з консолі
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.pressNickname(); // перш ніж почати, ви повинні запитати ім'я
            new ReadMsg().start(); // лінія читання повідомлення з сокету в нескінченному циклі
            new WriteMsg().start(); // лінія писання повідомлення в сокет в нескінченному циклі
        } catch (IOException e) {
            ClientSomthing.this.downService();
        }
    }

    private void pressNickname() {
        System.out.print("Введіть своє ім'я: ");
        try {
            nickname = inputUser.readLine();
            out.write("Сервер -> привіт [" + nickname + "] - ви в Чаті\n");
            out.flush();
        } catch (IOException ignored) {
        }
    }

    private void downService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {}
    }

    // лінія читання повідомлень із сервера
    private class ReadMsg extends Thread {
        @Override
        public void run() {

            String str;
            try {
                while (true) {
                    str = in.readLine(); // чекаємо повідомлення із сервера
                    if (str.equals("stop")) {
                        ClientSomthing.this.downService();
                        break; // виходимо з циклу, якщо прийшло "stop"
                    }
                    System.out.println(str); // пишемо повідомлення із сервера на консоль
                }
            } catch (IOException e) {
                ClientSomthing.this.downService();
            }
        }
    }

    // лінія відправляє повідомлення, що надходять з консолі на сервер
    public class WriteMsg extends Thread {
        @Override
        public void run() {
            while (true) {
                String userWord;
                try {
                    time = new Date();
                    dt1 = new SimpleDateFormat("HH:mm:ss"); // беремо лише час до секунд з поточної дата
                    dtime = dt1.format(time); // время
                    userWord = inputUser.readLine(); // повідомлення з консолі
                    if (userWord.equals("stop")) {
                        out.write("stop" + "\n");
                        ClientSomthing.this.downService(); //
                        break; // виходимо з циклу, якщо прийшло "stop"
                    } else {
                        out.write("|" + dtime + "| [" + nickname + "]: " + userWord + "\n"); // відправляємо на сервер
                    }
                    out.flush(); // чистимо
                } catch (IOException e) {
                    ClientSomthing.this.downService(); //
                }
            }
        }
    }
}