import java.util.ArrayList;
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test
{   
    /**
     * Generates a random value
     */
    public static int randInt(){
        int randNum = (int) (Math.random() * (40 - 1) );
        return randNum;
    }
    
    public static void array (){
        int lottoNum = 6;
        int linenum = 4;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(lottoNum);
        for(int i=0; i < lottoNum; i++) {
            graph.add(new ArrayList(linenum)); //put linenum in brackets
        }  
        for (int i = 0; i < linenum; i ++) {
            for (int b = 0; b < lottoNum; b++) {
                int num = randInt();
                graph.get(b).add(num);
            }    
        }
        for (int c = 0; c < linenum; c++) {
            System.out.println("");
            for (int k = 0; k < lottoNum; k++) {
                System.out.print((graph.get(k)).get(c) + "\t");
            }
        }
    }
}
