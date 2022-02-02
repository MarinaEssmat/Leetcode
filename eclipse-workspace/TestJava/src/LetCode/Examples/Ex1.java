/*
 * Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 
 
Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:
Input: numRows = 1
Output: [[1]]
 
Constraints:
•	1 <= numRows <= 30

 */
package LetCode.Examples;
import java.util.ArrayList;

import java.util.List;
public class Ex1 {

	public static void main(String[] args) {
		Ex1 code= new Ex1();
		System.out.println(code.generate(20));

	}

	    public List<List<Integer>>  generate(int numRows) {
	       List<List<Integer>> Output = new ArrayList<List<Integer>>();
	        List<Integer> beforeList = new ArrayList<Integer>();
	        List<Integer> afterList = new ArrayList<Integer>();

	        
	        //first node in the tree is added already
	        if ( numRows >=1)
	        {
	            beforeList.add(1);
	            Output.add(beforeList);
	        }
	        else 
	        {
	            return Output;
	        }
	        // starting from the next row
	        for ( int i =1 ; i< numRows ; i++)
	        {
	            afterList = new ArrayList<Integer>();
	            int afterListSize = beforeList.size() + 1 ;

	        for ( int afterIndexes = 0 ; afterIndexes < afterListSize ; afterIndexes ++)
	        {
	            if (afterIndexes ==0)
	            { afterList.add(afterIndexes,beforeList.get(0) + 0);}
	            else if (afterIndexes == beforeList.size()  )
	            { afterList.add(afterIndexes,beforeList.get(beforeList.size()-1) + 0);}
	            else
	            {
	            afterList.add(afterIndexes,beforeList.get(afterIndexes) + beforeList.get(afterIndexes-1));
	            }

	        }
	            
	            Output.add(afterList);
	            beforeList=afterList;
	    }
	      
	   return Output; 
	}
	

}
