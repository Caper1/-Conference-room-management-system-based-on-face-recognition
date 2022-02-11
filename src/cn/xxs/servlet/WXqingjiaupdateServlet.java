package cn.xxs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import cn.cy.domain.Result;
import cn.xxs.entity.Sign;
import cn.xxs.entity.User;
import cn.xxs.service.SignService;
import cn.xxs.service.UserService;
import cn.xxs.service.impl.SignServiceImpl;
import cn.xxs.service.impl.UserServiceImpl;
import cn.xxs.util.SendMail;

public class WXqingjiaupdateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public WXqingjiaupdateServlet() {
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

		int qdstatus=Integer.parseInt(req.getParameter("qdstatus"));
		String qdname=new String(req.getParameter("qdname").getBytes("ISO-8859-1"),"UTF-8");
		String name=new String(req.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		int meetid=Integer.parseInt(req.getParameter("meetid"));
		
		SignService signservice=new SignServiceImpl();
		Sign s=signservice.select(qdname, meetid);
		s.setQdstatus(qdstatus);
		signservice.update2(s);
		
		if(s.getQdstatus()==21)
		{
			//获取Admin对象
			User user=(User)req.getSession().getAttribute("user");
			UserService userservice=new UserServiceImpl();
			User u=userservice.select(name);
			String useremail=u.getEmail();
			User c= userservice.select(qdname);
			String[] toAdd=new String[1];
			toAdd[0]=c.getEmail();  //将获取的邮箱地址赋值进toAdd数组中
			//获取会议内容
			String meetContext="恭喜您！您的请假申请已通过！！";
			//获取会议主题
			String subject="请假申请通知！！！";
			//调用sendmail类
			SendMail sm=new SendMail();
			try {
				sm.send(useremail, toAdd, subject, meetContext);
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}else if(s.getQdstatus()==20) //若审核拒绝 ，发送拒绝通知
		{
			UserService userservice=new UserServiceImpl();
			User u=userservice.select(name);
			String useremail=u.getEmail();
			User c= userservice.select(qdname);
			String[] toAdd=new String[1];
			toAdd[0]=c.getEmail();  //将获取的邮箱地址赋值进toAdd数组中
			//获取会议内容
			String meetContext="很遗憾您的请假申请被驳回,原因：此次会议很重要,请务必参加";
			//获取会议主题
			String subject="请假申请通知！！！";
			//调用sendmail类
			SendMail sm=new SendMail();
			try {
				sm.send(useremail, toAdd, subject, meetContext);
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		Result result = new Result();
        result.setErrorMsg("审核完成");
        JSONObject json = new JSONObject(result.toString());
		resp.getWriter().print(json);
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
