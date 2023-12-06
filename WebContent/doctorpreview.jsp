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
<title>E-Channeling|Find your doctor </title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
    }

    h1 {
        text-align: center;
        color: #333;
    }

    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        background-color: #fff;
    }

    th, td {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 12px;
    }

    th {
        background-color: #f2f2f2;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #e2e2e2;
    }

    input[type="submit"] {
        background-color:#0074D9;
        color: white;
        padding: 6px 10px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
        }
    button {
            background-color:  #0074D9; /* Green background */
            border: none; /* Remove borders */
            color: white; /* White text */
            padding: 10px 25px; /* Padding */
            text-align: center; /* Center-align text */
            text-decoration: none;
            display: inline-block;
            font-size: 16px; /* Font size */
            margin: 4px 2px; /* Margin */
            transition-duration: 0.4s; /* Transition duration */
            cursor: pointer; /* Cursor style */
            border-radius: 12px; 
        }

        button:hover {
            background-color: #45a049; /* Darker green on hover */
        }
    }
    
        
</style>
<script>
    // JavaScript functionality here

    // Sample JavaScript function
    function confirmBooking() {
        return confirm("Are you sure you want to get an appointment for this doctor?");
    }
</script>
</head>
<body>
<img src ="logo-dark.png" width="300" height="50" ><br><br>
<h1>Find Your Doctor</h1>

<table>
    <thead>
        <tr>
            <th>DoctorID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Hospital</th>
            <th>Contact No.</th>
            <th></th>
            
        </tr>
    </thead>
    <tbody>

        <% 
        IDoctorService iDoctorService = new DoctorServiceImpl();
        ArrayList<Doctor> doctorList = iDoctorService.getDoctors();
        %>

        <% 
        for(Doctor doctors: doctorList){
        %>

        <tr>
            <td><%= doctors.getDoctorId() %></td>
            <td><%= doctors.getFirstName() %></td>
            <td><%= doctors.getLastName() %></td>
            <td><%= doctors.getHospital() %></td>
            <td><%= doctors.getMobileNo() %></td>

            <td>
              <form action="payment.jsp" method="post" onsubmit="return confirmBooking()">
    <input type="hidden" name="doctorId" value="<%= doctors.getDoctorId() %>">
    <button type="submit" id="submit">Get An Appointment</button>
</form>

            </td>

        </tr>

        <% 
        }
        %>

    </tbody>
</table>

</body>
</html>