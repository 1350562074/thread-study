package com.hao.Thread03;

//����������̻߳��౧�ŶԷ���Ҫ����Դ��Ȼ���γɽ���
public class DeadLock {
	public static void main(String[] args) {
		Makeup g1 = new Makeup(0, "�ҹ���");
		Makeup g2 = new Makeup(1, "��ѩ����");
		
		g1.start();
		g2.start();
	}
}

//�ں�

class Lipstick{
	
}

//����

class Mirror{
	
}

//��ױ

class Makeup extends Thread{
	
	//ֻ��һ����Դ��Ҫ����Ϊ��̬����
	static Lipstick lipstick = new Lipstick();
	static Mirror mirror = new Mirror();
	
	int choice; //ѡ��
	String girlName;//ʹ�û�ױƷ����
	
	Makeup(int choice,String girlName){
		this.choice = choice;
		this.girlName = girlName;
	}
	
	
	//��ױ
	@Override
	public void run() {
		try {
			makeup();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//������������ 
//	private void makeup() throws InterruptedException {
//		if(choice == 0) {
//			synchronized (lipstick) {//��ÿں����
//				System.out.println(this.girlName+"��ÿں����");
//				Thread.sleep(1000);
//				synchronized (mirror) {//һ���Ӻ����þ���
//					System.out.println(this.girlName+"��þ��ӵ���");
//					
//				}
//			}
//			
//		}else {
//			synchronized (mirror) {//��þ��ӵ���
//				System.out.println(this.girlName+"��þ��ӵ���");
//				Thread.sleep(2000);
//				synchronized (lipstick) {//һ���Ӻ����ÿں�
//					System.out.println(this.girlName+"��ÿں����");
//					
//				}
//			}
//			
//		}
//	}
//	
	
	//ͬ���������ͬ��������˾��ͷ���
	private void makeup() throws InterruptedException {
		if(choice == 0) {
			synchronized (lipstick) {//��ÿں����
				System.out.println(this.girlName+"��ÿں����");
				Thread.sleep(1000);
				
			}
			synchronized (mirror) {//һ���Ӻ����þ���
				System.out.println(this.girlName+"��þ��ӵ���");
				
			}
		}else {
			synchronized (mirror) {//��þ��ӵ���
				System.out.println(this.girlName+"��þ��ӵ���");
				Thread.sleep(2000);
				
			}
			synchronized (lipstick) {//һ���Ӻ����ÿں�
				System.out.println(this.girlName+"��ÿں����");
				
			}
		}
	}
}

