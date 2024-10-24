package day08.Task8;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
    public static void main(String[] args) 
    {

        try 
        {
            ServerSocket server = new ServerSocket(3000);
            System.out.println("Server listening on port 3000");

            Socket clientSocket = server.accept();
            System.out.println("Client connected:" + clientSocket.getInetAddress());

            ServerReader sr = new ServerReader(clientSocket);
            Thread threadSr = new Thread(sr);

            ServerWriter sw = new ServerWriter(clientSocket);
            Thread threadSw = new Thread(sw);

            // Running concurrently, read and write
            threadSr.start();
            threadSw.start();
        }

        catch (IOException e) 
        {
            e.printStackTrace();
        }
        

        // System.out.println("Closing socket..");
        // clientSocket.close();

        // System.out.println("Closing server..");
        // server.close();
    }
}
