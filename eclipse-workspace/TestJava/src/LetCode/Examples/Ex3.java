package LetCode.Examples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/*
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */

public class Ex3 {

	public static void main(String[] args) {
		Ex3 code= new Ex3();
		int[] nums1 = {4,9,5}; 
		int [] nums2 = {9,4,9,8,4};
		int[] result = code.intersection(nums1,nums2);
		for ( int i =0 ; i<result.length ; i++)
		{
			System.out.println(result[i]);
		}

	}
	
	 public int[] intersection(int[] nums1, int[] nums2) {
	       
        ArrayList<Integer> intersection = new ArrayList<>();
        int count = 0 ;
             
        for ( int i=0 ; i< nums1.length ; i++)
        {
            for ( int x = 0 ; x <nums2.length ; x++)
            {
                if ( nums1[i]==nums2[x])
                {
                   intersection.add(count,nums2[x]);
                    count ++;
                    
                }
            }
        }

        for ( int m : intersection)
        {
        	System.out.println(m);
        }

        Object[] objectArray =intersection.toArray();
        
        int[] integerArray = new int[objectArray.length];
 
        // copy elements from object array to integer array
        for (int i = 0; i < objectArray.length; i++) {
            integerArray[i] = (int)objectArray[i];
        }
        
        int end = integerArray.length;
        Set<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < end; i++){
          set.add(integerArray[i]);
        }
        
        int[] hello = new int[set.size()];
        int i =0;
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
          hello[i]=it.next();
          i++;
        }
        return hello;
    }
    
	
	 
}
