import java.io.*;
import java.util.*;  

public class GenerateTest {

	private static final String OUTPUT = "tests/test3.in";
	private static final int LINES = 100;
	private static final int MAX_EDGES = 1000;
	private static final int NO_NEIGHBOURS = 50;
	private int edge1;
	private int edge2;
	
	void filePrint() throws FileNotFoundException {
             File file = new File(OUTPUT);
             PrintWriter pw = new PrintWriter(file);
			 Random rand = new Random();
			 
			 int[][] edges = new int[2][MAX_EDGES];

             for (int i = 0; i < LINES; i++) {
                pw.println("AV " + i);
             }

			 for (int i=0;i<MAX_EDGES;i++){
				 edge1 = rand.nextInt(LINES);
				 edge2 = rand.nextInt(LINES);
				 while(edge1 == edge2){
					 edge2 = rand.nextInt(LINES);
				 }
				 edges[0][i]=edge1;
				 edges[1][i]=edge2;
				 pw.println("AE "+edge1 + " " + edge2);
			 }
			for (int i = NO_NEIGHBOURS; i > 0 ; i--) {
				
                //pw.println("RE " + +edges[0][i] + " " + edges[1][i]);
				pw.println("N " +rand.nextInt(LINES));
				pw.println("S " +rand.nextInt(LINES) + " "+rand.nextInt(LINES));
				
             }
			 
             pw.close();
      }
	
	public static void main(String[] args) throws FileNotFoundException{
		new GenerateTest().filePrint();

	}
	


}