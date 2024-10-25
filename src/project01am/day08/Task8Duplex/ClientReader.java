package day08.Task8Duplex;

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
                try
                {
                    serverMsg = br.readLine();
                       
                    // Handle "end" command from server
                    if (serverMsg.equals("end"))
                    {
                        System.out.println("Server terminated connection..");
                        System.out.print("Hit 'Enter' to exit program.");
                        break; // Exit loop and close the client socket
                    } 

                    System.out.println("Message from server: " + serverMsg);
                    System.out.print(">>> "); // print prompt again
                }
                catch (SocketException e)
                {
                    System.out.println("Connection to server ended."); // Unable to read since server
                    break; // Exit loop if socket is closed from the server side
                }
            }

            socket.close(); // Close socket after server sends "end"

        } 

        catch (IOException e) 
        {
            e.printStackTrace();
        }        
    }  
}
