package com.hao.lambda;

import java.lang.invoke.LambdaConversionException;

//�Ƶ�lambda���ʽ
public class TestLambda1 {

	//3.��̬�ڲ���
	static class Like2 implements ILike{
		@Override
		public void lambda() {
			// TODO Auto-generated method stub
			System.out.println("I like lambda2");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ILike like = new Like();
		like.lambda();
		
		like = new Like2();
		like.lambda();
		
		//4.�ֲ��ڲ���
		class Like3 implements ILike{
			@Override
			public void lambda() {
				// TODO Auto-generated method stub
				System.out.println("I like lambda3");
			}
		}
		
		like = new Like3();
		like.lambda();
		
		//5.�����ڲ���
		like = new ILike() {
			@Override
			public void lambda() {
				System.out.println("I like lambda4");
			}
		};
		like.lambda();
		
		
		//6.��lambda��
		like = () -> {
			System.out.println("I like lambda5");
		};
		
		like.lambda();
	}

}

//1.����һ������ʽ�ӿ�
interface ILike{
	void lambda();
}

//2.ʵ����
class Like implements ILike{
	@Override
	public void lambda() {
		// TODO Auto-generated method stub
		System.out.println("I like lambda");
	}
}