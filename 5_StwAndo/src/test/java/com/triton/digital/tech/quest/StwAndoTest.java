/**
 * 
 */
package com.triton.digital.tech.quest;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Class that test StwAndo
 * @author Ali Joomun
 * @version 1.0.0
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class StwAndoTest {
	
	/**
	 * Test method generateStwAndo
	 */
	@Test
	public void testGenerateStwAndo(){
		Map<Integer, String> stwAndoMap = StwAndo.generateStwAndo();
		assertEquals(100, stwAndoMap.size());
		assertEquals("Stw", stwAndoMap.get(Integer.valueOf(6)));
		assertEquals("Ando", stwAndoMap.get(Integer.valueOf(20)));
		assertEquals("StwAndo", stwAndoMap.get(Integer.valueOf(90)));
		assertEquals("94", stwAndoMap.get(Integer.valueOf(94)));
	}

}
