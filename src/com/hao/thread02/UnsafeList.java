package com.hao.thread02;

import java.util.List;
import java.util.ArrayList;


//线程不安全的集合
public class UnsafeList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10000; i++) {
			new Thread(() -> {
				list.add(Thread.currentThread().getName());
			}).start();
		}
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list.size());
	}
}
