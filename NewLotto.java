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
    static boolean running = true;
    static ArrayList<ArrayList<Integer>> lotto = new ArrayList<>();
    static ArrayList<Integer> powerball = new ArrayList<Integer>();
    static ArrayList<ArrayList<Integer>> strike = new ArrayList<>();
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
            //dips(ticket, draw);
        }
        else if (choice.equals("Special")) {
            special(ticket, draw);
        }
        
    }
    public static void chooseLine(Ticket ticket, Draw draw) {
        //asks user how many lotto lines they want, sets as line amount
        while (running) {
            System.out.println("How many Lotto lines would you like to buy?");
            int lineNum = Integer.valueOf(scanner.nextLine());
            
            if (lineNum >= 4 && lineNum <= 20) {
                ticket.setLineNum(lineNum); break;
            }
            else {
                System.out.println("Please enter a valid input (between 4 and 20 lines).");
            }
        }
       

        
        for(int i=0; i < ticket.returnLineNum(); i++) {
            
            //Program allows player to create a line, adds to 2d array of lines
            ticket.createLine();
            ticket.addLine();
            ticket.clearLine(); //clears line for next loop
            
            // If player wishes, they can add to the powerball array with one num per line
            while (running) {
            System.out.println("Will you add powerball to this line?");
            String answer = scanner.nextLine();
            answer = answer.substring(0,1).toUpperCase() + answer.substring(1).toLowerCase();
                if (answer.equals("Yes")) {
                    ticket.powerball();
                    break;
                }
                else if (answer.equals("No")) {
                    ticket.noPowerball();
                    break;
                }
                else {
                    System.out.println("Please enter a valid input.");
                }
            }
        }  
        
        // Player can buy strike tickets
        while (running) {
            System.out.println("Would you also like to play Strike?");
            String answer = scanner.nextLine(); 
            answer = answer.substring(0,1).toUpperCase() + answer.substring(1).toLowerCase();
            if (answer.equals("Yes")) {
                strike(ticket, draw);
                break;
            }
            else if (answer.equals("No")) {
                strike(ticket, draw);
                break;
            }
            else {
                System.out.println("Please enter a valid input.");
            }
        }
        lotto = ticket.returnTicket();
        powerball = ticket.returnPowerball();
        
        
        
        
        // for (int i = 0; i <= sizeLimit; i ++) {
            // while (ticket.get(i).size() <= sizeLimit) {
                // ticket.get(i).add(randInt());
                // if (Collections.frequency(ticket.get(i), randNum) > 1) {
                    // ticket.get(i).remove(ticket.get(i).size()-1);
                // }   
            // }
        // }

        
        for (int c = 0; c <= 5; c++) {
            System.out.println("");
            for (int k = 0; k < ticket.returnLineNum(); k++) {
                System.out.print((lotto.get(k)).get(c) + "\t");
              
            }
        }
        System.out.println("");
        for (int k = 0; k < ticket.returnLineNum(); k++) {
                if (! powerball.get(k).equals(-1) ){
                    System.out.print(powerball.get(k) + "\t");
                }
                
                else if ( powerball.get(k).equals(-1) ){
                    System.out.print("" + "\t");
                }
            }
        for (int c = 0; c <= 3; c++) {
            System.out.println("");
            for (int k = 0; k < ticket.returnStrikeNum(); k++) {
                System.out.print((strike.get(k)).get(c) + "\t");
            }
        }
    }
    
    public static void strike(Ticket ticket, Draw draw) {
        //asks user how many strike lines they want, sets as line amount
        while (running) {
            System.out.println("How many Strike lines would you like to buy?");
            ticket.setStrikeNum(Integer.valueOf(scanner.nextLine()));
            if (ticket.returnStrikeNum() >= 0 && ticket.returnStrikeNum() <= 20) {
                break;
            }
            else {
                System.out.println("Please enter a valid input (between 0 and 20 lines).");
            }
        }
        ticket.strikeTicket();
        for(int i=0; i < ticket.returnStrikeNum(); i++) {
            
            //Program allows player to fill a line, adds to 2d array of lines
            ticket.createLine();
            ticket.addStrike();
            ticket.clearLine(); 
        }
        ticket.lottoTicket();
        strike = ticket.returnStrike();
    }
    public static void dips(Ticket ticket, Draw draw) {
        // System.out.println("What would you like to choose?\nLucky Dip - Just Lotto\nPower Dip - Lotto and Powerball\nTriple Dip - Lotto, Powerball and Strike");
        // String dipChoice = scanner.nextLine();
        // dipChoice = dipChoice.substring(0,1).toUpperCase() + dipChoice.substring(1).toLowerCase();
        // System.out.println(dipChoice);
        // if (dipChoice.equals("Luckydip")){  
            // System.out.println("Which Lucky Dip would you like to choose?\nA | $5.60 - 8 lotto lines\nB | $7 - 10 lotto lines\nC | $10.50 - 15 lotto lines\nD | $14 - 20 lotto lines");
            // String dipChoiceA = scanner.nextLine();
            // if (dipChoiceA.equals("A")){
                // ticket.setLineNum(8);
                // //ticket.randTicket();
                
            // }
            // else if (dipChoiceA.equals("B")){
            // }
            // else if (dipChoiceA.equals("C")){
            // }
            // else if (dipChoiceA.equals("D")){
            // }
        // }
        // else if (dipChoice.equals("Powerdip")) {
            
        // }
        // else if (dipChoice.equals("Tripledip")) {

        // }
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
    // public static void checkTicket(Ticket ticket, Draw draw) {
        // ArrayList<Integer> ticketNums = ticket.returnTicket();
        // for (int i = 0; i < ticketNums.size(); i++) {
            // System.out.print(ticketNums.get(i) + "\t");
        // }
        // ArrayList<Integer> drawNums = draw.returnDraw();
        // System.out.println("");
        // for (int i = 0; i < drawNums.size(); i++) {
            // System.out.print(drawNums.get(i) + "\t");
        // }
        // ArrayList<Boolean> ticketMatch = new ArrayList<Boolean>();
        // System.out.println("");
        // for (int i = 0; i < ticketNums.size(); i++) {
            // if (ticketNums.get(i).equals(drawNums.get(i))) {
                // ticketMatch.add(true);
            // }
            // else {
                // ticketMatch.add(false);
            // }
        // }
        // for (int i = 0; i < drawNums.size(); i++) {
            // System.out.print(ticketMatch.get(i) + "\t");
        // }
    // }
}
