package greedyalgorithms;

public class DijkstraAlgorithm {

	public static void main(String[] args) {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
        ShortestPath t = new ShortestPath(); 
        t.dijkstra(graph, 0, 9); 
	}
}

class ShortestPath {
	int minKey(int[] dist, boolean[] mst)
	{
		int minInd = 0, minValue = Integer.MAX_VALUE;
		
		for(int i=0; i<dist.length; i++)
		{
			if((minValue > dist[i]) && (mst[i] == false))
			{
				minValue = dist[i];
				minInd = i;
			}
		}
		return minInd;
	}
	
	void dijkstra(int[][] graph, int src, int V)
	{
		int[] distance = new int[V];
		boolean[] mst = new boolean[V];
		
		for(int i=0; i<V; i++)
		{
			distance[i] = Integer.MAX_VALUE;
			mst[i] = false;
		}
		distance[src] = 0;
		 
		for(int i=0; i<V; i++)
		{
			int u = minKey(distance, mst);
			mst[u] = true;
			
			for(int j=0; j<V; j++)
			{
				if((graph[u][j] != 0) && (mst[j] == false) && (distance[u] != Integer.MAX_VALUE) && (distance[u] + graph[u][j] < distance[j]))
				{
					distance[j] = distance[u] + graph[u][j];
				}
			}
		}
		printSolution(distance);
 	}
    
	// A utility function to print the constructed distance array 
    void printSolution(int dist[]) 
    { 
        System.out.println("Vertex \t\t Distance from Source"); 
        for (int i = 0; i < dist.length; i++) 
        {
        	System.out.println(i + " \t\t " + dist[i]); 
        }
    } 
}