package cn.xxs.dao.impl;

import java.util.List;

import cn.xxs.dao.BaseDao;
import cn.xxs.dao.AdminDao;
import cn.xxs.dao.UserDao;
import cn.xxs.entity.Admin;
import cn.xxs.entity.User;

public class AdminDaoImpl extends BaseDao<Admin> implements AdminDao {

	@Override
	public List<Admin> selectAll() {
		List<Admin> list=queryList("select * from administ");
		return list;
	}

	@Override
	public Admin select(String username) {
		Admin a=queryOne("select * from where username=?",username);
		return a;
		
	}

	@Override
	public Admin update(Admin a) {
		// TODO Auto-generated method stub
		return null;
	}

}
