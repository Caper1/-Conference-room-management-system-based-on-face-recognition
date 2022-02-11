package cn.xxs.entity;

public class Count {
	private String CODE;
	private long mycount;  //我发起的狐疑
	private long joincount; //我参加的会议
	
	private long queqin;
	private long normal;
	private long qingjia;
	private long chidao;
	
	
	private String meetlocation;
	private long meetsum;
	
	
	private String qdname;
	private long user_id;
	
	public Count() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Count(String CODE, long mycount, long joincount) {
		super();
		this.CODE = CODE;
		this.mycount = mycount;
		this.joincount = joincount;
	}
	@Override
	public String toString() {
		return "{CODE:" + CODE + ", mycount:" + mycount + ", joincount:"
				+ joincount + "}";
	}
	public String getCODE() {
		return CODE;
	}
	public void setCODE(String CODE) {
		this.CODE = CODE;
	}
	public long getMycount() {
		return mycount;
	}
	public void setMycount(long mycount) {
		this.mycount = mycount;
	}
	public long getJoincount() {
		return joincount;
	}
	public void setJoincount(long joincount) {
		this.joincount = joincount;
	}
	public long getQueqin() {
		return queqin;
	}
	public void setQueqin(long queqin) {
		this.queqin = queqin;
	}
	public long getNormal() {
		return normal;
	}
	public void setNormal(long normal) {
		this.normal = normal;
	}
	public long getQingjia() {
		return qingjia;
	}
	public void setQingjia(long qingjia) {
		this.qingjia = qingjia;
	}
	public long getChidao() {
		return chidao;
	}
	public void setChidao(long chidao) {
		this.chidao = chidao;
	}
	public String getMeetlocation() {
		return meetlocation;
	}
	public void setMeetlocation(String meetlocation) {
		this.meetlocation = meetlocation;
	}
	public long getMeetsum() {
		return meetsum;
	}
	public void setMeetsum(long meetsum) {
		this.meetsum = meetsum;
	}
	public String getQdname() {
		return qdname;
	}
	public void setQdname(String qdname) {
		this.qdname = qdname;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	
	

}
