<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>E-channeling | Add doctor</title>
</head>
<body style="font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px; text-align: center;">
<img src = "logo-dark.png" width="300" height="50">
<h1 style="color: #333;">Add Doctor</h1>

<form action="<%= request.getContextPath() %>/AddDoctorServlet" method="post" style="width: 300px; margin: auto; background-color: #fff; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);" onsubmit="return validateForm()">
    <div style="margin-bottom: 10px;">
        First Name: <input type="text" name="firstname" id="firstname" style="display: block; width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;">
    </div>
    <div style="margin-bottom: 10px;">
        Last Name: <input type="text" name="lastname" id="lastname" style="display: block; width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;" >
    </div>
    <div style="margin-bottom: 10px;">
        Hospital: <input type="text" name="hospital" id="hospital" style="display: block; width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;">
    </div>
    <div style="margin-bottom: 10px;">
        Mobile Number: <input type="text" name="mobileno" id="mobileno" style="display: block; width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px;">
    </div>
    <input type="submit" value="Add Doctor" style="background-color: #0074D9; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer;">
</form>

<script>
    function validateForm() {
        var firstname = document.getElementById('firstname').value;
        var lastname = document.getElementById('lastname').value;
        var hospital = document.getElementById('hospital').value;
        var mobileno = document.getElementById('mobileno').value;

        if (firstname === '' || lastname === '' || hospital === '' || mobileno === '') {
            alert('Please fill in all fields.');
            return false;
        }
        return true;
    }
</script>

</body>
</html>
