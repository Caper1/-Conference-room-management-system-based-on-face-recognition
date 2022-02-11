package cn.xxs.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.xxs.dao.BaseDao;
import cn.xxs.dao.MeetDao;
import cn.xxs.entity.Meet;
import cn.xxs.entity.Sign;
import cn.xxs.entity.User;

public class MeetDaoImpl extends BaseDao<Meet> implements MeetDao {
	@Override
	public List<Meet> selectAll() {
		// TODO Auto-generated method stub
		List<Meet> list=queryList("select * from meet where meetstatus!=3");
		return list;
	}
	
	@Override
	public void add(Meet m) {
		update("insert  into meet(meetname,meetlocation,meetsqr,meetcontext,meetjoin,meetstarttime,meetendtime,shstatus,meetstatus,yuanyin)values(?,?,?,?,?,?,?,?,?,?)",m.getMeetname(),m.getMeetlocation(),m.getMeetsqr(),m.getMeetcontext(),m.getMeetjoin(),m.getMeetstarttime(),m.getMeetendtime(),m.getShstatus(),m.getMeetstatus(),m.getYuanyin());
	}

	@Override
	public List<Meet> selectbyName(String name,String meetlocation,String meetstarttime,String meetendtime) {
		String sql="select * from meet where (meetsqr=?)"
				+"and (meetlocation=? or ?='')"
				+"and (meetstarttime between ? and ? or ?='')"
				+"and (meetendtime between ? and ? or ?='')";
		List<Meet> list=queryList(sql,name,meetlocation,meetlocation,meetstarttime,meetendtime,meetstarttime,meetstarttime,meetendtime,meetstarttime);
		return list;
	}

	@Override
	public Meet select(int id) {
		Meet m=queryOne("select * from meet where id=?",id);
		return m;
	}

	@Override
	public Meet update(Meet m) {
		// TODO Auto-generated method stub
		update("update meet set shstatus=?,meetstatus=?,yuanyin=?,meetstatus=? where id=?",m.getShstatus(),m.getMeetstatus(),m.getYuanyin(),m.getMeetstatus(),m.getId());
		return m;
		
	}

	@Override
	public List<Meet> findby(String meetsqr, String meetlocation,
			String meetstarttime, String meetendtime) {
		// TODO Auto-generated method stub
		
		String sql="select * from meet where (meetsqr=? or ?='')"
		+"and (meetlocation=? or ?='')"
		+"and (meetstarttime between ? and ? or ?='')"
		+"and (meetendtime between ? and ? or ?='')"
		+"and (meetstatus!=3)";
		System.out.print(sql);
		System.out.println(meetendtime);
		List<Meet> list=queryList(sql,meetsqr,meetsqr,meetlocation,meetlocation,meetstarttime,meetendtime,meetstarttime,meetstarttime,meetendtime,meetstarttime);
		return list;
	}

	@Override
	public List<Meet> findbylocationstatus(String meetlocation,String time1,String time2) {
		String sql="select * from meet where (meetlocation=?)"
				+"and (shstatus=11)"
				+"and (meetstarttime between ?and ?)"
				+"and (meetendtime between ? and ?)";
		List<Meet> list=queryList(sql,meetlocation,time1,time2,time1,time2);
		return list;
	}

	@Override
	public Meet delete(int id) {
		update("delete from user where id=?",id);
		return null;
	}

	@Override
	public List<Meet> findbymeetsqrshstatus(String meetsqr,int tp) {
		List<Meet> list;
		if(tp==1)
		{
			list=queryList("select * from meet where meetsqr=? and shstatus like '1%'",meetsqr);
		}else if(tp==2)
		{
			list=queryList("select * from meet where meetsqr=? and shstatus=11",meetsqr);
		}else{
			list=queryList("select * from meet where meetsqr=? and shstatus=10",meetsqr);
		}
		
		
		return list;
	}

	@Override
	public List<Meet> findbymeetjoin(String name) {
		List<Meet> list=queryList("select *,CASE WHEN  meetstatus=0 THEN '' WHEN  meetstatus=3 THEN '(已撤销)' ELSE '' END meetstatus1 from meet where meetjoin like '%"+name+"%' and shstatus=11");
		System.out.println("6666666666666666666666666");
		System.out.println(list.get(0).getMeetstatus1());
		return list;
	}

	@Override
	public List<Meet> findmymeet(String name) {
		List<Meet> list=queryList("select * from meet as m,qiandao as q where qdname=? and meetjoin like '%"+name+"%' and shstatus=11 and meetstatus!=3 and q.meet_id=m.id",name);
		return list;
	}

	@Override
	public boolean isBusy(String meetlocation, String nowtime) {
		List<Meet> list=queryList("select * from meet where meetlocation=? and shstatus=11",meetlocation);
		for(int i=0;i<list.size();i++)
		{
			//获取起止时间
			String starttime=list.get(i).getMeetstarttime().toString();
			String endtime=list.get(i).getMeetendtime().toString();
			//比较nowtime 与起止时间的大小
			int res1=nowtime.compareTo(starttime); //若nowtime小则 res<0
			int res2=nowtime.compareTo(endtime);   
			if(res1>0&&res2<0)
			{	
				System.out.println("被占用");
				return false; //表示被占用
			}
		}
		System.out.println("空闲");
		return true; //表示空闲
		
	}

	@Override
	public List<Meet> findbyqdstatus(String name) throws Exception {
		String sql="select * from meet as m,qiandao as q where qdstatus like '2%' and q.meet_id=m.id and meetsqr=?";
		List<Meet> list=queryList(sql,name);
		return list;
	}

	@Override
	public List<Meet> WXfindmymeet(String name, String time1, String time2) {
		List<Meet> list=queryList("select * from meet as m,qiandao as q where qdname=?"+
				"and (meetjoin like '%"+name+"%')" +
						" and (shstatus=11)" +
						" and (meetstatus!=3)" +
						"and (meetstarttime between ?and ?)"
						+"and (meetendtime between ? and ?)" +
						"and (q.meet_id=m.id)",name,time1,time2,time1,time2);
		return list;
	}
	

}
