package com.hao.Thread04;


//���ԣ�������������ģ��--�����û�����������̷ܳ�
public class TestPC {
	public static void main(String[] args) {
		SynContainer container = new SynContainer();
		new Producer(container).start();
		new Consumer(container).start();
	}
}


//������
class Producer extends Thread{
	SynContainer container;
	
	public Producer(SynContainer container) {
		this.container = container;
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("������"+i+"ֻ��");
			container.push(new Chicken(i));
		}
	}
	
	
	
}

//������
class Consumer extends Thread{
	SynContainer container;
	
	public Consumer(SynContainer container) {
		this.container = container;
	}
	
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("�����˵�"+container.pop().id+"ֻ��");
		}
	}
	
}

//��Ʒ
class Chicken{
	int id;
	public Chicken(int id) {
		this.id = id;
	}
}

//�ٽ���
class SynContainer{
	
	//����������
	int count = 0;
	
	//��Ҫһ��������С
	Chicken[] chickens = new Chicken[10];
	
	//�ж�count ==10��0����һ�䣬��ò�Ҫ��if��
	//Ӧ����while�������ж�������ߵ�ʱ�򣬻�������жϵ�
	
	//�����߷����Ʒ
	public synchronized void push(Chicken chicken) {
		//����������ˣ��͵ȴ�����������
		if(count==chickens.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//���û���������Ǿ���Ҫ�����Ʒ
		chickens[count++]=chicken;
		
		//����֪ͨ������������
		this.notifyAll();
		
	}
	
	//���������Ѳ�Ʒ
	public synchronized Chicken pop() {
		if(count==0) {
			//�ȴ������������������ߵȴ�
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//�����������
		Chicken chicken = chickens[--count];
		
		//��������֪ͨ����������
		this.notifyAll();
		return chicken;
	}
}





