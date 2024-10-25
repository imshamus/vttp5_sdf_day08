package day08.Task8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3000);
            System.out.println("Connected to server.");
            System.out.println();

            System.out.println("Input <Number> <Operator> <Number> to calculate results");
            System.out.println("List of operators:");
            System.out.println("'+'   -   Addition");
            System.out.println("'*'   -   Multiplication");
            System.out.println("'/'   -   Division");
            System.out.println("'-'   -   Subtraction");

            OutputStream os = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(writer);

            InputStream is = socket.getInputStream();
            Reader reader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(reader);
            
            while(!socket.isClosed())
            {
                Console cons = System.console();
            
                String userInput = cons.readLine(">>> ");

                if (userInput.equals("end"))
                {
                    bw.write(userInput + "\n");
                    bw.flush();

                    System.out.println("Client ending connection..");
                    break;
                }

                bw.write(userInput + "\n");
                bw.flush();

                String results = br.readLine();
                System.out.println("Results: " + results);
            }

            bw.close();
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
