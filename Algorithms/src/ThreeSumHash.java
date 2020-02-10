// Solving three sum problem but with a hashtable
import java.util.* ;
  
public class ThreeSumHash { 
  
    public static void main(String[] args)  
    { 
    	//creating the test case array
        int[] TestCase = new int[] {-25,-10, -7, -3, 2,  4, 8,10}; 
        
        ArrayList<ArrayList<Integer>> matches = threeSum(TestCase); 
        
        System.out.println(matches); 
         
         
    } 
     
    public static ArrayList<ArrayList<Integer>> threeSum(int[] x) 
    { 
        final int length = x.length; 
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
        
        HashMap<Integer, int[]> hashMap = new HashMap<Integer, int[]>(); 
        
        if (length < 3) return result; 
         
        for (int i = 0; i < length - 2; i++)  
        { 
            if (x[i] > 0) break; 
            hashMap.clear(); 
             
            if (i == 0 || x[i] > x[i - 1])  
            { 
                for (int j = i + 1; j < length; j++)  
                { 
                    if (hashMap.containsKey(x[j]))  
                    { 
                        ArrayList<Integer> elem = new ArrayList<Integer>(3); 
                     
                        elem.add(hashMap.get(x[j])[0]); 
                        elem.add(hashMap.get(x[j])[1]); 
                        elem.add(x[j]); 
                         
                        result.add(elem); 
                         
                        while (j < (length - 1) && x[j] == x[j + 1]) j++; 
                    } 
                    else 
                    { 
                        int[] temp = new int[2]; 
                        temp[0] = x[i]; 
                        temp[1] = x[j]; 
                        hashMap.put(0 - (x[i] + x[j]), temp); 
                    } 
                } 
            } 
        } 
        return result; 
    } 
  
}   
