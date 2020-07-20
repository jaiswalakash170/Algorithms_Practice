package greedyalgorithms;

public class BinPackingNextFit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int weight[] = { 2, 5, 4, 7, 1, 3, 8 }; 
		  int c = 10; 
		  int n = weight.length; 
		  System.out.println("Number of bins required in Next Fit : " + nextFit(weight, n, c)); 
	}
	
	public static int nextFit(int[] w, int n, int c)
	{
		int res = 0, bin_cap = c;
		
		for(int i=0; i<n; i++)
		{
			if(w[i] <= bin_cap)
			{
				bin_cap -= w[i];
			}
			else
			{
				res++;
				bin_cap = c - w[i];
			}
		}
		return res;
	}
}
