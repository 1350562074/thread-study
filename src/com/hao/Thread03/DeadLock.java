package com.hao.Thread03;

//死锁：多个线程互相抱着对方需要的资源，然后形成僵持
public class DeadLock {
	public static void main(String[] args) {
		Makeup g1 = new Makeup(0, "灰姑娘");
		Makeup g2 = new Makeup(1, "白雪公主");
		
		g1.start();
		g2.start();
	}
}

//口红

class Lipstick{
	
}

//镜子

class Mirror{
	
}

//化妆

class Makeup extends Thread{
	
	//只有一份资源，要设置为静态变量
	static Lipstick lipstick = new Lipstick();
	static Mirror mirror = new Mirror();
	
	int choice; //选择
	String girlName;//使用化妆品的人
	
	Makeup(int choice,String girlName){
		this.choice = choice;
		this.girlName = girlName;
	}
	
	
	//化妆
	@Override
	public void run() {
		try {
			makeup();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//死锁，锁中锁 
//	private void makeup() throws InterruptedException {
//		if(choice == 0) {
//			synchronized (lipstick) {//获得口红的锁
//				System.out.println(this.girlName+"获得口红的锁");
//				Thread.sleep(1000);
//				synchronized (mirror) {//一秒钟后想获得镜子
//					System.out.println(this.girlName+"获得镜子的锁");
//					
//				}
//			}
//			
//		}else {
//			synchronized (mirror) {//获得镜子的锁
//				System.out.println(this.girlName+"获得镜子的锁");
//				Thread.sleep(2000);
//				synchronized (lipstick) {//一秒钟后想获得口红
//					System.out.println(this.girlName+"获得口红的锁");
//					
//				}
//			}
//			
//		}
//	}
//	
	
	//同步块的锁，同步块结束了就释放锁
	private void makeup() throws InterruptedException {
		if(choice == 0) {
			synchronized (lipstick) {//获得口红的锁
				System.out.println(this.girlName+"获得口红的锁");
				Thread.sleep(1000);
				
			}
			synchronized (mirror) {//一秒钟后想获得镜子
				System.out.println(this.girlName+"获得镜子的锁");
				
			}
		}else {
			synchronized (mirror) {//获得镜子的锁
				System.out.println(this.girlName+"获得镜子的锁");
				Thread.sleep(2000);
				
			}
			synchronized (lipstick) {//一秒钟后想获得口红
				System.out.println(this.girlName+"获得口红的锁");
				
			}
		}
	}
}

