package cn.xxs.dao.impl;

import java.util.List;

import cn.xxs.dao.BaseDao;
import cn.xxs.dao.SignDao;
import cn.xxs.entity.Meet;
import cn.xxs.entity.Sign;
import cn.xxs.entity.User;

public class SignDaoImpl  extends BaseDao<Sign> implements SignDao  {

	@Override
	public void add(Sign s) {
		update("insert into qiandao values(?,?,?,?,?,?,?,?,?)",s.getSignid(),s.getUser_id(),s.getMeet_id(),s.getQdstatus(),s.getQdtime(),s.getQdname(),s.getQdtel(),s.getQdbumen(),s.getQingjiayuanyin());
	}

	@Override
	public Sign select(String name) {
		Sign s=queryOne("select * from qiandao where qdname=?",name);
		return s;
	}

	@Override
	public List<Sign> select(int meetid) {
		List<Sign> list=queryList("select * from qiandao where meetid="+meetid);
		return list;
	}

	@Override
	public Sign update(Sign s) {
		update("update qiandao set qdstatus=?,qdtime=? where user_id=? and meet_id=?",s.getQdstatus(),s.getQdtime(),s.getUser_id(),s.getMeet_id());
		return s;
	}

	@Override
	public Sign select2(int userid) {
		// TODO Auto-generated method stub
		Sign s=queryOne("select * from qiandao where user_id=?",userid);
		return  s;
	}

	@Override
	public Sign update2(Sign s) {
		update("update qiandao set qdstatus=?,qingjiayuanyin=? where qdname=? and meet_id=?",s.getQdstatus(),s.getQingjiayuanyin(),s.getQdname(),s.getMeet_id());
		return s;
	}

	@Override
	public Sign select(String name, int meetid) {
		Sign s=queryOne("select * from qiandao where qdname=? and meet_id=?",name,meetid);
		return s;
	}

	
	}

	
