import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
/**
 * Creates a lotto ticket, compares it to a lotto draw to decide winnings
 *
 * @author Del Huang
 * @version 15/03/21
 */
public class NewLotto {
    static Scanner scanner = new Scanner(System.in);
    static boolean running = true;
    static ArrayList<ArrayList<Integer>> lotto = new ArrayList<>();
    static ArrayList<Integer> powerball = new ArrayList<Integer>();
    static ArrayList<ArrayList<Integer>> strike = new ArrayList<>();
    public static void main (String[]args) {     
            // Creates lotto ticket and draw objects
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
                
                ArrayList<ArrayList<Integer>> strike = ticket.returnStrike();
                ArrayList<ArrayList<Integer>> lotto = ticket.returnTicket();
                ArrayList<Integer> powerball = ticket.returnPowerball();
    
                System.out.println("---------Lotto Ticket---------");
                for (int i = 0; i < lotto.size(); i++) {
                    for (int c = 0; c < lotto.get(i).size(); c++ ) {
                        System.out.print(lotto.get(i).get(c) + "\t");
                    }
                    if (ticket.checkPowerball()) {
                        System.out.print(powerball.get(i));
                    }
                    System.out.println("");
                }
                if (ticket.checkStrike()) {
                    System.out.println("---------Strike Ticket---------");
                    for (int i = 0; i < strike.size(); i++) {
                        for (int c = 0; c < strike.get(i).size(); c++ ) {
                            System.out.print(strike.get(i).get(c) + "\t");
                        }
                        System.out.println("");
                    }
                }
                // if (ticket.checkPowerball()) {
                    // ticket.printPowerball();
                // }
                
                // if (ticket.checkStrike()) {
                    // ticket.printStrike();
                // }
                
                ticket.noPlayStrike();
                ticket.noPlayPowerball();
                lottoDraw(ticket,draw);
                System.out.println("");
                checkTicket(ticket,draw);
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
        draw.drawBonusball();
        ArrayList<Integer> lottoMatch = draw.returnLotto();
        ArrayList<Integer> strikeMatch = draw.returnStrike();
        System.out.println("\nThis week's lotto draw is...");
        for (int k = 0; k <= 5; k++) {
                System.out.print(lottoMatch.get(k) + "\t");
            }
        System.out.println("\nThis week's strike draw is...");
        for (int k = 0; k <= 3; k++) {
                System.out.print(strikeMatch.get(k) + "\t");
            }
        System.out.println("\nThis week's powerball draw is...\n" +
            draw.returnPowerball());
        System.out.println("\nThis week's bonus ball draw is...\n" +
            draw.returnBonusball());
    }
    public static void checkTicket (Ticket ticket, Draw draw){
        ArrayList<ArrayList<Boolean>> ticketMatch = new ArrayList<>();
        ArrayList<ArrayList<Boolean>> strikeMatch = new ArrayList<>();
        ArrayList<Boolean> matchCheck = new ArrayList<Boolean>();
        ArrayList<Boolean> strikeMatchCheck = new ArrayList<Boolean>();
        ArrayList<Boolean> powerballMatchCheck = new ArrayList<Boolean>();
        ArrayList<Integer> lottoDraw = draw.returnLotto();
        ArrayList<Integer> strikeDraw = draw.returnStrike();
        ArrayList<ArrayList<Integer>> strike = ticket.returnStrike();
        ArrayList<ArrayList<Integer>> lotto = ticket.returnTicket();
        boolean bonusball = false;
        for (int i = 0; i < lotto.size(); i++) {
            for (int c = 0; c < lotto.get(i).size(); c++ ) {
                if (lotto.get(i).get(c).equals(lottoDraw.get(c))) {
                    matchCheck.add(true);
                }
                else {
                    matchCheck.add(false);
                }
            }
            ticketMatch.add(new ArrayList(matchCheck));
            matchCheck.clear();    
        }
        for (int i = 0; i < strike.size(); i++) {
            for (int c = 0; c < strike.get(i).size(); c++ ) {
                if (strike.get(i).get(c).equals(strikeDraw.get(c))) {
                    strikeMatchCheck.add(true);
                }
                else {
                    strikeMatchCheck.add(false);
                }
            }
            strikeMatch.add(new ArrayList(strikeMatchCheck));
            strikeMatchCheck.clear();    
        }
        System.out.println("");
        for (int i = 0; i < ticketMatch.size(); i++) {
            for (int c = 0; c < ticketMatch.get(i).size(); c++ ) {
                System.out.print(ticketMatch.get(i).get(c) + "\t");
            }
            System.out.println("");
        }
        for (int i = 0; i < strikeMatch.size(); i++) {
            for (int c = 0; c < strikeMatch.get(i).size(); c++ ) {
                System.out.print(strikeMatch.get(i).get(c) + "\t");
            }
            System.out.println("");
        }
        
        for (int i = 0; i < lotto.size(); i++) {
            int matchNum = Collections.frequency(ticketMatch.get(i), true);
            if (ticketMatch.get(i).contains(draw.returnBonusball())) {
                bonusball = true;
            }
            if (matchNum == 3) {
                System.out.println("Line "+(i+1)+" wins Division 7");
            }
            else if (matchNum == 3 && bonusball) {
                System.out.println("Line "+(i+1)+" wins Division 6");
            }
            else if (matchNum == 4) {
                System.out.println("Line "+(i+1)+" wins Division 5");
            }
            else if (matchNum == 4 && bonusball) {
                System.out.println("Line "+(i+1)+" wins Division 4");
            }
            else if (matchNum == 5) {
                System.out.println("Line "+(i+1)+" wins Division 3");
            }
            else if (matchNum == 5 && bonusball) {
                System.out.println("Line "+(i+1)+" wins Division 2");
            }
            else if (matchNum == 6) {
                System.out.println("Line "+(i+1)+" wins Division 1");
            }
        }
    }
    public static void special(Ticket ticket, Draw draw) {
        while (running) {
            System.out.println("What would you like to simulate?\nA.Play until Strike 4!\nB.Play until Division 1 Powerball\nC.Favourite line vs. random line!");
            String choice = scanner.nextLine();
            choice = choice.substring(0,1).toUpperCase() + choice.substring(1).toLowerCase();
            // Repeat strike line until strike 4, record results
            if (choice.equals("A")){
            }
            // lotto repeat until division 1 and powerball win, record results
            else if (choice.equals("B")){
            }
            //favourites menu - set up favorites, favourites vs rand
            else if (choice.equals("C")){
            }
        }
    }
   
}
