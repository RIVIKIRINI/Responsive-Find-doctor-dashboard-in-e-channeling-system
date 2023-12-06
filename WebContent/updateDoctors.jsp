<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "com.doctor.model.Doctor" %>
<%@ page import = "com.doctor.service.IDoctorService" %>
<%@ page import = "com.doctor.service.DoctorServiceImpl" %>
<%@ page import = "java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-Channeling</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    h2 {
        text-align: center;
        color: #333;
    }

    form {
        width: 50%;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    input[type="submit"] {
        width: 100%;
        background-color: #0074D9;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>

<img src = "logo-dark.png" width="300" height="50">
    <h2>Update Doctor Details</h2>

    <% String doctorId = (String) request.getAttribute("doctorId");

    IDoctorService iDoctorService = new DoctorServiceImpl();
    ArrayList<Doctor> doctorList = iDoctorService.getDoctorById(doctorId); %>

    <% for (Doctor doctors : doctorList) { %>

    <form action="<%=request.getContextPath()%>/updateDoctorServlet" method="post">
        <input type="hidden" name="doctorId" value="<%= doctors.getDoctorId() %>">
        First Name <input type="text" name="firstname" value="<%= doctors.getFirstName() %>" required><br>
        Last Name <input type="text" name="lastname" value="<%= doctors.getLastName() %>"required><br>
        Hospital <input type="text" name="hospital" value="<%= doctors.getHospital() %>"required><br>
        Mobile Number <input type="text" name="mobilenumber" value="<%= doctors.getMobileNo() %>"required><br>
        <input type="Submit" value="Update">
    </form>

    <% } %>

</body>
</html>
