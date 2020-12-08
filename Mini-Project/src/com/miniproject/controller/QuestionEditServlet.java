package com.miniproject.controller;
/*
 * This servlet updates the record of the question.
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miniproject.db.QuestionsDAO;
import com.miniproject.db.StudentDAO;
import com.miniproject.model.Question;
import com.miniproject.model.Student;

/**
 * Servlet implementation class QuestionEditServlet
 */
@WebServlet("/QuestionEditServlet")
public class QuestionEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
		
			String id = request.getParameter("id");
			String question = request.getParameter("question");
			String option1 = request.getParameter("optionA");
			String option2 = request.getParameter("optionB");
			String option3 = request.getParameter("optionC");
			String option4 = request.getParameter("optionD");
			String answer = request.getParameter("answer");

			Question q = new Question(Integer.parseInt(id), question, option1, option2, option3, option4, answer);
			
			int status = QuestionsDAO.updateQuestion(q);
			if (status > 0) {
				response.sendRedirect("QuestionRepository.jsp");
			} else {
				out.println("Sorry! unable to update record");
			}
	
		out.close();
		}


}
