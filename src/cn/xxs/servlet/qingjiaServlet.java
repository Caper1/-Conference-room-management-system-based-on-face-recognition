package cn.xxs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xxs.entity.Admin;
import cn.xxs.entity.Sign;
import cn.xxs.entity.User;
import cn.xxs.service.SignService;
import cn.xxs.service.impl.SignServiceImpl;

public class qingjiaServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public qingjiaServlet() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//首先获取要请假的人session
		User user=(User)req.getSession().getAttribute("user");
		String qingjianame=user.getName();  //获取请假人的name
		//获取meetid 和请假缘由
		int meetid=Integer.parseInt(req.getParameter("meetid"));
		String qingjia=new String(req.getParameter("qingjia").getBytes("ISO-8859-1"),"UTF-8");
		//根据 qingjianame和meetid更新签到表
		SignService signservice=new SignServiceImpl();
		Sign s=new Sign();
		s=signservice.select(qingjianame, meetid);

		s.setQingjiayuanyin(qingjia);
		s.setQdstatus(2);
		if(s!=null)
		{
		signservice.update2(s);
		}
		
		
		
		
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
