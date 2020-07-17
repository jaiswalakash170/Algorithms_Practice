package greedyalgorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanCodingPriorityQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// no of files 
        int size = 6; 
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };
  
        // total no of computations 
        // do be done final answer 
        Node root = HuffmanCodingAlgo(charArray, charfreq, size);
        printCodes(root, "");
	}
	
	public static void printCodes(Node root, String s)
	{
        if((root.left == null) && (root.right == null) && (Character.isLetter(root.c))) 
        { 
            System.out.println(root.c + ":" + s); 
            return; 
        } 
  
        printCodes(root.left, s + "0"); 
        printCodes(root.right, s + "1"); 
	}
	
	public static Node HuffmanCodingAlgo(char[] charArray, int[] charfreq, int size)
	{
		Node root = null;
		PriorityQueue<Node> queue = new PriorityQueue<>(size, new MyComparator());
		
		for(int i=0; i<size; i++)
		{
			Node newNode = new Node(charArray[i], charfreq[i]);
			queue.add(newNode);
		}
		
		while(queue.size() > 1)
		{
			Node left = queue.poll();
			Node right = queue.poll();
			
			Node temp = new Node('-', left.f+right.f);
			queue.add(temp);
			temp.left = left;
			temp.right = right;
			root = temp;
		}
		return root;
	}
}

class Node{
	public char c;
	public int f;
	
	Node left, right;

	public Node(char c, int f) {
		this.c = c;
		this.f = f;
	}
}

class MyComparator implements Comparator<Node> { 
    public int compare(Node x, Node y) 
    { 
        return x.f - y.f; 
    } 
} 