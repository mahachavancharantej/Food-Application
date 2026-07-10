<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.tap.module.Order"%>
<%@ page import="com.tap.module.Restaurant"%>
<%
Order order = (Order)request.getAttribute("order");
Restaurant restaurant = (Restaurant)request.getAttribute("restaurant");
List<Map<String, Object>> detailedItems = (List<Map<String, Object>>)request.getAttribute("detailedItems");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodHub | Order Details #<%=order.getOrderId()%></title>
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
        <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 24px;">
            <h2 class="section-title" style="margin-bottom: 0;">Order Details</h2>
            <a href="myOrders" class="order-btn-view" style="text-decoration: none;">← Back to My Orders</a>
        </div>

        <div class="order-details-grid">
            <!-- Left Side: Order Items List -->
            <div class="cart-items-card">
                <h3 style="font-size: 18px; font-weight: 700; border-bottom: 1px solid var(--border); padding-bottom: 12px; margin-bottom: 16px;">
                    Items Ordered
                </h3>
                <table class="order-items-table">
                    <thead>
                        <tr>
                            <th>Item Name</th>
                            <th>Size</th>
                            <th>Qty</th>
                            <th>Unit Price</th>
                            <th style="text-align: right;">Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% if(detailedItems != null) { %>
                            <% for(Map<String, Object> item : detailedItems) { %>
                                <tr>
                                    <td>
                                        <div style="font-weight: 600;"><%=item.get("productName")%></div>
                                    </td>
                                    <td>
                                        <span style="font-size: 13px; color: var(--text-muted);"><%=item.get("sizeName")%></span>
                                    </td>
                                    <td style="font-weight: 500;">
                                        <%=item.get("quantity")%>
                                    </td>
                                    <td style="font-weight: 500;">
                                        ₹<%=item.get("unitPrice")%>
                                    </td>
                                    <td style="text-align: right; font-weight: 600;">
                                        ₹<%=item.get("totalPrice")%>
                                    </td>
                                </tr>
                            <% } %>
                        <% } %>
                    </tbody>
                </table>
            </div>

            <!-- Right Side: Order Summary Details Sidebar -->
            <div class="order-summary-sidebar">
                <h3 class="order-sidebar-title">Order Status Summary</h3>
                
                <div class="order-sidebar-row">
                    <span class="order-sidebar-label">Order ID</span>
                    <span class="order-sidebar-value">#<%=order.getOrderId()%></span>
                </div>

                <div class="order-sidebar-row">
                    <span class="order-sidebar-label">Date & Time</span>
                    <span class="order-sidebar-value"><%=order.getOrderDate()%></span>
                </div>

                <div class="order-sidebar-row">
                    <span class="order-sidebar-label">Restaurant</span>
                    <span class="order-sidebar-value">
                        <strong><%=restaurant != null ? restaurant.getRestaurantName() : "Restaurant #" + order.getRestaurantId()%></strong>
                        <% if(restaurant != null) { %>
                            <div style="font-size: 12px; color: var(--text-muted); font-weight: normal; margin-top: 2px;">
                                <%=restaurant.getAddress()%>
                            </div>
                        <% } %>
                    </span>
                </div>

                <div class="order-sidebar-row">
                    <span class="order-sidebar-label">Order Status</span>
                    <span class="order-sidebar-value">
                        <span class="order-status-badge <%=order.getOrderStatus().toLowerCase().replace(" ", "-")%>" style="margin-top: 4px; display: inline-block;">
                            <%=order.getOrderStatus()%>
                        </span>
                    </span>
                </div>

                <div class="order-sidebar-row">
                    <span class="order-sidebar-label">Payment Information</span>
                    <span class="order-sidebar-value">
                        Method: <strong><%=order.getPaymentMethod()%></strong><br>
                        Status: <strong style="color: <%= order.getPaymentStatus().equalsIgnoreCase("Paid") ? "var(--success)" : "hsl(40, 95%, 45%)" %>"><%=order.getPaymentStatus()%></strong>
                    </span>
                </div>

                <div class="order-sidebar-row">
                    <span class="order-sidebar-label">Delivery Address</span>
                    <span class="order-sidebar-value" style="line-height: 1.4;"><%=order.getDeliveryAddress()%></span>
                </div>

                <div class="order-sidebar-row" style="border-top: 1px dashed var(--border); padding-top: 12px; margin-top: 8px;">
                    <span class="order-sidebar-label" style="font-size: 13px;">Total Amount Paid</span>
                    <span class="order-sidebar-value" style="font-size: 20px; font-weight: 700; color: var(--primary);">₹<%=order.getTotalAmount()%></span>
                </div>
            </div>
        </div>
    </div>

    <footer>
        <p>© 2026 FoodHub | Java Full Stack Food Ordering Application</p>
    </footer>

</body>
</html>
