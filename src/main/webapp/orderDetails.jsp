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
    <title>FoodHub | Order Details #<%= order != null ? order.getOrderId() : "" %></title>
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

    <div class="container" style="margin-top: 30px;">
        <% if (order != null) { %>
            <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 28px;">
                <h2 class="section-title" style="margin-bottom: 0;">Order Receipt #<%=order.getOrderId()%></h2>
                <a href="myOrders" class="order-btn-view" style="text-decoration: none;">← Back to My Orders</a>
            </div>

            <div class="cart-layout">
                <!-- Left Side: Order Items List -->
                <div class="cart-items-card">
                    <h3 style="font-size: 18px; font-weight: 700; border-bottom: 1px solid var(--border-color); padding-bottom: 14px; margin-bottom: 18px;">
                        Items Ordered
                    </h3>
                    <table class="order-items-table">
                        <thead>
                            <tr>
                                <th>Item Name</th>
                                <th>Portion Size</th>
                                <th>Qty</th>
                                <th>Unit Price</th>
                                <th style="text-align: right;">Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% if(detailedItems != null && !detailedItems.isEmpty()) { %>
                                <% for(Map<String, Object> item : detailedItems) { %>
                                    <tr>
                                        <td>
                                            <div style="font-weight: 700;"><%=item.get("productName")%></div>
                                        </td>
                                        <td>
                                            <span style="font-size: 13px; color: var(--text-secondary);"><%=item.get("sizeName")%></span>
                                        </td>
                                        <td style="font-weight: 600;">
                                            <%=item.get("quantity")%>
                                        </td>
                                        <td style="font-weight: 600;">
                                            ₹<%=item.get("unitPrice")%>
                                        </td>
                                        <td style="text-align: right; font-weight: 800; color: var(--primary);">
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
                    <h3 style="font-size: 18px; font-weight: 700; border-bottom: 1px solid var(--border-color); padding-bottom: 14px; margin-bottom: 18px;">
                        Order Status & Summary
                    </h3>
                    
                    <div class="summary-row">
                        <span style="color: var(--text-secondary);">Order ID</span>
                        <span style="font-weight: 700;">#<%=order.getOrderId()%></span>
                    </div>

                    <div class="summary-row">
                        <span style="color: var(--text-secondary);">Date & Time</span>
                        <span style="font-size: 13px; color: var(--text-primary);"><%=order.getOrderDate()%></span>
                    </div>

                    <div class="summary-row">
                        <span style="color: var(--text-secondary);">Restaurant</span>
                        <span style="font-weight: 700; text-align: right;">
                            <%=restaurant != null ? restaurant.getRestaurantName() : "Restaurant #" + order.getRestaurantId()%>
                        </span>
                    </div>

                    <div class="summary-row">
                        <span style="color: var(--text-secondary);">Order Status</span>
                        <span class="order-status-badge <%=order.getOrderStatus() != null ? order.getOrderStatus().toLowerCase().replace(" ", "-") : "pending"%>">
                            <%=order.getOrderStatus()%>
                        </span>
                    </div>

                    <div class="summary-row">
                        <span style="color: var(--text-secondary);">Payment Method</span>
                        <span style="font-weight: 600;"><%=order.getPaymentMethod()%></span>
                    </div>

                    <div class="summary-row">
                        <span style="color: var(--text-secondary);">Payment Status</span>
                        <span style="font-weight: 700; color: <%= (order.getPaymentStatus() != null && order.getPaymentStatus().equalsIgnoreCase("Paid")) ? "var(--success)" : "var(--warning)" %>;">
                            <%=order.getPaymentStatus()%>
                        </span>
                    </div>

                    <div style="margin-top: 14px; padding-top: 14px; border-top: 1px dashed var(--border-color);">
                        <span style="font-size: 13px; color: var(--text-secondary); display: block; margin-bottom: 4px;">Delivery Address:</span>
                        <p style="font-size: 14px; color: var(--text-primary); line-height: 1.4;"><%=order.getDeliveryAddress()%></p>
                    </div>

                    <div class="summary-row total" style="margin-top: 16px;">
                        <span>Total Paid</span>
                        <span>₹<%=order.getTotalAmount()%></span>
                    </div>
                </div>
            </div>
        <% } else { %>
            <div class="empty-state">
                <div class="empty-state-icon">⚠️</div>
                <h2>Order Not Found</h2>
                <p>Could not retrieve details for this order. Please check your order history!</p>
                <a href="myOrders" class="orderBtn">View My Orders</a>
            </div>
        <% } %>
    </div>

    <footer>
        <p>© 2026 FoodHub | Java Full Stack Food Ordering Application</p>
    </footer>

</body>
</html>
