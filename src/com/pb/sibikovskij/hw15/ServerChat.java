package com.pb.sibikovskij.hw15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerChat {

    private static ArrayList<Handler> clients;

    static class Handler implements Runnable {
        private final Socket socket;
        // потік для читання даних
        private BufferedReader in;
        // потік для надсилання даних
        private PrintWriter out;


        public Handler(Socket socket) {
            this.socket = socket;
        }

        // надсилання повідомлень усім клієнтам, крім себе
        public void sendMessageToAll(String message){
            for (Handler client : clients) {
                if (!client.equals(this)){
                    client.out.println(message);
                }
            }
        }

        @Override
        public void run() {
            try {
                System.out.println(" " + java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm "))+
                        ": " + "Клієнт #" + (clients.indexOf(this)+1) + " ввійшов до чату");

                // створюємо потоки для зв'язку з клієнтом
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                sendMessageToAll(" " + java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm "))+ ":  " +
                        "Клієнт #" + (clients.indexOf(this)+1) + " ввійшов до чату");
                out.println(" Ваш nickname: #" + (clients.indexOf(this)+1));
                out.println(" Ваше повідомлення: ");
                String clientMessage;
                String serverMessage;

                // цикл очікування повідомлень від клієнта
                while ((clientMessage = in.readLine()) != null) {
                    if ("\\exit".equalsIgnoreCase(clientMessage)) {
                        out.println(clientMessage);
                        break;
                    }
                    serverMessage = java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm "))+ ":  " +
                            "Клієнт #" + (clients.indexOf(this)+1) + ": " + clientMessage;
                    sendMessageToAll(" " + serverMessage);
                    out.println(" " + java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm "))+ ":  " +
                            "Ви:  " + clientMessage);
                    System.out.println(" " + serverMessage);
                }

                System.out.println(" " + java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm "))+ ":  " +
                        "Клієнт #" + (clients.indexOf(this)+1) + " покинув чат");
                sendMessageToAll(" " + java.time.LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm "))+ ":  " +
                        "Клієнт #" + (clients.indexOf(this)+1) + " покинув чат");
//                clients.remove(this);
                out.close();
                in.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (Exception ex) {
                    // ignore
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        System.out.println(" Запуск серверу...");
        int serverPort = 5555;
        clients = new ArrayList<Handler>();

        // серверний сокет
        ServerSocket server = null;

        // создаем серверный сокет
        try {
            server = new ServerSocket(serverPort);
            System.out.println(" Порт Серверу чату: " + serverPort);
        } catch (IOException e) {
            System.out.println(" Помилка звязку з портом 5555");
            System.exit(-1);
        }

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        while (true) {
            try {
                Socket clientSocket = server.accept();
                Handler client=new Handler(clientSocket);
                clients.add(client);
                threadPool.submit(client);
            } catch (IOException e) {
                System.out.println(" Не можу встановити зєднання");
                System.exit(-1);
            }

        }

    }
}