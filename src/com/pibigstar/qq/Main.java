package com.pibigstar.qq;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.pibigstar.qq.domain.User;
import com.pibigstar.qq.main.FindByKeys;
import com.pibigstar.qq.main.GetAllUser;
import com.pibigstar.qq.main.GetInfo;
import com.pibigstar.qq.utils.ExportExcelUtil;
import com.pibigstar.qq.utils.GetCookies;

public class Main {
	
	public static void main(String[] args) throws IOException{
		// 1. 从文件中读取cookies
		String cookie = GetCookies.getCookieFromFile();
		Map<String,String> cookies = GetCookies.getCookies(cookie);
		
		// 2. 拿到所有的user
		List<User> users = GetAllUser.getAll(cookies);
		// 3. 为每个user设置信息
		for (User user : users) {
			User info = GetInfo.getInfo(user.getData(), cookies);
			info.setLabel(user.getLabel());
		}
		// 4. 导出到excel
		ExportExcelUtil.export(users);
		
	}
}
