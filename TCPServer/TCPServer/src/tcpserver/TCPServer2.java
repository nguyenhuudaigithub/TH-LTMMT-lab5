/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

import java.net.ServerSocket;
import java.net.Socket;
import static tcpserver.TCPServer.PORT;

/**
 *
 * @author Administrator
 */
public class TCPServer2 {
    static final int PORT = 1235;
    private ServerSocket server = null;
    public TCPServer2(){
        try{
            server = new ServerSocket(PORT);            
        }catch(Exception e){
        e.printStackTrace();}
    }
    public void action(){
        Socket socket = null;
        int i = 0;
        System.out.println("....");
        try{
            while((socket=server.accept())!=null){
                new ServerThread2(socket,"Client#"+i);
                System.out.printf("Thread for client #%d generating ... %n",i++);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new TCPServer2().action();
    }
}
