package greedyalgorithms;

import java.util.Arrays;
import java.util.Collections;

public class BinPackingFirstFitDecreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Integer weight[] = { 2, 5, 4, 7, 1, 3, 8 }; 
		  int c = 10; 
		  int n = weight.length; 
		  
		  Arrays.sort(weight, Collections.reverseOrder());
		  for(int i=0; i<n; i++) 
		  {
			  System.out.println(weight[i]);
		  }
		  System.out.println("Number of bins required in Next Fit : " + firstFit(weight, n, c)); 
	}
	
	public static int firstFit(Integer[] w, int n, int c)
	{
		int res = 0; 
		int[] bins = new int[n];
		
		for(int i=0; i<n; i++)
		{
			int j;
			for(j=0; j<res; j++)
			{
				if(bins[j] >= w[i])
				{
					bins[j] -= w[i];
					break;
				}
			}
			if(j == res)
			{
				bins[j] = c - w[i];
				res++;
			}
		}
		return res;
	}
}
