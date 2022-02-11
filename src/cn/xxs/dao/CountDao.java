package cn.xxs.dao;

import java.util.List;

import cn.xxs.entity.Count;

public interface CountDao {
	/**
	 * 对用户的会议进行统计 
	 */
	List<Count> meetcount(int method);
	
	/*
	 * 对考勤进行统计
	 */
	List<Count> kaoqincount(int method,String name);
	
	/*
	 * 对会议室进行统计
	 */
	List<Count> meetroomcount();
	/*
	 * 统计各个人员考勤
	 */
	List<Count> renyuankaoqin();

}
