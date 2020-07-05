package com.hao.proxystatic;


//��̬����ģʽ�ܽ᣺
// ��ʵ����ʹ������Ҫʵ��ͬһ���ӿ�
//�������Ҫ������ʵ��ɫ

//�ô���
//�������������ܶ���ʵ���������˵�����
//��ʵ����רע���Լ�������
public class StaticProxy {
	public static void main(String[] args) {
		weddingCompany weddingCompany = new weddingCompany(new You());
		weddingCompany.HappyMarry();
	
		new weddingCompany(new You()).HappyMarry();
		new Thread(()->System.out.println("�Ұ���")).start();
	}

}

interface Marry{
	//�˼��Ĵ�ϲ�£��ú����¶����������֪����������ҹ���������ʱ
	void HappyMarry();
}

//��ʵ��ɫ
class You implements Marry{
	@Override
	public void HappyMarry() {
		System.out.println("����ʦҪ����ˣ�������");
	}
}

//�����ɫ
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
		System.out.println("���֮ǰ�������ֳ�");
	}
	public void after() {
		System.out.println("���֮����β��");
	}
}