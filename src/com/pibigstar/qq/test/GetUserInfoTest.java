package com.pibigstar.qq.test;

import java.util.Map;
import com.pibigstar.qq.main.GetInfo;
import com.pibigstar.qq.utils.GetCookies;

public class GetUserInfoTest {
	
	public static void main(String[] args) {
		String cookie = "pgv_pvi=5227500544; RK=GQJtLCoRSV; tvfe_boss_uuid=daf9a35117336575; qzspeedup=sdch; __Q_w_s__QZN_TodoMsgCnt=1; rv2=80B875CD99ECA742FBE1C7CE46BD4A331070FC3F07A59C82F9; property20=EDE2570C27AEB666C12D6311DC69A7F11B4CC033B3F0B407CF903C906E52868951F88CFAF562AE50; pgv_si=s9643558912; 741047261_todaycount=1; 741047261_totalcount=18763; qqmusic_uin=; qqmusic_key=; qqmusic_fromtag=; qzmusicplayer=qzone_player_741047261_1529902249515; QZ_FE_WEBP_SUPPORT=1; qz_screen=1920x1080; cpu_performance_v8=30; pgv_info=ssid=s5041028400; pgv_pvid=5936885738; o_cookie=741047261; pac_uid=1_741047261; ptisp=cm; ptcz=540aecb6ba95de3a86e3526e25ca838045d8333519e4bc416f6f49f7620f1ded; uin=o0741047261; skey=@iXy6ox3Vn; pt2gguin=o0741047261; p_uin=o0741047261; pt4_token=c74qNPM0SU6I25dsyfU*-zCe7ZKxE1IFWljbQpn659s_; p_skey=JGGfev8-DAmnfA782zNHSvS*SZWShICaIx5Sq1-LZlA_; Loading=Yes";
		Map<String, String> cookies = GetCookies.getCookies(cookie);
		GetInfo.getInfo("741047261", cookies);
	}

}
