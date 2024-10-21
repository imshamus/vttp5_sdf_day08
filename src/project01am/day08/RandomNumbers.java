package day08;

import java.util.Random;

public class RandomNumbers 
{
    private String numbers;

    public RandomNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getNumber() {
        return numbers;
    }

    public void setNumber(String numbers) {
        this.numbers = numbers;
    }

    // Methods
    // Random Integer
    public static int generateRandom()
    {
        Random rand = new Random();
        int r = rand.nextInt(1, 7); // 1 is inclusive, 7 is exlcusive, generate 1-6
        
        return r;
    }
    
    // 4 Randoms

    public static String RandFourDigits()
    {
        int r1 = generateRandom();
        int r2 = generateRandom();
        int r3 = generateRandom();
        int r4 = generateRandom();

        String fd = Integer.toString(r1) + Integer.toString(r2) +Integer.toString(r3) +Integer.toString(r4); 
        return fd;
    }

}
