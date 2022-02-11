package cn.xxs.dao.impl;

import java.util.List;

import cn.xxs.dao.BaseDao;
import cn.xxs.dao.UserDao;
import cn.xxs.entity.User;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
	
	public static void main(String[] args) {
		UserDaoImpl d=new UserDaoImpl();
			System.out.println(d.findqd(1).get(0).getSign().getMeet_id());
	}

	/*
	 * 查询所有用户
	 * @see cn.xxs.dao.UserDao#selectAll()
	 */
	public List<User> selectAll(String departname) {
		String sql="select * from user where (bumen=? or ?='')";
		List<User> list=queryList(sql,departname,departname);
		return list;
	}

	@Override
	public User select(int id) {
		User c=queryOne("select * from user where id=?",id);
		
		return c;
	}

	@Override
	public void add(User c) {
		update("insert into user values(?,?,?,?,?,?,?,?,?,?)",c.getId(),c.getName(),c.getSex(),c.getTel(),c.getEmail(),c.getBumen(),c.getZhiwei(),c.getTime(),c.getPassword(),c.getIdentity());		
		
	}

	@Override
	public User delete(int id) {
		update("delete from user where id=?",id);
		return null;
	}

	@Override
	public User select2(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User c) {
		update("update user set name=?,bumen=?,zhiwei=?,time=? where id=?",
				c.getName(),c.getBumen(),c.getZhiwei(),c.getTime(),c.getId());
		
		return c;
	}
	
	

	@Override
	/*
	 * 查询所有员工名字(non-Javadoc)
	 * @see cn.xxs.dao.UserDao#select()
	 */
	public List<User> select() {
		List<User> list=queryList("select * from user");
		return list;
	}

	@Override
	public User select(String name) {
		
		User c=queryOne("select * from user where name=?",name);
		return c;
	}



	public  List<User> findqd(int meetid) {
		// TODO Auto-generated method stub
		List<User> list=queryList("select * from qiandao as q ,user as u ,meet as m where q.user_id=u.id and q.meet_id="+meetid);
		return list;
	}

	@Override
	public User update2(User c) {
		update("update user set tel=?,email=?,identity=?,password=? where id=?",
				c.getTel(),c.getEmail(),c.getIdentity(),c.getPassword(),c.getId());
		return c;
	}



	/*
	 * 查询所有客户信息
	 */
	
}
