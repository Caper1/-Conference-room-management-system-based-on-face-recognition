package cn.xxs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import cn.xxs.entity.User;
import cn.xxs.service.UserService;
import cn.xxs.service.impl.UserServiceImpl;

public class UsernameServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UsernameServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		UserService service=new UserServiceImpl();
		
		List<User> list=service.select();
		System.out.println(list);
		//json数据删除对象里指定的键
		JSONArray jsonArray = JSONArray.fromObject(list);
		JSONObject jsonObject =new JSONObject();
		
		for(int i=0;i<jsonArray.size();i++)
		{			
			jsonObject=(JSONObject)jsonArray.get(i);
			jsonObject.put("value", i);
			
		}
		String str = "{\"code\":0,\"msg\":\"success\",\"data\":" + jsonArray.toString() + "}";
		System.out.println(str);
		response.getWriter().write(str);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		UserService service=new UserServiceImpl();
//		String depart=new String(request.getParameter("depart").getBytes("ISO-8859-1"),"UTF-8");
//		System.out.println(depart);
//		if(depart==null)
//		{
//			depart="";
//		}
		List<User> list=service.select();
		System.out.println(list);
		//json数据删除对象里指定的键
		JSONArray jsonArray = JSONArray.fromObject(list);
		JSONObject jsonObject =new JSONObject();
		
		for(int i=0;i<jsonArray.size();i++)
		{			
			jsonObject=(JSONObject)jsonArray.get(i);
			jsonObject.put("value", i);
			
		}
		String str = "{\"code\":0,\"msg\":\"success\",\"data\":" + jsonArray.toString() + "}";
		System.out.println(str);
		response.getWriter().write(str);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
