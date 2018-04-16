import java.io.*;
import java.util.*;  

public class GenerateTest {

	private static final String OUTPUT = "tests/test3.in";
	private static final int LINES = 100;
	private static final int MAX_EDGES = 50;
	
	void filePrint() throws FileNotFoundException {
             File file = new File(OUTPUT);
             PrintWriter pw = new PrintWriter(file);
			 Random rand = new Random();

             for (int i = 0; i < LINES; i++) {
                pw.println("AV " + i);
             }

			 for (int i=0;i<MAX_EDGES;i++){
				 int edge1 = rand.nextInt(LINES);
				 int edge2 = rand.nextInt(LINES);
				 while(edge1 == edge2){
					 edge2 = rand.nextInt(LINES);
				 }
				 pw.println("AE "+edge1 + " " + edge2);
			 }
			 
			 
             pw.close();
      }
	
	public static void main(String[] args) throws FileNotFoundException{
		new GenerateTest().filePrint();

	}
	


}