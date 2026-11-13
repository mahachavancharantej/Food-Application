-- =========================================================
-- FoodHub Database Schema & Seed Data Script
-- Database: foodapp
-- =========================================================

CREATE DATABASE IF NOT EXISTS foodapp;
USE foodapp;

-- Drop old tables if they exist to prevent schema conflicts
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS cart_items;
DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS product_sizes;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS users;
SET FOREIGN_KEY_CHECKS = 1;

-- 1. Users Table
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    phone VARCHAR(20),
    address TEXT,
    role VARCHAR(50) DEFAULT 'Customer',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login_date TIMESTAMP NULL
);

-- 2. Categories Table
CREATE TABLE categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL
);

-- 3. Restaurants Table
CREATE TABLE restaurants (
    restaurant_id INT AUTO_INCREMENT PRIMARY KEY,
    restaurant_name VARCHAR(150) NOT NULL,
    owner_name VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(150),
    address TEXT,
    image_url VARCHAR(500),
    rating DOUBLE DEFAULT 4.0,
    status VARCHAR(50) DEFAULT 'Open',
    cuisine VARCHAR(100),
    delivery_time INT DEFAULT 30,
    price_for_two INT DEFAULT 400
);

-- 4. Products Table (Menu Items)
CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id INT NOT NULL,
    category_id INT NOT NULL,
    product_name VARCHAR(150) NOT NULL,
    description TEXT,
    image_url VARCHAR(500),
    base_price DOUBLE NOT NULL,
    is_available BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants(restaurant_id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES categories(category_id) ON DELETE CASCADE
);

-- 5. Product Sizes Table
CREATE TABLE product_sizes (
    size_id INT AUTO_INCREMENT PRIMARY KEY,
    product_id INT NOT NULL,
    size_name VARCHAR(100) NOT NULL,
    price DOUBLE NOT NULL,
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE
);

