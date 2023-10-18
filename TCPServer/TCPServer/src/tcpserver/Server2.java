/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

/**
 *
 * @author Administrator
 */
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.List;

public class Server2 {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(11112)) {
            System.out.println("...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Ket noi: " + clientSocket);
                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        if (inputLine.equalsIgnoreCase("exit")) {
                            break; 
                        }
                        if (inputLine.startsWith("LIST ")) {
                            String directoryName = inputLine.substring(5); 
                            File directory = new File(directoryName);
                            if (directory.exists() && directory.isDirectory()) {
                                File[] files = directory.listFiles();
                                if (files != null) {
                                    for (File file : files) {
                                        out.println(file.getName());
                                    }
                                }
                            } else {
                                out.println("Thu muc khong ton tai.");
                            }
                        } 
                    }
                } catch (IOException e) {                 
                }
            }
        } catch (IOException e) {
        }
    }
}

