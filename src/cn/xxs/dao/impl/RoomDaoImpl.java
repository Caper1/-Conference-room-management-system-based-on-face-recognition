package cn.xxs.dao.impl;

import java.util.List;

import cn.xxs.dao.BaseDao;
import cn.xxs.dao.RoomDao;
import cn.xxs.entity.Meet;
import cn.xxs.entity.Room;

public class RoomDaoImpl extends BaseDao<Room> implements RoomDao{

	@Override
	public List<Room> selectAll() {
		List<Room> list=queryList("select * from room");
		return list;
	}

	@Override
	public Room select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Room c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Room delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room update(Room c) {
		// TODO Auto-generated method stub
		update("update room set roomstatus=? where roomlocation=?",c.getRoomstatus(),c.getRoomlocation());
		return c;
	}

	@Override
	public Room select(String roomlocation) {
		Room r=queryOne("select * from room where roomlocation=?",roomlocation);
		return r;
	}
	

}
