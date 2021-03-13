import java.util.ArrayList;
import java.util.Collections;
/**
 * Creates a ticket object
 *
 * @author Del Huang
 * @version 11/03/21
 */
public class Ticket
{
    // instance variables - replace the example below with your own
    private ArrayList<Integer> ticketNums = new ArrayList<Integer>();
    private final int MIN = 0;
    private final int MAX = 40;
    private int sizeLimit = 6;
    private int lineNum = 4;
    private int randNum = 0;
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
        sizeLimit = 3;
    }
    /**
     * Creates a ticket list
     */
    public void randTicket(){
        while (ticketNums.size() <= sizeLimit) {
            ticketNums.add(randInt());
            checkDupe();
        }
    }    
    public void checkDupe(){
        if (Collections.frequency(ticketNums, randNum) > 1) {
                    ticketNums.remove(ticketNums.size()-1);
                } 
    }
    /**
     * Returns the Array
     */
    public ArrayList returnTicket(){
        return ticketNums;
    }
    /**
     * Changes the number of lines
     */
    public void setLineNum(int lnNum){
        lineNum = lnNum;
    }
    /**
     * Creates 2D array to store multiple line tickets
     */
    public void createArray() {
        ArrayList<ArrayList<Integer>> ticket = new ArrayList<>(lineNum);
        for(int i=0; i < sizeLimit; i++) {
            ticket.add(new ArrayList(sizeLimit)); //put linenum in brackets
        }  
        for (int i = 0; i < sizeLimit; i ++) {
            for (int b = 0; b < lineNum; b++) {
                int num = randInt();
                ticket.get(b).add(num);
            }    
        }
        for (int c = 0; c < sizeLimit; c++) {
            System.out.println("");
            for (int k = 0; k < lineNum; k++) {
                System.out.print((ticket.get(k)).get(c) + "\t");
            }
        }
    }
}