-- 6. Cart Table
CREATE TABLE cart (
    cart_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- 7. Cart Items Table
CREATE TABLE cart_items (
    cart_item_id INT AUTO_INCREMENT PRIMARY KEY,
    cart_id INT NOT NULL,
    product_id INT NOT NULL,
    size_id INT NOT NULL,
    quantity INT NOT NULL DEFAULT 1,
    total_price DOUBLE NOT NULL DEFAULT 0.0,
    FOREIGN KEY (cart_id) REFERENCES cart(cart_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE,
    FOREIGN KEY (size_id) REFERENCES product_sizes(size_id) ON DELETE CASCADE
);

-- 8. Orders Table
CREATE TABLE orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    restaurant_id INT NOT NULL,
    total_amount DOUBLE NOT NULL,
    order_status VARCHAR(50) DEFAULT 'Pending',
    payment_method VARCHAR(50) NOT NULL,
    payment_status VARCHAR(50) DEFAULT 'Pending',
    delivery_address TEXT NOT NULL,
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (restaurant_id) REFERENCES restaurants(restaurant_id) ON DELETE CASCADE
);

-- 9. Order Items Table
CREATE TABLE order_items (
    order_item_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    size_id INT NOT NULL,
    quantity INT NOT NULL,
    price DOUBLE NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE,
    FOREIGN KEY (size_id) REFERENCES product_sizes(size_id) ON DELETE CASCADE
);

-- =========================================================
-- Seed Data Insertion
-- =========================================================

-- Insert Categories
INSERT INTO categories (category_id, category_name) VALUES
(1, 'Starters & Appetizers'),
(2, 'Main Course'),
(3, 'Pizzas & Pastas'),
(4, 'Burgers & Wraps'),
(5, 'Chinese & Asian'),
(6, 'Desserts & Sweets'),
(7, 'Beverages & Drinks');

-- Insert Restaurants
INSERT INTO restaurants (restaurant_id, restaurant_name, owner_name, phone, email, address, image_url, rating, status, cuisine, delivery_time, price_for_two) VALUES
(1, 'Dominos Pizza', 'Mario Rossi', '9876543210', 'info@dominos.com', 'MG Road, Indiranagar, Bengaluru', 'https://images.unsplash.com/photo-1513104890138-7c749659a591?auto=format&fit=crop&w=800&q=80', 4.6, 'Open', 'Italian & Fast Food', 25, 450),
(2, 'Biryani Blues', 'Rahim Khan', '9876543211', 'contact@biryaniblues.com', 'Koramangala 5th Block, Bengaluru', 'https://images.unsplash.com/photo-1563379091339-03b21ab4a4f8?auto=format&fit=crop&w=800&q=80', 4.8, 'Open', 'Hyderabadi & Biryani', 30, 550),
(3, 'Burger King', 'John Smith', '9876543212', 'support@burgerking.com', 'HSR Layout Sector 1, Bengaluru', 'https://images.unsplash.com/photo-1568901346375-23c9450c58cd?auto=format&fit=crop&w=800&q=80', 4.4, 'Open', 'American & Fast Food', 20, 350),
(4, 'Mainland China', 'Wei Zhang', '9876543213', 'hello@mainlandchina.com', 'Whitefield Main Road, Bengaluru', 'https://images.unsplash.com/photo-1541696432-82c6da8ce7bf?auto=format&fit=crop&w=800&q=80', 4.7, 'Open', 'Asian & Dumplings', 35, 700),
(5, 'Sweet Truth Desserts', 'Anita Sharma', '9876543214', 'orders@sweettruth.com', 'Jayanagar 4th Block, Bengaluru', 'https://images.unsplash.com/photo-1551024709-8f23befc6f87?auto=format&fit=crop&w=800&q=80', 4.9, 'Open', 'Bakery & Desserts', 15, 300);

-- Insert Products (Menu Items)
INSERT INTO products (product_id, restaurant_id, category_id, product_name, description, image_url, base_price, is_available) VALUES
-- Domino's Pizza Items
(1, 1, 3, 'Farmhouse Pizza', 'Delightful combination of onion, capsicum, tomato, and grilled mushroom with extra mozzarella cheese.', 'https://images.unsplash.com/photo-1534308983496-4fabb1a015ee?auto=format&fit=crop&w=600&q=80', 299.0, TRUE),
(2, 1, 3, 'Peppy Paneer Pizza', 'Chunky paneer with crisp capsicum and spicy red paprika topped with gooey cheese.', 'https://images.unsplash.com/photo-1574071318508-1cdbab80d002?auto=format&fit=crop&w=600&q=80', 329.0, TRUE),
(3, 1, 1, 'Garlic Breadsticks', 'Baked to a golden brown perfection, seasoned with savory garlic and herbs.', 'https://images.unsplash.com/photo-1573140247632-f8fd74997d5c?auto=format&fit=crop&w=600&q=80', 129.0, TRUE),

-- Biryani Blues Items
(4, 2, 2, 'Hyderabadi Chicken Biryani', 'Authentic long-grain basmati rice slow-cooked dum style with tender marinated chicken and rich spices.', 'https://images.unsplash.com/photo-1633945274405-b6c8069047b0?auto=format&fit=crop&w=600&q=80', 349.0, TRUE),
(5, 2, 2, 'Paneer Dum Biryani', 'Fragrant basmati rice layered with fresh paneer cubes and spiced caramelized onions.', 'https://images.unsplash.com/photo-1563379091339-03b21ab4a4f8?auto=format&fit=crop&w=600&q=80', 299.0, TRUE),
(6, 2, 1, 'Chicken 65 Starter', 'Spicy deep-fried chicken bites tossed with curry leaves, green chilies, and tangy sauce.', 'https://images.unsplash.com/photo-1610057099443-fde8c4d50f91?auto=format&fit=crop&w=600&q=80', 249.0, TRUE),

-- Burger King Items
(7, 3, 4, 'Crispy Veg Whopper', 'Signature flame-grilled veg patty with crisp lettuce, fresh tomatoes, creamy mayo on a toasted sesame seed bun.', 'https://images.unsplash.com/photo-1568901346375-23c9450c58cd?auto=format&fit=crop&w=600&q=80', 169.0, TRUE),
(8, 3, 4, 'Fiery Chicken Burger', 'Crispy chicken patty infused with habanero spice sauce, onions, and spicy pickles.', 'https://images.unsplash.com/photo-1615297928064-24977384d0da?auto=format&fit=crop&w=600&q=80', 199.0, TRUE),
(9, 3, 7, 'Chocolate Shake', 'Rich, velvety chocolate milkshake blended with vanilla soft serve.', 'https://images.unsplash.com/photo-1572490122747-3968b75cc699?auto=format&fit=crop&w=600&q=80', 99.0, TRUE),

-- Mainland China Items
(10, 4, 5, 'Vegetable Hakka Noodles', 'Classic stir-fried wok noodles loaded with crunchy julienned vegetables and light soy sauce.', 'https://images.unsplash.com/photo-1585032226651-759b368d7246?auto=format&fit=crop&w=600&q=80', 229.0, TRUE),
(11, 4, 5, 'Steamed Chicken Momos', 'Delicate steamed dumplings stuffed with juicy minced chicken and served with spicy chilli chutney.', 'https://images.unsplash.com/photo-1625220194771-7ebdea0b70b9?auto=format&fit=crop&w=600&q=80', 189.0, TRUE),

-- Sweet Truth Items
(12, 5, 6, 'Molten Choco Lava Cake', 'Warm chocolate cake with a molten center of rich melted dark chocolate fudge.', 'https://images.unsplash.com/photo-1606313564200-e75d5e30476c?auto=format&fit=crop&w=600&q=80', 119.0, TRUE),
(13, 5, 6, 'New York Cheesecake', 'Classic dense and creamy baked cheesecake with a buttery graham cracker crust.', 'https://images.unsplash.com/photo-1533134242443-d4fd215305ad?auto=format&fit=crop&w=600&q=80', 179.0, TRUE);

-- Insert Product Sizes
INSERT INTO product_sizes (size_id, product_id, size_name, price) VALUES
-- Farmhouse Pizza sizes
(1, 1, 'Regular (7 inch)', 299.0),
(2, 1, 'Medium (10 inch)', 499.0),
(3, 1, 'Large (12 inch)', 699.0),

-- Peppy Paneer Pizza sizes
(4, 2, 'Regular (7 inch)', 329.0),
(5, 2, 'Medium (10 inch)', 549.0),
(6, 2, 'Large (12 inch)', 749.0),

-- Garlic Breadsticks
(7, 3, 'Standard Pack', 129.0),

-- Hyderabadi Chicken Biryani sizes
(8, 4, 'Single Portion', 349.0),
(9, 4, 'Family Pack', 649.0),

-- Paneer Dum Biryani sizes
(10, 5, 'Single Portion', 299.0),
(11, 5, 'Family Pack', 549.0),

-- Chicken 65
(12, 6, 'Full Plate', 249.0),

-- Burgers
(13, 7, 'Single Patty', 169.0),
(14, 7, 'Double Patty Meal', 259.0),
(15, 8, 'Single Patty', 199.0),
(16, 8, 'Double Patty Meal', 289.0),

-- Beverages & Sides
(17, 9, 'Regular 300ml', 99.0),
(18, 9, 'Large 500ml', 149.0),

-- Noodles & Momos
(19, 10, 'Half Plate', 149.0),
(20, 10, 'Full Plate', 229.0),
(21, 11, '6 Pieces', 189.0),
(22, 11, '10 Pieces', 289.0),

-- Desserts
(23, 12, '1 Piece', 119.0),
(24, 12, 'Pack of 2', 219.0),
(25, 13, '1 Slice', 179.0);

-- Insert Default Demo User (password: user123)
INSERT INTO users (user_id, username, password, email, phone, address, role, created_at) VALUES
(1, 'John Doe', 'user123', 'john@example.com', '9876543210', 'Flat 402, Sunshine Apartments, MG Road, Bengaluru', 'Customer', CURRENT_TIMESTAMP);
