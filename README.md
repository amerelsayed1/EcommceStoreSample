
# Ecommerce Store Spring Boot Project

This is a Spring Boot-based backend project designed for an **E-commerce store** application. It handles product catalog management, customer interactions, order placements, and other core e-commerce functionalities.

## Technologies Used

- **Spring Boot**: A Java-based framework to build the application.
- **Spring Data JPA**: For managing data access and CRUD operations.
- **H2 Database**: An in-memory database for development (replaceable with other DBs like MySQL or PostgreSQL).
- **MapStruct**: For DTO to Entity and Entity to DTO mapping.
- **JUnit 5**: For unit and integration tests.
- **Lombok**: To reduce boilerplate code such as getters, setters, constructors.
- **Maven/Gradle**: For dependency management and build automation.

## Setup and Installation

### Prerequisites

- **JDK 11 or higher**: Make sure to have JDK installed.
- **Maven/Gradle**: For dependency management and build. Use the build tool you are most comfortable with.
  
### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/ecommerce-store.git
   cd ecommerce-store
   ```

2. Install the required dependencies:

   If you're using **Maven**:

   ```bash
   mvn install
   ```

   Or **Gradle**:

   ```bash
   ./gradlew build
   ```

3. Configure your database connection (optional):
   - For development, you can use **H2** database (default configuration).
   - For production, configure **MySQL** or **PostgreSQL** by modifying the `application.properties` file in `src/main/resources`.

4. Build the application:

   ```bash
   mvn clean install
   ```

   Or with **Gradle**:

   ```bash
   ./gradlew build
   ```

5. Run the application:

   ```bash
   mvn spring-boot:run
   ```

   Or with **Gradle**:

   ```bash
   ./gradlew bootRun
   ```

   The application should now be running locally on `http://localhost:8080`.

## API Documentation

Below is a quick overview of some key API endpoints:

### Product Endpoints

- `POST /api/products`: Add a new product.
- `GET /api/products`: Retrieve a list of all products.
- `GET /api/products/{id}`: Retrieve a single product by ID.
- `PUT /api/products/{id}`: Update an existing product.
- `DELETE /api/products/{id}`: Delete a product by ID.

### Category Endpoints

- `POST /api/categories`: Add a new product category.
- `GET /api/categories`: Retrieve all categories.
- `GET /api/categories/{id}`: Get a category by ID.
  
### Customer Endpoints

- `POST /api/customers`: Add a new customer.
- `GET /api/customers/{id}`: Retrieve customer details by ID.

### Order Endpoints

- `POST /api/orders`: Place a new order.
- `GET /api/orders/{id}`: View an order's details by ID.
