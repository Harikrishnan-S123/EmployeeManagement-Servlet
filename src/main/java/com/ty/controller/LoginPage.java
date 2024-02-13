package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.ty.dao.LoginDao;
import com.ty.entity.UserInfo;

@WebServlet(value = "/login")
public class LoginPage extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		UserInfo user = (new LoginDao()).giveLogin(email,password);
		PrintWriter out = resp.getWriter();
		if (user != null) {
			HttpSession session=req.getSession();
			session.setAttribute("user", user);
			out.print("<html><body>");
			out.print("<h1>Sucess Login</h1>");
			out.print("</body></html>");
			if(user.getRole().equals("Employee")) {
                resp.sendRedirect("userlogin.jsp");
			}
			else {
				resp.sendRedirect("managerlogin.jsp");
			}

		} else {
			out.print("<html><body>");
			out.print("<h1>Invalid Login</h1>");
			out.print("</body></html>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
	}
}
