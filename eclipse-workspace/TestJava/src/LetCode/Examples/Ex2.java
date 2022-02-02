package LetCode.Examples;

import java.util.ArrayList;
/*
 * A transaction is possibly invalid if:
•	the amount exceeds $1000, or;
•	if it occurs within (and including) 60 minutes of another transaction with the same name in a different city.
You are given an array of strings transaction where transactions[i] consists of comma-separated values representing the name, time (in minutes), amount, and city of the transaction.
Return a list of transactions that are possibly invalid. You may return the answer in any order.
 
Example 1:
Input: transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
Output: ["alice,20,800,mtv","alice,50,100,beijing"]
Explanation: The first transaction is invalid because the second transaction occurs within a difference of 60 minutes, have the same name and is in a different city. Similarly the second one is invalid too.
Example 2:
Input: transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
Output: ["alice,50,1200,mtv"]
Example 3:
Input: transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
Output: ["bob,50,1200,mtv"]
 
Constraints:
•	transactions.length <= 1000
•	Each transactions[i] takes the form "{name},{time},{amount},{city}"
•	Each {name} and {city} consist of lowercase English letters, and have lengths between 1 and 10.
•	Each {time} consist of digits, and represent an integer between 0 and 1000.
•	Each {amount} consist of digits, and represent an integer between 0 and 2000.
---------------------------------------
A company is planning to interview 2n people. Given the array costs where costs[i] = [aCosti, bCosti], the cost of flying the ith person to city a is aCosti, and the cost of flying the ith person to city b is bCosti.
Return the minimum cost to fly every person to a city such that exactly n people arrive in each city.
 
Example 1:
Input: costs = [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
Example 2:
Input: costs = [[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]
Output: 1859
Example 3:
Input: costs = [[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]
Output: 3086
 
Constraints:
•	2 * n == costs.length

 */
import java.util.List;

public class Ex2 {

	public static void main(String[] args) {
		Ex2 code= new Ex2();
		String [] L = { "alice,20,800,mtv","alice,50,100,frankfurt","alice,51,100,frankfurt","alice,53,800,mtv" };
		System.out.println(code.invalidTransactions(L));
	}
	
	public List<String> invalidTransactions(String[] transactions) {
        List<String> result = new ArrayList<String>();
        List<String[]> listOfTransactions = new ArrayList<>();
        List<String[]> invalidTransactionsList = new ArrayList<>();

        for ( int i =0 ; i< transactions.length ; i++)
        {
            String[] res = transactions[i].split("[,]", 0);
        	listOfTransactions.add(res);	
        }
        
        for (int i =0 ; i<listOfTransactions.size();i++)
        {
        	if ((Integer.parseInt((listOfTransactions.get(i))[2])> 1000))
        	{
        		invalidTransactionsList.add(listOfTransactions.get(i));
        		listOfTransactions.remove(i);
        	}
        }
        
        List<String[]> CompareList = new ArrayList<>(listOfTransactions);
        List<String[]> newTempList = new ArrayList<>();
        List<String[]> newListOfTrans = new ArrayList<>(listOfTransactions);
        
        boolean sameNameExist = false;
        int i =0;   
        CompareList.remove(0);
            

        while ( newListOfTrans.size()> 0 )
        {

        	String name = (newListOfTrans.get(i))[0];
        	String country = (newListOfTrans.get(i))[3];
        	
        	if ( CompareList.size() == 0 || CompareList.size() == 1)
        		break;
        	
        	for(int n = 0 ; n < CompareList.size() ;n++ )
        	{
        		// if there are duplicate names
        		if (CompareList.get(n)[0].equals(name) & !CompareList.get(n)[3].equals(country) & ( Integer.parseInt(CompareList.get(n)[1])- Integer.parseInt(newListOfTrans.get(i)[1]) ) < 60)
        		{        			invalidTransactionsList.add(CompareList.get(n));
        			sameNameExist=true;
        			
        		}
        		else
    			{

    					newTempList.add(CompareList.get(n));
    					
    			}			
    			
        	}
        	
        	if (sameNameExist)
        	{
        		invalidTransactionsList.add(newListOfTrans.get(i));
        		sameNameExist=false;
        	}


        	CompareList=newTempList;
        	newListOfTrans = newTempList;
        	newTempList = new ArrayList<>();
        }

        
        for ( int s =0 ; s < invalidTransactionsList.size() ; s++)
        {
        	String k = "";
        	for ( int y =0; y < invalidTransactionsList.get(s).length ; y++)
        	{
        		if ( y <3 )
        		{
        			k = k+invalidTransactionsList.get(s)[y]+",";
        		}
        		else if ( y == 3)
        		{
        			k = k+invalidTransactionsList.get(s)[y];
        		}
        	}
        	result.add(k);
        }
        
             
        return result;  
    }
       
	}
