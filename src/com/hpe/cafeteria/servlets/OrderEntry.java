package com.hpe.cafeteria.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.cafeteria.db.CafeteriaBean;
import com.hpe.cafeteria.db.DbOperation;

/**
 * Servlet implementation class OrderEntry
 */
@WebServlet("/OrderEntry")
public class OrderEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public OrderEntry() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int empId=Integer.parseInt(request.getParameter("empid"));
		String eName=request.getParameter("ename");
		String food=request.getParameter("food");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
		CafeteriaBean cb=new CafeteriaBean();
		DbOperation db=new DbOperation();
		
		cb.setEmpid(empId);
		cb.seteName(eName);
		cb.setFood(food);
		cb.setQuantity(quantity);
		db.makeOrderEntry(cb);
		
		RequestDispatcher rd=request.getRequestDispatcher("Thankyou.jsp");
		rd.forward(request, response);
		
		
		
	}

}
