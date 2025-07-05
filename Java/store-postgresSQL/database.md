Designing a database for an Amazon-like e-commerce platform requires a schema that can handle a wide range of data including users, products, categories, orders, reviews, shipping, and more. Here's a high-level **relational database design** for an **Amazon-like product system**.

---

## 🔧 Core Requirements

* Support for multiple users and sellers
* Product catalog with categories and specifications
* Customer reviews and ratings
* Inventory and stock management
* Orders and order tracking
* Payments and shipping

---

## 📦 Tables & Schema Design

### 1. **Users**

```sql
Users (
    user_id INT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    password_hash VARCHAR(255),
    address TEXT,
    phone_number VARCHAR(20),
    role ENUM('customer', 'seller', 'admin'),
    created_at DATETIME
)
```

### 2. **Categories**

```sql
Categories (
    category_id INT PRIMARY KEY,
    name VARCHAR(255),
    parent_category_id INT, -- for subcategories
    FOREIGN KEY (parent_category_id) REFERENCES Categories(category_id)
)
```

### 3. **Products**

```sql
Products (
    product_id INT PRIMARY KEY,
    seller_id INT,
    name VARCHAR(255),
    description TEXT,
    price DECIMAL(10, 2),
    category_id INT,
    brand VARCHAR(100),
    created_at DATETIME,
    FOREIGN KEY (seller_id) REFERENCES Users(user_id),
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
)
```

### 4. **ProductImages**

```sql
ProductImages (
    image_id INT PRIMARY KEY,
    product_id INT,
    image_url TEXT,
    is_main BOOLEAN,
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
)
```

### 5. **Inventory**

```sql
Inventory (
    inventory_id INT PRIMARY KEY,
    product_id INT,
    stock_quantity INT,
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
)
```

### 6. **Orders**

```sql
Orders (
    order_id INT PRIMARY KEY,
    user_id INT,
    order_date DATETIME,
    status ENUM('pending', 'shipped', 'delivered', 'cancelled'),
    shipping_address TEXT,
    total_amount DECIMAL(10, 2),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
)
```

### 7. **OrderItems**

```sql
OrderItems (
    order_item_id INT PRIMARY KEY,
    order_id INT,
    product_id INT,
    quantity INT,
    price_at_purchase DECIMAL(10, 2),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
)
```

### 8. **Payments**

```sql
Payments (
    payment_id INT PRIMARY KEY,
    order_id INT,
    payment_date DATETIME,
    payment_method ENUM('card', 'paypal', 'bank_transfer'),
    payment_status ENUM('pending', 'completed', 'failed'),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id)
)
```

### 9. **Reviews**

```sql
Reviews (
    review_id INT PRIMARY KEY,
    user_id INT,
    product_id INT,
    rating INT CHECK (rating >= 1 AND rating <= 5),
    comment TEXT,
    review_date DATETIME,
    FOREIGN KEY (user_id) REFERENCES Users(user_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
)
```

### 10. **Shipping**

```sql
Shipping (
    shipping_id INT PRIMARY KEY,
    order_id INT,
    carrier VARCHAR(100),
    tracking_number VARCHAR(100),
    estimated_delivery DATE,
    status ENUM('in_transit', 'delivered', 'delayed'),
    FOREIGN KEY (order_id) REFERENCES Orders(order_id)
)
```

---

## ⚙️ Optional Enhancements

* **Wishlist**
* **Coupons & Promotions**
* **Product Variants** (size, color)
* **Audit Logs**
* **Admin Dashboard Tables**

---

If you’re specifically interested in a **database design focused on Amazon products**, we’ll tailor it to the **product catalog** only — that includes product details, categories, brands, sellers, pricing, images, inventory, and variants (like size/color).

---

## 📦 Amazon Products Database Design (Relational)

---

### 1. **Products**

Stores core product info.

```sql
Products (
    product_id INT PRIMARY KEY,
    title VARCHAR(255),
    description TEXT,
    brand_id INT,
    seller_id INT,
    category_id INT,
    created_at DATETIME,
    updated_at DATETIME,
    FOREIGN KEY (brand_id) REFERENCES Brands(brand_id),
    FOREIGN KEY (seller_id) REFERENCES Sellers(seller_id),
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
)
```

---

### 2. **Brands**

```sql
Brands (
    brand_id INT PRIMARY KEY,
    name VARCHAR(255) UNIQUE
)
```

---

### 3. **Sellers**

```sql
Sellers (
    seller_id INT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    rating FLOAT
)
```

---

### 4. **Categories** (Supports Nested Categories)

```sql
Categories (
    category_id INT PRIMARY KEY,
    name VARCHAR(255),
    parent_category_id INT,
    FOREIGN KEY (parent_category_id) REFERENCES Categories(category_id)
)
```

---

### 5. **ProductVariants** (for different sizes/colors etc.)

```sql
ProductVariants (
    variant_id INT PRIMARY KEY,
    product_id INT,
    sku VARCHAR(100) UNIQUE,
    color VARCHAR(100),
    size VARCHAR(100),
    price DECIMAL(10, 2),
    stock_quantity INT,
    is_active BOOLEAN,
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
)
```

---

### 6. **ProductImages**

```sql
ProductImages (
    image_id INT PRIMARY KEY,
    product_id INT,
    image_url TEXT,
    is_main BOOLEAN,
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
)
```

---

### 7. **Specifications**

Allows flexible key-value specs per product.

```sql
ProductSpecifications (
    spec_id INT PRIMARY KEY,
    product_id INT,
    key_name VARCHAR(255),
    value TEXT,
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
)
```

---

### 8. **ProductReviews**

```sql
ProductReviews (
    review_id INT PRIMARY KEY,
    product_id INT,
    user_id INT,
    rating INT CHECK (rating BETWEEN 1 AND 5),
    comment TEXT,
    review_date DATETIME,
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
)
```

---

## ✅ Example: A "Nike Running Shoe"

| Table                 | Data                                |
| --------------------- | ----------------------------------- |
| Products              | "Nike Air Zoom Pegasus"             |
| ProductVariants       | Size: 9, Color: Black, Price: \$120 |
| ProductImages         | 3 images (1 main, 2 additional)     |
| ProductSpecifications | Material: Mesh, Sole: Rubber        |
| Categories            | Shoes > Running Shoes               |
| Sellers               | Nike Store                          |
| Reviews               | 4.5 average from 200 reviews        |

---

Would you like:

* An **ERD (Entity Relationship Diagram)**?
* A **NoSQL version** (like for DynamoDB)?
* Integration with **search (e.g. Elasticsearch)**?
* Sample SQL queries?

Let me know how deep you want to go.

