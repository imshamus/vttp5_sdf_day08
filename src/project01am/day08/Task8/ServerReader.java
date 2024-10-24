package day08.Task8;

import java.net.Socket;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.ServerSocket;

public class ServerReader implements Runnable 
{
    private final Socket socket;
    private final ServerSocket server;
    
    public ServerReader(Socket socket, ServerSocket server) {
        this.socket = socket;
        this.server = server;
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
                try
                {
                    clientMsg = br.readLine();

                    if (clientMsg == null)
                    {
                        // if client sends null, connection is closed
                        System.out.println("Client is closed.");
                        break; // Exit loop and close the server and client socket
                    }
                    
                    if (clientMsg.equals("end"))
                    {
                        System.out.println("Client terminating connection..");
                        break; // Exit loop and close the server and client socket
                    }
                    
                    System.out.println("Message from client: " + clientMsg);
                    System.out.print(">>> "); // print prompt again
                }
                catch (SocketException e)
                {
                    System.out.println("Client socket closed.");
                    break;  // Exit loop if socket is closed from the client side
                }
                
            }

            socket.close(); // close client socket
            // server.close(); // close server socket, optional, 
            // only use if i want server to shutdown, remove if want to handle multiple client

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
