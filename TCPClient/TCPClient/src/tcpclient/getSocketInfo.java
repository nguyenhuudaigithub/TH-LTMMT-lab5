package tcpclient;

import java.io.IOException;
import java.net.Socket;

public class getSocketInfo {
    public static void main(String[] args) {
        try {
            Socket theSocket = new Socket("127.0.0.1", 80);
            System.out.println("Connected to " + theSocket.getInetAddress() +
                    " on port " + theSocket.getPort() + " from port " + theSocket.getLocalPort() + " of " + theSocket.getLocalAddress());
            theSocket.close(); // Don't forget to close the socket when you're done.
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
