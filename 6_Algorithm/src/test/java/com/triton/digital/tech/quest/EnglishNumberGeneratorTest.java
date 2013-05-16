/**
 * 
 */
package com.triton.digital.tech.quest;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Class used test EnglishNumberGenerator class
 * 
 * @author Ali Jooomun
 * @version 1.0.0
 * 
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class EnglishNumberGeneratorTest {

	@Test
	public void translateNumberTest() {
		assertEquals("inputed value is null",
				EnglishNumberGenerator.translateNumber(null));
		assertEquals("Zero",
				EnglishNumberGenerator.translateNumber(BigInteger.valueOf(0L)));
		assertEquals("One hundred thousand, two hundred and eighty two",
				EnglishNumberGenerator.translateNumber(BigInteger
						.valueOf(100282L)));

	}

}
