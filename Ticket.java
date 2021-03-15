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
    private int numLimit = 5;
    private int lineNum = 3;
    private int strikeNum = 0;
    private int randNum = 0;
    private int pick;
    private boolean playStrike = false;
    private boolean playPowerball = false;
    private boolean running = true;
    ArrayList<ArrayList<Integer>> lotto = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> strike = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> line = new ArrayList<Integer>();
    ArrayList<Integer> powerball = new ArrayList<Integer>();
    private Scanner scanner = new Scanner(System.in);
    /**
     * Constructor for objects of class ticket
     */
    public Ticket() {
    }
    /**
     * Generates a random value
     */
    public int randInt(int max){
        randNum = (int) (Math.random() * max + MIN);
        return randNum;
    }
    
    public void scrub(){
        lotto.clear();
        strike.clear();
        powerball.clear();  
    }
    /**
     * Changes ticket size from 6 slots to 4 (Strike)
     */
    public void strikeTicket(){
        numLimit = 3;
    }
    
    /**
     * Changes ticket size from 4 slots to 6 (Lotto)
     */
    public void lottoTicket(){
        numLimit = 5;
    }
    /**
     * Changes the number of lines
     */
    public void setLineNum(int lnNum){
        lineNum = lnNum;
    }
    public void setStrikeNum(int lnNum){
        strikeNum = lnNum;
    }
    
    public void playStrike(){
        playStrike = true;
    }
    
    public void noPlayStrike(){
        playStrike = false;
    }
    
    public boolean checkStrike(){
        return playStrike;
    }
    
    public void playPowerball(){
        playPowerball = true;
    }
    
    public void noPlayPowerball(){
        playPowerball = false;
    }
    
    public boolean checkPowerball(){
        return playPowerball;
    }
    /**
     * Creates a ticket list 
     */
    public void randLine(){
        while (line.size() <= numLimit) {
            int randnum = randInt(40);
            line.add(randnum);
            checkDupe(randnum);
        }
    }  
    /**
     * Creates random powerball numbers
     * kinda unneccesary
     */
    public void randPowerball() {
        while (powerball.size() <= lineNum) {
            int randnum = randInt(10);
            powerball.add(randnum);
        }
    }  
    public void printLotto(){
        for (int i = 0; i < lotto.size(); i++) {
            for (int c = 0; c < lotto.get(i).size(); c++ ) {
                System.out.print(lotto.get(i).get(c) + "\t");
            }
            System.out.println("");
        }
        }
    public void printPowerball(){    
        for (int k = 0; k < lineNum; k++) {
                if (! powerball.get(k).equals(-1) ){
                    System.out.print(powerball.get(k) + "\t");
                }
                
                else if ( powerball.get(k).equals(-1) ){
                    System.out.print("" + "\t");
                }
            }
            
    }
    public void printStrike() { 
        for (int i = 0; i < strike.size(); i++) {
            for (int c = 0; c < strike.get(i).size(); c++ ) {
                System.out.print(strike.get(i).get(c) + "\t");
            }
            System.out.println("");
        }
    }
    
    /**
     * Adds line to 2D array
     */
    public void addLine() {
        lotto.add(new ArrayList<Integer>(line));
    }
    
    /**
     * Creates a single line
     */
    public void createLine() {
        while (line.size() <= numLimit) {
            System.out.println("What number would you like to pick between 1-40?");
            pick = Integer.valueOf(scanner.nextLine());
            checkNum(line, 40);
            checkDupe(pick);
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
    public boolean checkNum(ArrayList list, int max) {
        if (pick >= MIN && pick <= max) {
            list.add(pick);
            return false;
        }
        else {
            System.out.println("Please pick a number between 0-"+max+"");
            return true;
        }
    }
    
    public void checkDupe(int num){
        if (Collections.frequency(line, num) > 1) {
            System.out.println("That number is already in the line");
            line.remove(line.size()-1);
        } 
    }
    /**
     * Returns the lotto Array
     */
    public ArrayList returnTicket(){
        return lotto;
    }
    
    /**
     * Returns the powerball Array
     */
    public ArrayList returnPowerball(){
        return powerball;
    }
    
    /**
     * Returns the strike Array
     */
    public ArrayList returnStrike(){
        return strike;
    }
    /**
     * Returns the lotto line num
     */
    public int returnLineNum(){
        return lineNum;
    }
    /**
     * Returns the strike line num
     */
    public int returnStrikeNum(){
        return strikeNum;
    }
    
    /**
     * Returns the number limit
     */
    public int returnNumLimit   (){
        return numLimit;
    }
    public void powerball() { //check if poewrball can be 0
        running = true;
        while (running) {
            System.out.println("What number would you like to pick between 1-10?");
            pick = Integer.valueOf(scanner.nextLine());
            running = checkNum(powerball,10); 
        }
    }
    
    public void noPowerball() {
        powerball.add(-1);
    }
    
    public void addStrike() {
        strike.add(new ArrayList<Integer>(line));
    }
    
}
