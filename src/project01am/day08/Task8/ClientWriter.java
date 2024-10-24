package day08.Task8;

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

                if (clientMsg.equals("end"))
                {
                    bw.write("Client ending connection.. \n");
                    bw.flush();
                    break;
                }

                bw.write(clientMsg + "\n");
                bw.flush();
            }

            bw.close(); // cascaded close the other wrapped objects like writer & os
            socket.close();

        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
}
