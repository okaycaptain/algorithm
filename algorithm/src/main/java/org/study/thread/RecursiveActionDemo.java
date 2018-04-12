/**
 * 
 */
package org.study.thread;

import java.lang.reflect.Array;
import java.nio.channels.NonWritableChannelException;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author captain
 *
 */
public class RecursiveActionDemo extends RecursiveAction {
	private static final long serialVersionUID = 3214121451355345L;

	static int[] raw = {19, 3, 0, -1, 57, 24, 65, Integer.MAX_VALUE, 42, 0, 3, 5};
	static int[] sorted = null;

	int[] source;
	int[] dest;
	int length;
	int start;
	final static int THRESHOLD = 4;

	public static void main(String[] args) {
		sorted = new int[raw.length];
		RecursiveActionDemo fb = new RecursiveActionDemo(raw, 0, raw.length, sorted);
		ForkJoinPool pool = new ForkJoinPool();
		System.out.println(pool.getPoolSize());
		pool.invoke(fb);
		System.out.println(Arrays.toString(sorted));
	}

	public RecursiveActionDemo(int[] src, int start, int length, int[] dest) {
		this.source = src;
		this.start = start;
		this.length = length;
		this.dest = dest;
	}

	@Override
	protected void compute() {
		// TODO Auto-generated method stub
		System.out.println("ForkJoinDemo.compute()" + length);
		if (length < THRESHOLD) {
			for (int i = start; i < start + length; i++) {
				dest[i] = source[i] * source[i];
			}
		} else {
			int split = length / 2;
			invokeAll(new RecursiveActionDemo(source, start, split, dest),
					new RecursiveActionDemo(source, start + split, length - split, dest));
		}

	}

}
