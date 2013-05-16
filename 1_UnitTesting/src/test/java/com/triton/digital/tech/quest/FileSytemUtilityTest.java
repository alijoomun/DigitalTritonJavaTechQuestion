package com.triton.digital.tech.quest;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
/**
 * Class used to test FileSytemUtility class 
 * particularly method isFileSystemSpaceLeft
 * @author Ali Joomun
 * @version 1.0.0
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class FileSytemUtilityTest {

	/**
	 * Unit test to test if only one 1 kb was possible to be written on a 20GB HD
	 * Outcome expected is true
	 * @throws IOException
	 */
	@Test
	public void isFileSystemSpaceLeft_True() throws IOException {
		long fileSizeToWrite = 1;//1kb
		long timeout = 3000; //3secs
		assertTrue(FileSytemUtility.isFileSystemSpaceLeft(fileSizeToWrite,timeout));
	}
	
	/**
	 * Unit test to test if only one 9 tera was possible to be written on a 20GB HD
	 * Outcome expected is false
	 * @throws IOException
	 */
	@Test
	public void isFileSystemSpaceLeft_False() throws IOException {
		long fileSizeToWrite = 900000000;//9 TERA
		long timeout = 3000;//3 secs
		assertFalse(FileSytemUtility.isFileSystemSpaceLeft(fileSizeToWrite,timeout));
	}

}
