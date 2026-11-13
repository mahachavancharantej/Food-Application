<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.tap.module.Menu"%>
<%@ page import="com.tap.module.Productsize"%>
<%
Menu product = (Menu)request.getAttribute("product");
List<Productsize> sizes = (List<Productsize>)request.getAttribute("sizes");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodHub | <%= product != null ? product.getProductName() : "Product Details" %></title>
    <link rel="stylesheet" href="CSS/home.css">
    <script>
        function adjustQty(amount) {
            var qtyInput = document.getElementById("quantity");
            var currentVal = parseInt(qtyInput.value);
            if (!isNaN(currentVal)) {
                var newVal = currentVal + amount;
                if (newVal >= 1) {
                    qtyInput.value = newVal;
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
            <a href="home">Home</a>
            <a href="cart">Cart</a>
            <a href="myOrders">My Orders</a>
            <a href="logout">Logout</a>
        </nav>
    </header>

    <div class="container" style="margin-top: 20px;">
        <% if (product != null) { %>
            <div class="details-container">
                <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px;">
                    <span class="status-badge <%=product.isAvailable() ? "open" : "closed"%>">
                        <%=product.isAvailable() ? "Available Now" : "Currently Unavailable"%>
                    </span>
                    <a href="javascript:history.back()" class="order-btn-view" style="text-decoration: none; font-size: 13px;">← Back</a>
                </div>

                <div class="details-header">
                    <% String productImgUrl = (product.getImageUrl() != null && !product.getImageUrl().isEmpty())
                            ? product.getImageUrl()
                            : "https://images.unsplash.com/photo-1546069901-ba9599a7e63c?auto=format&fit=crop&w=600&q=80";
                    %>
                    <img src="<%=productImgUrl%>" alt="<%=product.getProductName()%>"
                         style="width:100%; height:260px; object-fit:cover; border-radius:var(--radius-md); margin-bottom:24px; display:block;">
                    <h1 style="font-size: 30px; font-weight: 800; margin-bottom: 8px;"><%=product.getProductName()%></h1>
                </div>
                
                <p class="details-desc" style="color: var(--text-secondary); font-size: 15px; line-height: 1.6; margin-bottom: 28px;">
                    <%=product.getDescription()%>
                </p>

                <form action="addToCart" method="post">
                    <input type="hidden" name="productId" value="<%=product.getProductId()%>">

                    <h3 style="margin-bottom: 14px; font-size: 18px; font-weight: 700;">Select Portion Size</h3>
                    
                    <div class="sizes-grid">
                        <% if (sizes != null && !sizes.isEmpty()) { %>
                            <% boolean isFirst = true; %>
                            <% for(Productsize ps : sizes) { %>
                                <label class="size-option">
                                    <input type="radio" 
                                           name="sizeId" 
                                           value="<%=ps.getSizeId()%>" 
                                           <%= isFirst ? "checked" : "" %> 
                                           required>
                                    <div class="size-card">
                                        <span><%=ps.getSizeName()%></span>
                                        <span class="price">₹<%=ps.getPrice()%></span>
                                    </div>
                                </label>
                                <% isFirst = false; %>
                            <% } %>
                        <% } else { %>
                            <p style="color: var(--danger); font-weight: 600;">Standard portion sizes apply.</p>
                        <% } %>
                    </div>

                    <div class="quantity-section">
                        <label>Select Quantity</label>
                        <div class="quantity-control">
                            <button type="button" onclick="adjustQty(-1)">-</button>
                            <input type="number" 
                                   id="quantity" 
                                   name="quantity" 
                                   value="1" 
                                   min="1" 
                                   readonly>
                            <button type="button" onclick="adjustQty(1)">+</button>
                        </div>
                    </div>

                    <button type="submit" class="menuBtn" style="padding: 16px; font-size: 16px; width: 100%;">
                        🛒 Add To Shopping Cart
                    </button>
                </form>
            </div>
        <% } else { %>
            <div class="empty-state">
                <div class="empty-state-icon">⚠️</div>
                <h2>Product Not Found</h2>
                <p>The requested product details could not be found. Please browse our home menu!</p>
                <a href="home" class="orderBtn">Back to Home</a>
            </div>
        <% } %>
    </div>

    <footer>
        <p>© 2026 FoodHub | Java Full Stack Food Ordering Application</p>
    </footer>

</body>
</html>