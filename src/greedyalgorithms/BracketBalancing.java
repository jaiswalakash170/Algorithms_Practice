package greedyalgorithms;
import java.util.*;

public class BracketBalancing {

	public static void main(String[] args) {
        String str = "[]][]["; 
        System.out.println(numOfSwaps(str) ); 
  
        str = "[[][]]"; 
        System.out.println(numOfSwaps(str) ); 
        
        str = "[[][]][]]][["; 
        System.out.println(numOfSwaps(str) );
        
        str = "[]][]["; 
        System.out.println(swapCount(str) ); 
  
        str = "[[][]]"; 
        System.out.println(swapCount(str) ); 
        
        str = "[[][]][]]][["; 
        System.out.println(swapCount(str) );
	}
	
	public static int numOfSwaps(String str) {
		int swap = 0;
		int l=0, r=0, ib = 0;
		
		for(int i=0; i<str.length(); i++)
		{
			if(str.charAt(i) == '[')
			{
				l++;
				if(ib > 0)
				{
					swap += ib;
					ib--;
				}
			}
			else if(str.charAt(i) == ']')
			{
				r++;
				ib = r - l;
			}
		}
		
		return swap;
	}
	
	public static int swapCount(String str)
	{
		char[] chArr = str.toCharArray();
		
		int swap = 0, count = 0, p = 0;
		Vector<Integer> pos = new Vector<Integer>();
		
		for(int i=0; i<chArr.length; i++)
		{
			if(chArr[i] == '[')
			{
				pos.addElement(i+1);
			}
		}
		
		for(int i=0; i<chArr.length; i++)
		{
			if(chArr[i] == '[')
			{
				++count;
				++p;
			}
			else if(chArr[i] == ']')
			{
				--count;
			}
			
			if(count < 0)
			{
				swap += pos.get(p) - i;
				char temp =  chArr[p];
				chArr[p] = chArr[i];
				chArr[i] = temp;
				++p;
				count = 1;
			}
		}
		return swap;
	}
}
