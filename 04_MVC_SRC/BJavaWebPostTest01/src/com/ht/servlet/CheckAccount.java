package com.ht.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckAccount extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		AccountBean account = new AccountBean();
		String username = req.getParameter("username");
		String pwd = req.getParameter("pwd");
		account.setPassword(pwd);
		account.setUsername(username);
		if ((username != null) && (username.trim().equals("jsp"))) {
			if ((pwd != null) && (pwd.trim().equals("1"))) {
				System.out.println("success");
				session.setAttribute("account", account);
				String login_suc = "success.jsp";
				resp.sendRedirect(login_suc);
				return;
			}
		}
		String login_fail = "fail.jsp";
		resp.sendRedirect(login_fail);
		return;
	}

}