package com.miniproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miniproject.db.StudentDAO;

/**
 * Servlet implementation class StudentLoginServlet
 */
@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String username = request.getParameter("name");
		String password = request.getParameter("password");

		boolean status = StudentDAO.validateStudent(username, password);
		if (status) {
			// out.println("<p>Welcome" + username + "</p>");
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			request.getRequestDispatcher("StudentProfile.jsp").include(request, response);
		} else {

			String error = "Invalid Username or Password Entered ";
			response.sendRedirect("StudentLogin.jsp?error=" + error);

		}

	}

}
