# Product API (Spring Boot + MySQL)

## Features
- REST API to manage Products and Categories
  - GET /api/products -> list all products with category info
  - POST /api/products -> insert new product (JSON)
  - GET /api/products/price-range?min={min}&max={max} -> products in price range
  - PUT /api/products/{id}/price?price={newPrice} -> update product price

## Setup (Eclipse)
1. Ensure Java 17 and Maven are installed and configured in Eclipse.
2. Start MySQL and create database:
   ```sql
   CREATE DATABASE productdb;
   ```
3. Update `src/main/resources/application.properties` and set `spring.datasource.username` and `spring.datasource.password`.
4. Import the project into Eclipse:
   - File -> Import -> Existing Maven Projects -> select the folder extracted from the zip.
5. Right-click project -> Maven -> Update Project.
6. Run `com.example.productapi.ProductApiApplication` as Java Application (Spring Boot App).
7. Use Postman or curl to test endpoints.

## Example JSON to create product
```
POST /api/products
Content-Type: application/json

{
  "name": "Smartphone",
  "price": 19999.99,
  "category": { "name": "Electronics" }
}
```

## Notes
- The application uses `spring.jpa.hibernate.ddl-auto=update` to create tables automatically.
- `data.sql` seeds categories but product seeding is left for you to add via API or SQL.
