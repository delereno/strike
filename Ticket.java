import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * Creates a ticket object
 *
 * @author Del Huang
 * @version 11/03/21
 */
public class Ticket
{
    // instance variables - replace the example below with your own
    
    private final int MIN = 0;
    private final int MAX = 40;
    private int numLimit = 5;
    private int lineNum = 3;
    private int strikeNum = 0;
    private int randNum = 0;
    private int pick;
    private boolean running = true;
    ArrayList<ArrayList<Integer>> lotto = new ArrayList<>();
    ArrayList<ArrayList<Integer>> strike = new ArrayList<>();
    ArrayList<Integer> line = new ArrayList<>(numLimit);
    ArrayList<Integer> powerball = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    /**
     * Constructor for objects of class ticket
     */
    public Ticket() {
    }
    /**
     * Generates a random value
     */
    public int randInt(){
        randNum = (int) (Math.random() * MAX + MIN);
        return randNum;
    }
    /**
     * Changes ticket size from 6 slots to 4 (Strike)
     */
    public void strikeTicket(){
        numLimit = 3;
    }
    
    /**
     * Changes ticket size from 4 slots to 6 (Lotto)
     */
    public void lottoTicket(){
        numLimit = 5;
    }
    /**
     * Changes the number of lines
     */
    public void setLineNum(int lnNum){
        lineNum = lnNum;
    }
    public void setStrikeNum(int lnNum){
        strikeNum = lnNum;
    }
    
    // /**
     // * Creates a ticket list REDO THIS
     // */
    // public void randTicket(){
        // while (ticket.size() <= numLimit) {
            // ticket.add(randInt());
            // checkDupe();
        // }
    // }    
    

   

    
    /**
     * Adds line to 2D array
     */
    public void addLine() {
        lotto.add(new ArrayList<>(line));
    }
    
    /**
     * Creates a single line
     */
    public void createLine() {
        while (line.size() <= numLimit) {
            System.out.println("What number would you like to pick between 1-40?");
            pick = Integer.valueOf(scanner.nextLine());
            checkNum(line, 40);
            checkDupe();
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
     * Checks if int is between 0 and 40
     */
    public boolean checkNum(ArrayList list, int max) {
        if (pick >= MIN && pick <= max) {
            list.add(pick);
            return false;
        }
        else {
            System.out.println("Please pick a number between 0-"+max+"");
            return true;
        }
    }
    
    public void checkDupe(){
        if (Collections.frequency(line, pick) > 1) {
            System.out.println("That number is already in the line");
            line.remove(line.size()-1);
        } 
    }
    /**
     * Returns the lotto Array
     */
    public ArrayList returnTicket(){
        return lotto;
    }
    
    /**
     * Returns the powerball Array
     */
    public ArrayList returnPowerball(){
        return powerball;
    }
    
    /**
     * Returns the strike Array
     */
    public ArrayList returnStrike(){
        return strike;
    }
    /**
     * Returns the lotto line num
     */
    public int returnLineNum(){
        return lineNum;
    }
    /**
     * Returns the strike line num
     */
    public int returnStrikeNum(){
        return strikeNum;
    }
    
    /**
     * Returns the number limit
     */
    public int returnNumLimit   (){
        return numLimit;
    }
    public void powerball() {
        running = true;
        while (running) {
            System.out.println("What number would you like to pick between 1-10?");
            pick = Integer.valueOf(scanner.nextLine());
            running = checkNum(powerball,10); 
        }
    }
    
    public void noPowerball() {
        powerball.add(-1);
    }
    
    public void addStrike() {
        strike.add(new ArrayList<>(line));
    }
    
}
