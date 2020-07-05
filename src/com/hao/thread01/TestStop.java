package com.hao.thread01;

import java.util.FormatFlagsConversionMismatchException;

//测试stop
//1.建议线程正常停止-->利用次数，不建议死循环
//2.建议使用标志位-->设置一个标志位
//3.不要使用stop或destroy等过时或者JDK不建议使用的方法	

//停止的是test线程，主线程一直在走
public class TestStop implements Runnable{
	
	//1.设置一个标志位
	
	private boolean flag = true;
	@Override
	public void run() {
		int i=0;
		while(flag) {
			System.out.println("run...Thread"+i--);
		}
	}
	
	public void stop() {
		this.flag = false;
	} 	
	
	
	public static void main(String[] args) {
		TestStop testStop = new TestStop();
		new Thread(testStop).start();
		for(int i=0; i<100; i++) {
			System.out.println("main");
			if(i==90) {
				testStop.stop();
				System.out.println("该停止了");
			}
		}
		
	}
}
