<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodHub | Order Success</title>
    <link rel="stylesheet" href="CSS/home.css">
</head>
<body>

    <header class="header">
        <div class="logo">
            <h1>🍔 FoodHub</h1>
        </div>
        <nav class="nav">
            <a href="home">Home</a>
            <a href="cart">Cart</a>
            <a href="myOrders">My Orders</a>
            <a href="logout">Logout</a>
        </nav>
    </header>

    <div class="container">
        <div class="success-card">
            <div class="success-icon">🎉</div>
            <h1>Order Placed Successfully!</h1>
            <p>Your delicious food is being prepared and will be delivered shortly. You can track your order status in your orders history.</p>
            
            <div style="display: flex; gap: 16px; justify-content: center; margin-top: 24px;">
                <a href="home" style="text-decoration: none;">
                    <button class="menuBtn" style="padding: 12px 24px; font-size: 15px;">Continue Shopping</button>
                </a>
                <a href="myOrders" style="text-decoration: none;">
                    <button class="order-btn-view" style="padding: 12px 24px; font-size: 15px; border-radius: 10px; cursor: pointer;">View My Orders</button>
                </a>
            </div>
        </div>
    </div>

    <footer>
        <p>© 2026 FoodHub | Java Full Stack Food Ordering Application</p>
    </footer>

</body>
</html>