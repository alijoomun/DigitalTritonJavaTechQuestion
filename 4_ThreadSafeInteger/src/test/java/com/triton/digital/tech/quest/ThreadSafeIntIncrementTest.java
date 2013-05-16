package com.triton.digital.tech.quest;

import org.jmock.lib.concurrent.Blitzer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 * Class used to test ThreadSafeIntIncrement Main test done is to determine if
 * it is thread safe.
 * 
 * @author Ali Joomun
 * @version 1.0.0
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class ThreadSafeIntIncrementTest {

	/*
	 * The Blitzer class is used for stress-testing the synchronization of
	 * passive objects that do not start their own threads.
	 * http://jmock.org/threading-blitzer.html
	 */
	private Blitzer blitzer;

	private ThreadSafeIntIncrement threadSafeIntIncrement;

	/*
	 * Variable that will hold the count of the increment.
	 */
	private int countInt;

	@Before
	public void setUp() {
		blitzer = new Blitzer(25000);
		threadSafeIntIncrement = new ThreadSafeIntIncrement();
		// Upon testing each method @before is called
		// code below sets count back to 0
		countInt = 0;
	}

	/**
	 * Test testing method getIncrementedAtomicInteger with multiple threads
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void getIncrementedAtomicIntegerMultipleThreadsSimultaneously()
			throws InterruptedException {
		blitzer.blitz(new Runnable() {
			public void run() {
				countInt = threadSafeIntIncrement.getIncrementedAtomicInteger();
			}
		});
		assertEquals(blitzer.totalActionCount(), countInt);
	}

	/**
	 * Test testing method getIncrementedVolatileInt with multiple threads
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void getIncrementedVolatileIntMultipleThreadsSimultaneously()
			throws InterruptedException {
		blitzer.blitz(new Runnable() {
			public void run() {
				countInt = threadSafeIntIncrement.getIncrementedVolatileInt();
			}
		});
		assertEquals(blitzer.totalActionCount(), countInt);
	}

	/**
	 * Test testing method getThreadSafeInt with multiple threads
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void getThreadSafeIntMultipleThreadsSimultaneously()
			throws InterruptedException {
		blitzer.blitz(new Runnable() {
			public void run() {
				countInt = threadSafeIntIncrement.getThreadSafeInt();
			}
		});
		assertEquals(blitzer.totalActionCount(), countInt);
	}

	@After
	public void tearDown() throws InterruptedException {
		blitzer.shutdown();
	}

}
