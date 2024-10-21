package day08;

import java.util.ArrayList;
import java.util.List;

public class UserGuess 
{
    private String guess;

    public UserGuess(String guess) {
        this.guess = guess;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    // Methods
    public static List<Integer> guess(String userInput) 
    {
        List<Integer> numbers = new ArrayList<>();

        if (userInput.length() != 4)
        {
            System.out.println("Please guess only 4 digits.");

            return null;
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

            return numbers;
        }
    }
    

    
}
