package day08.Task8Duplex;

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

            ServerWriter sw = new ServerWriter(clientSocket);
            Thread threadSw = new Thread(sw);

            ServerReader sr = new ServerReader(clientSocket, sw);
            Thread threadSr = new Thread(sr);

            
            // Running concurrently, read and write
            threadSr.start();
            threadSw.start();

            try
            {
                threadSr.join(); // main thread waits for threadSr to finish
                threadSw.join(); // main thread waits for threadSw to finish
            }
            catch (InterruptedException e)
            {   
                e.printStackTrace();
            }

            System.out.println("Server closing..");
            server.close();
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
