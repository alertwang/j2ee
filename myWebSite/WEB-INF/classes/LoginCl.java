package com.tsinghua;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;
import java.sql.*;

public class LoginCl extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res){
		Connection ct = null;
		Statement sm = null;
		ResultSet rs = null;
		try{
			String u = req.getParameter("username");
			String p = req.getParameter("passwd");
			//��֤
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			ct = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=spdb","sa","sa");
			sm = ct.createStatement();
			//rs = sm.executeQuery("select top 1 * from users where username='"+u+"' and passwd='"+p+"'");
			rs = sm.executeQuery("select top 1 passwd from users where username='"+u+"'");
			if(rs.next()){
					//�Ϸ��û���ת
				//res.sendRedirect("wel?uanme="+u+"&passwd="+p);//дservlet��url

				String pd = rs.getString(1);
				if(p.equals(pd)){
					res.sendRedirect("wel?uanme="+u+"&passwd="+p);//дservlet��url
					HttpSession hs = req.getSession(true);
					hs.setMaxInactiveInterval(20);//20s
					hs.setAttribute("pass", "ok");
				}
				else{
					//���Ϸ�
					res.sendRedirect("sp");//дservlet��url
				}

				//HttpSession hs = req.getSession(true);
				//hs.setMaxInactiveInterval(20);//20s
				//hs.setAttribute("pass", "ok");
			}else{
				//���Ϸ�
				res.sendRedirect("sp");//дservlet��url
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(sm!=null)sm.close();
				if(ct!=null)ct.close();
			}catch(Exception e){
				e.printStackTrace();
			}

		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res){
		this.doGet(req, res);
	}
}