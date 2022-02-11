package cn.xxs.dao;


import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import cn.xxs.entity.User;
import cn.xxs.util.DBUtil;
 
public class BaseDao<E> {
 
	// E所对应的类型
	private Class<E> cls; // CustomerService Card
 
	public BaseDao() {
		// 获取E所代表的类型（必须在子类中执行）
		cls = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
 
	public boolean isExistColumn(ResultSet rs, String columnName) {
		try {
			if (rs.findColumn(columnName) > 0) {
				return true;
			}
		} catch (SQLException e) {
			return false;
		}
 
		return false;
	}
 
	/**
	 * 查询一条数据时，返回一个实体类
	 * 
	 * @param sql   查询的sql语句
	 * @param param sql语句中?所代表的数据
	 * @return
	 */
	public E queryOne(String sql, Object... param) { // Object... 0个~多个
		E c = null;
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			// 3、任务Statement
			state = conn.prepareStatement(sql);
			// state.setObject(1,"皮特");
			// state.setObject(2,"1234");
			for (int i = 0; i < param.length; i++) {
				state.setObject(i + 1, param[i]);
			}
			// 4、结果ResultSets
			rs = state.executeQuery();
			if (rs.next()) {
				// 1、创建对象
				c = cls.newInstance(); // new XX()
				// 2、通过成员变量，来获取rs的数据
				Field[] fs = cls.getDeclaredFields(); // 例如E代表Customer，cls->CustomerService
				for (Field f : fs) {
					f.setAccessible(true); // 让私有的、原本不可用的，变成可用
					if (isExistColumn(rs, f.getName())) {
 
						Object o = rs.getObject(f.getName());// 通过成员变量名，获得数据库的数据
						f.set(c, o); // 给e的成员变量赋值
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			// 5、关闭
			close(rs, state, conn);
 
		}
		return c;
	}
 
	/**
	 * 查询多条数据时，返回集合
	 * 
	 * @param sql   查询的sql语句
	 * @param param sql语句中?所代表的数据
	 * @return
	 */
	public List<E> queryList(String sql, Object... param) { // Object... 0个~多个
		List<E> list = new ArrayList<E>();
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		try {
 
			conn = DBUtil.getConnection();
			// 3、任务Statement
			state = conn.prepareStatement(sql);
			// state.setObject(1,"皮特");
			// state.setObject(2,"1234");
			for (int i = 0; i < param.length; i++) {
				state.setObject(i + 1, param[i]);
			}
			// 4、结果ResultSets
			rs = state.executeQuery();
			while (rs.next()) {
				// 1、创建对象
				E c = cls.newInstance(); // new XX()
				// 2、通过成员变量，来获取rs的数据
				Field[] fs = cls.getDeclaredFields(); // 例如E代表Customer，cls->CustomerService
				for (Field f : fs) {
					f.setAccessible(true); // 让私有的、原本不可用的，变成可用
					if (isExistColumn(rs, f.getName())) {
 
						Object o = rs.getObject(f.getName());// 通过成员变量名，获得数据库的数据
						f.set(c, o); // 给e的成员变量赋值
					}
				}
				// 放入集合中
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {
			close(rs, state, conn);
 
		}
		return list;
	}
 
	/**
	 * 修改数据库的操作（增、删、改）
	 * 
	 * @param sql   修改的sql语句
	 * @param param sql语句中?所代表的数据
	 * @return 修改是否成功
	 */
	public boolean update(String sql, Object... param) { // Object... 0个~多个
		int row = 0;
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		try {
 
			conn = DBUtil.getConnection();
			// 3、任务Statement
			state = conn.prepareStatement(sql);
			// state.setObject(1,"皮特");
			// state.setObject(2,"1234");
			for (int i = 0; i < param.length; i++) {
				state.setObject(i + 1, param[i]);
			}
			// 4、结果ResultSets
			row = state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, state, conn);
 
		}
		return row > 0;
	}
	
	/**
	* 查询的方法
	* @throws Exception
	*/
	public ResultSet executeQuery(String sql,Object...obj) throws Exception{
	//获取连接
		Connection conn = null;
		conn=DBUtil.getConnection();
		PreparedStatement state = null;
		ResultSet rs = null;
	//获取
	state= conn.prepareStatement(sql);
	//循环加载参数
	for (int i = 1; i <=obj.length; i++) {
	state.setObject(i, obj[i-1]);
	}
	//执行SQL
	rs= state.executeQuery();
	return rs;
	}
 
	// 关闭三大变量
	private void close(ResultSet rs, Statement state, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) { // 避免空指针：1、if(rs!=null) 2、SQLException->Exception
			e.printStackTrace();
		}
		try {
			if (state != null)
				state.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
