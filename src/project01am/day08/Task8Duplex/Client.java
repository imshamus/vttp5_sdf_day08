package day08.Task8Duplex;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args)
    {
        try
        {
            Socket socket = new Socket("localhost", 3000);
            System.out.println("Connected to server.");

            System.out.println("Input <Number> <Operator> <Number> to calculate results");
            System.out.println("List of operators:");
            System.out.println("'+'   -   Addition");
            System.out.println("'*'   -   Multiplication");
            System.out.println("'/'   -   Division");
            System.out.println("'-'   -   Subtraction");
        
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
        
        // System.out.println("Socket closing...");
        // socket.close();

    }
}
