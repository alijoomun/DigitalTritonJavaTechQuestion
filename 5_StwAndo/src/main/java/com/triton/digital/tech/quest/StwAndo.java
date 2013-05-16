/**
 * 
 */
package com.triton.digital.tech.quest;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Class that prints numbers from 1 to 100 
 * For multiples of 3 print Stw 
 * For multiple of 5 Ando for both multiple of 3 and 5 print StwAndo 
 * 
 * @author Ali Joomun
 * @version 1.0.0
 */
public class StwAndo {

	private static final Logger LOGGER = Logger.getLogger(StwAndo.class);

	public enum NumberType {
		STW("Stw"), ANDO("Ando"), STWANDO("StwAndo"), NORMALNUM("");
		private String value;

		private NumberType(String value) {
			this.value = value;
		}
	};  
	
	private static Map<Integer, String> stwAndoMap = new HashMap<Integer, String>();

	
	/**
	 * Method that will print out 
	 * Stw for multiples of 3 
	 * Ando for multiple of 5
	 * StwAndo for both multiple of 3 and 5 
	 * For others (not multiples of 3 and 5) just the number
	 * @return returns a Map for the numbers containing the number 
	 * and its corresponding evaluated value 
	 */
	public static Map<Integer, String> generateStwAndo() {

		for (int i = 1; i <= 100; i++) {			
			printNumber(i);			
		}
		return stwAndoMap;
	}
	
	/**
	 * Method that will print the numbers from 1 to 100
	 * Stw for multiples of 3 
	 * Ando for multiple of 5
	 * StwAndo for both multiple of 3 and 5 
	 * @param takes in a int as parameter the number to be checked
	 */
	private static void printNumber(int number) {

		NumberType numberType = NumberType.NORMALNUM;
		String numberValue = String.valueOf(number);
		
		if (number % 3 == 0 && number % 5 == 0) {
			numberType = NumberType.STWANDO;
		} else if (number % 3 == 0) {
			numberType = NumberType.STW;
		} else if (number % 5 == 0) {
			numberType = NumberType.ANDO;
		}

		
		switch (numberType) {
		case STWANDO:
			numberValue = NumberType.STWANDO.value;
			LOGGER.info("number: " + number
					+ " is a multiple of 3 and 5 so it is an: "
					+ numberValue);
			break;
		case STW:
			numberValue = NumberType.STW.value;
			LOGGER.info("number: " + number
					+ " is a multiple of 3 so it is an: " + numberValue);
			break;
		case ANDO:
			numberValue = NumberType.ANDO.value;
			LOGGER.info("number: " + number
					+ " is a multiple of 5 so it is an: "
					+ numberValue);
			break;
		default:
			LOGGER.info("number: " + number + " is a normal so : " + number);
			break;

		}		
		stwAndoMap.put(number, numberValue);

	}

}
