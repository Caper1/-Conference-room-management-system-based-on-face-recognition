package cn.xxs.service;

import java.util.List;

import cn.xxs.entity.Meet;
import cn.xxs.entity.Sign;

public interface SignService {
	/*
	 * 添加信息
	 */
	void add(Sign s);
	/*
	 * 根据名字查询信息
	 *
	 */
	Sign select(String name);
	
	/*
	 * 根据meetid字段查询信息
	 */
	List<Sign> select(int meetid);
	/*
	 * 更新会议信息
	 */
	Sign update(Sign s);
	/*
	 * 根据userid查询信息
	 */
	Sign select2(int userid);
	/*
	 * 根据 qingjianame和meetid更新签到表
	 */
	Sign update2(Sign s);
	/*
	 * 根据 name 和meetid查询唯一一条
	 */
	Sign select(String name,int meetid);
}
