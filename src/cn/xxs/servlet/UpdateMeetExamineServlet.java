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
import cn.xxs.entity.Meet;
import cn.xxs.entity.Sign;
import cn.xxs.entity.User;
import cn.xxs.service.MeetService;
import cn.xxs.service.SignService;
import cn.xxs.service.UserService;
import cn.xxs.service.impl.MeetServiceImpl;
import cn.xxs.service.impl.SignServiceImpl;
import cn.xxs.service.impl.UserServiceImpl;
import cn.xxs.util.SendMail;

public class UpdateMeetExamineServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateMeetExamineServlet() {
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
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		//获取id
		User user=new User();
		UserService userservice=new UserServiceImpl();
		
		Sign sign=new Sign();
		SignService signservice=new SignServiceImpl();
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		int shstatus=Integer.parseInt(req.getParameter("shstatus"));
		String yuanyin=new String(req.getParameter("yuanyin").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(yuanyin);
		
		MeetService service=new MeetServiceImpl();
		
		Meet m=service.select(id);
		m.setShstatus(shstatus);
		m.setYuanyin(yuanyin);
		
		if(m!=null)
		{
			service.update(m);
			PrintWriter out = resp.getWriter();
			out.println(" <script type='text/javascript'> alert('审核成功')</script>");
		}
		if(m.getShstatus()==11)
		{
			String meetjoin=m.getMeetjoin();
			String[] data=meetjoin.split(",");
			for(int i=0;i<data.length;i++)
			{
				User us=userservice.select(data[i]); //查找处一个对象类
				//获得user的id 并插入至  从表中
				int userid=us.getId();
				String qdname=us.getName();
				String qdtel=us.getTel();
				String bumen=us.getBumen();
				System.out.println(userid);
				sign.setUser_id(userid);
				sign.setMeet_id(id);
				sign.setQdname(qdname);
				sign.setQdbumen(bumen);
				sign.setQdtel(qdtel);
				signservice.add(sign);				
			}
			//获取Admin对象
			Admin admin=(Admin)req.getSession().getAttribute("admin");
			
			String adminemail=admin.getEmail(); //获取admin的邮箱地址
			System.out.println(adminemail);
			String meetsqr=m.getMeetsqr();  //获取会议发起人名字 
			System.out.println(meetsqr);
			User c=userservice.select(meetsqr);  
			String[] toAdd=new String[1];
			toAdd[0]=c.getEmail();  //将获取的邮箱地址赋值进toAdd数组中
			//获取会议内容
			String meetContext="恭喜您！您预约的时间由"+m.getMeetstarttime()+"开始的至"+m.getMeetendtime()
					+"结束的主题为"+m.getMeetname()+"的会议已经审批通过，请即使通知参会人员提前10分钟进场进行刷脸签到，谢谢合作！";
			//获取会议主题
			String subject="会议审核通过通知！！！";
			//调用sendmail类
			SendMail sm=new SendMail();
			try {
				sm.send(admin.getEmail(), toAdd, subject, meetContext);
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else if(m.getShstatus()==10) //若审核拒绝 ，发送拒绝通知
		{
			//获取Admin对象
			Admin admin=(Admin)req.getSession().getAttribute("admin");
			
			String adminemail=admin.getEmail(); //获取admin的邮箱地址
			System.out.println(adminemail);
			String meetsqr=m.getMeetsqr();  //获取会议发起人名字 
			System.out.println(meetsqr);
			User c=userservice.select(meetsqr);  
			String[] toAdd=new String[1];
			toAdd[0]=c.getEmail();  //将获取的邮箱地址赋值进toAdd数组中
			//获取会议内容
			String meetContext="很遗憾！您预约的时间由"+m.getMeetstarttime()+"开始的至"+m.getMeetendtime()
					+"结束的主题为"+m.getMeetname()+"的会议审批已拒绝,原因如下："+m.getYuanyin()+",请重新预约";
			//获取会议主题
			String subject="会议审核拒绝通知！！！";
			//调用sendmail类
			SendMail sm=new SendMail();
			try {
				sm.send(admin.getEmail(), toAdd, subject, meetContext);
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
