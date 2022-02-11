package cn.xxs.service.impl;

import java.util.List;

import cn.xxs.dao.MeetDao;
import cn.xxs.dao.UserDao;
import cn.xxs.dao.impl.MeetDaoImpl;
import cn.xxs.dao.impl.UserDaoImpl;
import cn.xxs.entity.Meet;
import cn.xxs.service.MeetService;

public class MeetServiceImpl implements MeetService  {
	MeetDao dao=new MeetDaoImpl();
	@Override
	public List<Meet> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}
@Override
	public void add(Meet m) {
		dao.add(m);	
	}
@Override
public List<Meet> selectbyName(String name,String meetlocation,String meetstarttime,String meetendtime) {
	// TODO Auto-generated method stub
	return dao.selectbyName(name, meetlocation, meetstarttime, meetendtime);
}
@Override
public Meet select(int id) {
	// TODO Auto-generated method stub
	return dao.select(id);
}
@Override
public Meet update(Meet m) {
	// TODO Auto-generated method stub
	return dao.update(m);
}
@Override
public List<Meet> findby(String meetsqr, String meetlocation, String meetsarttime,
		String meetendtime) {
	// TODO Auto-generated method stub
	return dao.findby(meetsqr, meetlocation, meetsarttime, meetendtime);
}
@Override
public List<Meet> findbylocationstatus(String meetlocation, String time1,
		String time2) {
	
	return dao.findbylocationstatus(meetlocation, time1, time2);
}
@Override
public Meet delete(int id) {
	// TODO Auto-generated method stub
	return dao.delete(id);
}
@Override
public List<Meet> findbymeetsqrshstatus(String meetsqr,int tp) {

	return dao.findbymeetsqrshstatus(meetsqr,tp);
}
@Override
public List<Meet> findbymeetjoin(String name) {
	// TODO Auto-generated method stub
	return dao.findbymeetjoin(name);
}
@Override
public List<Meet> findmymeet(String name) {
	// TODO Auto-generated method stub
	return dao.findmymeet(name);
}
@Override
public boolean isBusy(String meetlocation, String nowtime) {
	// TODO Auto-generated method stub
	return dao.isBusy(meetlocation, nowtime);
}
@Override
public List<Meet> findbyqdstatus(String name) throws Exception {
	// TODO Auto-generated method stub
	return dao.findbyqdstatus(name);
}
@Override
public List<Meet> WXfindmymeet(String name, String time1, String time2) {
	// TODO Auto-generated method stub
	return dao.WXfindmymeet(name, time1, time2);
}
	
}
