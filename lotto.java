// import java.util.ArrayList;
// import java.util.Scanner;
// /**
 // * Write a description of class lotto here.
 // *
 // * @author (your name)
 // * @version (a version number or a date)
 // */
public class lotto
{
    // static Scanner scanner = new Scanner(System.in);
    // public static void main (String[]args) {
            
            
        // Ticket ticket = new Ticket();
        
        // Draw draw = new Draw();
        // System.out.println("\nWelcome to Lotto! \nWould you like to:\nChoose your lines\nPlay with dips\nSpecial game!");
        // String choice = scanner.nextLine();
        // choice = choice.substring(0,1).toUpperCase() + choice.substring(1).toLowerCase();
        // if (choice.equals("Choose")){
            // chooseLine(ticket, draw);
        // }
        // else if (choice.equals("Dips")) {
            // dips(ticket, draw);
        // }
        // else if (choice.equals("Special")) {
            // special(ticket, draw);
        // }
        
    // }
    // public static void chooseLine(Ticket ticket, Draw draw) {
        // ticket.randTicket();
        
    // }
    // public static void dips(Ticket ticket, Draw draw) {
        // System.out.println("What would you like to choose?\nLucky Dip - Just Lotto\nPower Dip - Lotto and Powerball\nTriple Dip - Lotto, Powerball and Strike");
        // String dipChoice = scanner.nextLine();
        // dipChoice = dipChoice.substring(0,1).toUpperCase() + dipChoice.substring(1).toLowerCase();
        // System.out.println(dipChoice);
        // if (dipChoice.equals("Luckydip")){  
            // System.out.println("Which Lucky Dip would you like to choose?\nA | $5.60 - 8 lotto lines\nB | $7 - 10 lotto lines\nC | $10.50 - 15 lotto lines\nD | $14 - 20 lotto lines");
            // String dipChoiceA = scanner.nextLine();
            // if (dipChoiceA.equals("A")){
                // ticket.setLineNum(8);
                // ticket.randTicket();
                
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
        // // lucky dip - just lotto
        // /* 
         // *$5.60 8 lotto lines
         // *$7 10 lotto lines
         // *$10.50 15 lotto lines
         // *$14 20 lotto lines
         // */
        // // power dip - lotto + powerball
        // /*
         // * $12 8 lotto, 8 powerball
         // * $15 10 lotto, 10 powerball
         // * $18 12 lotto, 12 powerball
         // * $24 16 lotto, 16 powerball
         // */
        // // triple dip - lotto + powerball + strike 
        // /*
         // * $16 10 lotto, 10 powerball, 1 strike
         // * $18 10 lotto, 10 powerball, 3 strike
         // * $20 12 lotto, 12 powerball, 2 strike 
         // * $25 16 lotto, 16 powerball, 1 strike
         // * $28 18 lotto, 18 powerball, 1 strike 
         // */
    // }
    // public static void special(Ticket ticket, Draw draw) {
        // // Repeat strike line until strike 4, record results
        
        // // lotto repeat until division 1 and powerball win, record results
        
        // //favourites menu - set up favorites, favourites vs rand

    // }
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
