package com.pibigstar.qq.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetCookies {
	/**
	 * pgv_pvi=5227500544; RK=GQJtLCoRSV; tvfe_boss_uuid=daf9a35117336575; pgv_pvid=5936885738; o_cookie=741047261; pgv_info=ssid=s5041028400; ptisp=cm; ptcz=540aecb6ba95de3a86e3526e25ca838045d8333519e4bc416f6f49f7620f1ded; uin=o0741047261; skey=@iXy6ox3Vn; pt2gguin=o0741047261; p_uin=o0741047261; pt4_token=3QnUa*i4gfFsuPEp54NAlzt1EcZUfuOGz*7mIlslUfM_; p_skey=zaEhoSBPPHq7HJVzcG8876wt1Mlu2cv1gGU-DBBJRGA_; qzspeedup=sdch; Loading=Yes; qqmusic_uin=; qqmusic_key=; qqmusic_fromtag=; qzmusicplayer=qzone_player_741047261_1529889163687; QZ_FE_WEBP_SUPPORT=1; cpu_performance_v8=1; __Q_w_s__QZN_TodoMsgCnt=1
	 * @param cookie
	 * @return
	 */
	public static Map<String, String> getCookies(String cookie){
		if (cookie==null||cookie.length()==0) {
			return null;
		}
		Map<String, String> cookies = new HashMap<>();
		String[] strCookie = cookie.split(";");
		for (String string : strCookie) {
			String[] split = string.split("=");
			if (split.length==2) {
				String name =split[0].trim();
				String value = split[1].trim();
				cookies.put(name, value);
			}

		}
		return cookies;
	}

	public static String getCookieFromFile() throws IOException {
		File file = new File("conf.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp,cookies = ""; 

		while((temp=br.readLine())!=null){
			cookies+=temp;
		}
		System.out.println(cookies);
		return cookies;
	}
}
