package cn.xxs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import cn.xxs.entity.Meet;
import cn.xxs.service.MeetService;
import cn.xxs.service.impl.MeetServiceImpl;
import cn.xxs.util.JsonDateValueProcessor;

public class MeetAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MeetAddServlet() {
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
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		System.out.println("实现预约会议室");
		
		String meetname=req.getParameter("meetname");
		String meetlocation=req.getParameter("meetlocation");
		String meetsqr=req.getParameter("meetsqr");
		String meetcontext=req.getParameter("meetcontext");
		String meetjoin=req.getParameter("meetjoin");
		String meetstarttime=req.getParameter("meetstarttime");
		String meetendtime=req.getParameter("meetendtime");
		int shstatus=Integer.parseInt(req.getParameter("shstatus"));
		int meetstatus=Integer.parseInt(req.getParameter("meetstatus"));
		String yuanyin=req.getParameter("yuanyin");
		
		System.out.println(meetendtime);		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置为指定格式

		//parse会报异常需要进行捕获
		
		Date remeetstarttime=null;
		Date remeetendtime=null;
		try {
			remeetstarttime = sdf.parse(meetstarttime);
			remeetendtime=sdf.parse(meetendtime);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MeetService service=new MeetServiceImpl();
		Meet meet=new Meet();
		meet.setMeetname(meetname);
		meet.setMeetlocation(meetlocation);
		meet.setMeetsqr(meetsqr);
		meet.setMeetcontext(meetcontext);
		meet.setMeetjoin(meetjoin);
		meet.setMeetstarttime(remeetstarttime);
		meet.setMeetendtime(remeetendtime);
		meet.setShstatus(shstatus);
		meet.setMeetstatus(meetstatus);
		meet.setYuanyin(yuanyin);
		
		if(meet!=null)
		{
			service.add(meet);
			resp.getWriter().print(meetstatus);
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
