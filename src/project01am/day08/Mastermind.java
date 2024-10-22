package day08;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Mastermind 
{     
    public static void main(String[] args) 
    {

        List<Integer> numbers = new ArrayList<>();
        List<Integer> randNumbers = RandomNumbers.RandFourDigits();


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
               
               System.out.println(numbers);
               System.out.println(randNumbers);

               checkGuess(numbers, randNumbers);
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
        int c_counter = 0;
        int cp_counter = 0;
        int j = 0;

        for (int i = 0; i<randNumbers.size(); i++)
        {
            if(numbers.get(i).equals(randNumbers.get(i)))
            {
                cp_counter++;
            }
        }

        if (randNumbers.contains(numbers.get(j))) 
        {
            c_counter++;
            j++;
        }

        System.out.println("C: " + c_counter);
        System.out.println("CP: " + cp_counter);
    }

}
