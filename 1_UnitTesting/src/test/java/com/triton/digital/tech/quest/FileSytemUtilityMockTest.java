package com.triton.digital.tech.quest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.io.FileSystemUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Class used to test FileSytemUtilityMockTest class 
 * particularly method isFileSystemSpaceLeft.
 * The test below will be using Powermock
 * @author Ali Joomun
 * @version 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(FileSystemUtils.class)
public class FileSytemUtilityMockTest {

	/**
	 * Mocking class FileSystemUtils
	 * when freeSpaceKb method is called size 200000000 kb is returned.
	 * @throws IOException
	 */
	@Before
	public void setUp() throws IOException {
		PowerMockito.mockStatic(FileSystemUtils.class);
		long fileSystemSpace = 200000000l;
		PowerMockito.when(FileSystemUtils.freeSpaceKb(Mockito.anyLong())).thenReturn(fileSystemSpace);
	}
	
	/**
	 * Unit test to test if only one 1 kb was possible to be written on a 20GB HD
	 * Outcome expected is true
	 * @throws IOException
	 */
	@Test
	public void isFileSystemSpaceLeft_True_Mock() throws IOException {		
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
	public void isFileSystemSpaceLeft_False_Mock() throws IOException {		                       
		long fileSizeToWrite = 900000000;//9 TERA
		long timeout = 3000;//3 secs
		assertFalse(FileSytemUtility.isFileSystemSpaceLeft(fileSizeToWrite,timeout));
	}

}
