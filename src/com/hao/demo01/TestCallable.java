package com.hao.demo01;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//�̴߳�����ʽ����ʵ��callable�ӿ�
/*
 * callable�ĺô�
 * 1.���Զ��巵��ֵ
 * 2.�����׳�
 */
import org.apache.commons.io.FileUtils;

public class TestCallable implements Callable<Boolean>{
	
	
	private String url;
	private String name;
	
	public TestCallable(String url, String name) {
		this.url = url;
		this.name = name;
	}
	
	@Override
	public Boolean call() throws Exception {
		WebDownloader webDownloader = new WebDownloader();
		webDownloader.downloader(url, name);
		System.out.println("�������ļ���Ϊ��"+ name);
		return true;
	}
	
	
	public static void main(String[] args) throws  Exception {
		TestCallable t1 = new TestCallable("https://img-blog.csdnimg.cn/20200410214711397.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwNTMxNDc5,size_16,color_FFFFFF,t_70", "1.jpg");
		TestCallable t2 = new TestCallable("https://img-blog.csdnimg.cn/20200410215012896.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwNTMxNDc5,size_16,color_FFFFFF,t_70", "2.jpg");
		TestCallable t3 = new TestCallable("https://img-blog.csdnimg.cn/2020041021502615.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwNTMxNDc5,size_16,color_FFFFFF,t_70", "3.jpg");
		
		//����ִ�з���
		ExecutorService ser = Executors.newFixedThreadPool(3);
		//�ύִ��
		Future<Boolean> r1 = ser.submit(t1);
		Future<Boolean> r2 = ser.submit(t2);
		Future<Boolean> r3 = ser.submit(t3);
		
		//��ȡ���
		boolean rs1 = r1.get();
		boolean rs2 = r2.get();
		boolean rs3 = r3.get();
		
		//�رշ���
		ser.shutdownNow();
	}
	
	
	

}
