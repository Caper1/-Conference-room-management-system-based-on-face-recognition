package cn.xxs.service;

import java.util.List;

import cn.xxs.entity.User;

public interface UserService {

	/**
	 * 查询所有客户信息
	 * 
	 * @return
	 */
	List<User> selectAll(String departname);
	/*
	 * 查询所有员工的名字
	 * 
	 */
	List<User> select();
	/*
	 * 查询一个员工信息
	 */
	User select(int id);
	
	/*
	 * 添加员工信息
	 */
	void add(User c);

	/*
	 * 删除员工信息
	 */
	User delete(int id);
	
	/*
	 * 根据id查询员工信息
	 */
	User select2(int id);
	
	/*
	 * 更新客户信息
	 */
	User update(User c);
	
	/*
	 * 根据名字查询信息
	 *
	 */
	User select(String name);
	/*
	 * 完善个人资料
	 */
	
	User update2(User c);
	
}
