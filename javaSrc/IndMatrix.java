import java.io.*;
import java.util.*;
import java.lang.Math.*;


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
        long addVertexStart = System.nanoTime();
		ArrayList<Integer> tempArrayList = new ArrayList<Integer>();

		
		for(int i = 0; i < indMatrixEdge.size(); i++){
			tempArrayList.add(0);
		}
		indMatrixGraph.add(tempArrayList);
		
		indMatrixVertex.add(vertLabel);
		
/*		for(int i = 0; i < indMatrixGraph.size();i++){
			for(int j = 0; j < indMatrixGraph.get(i).size();j++){
				System.out.println(indMatrixGraph.get(i).get(j));
			}
			System.out.print("\n");
		}*/
		
		long addVertexEnd = System.nanoTime();
		double totalVertexTime = ((double) (addVertexEnd - addVertexStart))/Math.pow(10, 9);
		//System.out.println(totalVertexTime);
		// Implement me!
    } // end of addVertex()
	
    
    public void addEdge(T srcLabel, T tarLabel) {
		long addEdgeStart = System.nanoTime();
		ArrayList<T> tempList = new ArrayList<T>();
		
		indMatrixGraph.add(new ArrayList<Integer>());
		
		for(int i = 0; i < indMatrixVertex.size(); i++){
			if(indMatrixVertex.get(i).equals(srcLabel)){
				
				indMatrixGraph.get(i).add(1);
				tempList.add(srcLabel);
			}
			else if(indMatrixVertex.get(i).equals(tarLabel)){
				indMatrixGraph.get(i).add(1);
				tempList.add(tarLabel);
			}
			else{
				indMatrixGraph.get(i).add(0);
			}
		}
		
		
		indMatrixEdge.add(tempList);
		
/*		for(int i=0; i<indMatrixGraph.size();i++){
			for(int j=0; j<indMatrixGraph.get(i).size();j++){
				System.out.print(indMatrixGraph.get(i).get(j));
			}
			System.out.print("\n");
		}
		
		for(int i = 0; i < indMatrixEdge.size(); i++){
			for(int j = 0; j < indMatrixEdge.get(i).size(); j++){
				System.out.print(indMatrixEdge.get(i).get(j));
			}
			System.out.println();
		}*/
		
		long addEdgeEnd = System.nanoTime();
		double totalEdgeTime = ((double) (addEdgeEnd - addEdgeStart)) / Math.pow(10, 9);
		//System.out.println("Edge " + totalEdgeTime);
		
		// Implement me!
    } // end of addEdge()
	

    public ArrayList<T> neighbours(T vertLabel) {
		long findNeighbourStart = System.nanoTime();
        ArrayList<T> neighbours = new ArrayList<T>();

		for (int i = 0; i < indMatrixVertex.size(); i++){
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
		
		long findNeighbourEnd = System.nanoTime();
		double totalNeighbourTime = ((double) (findNeighbourEnd - findNeighbourStart)) / Math.pow(10, 9);
		// System.out.println(totalNeighbourTime);
        
        return neighbours;
    } // end of neighbours()
    
    public void removeVertex(T vertLabel) {
		
		long removeVertexStart = System.nanoTime();
        int line = 0;
		
		for (int i = 0; i < indMatrixVertex.size(); i++){
			if (indMatrixVertex.get(i).equals(vertLabel)){
				line = i;
				break;
			}
		}
		
		for (int i = 0; i < indMatrixEdge.size(); i++){
			if (indMatrixEdge.get(i).get(0).equals(vertLabel) || indMatrixEdge.get(i).get(1).equals(vertLabel)){
				for (int j = 0; j < indMatrixVertex.size(); j++){
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
		
		
		for(int i=0; i<indMatrixGraph.size();i++){
			for(int j=0; j<indMatrixGraph.get(i).size();j++){
				System.out.print(indMatrixGraph.get(i).get(j));
			}
			System.out.print("\n");
		}}*/
		
		long removeVertexEnd = System.nanoTime();
		double totalRemoveVertexTime = ((double) (removeVertexEnd - removeVertexStart)) / Math.pow(10, 9);
		//System.out.println(totalRemoveVertexTime);
		
		// Implement me!
    } // end of removeVertex()
	
    
    public void removeEdge(T srcLabel, T tarLabel) {
		long removeEdgeStart = System.nanoTime();
		int line = 0;
		
		for (int i = 0; i < indMatrixEdge.size(); i++){
			if (indMatrixEdge.get(i).equals(srcLabel)){
				for (int j = 0; j < indMatrixEdge.get(i).size(); j++){
					if (indMatrixEdge.get(i).get(j).equals(tarLabel)){
						
						line = i;
					}
				}
			}
		}
		
		indMatrixEdge.remove(line);
		
		for (int i = 0; i < indMatrixVertex.size(); i++){
			indMatrixGraph.get(i).remove(line);
		}
		
/*		for (int i = 0; i < indMatrixEdge.size(); i++){
			for (int j = 0; j < indMatrixEdge.get(i).size(); j++){
				System.out.print(indMatrixEdge.get(i).get(j));
			}
			System.out.print("\n");
		}
		
 		for(int i=0; i<indMatrixGraph.size();i++){
			for(int j=0; j<indMatrixGraph.get(i).size();j++){
				System.out.print(indMatrixGraph.get(i).get(j));
			}
			System.out.print("\n");
		}*/
		
		long removeEdgeEnd = System.nanoTime();
		double totalRemoveEdgeTime = ((double) (removeEdgeEnd - removeEdgeStart)) / Math.pow(10, 9);
		//System.out.println(totalRemoveEdgeTime);
		
		// Implement me!
    } // end of removeEdge()
	
    
    public void printVertices(PrintWriter os) {
        
		for (int i = 0; i < indMatrixVertex.size(); i++){
			os.printf(indMatrixVertex.get(i) + " ");
			os.flush();
		}
		
		// Implement me!
    } // end of printVertices()
	
    
    public void printEdges(PrintWriter os) {
        
		for(int i = 0; i < indMatrixEdge.size(); i++){
			for(int j = 0; j < indMatrixEdge.get(i).size(); j++){
				os.print(indMatrixEdge.get(i).get(j) +" ");
			}
			os.println();
		}
		
/*		for (int i = 0; i < indMatrixEdge.size(); i++){
			for (int j = 0; j < indMatrixEdge.get(i).size(); j++){
				System.out.print(indMatrixEdge.get(i).get(j));
			}
			System.out.print("\n");
		}*/
		
		// Implement me!
    } // end of printEdges()
    
    
    public int shortestPathDistance(T vertLabel1, T vertLabel2) {
    	long SPDStart = System.nanoTime();
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
				long SPDEnd = System.nanoTime();
				double totalSPDTime = ((double) (SPDEnd - SPDStart)) / Math.pow(10, 9);
				//System.out.println(totalSPDTime);
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
		
		long SPDEnd = System.nanoTime();
		double totalSPDTime = ((double) (SPDEnd - SPDStart)) / Math.pow(10, 9);
		//System.out.println(totalSPDTime);
		
		// Implement me!
    	
        // if we reach this point, source and target are disconnected
        return disconnectedDist;    	
    } // end of shortestPathDistance()
    
} // end of class IndMatrix

