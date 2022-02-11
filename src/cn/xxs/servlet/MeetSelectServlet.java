package cn.xxs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xxs.entity.Meet;
import cn.xxs.service.MeetService;
import cn.xxs.service.UserService;
import cn.xxs.service.impl.MeetServiceImpl;
import cn.xxs.service.impl.UserServiceImpl;

public class MeetSelectServlet extends HttpServlet {

	
	/**
	 * Constructor of the object.
	 */
	public MeetSelectServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method=request.getParameter("method");//得到传入的值下面根据传入的值执行不同的方法！！
        System.out.println("method"+method);
        
        if(method.equals("detail"))
        {
        	detail(request,response);
        	System.out.println("*************");
        }else if(method.equals("shenhe"))
        {
        	shenhe(request,response);
        }
	}

	public void detail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {


		int id=Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		MeetService service=new MeetServiceImpl();
		
		Meet m=service.select(id);
		
		if(m!=null){
			req.setAttribute("m", m);
			//转发
			req.getRequestDispatcher("meetdatil.jsp").forward(req, resp);
		}
		
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
	public void shenhe(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int id=Integer.parseInt(req.getParameter("id"));
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		MeetService service=new MeetServiceImpl();
		
		Meet m=service.select(id);
		
		if(m!=null){
			req.setAttribute("m", m);
			//转发
			req.getRequestDispatcher("meetExamine.jsp").forward(req, resp);
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
