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
    Draw draw = new Draw();
    ArrayList<Integer> ticketNums = ticket.returnTicket();
    for (int i = 0; i < ticketNums.size(); i++) {
        System.out.print(ticketNums.get(i) + "\t");
    }
    ArrayList<Integer> drawNums = draw.returnDraw();
    System.out.println("");
    for (int i = 0; i < drawNums.size(); i++) {
        System.out.print(drawNums.get(i) + "\t");
    }
    ArrayList<Boolean> ticketMatch = new ArrayList<Boolean>();
    System.out.println("");
    for (int i = 0; i < ticketNums.size(); i++) {
        if (ticketNums.get(i).equals(drawNums.get(i))) {
            ticketMatch.add(true);
        }
        else {
            ticketMatch.add(false);
        }
    }
    for (int i = 0; i < drawNums.size(); i++) {
        System.out.print(ticketMatch.get(i) + "\t");
    }
    }
}
