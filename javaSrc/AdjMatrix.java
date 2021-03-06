import java.io.*;
import java.util.*;
import java.lang.Math.*;


/**
 * Adjacency matrix implementation for the FriendshipGraph interface.
 * 
 * Your task is to complete the implementation of this class.  You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2016.
 */
public class AdjMatrix <T extends Object> implements FriendshipGraph<T>
{
	//private static final String OUTPUT = "timingAdjmat.out";
	protected final ArrayList<T> adjMatrixVertex;// = new ArrayList<T>();
	protected final ArrayList<ArrayList<Integer>> adjMatrixGraph;// = new ArrayList<ArrayList<Integer>>();
	public int totalEdges = 0;
	public long systemStartTime = System.nanoTime();

	/**
	 * Contructs empty graph.
	 */
    public AdjMatrix() {
		adjMatrixVertex = new ArrayList<T>();
		adjMatrixGraph = new ArrayList<ArrayList<Integer>>();
    	// Implement me!
    } // end of AdjMatrix()
    
    public void printGraph(){
		for(int i=0;i<adjMatrixVertex.size();i++){
			for(int j=0;j<adjMatrixVertex.size();j++){
				System.out.print(adjMatrixGraph.get(i).get(j));
			
			}
			System.out.println();
		}
			System.out.println();
	}
	
    public void addVertex(T vertLabel){
		
		ArrayList<Integer> tempArrayList = new ArrayList<Integer>();
		long addVertexStart = System.nanoTime();
		for(int i=0;i<adjMatrixVertex.size();i++){
			tempArrayList.add(0);
		}
		adjMatrixGraph.add(tempArrayList);		
		
		adjMatrixVertex.add(vertLabel);

		for(int i=0; i<adjMatrixGraph.size();i++){
			adjMatrixGraph.get(i).add(0);
		}
		long addVertexTime = System.nanoTime();
		double totalVertexTime = ((double) (addVertexTime-addVertexStart))/ Math.pow(10,9);
/* 		System.out.print("Vertices "+adjMatrixVertex.size()+" Edges "+totalEdges);
		System.out.println(" -Time taken:" + totalVertexTime); */
		//System.out.println(totalVertexTime);
		
        // Implement me!
    } // end of addVertex()
	
    
    public void addEdge(T srcLabel, T tarLabel) {
		long addEdgeStart = System.nanoTime();
		int src = 0;
		int tar = 0;
		totalEdges++;
		for(int i=0; i<adjMatrixVertex.size(); i++){
			if(adjMatrixVertex.get(i).equals(srcLabel)){
				src=i;
			}
			if(adjMatrixVertex.get(i).equals(tarLabel)){
				tar=i;
			}
		}
		/* System.out.printf("s=%d t=%d\n",src,tar); */
		adjMatrixGraph.get(tar).set(src,1);
		adjMatrixGraph.get(src).set(tar,1);
		
		long addEdgeTime = System.nanoTime();
		double totalEdgeTime = ((double) (addEdgeTime-addEdgeStart))/ Math.pow(10,9);
/* 		System.out.print("Vertices "+adjMatrixVertex.size()+" Edges "+totalEdges);
		System.out.println(" -Time taken:" + totalEdgeTime); */
		//System.out.println(totalEdgeTime);
        // Implement me!
    } // end of addEdge()
	

