Got it! Here's a **single combined Postman Collection JSON** that merges **all parts (1 to 4)** into one complete collection.

---

```json
{
  "info": {
    "name": "Amazon E-commerce API - Full Collection",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
    "_postman_id": "full-amazon-api-collection"
  },
  "variable": [
    { "key": "base_url", "value": "http://localhost:3000/api" },
    { "key": "token", "value": "your_jwt_token_here" }
  ],
  "item": [
    {
      "name": "Users",
      "item": [
        {
          "name": "Create User",
          "request": {
            "method": "POST",
            "header": [
              { "key": "Content-Type", "value": "application/json" }
            ],
            "url": { "raw": "{{base_url}}/users", "host": ["{{base_url}}"], "path": ["users"] },
            "body": {
              "mode": "raw",
              "raw": "{\"name\":\"John Doe\",\"email\":\"john@example.com\",\"password\":\"pass123\"}"
            }
          }
        },
        {
          "name": "Get User by ID",
          "request": {
            "method": "GET",
            "url": { "raw": "{{base_url}}/users/1", "host": ["{{base_url}}"], "path": ["users", "1"] }
          }
        }
      ]
    },
    {
      "name": "Authentication",
      "item": [
        {
          "name": "Login",
          "request": {
            "method": "POST",
            "header": [{ "key": "Content-Type", "value": "application/json" }],
            "url": { "raw": "{{base_url}}/auth/login", "host": ["{{base_url}}"], "path": ["auth", "login"] },
            "body": {
              "mode": "raw",
              "raw": "{\"email\":\"john@example.com\",\"password\":\"pass123\"}"
            }
          }
        }
      ]
    },
    {
      "name": "Categories",
      "item": [
        {
          "name": "Get All Categories",
          "request": {
            "method": "GET",
            "url": { "raw": "{{base_url}}/categories", "host": ["{{base_url}}"], "path": ["categories"] }
          }
        },
        {
          "name": "Create Category",
          "request": {
            "method": "POST",
            "header": [
              { "key": "Authorization", "value": "Bearer {{token}}" },
              { "key": "Content-Type", "value": "application/json" }
            ],
            "url": { "raw": "{{base_url}}/categories", "host": ["{{base_url}}"], "path": ["categories"] },
            "body": {
              "mode": "raw",
              "raw": "{\"name\":\"Electronics\"}"
            }
          }
        }
      ]
    },
    {
      "name": "Products",
      "item": [
        {
          "name": "Get All Products",
          "request": {
            "method": "GET",
            "url": { "raw": "{{base_url}}/products", "host": ["{{base_url}}"], "path": ["products"] }
          }
        },
        {
          "name": "Get Product by ID",
          "request": {
            "method": "GET",
            "url": { "raw": "{{base_url}}/products/1", "host": ["{{base_url}}"], "path": ["products", "1"] }
          }
        },
        {
          "name": "Create Product",
          "request": {
            "method": "POST",
            "header": [
              { "key": "Authorization", "value": "Bearer {{token}}" },
              { "key": "Content-Type", "value": "application/json" }
            ],
            "url": { "raw": "{{base_url}}/products", "host": ["{{base_url}}"], "path": ["products"] },
            "body": {
              "mode": "raw",
              "raw": "{\"name\":\"Laptop\",\"description\":\"Gaming Laptop\",\"price\":1200.99,\"category_id\":1}"
            }
          }
        },
        {
          "name": "Update Product",
          "request": {
            "method": "PUT",
            "header": [
              { "key": "Authorization", "value": "Bearer {{token}}" },
              { "key": "Content-Type", "value": "application/json" }
            ],
            "url": { "raw": "{{base_url}}/products/1", "host": ["{{base_url}}"], "path": ["products", "1"] },
            "body": {
              "mode": "raw",
              "raw": "{\"price\":1100.50}"
            }
          }
        },
        {
          "name": "Delete Product",
          "request": {
            "method": "DELETE",
            "header": [{ "key": "Authorization", "value": "Bearer {{token}}" }],
            "url": { "raw": "{{base_url}}/products/1", "host": ["{{base_url}}"], "path": ["products", "1"] }
          }
        }
      ]
    },
    {
      "name": "Product Images",
      "item": [
        {
          "name": "Upload Product Image",
          "request": {
            "method": "POST",
            "header": [
              { "key": "Authorization", "value": "Bearer {{token}}" },
              { "key": "Content-Type", "value": "multipart/form-data" }
            ],
            "url": { "raw": "{{base_url}}/product-images", "host": ["{{base_url}}"], "path": ["product-images"] },
            "body": {
              "mode": "formdata",
              "formdata": [
                { "key": "product_id", "value": "1", "type": "text" },
                { "key": "image_file", "type": "file" }
              ]
            }
          }
        },
        {
          "name": "Delete Product Image",
          "request": {
            "method": "DELETE",
            "header": [{ "key": "Authorization", "value": "Bearer {{token}}" }],
            "url": { "raw": "{{base_url}}/product-images/1", "host": ["{{base_url}}"], "path": ["product-images", "1"] }
          }
        }
      ]
    },
    {
      "name": "Inventory",
      "item": [
        {
          "name": "Get Inventory for Product",
          "request": {
            "method": "GET",
            "url": { "raw": "{{base_url}}/inventory/product/1", "host": ["{{base_url}}"], "path": ["inventory", "product", "1"] }
          }
        },
        {
          "name": "Update Inventory",
          "request": {
            "method": "PUT",
            "header": [
              { "key": "Authorization", "value": "Bearer {{token}}" },
              { "key": "Content-Type", "value": "application/json" }
            ],
            "url": { "raw": "{{base_url}}/inventory/1", "host": ["{{base_url}}"], "path": ["inventory", "1"] },
            "body": {
              "mode": "raw",
              "raw": "{\"quantity\": 50}"
            }
          }
        }
      ]
    },
    {
      "name": "Product Attributes",
      "item": [
        {
          "name": "Get Attributes for Product",
          "request": {
            "method": "GET",
            "url": { "raw": "{{base_url}}/product-attributes/product/1", "host": ["{{base_url}}"], "path": ["product-attributes", "product", "1"] }
          }
        },
        {
          "name": "Add Product Attribute",
          "request": {
            "method": "POST",
            "header": [
              { "key": "Authorization", "value": "Bearer {{token}}" },
              { "key": "Content-Type", "value": "application/json" }
            ],
            "url": { "raw": "{{base_url}}/product-attributes", "host": ["{{base_url}}"], "path": ["product-attributes"] },
            "body": {
              "mode": "raw",
              "raw": "{\"product_id\": 1, \"attribute_name\": \"Color\", \"attribute_value\": \"Black\"}"
            }
          }
        }
      ]
    },
    {
      "name": "Reviews",
      "item": [
        {
          "name": "Add Review",
          "request": {
            "method": "POST",
            "header": [
              { "key": "Authorization", "value": "Bearer {{token}}" },
              { "key": "Content-Type", "value": "application/json" }
            ],
            "url": { "raw": "{{base_url}}/reviews", "host": ["{{base_url}}"], "path": ["reviews"] },
            "body": {
              "mode": "raw",
              "raw": "{\"product_id\": 1, \"user_id\": 1, \"rating\": 5, \"comment\": \"Great product!\"}"
            }
          }
        },
        {
          "name": "Delete Review",
          "request": {
            "method": "DELETE",
            "header": [{ "key": "Authorization", "value": "Bearer {{token}}" }],
            "url": { "raw": "{{base_url}}/reviews/1", "host": ["{{base_url}}"], "path": ["reviews", "1"] }
          }
        }
      ]
    },
    {
      "name": "Orders",
      "item": [
        {
          "name": "Create Order",
          "request": {
            "method": "POST",
            "header": [
              { "key": "Authorization", "value": "Bearer {{token}}" },
              { "key": "Content-Type", "value": "application/json" }
            ],
            "url": { "raw": "{{base_url}}/orders", "host": ["{{base_url}}"], "path": ["orders"] },
            "body": {
              "mode": "raw",
              "raw": "{\"user_id\":1, \"status\":\"Pending\", \"total_amount\":199.99}"
            }
          }
        },
        {
          "name": "Get Orders",
          "request": {
            "method": "GET",
            "header": [{ "key": "Authorization", "value": "Bearer {{token}}" }],
            "url": { "raw": "{{base_url}}/orders", "host": ["{{base_url}}"], "path": ["orders"] }
          }
        }
      ]
    },
    {
      "name": "Order Items",
      "item": [
        {
          "name": "Add Order Item",
          "request": {
            "method": "POST",
            "header": [
              { "key": "Authorization", "value": "Bearer {{token}}" },
              { "key": "Content-Type", "value": "application/json" }
            ],
            "url": { "raw": "{{base_url}}/order-items", "host": ["{{base_url}}"], "path": ["order-items"] },
            "body": {
              "mode": "raw",
              "raw": "{\"order_id\":1,\"product_id\":1,\"quantity\":2,\"price\":599.99}"
            }
          }
        }
      ]
    },
    {
      "name": "Product Variants",
      "item": [
        {
          "name": "Get Variants for Product",
          "request": {
            "method": "GET",
            "url": { "raw": "{{base_url}}/product-variants/product/1", "host": ["{{base_url}}"], "path": ["product-variants", "product", "1"] }
          }
        },
        {
          "name": "Add Product Variant",
          "request": {
            "method": "POST",
            "header": [
              { "key": "Authorization", "value": "Bearer {{token}}" },
              { "key": "Content-Type", "value": "application/json" }
            ],
            "url": { "raw": "{{base_url}}/product-variants", "host": ["{{base_url}}"], "path": ["product-variants"] },
            "body": {
              "mode": "raw",
              "raw": "{\"product_id\":1,\"variant_name\":\"Color\",\"variant_value\":\"Red\"}"
            }
          }
        },
        {
          "name": "Delete Product Variant",
          "request": {
            "method": "DELETE",
            "header": [{ "key": "Authorization", "value": "Bearer {{token}}" }],
            "url": { "raw": "{{base_url}}/product-variants/1", "host": ["{{base_url}}"], "path": ["product-variants", "1"] }
          }
        }
      ]
    },
    {
      "name": "Sellers",
      "item": [
        {
          "name": "Get All Sellers",
          "request": {
            "method": "GET",
            "url": { "raw": "{{base_url}}/sellers", "host": ["{{base_url}}"], "path": ["sellers"] }
          }
        },
        {
          "name": "Create Seller",
          "request": {
            "method": "POST",
            "header": [
              { "key": "Authorization", "value": "Bearer {{token}}" },
              { "key": "Content-Type", "value": "application/json" }
            ],
            "url": { "raw": "{{base_url}}/sellers", "host": ["{{base_url}}"], "path": ["sellers"] },
            "body": {
              "mode": "raw",
              "raw": "{\"name\":\"BestSeller Inc.\",\"contact_info\":\"contact@bestseller.com\"}"
            }
          }
        },
        {
          "name": "Get Seller by ID",
          "request": {
            "method": "GET",
            "url": { "raw": "{{base_url}}/sellers/1", "host": ["{{base_url}}"], "path": ["sellers", "1"] }
          }
        }
      ]
    },
    {
      "name": "Product Sellers",
      "item": [
        {
          "name": "Assign Product to Seller",
          "request": {
            "method": "POST",
            "header": [
              { "key": "Authorization", "value": "Bearer {{token}}" },
              { "key": "Content-Type", "value": "application/json" }
            ],
            "url": { "raw": "{{base_url}}/product-sellers", "host": ["{{base_url}}"], "path": ["product-sellers"] },
            "body": {
              "mode": "raw",
              "raw": "{\"product_id\":1,\"seller_id\":1,\"price\":599.99,\"stock\":100}"
            }
          }
        },
        {
          "name": "Get Sellers for Product",
          "request": {
            "method": "GET",
            "url": { "raw": "{{base_url}}/product-sellers/product/1", "host": ["{{base_url}}"], "path": ["product-sellers", "product", "1"] }
          }
        }
      ]
    },
    {
      "name": "Search History",
      "item": [
        {
          "name": "Get Search History for User",
          "request": {
            "method": "GET",
            "header": [{ "key": "Authorization", "value": "Bearer {{token}}" }],
            "url": { "raw": "{{base_url}}/search-history/user/1", "host": ["{{base_url}}"], "path": ["search-history", "user", "1"] }
          }
        },
        {
          "name": "Add Search Entry",
          "request": {
            "method": "POST",
            "header": [
              { "key": "Authorization", "value": "Bearer {{token}}" },
              { "key": "Content-Type", "value": "application/json" }
            ],
            "url": { "raw": "{{base_url}}/search-history", "host": ["{{base_url}}"], "path": ["search-history"] },
            "body": {
              "mode": "raw",
              "raw": "{\"user_id\":1,\"search_text\":\"smartphone\"}"
            }
          }
        }
      ]
    },
    {
      "name": "Audit Logs",
      "item": [
        {
          "name": "Get All Audit Logs",
          "request": {
            "method": "GET",
            "header": [{ "key": "Authorization", "value": "Bearer {{token}}" }],
            "url": { "raw": "{{base_url}}/audit-logs", "host": ["{{base_url}}"], "path": ["audit-logs"] }
          }
        },
        {
          "name": "Get Audit Log by ID",
          "request": {
            "method": "GET",
            "header": [{ "key": "Authorization", "value": "Bearer {{token}}" }],
            "url": { "raw": "{{base_url}}/audit-logs/1", "host": ["{{base_url}}"], "path": ["audit-logs", "1"] }
          }
        }
      ]
    }
  ]
}

```

---

### How to use

1. Copy the whole JSON above to a `.json` file, e.g., `amazon-api.postman_collection.json`.
2. Open Postman.
3. Click **Import** > **Upload Files** > Select the JSON file.
4. Set your environment variables for `base_url` and `token` as needed.

---

If you want me to generate it as an actual downloadable file or split differently, just let me know!
```
