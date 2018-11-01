package com.pibigstar.qq.test.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.pibigstar.qq.domain.User;
import com.pibigstar.qq.main.GetAllUser;
import com.pibigstar.qq.utils.GetCookies;

public class Main2 {
	
	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		String cookie = "pgv_pvi=5227500544; RK=GQJtLCoRSV; tvfe_boss_uuid=daf9a35117336575; o_cookie=741047261; qzspeedup=sdch; __Q_w_s__QZN_TodoMsgCnt=1; rv2=80B875CD99ECA742FBE1C7CE46BD4A331070FC3F07A59C82F9; property20=EDE2570C27AEB666C12D6311DC69A7F11B4CC033B3F0B407CF903C906E52868951F88CFAF562AE50; pgv_si=s9643558912; pgv_info=ssid=s5041028400; pgv_pvid=5936885738; 741047261_todaycount=1; 741047261_totalcount=18763; qz_screen=1920x1080; QZ_FE_WEBP_SUPPORT=1; qqmusic_uin=; qqmusic_key=; qqmusic_fromtag=; qzmusicplayer=qzone_player_741047261_1529898715869; cpu_performance_v8=60; ptisp=cm; ptcz=540aecb6ba95de3a86e3526e25ca838045d8333519e4bc416f6f49f7620f1ded; uin=o0741047261; skey=@iXy6ox3Vn; pt2gguin=o0741047261; p_uin=o0741047261; pt4_token=5LmvpRxu8kWi3*w38m5C8c28ip0hIaHpnxFFhO0gsTE_; p_skey=KsYoqBbOgzv79z9lQP2wA61Ye51AIpDeEUnyCj35Ocs_; Loading=Yes";
		Map<String, String> cookies = GetCookies.parseCookie(cookie);
		List<User> users = GetAllUser.getAll(cookies);
		ExecutorService executor = Executors.newCachedThreadPool();
		List<Future<User>> futures = new ArrayList<>();
		for (User user : users) {
			GetInfo2 getInfo = new GetInfo2(cookies, user);
			Future<User> submit = executor.submit(getInfo);
			futures.add(submit);
		}
		User user = new User();
		user.setAge(19);
		user.setGender("2");
		for (Future<User> future : futures) {
			FindByKeys2.find(future.get(), user);
		}
	}
}
