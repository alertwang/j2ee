package com.tsinghua;


import javax.servlet.GenericServlet;
import javax.servlet.*;
import java.io.*;

public class HelloGen extends GenericServlet{
	//��дservice��������
	public void service(ServletRequest req, ServletResponse res){
		try{
			PrintWriter pw = res.getWriter();
			pw.println("hello world,generic");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}