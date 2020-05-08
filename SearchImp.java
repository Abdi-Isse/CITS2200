import java.util.*;
import CITS2200.*;

/**
 * Breadth First and Depth First Search implementations
 * @author Abdihafith Isse
 */

public class SearchImp implements Search {
	private int time;
	private int[][] timesArray;
	private int[][] edges;
	private int[] seen;
	/**
	 * Runs a BFS on a given directed, unwieghted graph
	 * @param Graph g & int startVertex
	 * @return connected tree
	 */
	public int[] getConnectedTree(Graph g, int startVertex) {
		int[][] edgeMatrix = g.getEdgeMatrix();
		int[] connectedTree = new int[edgeMatrix.length];
		int[] seen = new int[edgeMatrix.length];

		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(startVertex);
		seen[startVertex] = 1;
		Arrays.fill(connectedTree, -1);
		
		while(queue.size() != 0) {
			int edge = queue.remove();
			for(int i = 0; i < edgeMatrix[edge].length; ++i) {
				if (seen[i] == 0 && edgeMatrix[edge][i] == 1) {
					seen[i] = 1;
					connectedTree[i] = edge;
					queue.add(i);
				}
			}
		}

		return connectedTree;
	}
	
	/**
	 * Runs BFS on a given directed, unweighted graph to find the distances of vertices from the start vertex
	 * @param Graph g & int startVertex
	 * @return distances
	 */
	public int[] getDistances(Graph g, int startVertex) {
		int[][] edgeMatrix = g.getEdgeMatrix();
		int[] distances = new int[edgeMatrix.length];
		int[] seen = new int[edgeMatrix.length];

		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(startVertex);
		Arrays.fill(distances,-1);
		seen[startVertex] = 1;
		distances[startVertex] = 0;
		
		while(queue.size() != 0) {
			int edge = queue.remove();
			for(int i = 0; i < edgeMatrix[edge].length; ++i) {
				if (seen[i] == 0 && edgeMatrix[edge][i] == 1) {
					seen[i] = 1;
					distances[i] = distances[edge] +1;
					queue.add(i);
				}
			}
		}

		return distances;
	}
	
	/**
	 * Runs DFS on a given directed, unweighted graph to find the start time and finish time for each vertex
	 * @param graph g, int startvertex
	 * @return timesArray
	 */
	public int[][] getTimes(Graph g, int startVertex) {
		edges = g.getEdgeMatrix();
		int vertices = g.getNumberOfVertices();
		seen = new int[vertices];
		timesArray = new int[vertices][2];
		for(int[] i: timesArray){
			Arrays.fill(i, -1);
		}
		time = 0;
		dfsGetTimes(startVertex);
		return timesArray;
	}
	
	private void dfsGetTimes(int vertex) {
		seen[vertex] = 1;
		timesArray[vertex][0] = time;
		time++;
		for(int i = 0; i < edges.length; ++i) {
			if(seen[i] == 0 && edges[vertex][i] == 1) {
				dfsGetTimes(i);
			}
		}
		timesArray[vertex][1] = time;
		time++;
	}
}