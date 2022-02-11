package cn.xxs.dao;

import java.util.List;

import cn.xxs.entity.Depart;



public interface DepartDao {
	/**
	 * 查询部门所有信息
	 * 
	 * @return
	 */
	List<Depart> selectAll();
	
	

}
