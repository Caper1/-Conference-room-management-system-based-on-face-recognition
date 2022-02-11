package cn.xxs.entity;

import java.util.Date;

public class User {
	private int id; //员工账号
	private String name; //员工姓名
	private String sex;
	private String tel;
	private String email; //员工邮箱
	private String bumen; //员工所在部门
	private String zhiwei; //员工职位
	private Date time; //员工入职时间
	private String password;
	private String identity;
	private Sign sign;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	



	@Override
	public String toString() {
		return "{id:" + id + ", name:" + name + ", sex:" + sex + ", tel:"
				+ tel + ", email:" + email + ", bumen:" + bumen + ", zhiwei:"
				+ zhiwei + ", time:" + time + ", password:" + password
				+ ", identity:" + identity + "}";
	}






	public User(int id, String name,String sex,String tel,String email, String bumen,String zhiwei,Date time,Sign sign) {
		super();
		this.id = id;
		this.name = name;
		this.sex=sex;
		this.tel=tel;
		this.email=email;
		this.bumen = bumen;
		this.zhiwei = zhiwei;
		this.time = time;
		this.sign=sign;
	}

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBumen() {
		return bumen;
	}
	public void setBumen(String bumen) {
		this.bumen = bumen;
	}
	public String getZhiwei() {
		return zhiwei;
	}
	public void setZhiwei(String zhiwei) {
		this.zhiwei = zhiwei;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	
	public Sign getSign() {
		return sign;
	}
	public void setSign(Sign sign) {
		this.sign = sign;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	
}
