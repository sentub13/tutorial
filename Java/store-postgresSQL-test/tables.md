To manage and support Amazon-like product listings, a **database schema** typically involves multiple related tables. Here's a simplified view of the **most commonly used tables** in a database for an Amazon-style product catalog:

---

### 🔶 **1. Products Table**

Stores the basic information of each product.

| Field         | Type       | Description                       |
| ------------- | ---------- | --------------------------------- |
| `product_id`  | INT / UUID | Unique identifier for the product |
| `title`       | VARCHAR    | Product name/title                |
| `description` | TEXT       | Detailed product description      |
| `brand`       | VARCHAR    | Brand name                        |
| `category_id` | INT / UUID | Foreign key to Category table     |
| `price`       | DECIMAL    | Current product price             |
| `created_at`  | TIMESTAMP  | Date the product was added        |
| `updated_at`  | TIMESTAMP  | Last update time                  |

---

### 🔶 **2. Categories Table**

Used to organize products by category and subcategory.

| Field         | Type       | Description                      |
| ------------- | ---------- | -------------------------------- |
| `category_id` | INT / UUID | Unique identifier                |
| `name`        | VARCHAR    | Name of the category             |
| `parent_id`   | INT        | Self-reference for subcategories |

---

### 🔶 **3. Product\_Images Table**

Stores multiple images per product.

| Field        | Type       | Description                            |
| ------------ | ---------- | -------------------------------------- |
| `image_id`   | INT / UUID | Unique ID for image                    |
| `product_id` | INT / UUID | FK to Products                         |
| `image_url`  | VARCHAR    | Image file path or URL                 |
| `alt_text`   | VARCHAR    | Alternative text for SEO/accessibility |

---

### 🔶 **4. Inventory Table**

Tracks stock levels.

| Field            | Type | Description                     |
| ---------------- | ---- | ------------------------------- |
| `inventory_id`   | INT  | Unique ID                       |
| `product_id`     | INT  | FK to Products                  |
| `stock_quantity` | INT  | Number of units available       |
| `warehouse_id`   | INT  | FK to warehouse (if applicable) |

---

### 🔶 **5. Product\_Attributes Table**

Stores product-specific attributes (like color, size, etc.).

| Field             | Type    | Description           |
| ----------------- | ------- | --------------------- |
| `attribute_id`    | INT     | Unique ID             |
| `product_id`      | INT     | FK to Products        |
| `attribute_name`  | VARCHAR | e.g., "Color", "Size" |
| `attribute_value` | VARCHAR | e.g., "Red", "Large"  |

---

### 🔶 **6. Reviews Table**

Customer reviews and ratings for products.

| Field        | Type      | Description    |
| ------------ | --------- | -------------- |
| `review_id`  | INT       | Unique ID      |
| `product_id` | INT       | FK to Products |
| `user_id`    | INT       | FK to Users    |
| `rating`     | INT       | 1-5 stars      |
| `comment`    | TEXT      | Review content |
| `created_at` | TIMESTAMP | Date of review |

---

### 🔶 **7. Users Table**

Stores customer information.

| Field        | Type      | Description           |
| ------------ | --------- | --------------------- |
| `user_id`    | INT       | Unique ID             |
| `name`       | VARCHAR   | Customer name         |
| `email`      | VARCHAR   | Email address         |
| `password`   | VARCHAR   | Encrypted password    |
| `created_at` | TIMESTAMP | Account creation date |

---

### 🔶 **8. Orders Table**

Stores customer orders.

| Field          | Type      | Description               |
| -------------- | --------- | ------------------------- |
| `order_id`     | INT       | Unique ID                 |
| `user_id`      | INT       | FK to Users               |
| `order_date`   | TIMESTAMP | When the order was placed |
| `status`       | VARCHAR   | e.g., Pending, Shipped    |
| `total_amount` | DECIMAL   | Total cost of the order   |

---

### 🔶 **9. Order\_Items Table**

Items that are part of each order.

| Field           | Type    | Description               |
| --------------- | ------- | ------------------------- |
| `order_item_id` | INT     | Unique ID                 |
| `order_id`      | INT     | FK to Orders              |
| `product_id`    | INT     | FK to Products            |
| `quantity`      | INT     | Quantity of product       |
| `price`         | DECIMAL | Price at time of purchase |

---

### 🔶 **10. Shipping Table**

Tracks shipping information.

| Field          | Type      | Description                 |
| -------------- | --------- | --------------------------- |
| `shipping_id`  | INT       | Unique ID                   |
| `order_id`     | INT       | FK to Orders                |
| `address`      | TEXT      | Delivery address            |
| `status`       | VARCHAR   | e.g., In Transit, Delivered |
| `shipped_date` | TIMESTAMP | When shipped                |

