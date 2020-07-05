package com.hao.demo01;

//创建线程方式二：实现runnable接口，重写run方法，执行线程需要丢入runnable接口实现类，调用start方法
public class TestThread3 implements Runnable{

	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println("I am watching---"+i);
		}
	}
	
	public static void main(String[] args) {
		
		TestThread3 testThread3 = new TestThread3();
		Thread thread = new Thread(testThread3);
		thread.start();
		
		// new Thread(testThread3).start();
		for(int i = 0; i < 20; i++) {
			System.out.println("I am looking at thread---"+i);
		}
	}

}
