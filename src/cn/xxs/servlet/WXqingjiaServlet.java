package cn.xxs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import cn.cy.domain.Result;
import cn.xxs.entity.Sign;
import cn.xxs.entity.User;
import cn.xxs.service.SignService;
import cn.xxs.service.impl.SignServiceImpl;

public class WXqingjiaServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public WXqingjiaServlet() {
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
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

				//获取meetid 和请假缘由
				int meetid=Integer.parseInt(req.getParameter("meetid"));
				String name=new String(req.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
				String qingjiayuanyin=new String(req.getParameter("qingjiayuanyin").getBytes("ISO-8859-1"),"UTF-8");
				//根据 qingjianame和meetid更新签到表
				SignService signservice=new SignServiceImpl();
				Sign s=new Sign();
				s=signservice.select(name, meetid);

				s.setQingjiayuanyin(qingjiayuanyin);
				s.setQdstatus(2);
				if(s!=null)
				{
				signservice.update2(s);
				}
				Result result = new Result();
                result.setErrorMsg("请假申请已提交，请等待审核！");
                JSONObject json = new JSONObject(result.toString());
				resp.getWriter().print(json);
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
