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
    private int randNum = 0;
    private int pick;
    ArrayList<ArrayList<Integer>> ticket = new ArrayList<>(lineNum);
    ArrayList<Integer> line = new ArrayList<>(lineNum);
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
     * Changes the number of lines
     */
    public void setLineNum(int lnNum){
        lineNum = lnNum;
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
        ticket.add(new ArrayList<>(line));
    }
    
    /**
     * Creates a single line
     */
    public void createLine() {
        while (line.size() <= numLimit) {
            System.out.println("What number would you like to pick between 1-40?");
            pick = Integer.valueOf(scanner.nextLine());
            checkNum();
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
    public void checkNum() {
        if (pick >= 0 && pick <= 40) {
            line.add(pick); 
            checkDupe();
        }
        else {
            System.out.println("Please pick a number between 1-40");
        }
    }
    
    public void checkDupe(){
        if (Collections.frequency(line, pick) > 1) {
            System.out.println("That number is already in the line");
            line.remove(line.size()-1);
        } 
    }
    /**
     * Returns the Array
     */
    public ArrayList returnTicket(){
        return ticket;
    }
}
