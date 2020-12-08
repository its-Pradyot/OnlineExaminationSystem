package com.miniproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miniproject.model.Student;
import com.miniproject.db.StudentDAO;

/**
 * Servlet implementation class StudentEditServlet
 */
@WebServlet("/EditServlet")
public class StudentEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			this.doPost(request, response);
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Student s = new Student();
		s.setId(id);
		s.setName(name);
		s.setUsername(username);
		s.setPassword(password);

		int status = StudentDAO.updateStudent(s);
		if (status > 0) {
			response.sendRedirect("StudentRepository.jsp");
		} else {
			out.println("Sorry! unable to update record");
		}

		out.close();
	}

}
