<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tap.module.CartItem"%>
<%@ page import="com.tap.module.User"%>
<%
List<CartItem> cartItems = (List<CartItem>)request.getAttribute("cartItems");
Double totalObj = (Double)request.getAttribute("total");
double total = totalObj != null ? totalObj : 0.0;
User user = (User) session.getAttribute("loggedUser");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodHub | Secure Checkout</title>
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

    <div class="container" style="margin-top: 30px;">
        <h2 class="section-title">Secure Checkout</h2>

        <div class="cart-layout">
            <!-- Left Side: Shipping & Payment Form -->
            <div class="cart-items-card">
                <form action="placeOrder" method="post" class="checkout-form">
                    
                    <div style="display: flex; flex-direction: column; gap: 10px; margin-bottom: 24px;">
                        <label for="address" style="font-size: 16px; font-weight: 700; color: var(--text-primary);">Delivery Address</label>
                        <textarea
                            id="address"
                            name="address"
                            rows="4"
                            placeholder="Enter detailed delivery address (House No, Street, Landmark)..."
                            style="background: var(--bg-main); color: var(--text-primary); border: 1px solid var(--border-color); border-radius: var(--radius-md); padding: 14px; font-size: 15px; outline: none; width: 100%;"
                            required><%= user != null && user.getAddress() != null ? user.getAddress() : "" %></textarea>
                    </div>

                    <div style="display: flex; flex-direction: column; gap: 10px; margin-bottom: 24px;">
                        <label style="font-size: 16px; font-weight: 700; color: var(--text-primary);">Select Payment Method</label>
                        
                        <div class="payment-grid">
                            <label class="payment-option">
                                <input type="radio" name="payment" value="Cash" checked required>
                                <div class="payment-card">
                                    <span style="font-size: 28px;">💵</span>
                                    <span style="font-weight: 700;">Cash on Delivery</span>
                                </div>
                            </label>
                            
                            <label class="payment-option">
                                <input type="radio" name="payment" value="UPI" required>
                                <div class="payment-card">
                                    <span style="font-size: 28px;">📱</span>
                                    <span style="font-weight: 700;">UPI / GooglePay</span>
                                </div>
                            </label>
                            
                            <label class="payment-option">
                                <input type="radio" name="payment" value="Card" required>
                                <div class="payment-card">
                                    <span style="font-size: 28px;">💳</span>
                                    <span style="font-weight: 700;">Credit / Debit Card</span>
                                </div>
                            </label>
                        </div>
                    </div>

                    <button type="submit" class="menuBtn" style="padding: 16px; font-size: 17px; width: 100%; margin-top: 10px;">
                        🔒 Place Order & Pay (₹<%=total%>)
                    </button>
                </form>
            </div>

            <!-- Right Side: Order Summary -->
            <div class="cart-summary-card">
                <h3 style="font-size: 18px; font-weight: 700; border-bottom: 1px solid var(--border-color); padding-bottom: 14px; margin-bottom: 18px;">
                    Order Summary
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
                                        <div style="font-weight: 700;"><%=item.getProductName()%></div>
                                        <div style="font-size: 12px; color: var(--text-secondary);"><%=item.getSizeName()%></div>
                                    </td>
                                    <td style="padding: 10px 0; text-align: center; font-weight: 600;">
                                        <%=item.getQuantity()%>
                                    </td>
                                    <td style="padding: 10px 0; text-align: right; font-weight: 700; color: var(--primary);">
                                        ₹<%=item.getTotalPrice()%>
                                    </td>
                                </tr>
                            <% } %>
                        <% } %>
                    </tbody>
                </table>

                <div class="summary-row">
                    <span style="color: var(--text-secondary);">Items Total</span>
                    <span style="font-weight: 600;">₹<%=total%></span>
                </div>
                
                <div class="summary-row">
                    <span style="color: var(--text-secondary);">Delivery Charge</span>
                    <span style="color: var(--success); font-weight: 700;">FREE</span>
                </div>

                <div class="summary-row total">
                    <span>Total Payable</span>
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