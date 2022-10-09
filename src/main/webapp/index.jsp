<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>eCommerce</title>
</head>
<body>

<h1>!Product Registration!</h1>
<form action="ProductServlet" method="post">
Enter Product Name: <input type="text" name="productName" size="20">
<input type="submit" value="Product Registered" />
</form>

 <button onclick="window.location.href='http://localhost:8085/lesson14/register.jsp';"> Click to go to Product Registration </button>

</body>
</html>