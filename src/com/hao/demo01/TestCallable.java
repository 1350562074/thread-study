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

//线程创建方式三：实现callable接口
/*
 * callable的好处
 * 1.可以定义返回值
 * 2.可以抛出
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
		System.out.println("下载了文件名为："+ name);
		return true;
	}
	
	
	public static void main(String[] args) throws  Exception {
		TestCallable t1 = new TestCallable("https://img-blog.csdnimg.cn/20200410214711397.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwNTMxNDc5,size_16,color_FFFFFF,t_70", "1.jpg");
		TestCallable t2 = new TestCallable("https://img-blog.csdnimg.cn/20200410215012896.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwNTMxNDc5,size_16,color_FFFFFF,t_70", "2.jpg");
		TestCallable t3 = new TestCallable("https://img-blog.csdnimg.cn/2020041021502615.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQwNTMxNDc5,size_16,color_FFFFFF,t_70", "3.jpg");
		
		//创建执行服务：
		ExecutorService ser = Executors.newFixedThreadPool(3);
		//提交执行
		Future<Boolean> r1 = ser.submit(t1);
		Future<Boolean> r2 = ser.submit(t2);
		Future<Boolean> r3 = ser.submit(t3);
		
		//获取结果
		boolean rs1 = r1.get();
		boolean rs2 = r2.get();
		boolean rs3 = r3.get();
		
		//关闭服务
		ser.shutdownNow();
	}
	
	
	

}
