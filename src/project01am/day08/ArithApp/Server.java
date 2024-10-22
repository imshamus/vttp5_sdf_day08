package day08.ArithApp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.Reader;

public class Server 
{
    public static void main(String[] args) throws IOException {
        
        String msg = "";
        
        ServerSocket server = new ServerSocket(3000);
        System.out.println("Server listening on port 3000");

        Socket socket = server.accept();
        System.out.println("Client connected on port 3000 on localhost.");
        
        // Input Stream
        InputStream is = socket.getInputStream();
        Reader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);

        // Output Stream
        OutputStream os = socket.getOutputStream();
        Writer writer = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(writer);

        while(true)
        {
            try
            {
                msg = br.readLine();

                if (msg.equals("end"))
                {
                    System.out.println("Client is terminating connection..");
                    break;
                }

                else
                {
                    System.out.printf("Msg from client is: %s \n", msg);
                    
                    String[] m = msg.split(" ");
                    Parameters p = new Parameters();

                
                    bw.write("msg received.");
                    bw.newLine();
                    bw.flush();
                }
            }

            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        System.out.println("Closing socket..");
        socket.close();

        System.out.println("Closing server..");
        server.close();
    }
    
}
