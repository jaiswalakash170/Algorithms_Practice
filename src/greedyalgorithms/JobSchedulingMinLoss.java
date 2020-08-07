package greedyalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JobSchedulingMinLoss {

	public static void main(String[] args) {
        ArrayList<JobDetail> arr = new ArrayList<JobDetail>(); 
        
        arr.add(new JobDetail(1, 2, 1)); 
        arr.add(new JobDetail(2, 4, 2)); 
        arr.add(new JobDetail(3, 1, 3)); 
        arr.add(new JobDetail(5, 3, 4)); 
        arr.add(new JobDetail(6, 2, 5)); 
        
        System.out.println("Following jobs need to be "+ "executed for maximum profit"); 
		for(JobDetail j : arr)
		{
			System.out.println("Index - " + j.index + ", Time - " + j.time + ", Loss - " + j.loss);
		}
        printJobScheduling(arr); 
	}
	
	public static void printJobScheduling(ArrayList<JobDetail> arr)
	{
		System.out.println();
		System.out.println("Optimal Pattern for scheduling:");
		Collections.sort(arr, new JobDetail());
		
		for(JobDetail j : arr)
		{
			System.out.println("Index - " + j.index + ", Time - " + j.time + ", Loss - " + j.loss);
		}
	}
}

class JobDetail implements Comparator<JobDetail>{
	int loss, time, index;

	public JobDetail() {
		
	}
	
	public JobDetail(int loss, int time, int index) {
		super();
		this.loss = loss;
		this.time = time;
		this.index = index;
	}
	
    public int compare(JobDetail j1, JobDetail j2) 
    { 
        return (j1.loss*j2.time > j2.loss*j1.time)?1:-1; 
    }
}