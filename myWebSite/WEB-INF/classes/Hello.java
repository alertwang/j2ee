//ʵ�ֽӿڵķ�ʽ������
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
	//�ú���ֻ�ᱻ����һ��,���û���һ�η��ʸ�servlet��ʱ��Żᱻ����
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
	//���ڴ���ҵ���߼�,����ԱӦ�ð�ҵ���߼��������˺���
	//���û�ÿ����һ�ε�ʱ��ͻ���øú���һ��
	//req���ڻ�ÿͻ��˵���Ϣ
	//res������ͻ��˷�����Ϣ(�ͻ���=�����)
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
	//����servletʵ��,�ͷ��ڴ�
	//reload��servlet(webapps)��ʱ��,�ر�Tomcat,�ػ�
	public void destroy() {
		// TODO: Add your code here
		System.out.println("destory!");
	}

};