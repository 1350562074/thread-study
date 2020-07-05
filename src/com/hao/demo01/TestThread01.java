package com.hao.demo01;


//创建线程方式一：继承Thread类，重写run()方法，调用start开启线程

/*
 * 线程开启不一定立即执行，由cpu调度执行
 */
public class TestThread01 extends Thread{

	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println("I am watching---"+i);
		}
	}
	
	public static void main(String[] args) {
		
		TestThread01 testThread01 = new TestThread01();
		testThread01.start();
		
		for(int i = 0; i < 20; i++) {
			System.out.println("I am looking at thread---"+i);
		}
	}

}
