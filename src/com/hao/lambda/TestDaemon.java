package com.hao.lambda;

public class TestDaemon {
	public static void main(String[] args) {
		God god = new God();
		You you = new You();
		
		Thread thread = new Thread(god);
		thread.setDaemon(true);
		//Ĭ����false��ʾ���û��̣߳��������̶߳����û��߳�
		
		thread.start(); //�ϵ��ػ��߳�����
		
		new Thread(you).start();//��  �û��߳�����
	}
}



class God implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("�ϵ۱�������");
		}
	}
}

//��
class You implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 36500; i++) {
			System.out.println("��һ�������ĵĻ���");
		}
		System.out.println("----------goodbye,world!---------");
	}
	
}