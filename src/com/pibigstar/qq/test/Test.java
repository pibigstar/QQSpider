package com.pibigstar.qq.test;

public class Test {

	public static void main(String[] args) {
		String path = System.getProperty("java.class.path");
		String realPath = path.substring(0, path.indexOf(";"));
		System.out.println(realPath);
		System.out.println(System.getProperty("usr.dir"));
	}
}
