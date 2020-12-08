package com.miniproject.controller;
/*
 * This servlet deletes the record of the question when called from question repository.
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miniproject.db.QuestionsDAO;
import com.miniproject.db.StudentDAO;

/**
 * Servlet implementation class QuestionDeleteServlet
 */
@WebServlet("/QuestionDeleteServlet")
public class QuestionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        QuestionsDAO.deleteQuestion(id);  
        response.sendRedirect("QuestionRepository.jsp");  
    }  

}