    public ArrayList<T> neighbours(T vertLabel) {
        ArrayList<T> neighbours = new ArrayList<T>();

		long findNeighbourStart = System.nanoTime();
		//find label index
        for(int i=0;i<adjMatrixVertex.size();i++){
			//using the index look for neighbours in graph
			if (adjMatrixVertex.get(i).equals(vertLabel)){
				for(int j=0;j<adjMatrixGraph.get(i).size();j++){
					if(adjMatrixGraph.get(i).get(j).equals(1)){
						neighbours.add(adjMatrixVertex.get(j));
					}
				}
			}
		}
		
		double findNeightbourEnd = System.nanoTime();
		double totalNeighbourTime = ((double) (findNeightbourEnd-findNeighbourStart))/ Math.pow(10,9);
		//System.out.println(totalNeighbourTime);
        // Implement me!
        
        return neighbours;
    } // end of neighbours()
    
    
    public void removeVertex(T vertLabel) {
		long removeVertexStart = System.nanoTime();
		int index=0;
		for(int i=0;i<adjMatrixVertex.size();i++){
			if(adjMatrixVertex.get(i).equals(vertLabel)){
				index=i;
				break;
			}
		}
		adjMatrixVertex.remove(index);
		for(int j=0;j<adjMatrixGraph.size();j++){
			adjMatrixGraph.get(j).remove(index);
		}
		adjMatrixGraph.remove(index);
		long removeVertexEnd=System.nanoTime();
		double totalRemoveVertexTime=((double)(removeVertexEnd-removeVertexStart))/Math.pow(10,9);
/* 		System.out.print("vertices "+adjMatrixVertex.size()+" edges "+totalEdges);
		System.out.println(" - totalRemoveVertexTime "+totalRemoveVertexTime); */
		//System.out.println(totalRemoveVertexTime);
        // Implement me!
    } // end of removeVertex()
	
    
    public void removeEdge(T srcLabel, T tarLabel) {
		long removeEdgeStart = System.nanoTime();
		totalEdges--;
		int src=0;
		int tar=0;
		for(int i=0;i<adjMatrixVertex.size();i++){
			if(adjMatrixVertex.get(i).equals(srcLabel)){
				src=i;
			}
			if(adjMatrixVertex.get(i).equals(tarLabel)){
				tar=i;
			}
		}
		adjMatrixGraph.get(tar).set(src,0);
		adjMatrixGraph.get(src).set(tar,0);
		long removeEdgeEnd=System.nanoTime();
		double totalRemoveEdgeTime=((double)(removeEdgeEnd-removeEdgeStart))/Math.pow(10,9);
/* 		System.out.print("vertices "+adjMatrixVertex.size()+" edges "+totalEdges);
		System.out.println("totalRemoveEdgeTime:" + totalRemoveEdgeTime); */
		System.out.println(totalRemoveEdgeTime);
        // Implement me!
    } // end of removeEdges()
	
    
    public void printVertices(PrintWriter os) {
		
		for(int i=0;i<adjMatrixVertex.size();i++){
			//System.out.print(" "+adjMatrixVertex.get(i));
			os.print(adjMatrixVertex.get(i) + " ");
			os.flush();
		}

        // Implement me!
    } // end of printVertices()
	
    
    public void printEdges(PrintWriter os) {
		for(int i=0;i<adjMatrixGraph.size();i++){
			for(int j=0;j<adjMatrixGraph.get(i).size();j++){
				if(adjMatrixGraph.get(i).get(j).equals(1)){
					os.println(adjMatrixVertex.get(i) + " " + adjMatrixVertex.get(j));
				}
			}
		}
        // Implement me!
    } // end of printEdges()
    
    
    public int shortestPathDistance(T vertLabel1, T vertLabel2) {
		// Implement me!
		long shortestPathDistanceStart=System.nanoTime();
		boolean[] marked = new boolean[adjMatrixVertex.size()];
		Queue<T> vertexQueue = new LinkedList<T>();
		Queue<Integer> distanceQueue = new LinkedList<Integer>();
		T vertex;
		int distance;
		
		for(int i = 0; i < adjMatrixVertex.size(); i++){
			marked[i] = false;
		}

		vertexQueue.add(vertLabel1);
		distanceQueue.add(0);

		while(vertexQueue.peek() != null){
			vertex = vertexQueue.remove();
			distance = distanceQueue.remove();

			if(vertex.equals(vertLabel2)){
				long shortestPathDistanceEnd=System.nanoTime();
				double totalShortestTime=((double)(shortestPathDistanceEnd-shortestPathDistanceStart))/Math.pow(10,9);
				//System.out.println(totalShortestTime);
				
				return distance;
			}
			
			marked[adjMatrixVertex.indexOf(vertex)] = true;

			for(int i = 0; i < adjMatrixVertex.size(); i++){
				if(adjMatrixGraph.get(returnIndex(vertex)).get(i)==1){
					if(!marked[i]){		
						vertexQueue.add(adjMatrixVertex.get(i));
						distanceQueue.add(distance + 1);
					}			
				}
			}
		}	
		
    // if we reach this point, source and target are disconnected
					long shortestPathDistanceEnd=System.nanoTime();
				double totalShortestTime=((double)(shortestPathDistanceEnd-shortestPathDistanceStart))/Math.pow(10,9);
				//System.out.println(totalShortestTime);
        return disconnectedDist;    	
		
    } // end of shortestPathDistance()
	public int returnIndex(T vertex){
		int index;
		for (int i=0;i<adjMatrixVertex.size();i++){
			if (vertex.equals(adjMatrixVertex.get(i))){
				return i;
			}
		}
		return 0;
	}
//	pw.close();
} // end of class AdjMatrix