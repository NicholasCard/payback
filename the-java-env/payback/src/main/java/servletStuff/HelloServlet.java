package servletStuff;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import common.model.TestUsers;
import manager.TestManager;

@WebServlet("/Hello")
public class HelloServlet extends HttpServlet {
	
	ObjectMapper mapper = new ObjectMapper();
	
	private static TestManager tm = new TestManager();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		System.out.println("processing request ...");
		
		String name = request.getParameter("name");
		response.setContentType("application/json"); 
		response.setCharacterEncoding("UTF-8");
		
		TestUsers users = tm.showUsers();
		
		String newJson = mapper.writeValueAsString(name);
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Hello" + newJson + "</h1>");
		//out.println(tm.showUsers().get(0));

		String[] names = {"Mike","Kevin","Peter"};
		request.setAttribute("names", newJson);
		
		
		
		//Forwarding to JSP (Java Server Pages)
		//RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		
		//dispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
	
}