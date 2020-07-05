package com.hao.thread02;

public class SafeBank {
	public static void main(String[] args) {
		Account2 account = new Account2(100, "结婚基金");
		Drawing2 you = new Drawing2(account, 50, "你");
		Drawing2 girlFriend = new Drawing2(account, 100, "女朋友");
		
		you.start();
		girlFriend.start();
	}
	
}


class Account2{
	int money;
	String name;
	public Account2(int money,String name) {
		this.money = money;
		this.name = name;
	}
}

class Drawing2 extends Thread{
	
	Account2 account;
	int drawingMoney;
	int nowMoney;
	
	public Drawing2(Account2 account,int drawingMoney,String name) {
		super(name);
		this.account = account;
		this.drawingMoney = drawingMoney;
	}
	
	//synchronized默认锁的是this指的对象
	//我们要观察是哪个对象在改变
	//锁的对象是共享的对象，或者说是增删改的对象	
	@Override
	public  void run() {
		synchronized(account) {
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
	
}