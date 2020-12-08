package com.miniproject.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.miniproject.db.StudentDAO;
import com.miniproject.model.Student;

/**
 * Servlet Filter implementation class StudentInsertValidator
 */
@WebFilter("")
public class StudentInsertValidator implements Filter {

    
    public StudentInsertValidator() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Student s = new Student(id,name, username, password);

		int status = StudentDAO.getStudentById(id);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
