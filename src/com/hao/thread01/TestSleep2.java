package com.hao.thread01;

import java.sql.Date;
import java.text.SimpleDateFormat;

//模拟倒计时
public class TestSleep2 {
	public static void main(String[] args) {
//		try {
//			tenDown();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//打印当前系统时间
		Date startTime = new Date(System.currentTimeMillis());
		
		while(true) {
			try {
				Thread.sleep(1000);
				System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
				startTime = new Date(System.currentTimeMillis());//更新当前时间
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//模拟倒计时
	public static void tenDown() throws InterruptedException {
		int num = 10;
		while(true) {
			Thread.sleep(1000);
			System.out.println("num--");
			if(num <= 0) {
				break;
			}
		}
	}
}
