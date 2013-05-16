package com.triton.digital.tech.quest;

import java.io.IOException;

import org.apache.commons.io.FileSystemUtils;
import org.apache.log4j.Logger;

/**
 * Utility class used to calculate the the amount of space there is on a file
 * system before writing x bytes
 * 
 * @author Ali Joomun
 * @version 1.0.0 
 */
public class FileSytemUtility {
	
	private static final Logger LOGGER = Logger.getLogger(FileSytemUtility.class); 

	/**
	 * Method that check the free space available
	 * @param timeout timeout configuration so that server will not hang
	 * @return the number of kb left
	 * @throws IOException
	 */
	private static long getSizeOfFreeSpace(long timeout) throws IOException {
		long sizeOfSystem = FileSystemUtils.freeSpaceKb(timeout);
		LOGGER.info("Timeout value is " + timeout + " and size available on the system is " + sizeOfSystem);
		return sizeOfSystem;
	}

	/**
	 * Method that checks if there is space available on file system to write 
	 * @param fileSizeToWrite size of the file we are about to write
	 * @param timeout timeout configuration so that server will not hang
	 * @return true if there is space left
	 * @throws IOException
	 */
	public static boolean isFileSystemSpaceLeft(long fileSizeToWrite, long timeout)
			throws IOException {

		boolean isSpaceAvailable = false;
		if (getSizeOfFreeSpace(timeout) >= fileSizeToWrite)
			isSpaceAvailable = true;
		LOGGER.info("is FileSystem Space Left TO WRITE " + fileSizeToWrite +" KB " + isSpaceAvailable);
		return isSpaceAvailable;
	}

}
