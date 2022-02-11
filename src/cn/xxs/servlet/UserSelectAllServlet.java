package cn.xxs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xxs.service.MeetService;
import cn.xxs.service.UserService;
import cn.xxs.service.impl.MeetServiceImpl;
import cn.xxs.service.impl.UserServiceImpl;
import cn.xxs.util.JsonDateValueProcessor;
import cn.xxs.entity.Meet;
import cn.xxs.entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import javax.servlet.annotation.WebServlet;

public class UserSelectAllServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserSelectAllServlet() {
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
//		response.setCharacterEncoding("UTF-8");
//		//调用查询函数
//		UserService service=new UserServiceImpl();
//		List<User> list =service.selectAll();
//		
//		
//		//把list转换成json
//		JsonConfig config = new JsonConfig();
//        config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
//        
//		JSONArray jsonArray = JSONArray.fromObject(list,config);
//		
//		
//
//		String str = "{\"code\":0,\"msg\":\"\",\"count\":" + 12 + ",\"data\":" + jsonArray.toString() + "}";
//		System.out.println(str);
//		response.getWriter().write(str);
		
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		UserService service=new UserServiceImpl();
		System.out.println("!!!!!!!!!!!!!!!!");
		String departname=req.getParameter("key[departname]");
		System.out.println(departname);
		if(departname==null)
		{
			departname="";
		}
		List<User> list=service.selectAll(departname);
		//把list转换成json   
		JsonConfig config = new JsonConfig();
        config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        
		JSONArray jsonArray = JSONArray.fromObject(list,config);
		

		String str = "{\"code\":0,\"msg\":\"\",\"count\":" + 12 + ",\"data\":" + jsonArray.toString() + "}";
		System.out.println(str);
		resp.getWriter().write(str);
		
		
		
	}
	
}
