package greedyalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JobSchedulingDisjointSet {

	public static void main(String[] args) {
        ArrayList<JobItem> arr=new ArrayList<JobItem>(); 
        
        arr.add(new JobItem(100, 2, 1)); 
        arr.add(new JobItem(9, 1, 2)); 
        arr.add(new JobItem(27, 2, 3)); 
        arr.add(new JobItem(25, 1, 4)); 
        arr.add(new JobItem(15, 3, 5)); 
        System.out.println("Following jobs need to be "+ "executed for maximum profit"); 
        printJobScheduling(arr); 
	}
	
	public static void printJobScheduling(ArrayList<JobItem> arr)
	{
		Collections.sort(arr, new JobItem());
		
		for(JobItem j : arr)
		{
			System.out.println("Index - " + j.index + ", Deadline - " + j.deadline + ", Profit - " + j.profit);
		}
		
		int m = findMaxDeadline(arr);
		System.out.println("m - "+ m);
		DisjointSet dj = new DisjointSet(m);
		
		for(JobItem j : arr)
		{
			int next = dj.find(j.deadline);
			
			if(next>0)
			{
				dj.merge(dj.find(next-1), next);
				System.out.println(j.index + " ");
			}
		}
	}
	
	public static int findMaxDeadline(ArrayList<JobItem> arr)
	{
		int maxDeadline = Integer.MIN_VALUE;
		for(JobItem j : arr)
		{
			if(j.deadline > maxDeadline)
			{
				maxDeadline = j.deadline;
			}
		}
		return maxDeadline;
	}
}

class DisjointSet{
	private int parent[];

	public DisjointSet(int n) {
		super();
		parent = new int[n+1];
		for(int i=0; i<n+1; i++)
		{
			parent[i] = i;
		}
	}
	
	public int find(int s)
	{
		if(parent[s] == s)
		{
			return s;
		}
		return parent[s] = find(parent[s]);
	}
	
	public void merge(int s, int d)
	{
		parent[d] = s;
	}
}

class JobItem implements Comparator<JobItem>{
	int profit, deadline, index;

	public JobItem() {
		
	}
	
	public JobItem(int profit, int deadline, int index) {
		super();
		this.profit = profit;
		this.deadline = deadline;
		this.index = index;
	}
	
    public int compare(JobItem j1, JobItem j2) 
    { 
        return j1.profit > j2.profit? -1: 1; 
    } 
}