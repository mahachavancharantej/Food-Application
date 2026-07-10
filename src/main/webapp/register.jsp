<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodHub - Create Account</title>
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body>

<div class="container">
    <div class="card">
        <h1>🍔 FoodHub</h1>
        <h3>Create an account to get started</h3>

        <form action="register" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text"
                       id="username"
                       name="username"
                       placeholder="Choose a username"
                       required>
            </div>

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

            <div class="form-group">
                <label for="phone">Phone Number</label>
                <input type="tel"
                       id="phone"
                       name="phone"
                       placeholder="Enter phone number"
                       required>
            </div>

            <div class="form-group">
                <label for="address">Delivery Address</label>
                <textarea
                    id="address"
                    name="address"
                    placeholder="Enter default delivery address"
                    required></textarea>
            </div>

            <div class="form-group">
                <label for="role">User Role</label>
                <select id="role" name="role">
                    <option value="Customer">Customer</option>
                    <option value="Admin">Admin</option>
                </select>
            </div>

            <button type="submit">
                Register
            </button>
        </form>

        <p>
            Already have an account? 
            <a href="login.jsp">Login here</a>
        </p>
    </div>
</div>

</body>
</html>