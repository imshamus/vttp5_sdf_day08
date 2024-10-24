package day08.Task8;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args)
    {
        try
        {
            Socket socket = new Socket("localhost", 3000);
            System.out.println("Connected to server.");
        
            ClientWriter cw = new ClientWriter(socket);
            Thread threadCw = new Thread(cw);

            ClientReader cr = new ClientReader(socket);
            Thread threadCr = new Thread(cr);

            // Running concurrently, read and write
            threadCw.start();
            threadCr.start();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        // System.out.println("Closing socket...");
        // socket.close();

    }
}
