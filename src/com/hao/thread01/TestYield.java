package com.hao.thread01;

//���������߳�
//���ò�һ���ɹ�����CPU����
public class TestYield {
	
	public static void main(String[] args) {
		MyYield myYield = new MyYield();
		new Thread(myYield,"a").start();
		new Thread(myYield,"b").start();
	}
	
}

class MyYield implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"�߳̿�ʼִ��");
		Thread.yield();
		System.out.println(Thread.currentThread().getName()+"�߳�ִֹͣ��");
	}
	
}
