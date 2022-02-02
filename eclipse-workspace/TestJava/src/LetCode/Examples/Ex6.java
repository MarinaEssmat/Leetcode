package LetCode.Examples;

import java.math.BigInteger;


/*
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.


 */
public class Ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex6 y = new Ex6();
		int[] n = {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
		int[] x=y.plusOne(n);
		for ( int s : x)
        {
        	
        	System.out.println(s);
        	
        }
	}
	
	public int[] plusOne(int[] digits) {
		
		BigInteger number=new BigInteger("0");

        for (int i =0 ; i<digits.length; i++)
        {
        	// Creating BigInteger object
            BigInteger b1= new BigInteger("10");
            int exponent = digits.length- i -1;
            
        	BigInteger ff=new BigInteger("0");
        	ff = ff.add(b1.pow(exponent));
        	// the number
        	BigInteger digit = BigInteger.valueOf(digits[i]);
        	ff = ff.multiply(digit);

        	number= number.add(ff);
        }
        
        BigInteger increment =new BigInteger("1");
        increment= increment.add(number);
       
        String s=String.valueOf(increment);
        String[] strArray = s.split("");
        
        int d = 0 ;
        int[] y = new int[strArray.length];
        
        for ( String v : strArray)
        {
        	y[d]=Integer. parseInt(v);
        	d++;
        }
        
        return y;
    }

}
