package com.hao.thread01;

import java.util.FormatFlagsConversionMismatchException;

//����stop
//1.�����߳�����ֹͣ-->���ô�������������ѭ��
//2.����ʹ�ñ�־λ-->����һ����־λ
//3.��Ҫʹ��stop��destroy�ȹ�ʱ����JDK������ʹ�õķ���	

//ֹͣ����test�̣߳����߳�һֱ����
public class TestStop implements Runnable{
	
	//1.����һ����־λ
	
	private boolean flag = true;
	@Override
	public void run() {
		int i=0;
		while(flag) {
			System.out.println("run...Thread"+i--);
		}
	}
	
	public void stop() {
		this.flag = false;
	} 	
	
	
	public static void main(String[] args) {
		TestStop testStop = new TestStop();
		new Thread(testStop).start();
		for(int i=0; i<100; i++) {
			System.out.println("main");
			if(i==90) {
				testStop.stop();
				System.out.println("��ֹͣ��");
			}
		}
		
	}
}
