package cn.xxs.entity;

public class Depart {
	private int departid;
	private String departname;
	private int departnum;
	public int getDepartid() {
		return departid;
	}
	public void setDepartid(int departid) {
		this.departid = departid;
	}
	public String getDepartname() {
		return departname;
	}
	public void setDepartname(String departname) {
		this.departname = departname;
	}
	public int getDepartnum() {
		return departnum;
	}
	public void setDepartnum(int departnum) {
		this.departnum = departnum;
	}
	@Override
	public String toString() {
		return "Dpart [departid=" + departid + ", departname=" + departname
				+ ", departnum=" + departnum + "]";
	}
	public Depart(int departid, String departname, int departnum) {
		super();
		this.departid = departid;
		this.departname = departname;
		this.departnum = departnum;
	}
	public Depart() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
