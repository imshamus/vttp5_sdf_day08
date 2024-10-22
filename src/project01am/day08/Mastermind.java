package day08;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Mastermind 
{     
    public static void main(String[] args) 
    {          
        while (true)
        {
            boolean restart = false;
            List<Integer> numbers = new ArrayList<>();
            List<Integer> randNumbers = RandomNumbers.RandFourDigits();


            Console cons = System.console();

            System.out.println("Welcome to Mastermind! Guess the 4 digit number. Each digit ranges from 1-6.");
            System.out.println("To guess:   Enter the 4 digits.");
            System.out.println("To quit:    Enter 'quit'");

            // Get user input
            while(!restart)
            {   
                numbers.clear();
            
                String userInput = cons.readLine("> ").toLowerCase();

                if(!(userInput.equals("quit")))
                { 
                    numbers = UserGuess.guess(userInput);
                
                    // System.out.println(numbers);
                    // System.out.println(randNumbers);
            
                    try
                    {
                        int cp = checkGuess(numbers, randNumbers);

                        if(cp == 4)
                        {
                            System.out.println("You've won! Congratulations!");

                            while (!restart) 
                            {
                                System.out.println("Exit with 'quit' or 'play' to start new game.");
                                userInput = cons.readLine("> ");

                                switch (userInput) 
                                {
                                    case "play":

                                        restart = true;

                                        break;

                                    case "quit":

                                        System.out.println("Thank you.");
                                        System.exit(0);

                                        break;
                                
                                    default: 

                                        break;
                                }
                            }
                        }
                    }
                    catch (IndexOutOfBoundsException e)
                    {
                        System.out.println("Please try again.");
                    }
                }
                
                else
                {
                    System.out.println("Thank you! Have a nice day!");

                    break;
                }            
            }
        }
    }
        
    // Methods
    
    public static Integer checkGuess(List<Integer> numbers, List<Integer> randNumbers)
    {   
        int c_counter = 0;
        int cp_counter = 0;

        for (int i = 0; i<randNumbers.size(); i++)
        {
            if(numbers.get(i).equals(randNumbers.get(i)))
            {
                cp_counter++;
            }
        }

        for (int j = 0; j<randNumbers.size(); j++)
        {
            if (randNumbers.contains(numbers.get(j))) 
            {
                c_counter++;
            }
        }

        c_counter -= cp_counter;

        System.out.println("C: " + c_counter);
        System.out.println("CP: " + cp_counter);

        return cp_counter;
    }

}
