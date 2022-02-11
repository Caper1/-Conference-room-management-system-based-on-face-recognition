package cn.xxs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xxs.entity.User;
import cn.xxs.service.UserService;
import cn.xxs.service.impl.UserServiceImpl;

public class UserTableSelectServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserTableSelectServlet() {
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
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//从 form表单获取数据
		int id=Integer.parseInt(req.getParameter("id"));
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		UserService service=new UserServiceImpl();
		
		User cu=service.select(id);
		
		if(cu!=null)
		{
			//打印
			req.setAttribute("c", cu);
			//转发
			req.getRequestDispatcher("UserTableSelect.jsp").forward(req, resp);
		}
		
		
		
	}


}
