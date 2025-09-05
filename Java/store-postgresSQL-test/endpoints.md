Here's a full list of **RESTful API endpoints (services)** for an **Amazon-style e-commerce platform**, based on the database schema we discussed.

Each service is grouped by entity (like users, products, orders, etc.) and follows standard REST conventions:

---

## 📦 1. **User Services**

| Method | Endpoint           | Description             |
| ------ | ------------------ | ----------------------- |
| GET    | `/users`           | Get list of all users   |
| GET    | `/users/{user_id}` | Get user by ID          |
| POST   | `/users`           | Register a new user     |
| PUT    | `/users/{user_id}` | Update user profile     |
| DELETE | `/users/{user_id}` | Delete user             |
| POST   | `/users/login`     | Login and get JWT token |

---

## 🛍️ 2. **Product Services**

| Method | Endpoint                 | Description                      |
| ------ | ------------------------ | -------------------------------- |
| GET    | `/products`              | Get list of all products         |
| GET    | `/products/{product_id}` | Get single product by ID         |
| POST   | `/products`              | Add a new product (admin/seller) |
| PUT    | `/products/{product_id}` | Update product info              |
| DELETE | `/products/{product_id}` | Delete a product                 |

---

## 🧱 3. **Category Services**

| Method | Endpoint                    | Description                 |
| ------ | --------------------------- | --------------------------- |
| GET    | `/categories`               | Get all categories          |
| GET    | `/categories/{category_id}` | Get category by ID          |
| POST   | `/categories`               | Create new category (admin) |
| PUT    | `/categories/{category_id}` | Update category             |
| DELETE | `/categories/{category_id}` | Delete category             |

---

## 🖼️ 4. **Product Image Services**

| Method | Endpoint                        | Description                 |
| ------ | ------------------------------- | --------------------------- |
| GET    | `/products/{product_id}/images` | Get all images of a product |
| POST   | `/products/{product_id}/images` | Upload product image        |
| DELETE | `/product-images/{image_id}`    | Delete an image             |

---

## 🏬 5. **Inventory Services**

| Method | Endpoint                  | Description                     |
| ------ | ------------------------- | ------------------------------- |
| GET    | `/inventory`              | Get inventory for all products  |
| GET    | `/inventory/{product_id}` | Get inventory by product ID     |
| PUT    | `/inventory/{product_id}` | Update inventory (admin/seller) |

---

## 🎨 6. **Product Attributes Services**

| Method | Endpoint                             | Description              |
| ------ | ------------------------------------ | ------------------------ |
| GET    | `/products/{product_id}/attributes`  | Get product attributes   |
| POST   | `/products/{product_id}/attributes`  | Add product attribute    |
| PUT    | `/product-attributes/{attribute_id}` | Update product attribute |
| DELETE | `/product-attributes/{attribute_id}` | Delete attribute         |

---

## ⭐ 7. **Review Services**

| Method | Endpoint                         | Description                   |
| ------ | -------------------------------- | ----------------------------- |
| GET    | `/products/{product_id}/reviews` | Get all reviews for a product |
| POST   | `/products/{product_id}/reviews` | Post a new review             |
| DELETE | `/reviews/{review_id}`           | Delete review (user/admin)    |

---

## 📦 8. **Order Services**

| Method | Endpoint             | Description                      |
| ------ | -------------------- | -------------------------------- |
| GET    | `/orders`            | Get all orders (admin/user)      |
| GET    | `/orders/{order_id}` | Get order by ID                  |
| POST   | `/orders`            | Place a new order                |
| PUT    | `/orders/{order_id}` | Update order status (admin only) |
| DELETE | `/orders/{order_id}` | Cancel/delete order (admin/user) |

---

## 📦 9. **Order Items Services**

| Method | Endpoint                   | Description           |
| ------ | -------------------------- | --------------------- |
| GET    | `/orders/{order_id}/items` | Get items in an order |
| POST   | `/orders/{order_id}/items` | Add item to an order  |

