# 🍔 Food Delivery Web Application

### A Java-Based Online Food Ordering and Management System

A dynamic and user-friendly Food Delivery Web Application developed using Java, JSP, Servlets, JDBC and MySQL. This application provides an online platform where users can explore restaurants, browse food menus, select products, manage their shopping cart and place food orders conveniently.

The project follows a layered architecture using DAO (Data Access Object) design patterns to separate database operations from application logic, making the application easier to maintain and extend.

---

## 📌 Table of Contents

- About the Project
- Project Objectives
- Key Features
- Technologies Used
- Project Architecture
- Project Folder Structure
- Application Workflow
- Database Design
- Installation and Setup
- How to Run the Project
- Future Enhancements
- Learning Outcomes
- Author

---

## 🚀 About the Project

The Food Delivery Application is a web-based application designed to simplify the online food ordering process.

Users can register and log in to their accounts, explore available restaurants and food items, view product details, select different product sizes, add items to their cart, update quantities and proceed to checkout.

The application uses Java Servlets to handle incoming requests, JSP for dynamic user interfaces, JDBC for database connectivity and MySQL for storing application data.

It provides a practical implementation of Java Full Stack development concepts, including object-oriented programming, database connectivity, CRUD operations, session management and MVC-based application flow.

---

## 🎯 Project Objectives

- Develop a complete web-based food ordering application.
- Implement user registration and authentication.
- Provide restaurant and food menu browsing functionality.
- Implement shopping cart management.
- Enable customers to place and track their orders.
- Integrate Java applications with MySQL using JDBC.
- Apply DAO design patterns for database operations.
- Build a structured and maintainable web application.

---

## ✨ Key Features

### 1. User Management
- New user registration.
- User login functionality.
- User logout functionality.
- Session-based user management.
- User information management.

### 2. Restaurant Management
- Display available restaurants.
- Retrieve restaurant information from the database.
- Browse restaurant menus.

### 3. Food Menu Management
- Display food products.
- View individual product details.
- Retrieve food items based on restaurant.
- Retrieve food items based on category.
- Search food products.
- Select available product sizes.

### 4. Shopping Cart Management
- Add food items to the cart.
- View cart items.
- Increase product quantity.
- Decrease product quantity.
- Remove products from the cart.
- Calculate cart total.
- Clear cart items after successful order placement.

### 5. Order Management
- Proceed to checkout.
- Enter delivery address.
- Select payment method.
- Place food orders.
- Generate order records.
- Store individual order items.
- View previous orders.
- View order details.
- Display order success confirmation.

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| Java | Backend programming |
| JSP | Dynamic web pages |
| Servlets | Request and response handling |
| JDBC | Database connectivity |
| MySQL | Relational database |
| HTML | Web page structure |
| CSS | Styling and layout |
| Apache Tomcat | Web application server |
| Eclipse IDE | Development environment |
| Git & GitHub | Version control and project hosting |

---

## 🏗️ Project Architecture

The application follows a layered architecture with separation of responsibilities.

### 1. Presentation Layer
**JSP, HTML and CSS**

Responsible for displaying the user interface and accepting user inputs.

### 2. Controller Layer
**Java Servlets**

Responsible for processing HTTP requests, managing application flow and communicating with the DAO layer.

### 3. Data Access Layer
**DAO and DAO Implementation Classes**

Responsible for performing database operations such as inserting, updating, deleting and retrieving records.

### 4. Model Layer
**Java Model Classes**

Contains Java objects representing application entities such as User, Restaurant, Menu, Cart, CartItem and Order.

### 5. Database Layer
**MySQL**

Stores user details, restaurant information, food products, cart information and order records.

---

## 📂 Project Folder Structure

```text
Food-Delivery-App/
│
├── src/
│   └── main/
│       │
│       ├── java/
│       │   └── com/
│       │       └── tap/
│       │           │
│       │           ├── dao/
│       │           │   ├── Userdao.java
│       │           │   ├── Restaurantdao.java
│       │           │   ├── Menudao.java
│       │           │   ├── Cartdao.java
│       │           │   ├── Cartitemdao.java
│       │           │   ├── Orderdao.java
│       │           │   ├── Orderitemdao.java
│       │           │   ├── Categorydao.java
│       │           │   └── Productsizedao.java
│       │           │
│       │           ├── daoimp/
│       │           │   ├── userdaoimp.java
│       │           │   ├── Restaurantdaoimp.java
│       │           │   ├── Menudaoimp.java
│       │           │   ├── Cartdaoimp.java
│       │           │   ├── Cartitemdaoimp.java
│       │           │   ├── Orderdaoimp.java
│       │           │   ├── Orderitemdaoimp.java
│       │           │   ├── Categorydaoimp.java
│       │           │   └── Productsizedaoimp.java
│       │           │
│       │           ├── module/
│       │           │   ├── User.java
│       │           │   ├── Restaurant.java
│       │           │   ├── Menu.java
│       │           │   ├── Cart.java
│       │           │   ├── CartItem.java
│       │           │   ├── Order.java
│       │           │   ├── Orderitem.java
│       │           │   ├── Category.java
│       │           │   └── Productsize.java
│       │           │
│       │           ├── servlets/
│       │           │   ├── RegisterServlet.java
│       │           │   ├── LoginServlet.java
│       │           │   ├── LogoutServlet.java
│       │           │   ├── HomeServlet.java
│       │           │   ├── MenuServlet.java
│       │           │   ├── ProductDetailsServlet.java
│       │           │   ├── AddToCartServlet.java
│       │           │   ├── CartServlet.java
│       │           │   ├── UpdateCartServlet.java
│       │           │   ├── RemoveCartItemServlet.java
│       │           │   ├── CheckoutServlet.java
│       │           │   ├── PlaceOrderServlet.java
│       │           │   └── MyOrdersServlet.java
│       │           │
│       │           └── utitity/
│       │               └── DBconnection.java
│       │
│       └── webapp/
│           │
│           ├── CSS/
│           │   ├── images/
│           │   ├── home.css
│           │   └── style.css
│           │
│           ├── WEB-INF/
│           │   └── web.xml
│           │
│           ├── META-INF/
│           │
│           ├── index.jsp
│           ├── home.jsp
│           ├── login.jsp
│           ├── register.jsp
│           ├── menu.jsp
│           ├── productDetails.jsp
│           ├── Cart.jsp
│           ├── checkout.jsp
│           ├── myOrder.jsp
│           ├── orderDetails.jsp
│           └── orderSuccess.jsp
│
├── .classpath
├── .project
├── .gitignore
└── README.md
```

