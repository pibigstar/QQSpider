package com.pibigstar.qq.test.main;

import java.util.Calendar;

import com.pibigstar.qq.utils.GetTk;

public class Test {
	
	public static void main(String[] args) {
		
//		String tk = GetTk.getTk("@iXy6ox3Vn");
//		System.out.println(tk);
		Calendar calendar = Calendar.getInstance();
		int now = calendar.get(Calendar.YEAR);
		System.out.println(now);
	}

}
