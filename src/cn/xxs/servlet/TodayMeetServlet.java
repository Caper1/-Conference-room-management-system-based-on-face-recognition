package cn.xxs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import cn.xxs.entity.Meet;
import cn.xxs.service.MeetService;
import cn.xxs.service.impl.MeetServiceImpl;
import cn.xxs.util.DateUtil;
import cn.xxs.util.JsonDateValueProcessor;

import com.sun.jmx.snmp.Timestamp;

public class TodayMeetServlet extends HttpServlet {
	
	
	/**
	 * Constructor of the object.
	 */
	public TodayMeetServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		MeetService service=new MeetServiceImpl();
		DateUtil du=new DateUtil();
		String time1=du.getStartTimestamp().toString();
		System.out.println(time1);
		String time2=du.getEndTimestamp().toString();
		String meetlocation=new String(req.getParameter("meetlocation").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(meetlocation);
		List<Meet> list=service.findbylocationstatus(meetlocation, time1, time2);
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
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		MeetService service=new MeetServiceImpl();
		String time1="2021-04-16 00:00:00";
		String time2="2021-04-16 23:59:59";
		String meetlocation=req.getParameter("meetlocation");
		System.out.println(meetlocation);
		List<Meet> list=service.findbylocationstatus(meetlocation, time1, time2);
		
		JsonConfig config = new JsonConfig();
        config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        
		JSONArray jsonArray = JSONArray.fromObject(list,config);
		

		String str = "{\"code\":0,\"msg\":\"\",\"count\":" + 12 + ",\"data\":" + jsonArray.toString() + "}";
		System.out.println(str);
		resp.getWriter().write(str);
		

		
		
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
