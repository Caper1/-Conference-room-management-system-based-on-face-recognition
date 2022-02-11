package cn.xxs.service.impl;

import java.util.List;
import cn.xxs.dao.DepartDao;
import cn.xxs.dao.impl.DepartDaoImpl;
import cn.xxs.entity.Depart;
import cn.xxs.service.DepartService;

public class DepartServiceImpl implements DepartService {
	
	DepartDao dao=new DepartDaoImpl();
	@Override
	public List<Depart> selectAll() {
		
		return dao.selectAll();
	}

}
