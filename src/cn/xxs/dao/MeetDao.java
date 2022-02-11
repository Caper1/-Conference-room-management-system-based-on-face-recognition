package cn.xxs.dao;
import java.util.Date;
import java.util.List;

import cn.xxs.entity.Meet;
import cn.xxs.entity.User;
public interface MeetDao {
	/*
	 * 会议查询
	 */
	List<Meet> selectAll();
	/*
	 * 会议申请，即申请插入
	 */
	void add(Meet m);
	
	/*
	 * 根据会议发起人名字查询 他所发起的会议
	 */
	List<Meet> selectbyName(String name,String meetlocation,String meetstarttime,String meetendtime);
	/*
	 * 根据会议id 判断点击哪一个并进行审核操作
	 */
	Meet select(int id);
	
	/*
	 * 更新会议信息
	 */
	Meet update(Meet m);
	
	/*
	 * 实现多条件查询
	 */
	List<Meet> findby(String meetsqr, String meetlocation,String meetsarttime,String meetendtime);
	
	/*
	 * 实现根据会议室地点 和加审核状态为11 查出一条或多条数据
	 */
	List<Meet> findbylocationstatus(String meetlocation,String time1,String time2);
	/*
	 * 删除会议信息
	 */
	Meet delete(int id);
	
	/*
	 * 根据会议发起人和审核字段来判断是否审核通过并进行会议通知
	 */
	List<Meet> findbymeetsqrshstatus(String meetsqr,int tp);
	/*
	 * 发送会议通知
	 */
	List<Meet> findbymeetjoin(String name);
	
	/*
	 * 根据登录的seeion name and shstatus为11即审核通过的 字段 返回List
	 */
	List<Meet> findmymeet(String name);
	
	/**
	 * 根据获取当前时间 和会议地点 来查询会议室是否被占用或者空闲,返回一个bool类型
	 */
	boolean isBusy(String meetlocation,String nowtime);
	
	/*
	 * Meet 与qiaodao表两表查询 qstatus=10的已经请假但未批准  而且是要会议发起人负责的会议
	 */
	List<Meet> findbyqdstatus(String name) throws Exception;
	
	/*
	 * 微信查出我的今日会议
	 */
	List<Meet> WXfindmymeet(String name,String time1,String time2);
	

}
