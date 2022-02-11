package cn.xxs.service.impl;

import java.util.List;

import cn.xxs.dao.AdminDao;
import cn.xxs.dao.impl.AdminDaoImpl;
import cn.xxs.entity.Admin;
import cn.xxs.service.AdminService;
import cn.xxs.service.UserService;

public class AdminServiceImpl implements AdminService{

	AdminDao dao=new AdminDaoImpl();
	
	@Override
	public List<Admin> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public Admin select(String username) {
		// TODO Auto-generated method stub
		return dao.select(username);
	}

	@Override
	public Admin update(Admin a) {
		
		return null;
	}

}
