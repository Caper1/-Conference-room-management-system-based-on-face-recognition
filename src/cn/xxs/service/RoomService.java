package cn.xxs.service;

import java.util.List;

import cn.xxs.entity.Room;

public interface RoomService {
	/*
	 * 查询会议所有信息
	 */
	List<Room> selectAll();
	
	/*
	 * 根据会议id查询员工的考勤信息
	 */
	Room select(int id);
	
	/*
	 * 添加员工信息
	 */
	void add(Room c);
	
	/*
	 * 删除会议信息
	 */
	Room delete(int id);
	
	/*
	 * 更新客户信息
	 */
	
	Room update(Room c);

	
	Room select(String roomlocation);
}
