package cn.xxs.service.impl;

import java.util.List;

import cn.xxs.dao.CountDao;
import cn.xxs.dao.UserDao;
import cn.xxs.dao.impl.CountDaoImpl;
import cn.xxs.dao.impl.UserDaoImpl;
import cn.xxs.entity.Count;
import cn.xxs.service.CountService;

public class CountServiceImpl implements CountService {

	CountDao dao=new CountDaoImpl();
	@Override
	public List<Count> meetcount(int method) {
		// TODO Auto-generated method stub
		return dao.meetcount(method);
	}
	@Override
	public List<Count> kaoqincount(int method, String name) {
		// TODO Auto-generated method stub
		return dao.kaoqincount(method, name);
	}
	@Override
	public List<Count> meetroomcount() {
		// TODO Auto-generated method stub
		return dao.meetroomcount();
	}
	@Override
	public List<Count> renyuankaoqin() {
		// TODO Auto-generated method stub
		return dao.renyuankaoqin();
	}
	
	

}
