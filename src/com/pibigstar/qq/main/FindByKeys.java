package com.pibigstar.qq.main;

import java.util.ArrayList;
import java.util.List;

import com.pibigstar.qq.domain.User;

public class FindByKeys {
	
	public static List<User> find(List<User> users,User my){
		List<User> myUsers = new ArrayList<>();
		for (User user : users) {
			if (user.getGender()==null||user.getAge()==0) {
				continue;
			}
			if (my.getAge()!=user.getAge()) {
				continue;
			}
			if (!user.getGender().equals(my.getGender())) {
				continue;
			}
			
			myUsers.add(user);
			System.out.println(user);
		}
		return myUsers;
	}

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
