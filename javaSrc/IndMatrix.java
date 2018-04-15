import java.io.*;
import java.util.*;


/**
 * Incidence matrix implementation for the FriendshipGraph interface.
 * 
 * Your task is to complete the implementation of this class.  You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2016.
 */
public class IndMatrix <T extends Object> implements FriendshipGraph<T>
{

	protected final ArrayList<ArrayList<Integer>> indMatrixGraph;
	protected final ArrayList<T> indMatrixVertex;
	protected final ArrayList<ArrayList<T>> indMatrixEdge;
	
	/**
	 * Contructs empty graph.
	 */
    public IndMatrix() {
    	
		indMatrixGraph = new ArrayList<ArrayList<Integer>>();
		indMatrixVertex = new ArrayList<T>();
		indMatrixEdge = new ArrayList<ArrayList<T>>();
		// Implement me!
    } // end of IndMatrix()
    
	public void printGraph(){
		for(int i=0;i<indMatrixVertex.size();i++){
			for(int j=0;j<indMatrixEdge.size();j++){
				System.out.print(indMatrixGraph.get(i).get(j));
			
			}
			System.out.println();
		}
			System.out.println();
	}
    
    public void addVertex(T vertLabel) {
        
		ArrayList<Integer> tempArrayList = new ArrayList<Integer>();

		if(indMatrixEdge.size() > 0){
			for(int i = 0; i < indMatrixEdge.size(); i++){
				tempArrayList.add(0);
			}
			indMatrixGraph.add(tempArrayList);
		}	
		
		indMatrixVertex.add(vertLabel);
		printGraph();

/*		for(int i = 0; i < indMatrixGraph.size();i++){
			for(int j = 0; j < indMatrixGraph.get(i).size();j++){
				System.out.print(indMatrixGraph.get(i).get(j));
			}
			System.out.print("\n");
		}*/
		// Implement me!
    } // end of addVertex()
	
    
    public void addEdge(T srcLabel, T tarLabel) {
        int src = 0;
		int tar = 0;
		ArrayList<T> tempList = new ArrayList<T>();
		tempList.add(srcLabel);
		tempList.add(tarLabel);
		indMatrixEdge.add(tempList);
		
		for(int i = 0; i < indMatrixGraph.size(); i++){
			if(indMatrixVertex.get(i).equals(srcLabel)){
				src = i;
				
			}
			if(indMatrixVertex.get(i).equals(tarLabel)){
				tar = i;
			}
		}
		
		for(int i = 0; i < indMatrixGraph.size(); i++){
			if(i == src || i == tar){
				indMatrixGraph.get(i).add(1);
			}
			else{
				indMatrixGraph.get(i).add(0);
			}
		}
		
		
		
		printGraph();
		
/*		for(int i=0; i<indMatrixGraph.size();i++){
			for(int j=0; j<indMatrixGraph.get(i).size();j++){
				System.out.print(indMatrixGraph.get(i).get(j));
			}
			System.out.print("\n");
		}
		
		for(int i = 0; i < indMatrixEdge.size(); i++){
			System.out.print(indMatrixEdge.get(i));
			System.out.printf("%d", i);
		}*/
		
		// Implement me!
    } // end of addEdge()
	

    public ArrayList<T> neighbours(T vertLabel) {
        ArrayList<T> neighbours = new ArrayList<T>();

		for (int i = 0; i < indMatrixGraph.size(); i++){
			if (indMatrixVertex.get(i).equals(vertLabel)){
				for (int j = 0; j < indMatrixGraph.get(i).size(); j++){
					if(indMatrixGraph.get(i).get(j) == 1){
						if(indMatrixVertex.get(i).equals(indMatrixEdge.get(j).get(0))){
							
							neighbours.add(indMatrixEdge.get(j).get(1));
						}
						else{
							neighbours.add(indMatrixEdge.get(j).get(0));
						}
					}
				}
				
			}
		}
		
/*		for (int i = 0; i < neighbours.size(); i++){
			System.out.print(neighbours.get(i));
		}*/
        // Implement me!
        
        return neighbours;
    } // end of neighbours()
    
