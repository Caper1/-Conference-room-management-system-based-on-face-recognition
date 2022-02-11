package cn.xxs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import cn.xxs.entity.Meet;
import cn.xxs.entity.Sign;
import cn.xxs.entity.User;
import cn.xxs.service.MeetService;
import cn.xxs.service.SignService;
import cn.xxs.service.UserService;
import cn.xxs.service.impl.MeetServiceImpl;
import cn.xxs.service.impl.SignServiceImpl;
import cn.xxs.service.impl.UserServiceImpl;
import cn.xxs.util.JsonDateValueProcessor;

public class facefindServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public facefindServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	
//	public static void main(String[] args) {
//		doGet(request,response);
//		
//	}
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
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		User user=new User();
		UserService userservice=new UserServiceImpl();
		
		SignService signservice=new SignServiceImpl();
		
		int id=Integer.parseInt(req.getParameter("meetid"));//获取会议id
		//根据会议id查出会议参与人员
		MeetService service=new MeetServiceImpl();
		Meet m=service.select(id);
		//获取参与人的名字
		String meetjoin=m.getMeetjoin();
		//切割字符串
		String[] data=meetjoin.split(",");
		List<Sign> list = new ArrayList<Sign>();
		for(int i=0;i<data.length;i++)
		{
			Sign s=signservice.select(data[i],id);
			list.add(s);
		}
		JsonConfig config = new JsonConfig();
        config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        
		JSONArray jsonArray = JSONArray.fromObject(list,config);
		
		String str = "{\"code\":0,\"msg\":\"\",\"count\":" + 12 + ",\"data\":" + jsonArray.toString() + "}";
		System.out.println(str);
		resp.getWriter().write(str);
		
		
		
		

		
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
