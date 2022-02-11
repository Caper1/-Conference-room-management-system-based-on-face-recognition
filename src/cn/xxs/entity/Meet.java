package cn.xxs.entity;

import java.util.Date;
import java.util.List;

public class Meet {
	private int id;
	private String meetname;
	private String meetlocation;
	private String meetsqr;
	private String meetcontext;
	private String meetjoin;
	private Date meetstarttime;
	private Date meetendtime;
	private int shstatus;
	private int meetstatus;
	private String yuanyin;
	private String meetstatus1;
	private String qdname;
	private int qdstatus;
	private String qingjiayuanyin;
	
	
	private int mycount;
	private int canyucount;

	
	public Meet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public Meet(int id, String meetname, String meetlocation, String meetsqr,
			String meetcontext, String meetjoin, Date meetstarttime,
			Date meetendtime, int shstatus, int meetstatus, String yuanyin,
			String meetstatus1) {
		super();
		this.id = id;
		this.meetname = meetname;
		this.meetlocation = meetlocation;
		this.meetsqr = meetsqr;
		this.meetcontext = meetcontext;
		this.meetjoin = meetjoin;
		this.meetstarttime = meetstarttime;
		this.meetendtime = meetendtime;
		this.shstatus = shstatus;
		this.meetstatus = meetstatus;
		this.yuanyin = yuanyin;
		this.meetstatus1 = meetstatus1;
	}




	@Override
	public String toString() {
		return "Meet [id=" + id + ", meetname=" + meetname + ", meetlocation="
				+ meetlocation + ", meetsqr=" + meetsqr + ", meetcontext="
				+ meetcontext + ", meetjoin=" + meetjoin + ", meetstarttime="
				+ meetstarttime + ", meetendtime=" + meetendtime
				+ ", shstatus=" + shstatus + ", meetstatus=" + meetstatus
				+ ", yuanyin=" + yuanyin + ", meetstatus1=" + meetstatus1 + "]";
	}




	public String getMeetname() {
		return meetname;
	}
	public void setMeetname(String meetname) {
		this.meetname = meetname;
	}
	public String getMeetlocation() {
		return meetlocation;
	}
	public void setMeetlocation(String meetlocation) {
		this.meetlocation = meetlocation;
	}
	public String getMeetsqr() {
		return meetsqr;
	}
	public void setMeetsqr(String meetsqr) {
		this.meetsqr = meetsqr;
	}
	public String getMeetcontext() {
		return meetcontext;
	}
	public void setMeetcontext(String meetcontext) {
		this.meetcontext = meetcontext;
	}
	public String getMeetjoin() {
		return meetjoin;
	}
	public void setMeetjoin(String meetjoin) {
		this.meetjoin = meetjoin;
	}
	public Date getMeetstarttime() {
		return meetstarttime;
	}
	public void setMeetstarttime(Date meetstarttime) {
		this.meetstarttime = meetstarttime;
	}
	public Date getMeetendtime() {
		return meetendtime;
	}
	public void setMeetendtime(Date meetendtime) {
		this.meetendtime = meetendtime;
	}
	public int getShstatus() {
		return shstatus;
	}
	public void setShstatus(int shstatus) {
		this.shstatus = shstatus;
	}
	public int getMeetstatus() {
		return meetstatus;
	}
	public void setMeetstatus(int meetstatus) {
		this.meetstatus = meetstatus;
	}
	public String getYuanyin() {
		return yuanyin;
	}
	public void setYuanyin(String yuanyin) {
		this.yuanyin = yuanyin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}




	public String getMeetstatus1() {
		return meetstatus1;
	}




	public void setMeetstatus1(String meetstatus1) {
		this.meetstatus1 = meetstatus1;
	}









	public String getQdname() {
		return qdname;
	}




	public void setQdname(String qdname) {
		this.qdname = qdname;
	}




	public int getQdstatus() {
		return qdstatus;
	}




	public void setQdstatus(int qdstatus) {
		this.qdstatus = qdstatus;
	}




	public String getQingjiayuanyin() {
		return qingjiayuanyin;
	}




	public void setQingjiayuanyin(String qingjiayuanyin) {
		this.qingjiayuanyin = qingjiayuanyin;
	}




	public int getCanyucount() {
		return canyucount;
	}




	public void setCanyucount(int canyucount) {
		this.canyucount = canyucount;
	}




	public int getMycount() {
		return mycount;
	}




	public void setMycount(int mycount) {
		this.mycount = mycount;
	}
	
	

}
