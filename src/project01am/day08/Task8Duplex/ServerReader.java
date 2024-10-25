package day08.Task8Duplex;

import java.net.Socket;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;

public class ServerReader implements Runnable 
{
    private final Socket socket;
    private final ServerWriter sw;
    
    public ServerReader(Socket socket, ServerWriter sw) {
        this.socket = socket;
        this.sw = sw;
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
                    
                    // Handle "end"command from client
                    if (clientMsg.equals("end"))
                    {
                        System.out.println("Client terminated connection.");
                        System.out.print("Hit 'Enter' to exit program.");
                        break; // Exit loop and close client socket
                    }
                    
                    System.out.println("Message from client: " + clientMsg);

                    String clientMsgList[] = clientMsg.split(" ");

                    int results = 0;

                    switch (clientMsgList[1]) {

                        case "+":
                            results = Parameters.addOps(Integer.parseInt(clientMsgList[0]), Integer.parseInt(clientMsgList[2]));
                            System.out.println("a");
                            sw.sendResults(results);
                            break;

                        case "-":
                            results = Parameters.subtractOps(Integer.parseInt(clientMsgList[0]), Integer.parseInt(clientMsgList[2]));
                            sw.sendResults(results);
                            break;

                        case "*":
                            results = Parameters.multiOps(Integer.parseInt(clientMsgList[0]), Integer.parseInt(clientMsgList[2]));
                            sw.sendResults(results);
                            break;

                        case "/":
                            results = Parameters.divideOps(Integer.parseInt(clientMsgList[0]), Integer.parseInt(clientMsgList[2]));
                            sw.sendResults(results);
                            break;

                        default:
                            System.out.println("Please try again.");
                            break;
                    }

                    System.out.print(">>> "); // print prompt again
                }
                catch (SocketException e)
                {
                    System.out.println("Connection to client ended.");
                    break;  // Exit loop if socket is closed from the client side
                }
            }

            socket.close(); // close socket after client sends "end"

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
