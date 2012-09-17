package itu.dk.smds.e2012.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexander
 */
public class TcpServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int serverPort = 7896;
            ServerSocket serverSocket = new ServerSocket(serverPort);
            
            System.out.println("Server started at port: " + serverPort);
            
            Socket socket = serverSocket.accept();
            
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            
            String message = dis.readUTF();
            
            System.out.println("Message from Client: " + message);
            
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            
            outputStream.writeUTF("Ready");
            
            outputStream.flush();
            
            socket.close();
            
        } catch (IOException e) {
            Logger.getLogger(TcpServer.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("error message: " + e.getMessage());
        }
    }

}
