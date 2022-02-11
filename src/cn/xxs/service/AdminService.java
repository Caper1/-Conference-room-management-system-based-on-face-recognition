package cn.xxs.service;

import java.util.List;

import cn.xxs.entity.Admin;

public interface AdminService {
	/*
	 * 查询管理员账户
	 */
	List<Admin> selectAll();
	
	/*
	 * 根据username查询密码
	 */
	Admin select(String username);
	
	/*
	 * 修改管理员账户密码
	 */
	Admin update(Admin a);

}
