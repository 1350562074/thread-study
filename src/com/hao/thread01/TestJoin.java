package com.hao.thread01;

import java.util.Iterator;

//����join����������Ϊ���
public class TestJoin implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("�߳�VIP����"+i);
		}
		
	}
	
	//200֮ǰ��cpu���ȣ��ǲ��еģ�����200֮ǰ�ǽ������
	
	public static void main(String[] args) throws InterruptedException {
		
		//�������ǵ��߳�
		TestJoin testJoin = new TestJoin();
		Thread thread = new Thread(testJoin);
		
		thread.start();
		
		
		//���߳�
		for (int i = 0; i < 500; i++) {
			if(i==200) {
				thread.join();
			}
			System.out.println("main"+i);
		}
		
		
	}
}
