package day08.ArithApp;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.io.Writer;
import java.io.Reader;

public class Client {

    public static void main(String[] args) throws IOException 
    {
        Console cons = System.console();
        String msg = "";

        // Create socket to connect to the server
        Socket socket = new Socket("localhost", 3000);
        System.out.println("Connected to port 3000 on localhost.");

        // Output Stream
        OutputStream os = socket.getOutputStream();
        Writer writer = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(writer);

        // Input Stream
        InputStream is = socket.getInputStream();
        Reader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);
        
        while (true)
        {
            try
            {
                // Read user input
                msg = cons.readLine(">>> ");
                
                // Write the message to the server and add a new line
                bw.write(msg + "\n");
                bw.flush();

                // Read the result back
                msg = br.readLine();

                if (msg == null)
                {
                    System.out.println("Server terminated connection..");
                    break;
                }

                else
                {
                    System.out.printf("Results from server is: %s \n", msg);
                }
            }

            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        System.out.println("Closing socket...");
        socket.close();

    }
    
}
