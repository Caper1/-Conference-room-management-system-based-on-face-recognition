package cn.xxs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.GeneralSecurityException;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xxs.entity.Admin;
import cn.xxs.entity.Sign;
import cn.xxs.entity.User;
import cn.xxs.service.SignService;
import cn.xxs.service.UserService;
import cn.xxs.service.impl.SignServiceImpl;
import cn.xxs.service.impl.UserServiceImpl;
import cn.xxs.util.SendMail;

public class qingjiaupdateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public qingjiaupdateServlet() {
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
		int qdstatus=Integer.parseInt(req.getParameter("qdstatus"));
		String qingjiayuanyin=new String(req.getParameter("qingjiayuanyin").getBytes("ISO-8859-1"),"UTF-8");
		String qdname=new String(req.getParameter("qdname").getBytes("ISO-8859-1"),"UTF-8");
		int meetid=Integer.parseInt(req.getParameter("meetid"));
		SignService signservice=new SignServiceImpl();
		Sign s=signservice.select(qdname, meetid);
		s.setQdstatus(qdstatus);
		
		if(s!=null)
		{
			signservice.update2(s);
			resp.sendRedirect("./qingjiaSelectServlet");
		}
		if(s.getQdstatus()==21)
		{
			//??????Admin??????
			User user=(User)req.getSession().getAttribute("user");
			UserService userservice=new UserServiceImpl();
			String useremail=user.getEmail(); //??????admin???????????????
			User c= userservice.select(qdname);
			String[] toAdd=new String[1];
			toAdd[0]=c.getEmail();  //?????????????????????????????????toAdd?????????
			//??????????????????
			String meetContext="?????????????????????????????????????????????";
			//??????????????????
			String subject="???????????????????????????";
			//??????sendmail???
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
		}else if(s.getQdstatus()==20) //??????????????? ?????????????????????
		{
			//??????Admin??????
			User user=(User)req.getSession().getAttribute("user");
			UserService userservice=new UserServiceImpl();
			String useremail=user.getEmail(); //??????admin???????????????
			User c= userservice.select(qdname);
			String[] toAdd=new String[1];
			toAdd[0]=c.getEmail();  //?????????????????????????????????toAdd?????????
			//??????????????????
			String meetContext="????????????????????????????????????,??????????????????????????????,???????????????";
			//??????????????????
			String subject="???????????????????????????";
			//??????sendmail???
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
