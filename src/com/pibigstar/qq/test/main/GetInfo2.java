package com.pibigstar.qq.test.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.pibigstar.qq.domain.User;
import com.pibigstar.qq.utils.GetTk;
import com.pibigstar.qq.utils.JSONUtil;

public class GetInfo2 implements Callable<User>{
	
	private Map<String, String> cookies;
	private String qq;
	private User user;
	public GetInfo2(Map<String, String> cookies, User user) {
		this.cookies = cookies;
		this.user = user;
		this.qq = user.getData();
	}

	@Override
	public User call() throws Exception {
		Map<String, String> data = new HashMap<>();
		//注意这里，获得信息是用的skey 而获得全部好友使用的为p_skey
		String skey = cookies.get("skey");
		String g_tk = GetTk.getTk(skey);
		
		data.put("keyword", qq);
		data.put("ldw", g_tk);
		
		Document document;
		try {
			document = Jsoup.connect("http://cgi.find.qq.com/qqfind/buddy/search_v3").cookies(cookies).header("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").ignoreContentType(true).data(data).timeout(10000).post();
			String allJson = document.getElementsByTag("body").text();
			JSONObject result = (JSONObject) new JSONObject(allJson).get("result");
			JSONObject buddy = (JSONObject) result.get("buddy");
			JSONArray jsonArray = buddy.getJSONArray("info_list");
			
			JSONObject dataJson = (JSONObject) jsonArray.get(0);
			user = JSONUtil.jSONToObject(dataJson.toString(), User.class);
			JSONObject birthdayJson = (JSONObject) dataJson.get("birthday");
			String year = birthdayJson.get("year").toString();
			String month = birthdayJson.get("month").toString();
			String day = birthdayJson.get("day").toString();
			String birthday = year+"-"+month+"-"+day;
			user.setBirthday(birthday);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return user;
	}

}
