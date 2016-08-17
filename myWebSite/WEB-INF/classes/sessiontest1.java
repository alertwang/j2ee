
package com.tsinghua;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class sessiontest1 extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try{
			PrintWriter pw = res.getWriter();
			HttpSession hs = req.getSession();
			String id = hs.getId();
			String name = (String)hs.getAttribute("name");
			pw.println("sessionid="+id+", name="+name);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void doPos(HttpServletRequest req, HttpServletResponse res){
		this.doGet(req,res);
	}
}
