package greedyalgorithms;
import java.util.*;

public class OptimalMergePriorityQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// no of files 
        int size = 6; 
  
        // 6 files with their sizes 
        int files[] = new int[] { 2, 3, 4, 5, 6, 7 }; 
  
        // total no of computations 
        // do be done final answer 
        System.out.println("Minimum Computations = " + minComputation(size, files)); 
	}
	
	public static int minComputation(int size, int[] files)
	{
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i=0; i<size; i++)
		{
			queue.add(files[i]);
		}
		int count = 0;
		while(queue.size() > 1)
		{
			int temp = (queue.poll() + queue.poll());
			queue.add(temp);
			count += temp;
		}
		return count;
	}
}
