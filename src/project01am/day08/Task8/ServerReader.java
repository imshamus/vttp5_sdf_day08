package day08.Task8;

import java.net.Socket;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ServerReader implements Runnable 
{
    private final Socket socket;
    
    public ServerReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() 
    {
        try ( // try-with-resources - auto close 
            InputStream is = socket.getInputStream();
            Reader reader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(reader);
        ) {
            String clientMsg = "";

            while (true)
            {
                clientMsg = br.readLine();

                if (clientMsg == null)
                {
                    System.out.println();
                    System.out.println("Client is closed.");
                    break;
                }
                
                if (clientMsg.equals("end"))
                {
                    System.out.println("Client terminating connection..");
                    break;
                }
                
                System.out.println("Message from client: " + clientMsg);
                System.out.print(">>> "); // print prompt again
            }

            socket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
