package cn.xxs.servlet;
import cn.xxs.entity.Room;

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

import cn.xxs.service.MeetService;
import cn.xxs.service.RoomService;
import cn.xxs.service.impl.MeetServiceImpl;
import cn.xxs.service.impl.RoomServiceImpl;
import cn.xxs.util.DateUtil;
import cn.xxs.util.JsonDateValueProcessor;

public class RoomSelectAllServlet extends HttpServlet {
	/**
	 * Constructor of the object.
	 */
	public RoomSelectAllServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		RoomService service=new RoomServiceImpl();
		
		MeetService meetservice=new MeetServiceImpl();
		
		List<Room> list=service.selectAll();
		System.out.println("查询会议室跳转Servlet");
		//判断会议室状态
		for(int i=0;i<list.size();i++)
		{
			String meetlocation=list.get(i).getRoomlocation(); //获取会议地点
			
			//获取当前时间
			DateUtil du=new DateUtil();
			String nowtime=du.getNowTimestamp();
			System.out.println(nowtime);
			//获取当前会议室状态
			Room r =new Room();
			r=service.select(meetlocation);
			int meetstatus=r.getRoomstatus();
			System.out.println(meetstatus);
			if(meetstatus==1)
			{	
				System.out.println("忙");
				//如果一开始状态为空闲,且现在时间为占用时间，则将空闲改为占用
				if(!meetservice.isBusy(meetlocation, nowtime)){ //如果表示空闲 什么也不做 1代表空闲 0代表占用   //
					//若占用则需要更新会议室状态 status字段为0
					r.setRoomstatus(0);
					
					service.update(r);
				}
			}else
			{
				if(meetservice.isBusy(meetlocation, nowtime))
				{
					r.setRoomstatus(1);
					service.update(r);
				}
			}
			
		}
		//更新后重新遍历一次
		List<Room> list1=service.selectAll();
		//把list转换成json
		JSONArray jsonArray = JSONArray.fromObject(list1);
		String str = "{\"code\":0,\"msg\":\"\",\"count\":" + 12 + ",\"data\":" + jsonArray.toString() + "}";
		System.out.println(str);
		response.getWriter().write(str);
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
		RoomService service=new RoomServiceImpl();
		
		List<Room> list=service.selectAll();
		System.out.println("很烦");
		//把list转换成json
        
		JSONArray jsonArray = JSONArray.fromObject(list);
		

		String str = "{\"code\":0,\"msg\":\"\",\"count\":" + 12 + ",\"data\":" + jsonArray.toString() + "}";
		System.out.println(str);
		response.getWriter().write(str);
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
