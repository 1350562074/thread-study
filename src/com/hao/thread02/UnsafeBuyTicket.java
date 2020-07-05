package com.hao.thread02;

//不安全的买票
public class UnsafeBuyTicket {
	public static void main(String[] args) {
		BuyTicket buyTicket = new BuyTicket();
		
		new Thread(buyTicket,"苦逼的我").start();
		new Thread(buyTicket,"牛逼的你们").start();
		new Thread(buyTicket,"可恶的黄牛党").start();
	}
}


class BuyTicket implements Runnable{
	
	private int ticketNums =10;
	boolean flag = true;
	
	@Override
	public void run() {
		while(flag) {
			try {
				buy();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void buy() throws InterruptedException {
		if(ticketNums <= 0) {
			flag = false;
			return ;
		}
		Thread.sleep(100);
		System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
	}
	
}