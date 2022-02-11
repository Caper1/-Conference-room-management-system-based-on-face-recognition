package cn.xxs.service.impl;

import java.util.List;

import cn.xxs.dao.SignDao;
import cn.xxs.dao.UserDao;
import cn.xxs.dao.impl.SignDaoImpl;
import cn.xxs.dao.impl.UserDaoImpl;
import cn.xxs.entity.Sign;
import cn.xxs.service.SignService;

public class SignServiceImpl  implements SignService {
	SignDao dao=new SignDaoImpl();
	@Override
	public void add(Sign s) {
		dao.add(s);
	}
	@Override
	public Sign select(String name) {
		// TODO Auto-generated method stub
		return dao.select(name);
	}
	@Override
	public List<Sign> select(int meetid) {

		return dao.select(meetid);
	}
	@Override
	public Sign update(Sign s) {
		
		return dao.update(s);
	}
	@Override
	public Sign select2(int userid) {
		// TODO Auto-generated method stub
		return dao.select2(userid);
	}
	@Override
	public Sign update2(Sign s) {
		// TODO Auto-generated method stub
		return dao.update2(s);
	}
	@Override
	public Sign select(String name, int meetid) {
		// TODO Auto-generated method stub
		return dao.select(name, meetid);
	}

}
