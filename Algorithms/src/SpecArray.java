//given a special array 

import java.util.Arrays; 

public class SpecArray {

	public static void main(String[] args)
	{
		int a = 18;
		int b = -21;
		int[] test = new int[] {18, 17, 14, 9, 6, 5, 1, -5, -9, -17, -22, -25, -20, -18, -10, -7, -3, 0, 2, 4, 8, 10, 15, 16};
		System.out.println("The number " + a + " is in the array: " + find(test, a));
		System.out.print("The number " + b + " is in the array: " + find(test, b));
	}
	
	//method to find a number in the array
	public static boolean find(int[] x, int a) 
	{
		int turnpoint = 0;
		
		//finding the turning point in the array if one exists
		for(int i = 0; i < x.length - 1 ; i++)
		{
			if(x[i] > x[i+1])
			{
				turnpoint = i + 1;
			}
		}
		
		
		int[] leftArray = Arrays.copyOfRange(x,0,turnpoint + 1);
		int[] rightArray = Arrays.copyOfRange(x,turnpoint, x.length);
		
		Arrays.sort(leftArray);
		int index = Arrays.binarySearch(leftArray, a);
		//Bellow is code to see what side of the turning point the number is in
		//System.out.println("left array: " + index);
		if(index < 0)
		{
			
			index = Arrays.binarySearch(rightArray, a);
			//A check to see what side of the turning point the number is in
			//System.out.println("right array:"+ index);
			if(index < 0)
			{
				
				return false;
			}
			else 
				return true;
			
		}
		else 
			return true;
		
		
	}
}
