package com.doctor.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doctor.model.Doctor;
import com.doctor.service.DoctorServiceImpl;
import com.doctor.service.IDoctorService;

/**
 * Servlet implementation class AddDoctorServlet
 */
@WebServlet("/AddDoctorServlet")
public class AddDoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDoctorServlet() {
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
		
		response.setContentType("text/html");
		
		Doctor doctor = new Doctor();
		
		doctor.setFirstName(request.getParameter("firstname"));
		doctor.setLastName(request.getParameter("lastname"));
		doctor.setHospital(request.getParameter("hospital"));
		doctor.setMobileNo(request.getParameter("mobileno"));
		
		IDoctorService idoctorService = new DoctorServiceImpl();
		idoctorService.addDoctor(doctor);
		
		
		request.setAttribute("doctor",doctor);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/allDoctors.jsp");
		dispatcher.forward(request, response);
		
	}

}

