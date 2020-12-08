package com.miniproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miniproject.db.StudentDAO;
import com.miniproject.model.Student;

/**
 * Servlet implementation class ViewAllStudentServlet
 */
@WebServlet("/ViewAllStudentServlet")
public class ViewAllStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			this.doPost(request, response);
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='InsertStudent.jsp'>Add New Student</a>");  
        out.println("<h1>Students List</h1>");  
          
        List<Student> list=StudentDAO.getAllStudents();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Edit</th><th>Delete</th></tr>");  
        for(Student s:list){  
        	out.print("<tr><td>"+s.getId()+"</td><td>"+s.getName()+"</td><td>"+s.getPassword()+"</td><td><a href='EditServlet1?id="+s.getId()+"'>edit</a></td><td><a href='DeleteStudentServlet?id="+s.getId()+"'>delete</a></td></tr>");        
        }  
        out.print("</table>");  
          
        out.close();  
    }
}