---

## 🚚 10. **Shipping Services**

| Method | Endpoint                  | Description                       |
| ------ | ------------------------- | --------------------------------- |
| GET    | `/shipping/{order_id}`    | Get shipping details for an order |
| POST   | `/shipping`               | Add shipping info                 |
| PUT    | `/shipping/{shipping_id}` | Update shipping status            |

---

## 💖 11. **Wishlist Services**

| Method | Endpoint                  | Description                  |
| ------ | ------------------------- | ---------------------------- |
| GET    | `/wishlist`               | Get user's wishlist          |
| POST   | `/wishlist`               | Add product to wishlist      |
| DELETE | `/wishlist/{wishlist_id}` | Remove product from wishlist |

---

## 🛒 12. **Cart Services**

| Method | Endpoint                     | Description             |
| ------ | ---------------------------- | ----------------------- |
| GET    | `/cart`                      | Get current user's cart |
| POST   | `/cart/items`                | Add item to cart        |
| PUT    | `/cart/items/{cart_item_id}` | Update item quantity    |
| DELETE | `/cart/items/{cart_item_id}` | Remove item from cart   |

---

## 💳 13. **Payment Services**

| Method | Endpoint                 | Description                      |
| ------ | ------------------------ | -------------------------------- |
| GET    | `/payments/{order_id}`   | Get payment details for an order |
| POST   | `/payments`              | Make a payment                   |
| PUT    | `/payments/{payment_id}` | Update payment status            |

---

## 🎁 14. **Promotion/Coupon Services**

| Method | Endpoint                 | Description                   |
| ------ | ------------------------ | ----------------------------- |
| GET    | `/promotions`            | Get all available promo codes |
| POST   | `/promotions`            | Create a new promo (admin)    |
| DELETE | `/promotions/{promo_id}` | Delete a promo code           |

---

## 🧩 15. **Product Variant Services**

| Method | Endpoint                          | Description                |
| ------ | --------------------------------- | -------------------------- |
| GET    | `/products/{product_id}/variants` | Get variants for a product |
| POST   | `/products/{product_id}/variants` | Add variant                |
| PUT    | `/product-variants/{variant_id}`  | Update variant             |
| DELETE | `/product-variants/{variant_id}`  | Delete variant             |

---

## 🧑‍💼 16. **Seller Services**

| Method | Endpoint               | Description           |
| ------ | ---------------------- | --------------------- |
| GET    | `/sellers`             | Get all sellers       |
| GET    | `/sellers/{seller_id}` | Get seller profile    |
| POST   | `/sellers`             | Register a new seller |
| PUT    | `/sellers/{seller_id}` | Update seller profile |

---

## 🔗 17. **Product-Seller Services**

| Method | Endpoint                         | Description                        |
| ------ | -------------------------------- | ---------------------------------- |
| GET    | `/products/{product_id}/sellers` | Get all sellers offering a product |
| POST   | `/product-sellers`               | Assign seller to a product         |

---

## 🔍 18. **Search History Services**

| Method | Endpoint          | Description               |
| ------ | ----------------- | ------------------------- |
| GET    | `/search-history` | Get user's search history |
| POST   | `/search-history` | Log a new search          |

---

## 🧾 19. **Audit Log (Admin)**

| Method | Endpoint     | Description                     |
| ------ | ------------ | ------------------------------- |
| GET    | `/audit-log` | Get all audit logs (admin only) |

---

## 🧠 Optional Advanced Services:

* `/recommendations` – personalized suggestions based on user behavior.
* `/ab-tests` – A/B test group tracking (for UI experiments).

---

### ✅ API Style:

* RESTful
* JSON-based responses
* Uses JWT or OAuth2 for secure authentication
* Role-based access for admin vs user vs seller

---

Would you like:

* A **Postman collection** for these endpoints?
* An **OpenAPI / Swagger specification**?
* Sample **request/response JSONs**?

Let me know how you'd like to proceed!
