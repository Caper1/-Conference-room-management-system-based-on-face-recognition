package cn.xxs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import cn.xxs.entity.User;
import cn.xxs.service.UserService;
import cn.xxs.service.impl.UserServiceImpl;

public class UserTableInertSevlet extends HttpServlet {
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
		System.out.println("ddddddddddddddddddddddddddddddd");
		int id=Integer.parseInt(req.getParameter("imgId"));
		String name=new String(req.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		System.out.println(name);
		String bumen=new String(req.getParameter("bumen").getBytes("iso-8859-1"),"utf-8");
		System.out.println(bumen);
		String zhiwei=new String(req.getParameter("zhiwei").getBytes("iso-8859-1"),"utf-8");
		String datetime = req.getParameter("time");//获取表单信息
		String sex=new String(req.getParameter("sex").getBytes("iso-8859-1"),"utf-8");
		String email=new String(req.getParameter("email").getBytes("iso-8859-1"),"utf-8");
		String tel=new String(req.getParameter("tel").getBytes("iso-8859-1"),"utf-8");
		String password=new String(req.getParameter("password").getBytes("iso-8859-1"),"utf-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置为指定格式

		//parse会报异常需要进行捕获
		
		Date renodate=null;
		try {
			renodate = sdf.parse(datetime);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserService service=new UserServiceImpl();
		User add=new User();
		add.setId(id);
		add.setName(name);
		add.setBumen(bumen);
		add.setZhiwei(zhiwei);
		add.setTime(renodate);
		add.setSex(sex);
		add.setTel(tel);
		add.setEmail(email);
		add.setPassword(password);
		
		if(add!=null)
		{
			service.add(add);
			resp.sendRedirect("user.jsp");
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
