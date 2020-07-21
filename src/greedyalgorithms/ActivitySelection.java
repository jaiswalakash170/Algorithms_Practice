package greedyalgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int s[] =  {5, 1, 3, 0, 5, 8}; 
	    int f[] =  {9, 2, 4, 6, 7, 9}; 
	    int n = s.length; 
	         
	    printMaxActivities(s, f, n); 
	}

	public static void printMaxActivities(int s[], int f[], int n)
	{
		Activity[] activities = new Activity[n];
		for(int i=0; i<n; i++)
		{
			activities[i] = new Activity(s[i], f[i]);
		}
		
		Arrays.sort(activities, new MyActivityComparator());
		
		for(int i=0; i<n; i++)
		{
			System.out.println("Activity - " + i + ", Start[i] - " + activities[i].start + ", End[i] - " + activities[i].end);
		}
		
		int actInd = 0;
		System.out.println("Activity - " + actInd + ", Start - " + activities[actInd].start + ", End - " + activities[actInd].end);
		
		for(int j=1; j<n; j++)
		{
			if(activities[j].start >= activities[actInd].end)
			{
				System.out.println("Activity - " + j + ", Start - " + activities[j].start + ", End - " + activities[j].end);
				actInd = j;
			}
		}
	}
}

class Activity{
	int start, end;

	public Activity(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
}

class MyActivityComparator implements Comparator<Activity> { 
    public int compare(Activity x, Activity y) 
    { 
        return x.end - y.end;  
    } 
} 