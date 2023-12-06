<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Control Panel</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            text-align: center;
            background-image: url("background.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            background-attachement: fixed;
        }
        
        .container {
            background-color: #808080;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            margin-top: 400px;
        }

        h1 {
            color: #333;
        }

        thank {
            font-size: 24px;
            color: #4CAF50;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
        
        header {
            background-color: #0074D9;
            color: white;
            padding: 10px;
            text-align: center;
            position: absolute;
            top: 0;
    		left: 0;
    		right: 0;
    		width: 100%;
        }
        
        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px 0;
            position: absolute;
            bottom: -150px;
    		left: 0;
    		right: 0;
    		width: 100%;
        }
        
        nav {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 30px 50px;
            position: absolute;
            top: 117px;
    		left: 0;
    		right: 0;
    		width: 100%;
        }

        nav a {
            text-decoration: none;
            color: white;
            padding: 20px 30px;
        }

        nav a:hover {
            background-color: #555;
        }
        
    </style>
</head>
<body>
	<header>
        <h1>Welcome to E-Channelling</h1>
        <a onclick="location.href='AdminControl.jsp'" href="#">Admin Control Panel</a>
    </header>
    <nav>
        <a onclick="location.href='homepage.jsp'" href="#">Home</a>
        <a onclick="location.href='doctorpreview.jsp'" href="#">Schedule Appointment</a>
        <a onclick="location.href='order.jsp'" href="#">Order Medicine</a>
        <a href="#">FAQ</a>
        <a onclick="location.href='Aboutus.jsp'" href="#">About Us</a>
        <a href="#">Contact Us</a>
    </nav>
    <div class="container">
        <button onclick="location.href='allDoctors.jsp'">View Doctor List</button><br><br>
        <button onclick="location.href='allMedicineOrder.jsp'">View Medicine Order List</button><br><br>
        <button onclick="location.href='index.jsp'">Add Doctor Profile</button>
    </div>
     <footer>
        &copy; 2023 E-Channelling. All rights reserved.
    </footer>
</body>
</html>