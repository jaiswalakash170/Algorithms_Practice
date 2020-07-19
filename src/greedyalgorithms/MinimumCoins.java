package greedyalgorithms;

import java.util.Vector;

public class MinimumCoins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1000, 500, 100, 50, 20, 10, 5, 1};
		int value = 93;
		Vector<Integer> res = new Vector<Integer>();
		for(int i=0; i<coins.length && value!=0; i++)
		{
			while(value/coins[i] != 0)
			{
				value -= coins[i];
				res.add(coins[i]);
			}
		}
		System.out.println(res);
	}

}
