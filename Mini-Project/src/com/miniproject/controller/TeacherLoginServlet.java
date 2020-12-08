package com.miniproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miniproject.db.StudentDAO;
import com.miniproject.db.TeacherDAO;

/**
 * Servlet implementation class TeacherLoginServlet
 */
@WebServlet("/ValidateTeacher1")
public class TeacherLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		
		

		String username = request.getParameter("name");
		String password = request.getParameter("password");
		
		boolean status = TeacherDAO.validate(username, password);
		if (username.equals("teacher1") && password.equals("password")) {
		//if(status) {
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);
			response.sendRedirect("TeacherHome.jsp");
		} else {
			String error = "Invalid Username or Password Entered ";
			response.sendRedirect("TeacherLogin.jsp?error=" + error);
		} // TODO Auto-generated method stub

	}
}

//		boolean status = TeacherDAO.validate(username, password);
//		if (status) {
//			// out.println("<p>Welcome" + username + "</p>");
//			HttpSession session = request.getSession();
//			session.setAttribute("username", username);
//			request.getRequestDispatcher("TeacherProfile.jsp").include(request, response);
//		} else {
//
//			String error = "Invalid Username or Password Entered ";
//			response.sendRedirect("StudentLogin.jsp?error=" + error);
//
//		}
//
//	}
