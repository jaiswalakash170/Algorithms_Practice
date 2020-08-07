package greedyalgorithms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class ProductionSchedulingMinLoss {

	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<Product>();
		products.add(new Product(1, 3));
		products.add(new Product(2, 1));
		products.add(new Product(3, 41));
		products.add(new Product(4, 52));
		products.add(new Product(5, 15));
		products.add(new Product(6, 4));
		products.add(new Product(7, 1));
		products.add(new Product(8, 63));
		products.add(new Product(9, 12));
		
		for(Product p : products)
		{
			System.out.println("Product No: " + p.index + ", Product Volume: " + p.volume);
		}
		
		System.out.println("Maximum Volume = " + printMaximumVolume(products));
	}
	public static double printMaximumVolume(ArrayList<Product> products)
	{
		double maxVol = 0;
		
		Collections.sort(products, new Product());
		System.out.println();
		System.out.println();
		for(Product p : products)
		{
			System.out.println("Product No: " + p.index + ", Product Volume: " + p.volume);
			maxVol = p.volume + (maxVol * 0.8);
		}
		return maxVol;
	}
}

class Product implements Comparator<Product>{
	int volume, index;
	
	public Product()
	{
		
	}
	public Product(int index, int volume)
	{
		this.index = index;
		this.volume = volume;
	}
	
	public int compare(Product p1, Product p2)
	{
		return (p1.volume > p2.volume) ? 1: -1;
	}
}