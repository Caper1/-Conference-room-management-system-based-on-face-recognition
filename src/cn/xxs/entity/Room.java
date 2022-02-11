package cn.xxs.entity;

import java.util.Date;

public class Room {
	private String roomname;
	private String roomlocation;
	private String roomcap;
	private int roomstatus;
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Room(String roomname, String roomlocation, String roomcap, int roomstatus) {
		super();
		this.roomname = roomname;
		this.roomlocation = roomlocation;
		this.roomcap = roomcap;
		this.setRoomstatus(roomstatus);
	}

	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}
	public String getRoomlocation() {
		return roomlocation;
	}
	public void setRoomlocation(String roomlocation) {
		this.roomlocation = roomlocation;
	}
	public String getRoomcap() {
		return roomcap;
	}
	public void setRoomcap(String roomcap) {
		this.roomcap = roomcap;
	}

	public int getRoomstatus() {
		return roomstatus;
	}

	public void setRoomstatus(int roomstatus) {
		this.roomstatus = roomstatus;
	}
	

}
