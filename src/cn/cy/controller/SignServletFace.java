package cn.cy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;




import cn.cy.domain.Image;
import cn.cy.domain.Result;
import cn.cy.service.FaceSearch;
import cn.cy.service.imp.FaceSearchImp;
import cn.xxs.entity.Meet;
import cn.xxs.entity.Sign;
import cn.xxs.service.MeetService;
import cn.xxs.service.SignService;
import cn.xxs.service.impl.MeetServiceImpl;
import cn.xxs.service.impl.SignServiceImpl;
import cn.xxs.util.DateUtil;

public class SignServletFace extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FaceSearch faceSearch = new FaceSearchImp();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, HaiYi-Access-Token");
		//获取会议的起始时间和结束时间  用于判断签到状态
		int meetid=Integer.parseInt(request.getParameter("meetid"));
		
		MeetService meetservice=new MeetServiceImpl();
		Meet m=meetservice.select(meetid);
		String starttime=m.getMeetstarttime().toString();
		String endtime=m.getMeetendtime().toString();
		
		String imgStr=request.getParameter("imgStr");
        String imgType=request.getParameter("imgType");
        Image image = new Image();
        image.setImgStr(imgStr);
        image.setImgType(imgType);
        
        DateUtil du=new DateUtil();
        Result result = faceSearch.faceLogin(image);
        JSONObject json = new JSONObject(result.toString());
        //单纯的记录一下 一个会议 有多少人
//        MeetService service=new MeetServiceImpl();
//		
//		Meet m=service.select(meetid);
//		String yuangong=m.getMeetjoin();
//		System.out.println(yuangong);
//		String[] data=yuangong.split(",");
//		int n=data.length;
        SignService signservice=new SignServiceImpl();
        
        if(result.isStart())
        {
        	int userid=Integer.parseInt(result.getUserId());
        	String qdtime=du.getNowTimestamp();
        	System.out.printf(qdtime);
        	Sign s=signservice.select2(userid);
        	int res1=qdtime.compareTo(starttime); //若qdtime小则 res<0
        	int res2=qdtime.compareTo(endtime); 
        	System.out.println("签到跳转！！！！！！！！！！！！！！！！！！！！！！！！！！！");
        	System.out.println(res1);
        	System.out.println(res2);
        	if(res1<0)//则代表 并没有晚   正常签到 
        	{
        		s.setQdstatus(1);
            	s.setQdtime(qdtime);
            	s.setMeet_id(meetid);
            	signservice.update(s);
        	}else if(res1>0&&res2<0)
        	{//迟到
        		s.setQdstatus(3);
            	s.setQdtime(qdtime);
            	s.setMeet_id(meetid);
            	signservice.update(s);
        	}
        	System.out.println("更新成功");
        }else {
        	System.out.println("失败"+result.getErrorMsg());
        }
        response.getWriter().print(json);
        
		
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

		doGet(request, response);
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
