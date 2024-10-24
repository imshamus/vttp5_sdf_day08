package day08.Task6;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation 
{
    Set<String> permutations = new HashSet<>();
    Set<String> tempList = new HashSet<>();

    public static void main(String[] args) 
    {
        List<String> inputList = new ArrayList<>();
        Console cons = System.console();

        // Get user input
        while(true)
        {   
            inputList.clear();
            
            String userInput = cons.readLine("Enter '4 distinct alphanumeric inputs' or 'quit' to exit: "); // 4 digit permutation is 4! = 4 x 3 x 2 x 1 = 24 unique

            if(!(userInput.equals("quit")))
            { 
                if (userInput.length() != 4)
                {
                    System.out.println("Inputs must be exactly 4.");
                }

                else
                {   
                    String[] inputs = userInput.split("");

                    for (String input : inputs)
                    {
                        if(!inputList.contains(input))
                        {
                            inputList.add(input);
                        }
                    }

                    if(inputList.size()<4)
                    {
                        System.out.println("Please do not enter repeated inputs");
                    }

                    else
                    {
                        System.out.println(inputList);
                        // System.out.println(inputList.get(0));
                    }
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
     public void getPermutation(List<String> inputList)
     {
        List<String> tempList = new ArrayList<>();

        for(int i = 0; i < inputList.size(); i++)
        {
            tempList.add(inputList.get(i));
        }

        
     }
}
