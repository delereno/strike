import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
/**
 * Write a description of class newLotto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NewLotto
{
    static Scanner scanner = new Scanner(System.in);
    static int numLimit = 5;
    static int lineNum = 3;
    static boolean running = true;
    public static void main (String[]args) {
            
            
        Ticket ticket = new Ticket();
        
        Draw draw = new Draw();
        System.out.println("\nWelcome to Lotto! \nWould you like to:\nChoose your lines\nPlay with dips\nSpecial game!");
        String choice = scanner.nextLine();
        choice = choice.substring(0,1).toUpperCase() + choice.substring(1).toLowerCase();
        if (choice.equals("Choose")){
            chooseLine(ticket, draw);
        }
        else if (choice.equals("Dips")) {
            dips(ticket, draw);
        }
        else if (choice.equals("Special")) {
            special(ticket, draw);
        }
        
    }
    public static void chooseLine(Ticket ticket, Draw draw) {
        //asks user how many lotto lines they want, sets as line amount
        System.out.println("How many Lotto lines would you like to buy?");
        int lineNum = Integer.valueOf(scanner.nextLine());
        ticket.setLineNum(lineNum);
       

        ArrayList<Integer> powerball = new ArrayList<Integer>(lineNum);
        for(int i=0; i < lineNum; i++) {
            //lottoLines.add(new ArrayList(numLimit));
            // adds all 6 lotto values to list
            // while (lottoLines.get(i).size() <= numLimit) {
                // System.out.println("What number would you like to pick between 1-40?");
                // int pick = Integer.valueOf(scanner.nextLine());
                // if (pick >= 0 && pick <= 40) {
                    // lottoLines.get(i).add(pick); // SIMPLIFY THIS BY PUTTING INTO SEPERATE METHODS
                    // if (Collections.frequency(lottoLines.get(i), pick) > 1) {
                        // System.out.println("Uh oh, that number has already been selected"); 
                        // lottoLines.get(i).remove(lottoLines.get(i).size()-1);
                    // }
                // }
                // else {
                    // System.out.println("oops! that num is not between 1-40");
                // }   
            // }
            
            ticket.clearLine();
            ticket.createLine();
            ticket.addLine();
            
            
            // System.out.println("Will you add powerball to this line?");
            // String answer = scanner.nextLine(); //RENAME THIS VARIABLE
            // if (answer.equals("yes")) {
                // lottoLines.add(new ArrayList(numLimit+1)); //put linenum in brackets
                // while (running) {
                    // System.out.println("Pick a number between 1-10");
                    // int pick = Integer.valueOf(scanner.nextLine());
                    // if (pick >= 0 && pick <= 10) {
                        // powerball.add(pick); break;
                    // }
                    // else {
                        // System.out.println("oops! that num is not between 1-10");
                    // }
                // }
            // }
            // else {
                // lottoLines.add(new ArrayList(numLimit)); //put linenum in brackets
                // powerball.add(-1);
            // }
        }  
        
        ArrayList<ArrayList<Integer>> lottoLines = ticket.returnTicket();
        
        
        
        
        
        // for (int i = 0; i <= sizeLimit; i ++) {
            // while (ticket.get(i).size() <= sizeLimit) {
                // ticket.get(i).add(randInt());
                // if (Collections.frequency(ticket.get(i), randNum) > 1) {
                    // ticket.get(i).remove(ticket.get(i).size()-1);
                // }   
            // }
        // }

        System.out.println(lottoLines.get(1).get(2));
        for (int c = 0; c <= numLimit; c++) {
            System.out.println("");
            for (int k = 0; k < lineNum; k++) {
                System.out.print((lottoLines.get(k)).get(c) + "\t");
              
            }
        }
        // for (int k = 0; k < lineNum; k++) {
                // if (! powerball.get(k).equals(-1) ){
                    // System.out.print(powerball.get(k) + "\t");
                // }
            // }
        
    }
    public static void dips(Ticket ticket, Draw draw) {
        System.out.println("What would you like to choose?\nLucky Dip - Just Lotto\nPower Dip - Lotto and Powerball\nTriple Dip - Lotto, Powerball and Strike");
        String dipChoice = scanner.nextLine();
        dipChoice = dipChoice.substring(0,1).toUpperCase() + dipChoice.substring(1).toLowerCase();
        System.out.println(dipChoice);
        if (dipChoice.equals("Luckydip")){  
            System.out.println("Which Lucky Dip would you like to choose?\nA | $5.60 - 8 lotto lines\nB | $7 - 10 lotto lines\nC | $10.50 - 15 lotto lines\nD | $14 - 20 lotto lines");
            String dipChoiceA = scanner.nextLine();
            if (dipChoiceA.equals("A")){
                ticket.setLineNum(8);
                //ticket.randTicket();
                
            }
            else if (dipChoiceA.equals("B")){
            }
            else if (dipChoiceA.equals("C")){
            }
            else if (dipChoiceA.equals("D")){
            }
        }
        else if (dipChoice.equals("Powerdip")) {
            
        }
        else if (dipChoice.equals("Tripledip")) {

        }
        // lucky dip - just lotto
        /* 
         *$5.60 8 lotto lines
         *$7 10 lotto lines
         *$10.50 15 lotto lines
         *$14 20 lotto lines
         */
        // power dip - lotto + powerball
        /*
         * $12 8 lotto, 8 powerball
         * $15 10 lotto, 10 powerball
         * $18 12 lotto, 12 powerball
         * $24 16 lotto, 16 powerball
         */
        // triple dip - lotto + powerball + strike 
        /*
         * $16 10 lotto, 10 powerball, 1 strike
         * $18 10 lotto, 10 powerball, 3 strike
         * $20 12 lotto, 12 powerball, 2 strike 
         * $25 16 lotto, 16 powerball, 1 strike
         * $28 18 lotto, 18 powerball, 1 strike 
         */
    }
    public static void special(Ticket ticket, Draw draw) {
        // Repeat strike line until strike 4, record results
        
        // lotto repeat until division 1 and powerball win, record results
        
        //favourites menu - set up favorites, favourites vs rand

    }
    public static void checkTicket(Ticket ticket, Draw draw) {
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
