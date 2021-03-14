import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * Creates a draw object
 *
 * @author Del Huang
 * @version 12/03/21
 */
public class Draw
{
    // instance variables - replace the example below with your own
    
    private final int MIN = 0;
    
    private int powerball = 0;
    private int bonusBall = 0;
    private int randNum = 0;
    private boolean running = true;
    ArrayList<Integer> line = new ArrayList<>();
    ArrayList<Integer> lotto = new ArrayList<>();
    ArrayList<Integer> strike = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    /**
     * Constructor for objects of class draw
     */
    public Draw() {
    }
    /**
     * Generates a random value
     */
    public int randInt(int max){
        randNum = (int) (Math.random() * max + MIN);
        return randNum;
    }
    
    public void drawLotto() {
        lotto = new ArrayList<>(line);
    }
    public void drawStrike() {
        strike = new ArrayList<>(line);
    }
    public void drawPowerball() {
        powerball = randInt(10);
    }
    public void checkDupe(int num){
        if (Collections.frequency(line, num) > 1) {
            line.remove(line.size()-1);
        } 
    }
    /**
     * Creates a single line
     */
    public void createLine(int numLimit) {
        while (line.size() <= numLimit) {
            int randnum = randInt(40);
            line.add(randnum);
            checkDupe(randnum);
        } 
                // int pick = Integer.valueOf(scanner.nextLine());
    }
    /**
     * Clears the line array
     */
    public void clearLine() {
        line.clear();
    }
    
  
    /**
     * Returns the lotto
     * 
     */
    public ArrayList returnLotto(){
        return lotto;
    }
    public ArrayList returnStrike(){
        return strike;
    }
    public int returnPowerball(){
        return powerball;
    }
 }
