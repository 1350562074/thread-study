package com.hao.thread01;import java.lang.Thread.State;

import javax.xml.stream.events.StartDocument;

//�۲�����̵߳�״̬
public class TestState {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread( ()-> {
			for(int i=0; i<5;i++) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("///////");
		});
		
		
		
		//�۲�״̬
		
		Thread.State state = thread.getState();
		System.out.println(state);
		
		//�۲�������
		
		thread.start();//�����߳�
		state = thread.getState();
		System.out.println(state);
		
		while(state != Thread.State.TERMINATED) {//ֻҪ�̲߳���ֹ����һֱ���״̬
			Thread.sleep(100);
			state = thread.getState();//�����߳�״̬
			System.out.println(state);//���״̬
		}
		
		thread.start();//����֮����̲߳���������
	}
}
