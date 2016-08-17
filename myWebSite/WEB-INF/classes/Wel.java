package com.tsinghua;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class Wel extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res){

		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String u = req.getParameter("uanme");
		String p = req.getParameter("passwd");

		HttpSession hs = req.getSession(true);
		String val = (String)hs.getAttribute("pass");


		try{
			if(val==null){
				res.sendRedirect("sp");
				return;
			}

			res.setContentType("text/html;charset=gbk");
			//res.setCharacterEncoding("gbk");
			PrintWriter pw = res.getWriter();

			int pageSize = 3;
			int pageCount = 0;
			int rawCount =0;
			int pageNow=1;//希望显示第几页

			String s = req.getParameter("pageNow");
			if(s != null){
				pageNow = Integer.parseInt(s);
			}


			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=spdb","sa","sa");
			ps = ct.prepareStatement("select count(*)from users");
			rs = ps.executeQuery();

			if(rs.next()){
				rawCount = rs.getInt(1);
			}
			if(rawCount%pageSize != 0){
				pageCount=rawCount/pageSize+1;
			}else{
				pageCount=rawCount/pageSize;
			}

			ps = ct.prepareStatement("select top "+pageSize+" * from users where userId not in(select top "+(pageNow-1)*pageSize+" userId from users)");
			//ps = ct.prepareStatement("select top ? * from users where userId not in(select top ? userId from users)");
			//ps.setInt(1, pageSize);
			//ps.setInt(2, (pageNow-1)*pageSize);
			rs = ps.executeQuery();

			pw.println("<body><center>");

			pw.println("<table border=1");
			pw.println("<tr><th>id</th><th>name</th><th>passwd</th><th>email</th><th>grade</th></tr>");

			while(rs.next()){
				pw.println("<tr>");
				pw.println("<td>"+rs.getInt(1)+"</td>");
				pw.println("<td>"+rs.getString(2)+"</td>");
				pw.println("<td>"+rs.getString(3)+"</td>");
				pw.println("<td>"+rs.getString(4)+"</td>");
				pw.println("<td>"+rs.getInt(5)+"</td>");
				pw.println("<tr>");
			}
			pw.println("</table>");

			if(pageNow>1){
				pw.println("<a href=wel?pageNow="+(pageNow-1)+">上一页</a>");
			}

			for(int i=pageNow;i<pageCount&&i<=pageNow+4;i++){
				pw.println("<a href=wel?pageNow="+i+">"+i+"</a>");
			}


			if(pageNow<pageCount){
				pw.println("<a href=wel?pageNow="+(pageNow+1)+">下一页</a>");
			}
			pw.println("<br>");
			//在servlet中显示图片
			pw.println("<img src=imgs/1.gif><br>");

			pw.println("welcom, "+u+";passwd,"+p);

			pw.println("</center></body>");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res){
		this.doGet(req, res);
	}
}