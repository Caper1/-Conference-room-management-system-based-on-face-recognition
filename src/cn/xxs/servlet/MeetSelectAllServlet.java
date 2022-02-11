package cn.xxs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import cn.xxs.entity.Meet;
import cn.xxs.entity.Room;
import cn.xxs.service.MeetService;
import cn.xxs.service.RoomService;
import cn.xxs.service.impl.MeetServiceImpl;
import cn.xxs.service.impl.RoomServiceImpl;
import cn.xxs.util.DateUtil;
import cn.xxs.util.JsonDateValueProcessor;

public class MeetSelectAllServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MeetSelectAllServlet() {
		super();
		
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
//protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String method=request.getParameter("method");//得到传入的值下面根据传入的值执行不同的方法！！
//        System.out.println("method"+method);
//        
//        if(method.equals("duotiaojian"))
//        {
//        	findby(request,response);
//        	System.out.println("*************");
//        }else if(method.equals("shenhe"))
//        {
//        	
//        }
//	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		MeetService service=new MeetServiceImpl();
		
		List<Meet> list=service.selectAll();
		System.out.println("不输出meetstatus为0的会议");
		//判断会议状态
		
		//获取当前时间
		DateUtil du=new DateUtil();
		String nowtime=du.getNowTimestamp();
		System.out.println(nowtime);
		for(int i=0;i<list.size();i++)
		{
			//获取当前会议id
			int meetid=list.get(i).getId();
			//获取当前会议状态
			int meetstatus=list.get(i).getMeetstatus();
			
			//比较  mowtime 与会议的开始结束时间
			int res1=nowtime.compareTo(list.get(i).getMeetstarttime().toString()); //若nowtime小则 res<0
			int res2=nowtime.compareTo(list.get(i).getMeetendtime().toString());   
			if(meetstatus==0)
			{	
				if(res1<0)
				{
					System.out.println("什么也不做");
				}
				else if(res1>0&&res2<0)
				{
					Meet m=service.select(meetid);
					m.setMeetstatus(1);
					service.update(m);
				}
				else if(res2>0)
				{
					Meet m=service.select(meetid);
					m.setMeetstatus(2);
					service.update(m);
				}
			}
			else if(meetstatus==1)
			{
				
				if(res2>0)
				{
					Meet m=service.select(meetid);
					m.setMeetstatus(2);
					service.update(m);
				}
				else if(res1<0)
				{
					System.out.println("nnmmmmmmmmmm");
					Meet m=service.select(meetid);
					m.setMeetstatus(0);
					service.update(m);
				}
			}		
		}
		
		//把list转换成json
		JsonConfig config = new JsonConfig();
        config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        
		JSONArray jsonArray = JSONArray.fromObject(list,config);
		

		String str = "{\"code\":0,\"msg\":\"\",\"count\":" + 12 + ",\"data\":" + jsonArray.toString() + "}";
		System.out.println(str);
		response.getWriter().write(str);
		
	}
	
//	public void findby(HttpServletRequest req, HttpServletResponse resp)
//			throws ServletException, IOException {
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html");
//		MeetService service=new MeetServiceImpl();
//		
//		String meetsqr=req.getParameter("key[meetsqr]");
//		String meetlocation=req.getParameter("key[meetlocation]");
//		System.out.println(meetlocation);
//		String starttime=req.getParameter("key[starttime]");
//		String endtime=req.getParameter("key[endtime]");
//		if(meetsqr==null)
//		{
//			meetsqr="";
//		}
//		if(meetlocation==null)
//		{
//			meetlocation="";
//		}
//		if(starttime==null)
//		{
//			starttime="";
//		}
//		if(endtime==null)
//		{
//			endtime="";
//		}
//		
//		System.out.println(meetlocation);
//		List<Meet> list=service.findby(meetsqr, meetlocation, starttime, endtime);
//		//把list转换成json   
//		JsonConfig config = new JsonConfig();
//        config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
//        
//		JSONArray jsonArray = JSONArray.fromObject(list,config);
//		
//
//		String str = "{\"code\":0,\"msg\":\"\",\"count\":" + 12 + ",\"data\":" + jsonArray.toString() + "}";
//		System.out.println(str);
//		resp.getWriter().write(str);
//
//		
//	}
	
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
		
		String meetsqr=req.getParameter("key[meetsqr]");
		String meetlocation=req.getParameter("key[meetlocation]");
		System.out.println(meetlocation);
		String starttime=req.getParameter("key[meetstartime]");
		String endtime=req.getParameter("key[meetendtime]");
		System.out.println(starttime);
		if(meetsqr==null)
		{
			meetsqr="";
		}
		if(meetlocation==null)
		{
			meetlocation="";
		}
		if(starttime==null)
		{
			starttime="";
		}
		if(endtime==null)
		{
			endtime="";
		}
		
		System.out.println(meetlocation);
		System.out.println(endtime);
		System.out.println(starttime);
		List<Meet> list=service.findby(meetsqr, meetlocation, starttime, endtime);
		//获取当前时间
				DateUtil du=new DateUtil();
				String nowtime=du.getNowTimestamp();
				System.out.println(nowtime);
				for(int i=0;i<list.size();i++)
				{
					//获取当前会议id
					int meetid=list.get(i).getId();
					//获取当前会议状态
					int meetstatus=list.get(i).getMeetstatus();
					
					//比较  mowtime 与会议的开始结束时间
					int res1=nowtime.compareTo(list.get(i).getMeetstarttime().toString()); //若nowtime小则 res<0
					int res2=nowtime.compareTo(list.get(i).getMeetendtime().toString());   
					if(meetstatus==0)
					{	
						if(res1<0)
						{
							System.out.println("什么也不做");
						}
						else if(res1>0&&res2<0)
						{
							Meet m=service.select(meetid);
							m.setMeetstatus(1);
							service.update(m);
						}
						else if(res2>0)
						{
							Meet m=service.select(meetid);
							m.setMeetstatus(2);
							service.update(m);
						}
					}
					else if(meetstatus==1)
					{
						if(res2>0)
						{
							Meet m=service.select(meetid);
							m.setMeetstatus(2);
							service.update(m);
						}
						else if(res1<0)
						{
							System.out.println("nnmmmmmmmmmm");
							Meet m=service.select(meetid);
							m.setMeetstatus(0);
							service.update(m);
						}
					}		
				}
				
		//把list转换成json   
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
