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
    <script>
        function filterRestaurants() {
            var input = document.getElementById("searchBar").value.toLowerCase();
            var cards = document.getElementsByClassName("restaurant-card");
            for (var i = 0; i < cards.length; i++) {
                var title = cards[i].querySelector("h2").innerText.toLowerCase();
                var cuisine = cards[i].querySelector(".cuisine-text").innerText.toLowerCase();
                if (title.includes(input) || cuisine.includes(input)) {
                    cards[i].style.display = "flex";
                } else {
                    cards[i].style.display = "none";
                }
            }
        }
    </script>
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

    <section class="hero" style="background-image: linear-gradient(180deg, rgba(13, 17, 23, 0.75) 0%, rgba(13, 17, 23, 0.95) 100%), url('CSS/images/foodapp_hero.jpg'); background-size: cover; background-position: center;">
        <div class="hero-content">
            <h1>Craving something delicious?</h1>
            <h2>Get fresh, top-rated restaurant meals delivered hot to your doorstep.</h2>
            <p>🚀 30 Min Express Delivery • 🌟 4.5+ Rated Restaurants • 🔒 100% Secure Checkout</p>
            <div style="max-width: 500px; margin: 0 auto 20px auto;">
                <input type="text" id="searchBar" onkeyup="filterRestaurants()" placeholder="🔍 Search restaurants or cuisines..." style="padding: 16px 24px; border-radius: 30px; border: 1px solid var(--border-glow); width: 100%; font-size: 16px; background: rgba(22, 27, 34, 0.9); color: var(--text-primary); outline: none;">
            </div>
        </div>
    </section>

    <div class="container" id="restaurants">
        <h2 class="section-title">Popular Restaurants Near You</h2>

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
                                <span class="status-badge <%= (r.getStatus() != null && r.getStatus().equalsIgnoreCase("Open")) ? "open" : "closed"%>">
                                    <%= (r.getStatus() != null) ? r.getStatus() : "Open"%>
                                </span>
                            </div>

                            <p class="cuisine-text"><strong>Cuisine:</strong> <%=r.getCuisine()%></p>
                            <p><strong>Delivery Time:</strong> ⏱️ <%=r.getDeliveryTime()%> mins</p>
                            <p><strong>Price:</strong> 💳 ₹<%=r.getPriceForTwo()%> for two</p>
                            <p style="font-size: 13px; color: var(--text-secondary); margin-bottom: 18px;">📍 <%=r.getAddress()%></p>

                            <a class="menuBtn" href="menu?restaurantId=<%=r.getRestaurantId()%>">
                                View Menu & Order
                            </a>
                        </div>
                    </div>
                <% } %>
            </div>
        <% } else { %>
            <div class="empty-state">
                <div class="empty-state-icon">🍽️</div>
                <h2>No Restaurants Available</h2>
                <p>We couldn't find any active restaurants in your area right now. Please run `foodapp.sql` script to populate database records!</p>
            </div>
        <% } %>
    </div>

    <footer>
        <p>© 2026 FoodHub | Java Full Stack Food Ordering Application</p>
    </footer>

</body>
</html>