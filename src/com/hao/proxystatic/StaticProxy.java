package com.hao.proxystatic;


//静态代理模式总结：
// 真实对象和代理对象都要实现同一个接口
//代理对象要代理真实角色

//好处：
//代理对象可以做很多真实对象做不了的事情
//真实对象专注做自己的事情
public class StaticProxy {
	public static void main(String[] args) {
		weddingCompany weddingCompany = new weddingCompany(new You());
		weddingCompany.HappyMarry();
	
		new weddingCompany(new You()).HappyMarry();
		new Thread(()->System.out.println("我爱你")).start();
	}

}

interface Marry{
	//人间四大喜事，久旱逢甘露，他乡遇故知，洞房花烛夜，金榜题名时
	void HappyMarry();
}

//真实角色
class You implements Marry{
	@Override
	public void HappyMarry() {
		System.out.println("秦老师要结婚了，超开心");
	}
}

//代理角色
class weddingCompany implements Marry{
	
	private Marry target;
	
	public weddingCompany(Marry target) {
		this.target = target;
	}
	@Override
	public void HappyMarry() {
		before();
		this.target.HappyMarry();
		after();
	}
	
	public void before() {
		System.out.println("结婚之前，布置现场");
	}
	public void after() {
		System.out.println("结婚之后，收尾款");
	}
}