package greedyalgorithms;

import java.util.*;

public class AssignMiceHoles {

	public static void main(String[] args) {
		ArrayList<Integer> mice = new ArrayList<Integer>();
		ArrayList<Integer> holes = new ArrayList<Integer>();
		mice.add(-10);
		mice.add(-79);
		mice.add(-79);
		mice.add(67);
		mice.add(93);
		mice.add(-85);
		mice.add(-28);
		mice.add(-94);
		
		holes.add(-2);
		holes.add(9);
		holes.add(69);
		holes.add(25);
		holes.add(-31);
		holes.add(23);
		holes.add(50);
		holes.add(78);
		
		System.out.println("Minimum time taken by last mouse : " + findMinTimeOfMouse(mice, holes));
	}
	
	public static int findMinTimeOfMouse(ArrayList<Integer> mice, ArrayList<Integer> holes)
	{
		int max = 0;
		Collections.sort(mice);
		Collections.sort(holes);
		
		for(int i=0; i<mice.size(); i++)
		{
			if(max < Math.abs(mice.get(i) - holes.get(i)))
			{
				max = Math.abs(mice.get(i) - holes.get(i));
			}
		}
		return max;
	}
}
