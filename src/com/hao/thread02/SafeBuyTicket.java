package com.hao.thread02;

public class SafeBuyTicket {
	public static void main(String[] args) {
		BuyTicket2 buyTicket = new BuyTicket2();
		
		new Thread(buyTicket,"��Ƶ���").start();
		new Thread(buyTicket,"ţ�Ƶ�����").start();
		new Thread(buyTicket,"�ɶ�Ļ�ţ��").start();
	}
}


class BuyTicket2 implements Runnable{
	
	private int ticketNums =10;
	boolean flag = true;
	
	@Override
	public void run() {
		while(flag) {
			try {
				buy();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
	
	//synchronized ͬ��������������this
	private synchronized void buy() throws InterruptedException {
		if(ticketNums <= 0) {
			flag = false;
			return ;
		}
		//sleep��buy�������������һ�����⣺
		//sleep�����Ƿ���������һֱ��һ���߳�ִ��
//		Thread.sleep(100);
		System.out.println(Thread.currentThread().getName()+"�õ�"+ticketNums--);
	}
	
}