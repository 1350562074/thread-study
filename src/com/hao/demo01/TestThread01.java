package com.hao.demo01;


//�����̷߳�ʽһ���̳�Thread�࣬��дrun()����������start�����߳�

/*
 * �߳̿�����һ������ִ�У���cpu����ִ��
 */
public class TestThread01 extends Thread{

	@Override
	public void run() {
		for(int i = 0; i < 20; i++) {
			System.out.println("I am watching---"+i);
		}
	}
	
	public static void main(String[] args) {
		
		TestThread01 testThread01 = new TestThread01();
		testThread01.start();
		
		for(int i = 0; i < 20; i++) {
			System.out.println("I am looking at thread---"+i);
		}
	}

}
