import java.util.ArrayList;
/**
 * Write a description of class lotto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class lotto
{
    public static void main (String[]args) {
    Ticket ticket = new Ticket();
    ArrayList<Integer> ticketNums = ticket.returnTicket();
    for (int i = 0; i < ticketNums.size(); i++) {
        System.out.print(ticketNums.get(i) + "\t");
    }
    }
}
