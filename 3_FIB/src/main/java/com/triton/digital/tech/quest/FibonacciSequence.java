/**
 * 
 */
package com.triton.digital.tech.quest;

import java.util.HashMap;
import java.util.Map;

/**
 * Class used generate the first 10 numbers
 * of the Fibonacci sequence in a non-recursive manner.
 * @author Ali Joomun
 * @since 1.0.0
 */

/* 
 * The advantages to using a non-recursive functions are:
 * 1. We do not need to allocate much memory as from the code below we will only require 3 
 *    variables to store our values. Recursion will require larger amount of memory to be allocated.
 * 2. Non-recursive functions are far less complex to implement than recursive ones. 
 */


public class FibonacciSequence {
	
	/*
	 * This is the first Finonacci no
	 */
	private static Integer firstFibonacciNo = 0;
	
	/*
	 * This is the second Finonacci no
	 */
	private static Integer secondFibonacciNo = 1;
	
	/**
	 * Method will generate the first 10 Fibonnaci Sequence
	 * using a non recursive algorithm
	 * @return a map containing the values of the Fibonnaci Sequence in the desired order
	 */
	public static Map<Integer, Integer> genFirst10FibSequence(){
		
		Map<Integer, Integer> fibMap = new HashMap<Integer, Integer>();
		fibMap.put(1, firstFibonacciNo);		
		fibMap.put(2, secondFibonacciNo);
		
		Integer fibNo = secondFibonacciNo;
		Integer position = 3;
		for (int i = 0;i<8;i++){
			fibNo =  firstFibonacciNo + secondFibonacciNo;
			firstFibonacciNo = secondFibonacciNo;
			secondFibonacciNo = fibNo;
			fibMap.put(position+i, fibNo);
		}
		
		return fibMap;
	}
}
