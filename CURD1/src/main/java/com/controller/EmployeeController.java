package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.Employee;
import com.dao.EmployeeDao;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               String action =request.getParameter("action");
               if(action.equalsIgnoreCase("insert")) {
            	   Employee s=new Employee();
            	   s.setFname(request.getParameter("fname"));
            	   s.setLname(request.getParameter("lname"));
            	   s.setEmail(request.getParameter("email"));
            	   s.setMobile(request.getParameter("mobile"));
            	   s.setAddress(request.getParameter("address"));
            	   s.setGender(request.getParameter("gender"));
                   EmployeeDao.insertEmployee(s);
            	   request.setAttribute("msg", "Data Is SuccessFully Insert");
            	   response.sendRedirect("insert.jsp");
               }
               else if(action.equalsIgnoreCase("edit")) {
     	    	  int id=Integer.parseInt(request.getParameter("id"));
     	    	 Employee s=EmployeeDao.getEmployees(id);
     	    	  request.setAttribute("s", s);
     	    	 request.getRequestDispatcher("update.jsp").forward(request, response);
     	      }
     	      
     	      else if(action.equalsIgnoreCase("update")) {
     	    	 Employee s=new Employee();
     	    	  s.setId(Integer.parseInt(request.getParameter("id")));
     	    	  s.setFname(request.getParameter("fname"));
     	    	  s.setLname(request.getParameter("lname"));
     	    	  s.setEmail(request.getParameter("email"));
     	    	  s.setMobile(request.getParameter("mobile"));
     	    	  s.setAddress(request.getParameter("address"));
     	    	  s.setGender(request.getParameter("gender"));
     	    	 EmployeeDao.updateEmployee(s);
     	    	  response.sendRedirect("Show.jsp");
     	      }
     	      else if(action.equalsIgnoreCase("delete")) {
     	    	  int id=Integer.parseInt(request.getParameter("id"));
     	    	 EmployeeDao.deleteEmployee(id);
     	    	  response.sendRedirect("Show.jsp");
     	    	  
     	      }
     	}


}
