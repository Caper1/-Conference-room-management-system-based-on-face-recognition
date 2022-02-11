package cn.xxs.dao.impl;


import java.util.List;

import cn.xxs.dao.BaseDao;
import cn.xxs.dao.CountDao;

import cn.xxs.entity.Count;
import cn.xxs.entity.User;

public class CountDaoImpl extends BaseDao<Count> implements CountDao {

	@Override
	public List<Count> meetcount(int method) {
		List<Count> list=null;
		if(method==0)
		{
			String sql="SELECT b1.CODE,IFNULL(b1.mycount,0) mycount,IFNULL(b2.joincount,0) joincount FROM (SELECT DATE_FORMAT(meetstarttime, '%Y-%m-%d') CODE, count(meetsqr) mycount FROM meet GROUP BY CODE ORDER BY CODE ASC)b1 " +
					"LEFT JOIN (SELECT DATE_FORMAT(meetstarttime, '%Y-%m-%d') CODE,count(meetjoin) joincount FROM meet where meetjoin like '%吴林祥%'GROUP BY CODE ORDER BY CODE ASC )b2 ON b1.CODE=b2.CODE";
			list=queryList(sql);
		}
		else if(method==1)
		{
			String sql="SELECT b1.CODE,IFNULL(b1.mycount,0) mycount,IFNULL(b2.joincount,0) joincount FROM (SELECT DATE_FORMAT(meetstarttime, '%Y-%m') CODE, count(meetsqr) mycount FROM meet GROUP BY CODE ORDER BY CODE ASC)b1 " +
					"LEFT JOIN (SELECT DATE_FORMAT(meetstarttime, '%Y-%m') CODE,count(meetjoin) joincount FROM meet where meetjoin like '%吴林祥%'GROUP BY CODE ORDER BY CODE ASC )b2 ON b1.CODE=b2.CODE";
			
			list=queryList(sql);
		}else if(method==2)
		{
			String sql="SELECT b1.CODE,IFNULL(b1.mycount,0) mycount,IFNULL(b2.joincount,0) joincount FROM " +
					"(SELECT DATE_FORMAT(meetstarttime, '%Y') CODE, count(meetsqr) mycount FROM meet GROUP BY CODE ORDER BY CODE ASC)b1 " +
					"LEFT JOIN (SELECT DATE_FORMAT(meetstarttime, '%Y') CODE,count(meetjoin) joincount FROM meet where meetjoin like '%吴林祥%'GROUP BY CODE ORDER BY CODE ASC )b2 ON b1.CODE=b2.CODE";
			
			list=queryList(sql);
			
		}
		return list;
	}

	@Override
	public List<Count> kaoqincount(int method, String name) {
		List<Count> list=null;
		if(method==0)
		{
			
			String sql="SELECT b1.CODE,IFNULL(b1.queqin,0) queqin,IFNULL(b2.normal,0) normal,IFNULL(b3.qingjia,0) qingjia,IFNULL(b4.chidao,0) chidao  FROM" +
					"(SELECT DATE_FORMAT(m.meetstarttime, '%Y-%m') CODE, count(qdstatus) queqin FROM  meet as m,qiandao as q where q.qdstatus=0 and q.meet_id=m.id and qdname=? GROUP BY CODE ORDER BY CODE ASC)b1 LEFT JOIN(SELECT DATE_FORMAT(m.meetstarttime, '%Y-%m') CODE, count(qdstatus) normal FROM  meet as m,qiandao as q where q.qdstatus=1 and q.meet_id=m.id and qdname=? GROUP BY CODE ORDER BY CODE ASC)b2  ON b1.CODE=b2.CODE LEFT JOIN(SELECT DATE_FORMAT(m.meetstarttime, '%Y-%m') CODE, count(qdstatus) qingjia FROM  meet as m,qiandao as q where q.qdstatus=21 and q.meet_id=m.id and qdname=?  GROUP BY CODE ORDER BY CODE ASC)b3 ON b2.CODE=b3.CODE LEFT JOIN(SELECT DATE_FORMAT(m.meetstarttime, '%Y-%m') CODE, count(qdstatus) chidao FROM  meet as m,qiandao as q where q.qdstatus=3 and q.meet_id=m.id and qdname=? GROUP BY CODE ORDER BY CODE ASC)b4 ON b3.CODE=b4.CODE";
			list=queryList(sql,name,name,name,name);
			
		}else if(method==1)
		{
			String sql="SELECT b1.CODE,IFNULL(b1.queqin,0) queqin,IFNULL(b2.normal,0) normal,IFNULL(b3.qingjia,0) qingjia,IFNULL(b4.chidao,0) chidao  FROM" +
					"(SELECT DATE_FORMAT(m.meetstarttime, '%Y') CODE, count(qdstatus) queqin FROM  meet as m,qiandao as q where q.qdstatus=0 and q.meet_id=m.id and qdname=? GROUP BY CODE ORDER BY CODE ASC)b1 LEFT JOIN(SELECT DATE_FORMAT(m.meetstarttime, '%Y') CODE, count(qdstatus) normal FROM  meet as m,qiandao as q where q.qdstatus=1 and q.meet_id=m.id and qdname=? GROUP BY CODE ORDER BY CODE ASC)b2  ON b1.CODE=b2.CODE LEFT JOIN(SELECT DATE_FORMAT(m.meetstarttime, '%Y') CODE, count(qdstatus) qingjia FROM  meet as m,qiandao as q where q.qdstatus=21 and q.meet_id=m.id and qdname=?  GROUP BY CODE ORDER BY CODE ASC)b3 ON b2.CODE=b3.CODE LEFT JOIN(SELECT DATE_FORMAT(m.meetstarttime, '%Y') CODE, count(qdstatus) chidao FROM  meet as m,qiandao as q where q.qdstatus=3 and q.meet_id=m.id and qdname=? GROUP BY CODE ORDER BY CODE ASC)b4 ON b3.CODE=b4.CODE";
			list=queryList(sql,name,name,name,name);
		}
		
		
		return list;
	}

	@Override
	public List<Count> meetroomcount() {
		String sql="select meetlocation,COUNT(id) meetsum from meet GROUP BY meetlocation";
		List<Count> list=queryList(sql);
		return list;
	}

	@Override
	public List<Count> renyuankaoqin() {
		String sql="SELECT b1.qdname,b1.user_id,IFNULL(b1.queqin,0) queqin,IFNULL(b2.normal,0) normal,IFNULL(b3.qingjia,0) qingjia,IFNULL(b4.chidao,0) chidao from(SELECT qdname,user_id,COUNT(qdstatus) queqin from qiandao WHERE qdstatus=0 GROUP BY qdname,user_id ORDER BY qdname ASC)b1 LEFT JOIN(SELECT qdname,user_id,count(qdstatus) normal from qiandao WHERE qdstatus=1 GROUP BY qdname,user_id ORDER BY qdname ASC)b2 ON b1.qdname=b2.qdname LEFT JOIN(SELECT qdname,user_id,count(qdstatus) qingjia from qiandao WHERE qdstatus like '2%' GROUP BY qdname,user_id ORDER BY qdname ASC)b3 on b2.qdname=b3.qdname LEFT JOIN(SELECT qdname,user_id,count(qdstatus) chidao from qiandao WHERE qdstatus=3 GROUP BY qdname,user_id ORDER BY qdname ASC)b4 on b3.qdname=b4.qdname";
		List<Count> list=queryList(sql);
		return list;
	}
	

	
}
