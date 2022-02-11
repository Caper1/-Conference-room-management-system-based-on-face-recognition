package cn.xxs.service.impl;
import java.util.List;

import cn.xxs.entity.User;
import cn.xxs.dao.UserDao;
import cn.xxs.dao.impl.UserDaoImpl;
import cn.xxs.service.UserService;

public class UserServiceImpl implements UserService  {
	UserDao dao=new UserDaoImpl();
	/**
	 * 查询所有客户信息
	 * 
	 * @return
	 */
	@Override
	public List<User> selectAll(String departname) {
		return dao.selectAll(departname);
	}
	@Override
	public User select(int id) {
		
		return dao.select(id);
	}
	@Override
	public void add(User c) {
		// TODO Auto-generated method stub
		dao.add(c);
	}
	@Override
	public User delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}
	@Override
	public User select2(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User update(User c) {
		// TODO Auto-generated method stub
		return dao.update(c);
	}
	@Override
	public List<User> select() {
		return dao.select();
	}
	@Override
	public User select(String name) {
		
		return dao.select(name);
	}
	@Override
	public User update2(User c) {
		// TODO Auto-generated method stub
		return dao.update2(c);
	}


}
