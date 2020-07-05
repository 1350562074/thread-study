package com.hao.thread01;

import com.hao.demo01.TestThread4;

//ģ��������ʱ:�Ŵ�����ķ�����
public class TestSleep implements Runnable{
private int ticketNums = 10;
	
	@Override
	public void run() {
		while(true) {
			if(ticketNums <= 0) {
				break;
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"-->�õ��˵�"+ticketNums--+"Ʊ");
		}
	}
	public static void main(String[] args) {
		TestSleep ticket = new TestSleep();
		
		new Thread(ticket,"С��").start();
		new Thread(ticket,"��ʦ").start();
		new Thread(ticket,"��ţ��").start();
	} 
}
