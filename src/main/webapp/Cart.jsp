<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tap.module.CartItem"%>
<%
List<CartItem> cartItems = (List<CartItem>)request.getAttribute("cartItems");
Double totalObj = (Double)request.getAttribute("total");
double total = totalObj != null ? totalObj : 0.0;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodHub | My Cart</title>
    <link rel="stylesheet" href="CSS/home.css">
</head>
<body>

    <header class="header">
        <div class="logo">
            <h1>🍔 FoodHub</h1>
        </div>
        <nav class="nav">
            <a href="home">Home</a>
            <a href="cart" class="active">Cart</a>
            <a href="myOrders">My Orders</a>
            <a href="logout">Logout</a>
        </nav>
    </header>

    <div class="container" style="margin-top: 30px;">
        <h2 class="section-title">Your Shopping Cart</h2>

        <% if(cartItems != null && !cartItems.isEmpty()) { %>
            <div class="cart-layout">
                <!-- Left Side: Items List -->
                <div class="cart-items-card">
                    <table class="cart-table">
                        <thead>
                            <tr>
                                <th>Product Details</th>
                                <th>Quantity</th>
                                <th>Total Price</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(CartItem item : cartItems) { %>
                                <tr>
                                    <td>
                                        <div class="cart-item-title"><%=item.getProductName()%></div>
                                        <div class="cart-item-size">Portion Size: <%=item.getSizeName()%></div>
                                    </td>
                                    <td>
                                        <div style="display: flex; align-items: center; gap: 8px;">
                                            <a href="updateCart?cartItemId=<%=item.getCartItemId()%>&action=minus" style="text-decoration: none;">
                                                <button type="button" class="cart-qty-btn">-</button>
                                            </a>
                                            <span style="font-weight: 700; font-size: 15px; min-width: 20px; text-align: center;"><%=item.getQuantity()%></span>
                                            <a href="updateCart?cartItemId=<%=item.getCartItemId()%>&action=plus" style="text-decoration: none;">
                                                <button type="button" class="cart-qty-btn">+</button>
                                            </a>
                                        </div>
                                    </td>
                                    <td style="font-weight: 800; font-size: 16px; color: var(--primary);">
                                        ₹<%=item.getTotalPrice()%>
                                    </td>
                                    <td>
                                        <a href="removeCartItem?cartItemId=<%=item.getCartItemId()%>" class="remove-btn">
                                            🗑️ Remove
                                        </a>
                                    </td>
                                </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>

                <!-- Right Side: Order Summary -->
                <div class="cart-summary-card">
                    <h3 style="font-size: 18px; font-weight: 700; border-bottom: 1px solid var(--border-color); padding-bottom: 14px; margin-bottom: 18px;">
                        Order Summary
                    </h3>
                    
                    <div class="summary-row">
                        <span style="color: var(--text-secondary);">Subtotal</span>
                        <span style="font-weight: 600;">₹<%=total%></span>
                    </div>
                    
                    <div class="summary-row">
                        <span style="color: var(--text-secondary);">Delivery Fee</span>
                        <span style="color: var(--success); font-weight: 700;">FREE Express</span>
                    </div>

                    <div class="summary-row total">
                        <span>Grand Total</span>
                        <span>₹<%=total%></span>
                    </div>

                    <a href="checkout" style="text-decoration: none; display: block; margin-top: 24px;">
                        <button class="menuBtn" style="padding: 16px; font-size: 16px; width: 100%;">
                            Proceed to Checkout →
                        </button>
                    </a>
                </div>
            </div>
        <% } else { %>
            <div class="empty-state">
                <div class="empty-state-icon">🛒</div>
                <h2>Your cart is currently empty</h2>
                <p>Discover delicious meals from top restaurants near you and add them to your cart!</p>
                <a href="home" class="orderBtn">Browse Restaurants Now</a>
            </div>
        <% } %>
    </div>

    <footer>
        <p>© 2026 FoodHub | Java Full Stack Food Ordering Application</p>
    </footer>

</body>
</html>