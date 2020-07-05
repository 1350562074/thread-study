package com.hao.thread02;

public class UnsafeBank {
	public static void main(String[] args) {
		Account account = new Account(100, "结婚基金");
		Drawing you = new Drawing(account, 50, "你");
		Drawing girlFriend = new Drawing(account, 100, "女朋友");
		
		you.start();
		girlFriend.start();
	}
	
}


class Account{
	int money;
	String name;
	public Account(int money,String name) {
		this.money = money;
		this.name = name;
	}
}

class Drawing extends Thread{
	
	Account account;
	int drawingMoney;
	int nowMoney;
	
	public Drawing(Account account,int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	
	@Override
	public void run() {
		if(account.money-drawingMoney<0) {
			System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
			return;
		}
		
		//sleep可以放大问题的发生性
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		account.money = account.money-drawingMoney;
		nowMoney = nowMoney + drawingMoney;
		System.out.println(account.name+"余额为："+account.money);
		
		//this.getName() == Thread.currentThread().getName();
		System.out.println(this.getName()+"手里的钱："+nowMoney);
	}
	
}