package cn.xxs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import cn.xxs.entity.Admin;
import cn.xxs.entity.Meet;
import cn.xxs.entity.User;
import cn.xxs.service.MeetService;
import cn.xxs.service.impl.MeetServiceImpl;
import cn.xxs.util.JsonDateValueProcessor;

public class MeetTongzhiServlet1 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MeetTongzhiServlet1() {
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		int tp=Integer.parseInt(request.getParameter("tp[]"));
		System.out.println(tp);
		MeetService service=new MeetServiceImpl();
		User user=(User)request.getSession().getAttribute("user");
		
		String meetsqr=user.getName();

		List<Meet> list=service.findbymeetsqrshstatus(meetsqr,tp); //查询到审核通过的并由meetsqr发起的会议
		
		//把list转换成json
		JsonConfig config = new JsonConfig();
        config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        
		JSONArray jsonArray = JSONArray.fromObject(list,config);
		response.getWriter().print(jsonArray.toString());
		System.out.println(jsonArray.toString());
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
