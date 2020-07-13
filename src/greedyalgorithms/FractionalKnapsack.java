package greedyalgorithms;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] w = {10, 40, 20, 30}; 
		double[] p = {60, 40, 100, 120}; 
		double c = 50; 
  
        System.out.println("Max Profit = " + maxProfit(p, w, c)); 
 
	}
	
	public static double maxProfit(double[] p, double[] w, double c)
	{
		Item[] items = new Item[w.length];
		double profit = 0;
		for(int i=0; i<w.length; i++)
		{
			items[i] = new Item(w[i], p[i], i);
		}
		Arrays.sort(items, new Comparator<Item>()  
        { 
            @Override
            public int compare(Item o1, Item o2)  
            { 
                return o2.r.compareTo(o1.r) ; 
            } 
        }); 
		for(int i=0; i<items.length; i++)
		{
			System.out.println(items[i].w + "  " + items[i].p + "  " + items[i].r);
		}
		
		for(int i=0; i<items.length; i++)
		{
			if(c-items[i].w >= 0)
			{
				c -= items[i].w;
				profit += items[i].p;
			}
			else
			{
				double temp = (double)c/(double)items[i].w;
				profit += (items[i].p * temp);
				c -= (temp);
				break;
			}
		}
		return profit;
	}
}

class Item{
	double w, p, index;
	Double r;

	public Item(double w, double p, double index) {
		this.w = w;
		this.p = p;
		this.index = index;
		this.r = Double.valueOf(p/w);
	}
}