package cn.xxs.service;

import java.util.List;

import cn.xxs.entity.Depart;

public interface DepartService {
	/**
	 * 查询部门所有信息
	 * 
	 * @return
	 */
	List<Depart> selectAll();

}
