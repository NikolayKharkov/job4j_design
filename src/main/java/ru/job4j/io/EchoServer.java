package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String userInput = in.readLine();
                    switch (userInput
                            .substring(userInput.indexOf("?msg=") + 5, userInput.indexOf(" HTTP/1.1"))
                            .toLowerCase().trim()) {
                        case "exit":
                            server.close();
                            break;
                        case "hello":
                            out.write("Hello, dear friend.\n".getBytes());
                            break;
                        default:
                            out.write("What?.\n".getBytes());
                            break;
                    }
                    out.flush();
                }
            }
        }
    }
}