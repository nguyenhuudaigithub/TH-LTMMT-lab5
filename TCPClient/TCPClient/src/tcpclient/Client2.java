    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpclient;

/**
 *
 * @author Administrator
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 11112);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Nhap: ");
                String userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("exit")) {
                    break; 
                }
                out.println(userInput);
                String response;
                while (!(response = in.readLine()).isEmpty()) {
                    System.out.println(response);
                }
            }
        } catch (IOException e) {
        }
    }
}

