<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.module.Order" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodHub | My Orders</title>
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
            <a href="myOrders" class="active">My Orders</a>
            <a href="logout">Logout</a>
        </nav>
    </header>

    <div class="container">
        <h2 class="section-title">Order History</h2>

        <%
        List<Order> orders = (List<Order>)request.getAttribute("orders");
        if(orders != null && !orders.isEmpty()){
        %>
            <div class="orders-list">
                <% for(Order order : orders){ %>
                    <div class="order-history-card">
                        <div class="order-details-summary">
                            <div class="order-header-row">
                                <span class="order-restaurant-name">
                                    <%=order.getRestaurantName() != null ? order.getRestaurantName() : "Restaurant #" + order.getRestaurantId()%>
                                </span>
                                <span class="order-date-text">
                                    <%=order.getOrderDate()%>
                                </span>
                            </div>
                            
                            <div class="order-info-row">
                                <span>Order ID: <strong>#<%=order.getOrderId()%></strong></span>
                                <span>Total Paid: <strong>₹<%=order.getTotalAmount()%></strong></span>
                                <span>Payment Method: <strong><%=order.getPaymentMethod()%></strong></span>
                            </div>
                        </div>
                        
                        <div style="display: flex; align-items: center; gap: 20px;">
                            <span class="order-status-badge <%=order.getOrderStatus().toLowerCase().replace(" ", "-")%>">
                                <%=order.getOrderStatus()%>
                            </span>
                            <a class="order-btn-view" href="orderDetails?orderId=<%=order.getOrderId()%>">
                                View Details
                            </a>
                        </div>
                    </div>
                <% } %>
            </div>
        <% } else { %>
            <div class="empty-state">
                <div class="empty-state-icon">📦</div>
                <h2>No Orders Found</h2>
                <p>You haven't placed any orders yet. Try ordering some food!</p>
                <a href="home" class="orderBtn">Order Now</a>
            </div>
        <% } %>
    </div>

    <footer>
        <p>© 2026 FoodHub | Java Full Stack Food Ordering Application</p>
    </footer>

</body>
</html>