package day08;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Mastermind 
{  
    public static void main(String[] args) 
    {

        List<Integer> numbers = new ArrayList<>();

        Console cons = System.console();

        System.out.println("Welcome to Mastermind! Guess the 4 digit number. Each digit ranges from 1-6.");
        System.out.println("To guess:   Enter the 4 digits.");
        System.out.println("To quit:    Enter 'quit'");

        // Get user input
        while(true)
        {   
            numbers.clear();
            // inputList.clear();
           
            String userInput = cons.readLine("> ").toLowerCase();

            if(!(userInput.equals("quit")))
            { 
                if (userInput.length() != 4)
                {
                    System.out.println("Please guess only 4 digits.");
                }
                else
                {   
                    String[] strList = userInput.split("");

                    for (String number: strList)
                    {
                        int i = Integer.parseInt(number);

                        if (i < 1 || i > 6)
                        {
                            System.out.println("Each digit must range between 1-6");
                            break;
                        }
                        else
                        {
                            numbers.add(i);
                        }
                    }

                    System.out.println(numbers);
                }
            }
  
            else
            {
                System.out.println("Thank you! Have a nice day!");

                break;
            }            
        }
        
    }

    // Methods
    

}
