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
        while (running) {
            ticket.scrub();
            while (running) {
                System.out.println("Welcome to Lotto!\n\nWould you like to:\nChoose your lines\nPlay with dips\nSpecial game!");
                String choice = scanner.nextLine();
                choice = choice.substring(0,1).toUpperCase() + choice.substring(1).toLowerCase();
                if (choice.equals("Choose")){
                    chooseLine(ticket, draw); break;
                }
                else if (choice.equals("Dips")) {
                    dips(ticket, draw); break;
                }
                else if (choice.equals("Special")) {
                    special(ticket, draw); break;
                }
                else {
                    System.out.println("Please enter a valid input.");
                }
            }
            
            
            ticket.printLotto();
            if (ticket.checkPowerball()) {
                ticket.printPowerball();
            }
            if (ticket.checkStrike()) {
                ticket.printStrike();
            }
            ticket.noPlayStrike();
            lottoDraw(ticket,draw);
            System.out.println("");
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
                break;
            }
            else {
                System.out.println("Please enter a valid input.");
            }
        }
        
    }
    
    public static void strike(Ticket ticket, Draw draw) {
        
        ticket.playStrike();
        
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
        while (running) {
            System.out.println("What would you like to choose?\nLucky Dip - Just Lotto\nPower Dip - Lotto and Powerball\nTriple Dip - Lotto, Powerball and Strike");
            String dipChoice = scanner.nextLine();
            dipChoice = dipChoice.substring(0,1).toUpperCase() + dipChoice.substring(1).toLowerCase();
            System.out.println(dipChoice);
            if (dipChoice.equals("Luckydip")){  
                while (running) {
                    System.out.println("Which Lucky Dip would you like to choose?" +
                        "\nA | $5.60 - 8 lotto lines" +
                        "\nB | $7 - 10 lotto lines" +
                        "\nC | $10.50 - 15 lotto lines" +
                        "\nD | $14 - 20 lotto lines");
                    String dipChoiceA = scanner.nextLine();
                    dipChoiceA = dipChoiceA.substring(0,1).toUpperCase() + dipChoiceA.substring(1).toLowerCase();
                    if (dipChoiceA.equals("A")){
                        ticket.setLineNum(8); break;
                    }
                    else if (dipChoiceA.equals("B")){
                        ticket.setLineNum(10); break;
                    }
                    else if (dipChoiceA.equals("C")){
                        ticket.setLineNum(15); break;
                    }
                    else if (dipChoiceA.equals("D")){
                        ticket.setLineNum(20); break;
                    }
                    else {
                        System.out.println("Please enter a valid input.");
                    }
                }
                break;
            }
            else if (dipChoice.equals("Powerdip")) {
                ticket.playPowerball();
                System.out.println("Which Power Dip would you like to choose?" +
                    "\nA | $12 - 8 lotto + powerball lines" +
                    "\nB | $15 - 10 lotto + powerball lines" +
                    "\nC | $18 - 12 lotto + powerball lines" +
                    "\nD | $24 - 16 lotto + powerball lines");
                String dipChoiceB = scanner.nextLine();
                dipChoiceB = dipChoiceB.substring(0,1).toUpperCase() + dipChoiceB.substring(1).toLowerCase();
                if (dipChoiceB.equals("A")){
                    ticket.setLineNum(8); break;
                }
                else if (dipChoiceB.equals("B")){
                    ticket.setLineNum(10); break;
                }
                else if (dipChoiceB.equals("C")){
                    ticket.setLineNum(12); break;
                }
                else if (dipChoiceB.equals("D")){
                    ticket.setLineNum(16); break;
                }
                break;
            }
            else if (dipChoice.equals("Tripledip")) {
                ticket.playPowerball();
                ticket.playStrike();
                while (running) {
                    System.out.println("Which Triple Dip would you like to choose?" +
                            "\nA | $16 - 10 lotto + powerball + 1 strike lines" +
                            "\nB | $18 - 10 lotto + powerball + 3 strike lines" +
                            "\nC | $20 - 12 lotto + powerball + 2 strike lines" +
                            "\nD | $25 - 16 lotto + powerball + 1 strike lines" +
                            "\nE | $28 - 18 lotto + powerball + 1 strike lines");
                    String dipChoiceC = scanner.nextLine();
                    dipChoiceC = dipChoiceC.substring(0,1).toUpperCase() + dipChoiceC.substring(1).toLowerCase();
                    if (dipChoiceC.equals("A")){
                        ticket.setLineNum(10);
                        ticket.setStrikeNum(1); break;
                    }
                    else if (dipChoiceC.equals("B")){
                        ticket.setLineNum(10);
                        ticket.setStrikeNum(3); break;
                    }
                    else if (dipChoiceC.equals("C")){
                        ticket.setLineNum(12);
                        ticket.setStrikeNum(2); break;
                    }
                    else if (dipChoiceC.equals("D")){
                        ticket.setLineNum(16);
                        ticket.setStrikeNum(1); break;
                    } 
                    else if (dipChoiceC.equals("E")){
                        ticket.setLineNum(18);
                        ticket.setStrikeNum(1); break;
                    }
                    else {
                        System.out.println("Please enter a valid input.");
                    }
                    
                }
                break;
            }
            else {  
                System.out.println("Please enter a valid input");
            } 
        }
        for(int i=0; i < ticket.returnLineNum(); i++) {
            ticket.randLine();
            ticket.addLine();
            ticket.clearLine();
        }
        if (ticket.checkPowerball()) {
            ticket.randPowerball();
            ticket.clearLine();
        }
        if (ticket.checkStrike()) {
            ticket.strikeTicket();
            for(int i=0; i < ticket.returnStrikeNum(); i++) {
                ticket.randLine();
                ticket.addStrike();
                ticket.clearLine();
            }
            ticket.lottoTicket();
        }
    }
    public static void lottoDraw (Ticket ticket,Draw draw ) {
        draw.createLine(3);
        draw.drawStrike();
        draw.clearLine();
        draw.createLine(5);
        draw.drawLotto();
        draw.drawPowerball();
        ArrayList<Integer> lottoMatch = draw.returnLotto();
        ArrayList<Integer> strikeMatch = draw.returnStrike();
        for (int k = 0; k <= 3; k++) {
                System.out.print(strikeMatch.get(k) + "\t");
            }
        for (int k = 0; k <= 5; k++) {
                System.out.print(lottoMatch.get(k) + "\t");
            }
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
