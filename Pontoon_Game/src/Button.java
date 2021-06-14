import java.awt.Color;
import javax.swing.*;

public class Button extends JButton
{
    private int xcoord,ycoord;
    private int player;
    private int[][] numbers;
    public Button(int x, int y)
    {
        super();  
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        numbers = new int[5][5];
    }
    
    public void setNumbers(int i, int j, int n)
    {
       numbers[i][j] = n;  // helps in setting numbers 
    }
    
    public int getNumber(int a, int b)
    {
        int m = numbers[a][b];
        return m;  // helps in getting the number
    }
    
    // simple setters and getters
    public void setXcoord(int value)    { xcoord = value; }
    public void setYcoord(int value)    { ycoord = value; }
    public int getXcoord()              { return xcoord; }
    public int getYcoord()               {return ycoord;}
}