package com.hao.Thread03;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//²âÊÔLockËø
public class TestLock {
	public static void main(String[] args) {
		TestLock2 testLock2 = new TestLock2();
		
		new Thread(testLock2).start();
		new Thread(testLock2).start();
		new Thread(testLock2).start();
	}
}

class TestLock2 implements Runnable{
	int ticketNums = 1000;
	
	//¶¨ÒåLockËø
	private final ReentrantLock lock = new ReentrantLock();
	
	@Override
	public void run() {
		while(true) {
			try {
				lock.lock(); //¼ÓËø
				if(ticketNums>0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"---"+ticketNums--);
				}else {
					break;
				}
			} finally {
				lock.unlock();
			} 
			
		}
	}
	
}