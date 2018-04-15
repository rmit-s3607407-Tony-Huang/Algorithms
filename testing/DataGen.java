import java.io.*;
import java.util.*;  

public class DataGen {

	private static final String FILENAME = "facebook_combined.txt";
	private static final String OUTNAME = "tests/data.in";
	private static final int LINES = 88234;
	private static final int MAX_EDGES = 200;
	private static final double THRESHOLD = 0.1;
	private static final int NOOFNEIGHBOURS = 100;
	private static final int NOOFSHORTESTPATH = 100;
	private static final int scenario = 3;


	public static void main(String[] args) 
	{

		BufferedReader br = null;
		FileReader fr = null;

		try {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;
			Set<String> vertSet = new HashSet<String>();
			Set<String> edgeList = new HashSet<String>();
			List<Integer> lineNumbers = new ArrayList<Integer>();
			Random rng = new Random();

			int lineNum = 0;

			while (lineNumbers.size() < MAX_EDGES) {
				lineNumbers.add(rng.nextInt(LINES));
			}

			System.out.println(lineNumbers);


			while ((sCurrentLine = br.readLine()) != null) 
			{
				if (!lineNumbers.contains(lineNum++)) continue;
				// System.out.println(sCurrentLine);
				String[] splitted = sCurrentLine.split(" ");
				vertSet.add(splitted[0]);
				vertSet.add(splitted[1]);
				edgeList.add(sCurrentLine);

        		//readFile1(FILENAME, OUTNAME);

				

			}

			String[] vertArray = vertSet.toArray(new String[vertSet.size()]);
			float density = 0;
			while (density < THRESHOLD) {
				String v1 = vertArray[rng.nextInt(vertArray.length)];
				String v2 = vertArray[rng.nextInt(vertArray.length)];

				if (Integer.parseInt(v2) < Integer.parseInt(v1)) {
					String c = v2;
					v2 = v1;
					v1 = c;
				}

				edgeList.add(v1 + " " + v2);
				
				density = (float)edgeList.size()/(vertSet.size()*vertSet.size());
			}

			//System.out.println(vertSet) ;

			for(String vs : vertSet)
			{
				System.out.println("AV " + vs);
				System.out.println("AV " + vs);


			}

			for(String es : edgeList	)
			{
				System.out.println("AE " + es);
			}

			System.out.println(edgeList.size());

			System.out.println(vertSet.size());

			for(int i = 0; i < NOOFNEIGHBOURS; i++){
				System.out.println("N " + vertArray[rng.nextInt(vertArray.length)]);
			}
			
			System.out.println(density);


			try
	     	{
				PrintWriter outputStream = new PrintWriter(OUTNAME);

	    
        		for(String vs : vertSet)
				{
	        		outputStream.println("AV " + vs);
				}

				for(String es : edgeList	)
				{
	        		outputStream.println("AE " + es);
				}

				if(scenario == 2){
					for(int i = 0; i < NOOFNEIGHBOURS; i++){
						outputStream.println("N " + vertArray[rng.nextInt(vertArray.length)]);
					}

					for(int i = 0; i < NOOFSHORTESTPATH; i++){
						String v3 = vertArray[rng.nextInt(vertArray.length)];
						String v4 = vertArray[rng.nextInt(vertArray.length)];

						outputStream.println("S " + v3 + " " + v4);

					}
				}

				if(scenario == 3){
					for(String es : edgeList	)
					{
		        		outputStream.println("RE " + es);
					}
				}
				if(scenario == 4){
	        		for(String vs : vertSet)
					{
		        		outputStream.println("RV " + vs);
					}
				}
				

				outputStream.close();
			} 
			catch (IOException e) 
			{
	    		e.printStackTrace();
			}


		} 
		catch (IOException e) 
		{

			e.printStackTrace();

		} 
		finally 
		{
			try 
			{

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} 
			catch (IOException ex) 
			{

				ex.printStackTrace();

			}

		}

	}



private static void readFile1(String in, String out) throws IOException
{
    FileInputStream fis = new FileInputStream(new File(in));

    BufferedReader br = new BufferedReader(new InputStreamReader(fis));

    BufferedWriter writer = null;

    writer = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream(out), "utf-8"));

    String line = null;
    while ((line = br.readLine()) != null)
    {
        if(line.length() > 0)
        {
            String[] words = line.split("\\s+");
            //System.out.println(words[words.length - 1]);
            writer.write(words[0]);
            writer.newLine();
        }          
    }

    br.close();
    writer.close();
    fis.close();
}

}