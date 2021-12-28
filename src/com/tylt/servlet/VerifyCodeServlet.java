package com.tylt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tylt.model.VerifyCode;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Servlet implementation class VerifyCodeServlet
 */
@WebServlet(name = "VerifyCodeServlet", value = "/VerifyCodeServlet")
public class VerifyCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VerifyCodeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��������
		VerifyCode vc = new VerifyCode();
		// ��ȡͼƬ����
		BufferedImage bi = vc.getImage();
		// ���ͼƬ���ı�����
		String text = vc.getText();
		// ��ϵͳ���ɵ��ı����ݱ��浽session��
		request.getSession().setAttribute("text", text);
		// ����������ͼƬ
		vc.output(bi, response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