    public void removeVertex(T vertLabel) {
        int line = 0;
		
		for (int i = 0; i < indMatrixVertex.size(); i++){
			if (indMatrixVertex.get(i).equals(vertLabel)){
				line = i;
				break;
			}
		}
		
		for (int i = 0; i < indMatrixEdge.size(); i++){
			if (indMatrixEdge.get(i).get(0).equals(vertLabel) || indMatrixEdge.get(i).get(1).equals(vertLabel)){
				for (int j = 0; j < indMatrixGraph.size(); j++){
					indMatrixGraph.get(j).remove(i);
				}
				indMatrixEdge.remove(i);
			}
		}
		
/*		for (int i = 0; i < indMatrixEdge.size(); i++){
			for (int j = 0; j < indMatrixEdge.get(i).size(); j++){
				System.out.print(indMatrixEdge.get(i).get(j));
			}
			System.out.print("\n");
		}*/
		
		indMatrixGraph.remove(line);
		indMatrixVertex.remove(line);
		
/*		for(int i = 0; i < indMatrixVertex.size(); i++){
			System.out.print(indMatrixVertex.get(i));
		}
		
		for(int i=0; i<indMatrixGraph.size();i++){
			for(int j=0; j<indMatrixGraph.get(i).size();j++){
				System.out.print(indMatrixGraph.get(i).get(j));
			}
			System.out.print("\n");
		}*/
		// Implement me!
    } // end of removeVertex()
	
    
    public void removeEdge(T srcLabel, T tarLabel) {
		int line = 0;
		
		for (int i = 0; i < indMatrixEdge.size(); i++){
			if (indMatrixEdge.get(i).equals(srcLabel)){
				for (int j = 0; j < indMatrixEdge.get(i).size(); j++){
					if (indMatrixEdge.get(i).get(j).equals(tarLabel)){
						indMatrixEdge.remove(i);
						line = i;
					}
				}
			}
		}
		
		for (int i = 0; i < indMatrixGraph.size(); i++){
			indMatrixGraph.get(i).remove(line);
		}
		
/* 		for(int i=0; i<indMatrixGraph.size();i++){
			for(int j=0; j<indMatrixGraph.get(i).size();j++){
				System.out.print(indMatrixGraph.get(i).get(j));
			}
			System.out.print("\n");
		}*/
		
		// Implement me!
    } // end of removeEdges()
	
    
    public void printVertices(PrintWriter os) {
        
		for (int i = 0; i < indMatrixVertex.size(); i++){
			os.printf(indMatrixVertex.get(i) + " ");
			os.flush();
		}
		
		// Implement me!
    } // end of printVertices()
	
    
    public void printEdges(PrintWriter os) {
        
		for(int i = 0; i < indMatrixEdge.size(); i++){
			for (int j = 0; j < indMatrixEdge.get(i).size(); j++){
				os.println(indMatrixEdge.get(i).get(j));
			}
		}
		
		// Implement me!
    } // end of printEdges()
    
    
    public int shortestPathDistance(T vertLabel1, T vertLabel2) {
    	
		boolean[] marked = new boolean[indMatrixVertex.size()];
		Queue<T> vertexQueue = new LinkedList<T>();
		Queue<Integer> distanceQueue = new LinkedList<Integer>();
		int dist;
		T vert;
		T temp;
		
		for (int i = 0; i < indMatrixVertex.size(); i++){
			marked[i] = false;
		}
		
		vertexQueue.add(vertLabel1);
		distanceQueue.add(0);
		
		while(vertexQueue.peek() != null){
			vert = vertexQueue.remove();
			dist = distanceQueue.remove();
			
			if (vert.equals(vertLabel2)){
				// System.out.print(dist);
				return dist;
			}
			
			marked[indMatrixVertex.indexOf(vert)] = true;
			
			for(int i = 0; i < indMatrixEdge.size(); i++){
				for(int j = 0; j < indMatrixEdge.get(i).size(); j++){
					if(indMatrixEdge.get(i).get(j).equals(vert)){
						if(j == 0){
							if(!marked[indMatrixVertex.indexOf(indMatrixEdge.get(i).get(j+1))]){
								vertexQueue.add(indMatrixEdge.get(i).get(j+1));
								distanceQueue.add(dist + 1);
							}
						}
						else {
							if(!marked[indMatrixVertex.indexOf(indMatrixEdge.get(i).get(j-1))]){
								vertexQueue.add(indMatrixEdge.get(i).get(j-1));
								distanceQueue.add(dist + 1);
							}
						}
					}
				}
			}
		}
		
		
		// Implement me!
    	
        // if we reach this point, source and target are disconnected
        return disconnectedDist;    	
    } // end of shortestPathDistance()
    
} // end of class IndMatrix