---
## 🔷 11. **Wishlist Table**

Stores user wishlisted items.

| Field         | Type      | Description                |
| ------------- | --------- | -------------------------- |
| `wishlist_id` | INT       | Unique ID                  |
| `user_id`     | INT       | FK to Users                |
| `product_id`  | INT       | FK to Products             |
| `added_at`    | TIMESTAMP | When the product was added |

---

## 🔷 12. **Cart Table**

Represents the user's shopping cart.

| Field        | Type      | Description  |
| ------------ | --------- | ------------ |
| `cart_id`    | INT       | Unique ID    |
| `user_id`    | INT       | FK to Users  |
| `created_at` | TIMESTAMP | Created date |

### 🔷 13. **Cart\_Items Table**

Items inside a shopping cart.

| Field          | Type | Description       |
| -------------- | ---- | ----------------- |
| `cart_item_id` | INT  | Unique ID         |
| `cart_id`      | INT  | FK to Cart        |
| `product_id`   | INT  | FK to Products    |
| `quantity`     | INT  | Quantity selected |

---

## 🔷 14. **Payment Table**

Stores payment-related details (minimal to keep it secure).

| Field            | Type      | Description                |
| ---------------- | --------- | -------------------------- |
| `payment_id`     | INT       | Unique ID                  |
| `order_id`       | INT       | FK to Orders               |
| `payment_method` | VARCHAR   | Credit card, UPI, etc.     |
| `status`         | VARCHAR   | Paid, Failed, Refunded     |
| `paid_at`        | TIMESTAMP | When payment was processed |

---

## 🔷 15. **Promotions Table**

Supports coupon codes or discounts.

| Field              | Type    | Description            |
| ------------------ | ------- | ---------------------- |
| `promo_id`         | INT     | Unique ID              |
| `code`             | VARCHAR | e.g., "SAVE10"         |
| `description`      | TEXT    | Promo description      |
| `discount_percent` | DECIMAL | e.g., 10.0 for 10% off |
| `valid_from`       | DATE    | Start of promotion     |
| `valid_to`         | DATE    | End of promotion       |

---

## 🔷 16. **Product\_Variants Table**

Handles SKUs for different sizes, colors, etc.

| Field            | Type    | Description                |
| ---------------- | ------- | -------------------------- |
| `variant_id`     | INT     | Unique ID                  |
| `product_id`     | INT     | FK to Products             |
| `sku`            | VARCHAR | Stock keeping unit         |
| `variant_name`   | VARCHAR | e.g., "Red, Large"         |
| `price`          | DECIMAL | May differ from base price |
| `stock_quantity` | INT     | Available units            |

---

## 🔷 17. **Seller Table**

Used in a marketplace with third-party sellers.

| Field        | Type      | Description           |
| ------------ | --------- | --------------------- |
| `seller_id`  | INT       | Unique ID             |
| `name`       | VARCHAR   | Seller/Store name     |
| `email`      | VARCHAR   | Contact email         |
| `rating`     | DECIMAL   | Average seller rating |
| `created_at` | TIMESTAMP | Registration date     |

---

## 🔷 18. **Product\_Seller Table**

Maps products to sellers.

| Field               | Type    | Description              |
| ------------------- | ------- | ------------------------ |
| `product_seller_id` | INT     | Unique ID                |
| `product_id`        | INT     | FK to Products           |
| `seller_id`         | INT     | FK to Sellers            |
| `price`             | DECIMAL | Seller-specific price    |
| `stock_quantity`    | INT     | Seller’s available stock |

---

## 🔷 19. **Search\_History Table**

Stores user search queries for recommendations and analytics.

| Field         | Type      | Description       |
| ------------- | --------- | ----------------- |
| `search_id`   | INT       | Unique ID         |
| `user_id`     | INT       | FK to Users       |
| `search_term` | VARCHAR   | What was searched |
| `searched_at` | TIMESTAMP | Time of search    |

---

## 🔷 20. **Audit\_Log Table**

For tracking changes to records (optional, but used in secure apps).

| Field        | Type      | Description              |
| ------------ | --------- | ------------------------ |
| `log_id`     | INT       | Unique ID                |
| `user_id`    | INT       | Who made the change      |
| `action`     | VARCHAR   | INSERT, UPDATE, DELETE   |
| `table_name` | VARCHAR   | Which table              |
| `record_id`  | INT       | ID of the record changed |
| `timestamp`  | TIMESTAMP | When the action occurred |

---

If you want this in SQL format or an ER diagram, I can generate that too. Would you like a visual ERD or the actual SQL table creation code?
