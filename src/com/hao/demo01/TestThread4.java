package com.hao.demo01;


//����߳�ͬʱ����ͬһ������
//���Ʊ������

//�������⣺����̲߳���ͬһ����Դ������£��̲߳���ȫ����������
public class TestThread4 implements Runnable{

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
		TestThread4 ticket = new TestThread4();
		
		new Thread(ticket,"С��").start();
		new Thread(ticket,"��ʦ").start();
		new Thread(ticket,"��ţ��").start();
	} 

}
