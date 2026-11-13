<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tap.module.Menu"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodHub | Restaurant Menu</title>
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
        <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 28px;">
            <h2 class="section-title" style="margin-bottom: 0;">Explore Menu Items</h2>
            <a href="home" class="order-btn-view" style="text-decoration: none;">← Back to Restaurants</a>
        </div>

        <%
        List<Menu> menuList = (List<Menu>)request.getAttribute("menuList");
        if(menuList != null && !menuList.isEmpty()) {
        %>
            <div class="menu-grid">
                <% for(Menu m : menuList) { %>
                    <div class="menu-card">
                        <div class="menu-image">
                            <img src="<%= (m.getImageUrl() != null && !m.getImageUrl().isEmpty()) ? m.getImageUrl() : "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?auto=format&fit=crop&w=500&q=80" %>" alt="<%=m.getProductName()%>">
                        </div>
                        <div class="menu-content">
                            <h2><%=m.getProductName()%></h2>
                            
                            <div class="restaurant-meta">
                                <span class="status-badge <%=m.isAvailable() ? "open" : "closed"%>">
                                    <%=m.isAvailable() ? "Available" : "Not Available"%>
                                </span>
                                <span style="font-size: 20px; font-weight: 800; color: var(--primary);">
                                    ₹<%=m.getBasePrice()%>
                                </span>
                            </div>

                            <p><%=m.getDescription()%></p>

                            <a class="menuBtn" href="productDetails?productId=<%=m.getProductId()%>" style="margin-top: 18px;">
                                Customize & Order
                            </a>
                        </div>
                    </div>
                <% } %>
            </div>
        <% } else { %>
            <div class="empty-state">
                <div class="empty-state-icon">🍜</div>
                <h2>No Menu Items Available</h2>
                <p>There are no items currently listed on this restaurant menu. Please check back later!</p>
                <a href="home" class="orderBtn" style="margin-top: 16px;">Browse Other Restaurants</a>
            </div>
        <% } %>
    </div>

    <footer>
        <p>© 2026 FoodHub | Java Full Stack Food Ordering Application</p>
    </footer>

</body>
</html>