import java.io.*;
import java.util.*;


/**
 * Adjacency matrix implementation for the FriendshipGraph interface.
 * 
 * Your task is to complete the implementation of this class.  You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2016.
 */
public class AdjMatrix <T extends Object> implements FriendshipGraph<T>
{

	protected final ArrayList<T> adjMatrixVertex;// = new ArrayList<T>();
	protected final ArrayList<ArrayList<Integer>> adjMatrixGraph;// = new ArrayList<ArrayList<Integer>>();
	/**
	 * Contructs empty graph.
	 */
    public AdjMatrix() {
		adjMatrixVertex = new ArrayList<T>();
		adjMatrixGraph = new ArrayList<ArrayList<Integer>>();
    	// Implement me!
    } // end of AdjMatrix()
    
    
    public void addVertex(T vertLabel) {
		ArrayList<Integer> tempArrayList = new ArrayList<Integer>();

		for(int i=0;i<adjMatrixVertex.size();i++){
			tempArrayList.add(0);
		}
		adjMatrixGraph.add(tempArrayList);		
		
		adjMatrixVertex.add(vertLabel);

		for(int i=0; i<adjMatrixGraph.size();i++){
			adjMatrixGraph.get(i).add(0);
		}
/* 		for(int i=0; i<adjMatrixGraph.size();i++){
			for(int j=0; j<adjMatrixGraph.get(i).size();j++){
				System.out.print(adjMatrixGraph.get(i).get(j));
			}
			System.out.print("\n");
		} */
        // Implement me!
    } // end of addVertex()
	
    
    public void addEdge(T srcLabel, T tarLabel) {
		int src = 0;
		int tar = 0;
		
		for(int i=0; i<adjMatrixVertex.size(); i++){
			if(adjMatrixVertex.get(i).equals(srcLabel)){
				src=i;
			}
			if(adjMatrixVertex.get(i).equals(tarLabel)){
				tar=i;
			}
		}
		System.out.printf("s=%d t=%d\n",src,tar);
		adjMatrixGraph.get(tar).set(src,1);
		adjMatrixGraph.get(src).set(tar,1);
		
/* 		for(int i=0; i<adjMatrixGraph.size();i++){
			for(int j=0; j<adjMatrixGraph.get(i).size();j++){
				System.out.print(adjMatrixGraph.get(i).get(j));
			}
			System.out.print("\n");
		} */
        // Implement me!
    } // end of addEdge()
	

    public ArrayList<T> neighbours(T vertLabel) {
        ArrayList<T> neighbours = new ArrayList<T>();
		
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
        // Implement me!
        
        return neighbours;
    } // end of neighbours()
    
    
    public void removeVertex(T vertLabel) {
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
        // Implement me!
    } // end of removeVertex()
	
    
    public void removeEdge(T srcLabel, T tarLabel) {
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
        // Implement me!
    } // end of removeEdges()
	
    
    public void printVertices(PrintWriter os) {
		
		for(int i=0;i<adjMatrixVertex.size();i++){
			//System.out.print(" "+adjMatrixVertex.get(i));
			os.print(adjMatrixVertex.get(i) + " ");
			/* os.flush(); */
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
		
		ArrayList<Integer> visited= new ArrayList<Integer>();
		Queue<T> vertexQueue= new LinkedList<T>();
		Queue<Integer> distanceQueue= new LinkedList<Integer>();
		
		T vertex;
		int distance;
		
		for(int i=0;i<adjMatrixVertex.size();i++){
			visited.add(0);
		}
		vertexQueue.add(vertLabel1);
		distanceQueue.add(0);
		
/* 		while(vertexQueue.peek() != null){
			vertex=vertexQueue.remove();
			distance=distanceQueue.remove();
			
			if(vertex.equals(vertLabel2)){
				return distance;
			}
			for(int i=0;i<adjMatrixVertex.size();i++){
				if(adjMatrixVertex.get(i).equals(vertex)){
					visited.set(i,1);
					if(visited.get(i)==1){
						vertexQueue.add(adjMatrixVertex.get(i));
						distanceQueue.add(distance+1);
					}
				}
			}
		} */

		
		
        return disconnectedDist;    
		
    } // end of shortestPathDistance()
    
} // end of class AdjMatrix