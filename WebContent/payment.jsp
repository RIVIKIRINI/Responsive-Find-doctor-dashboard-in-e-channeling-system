<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Payment</title>
<script>
function validateForm() {
    var name = document.forms["paymentForm"]["name"].value;
    var exdate = document.forms["paymentForm"]["exdate"].value;
    var cvv = document.forms["paymentForm"]["cvv"].value;
    var amount = document.forms["paymentForm"]["amount"].value;
    
    if (name === "" || exdate === "" || cvv === "" || amount === "") {
        alert("All fields must be filled out");
        return false;
    }
    // You can add more specific validation rules here, such as validating the format of the inputs.
}
</script>
<style>
        body{
    min-height: 100vh;
    background: url(payment.jpg) no-repeat;
    background-size: cover; 
    display: flex;
    justify-content: center;
    align-items: center;
}

        .container {
            max-width: 400px;
            padding: 100px;
            background-color:#FFFFFF; /* Adjust the last value for transparency */
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        h1 {
            text-align: center;
        }

        label, input {
            display: block;
            margin: 10px 0;
        }

        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #3944BC;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
 <div class="container">
<h1>Insert Payment</h1>

<form name="paymentForm" action="<%= request.getContextPath() %>/AddPaymentServlet" method="post" onsubmit="return validateForm()">
    
    Name <input type="text" name="exdate">
    Exdate <input type="text" name="name">
    Cvv <input type="text" name="cvv">
    Amount <input type="text" name="amount">
    <input type="submit" value="Add Payment">
</form>
</div>
</body>
</html>
