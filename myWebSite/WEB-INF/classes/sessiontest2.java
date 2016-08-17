
package com.tsinghua;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class sessiontest2 extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try{
			PrintWriter pw = res.getWriter();
			HttpSession hs = req.getSession();
			String id = hs.getId();
			hs.setAttribute("name", "shunping");
			hs.setMaxInactiveInterval(30);
			pw.println("sessionid="+id+" name=shunping");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void doPos(HttpServletRequest req, HttpServletResponse res){
		this.doGet(req,res);
	}
}
