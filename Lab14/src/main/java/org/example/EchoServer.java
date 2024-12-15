package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java EchoServer <port number>");
            return;
        }
        int portNumber = Integer.parseInt(args[0]);

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Server is listening on port " + portNumber);
            while (true) {
                try (
                        Socket clientSocket = serverSocket.accept();
                        PrintWriter sockOut = new PrintWriter(clientSocket.getOutputStream(), true);
                        BufferedReader sockIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());
                    String inputLine;
                    while ((inputLine = sockIn.readLine()) != null) {
                        System.out.println("Received: " + inputLine);
                        sockOut.println(inputLine);
                    }
                    System.out.println("Client disconnected.");
                } catch (IOException e) {
                    System.err.println("Error handling client: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Could not start server: " + e.getMessage());
        }
    }
}
