package cn.xxs.dao;

import java.util.List;

import cn.xxs.entity.Room;
import cn.xxs.entity.User;

public interface RoomDao {
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
	/*
	 * 根据会议室地点查询会议室
	 */
	Room select(String roomlocation);

}
