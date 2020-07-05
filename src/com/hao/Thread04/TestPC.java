package com.hao.Thread04;


//测试：生产者消费者模型--》利用缓冲区解决：管程法
public class TestPC {
	public static void main(String[] args) {
		SynContainer container = new SynContainer();
		new Producer(container).start();
		new Consumer(container).start();
	}
}


//生产者
class Producer extends Thread{
	SynContainer container;
	
	public Producer(SynContainer container) {
		this.container = container;
	}
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("生产了"+i+"只鸡");
			container.push(new Chicken(i));
		}
	}
	
	
	
}

//消费者
class Consumer extends Thread{
	SynContainer container;
	
	public Consumer(SynContainer container) {
		this.container = container;
	}
	
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("消费了第"+container.pop().id+"只鸡");
		}
	}
	
}

//产品
class Chicken{
	int id;
	public Chicken(int id) {
		this.id = id;
	}
}

//临界区
class SynContainer{
	
	//容器计数器
	int count = 0;
	
	//需要一个容器大小
	Chicken[] chickens = new Chicken[10];
	
	//判断count ==10或0的那一句，最好不要用if，
	//应该用while，否则当有多个消费者的时候，会出现脏判断的
	
	//生产者放入产品
	public synchronized void push(Chicken chicken) {
		//如果容器满了，就等待消费者消费
		if(count==chickens.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//如果没有满，我们就需要丢入产品
		chickens[count++]=chicken;
		
		//可以通知消费者消费了
		this.notifyAll();
		
	}
	
	//消费者消费产品
	public synchronized Chicken pop() {
		if(count==0) {
			//等待生产者生产，消费者等待
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//如果可以消费
		Chicken chicken = chickens[--count];
		
		//吃完啦，通知生产者生产
		this.notifyAll();
		return chicken;
	}
}





