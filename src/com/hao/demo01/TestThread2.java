package com.hao.demo01;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class TestThread2 extends Thread {
	
	
	private String url;
	private String name;
	
	public TestThread2(String url, String name) {
		this.url = url;
		this.name = name;
	}
	
	@Override
	public void run() {
		WebDownloader webDownloader = new WebDownloader();
		webDownloader.downloader(url, name);
		System.out.println("下载了文件名为："+ name);
	}
	
	public static void main(String[] args) {
		TestThread2 t1 = new TestThread2("https://img-blog.csdnimg.cn/20200410214711397.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwNTMxNDc5,size_16,color_FFFFFF,t_70", "1.jpg");
		TestThread2 t2 = new TestThread2("https://img-blog.csdnimg.cn/20200410215012896.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwNTMxNDc5,size_16,color_FFFFFF,t_70", "2.jpg");
		TestThread2 t3 = new TestThread2("https://img-blog.csdnimg.cn/2020041021502615.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwNTMxNDc5,size_16,color_FFFFFF,t_70", "3.jpg");
		
		
		//同时执行
		t1.start();
		t2.start();
		t3.start();
	}
	
	
	

}

class WebDownloader{
	
	public void downloader(String url, String name){
		try {
			FileUtils.copyURLToFile(new URL(url), new File(name));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO异常,downloader方法出现问题");
		}
		
	}
	
}