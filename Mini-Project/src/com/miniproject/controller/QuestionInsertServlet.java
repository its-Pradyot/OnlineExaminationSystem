package com.miniproject.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miniproject.db.QuestionsDAO;

import com.miniproject.model.Question;


/**
 * Servlet implementation class QuestionInsertServlet
 */
@WebServlet("/QuestionInsertServlet")
public class QuestionInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionInsertServlet() {
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
		String question = request.getParameter("question");
		String option1 = request.getParameter("optionA");
		String option2 = request.getParameter("optionB");
		String option3 = request.getParameter("optionC");
		String option4 = request.getParameter("optionD");
		String answer = request.getParameter("answer");

		

		Question q = new Question(Integer.parseInt(id), question, option1, option2, option3, option4, answer);
		int status = QuestionsDAO.insertQuestion(q);
		if (status > 0) {
			out.println("<p>Record Saved Successfully</p>");
			request.getRequestDispatcher("AddQuestion.jsp").include(request, response);
		} else {
			out.println("Sorry Unable to save the record");
		}

	}

}
