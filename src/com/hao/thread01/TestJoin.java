package com.hao.thread01;

import java.util.Iterator;

//测试join方法，想象为插队
public class TestJoin implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("线程VIP来了"+i);
		}
		
	}
	
	//200之前是cpu调度，是并行的，所以200之前是交替进行
	
	public static void main(String[] args) throws InterruptedException {
		
		//启动我们的线程
		TestJoin testJoin = new TestJoin();
		Thread thread = new Thread(testJoin);
		
		thread.start();
		
		
		//主线程
		for (int i = 0; i < 500; i++) {
			if(i==200) {
				thread.join();
			}
			System.out.println("main"+i);
		}
		
		
	}
}
