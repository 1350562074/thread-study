package com.hao.thread02;

public class SafeBank {
	public static void main(String[] args) {
		Account2 account = new Account2(100, "������");
		Drawing2 you = new Drawing2(account, 50, "��");
		Drawing2 girlFriend = new Drawing2(account, 100, "Ů����");
		
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
	
	//synchronizedĬ��������thisָ�Ķ���
	//����Ҫ�۲����ĸ������ڸı�
	//���Ķ����ǹ���Ķ��󣬻���˵����ɾ�ĵĶ���	
	@Override
	public  void run() {
		synchronized(account) {
			if(account.money-drawingMoney<0) {
				System.out.println(Thread.currentThread().getName()+"Ǯ������ȡ����");
				return;
			}
			
			//sleep���ԷŴ�����ķ�����
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			account.money = account.money-drawingMoney;
			nowMoney = nowMoney + drawingMoney;
			System.out.println(account.name+"���Ϊ��"+account.money);
			
			//this.getName() == Thread.currentThread().getName();
			System.out.println(this.getName()+"�����Ǯ��"+nowMoney);

		}
	}
	
}