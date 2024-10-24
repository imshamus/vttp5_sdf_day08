package day08.Task8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;
import java.net.SocketException;

public class ClientReader implements Runnable 
{
    private final Socket socket;

    public ClientReader(Socket socket) {
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
            String serverMsg = "";

            while (true)
            {
                if (socket != null)
                {
                    try
                    {
                        serverMsg = br.readLine();

                        if (serverMsg == null)
                        {
                            System.out.println();
                            System.out.println("Server is closed.");
                            break;
                        }
                                    
                        if (serverMsg.equals("end"))
                        {
                            System.out.println("Server terminating connection..");
                            break;
                        } 

                        System.out.println("Message from server: " + serverMsg);
                        System.out.print(">>> "); // print prompt again
                    }
                    
                    catch (SocketException e)
                    {
                        System.out.println("Server socket closed.");
                        break;
                    }
                    
                }
                

            }
                  
        } 

        catch (IOException e) 
        {
            e.printStackTrace();
        }        
    }  
}
