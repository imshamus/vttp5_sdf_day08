package day08;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Mastermind 
{  
    public static void main(String[] args) 
    {

        List<Integer> numbers = new ArrayList<>();
        List<Integer> randNumbers = new ArrayList<>();

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
               numbers = UserGuess.guess(userInput);
               randNumbers = RandomNumbers.RandFourDigits();
               
               System.out.println(numbers);
               System.out.println(randNumbers);
            }
  
            else
            {
                System.out.println("Thank you! Have a nice day!");

                break;
            }            
        }
        
    }

    // Methods
    
    public static void checkGuess(List<Integer> numbers, List<Integer> randNumbers)
    {
        for(int i = 0; i<randNumbers.size(); i++)
        {
            if(numbers[i].equals)
        }
    }

}
