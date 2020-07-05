package com.hao.thread01;

import java.sql.Date;
import java.text.SimpleDateFormat;

//ģ�⵹��ʱ
public class TestSleep2 {
	public static void main(String[] args) {
//		try {
//			tenDown();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//��ӡ��ǰϵͳʱ��
		Date startTime = new Date(System.currentTimeMillis());
		
		while(true) {
			try {
				Thread.sleep(1000);
				System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
				startTime = new Date(System.currentTimeMillis());//���µ�ǰʱ��
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//ģ�⵹��ʱ
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
