package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.ty.dao.TaskDao;

@WebServlet(value = "/assigned")
public class TaskAssignedServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("name");
		String description = req.getParameter("description");
		(new TaskDao()).assignTask(userId, description);
		PrintWriter out = resp.getWriter();
		out.print("<html><body>");
		out.print("<h1>Task added Succesfully<h1>");
//		JOptionPane.showMessageDialog(null, "Hello, world!");
		RequestDispatcher dispatcher = req.getRequestDispatcher("managertask.jsp");
		dispatcher.include(req, resp);
		out.print("</body></html>");
	}

}
