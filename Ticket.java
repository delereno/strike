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
    private final int SIZELIMIT = 5;
    private int randNum = 0;
    /**
     * Constructor for objects of class ticket
     */
    public Ticket() { 

        while (ticketNums.size() <= SIZELIMIT) {
            randInt();
            ticketNums.add(randNum);
            if (Collections.frequency(ticketNums, randNum) > 1) {
                ticketNums.remove(ticketNums.size());
            } 
        }
        
    }
    /**
     * Generates a random value
     */
    public int randInt(){
        randNum = (int) (Math.random() * MAX + MIN);
        return randNum;
    }
    /**
     * Returns the Array
     * 
     */
    public ArrayList returnTicket(){
        return ticketNums;
    }
}
