# E-Commerce API Documentation

## Overview
This Spring Boot application provides a comprehensive e-commerce REST API with the following entities:
- **Users**: Customer management with roles (ADMIN, USER, GUEST)
- **Categories**:  categorization
- **Brands**: Brand management for products
- **Sellers**: Vendor management
- **Products**: Product catalog with pricing and inventory
- **ProductImages**: Product image management
- **ProductSpecifications**: Product technical specifications
- **ProductVariants**: Product variants (color, size, SKU)
- **Orders**: Order processing with status tracking
- **Payments**: Payment processing with multiple methods
- **Reviews**: Product review system
- **Inventory**: Stock management
- **Shipping**: Order fulfillment tracking

## Base URL
```
http://localhost:8080
```

## API Endpoints Summary

### Users Management (`/users`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/users` | Get all users |
| POST | `/users` | Create new user |
| GET | `/users/{id}` | Get user by ID |
| PUT | `/users/{id}` | Update user |
| DELETE | `/users/{id}` | Delete user |

**Sample User Payload:**
```json
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "passwordHash": "hashedpassword123",
  "address": "123 Main St, City, State 12345",
  "phoneNumber": "+1-555-0123",
  "role": "USER"
}
```

### Categories Management (`/categories`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/categories` | Get all categories |
| POST | `/categories` | Create new category |
| GET | `/categories/{id}` | Get category by ID |
| PUT | `/categories/{id}` | Update category |
| DELETE | `/categories/{id}` | Delete category |

**Sample Category Payload:**
```json
{
  "name": "Electronics",
  "description": "Electronic devices and gadgets"
}
```

### Products Management (`/products`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/products` | Get all products |
| POST | `/products` | Create new product |
| GET | `/products/{id}` | Get product by ID |
| PUT | `/products/{id}` | Update product |
| DELETE | `/products/{id}` | Delete product |

**Sample Product Payload:**
```json
{
  "name": "iPhone 15 Pro",
  "description": "Latest Apple iPhone with advanced features",
  "price": 999.99,
  "stockQuantity": 50,
  "category": {
    "categoryId": 1
  },
  "seller": {
    "sellerId": 1
  }
}
```

### Orders Management (`/orders`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/orders` | Get all orders |
| POST | `/orders` | Create new order |
| GET | `/orders/{id}` | Get order by ID |
| PUT | `/orders/{id}` | Update order |
| DELETE | `/orders/{id}` | Delete order |

**Sample Order Payload:**
```json
{
  "orderId": 1001,
  "userId": 1,
  "orderDate": "2024-01-15T10:30:00",
  "status": "pending",
  "shippingAddress": "123 Main St, City, State 12345",
  "totalAmount": 999.99
}
```

**Order Status Values:**
- `pending`
- `shipped`
- `delivered`
- `cancelled`

### Payments Management (`/payments`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/payments` | Get all payments |
| POST | `/payments` | Create new payment |
| GET | `/payments/{id}` | Get payment by ID |
| PUT | `/payments/{id}` | Update payment |
| DELETE | `/payments/{id}` | Delete payment |

**Sample Payment Payload:**
```json
{
  "paymentId": 2001,
  "orderId": 1001,
  "paymentDate": "2024-01-15T11:00:00",
  "paymentMethod": "card",
  "paymentStatus": "completed"
}
```

**Payment Method Values:**
- `card`
- `paypal`
- `bank_transfer`

**Payment Status Values:**
- `pending`
- `completed`
- `failed`

### Brands Management (`/brands`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/brands` | Get all brands |
| POST | `/brands` | Create new brand |
| GET | `/brands/{id}` | Get brand by ID |
| PUT | `/brands/{id}` | Update brand |
| DELETE | `/brands/{id}` | Delete brand |

**Sample Brand Payload:**
```json
{
  "brandId": 1,
  "name": "Apple"
}
```

### Product Images Management (`/product-images`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/product-images` | Get all product images |
| POST | `/product-images` | Create new product image |
| GET | `/product-images/{id}` | Get product image by ID |
| PUT | `/product-images/{id}` | Update product image |
| DELETE | `/product-images/{id}` | Delete product image |

**Sample Product Image Payload:**
```json
{
  "productId": 1,
  "imageUrl": "https://example.com/images/iphone15-main.jpg",
  "isMain": true
}
```

