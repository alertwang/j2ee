package com.tsinghua;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;

public class HelloHttp extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		//ҵ���߼������ﴦ��
		try{
			PrintWriter pw = res.getWriter();
			pw.println("hello,http");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res){
		this.doGet(req, res);
	}
}