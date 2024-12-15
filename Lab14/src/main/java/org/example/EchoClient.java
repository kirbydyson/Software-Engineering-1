package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java EchoClient <host name> <port number>");
            return;
        }
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (
                Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter sockOut = new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader sockIn = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;
            System.out.println("Connected to server. Type your message:");
            while ((userInput = stdIn.readLine()) != null) {
                sockOut.println(userInput);
                System.out.println("Echo: " + sockIn.readLine());
            }
        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }
}
