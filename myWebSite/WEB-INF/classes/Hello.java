//实现接口的方式来开发
package com.tsinghua;


import javax.servlet.*;
import java.io.*;

public class Hello implements Servlet{
	/**
	 * Method init
	 *
	 *
	 * @param parm1
	 *
	 @throws ServletException
	 *
	 */
	//该函数只会被调用一次,当用户第一次访问该servlet的时候才会被调用
	public void init(ServletConfig parm1) throws ServletException {
		// TODO: Add your code here
		System.out.println("init it");
	}

	/**
	 * Method getServletConfig
	 *
	 *
	 * @return
	 *
	 */
	public ServletConfig getServletConfig() {
		// TODO: Add your code here
		return null;
	}

	/**
	 * Method service
	 *
	 *
	 * @param parm1
	 * @param parm2
	 *
	 @throws ServletException
	 @throws IOException
	 *
	 */
	//用于处理业务逻辑,程序员应该把业务逻辑代码放入此函数
	//当用户每访问一次的时候就会调用该函数一次
	//req用于获得客户端的信息
	//res用于向客户端返回信息(客户端=浏览器)
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO: Add your code here
		System.out.println("service it");
		PrintWriter pw = res.getWriter();
		pw.println("hello, world");
	}

	/**
	 * Method getServletInfo
	 *
	 *
	 * @return
	 *
	 */
	public String getServletInfo() {
		// TODO: Add your code here
		return null;
	}

	/**
	 * Method destroy
	 *
	 *
	 */
	//销毁servlet实例,释放内存
	//reload该servlet(webapps)的时候,关闭Tomcat,关机
	public void destroy() {
		// TODO: Add your code here
		System.out.println("destory!");
	}

};