package cn.xxs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import net.sf.json.JSONArray;


import cn.xxs.entity.Admin;
import cn.xxs.entity.User;
import cn.xxs.service.AdminService;
import cn.xxs.service.UserService;
import cn.xxs.service.impl.AdminServiceImpl;
import cn.xxs.service.impl.UserServiceImpl;

public class WXloginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public WXloginServlet() {
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
		System.out.println("微信登录");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		String password=request.getParameter("password");
		System.out.println(password);
		UserService service=new UserServiceImpl();
		List<User> list=service.select();
		
		for(User user : list)
		{
			int userid=user.getId();
			System.out.println(userid);
			//如果用户登录成功
			if(userid==id&&user.getPassword().equals(password))
			{
				System.out.println(user.getId());
				
				HttpSession session=request.getSession();
				// 手动设置session的有效期为30分钟
				String sessionId=session.getId();
				Cookie cookie = new Cookie("JSESSIONID", sessionId);
				cookie.setMaxAge(60 * 30);
				cookie.setPath(request.getContextPath());
				
				response.addCookie(cookie);
				
				//登录成功后要存入用户的登陆状态
				session.setAttribute("user",user);
				String json=JSON.toJSONString(user);
				System.out.println(json);
				response.getWriter().print(json);
				break;
			}
		}
		
		

		
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
