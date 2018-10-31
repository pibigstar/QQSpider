package com.pibigstar.qq.domain;

public class User {
	
	private String data;//QQ号
	
	private String label;//用户名/备注名
	
	private String nick;//昵称
	
	private String gender;//性别 1为男  2为女
	
	private String city;//城市
	
	private String country;//国家
	
	private String lnick;//个性签名
	
	private String personal;//个人说明
	
	private String college;//学校
	
	private String birthday;//生日
	
	private String email;//邮箱
	
	private String phone;//手机
	
	private String uin;//qq号
	
	private int age;
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUin() {
		return uin;
	}

	public void setUin(String uin) {
		this.uin = uin;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLnick() {
		return lnick;
	}

	public void setLnick(String lnick) {
		this.lnick = lnick;
	}

	public String getPersonal() {
		return personal;
	}

	public void setPersonal(String personal) {
		this.personal = personal;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [data=" + data + ", label=" + label + ", nick=" + nick + ", gender=" + gender + ", city=" + city
				+ ", country=" + country + ", lnick=" + lnick + ", personal=" + personal + ", college=" + college
				+ ", birthday=" + birthday + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
}
