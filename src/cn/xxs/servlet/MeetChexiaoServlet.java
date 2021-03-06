package cn.xxs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xxs.entity.Meet;
import cn.xxs.entity.User;
import cn.xxs.service.MeetService;
import cn.xxs.service.UserService;
import cn.xxs.service.impl.MeetServiceImpl;
import cn.xxs.service.impl.UserServiceImpl;
import cn.xxs.util.SendMail;

public class MeetChexiaoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MeetChexiaoServlet() {
		super();
	}
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		User user=new User();
		UserService userservice=new UserServiceImpl();
		
		int id=Integer.parseInt(request.getParameter("id"));  //????????????id
		//????????????id????????????
		MeetService service=new MeetServiceImpl();
		Meet m=service.select(id);
		//???session????????????user?????????
		User user1=(User)request.getSession().getAttribute("user");
		//?????????????????????????????????????????????
		String yuangong=m.getMeetjoin();
		String[] data=yuangong.split(",");
		//???????????? ?????????????????????????????????
		String[] toAdd=new String[data.length];
		for(int i=0;i<data.length;i++)
		{	
			System.out.println(data[i]);
			User c=userservice.select(data[i]);
			toAdd[i]=c.getEmail();
		}
		//??????????????????
		String meetContext="??????????????????"+m.getMeetname()+"??????????????????,???"+m.getMeetstarttime()+"???"+m.getMeetendtime()+"???????????????????????????????????????????????????????????????";
		//??????????????????
		String subject="?????????????????????";
		//??????sendmail???
		SendMail sm=new SendMail();
		try {
			sm.send(user1.getEmail(), toAdd, subject, meetContext);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("fghhhjklkjhgf");
		 response.getWriter().print(id);
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
