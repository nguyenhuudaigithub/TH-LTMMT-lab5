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

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(10102)) {
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
                        try {
                            int number = Integer.parseInt(inputLine);
                            String binary = Integer.toBinaryString(number);
                            out.println("Nhi phan: " + binary);
                        } catch (NumberFormatException e) {
                            out.println("Khong phai so nguyen");
                        }
                    }
                } catch (IOException e) {                   
                }              
            }
        } catch (IOException e) {           
        }
    }
}

