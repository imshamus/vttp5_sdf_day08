package day08.Task8Duplex;

import java.io.BufferedWriter;
import java.io.Console;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.net.Socket;

public class ServerWriter implements Runnable 
{
    private final Socket socket;
    private BufferedWriter bw;

    public ServerWriter(Socket socket) throws IOException {
        this.socket = socket;
        this.bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    @Override
    public void run() 
    {
        try  
        {
            Console cons = System.console();
            
            // OutputStream os = socket.getOutputStream();
            // Writer writer = new OutputStreamWriter(os);
            // BufferedWriter bw = new BufferedWriter(writer);

            while(true)
            {
                String serverMsg = cons.readLine(">>> ");

                if (socket.isClosed())
                {
                    break;
                }

                if (serverMsg.equals("end"))
                {
                    bw.write(serverMsg + "\n"); // server send "end" command over to client
                    bw.flush();
                    break;
                }

                bw.write(serverMsg + "\n");
                bw.flush();
            }

            bw.close(); // cascaded close the other wrapped objects like writer & os
            socket.close(); // close socket if server input "end"
            
        } 
        
        catch (IOException e) 
        {
            e.printStackTrace();
        }     
    }

    public void sendResults(int results) throws IOException
    {
        bw.write("Results: " + results + "\n");
        bw.flush();
    } 
    
}
