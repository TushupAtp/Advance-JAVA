package com.cdac.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdac.model.Option;
import com.cdac.model.Question;
import com.cdac.model.QuestionBankLoader;

/**
 * Servlet implementation class QuestionLoaderServlet
 */
@WebServlet("/QuestionLoaderServlet")
public class QuestionLoaderServlet extends HttpServlet {

	private List<Question> listOfQuestions;
	private int qNo;
	
	@Override
	public void init() throws ServletException {
		QuestionBankLoader qbLoader = new QuestionBankLoader();
		listOfQuestions = qbLoader.loadQuestionsOnJava();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(qNo < listOfQuestions.size()) {
			Question q = listOfQuestions.get(qNo++);
		
			HttpSession session = request.getSession();
			session.setAttribute("currentQs", q);
			
			response.sendRedirect("viewQuestion.jsp");
			/*PrintWriter out = response.getWriter();
			out.println("<h1>" + q.getQuestion() + "</h1>");
			for(Option op : q.getOptions()) {
				out.println("<h3>" + op.getOption() + "</h3>");
			}*/
		}
		else
			response.sendRedirect("result.jsp");
	}

}
