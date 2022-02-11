package cn.xxs.service.impl;

import java.util.List;

import cn.xxs.dao.RoomDao;
import cn.xxs.dao.impl.RoomDaoImpl;
import cn.xxs.entity.Room;
import cn.xxs.service.RoomService;

public class RoomServiceImpl implements RoomService {
	RoomDao dao=new RoomDaoImpl();

	@Override
	public List<Room> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
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
		return dao.update(c);
	}
	@Override
	public Room select(String roomlocation) {
		// TODO Auto-generated method stub
		return dao.select(roomlocation);
	}
	

}
