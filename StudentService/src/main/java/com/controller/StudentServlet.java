package com.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.modal.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/studentS")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 List<Student> studentlist = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		studentlist = new ArrayList <>();
		
		studentlist.add(new Student(100, "Bala", 95.6));
		studentlist.add(new Student(101, "pradeep", 98.6));
		studentlist.add(new Student(102, "venkat", 97.6));
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		Gson gson = new Gson();
		String result = gson.toJson(studentlist);
		response.getOutputStream().print(result);		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("Hello");
            BufferedReader reader = request.getReader();
            String line = null;
            Gson gson = new Gson();
            Student stu = null;
            while((line=reader.readLine())!=null) {
            	
            	stu = gson.fromJson(line, Student.class);
            	
            	System.out.println(stu);
            	
            }
		
		
		
//		int rollnumber = Integer.parseInt(request.getParameter("rollNumber"));
//		String studentName = request.getParameter("studentName");
//		double markScored = Double.parseDouble(request.getParameter("markScored"));
//		
//		Student stu = new Student(rollnumber, studentName, markScored);
		
		studentlist.add(stu);
		
		
		
		response.getOutputStream().print("one row added");

		
		
		
	}

}
