Great! Below is a simplified **JSON structure** representing the main tables and relationships used in an **Amazon-like product database**.

This JSON doesn't represent actual data but rather the **structure/schema** — think of it as a blueprint of how each entity (table) and its fields are organized.

---

### 🧾 **Amazon-like E-commerce Database Schema in JSON**

```json
{
  "users": {
    "user_id": "integer",
    "name": "string",
    "email": "string",
    "password": "string",
    "created_at": "datetime"
  },
  "products": {
    "product_id": "integer",
    "title": "string",
    "description": "string",
    "brand": "string",
    "category_id": "integer",
    "price": "decimal",
    "created_at": "datetime",
    "updated_at": "datetime"
  },
  "categories": {
    "category_id": "integer",
    "name": "string",
    "parent_id": "integer (nullable)"
  },
  "product_images": {
    "image_id": "integer",
    "product_id": "integer",
    "image_url": "string",
    "alt_text": "string"
  },
  "inventory": {
    "inventory_id": "integer",
    "product_id": "integer",
    "stock_quantity": "integer",
    "warehouse_id": "integer (optional)"
  },
  "product_attributes": {
    "attribute_id": "integer",
    "product_id": "integer",
    "attribute_name": "string",
    "attribute_value": "string"
  },
  "reviews": {
    "review_id": "integer",
    "product_id": "integer",
    "user_id": "integer",
    "rating": "integer",
    "comment": "string",
    "created_at": "datetime"
  },
  "orders": {
    "order_id": "integer",
    "user_id": "integer",
    "order_date": "datetime",
    "status": "string",
    "total_amount": "decimal"
  },
  "order_items": {
    "order_item_id": "integer",
    "order_id": "integer",
    "product_id": "integer",
    "quantity": "integer",
    "price": "decimal"
  },
  "shipping": {
    "shipping_id": "integer",
    "order_id": "integer",
    "address": "string",
    "status": "string",
    "shipped_date": "datetime"
  },
  "wishlist": {
    "wishlist_id": "integer",
    "user_id": "integer",
    "product_id": "integer",
    "added_at": "datetime"
  },
  "cart": {
    "cart_id": "integer",
    "user_id": "integer",
    "created_at": "datetime"
  },
  "cart_items": {
    "cart_item_id": "integer",
    "cart_id": "integer",
    "product_id": "integer",
    "quantity": "integer"
  },
  "payment": {
    "payment_id": "integer",
    "order_id": "integer",
    "payment_method": "string",
    "status": "string",
    "paid_at": "datetime"
  },
  "promotions": {
    "promo_id": "integer",
    "code": "string",
    "description": "string",
    "discount_percent": "decimal",
    "valid_from": "date",
    "valid_to": "date"
  },
  "product_variants": {
    "variant_id": "integer",
    "product_id": "integer",
    "sku": "string",
    "variant_name": "string",
    "price": "decimal",
    "stock_quantity": "integer"
  },
  "sellers": {
    "seller_id": "integer",
    "name": "string",
    "email": "string",
    "rating": "decimal",
    "created_at": "datetime"
  },
  "product_sellers": {
    "product_seller_id": "integer",
    "product_id": "integer",
    "seller_id": "integer",
    "price": "decimal",
    "stock_quantity": "integer"
  },
  "search_history": {
    "search_id": "integer",
    "user_id": "integer",
    "search_term": "string",
    "searched_at": "datetime"
  },
  "audit_log": {
    "log_id": "integer",
    "user_id": "integer",
    "action": "string",
    "table_name": "string",
    "record_id": "integer",
    "timestamp": "datetime"
  }
}
```

---

### ✅ Notes:
- All `*_id` fields are unique identifiers (primary keys).
- Fields like `product_id`, `user_id`, etc., are foreign keys linking related data.
- Data types used: `string`, `integer`, `decimal`, `datetime`, `date`, and `nullable`.

---

Would you like me to:
- Export this as a `.json` file?
- Include sample data for each entity?
- Generate a visual ER diagram?

Let me know what you need next.