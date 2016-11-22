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
 * Servlet implementation class OrderStatus
 */
@WebServlet("/OrderStatus")
public class OrderStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderStatus() {
        super();
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
		int Order_no=Integer.parseInt(request.getParameter("Order_no"));
		String orderStatus="C";
		CafeteriaBean cb=new CafeteriaBean();
		DbOperation db=new DbOperation();
		
		cb.setOrderNo(Order_no);
		cb.setStatus(orderStatus);
		db.updateOrder(cb);
		db.processOrder(cb);
		
		RequestDispatcher rd=request.getRequestDispatcher("OrderDetails.jsp");
		request.setAttribute( "empId",String.valueOf(cb.getEmpid()));
		System.out.println("55:"+String.valueOf(cb.getEmpid()));
		request.setAttribute("eName",cb.geteName());
		System.out.println("57:"+cb.geteName());
		request.setAttribute("food",cb.getFood());
		System.out.println("59:"+cb.getFood());
		request.setAttribute("quantity",String.valueOf(cb.getQuantity()));
		System.out.println("61:"+String.valueOf(cb.getQuantity()));
		request.setAttribute("orderNo",String.valueOf(cb.getOrderNo()));
		System.out.println("63:"+String.valueOf(cb.getOrderNo()));
		request.setAttribute("status",cb.getStatus());
		System.out.println("65:"+cb.getStatus());
		rd.forward(request, response);
		
	}

}
