package com.miniproject.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.miniproject.db.QuestionsDAO;
import com.miniproject.db.ResultDAO;
import com.miniproject.db.StudentDAO;
import com.miniproject.model.Question;
import com.miniproject.model.Result;

/**
 * Servlet implementation class Resutl
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		PrintWriter out = response.getWriter();
		
		if(session.getAttribute("username")!=null && session.getAttribute("username")!="")
		
		{	
			String[] answer = new String[100];
			ArrayList<Question> allQuestions = QuestionsDAO.getAllQuestions();
			int i = 0;
			int marks = 0;
			int total = 0;
			int size = allQuestions.size();
			for(Question q : allQuestions)
				{   
					answer[i] = q.getAnswer();
					  i++;
				}
			String[] studentAnswer = new String[100];
			for(int j = 0 ; j < size ; j++)
				{
					studentAnswer[j] = request.getParameter(Integer.toString(j));
				}
			int correctanswer=0;
			int unattempted = 0;
			int wronganswer=0;
			for(int k = 0 ; k< size;k++)
			{
				if(studentAnswer[k].equalsIgnoreCase(answer[k]))
				{
					correctanswer++;
					marks += 1;
				}
				else if(studentAnswer[k].equals("e"))
				{
					unattempted++;
				}
				else
				{
					wronganswer++;
				}
				total = total+1;
			}
			int attemped = size - unattempted;
			
			System.out.println("Hello");
			
			//RequestDispatcher rd = request.getRequestDispatcher("score1.jsp");
			request.setAttribute("attempted", attemped);
			request.setAttribute("marks", marks);
			request.setAttribute("Total", total);
			
			String name = (String) session.getAttribute("username");
			System.out.println(name);
			System.out.println(attemped);
			System.out.println(marks);
			System.out.println(total);
			
			Result result = new Result(name, marks, total);
			
			int status = ResultDAO.saveResult(result);
			if (status > 0) {
				request.getRequestDispatcher("FinalResult.jsp").include(request, response);
			} else {
				out.println("Sorry Unable to save the record");
				response.sendRedirect("StudentProfile.jsp");
			}

	}
}
}
