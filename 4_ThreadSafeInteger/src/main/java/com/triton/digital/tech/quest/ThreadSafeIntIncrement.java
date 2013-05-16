/**
 * 
 */
package com.triton.digital.tech.quest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class that will show 3 thread safe ways of incrementing an integer
 * 
 * @author Ali Joomun
 * @version 1.0.0
 * 
 */
public class ThreadSafeIntIncrement {

	/*
	 * Int is declared volatile. This will inform the compiler that it would be
	 * accessed by multiple threads
	 */
	private volatile int volatileInteger;

	/*
	 * Initializes an int value that can be updated atomically. i.e in a
	 * lock-free and thread-safe manner
	 */
	private AtomicInteger atomicCount = new AtomicInteger();

	private int myThreadSafeInt;

	/**
	 * Method that will increment an integer in a Thread safe manner as the
	 * integer is declared as volatile. This will inform the compiler that this
	 * method will be accessed by multiple threads.
	 * 
	 * @return incremented int
	 */
	public int getIncrementedVolatileInt() {
		synchronized (ThreadSafeIntIncrement.class) {
			volatileInteger++;
		}
		return volatileInteger;
	}

	/**
	 * Method will increment the integer by one of the current value. The
	 * integer is incremented atomically. It is thread-safe.
	 * 
	 * @return incremented int
	 */
	public int getIncrementedAtomicInteger() {
		return atomicCount.incrementAndGet();
	}

	/**
	 * Method uses the synchronized block which makes possible that only one
	 * thread can execute the method at a time which removes possibility of
	 * coinciding or interleaving. Thus making it thread safe
	 * 
	 * @return incremented int
	 */
	public int getThreadSafeInt() {
		synchronized (ThreadSafeIntIncrement.class) {
			myThreadSafeInt++;
		}
		return myThreadSafeInt;
	}
}