### Product Specifications Management (`/product-specifications`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/product-specifications` | Get all product specifications |
| POST | `/product-specifications` | Create new product specification |
| GET | `/product-specifications/{id}` | Get product specification by ID |
| PUT | `/product-specifications/{id}` | Update product specification |
| DELETE | `/product-specifications/{id}` | Delete product specification |

**Sample Product Specification Payload:**
```json
{
  "specId": 1,
  "productId": 1,
  "keyName": "Screen Size",
  "value": "6.1 inches"
}
```

### Product Variants Management (`/product-variants`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/product-variants` | Get all product variants |
| POST | `/product-variants` | Create new product variant |
| GET | `/product-variants/{id}` | Get product variant by ID |
| PUT | `/product-variants/{id}` | Update product variant |
| DELETE | `/product-variants/{id}` | Delete product variant |

**Sample Product Variant Payload:**
```json
{
  "variantId": 1,
  "productId": 1,
  "sku": "IPH15-BLK-128",
  "color": "Black",
  "size": "128GB",
  "price": 999.99,
  "stockQuantity": 25,
  "isActive": true
}
```

### Reviews Management (`/reviews`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/reviews` | Get all reviews |
| POST | `/reviews` | Create new review |
| GET | `/reviews/{id}` | Get review by ID |
| PUT | `/reviews/{id}` | Update review |
| DELETE | `/reviews/{id}` | Delete review |

**Sample Review Payload:**
```json
{
  "reviewId": 1,
  "userId": 1,
  "productId": 1,
  "rating": 5,
  "comment": "Excellent product! Highly recommended.",
  "reviewDate": "2024-01-15T14:30:00"
}
```

## Data Relationships

### Entity Relationships
1. **Product** belongs to **Category** (Many-to-One)
2. **Product** belongs to **Seller** (Many-to-One)
3. **ProductImages** belongs to **Product** (Many-to-One)
4. **ProductSpecifications** belongs to **Product** (Many-to-One)
5. **ProductVariants** belongs to **Product** (Many-to-One)
6. **Order** belongs to **User** (Many-to-One)
7. **Payment** belongs to **Order** (Many-to-One)
8. **Reviews** belongs to **Product** and **User** (Many-to-One each)

### Key Fields
- **Users**: `userId` (Long), `role` (UserRole enum)
- **Brands**: `brandId` (Integer), `name` (String, unique)
- **Products**: `productId` (Integer), `price` (BigDecimal)
- **ProductImages**: `imageId` (Integer), `isMain` (Boolean)
- **ProductSpecifications**: `specId` (Integer), `keyName` & `value` (String)
- **ProductVariants**: `variantId` (Integer), `sku` (String, unique), `isActive` (Boolean)
- **Orders**: `orderId` (Integer), `status` (OrderStatus enum)
- **Payments**: `paymentId` (Integer), `paymentMethod` & `paymentStatus` (enums)
- **Reviews**: `reviewId` (Integer), `rating` (Integer), `reviewDate` (LocalDateTime)

## Database Configuration
The application uses PostgreSQL database:
- **Database**: `store`
- **Host**: `localhost:5432`
- **Username**: `postgres`
- **Password**: `admin`

## Testing with Postman

1. **Import Collection**: Import the `E-Commerce-API-Collection.postman_collection.json` file
2. **Set Base URL**: The collection uses `{{baseUrl}}` variable set to `http://localhost:8080`
3. **Test Sequence**:
   - Create Categories and Brands first
   - Create Sellers
   - Create Users
   - Create Products (requires existing Category and Seller)
   - Create Product Images, Specifications, and Variants (requires existing Product)
   - Create Orders (requires existing User)
   - Create Payments (requires existing Order)
   - Create Reviews (requires existing User and Product)

## Error Handling
The API returns standard HTTP status codes:
- `200 OK`: Successful GET/PUT requests
- `201 Created`: Successful POST requests
- `204 No Content`: Successful DELETE requests
- `404 Not Found`: Resource not found
- `400 Bad Request`: Invalid request data
- `500 Internal Server Error`: Server errors

## Notes
- All timestamps use ISO 8601 format (`YYYY-MM-DDTHH:mm:ss`)
- Decimal values use standard decimal notation (e.g., `999.99`)
- Foreign key relationships require existing parent entities
- The application uses JPA with automatic timestamp management (`@PrePersist`, `@PreUpdate`)