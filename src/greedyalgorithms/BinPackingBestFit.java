package greedyalgorithms;

public class BinPackingBestFit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int weight[] = { 2, 5, 4, 7, 1, 3, 8 }; 
		  int c = 10; 
		  int n = weight.length; 
		  System.out.println("Number of bins required in Next Fit : " + bestFit(weight, n, c)); 
	}
	public static int bestFit(int[] w, int n, int c)
	{
		int res = 0;
		int[] bins = new int[n];
		
		for(int i=0; i<n; i++)
		{
			int j;
			int ind = 0, minSpace = c+1;
			for(j=0; j<res; j++)
			{
				if((bins[j] >= w[i]) && (bins[j]-w[i] < minSpace))
				{
					ind = j;
					minSpace = bins[j]-w[i];
				}
			}
			
			if(minSpace == c+1)
			{
				bins[res] = c - w[i];
				res++;
			}
			else 
			{
				bins[ind] -= w[i];
			}
		}		
		
		return res;
	}
}
