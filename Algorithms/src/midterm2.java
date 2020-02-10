
public class midterm2 {

	public static void main(String[] args)
	{
		String[] teststring = { "aba","aaa","aab", "bab"};
		System.out.print("The array we are checking is");
		for(int i= 0; i < teststring.length; i++)
		{
			System.out.print(" " + teststring[i]);
		}
		System.out.println("");
		System.out.println("Number of Equivalence clases:" +  equivalence(teststring));
		
	}
	
	public static int equivalence(String[] e)
	{
		int numOfEquivalences = 1;
		
		for(int i =0; i < e.length; i++)
		{
			char[] character = e[i].toCharArray();
			charsort(character);
			String back2string = new String(character);
			e[i] = back2string;
		}
		
		stringsort(e);
		
		System.out.print("The array when the chars and strings are sorted: ");
		for(int i= 0; i < e.length; i++)
		{
			System.out.print(e[i] + " ");
		}
		
		
		for(int i = 0; i < e.length-1; i++)
		{
			System.out.println("");
			System.out.println("Are " + e[i] + " and " +  e[i+1] + " the same");
			if(e[i].compareTo(e[i+1]) == 0)
			{
				System.out.println("Yes");
				numOfEquivalences++;
			}
			else{
				System.out.println("No");
				
			}
		}
		return numOfEquivalences;
		
	}
	
	
	
	
	
	 public static void charsort(char[] a)
	  {
		 int N = a.length;
		 int h = 1;
		 while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, ...
		 while (h >= 1)
		 { // h-sort the array.
		 for (int i = h; i < N; i++)
		 {
		 for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
		 charexch(a, j, j-h);
		 }

		 h = h/3;
		 }
	  }
	 
	 
	 
	 
	 public static void stringsort(String[] a)
	  {
		 int N = a.length;
		 int h = 1;
		 while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, ...
		 while (h >= 1)
		 { // h-sort the array.
		 for (int i = h; i < N; i++)
		 {
		 for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
		 exch(a, j, j-h);
		 }

		 h = h/3;
		 }
	  }
	 
	 
	 private static boolean less(Comparable v, Comparable w)
	 {
		return v.compareTo(w) < 0;
	 }
	 
	private static void charexch(char[] a, int i, int j)
	{
		char swap = a[i];
		//System.out.println( "comparing " + a[i] + " to " + a[j]);
		a[i] = a[j];
		a[j] = swap;
		//System.out.println(a[i] + " has been swapped with " + a[j]);
	}
	
	private static void exch(String[] a, int i, int j)
	{
		String swap = a[i];
		//System.out.println( "comparing " + a[i] + " to " + a[j]);
		a[i] = a[j];
		a[j] = swap;
		//System.out.println(a[i] + " has been swapped with " + a[j]);
	}
}