package greedyalgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencingDeadline {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] P = {20, 15, 10, 5, 1}; 
		int[] D = {2, 2, 1, 3, 3}; 
		
		System.out.println("Max Profit = " + maxProfit(D, P)); 
	}
	public static double maxProfit(int[] D, int[] P)
	{
		int maxProfit = 0;
		ItemJob[] items = new ItemJob[D.length];
		for(int i=0; i<D.length; i++)
		{
			items[i] = new ItemJob(i, P[i], D[i]);
		}
		Arrays.sort(items, new Comparator<ItemJob>()  
        { 
            @Override
            public int compare(ItemJob o1, ItemJob o2)  
            { 
                return Integer.valueOf(o2.profit).compareTo(Integer.valueOf(o1.profit)) ; 
            } 
        });

		int[] slots = new int[findMax(D)];
		int[] result = new int[findMax(D)];
		
		for(int i=0; i<items.length; i++)
		{
			System.out.println(items[i].profit + "  " + items[i].deadline + "  " + items[i].index);
		}
		
		for(int i=0; i<items.length; i++)
		{
			for(int j=(items[i].deadline - 1); j >= 0 && j < slots.length; j--)
			{
				if(slots[j] == 0)
				{
					slots[j] = 1;
					result[j] = items[i].index;
					maxProfit += items[i].profit;
					break;
				}
			}
		}
		System.out.println(result.toString());
		return maxProfit;
	}
	
	public static int findMax(int[] D)
	{
		int max = 0;
		for(int i=0; i<D.length; i++)
		{
			if(max < D[i])
			{
				max = D[i];
			}
		}
		return max;
	}
}

class ItemJob{
	int profit, deadline;
	int index;

	public ItemJob(int index, int profit, int deadline) {
		this.index = index;
		this.profit = profit;
		this.deadline = deadline;
	}
}
