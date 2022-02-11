package cn.xxs.dao.impl;

import java.util.List;

import cn.xxs.dao.BaseDao;
import cn.xxs.dao.DepartDao;
import cn.xxs.entity.Depart;
import cn.xxs.entity.User;

public class DepartDaoImpl  extends BaseDao<Depart> implements DepartDao{

	@Override
	public List<Depart> selectAll() {
		// TODO Auto-generated method stub
		List<Depart> list=queryList("select * from depart");
		return list;
	}

}
