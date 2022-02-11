package cn.xxs.entity;

import java.util.Date;

public class Sign {
	private int signid;
	private int user_id;
	private int meet_id;
	private int qdstatus;
	private String qdtime;
	private String qdname;
	private String qdtel;
	private String qdbumen;
	private String qingjiayuanyin;
	
	public Sign() {
		super();
		
	}
	
	public Sign(int signid, int user_id, int meet_id, int qdstatus,
			String qdtime, String qdname, String qdtel, String qdbumen,
			String qingjiayuanyin) {
		super();
		this.signid = signid;
		this.user_id = user_id;
		this.meet_id = meet_id;
		this.qdstatus = qdstatus;
		this.qdtime = qdtime;
		this.qdname = qdname;
		this.qdtel = qdtel;
		this.qdbumen = qdbumen;
		this.qingjiayuanyin = qingjiayuanyin;
	}

	@Override
	public String toString() {
		return "Sign [signid=" + signid + ", user_id=" + user_id + ", meet_id="
				+ meet_id + ", qdstatus=" + qdstatus + ", qdtime=" + qdtime
				+ ", qdname=" + qdname + ", qdtel=" + qdtel + ", qdbumen="
				+ qdbumen + ", qingjiayuanyin=" + qingjiayuanyin + "]";
	}

	public int getSignid() {
		return signid;
	}
	public void setSignid(int signid) {
		this.signid = signid;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getMeet_id() {
		return meet_id;
	}
	public void setMeet_id(int meet_id) {
		this.meet_id = meet_id;
	}
	public int getQdstatus() {
		return qdstatus;
	}
	public void setQdstatus(int qdstatus) {
		this.qdstatus = qdstatus;
	}
	public String getQdtime() {
		return qdtime;
	}
	public void setQdtime(String qdtime) {
		this.qdtime = qdtime;
	}
	public String getQdname() {
		return qdname;
	}
	public void setQdname(String qdname) {
		this.qdname = qdname;
	}
	public String getQdtel() {
		return qdtel;
	}
	public void setQdtel(String qdtel) {
		this.qdtel = qdtel;
	}
	public String getQdbumen() {
		return qdbumen;
	}
	public void setQdbumen(String qdbumen) {
		this.qdbumen = qdbumen;
	}
	public String getQingjiayuanyin() {
		return qingjiayuanyin;
	}
	public void setQingjiayuanyin(String qingjiayuanyin) {
		this.qingjiayuanyin = qingjiayuanyin;
	}
	

}