---

## 🔄 Application Workflow

The application follows this general workflow:

1. User opens the Food Delivery Application.
2. User registers or logs into the application.
3. The application displays available restaurants.
4. User selects a restaurant and explores its food menu.
5. User views product details and selects a suitable size.
6. User adds selected food items to the shopping cart.
7. User updates quantities or removes unwanted products.
8. User proceeds to the checkout page.
9. User enters the delivery address and selects a payment method.
10. User confirms the order.
11. The application stores order and order-item information in MySQL.
12. User receives an order success confirmation and can view previous orders.

---

## 🗄️ Database Design

The application uses MySQL as its relational database.

The application contains DAO interfaces and implementations for the following entities:

| Entity | Description |
|---|---|
| User | Stores user information |
| Restaurant | Stores restaurant details |
| Category | Manages food categories |
| Menu | Stores food product information |
| Productsize | Maintains product size and pricing information |
| Cart | Maintains user shopping carts |
| CartItem | Stores individual cart products |
| Order | Stores customer order information |
| Orderitem | Stores products associated with orders |

### Database Configuration

Database name:

```sql
foodapp
```

Database connection is managed through the JDBC DriverManager API.

Configure the following connection details using environment variables:

```text
DB_URL=jdbc:mysql://localhost:3306/foodapp
DB_USERNAME=your_mysql_username
DB_PASSWORD=your_mysql_password
```

Make sure the required database tables and relationships are created before running the application.

---

## ⚙️ Installation and Setup

Follow these steps to run the project locally.

### Prerequisites

Install the following software:

- Java Development Kit (JDK)
- Eclipse IDE for Enterprise Java and Web Development
- Apache Tomcat Server
- MySQL Server
- MySQL Connector/J JDBC Driver
- Git

### Step 1: Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/Food-Delivery-App.git
```

### Step 2: Open the Project

1. Open Eclipse IDE.
2. Select File → Import.
3. Select Existing Projects into Workspace.
4. Browse the cloned project directory.
5. Import the project.

### Step 3: Configure MySQL

1. Start MySQL Server.
2. Create the database named `foodapp`.
3. Create the required tables and relationships.
4. Configure database connection environment variables.

### Step 4: Configure JDBC

Add the MySQL Connector/J library to the project's build path.

### Step 5: Configure Apache Tomcat

1. Add Apache Tomcat to Eclipse.
2. Configure the project with the compatible Tomcat runtime.
3. Add the project to the Tomcat server.

### Step 6: Run the Application

1. Right-click the project.
2. Select Run As.
3. Choose Run on Server.
4. Select Apache Tomcat.
5. Open the application in your browser.

---

## 🔮 Future Enhancements

The following features can be implemented to improve the application:

- Online payment gateway integration.
- Admin dashboard for restaurant management.
- Restaurant and menu management interface.
- Real-time order status tracking.
- Improved search and filtering functionality.
- Password encryption and stronger authentication.
- Responsive design for mobile devices.
- REST API integration.
- Email and SMS order notifications.
- Deployment to a cloud hosting platform.

---

## 📚 Learning Outcomes

Through this project, I gained practical experience in:

- Java Object-Oriented Programming.
- Java Servlets and JSP.
- JDBC database connectivity.
- MySQL database management.
- CRUD operations.
- DAO design pattern.
- HTTP request and response handling.
- Session management.
- MVC-based application development.
- Git and GitHub version control.
- Building end-to-end Java web applications.

---

## 👨‍💻 Author

**CHARAN TEJ**

Java Full Stack Developer | B.Tech Graduate

Interested in Java Development, Backend Development and Full Stack Web Technologies.

### Connect With Me

- GitHub: https://github.com/mahachavancharantej
- LinkedIn: Add your LinkedIn profile URL here.

---

## ⭐ Support

If you find this project interesting, consider giving this repository a ⭐ on GitHub.

Thank you for visiting my Food Delivery Web Application repository!
