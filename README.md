# 📊 Investment Portfolio API

A RESTful API for managing users, investment wallets, and financial assets like stocks and real estate funds.

---

## 📜 Description

This API allows users to manage investment portfolios by registering users, creating wallets, and adding various assets. It also calculates total wallet values and taxes.

- Registering users
- Creating investment wallets
- Adding various assets (stocks and real estate funds)
- Calculating total wallet values and taxes

---

## 🚀 Technologies

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

---

## 🔧 Requirements

- Java 21
- PostgreSQL
- Maven

---

## 💾 Installation

1. **Clone the repository:**

```bash
git clone https://github.com/your-username/Investment_Portfolio_API.git
cd investments
````

2. **Install dependencies:**

```bash
mvn install
```

3. **Configure the database connection:**

* Copy the example configuration file:

```bash
cp src/main/resources/application.properties.example src/main/resources/application.properties
```

* Edit `src/main/resources/application.properties` with your PostgreSQL credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```

4. **Start your PostgreSQL database.**

5. **Run the application:**

```bash
mvn spring-boot:run
```

The API will be available at:
➡️ `http://localhost:8080`

---

## 📁 Project Structure

```
src/main/java/com/paiva/investments
├── controller
├── exception
├── model
├── repository
├── service
└── InvestmentsApplication.java
```

---

## 📑 API Endpoints

### 👤 User Management

| Method | Endpoint          | Description    |
| ------ | ----------------- | -------------- |
| POST   | `/api/users`      | Create a user  |
| GET    | `/api/users`      | List all users |
| GET    | `/api/users/{id}` | Get user by ID |
| PUT    | `/api/users/{id}` | Update user    |
| DELETE | `/api/users/{id}` | Delete user    |

---

### 💼 Wallet Management

| Method | Endpoint                        | Description                    |
| ------ | ------------------------------- | ------------------------------ |
| POST   | `/api/wallets`                  | Create a wallet                |
| GET    | `/api/wallets`                  | List all wallets               |
| GET    | `/api/wallets/{id}/assets`      | Get all assets from a wallet   |
| GET    | `/api/wallets/{id}/total-value` | Get total wallet value         |
| GET    | `/api/wallets/{id}/total-taxes` | Get total taxes for the wallet |
| PUT    | `/api/wallets/{id}`             | Update a wallet                |
| DELETE | `/api/wallets/{id}`             | Delete a wallet                |
| PUT    | `/api/wallets/{id}/add-asset/{assetId}`             | Add asset in wallet                |
| DELETE    | `/api/wallets/{id}/remove-asset/{assetId}`             | Remove asset from wallet                |


---

### 📈 Asset Management

| Method | Endpoint                     | Description               |
| ------ | ---------------------------- | ------------------------- |
| POST   | `/api/assets`                | Create a generic asset    |
| POST   | `/api/assets/stocks`         | Create a stock            |
| POST   | `/api/assets/realstatefunds` | Create a real estate fund |
| GET    | `/api/assets`                | List all assets           |
| GET    | `/api/assets/{id}`           | Get asset by ID           |
| PUT    | `/api/assets/{id}`           | Update an asset           |
| DELETE | `/api/assets/{id}`           | Delete an asset           |

---

## 🔥 Example Requests (Postman)

### 👤 Create User

**POST** `/api/users`

```json
{
  "name": "Victor Paiva",
  "email": "victor@example.com"
}
```

---

### 💼 Create Wallet

**POST** `/api/wallets`

```json
{
  "name": "Long Term Investments"
}
```

---

### 📈 Create Stock

**POST** `/api/assets/stocks`

```json
{
  "name": "PETR4",
  "value": 28.00,
  "dividends": 24.00
}
```

---

### 🏢 Create Real Estate Fund

**POST** `/api/assets/realstatefunds`

```json
{
  "name": "ABC11",
  "value": 122.00,
  "dividends": 13.23
}
```

---

### 💰 Get Wallet Total Value

**GET** `/api/wallets/{id}/total-value`

---

## 🏗️ Database

The database schema is generated automatically by JPA using:

```properties
spring.jpa.hibernate.ddl-auto=update
```

### ✅ You only need to create the database manually:

```sql
CREATE DATABASE investments;
```

---

## 🤝 Contribution

Contributions are welcome! To contribute:

1. Fork the repository
2. Create a new branch:

```bash
git checkout -b feature/your-feature
```

3. Commit your changes:

```bash
git commit -m "Add some feature"
```

4. Push to the branch:

```bash
git push origin feature/your-feature
```

5. Open a Pull Request

---

## 🪪 License

This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.

---

## 📩 Contact

* **Author:** Victor Paiva
* [LinkedIn](https://www.linkedin.com/in/victor-paiva-b4392ab7/)

```

