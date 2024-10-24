package day08.Task8;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class ServerWriter implements Runnable 
{
    private final Socket socket;

    public ServerWriter(Socket socket) {
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
                String serverMsg = cons.readLine(">>> ");

                if (serverMsg.equals("end"))
                {
                    bw.write("Server terminating connection.. \n");
                    bw.flush();
                    break;
                }

                bw.write(serverMsg + "\n");
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
