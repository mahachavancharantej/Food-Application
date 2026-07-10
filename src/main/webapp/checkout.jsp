<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tap.module.CartItem"%>
<%@ page import="com.tap.module.User"%>
<%
List<CartItem> cartItems = (List<CartItem>)request.getAttribute("cartItems");
double total = (Double)request.getAttribute("total");
User user = (User) session.getAttribute("loggedUser");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodHub | Checkout</title>
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
        <h2 class="section-title">Secure Checkout</h2>

        <div class="cart-layout">
            <!-- Left Side: Shipping & Payment Form -->
            <div class="cart-items-card">
                <form action="placeOrder" method="post" class="checkout-form">
                    
                    <div class="order-sidebar-row" style="gap: 8px;">
                        <label for="address" style="font-size: 16px; font-weight: 600;">Delivery Address</label>
                        <textarea
                            id="address"
                            name="address"
                            rows="4"
                            placeholder="Enter delivery address"
                            required><%= user != null ? user.getAddress() : "" %></textarea>
                    </div>

                    <div class="order-sidebar-row" style="gap: 8px; margin-top: 10px;">
                        <label style="font-size: 16px; font-weight: 600;">Payment Method</label>
                        
                        <div class="payment-grid">
                            <label class="payment-option">
                                <input type="radio" name="payment" value="Cash" checked required>
                                <div class="payment-card">
                                    <span style="font-size: 24px;">💵</span>
                                    <span>Cash</span>
                                </div>
                            </label>
                            
                            <label class="payment-option">
                                <input type="radio" name="payment" value="UPI" required>
                                <div class="payment-card">
                                    <span style="font-size: 24px;">📱</span>
                                    <span>UPI</span>
                                </div>
                            </label>
                            
                            <label class="payment-option">
                                <input type="radio" name="payment" value="Card" required>
                                <div class="payment-card">
                                    <span style="font-size: 24px;">💳</span>
                                    <span>Card</span>
                                </div>
                            </label>
                        </div>
                    </div>

                    <button type="submit" class="menuBtn" style="padding: 14px; font-size: 16px; margin-top: 20px;">
                        Place Order (₹<%=total%>)
                    </button>
                </form>
            </div>

            <!-- Right Side: Order Summary -->
            <div class="cart-summary-card">
                <h3 style="font-size: 18px; font-weight: 700; border-bottom: 1px solid var(--border); padding-bottom: 12px; margin-bottom: 16px;">
                    Items Summary
                </h3>

                <table class="cart-table" style="margin-bottom: 20px;">
                    <thead>
                        <tr>
                            <th style="padding: 10px 0;">Item</th>
                            <th style="padding: 10px 0; text-align: center;">Qty</th>
                            <th style="padding: 10px 0; text-align: right;">Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% if (cartItems != null) { %>
                            <% for(CartItem item : cartItems) { %>
                                <tr>
                                    <td style="padding: 10px 0;">
                                        <div style="font-weight: 600;"><%=item.getProductName()%></div>
                                        <div style="font-size: 12px; color: var(--text-muted);"><%=item.getSizeName()%></div>
                                    </td>
                                    <td style="padding: 10px 0; text-align: center; font-weight: 500;">
                                        <%=item.getQuantity()%>
                                    </td>
                                    <td style="padding: 10px 0; text-align: right; font-weight: 600;">
                                        ₹<%=item.getTotalPrice()%>
                                    </td>
                                </tr>
                            <% } %>
                        <% } %>
                    </tbody>
                </table>

                <div class="summary-row">
                    <span style="color: var(--text-muted);">Items Total</span>
                    <span style="font-weight: 500;">₹<%=total%></span>
                </div>
                
                <div class="summary-row">
                    <span style="color: var(--text-muted);">Delivery Charge</span>
                    <span style="color: var(--success); font-weight: 600;">FREE</span>
                </div>

                <div class="summary-row total">
                    <span>To Pay</span>
                    <span>₹<%=total%></span>
                </div>
            </div>
        </div>
    </div>

    <footer>
        <p>© 2026 FoodHub | Java Full Stack Food Ordering Application</p>
    </footer>

</body>
</html>