package itu.dk.smds.e2012.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexander
 */
public class TcpClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 7896;
            
            Socket socket = new Socket(serverAddress, serverPort);
            
            boolean serverState = checkServer(socket);
            if (serverState == false) 
                { throw new IOException("No server response"); }
            
            // Insert responses here --
            
            socket.close();
            
        } catch (Exception e) {
            Logger.getLogger(TcpClient.class.getName()).log(Level.SEVERE, null, e);
            
            System.out.println("error message: " + e.getMessage());
        }
    }
    
    private static boolean checkServer(Socket socket) throws IOException {
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        
        String message = "Hello Server!";
        
        dos.writeUTF(message);
        dos.flush();
        
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        
        String response = dis.readUTF();
        
        System.out.println("Message from Server: " + response);
        
        if (response.equals("Ready")) { return true; }
        else { return false; }
    }

}
