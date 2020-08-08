package greedyalgorithms;
import java.util.*; 

public class EfficientHuffmanCoding {

	public static void main(String[] args) {
		char[] arr = {'a', 'b', 'c', 'd', 'e', 'f'};
		int[] freq = {5, 9, 12, 13, 16, 45};
		int size = 6;

		print(printHuffmanCodes(arr, freq, size), "");
	}
	
	public static void print(HuffmanNode N, String s)
	{
		if((N.left == null) && (N.right == null) && (Character.isLetter(N.c))) 
        { 
            System.out.println(N.c + ":" + s); 
            return; 
        } 
  
        print(N.left, s + "0"); 
        print(N.right, s + "1"); 
	}
	
	public static HuffmanNode printHuffmanCodes(char[] arr, int[] freq, int size)
	{
		Queue<HuffmanNode> Q1 = new LinkedList<HuffmanNode>();
		Queue<HuffmanNode> Q2 = new LinkedList<HuffmanNode>();
		for(int i=0; i<size; i++)
		{
			System.out.println("Index : " + (i+1) + ", Character : " + arr[i] + ", Frequency : " + freq[i]);
			Q1.add(new HuffmanNode(arr[i], freq[i]));
		}
		System.out.println();
		HuffmanNode newNode;
		while(!((Q1.peek() == null) && (Q2.size() == 1))) 
		{
			HuffmanNode left = findMin(Q1, Q2);
			HuffmanNode right = findMin(Q1, Q2);
			newNode = new HuffmanNode('-', left.f + right.f);
			newNode.left = left;
			newNode.right = right;
			Q2.add(newNode);
		}
		return Q2.poll();
	}
	
	public static HuffmanNode findMin(Queue<HuffmanNode> Q1, Queue<HuffmanNode> Q2)
	{
		if(Q1.peek() == null)
		{
			return Q2.remove();
		}
		if(Q2.peek() == null)
		{
			return Q1.remove();
		}
		if(Q1.peek().f < Q2.peek().f)
		{
			return Q1.remove();
		}
		return Q2.remove();
	}
}

class HuffmanNode implements Comparator<HuffmanNode>{
	char c;
	int f;
	HuffmanNode left, right;
	
	public HuffmanNode()
	{
		
	}
	
	public HuffmanNode(char c, int f)
	{
		this.c = c;
		this.f = f;
	}
	
	public int compare(HuffmanNode n1, HuffmanNode n2)
	{
		return (n1.f > n2.f) ? -1 : 1;
	}
}