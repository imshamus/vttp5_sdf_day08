package day08.ArithApp;

public class Parameters 
{
    private int var1;
    private int var2;

    // Constructors
    public Parameters() {
    }

    public Parameters(int var1, int var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    // Getters Setters
    public int getVar1() {
        return var1;
    }

    public void setVar1(int var1) {
        this.var1 = var1;
    }

    public int getVar2() {
        return var2;
    }

    public void setVar2(int var2) {
        this.var2 = var2;
    }

    // Methods
    public int addOps(int var1, int var2)
    {
        int results = var1 + var2;
        return results;
    }
    
    public int divideOps(int var1, int var2)
    {
        int results = var1 / var2;
        return results;
    }

    public int multiOps(int var1, int var2)
    {
        int results = var1 * var2;
        return results;
    }

    public int subtractOps(int var1, int var2)
    {
        int results = var1 - var2;
        return results;
    }
    
    
}
