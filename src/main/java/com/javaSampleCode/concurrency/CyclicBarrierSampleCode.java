package com.javaSampleCode.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//Latches are for waiting for events; barriers are for waiting for other threads. - Java Concurrency in Practice

//CyclicBarrier can be used where we have divided the task with n threads and each thread must wait for other thread after doing there part. 

class CyclicBarrierTask implements Runnable {
	private CyclicBarrier barrier;

	public CyclicBarrierTask(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
			barrier.await();
			System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} catch (BrokenBarrierException ex) {
			ex.printStackTrace();
		}
	}
}

public class CyclicBarrierSampleCode {
	public static void main(String[] args) {
		final CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
			@Override
			public void run() {
				// This task will be executed once all thread reaches barrier
				System.out.println("All parties are arrived at barrier, lets play");
			}
		});
		// starting each of thread
		Thread t1 = new Thread(new CyclicBarrierTask(cb), "Thread 1");
		Thread t2 = new Thread(new CyclicBarrierTask(cb), "Thread 2");
		Thread t3 = new Thread(new CyclicBarrierTask(cb), "Thread 3");

		t1.start();
		t2.start();
		t3.start();

		System.out.println("\n\n\n\n\n\n\n\n\n");

		// t1 = new Thread(new Task(cb), "Thread 1");
		// t2 = new Thread(new Task(cb), "Thread 2");
		// t3 = new Thread(new Task(cb), "Thread 3");
		//
		// t1.start();
		// t2.start();
		// t3.start();
	}
}
