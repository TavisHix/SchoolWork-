//Solving the three summ problem
import java.util.ArrayList;
import java.util.Arrays;


//Finding three sum in a group of numebrs means any three numbers that add to be zero
public class ThreeSum {
	
	public static void main(String[] args)
	{
		
		//The test case
		Integer[] TestCase = { -25, -10 , -7, -3, 2, 4, 8 , 10};
		ArrayList<Integer[]> p = threeSum(TestCase);
		
		// process of printing out answers
		int n = 1;
		System.out.println("The 3 sum matches are:");
		for(int i = 0; i < p.size(); i++) 
		{
			System.out.print(n + ". ");
			System.out.println(Arrays.toString(p.get(i)));
			n++;
		}
	}



	public static ArrayList<Integer[]> threeSum(Integer[] x)
	{
		
		// making a array list of integers to store the matches
		ArrayList<Integer[]> matches = new ArrayList<Integer[]>();
		
		// Sorting the array although array is sent in already sorted
		Arrays.sort(x);

		for( int i = 0; i < x.length - 3; i++)
		{
			if(i == 0 || x[i] < x[i+1])
			{
				int start = i + 1;
				int end = x.length - 1;
				while(start < end)
				{
					if(x[i] + x[start] + x[end] == 0)
					{
						//Remove this comment and comment on line 46,47 to see the testing 
						//System.out.println(x[i] + " " + x[start] + " " + x[end] + " IS A MATCH");
						matches.add(new Integer[] {x[i], x[start], x[end]});
					}
					//else
						//System.out.println(x[i] + " " + x[start] + " " + x[end] + " is not a match");
					
					//If the total of the three numbers is less than 0 then we move the start
					if(x[i] + x[start] + x[end] < 0)
					{
						int myStart = start;
						while (x[start] == x[myStart] && start < end)
						{
							start ++;
						}
					}
					//If the total of the three numbers is greater than 0 then we move the end
					else
					{
						int myEnd = end;
						while(x[end] == x[myEnd] && start < end)
						{
							end--;
						}
					}
				}
			}
		}
		return matches;
	}
}