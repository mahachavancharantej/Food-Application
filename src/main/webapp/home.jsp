<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tap.module.Restaurant"%>
<%
List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("restaurants");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodHub | Premium Food Delivery</title>
    <link rel="stylesheet" href="CSS/home.css">
</head>
<body>

    <header class="header">
        <div class="logo">
            <h1>🍔 FoodHub</h1>
        </div>
        <nav class="nav">
            <a href="home" class="active">Home</a>
            <a href="cart">Cart</a>
            <a href="myOrders">My Orders</a>
            <a href="logout">Logout</a>
        </nav>
    </header>

    <section class="hero">
        <div class="hero-content">
            <h1>Craving something delicious?</h1>
            <h2>Get fresh, restaurant-quality food delivered straight to your door step.</h2>
            <p>Fast Delivery • Best Quality Guarantee • Safe & Secure Payment</p>
            <a href="#restaurants" class="orderBtn">
                Explore Restaurants
            </a>
        </div>
    </section>

    <div class="container" id="restaurants">
        <h2 class="section-title">Popular Restaurants near you</h2>

        <% if (restaurants != null && !restaurants.isEmpty()) { %>
            <div class="restaurants-grid">
                <% for (Restaurant r : restaurants) { %>
                    <div class="restaurant-card">
                        <div class="restaurant-image">
                            <img src="<%= (r.getImageUrl() != null && !r.getImageUrl().isEmpty()) ? r.getImageUrl() : "https://images.unsplash.com/photo-1504674900247-0877df9cc836?auto=format&fit=crop&w=600&q=80" %>" alt="<%=r.getRestaurantName()%>">
                        </div>
                        <div class="restaurant-content">
                            <h2><%=r.getRestaurantName()%></h2>
                            
                            <div class="restaurant-meta">
                                <span class="rating">⭐ <%=r.getRating()%></span>
                                <span class="status-badge <%=r.getStatus().equalsIgnoreCase("Open") ? "open" : "closed"%>">
                                    <%=r.getStatus()%>
                                </span>
                            </div>

                            <p><strong>Cuisine:</strong> <%=r.getCuisine()%></p>
                            <p><strong>Delivery Time:</strong> <%=r.getDeliveryTime()%> mins</p>
                            <p><strong>Price:</strong> ₹<%=r.getPriceForTwo()%> for two</p>
                            <p><strong>Address:</strong> <%=r.getAddress()%></p>

                            <a class="menuBtn" href="menu?restaurantId=<%=r.getRestaurantId()%>">
                                View Menu
                            </a>
                        </div>
                    </div>
                <% } %>
            </div>
        <% } else { %>
            <div class="empty-state">
                <div class="empty-state-icon">🍽️</div>
                <h2>No Restaurants Available</h2>
                <p>We couldn't find any restaurants at the moment. Please check back later!</p>
            </div>
        <% } %>
    </div>

    <footer>
        <p>© 2026 FoodHub | Java Full Stack Food Ordering Application</p>
    </footer>

</body>
</html>