package greedyalgorithms;

import java.util.Arrays;
import java.util.Vector;
import java.util.Comparator;

public class SetCoverProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int items = 13;
		Subset[] subsets = new Subset[5];
		subsets[0] = new Subset(new int[] {1, 2}, 5, 2);
		subsets[1] = new Subset(new int[] {2, 3, 4, 5}, 10, 4);
		subsets[2] = new Subset(new int[] {6, 7, 8, 9, 10, 11, 12, 13}, 25, 8);
		subsets[3] = new Subset(new int[] {1, 3, 5, 7, 9, 11, 13}, 20, 7);
		subsets[4] = new Subset(new int[] {2, 4, 6, 8, 10, 12, 13}, 22, 7);
		for(int i=0; i<subsets.length; i++)
		{
			System.out.println(i + " -> Cost - " + subsets[i].cost + ", items - " + subsets[i].elements + ", ratio - " + subsets[i].ratio);
		}
		Vector<Subset> res = minimizedSubset(subsets, items);
		System.out.println(res);
	}
	
	public static Vector<Subset> minimizedSubset(Subset[] subsets,  int items)
	{
		boolean[] covered = new boolean[items+1];
		Vector<Subset> res = new Vector<Subset>();
		Arrays.sort(subsets, new MySetComparator());
		System.out.println();
		for(int i=0; i<subsets.length; i++)
		{
			System.out.println(i + " -> Cost - " + subsets[i].cost + ", items - " + subsets[i].elements + ", ratio - " + subsets[i].ratio);
		} 
		int s = 0;
		int totalCost = 0;
		while(!allCovered(covered) && s<5)
		{
			res.add(subsets[s]);
			updateCovered(subsets[s].elements, covered);
			totalCost += subsets[s].cost;
			s++;
		}
		System.out.println(totalCost);
		return res;
	}
	
	public static boolean allCovered(boolean[] covered)
	{
		for(int i=1; i<covered.length; i++)
		{
			if(covered[i] == false)
			{
				return false;
			}
		}
		return true;
	}
	public static void updateCovered(int[] items, boolean[] covered)
	{
		for(int i=0; i<items.length; i++)
		{
			covered[items[i]] = true;
		}
	}
}

class Subset{
	int[] elements;
	int cost, n;
	Double ratio;
	
	public Subset(int[] elements, int cost, int n) {
		super();
		this.elements = elements;
		this.cost = cost;
		this.n = n;
		this.ratio = Double.valueOf((double)cost/(double)n);
	}
}

class MySetComparator implements Comparator<Subset> { 
    public int compare(Subset x, Subset y) 
    { 
        return x.ratio.compareTo(y.ratio) ;  
    } 
} 