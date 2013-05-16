package com.triton.digital.tech.quest;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 * Class used to test FibonacciSequence
 * @author Ali Joomun
 * @version 1.0.0
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class FibonacciSequenceTest {
	

	private static final Logger LOGGER = Logger.getLogger(FibonacciSequenceTest.class);
	
	/**
	 * Method for testing the first 10 Fibonacci Sequence
	 */
	@Test
	public void genFirst10FibSequenceTest(){
		
		Map<Integer, Integer> fibMap = FibonacciSequence.genFirst10FibSequence();
		assertEquals(10, fibMap.size());
		Integer[] fibNos = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
		
		Iterator<Entry<Integer, Integer>> iterator = fibMap.entrySet().iterator();
		int fibNosPosition = 0;
		while (iterator.hasNext()) {
			Map.Entry<Integer, Integer> mapEntry = (Map.Entry<Integer, Integer>) iterator.next();
			assertEquals(fibNos[fibNosPosition],  (Integer)(mapEntry.getValue()));
			fibNosPosition++;
			LOGGER.info("Position: " + mapEntry.getKey()
				+ " of Fibonacci sequence has value :" + mapEntry.getValue());
		}
	}

}
