package com.pibigstar.qq.test.main;

import com.pibigstar.qq.domain.User;

public class FindByKeys2 {

	public static void find(User user,User my){
		if (user.getGender()==null||user.getAge()==0) {
			return;
		}
		if (my.getAge()!=user.getAge()) {
			return;
		}
		if (!user.getGender().equals(my.getGender())) {
			return;
		}
		System.out.println(user);
	}
}
