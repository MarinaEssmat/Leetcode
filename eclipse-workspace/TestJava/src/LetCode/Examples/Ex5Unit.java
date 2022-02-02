package LetCode.Examples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Ex5Unit {

	@BeforeEach
	void setUp() throws Exception {
	}


	
	@Test
	public void testC1() 
	{
	   String input = "the sky is blue";
	   String output = "blue is sky the";
	    assertEquals(output, new Ex4().reverseWords(input));
	    
	}
	
	@Test
	public void testC2() 
	{
	   String input = "  hello world  ";
	   String output = "world hello";
	    assertEquals(output, new Ex4().reverseWords(input));

	}

}
