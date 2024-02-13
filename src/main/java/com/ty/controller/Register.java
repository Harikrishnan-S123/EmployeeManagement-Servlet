package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.RegisterDao;

@WebServlet(value = "/register")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName=req.getParameter("userName");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String role=req.getParameter("role");
		String designation=req.getParameter("designation");
		String sal=req.getParameter("salary");
		double salary=Double.parseDouble(sal);
		(new RegisterDao()).createUser(userName, email, password, role, designation, salary);
		PrintWriter writer=resp.getWriter();
		writer.print("<html><body>");
		writer.print("<h1>Registered successfully</h1>");
		writer.print("</body></html>");
	}

}
