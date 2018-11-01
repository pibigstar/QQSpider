package com.pibigstar.qq;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.pibigstar.qq.domain.User;
import com.pibigstar.qq.main.GetAllUser;
import com.pibigstar.qq.main.GetInfo;
import com.pibigstar.qq.utils.ExportExcelUtil;
import com.pibigstar.qq.utils.GetCookies;

import javax.swing.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		// 1. 从文件中读取cookies
		String cookie = GetCookies.getCookieFromFile();
		Map<String,String> cookies = GetCookies.parseCookie(cookie);
		
		// 2. 拿到所有的user
		List<User> users = GetAllUser.getAll(cookies);
		List<User> newUsers = new ArrayList<>();
		// 3. 为每个user设置信息
		for (User user : users) {
			User newUser = GetInfo.getInfo(user.getData(), cookies);
			newUser.setData(user.getData());
			newUser.setLabel(user.getLabel());
			newUsers.add(newUser);
			System.out.println(newUser);
		}
		// 4. 导出到excel
		ExportExcelUtil.export(newUsers);
		JOptionPane.showMessageDialog(null,"导出成功");
	}
}
