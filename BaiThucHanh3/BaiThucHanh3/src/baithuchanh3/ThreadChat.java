/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiThucHanh3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class ThreadChat implements Runnable {

    private Scanner in = null;
    public frmClient chat = null;
    private Socket socket;
    ServerSocket server = null;

    public ThreadChat() throws IOException {
        server = new ServerSocket(1234);
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                while((socket = server.accept()) != null){
                    this.in = new Scanner(this.socket.getInputStream());
                    String chuoi = in.nextLine().trim();
                    chat.HienThi(chuoi + "\n");
                }
            }
        } catch (Exception e) {
           
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }
}
