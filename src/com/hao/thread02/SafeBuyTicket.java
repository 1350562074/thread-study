package com.hao.thread02;

public class SafeBuyTicket {
	public static void main(String[] args) {
		BuyTicket2 buyTicket = new BuyTicket2();
		
		new Thread(buyTicket,"苦逼的我").start();
		new Thread(buyTicket,"牛逼的你们").start();
		new Thread(buyTicket,"可恶的黄牛党").start();
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
	
	//synchronized 同步方法，锁的是this
	private synchronized void buy() throws InterruptedException {
		if(ticketNums <= 0) {
			flag = false;
			return ;
		}
		//sleep放buy里面这样会出现一个问题：
		//sleep不会是否锁，所以一直是一个线程执行
//		Thread.sleep(100);
		System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
	}
	
}