package com.ty.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.dao.TaskDao;
import com.ty.entity.Task;
import com.ty.entity.UserInfo;
@WebServlet(value = "/changestatus")
public class UserStatusChangeServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   // HttpSession session=req.getSession();
		    String taskId=req.getParameter("taskid");
		    System.out.println(taskId);
			Task task=(new TaskDao()).updateTask(taskId);
			if(task!=null) {
				System.out.println("Updated");
				resp.sendRedirect("usertask.jsp");
			}
			else
				System.out.println("not");
		}
	

}
