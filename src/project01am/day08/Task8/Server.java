package day08.Task8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(3000);
            System.out.println("Server listening on port 3000");

            Socket clientSocket = server.accept(); // blocking call, waits for client to connect
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            InputStream is = clientSocket.getInputStream();
            Reader reader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(reader);

            OutputStream os = clientSocket.getOutputStream();
            Writer writer = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(writer);

            while (!clientSocket.isClosed())
            {
                String userInput = br.readLine();

                if (userInput.equals("end"))
                {
                    System.out.println("Client ended connection..");
                    break;
                }
                else
                {
                    System.out.println(userInput);
                    String[] inputList = userInput.trim().split(" ");

                    int results = 0;

                    switch (inputList[1]) {

                        case "+":
                            results = Operations.addOps(Integer.parseInt(inputList[0]), Integer.parseInt(inputList[2]));
                            break;
                        
                        case "-":
                        results = Operations.subOps(Integer.parseInt(inputList[0]), Integer.parseInt(inputList[2]));
                        break;

                        case "*":
                        results = Operations.mulOps(Integer.parseInt(inputList[0]), Integer.parseInt(inputList[2]));
                        break;

                        case "/":
                            results = Operations.divOps(Integer.parseInt(inputList[0]), Integer.parseInt(inputList[2]));
                            break;

                        default:
                            break;
                    }

                    bw.write(Integer.toString(results) + "\n");
                    bw.flush();
                }

            }
            
            server.close();
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
