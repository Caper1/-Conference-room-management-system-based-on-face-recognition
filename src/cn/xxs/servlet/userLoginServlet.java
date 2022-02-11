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

import cn.xxs.entity.Admin;
import cn.xxs.entity.User;
import cn.xxs.service.AdminService;
import cn.xxs.service.UserService;
import cn.xxs.service.impl.AdminServiceImpl;
import cn.xxs.service.impl.UserServiceImpl;

public class userLoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public userLoginServlet() {
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

		System.out.println("userloginServlet");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		int id=Integer.parseInt(request.getParameter("userid"));
		System.out.println(id);
		String password=request.getParameter("password");
		System.out.println(password);
		UserService service=new UserServiceImpl();
		List<User> list=service.select();
		
		for(User user : list)
		{
			
			//如果用户登录成功
			if(user.getId()==id&&user.getPassword().equals(password))
			{	
				System.out.println(user.getPassword());
				HttpSession session=request.getSession();
				// 手动设置session的有效期为30分钟
				String sessionId=session.getId();
				Cookie cookie = new Cookie("JSESSIONID", sessionId);
				cookie.setMaxAge(60 * 30);
				cookie.setPath(request.getContextPath());
				
				response.addCookie(cookie);
				
				//登录成功后要存入用户的登陆状态
				session.setAttribute("user",user);
				//重定向到首页
				response.sendRedirect("userindex.html");	
				return ;
			}
			
		}
		PrintWriter out = response.getWriter();
		out.print("用户名或密码错误");
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
