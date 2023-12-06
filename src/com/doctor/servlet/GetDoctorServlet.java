package com.doctor.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doctor.service.DoctorServiceImpl;
import com.doctor.service.IDoctorService;


@WebServlet("/GetDoctorServlet")
public class GetDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetDoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String doctorId = request.getParameter("doctorId");
		
		IDoctorService iDoctorService = new DoctorServiceImpl();
		iDoctorService.getDoctorById(doctorId);
		
		request.setAttribute("doctorId",doctorId);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/updateDoctors.jsp");
		dispatcher.forward(request, response);
	}

}
