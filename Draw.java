import java.util.ArrayList;
import java.util.Collections;
/**
 * Creates a draw object
 *
 * @author Del Huang
 * @version 12/03/21
 */
public class Draw
{
    // instance variables - replace the example below with your own
    private ArrayList<Integer> drawNums = new ArrayList<Integer>();
    private final int MIN = 0;
    private final int MAX = 40;
    private final int SIZELIMIT = 5;
    private int randNum = 0;
    /**
     * Constructor for objects of class draw
     */
    public Draw() { 
        createDraw();
    }
    /**
     * Generates a random value
     */
    public int randInt(){
        randNum = (int) (Math.random() * MAX + MIN);
        return randNum;
    }
    /**
     * Creates a draw list
     */
    public void createDraw(){
        while (drawNums.size() <= SIZELIMIT) {
            randInt();
            drawNums.add(randNum);
            checkDupe();
        }
    }    
    public void checkDupe(){
        if (Collections.frequency(drawNums, randNum) > 1) {
                    drawNums.remove(drawNums.size()-1);
                } 
    }
    /**
     * Returns the Array
     * 
     */
    public ArrayList returnDraw(){
        return drawNums;
    }
}
