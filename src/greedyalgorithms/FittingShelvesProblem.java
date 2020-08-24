package greedyalgorithms;

public class FittingShelvesProblem {

	public static void main(String[] args) {
		int wall = 24, m = 3, n = 5;
		System.out.println("Minimum left space: " + minSpaceFittingShelves(wall, m, n));
		
		wall = 24;
		m = 4;
		n = 7;
		System.out.println("Minimum left space: " + minSpaceFittingShelves(wall, m, n));
		
		wall = 29;
		m = 3;
		n = 9;
		System.out.println("Minimum left space: " + minSpaceFittingShelves(wall, m, n));
	}

	public static int minSpaceFittingShelves(int wall, int m, int n)
	{
		int rem = 0, minEmpty = wall;
		int p = 0, q = 0;
		int finalM = 0, finalN = 0;
		
		while(wall >= n)
		{
			p = wall/m;
			rem = wall%m;
			
			if(rem <= minEmpty)
			{
				finalM = p;
				finalN = q;
				minEmpty = rem;
			}
			q++;
			wall -= n;
		}
		System.out.println("Number of m type shelves = " + finalM);
		System.out.println("Number of n type shelves = " + finalN);
		return rem;
	}
}
