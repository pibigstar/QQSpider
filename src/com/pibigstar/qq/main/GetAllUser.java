package com.pibigstar.qq.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.pibigstar.qq.domain.User;
import com.pibigstar.qq.utils.GetCookies;
import com.pibigstar.qq.utils.GetTk;
import com.pibigstar.qq.utils.JSONUtil;

/**
 * 获取所有的QQ用户列表
 * @author pibigstar
 *
 */
public class GetAllUser {
	
	public static List<User> getAll(Map<String, String> cookies) throws IOException{
		List<User> allUser = new ArrayList<>();
		String qq = cookies.get("o_cookie");
		String pskey = cookies.get("p_skey");
		
		String g_tk = GetTk.getTk(pskey);
		
		for(int i=0;;) {
			Document document = Jsoup.connect("https://h5.qzone.qq.com/proxy/domain/base.qzone.qq.com/cgi-bin/right/get_entryuinlist.cgi?uin=741047261&fupdate=1&action=1&offset="+i+"&g_tk="+g_tk).cookies(cookies).header("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").timeout(10000).ignoreContentType(true).get();
			String strJson = document.getElementsByTag("body").text().replace("_Callback(", "").replace(");", "");
			JSONObject jsonObject = new JSONObject(strJson);
			String jsonData =((JSONObject) jsonObject.get("data")).get("uinlist").toString();
			List<User> users = JSONUtil.JSONToList(jsonData, User.class);
			if (users==null||users.size()==0) {
				break;
			}
			allUser.addAll(users);
			i+=50;
		}
		return allUser;
	}

}
