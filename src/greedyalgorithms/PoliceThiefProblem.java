package greedyalgorithms;
import java.util.*;

public class PoliceThiefProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k, n;
		char[] arr = {'P', 'T', 'T', 'P', 'T'};
		k = 2;
		n = arr.length;
		System.out.println(printMaxThieves(arr, k, n));
		
		char arr2[] =new char[] { 'T', 'T', 'P', 'P', 'T', 'P' }; 
		k = 2;
		n = arr2.length;
		System.out.println(printMaxThieves(arr2, k, n));
		
		char arr3[] = new char[]{ 'P', 'T', 'P', 'T', 'T', 'P' }; 
		k = 3; 
		n = arr3.length; 
		System.out.println(printMaxThieves(arr3, k, n));
	}

	public static int printMaxThieves(char[] arr, int k, int n)
	{
		int ans = 0;
		List<Integer> P = new ArrayList<Integer>();
		List<Integer> T = new ArrayList<Integer>();
		for(int i=0; i<n; i++)
		{
			if(arr[i] == 'P')
			{
				P.add(i+1);
			}
			else
			{
				T.add(i+1);
			}
		}
		int l = 0, r = 0;
		while((l < T.size()) && (r < P.size()))
		{
			if(Math.abs(T.get(l) - P.get(r)) <= k)
			{
				ans++;
				l++;
				r++;
			}
			else if(T.get(l) < P.get(r))
			{
				l++;
			}
			else
			{
				r++;
			}
		}
		return ans;
	}
}
