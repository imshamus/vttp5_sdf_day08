public class workspace {

    // Methods
    public void getPermutation(String userInput)
    {
        // String[] inputs = userInput.split("");

        // for (String input : inputs)
        // {
        //     if(!inputList.contains(input))
        //     {
        //         inputList.add(input);
        //     }
        // }


        
        // System.out.println(inputList);


            // permutations.add(input);
            // System.out.println(permutations);

          
        

            /* Console cons = System.console();
            String msgClient = "";
            String msgServer = "";
            
            
            
            
            // Input Stream
            
    
            
    
            while(true)
            {            
                try
                {
                    msgClient = br.readLine();
    
                    if (msgClient != null)
                    {
                        if (msgClient.equals("end"))
                        {
                            System.out.println("Client is terminating connection..");
                            break;
                        }
    
                        else
                        {
                            System.out.printf("Msg from client is: %s \n", msgClient);
                            
                            String[] m = msgClient.split(" ");
                            Parameters p = new Parameters();
    
                        
                            bw.write("msg received.");
                            bw.newLine();
                            bw.flush();
                        } 
                    }
    
                    else
                    {
                        // Read user input
                        msgServer = cons.readLine(">>> ");
    
                        if (msgServer.equals("end"))
                        {
                            System.out.println("Server is ending connection..");
                            break;
                        }
    
                         // Write the message to the server and add a new line
                        bw.write(msgServer + "\n");
                        bw.flush();
                    }                
                }
    
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            } */

    }
    
}


/* 
Console cons = System.console();
        String msgClient = "";
        String msgServer = "";


        // Create socket to connect to the server
        

        // Output Stream
        

        // Input Stream
        
        
        while (true)
        {
            try
            {
                msgServer = br.readLine();

                if (msgServer != null)
                {
                    if (msgServer.equals("end"))
                    {
                        System.out.println("Server is terminating connection..");
                        break;
                    }

                    else
                    {
                        System.out.printf("Msg from Server is: %s \n", msgServer);
                    
                        bw.write("msg received.");
                        bw.newLine();
                        bw.flush();
                    } 
                }

                else
                {
                    // Read user input
                    msgClient = cons.readLine(">>> ");

                    if (msgClient.equals("end"))
                    {
                        System.out.println("Client is ending connection..");
                        break;
                    }

                     // Write the message to the server and add a new line
                    bw.write(msgServer + "\n");
                    bw.flush();
                }

            }

            catch(Exception e)
            {
                e.printStackTrace();
            }
        } */