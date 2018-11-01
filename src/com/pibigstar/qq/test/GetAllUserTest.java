package com.pibigstar.qq.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.pibigstar.qq.domain.User;
import com.pibigstar.qq.main.GetAllUser;
import com.pibigstar.qq.main.GetInfo;
import com.pibigstar.qq.utils.GetCookies;

public class GetAllUserTest {

	public static void main(String[] args) throws IOException {
		String cookie = "pgv_pvi=1058476032; RK=zYJlbAoRTX; tvfe_boss_uuid=9a4adc259494c16c; __guid=152210621.3601331899232616400.1535638382858.744; QZ_FE_WEBP_SUPPORT=1; __Q_w_s_hat_seed=1; ptcz=92d102881bb722e6f5cae9982e1a870110c54b422371de1db9986c4d9b5477ff; pt2gguin=o0741047261; o_cookie=741047261; pgv_pvid=5440031152; pgv_si=s8860481536; _qpsvr_localtk=0.4752981621065406; ptisp=cnc; pgv_info=ssid=s6435035642; Loading=Yes; welcomeflash=741047261_48260; qqmusic_uin=; qqmusic_key=; qqmusic_fromtag=; qz_screen=1920x1080; 741047261_todaycount=3; 741047261_totalcount=18821; uin=o0741047261; skey=@isshkgv4L; p_uin=o0741047261; cpu_performance_v8=6; pt4_token=UpZ7Uy3GzTwc2I93gclD56xK7DkOODFNzPrE8bRPwvY_; p_skey=rnUwXyyIiUqqRf9hKBrjDWqrzvZeQIRGrr-RT68dwX0_; monitor_count=3; qzmusicplayer=qzone_player_741047261_1540997994050";
		Map<String, String> cookies = GetCookies.parseCookie(cookie);
		List<User> users = GetAllUser.getAll(cookies);
		for (User user : users) {
			GetInfo.getInfo(user.getData(), cookies);
		}
	}
}
