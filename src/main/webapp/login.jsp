<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String errorStr = request.getParameter("error");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodHub | Login</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>

<div class="container">
    <div class="card">
        <h1>🍔 FoodHub</h1>
        <h3>Welcome back! Please login to your account.</h3>

        <% if (errorStr != null) { %>
            <div class="error-alert">
                ⚠️ Invalid email or password. Please try again.
            </div>
        <% } %>

        <form action="login" method="post">
            <div class="form-group">
                <label for="email">Email Address</label>
                <input type="email"
                       id="email"
                       name="email"
                       placeholder="name@example.com"
                       required>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password"
                       id="password"
                       name="password"
                       placeholder="••••••••"
                       required>
            </div>

            <button type="submit">
                Sign In to FoodHub
            </button>
        </form>

        <p>
            New to FoodHub? 
            <a href="register.jsp">Create a new account</a>
        </p>
    </div>
</div>

</body>
</html>