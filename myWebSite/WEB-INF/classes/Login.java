package com.tsinghua;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class Login extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res){
		try{

			//������������
			res.setContentType("text/html;charset=gbk");

			PrintWriter pw = res.getWriter();

			pw.println("<html>");
			pw.println("<body>");
			pw.println("<h1>��¼����</h1>");
			pw.println("<form action=loginCl method=post>");
			pw.println("�û���:<input type=text name=username><br>");
			pw.println("����:<input type=password name=passwd><br>");
			pw.println("<input type=submit value=login><br>");
			pw.println("</form>");
			pw.println("</body>");
			pw.println("</html>");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res){
		this.doGet(req, res);
	}
}