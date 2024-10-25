package day08.Task8Duplex;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class ClientWriter implements Runnable  
{
    private final Socket socket;

    public ClientWriter(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() 
    {
        try
        {
            Console cons = System.console();
            
            OutputStream os = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(writer);

            while(true)
            {
                String clientMsg = cons.readLine(">>> ");

                if (socket.isClosed())
                {
                    break;
                }

                if (clientMsg.equals("end"))
                {
                    bw.write(clientMsg + "\n"); // client send "end" command over to client
                    bw.flush();
                    break;
                }

                
                bw.write(clientMsg + "\n");
                bw.flush();
            }

            bw.close(); // cascaded close the other wrapped objects like writer & os
            socket.close(); // close socket if client input "end"

        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
}
