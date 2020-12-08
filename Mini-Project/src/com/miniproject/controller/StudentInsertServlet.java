package com.miniproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miniproject.db.StudentDAO;
import com.miniproject.model.Student;

/**
 * Servlet implementation class StudentInsertServlet
 */
@WebServlet("/StudentInsertServlet")
public class StudentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentInsertServlet() {
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
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Student s = new Student(Integer.parseInt(id),name, username, password);

		int status = StudentDAO.insertStudent(s);
		if (status > 0) {
			String success = "Record Saved Successfully ";
			request.getRequestDispatcher("AddStudent.jsp?success="+success).include(request, response);
		} else {
			String fail = "Insert Failed. ";
			request.getRequestDispatcher("AddStudent.jsp?fail="+fail).include(request, response);
		}

	}

}
