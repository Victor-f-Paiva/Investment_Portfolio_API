# 💼 Investment Portfolio API

A RESTful API for managing users, investment wallets, and financial assets like stocks and real estate funds.

## 📜 Description

This API allows users to manage investment portfolios by registering users, creating wallets, and adding various assets. It also calculates total wallet values and taxes.

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
git clone https://github.com/your-username/investments.git
cd investments
2.	Install dependencies:
mvn install
3.	Configure the database connection:
•	Copy the file src/main/resources/application.properties.example to application.properties.
cp src/main/resources/application.properties.example src/main/resources/application.properties
•	Open application.properties and configure your PostgreSQL database credentials:
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
4.	Start the PostgreSQL database.
5.	Run the application:
mvn spring-boot:run
The API will run at: http://localhost:8080
________________________________________
📁 Project Structure
src/main/java/com/paiva/investments
├── controller
├── exception
├── model
├── repository
├── service
└── InvestmentsApplication.java
________________________________________
📑 API Endpoints
Method	Endpoint	Description
User Management		
POST	/api/users	Create a user
GET	/api/users	List all users
GET	/api/users/{id}	Get user by ID
PUT	/api/users/{id}	Update user
DELETE	/api/users/{id}	Delete user
Wallet Management		
POST	/api/wallets	Create a wallet
GET	/api/wallets	List all wallets
GET	/api/wallets/{id}/assets	Get all assets from a wallet
GET	/api/wallets/{id}/total-value	Get total wallet value
GET	/api/wallets/{id}/total-taxes	Get total taxes for the wallet
PUT	/api/wallets/{id}	Update a wallet
DELETE	/api/wallets/{id}	Delete a wallet
Asset Management		
POST	/api/assets	Create a generic asset
POST	/api/assets/stocks	Create a stock
POST	/api/assets/realstatefunds	Create a real estate fund
GET	/api/assets	List all assets
GET	/api/assets/{id}	Get asset by ID
PUT	/api/assets/{id}	Update an asset
DELETE	/api/assets/{id}	Delete an asset
________________________________________
🔥 Example Requests (Postman)
🧑‍💼 Create User
•	POST /api/users
{
  "name": "Victor Paiva",
  "email": "victor@example.com"
}
________________________________________
💼 Create Wallet
•	POST /api/wallets
{
  "name": "Long Term Investments"
}
________________________________________
📈 Create Stock
•	POST /api/assets/stocks
{
  "name": "Apple Inc.",
  "ticker": "AAPL",
  "quantity": 10,
  "value": 1500.00,
  "tax": 15.00
}
________________________________________
🏢 Create Real Estate Fund
•	POST /api/assets/realstatefunds
{
  "name": "FII ABC Plaza",
  "ticker": "ABC11",
  "quantity": 50,
  "value": 5000.00,
  "tax": 50.00
}
________________________________________
🔎 Get Wallet Total Value
•	GET /api/wallets/{id}/total-value
________________________________________
🏗️ Database
The database schema is generated automatically using JPA:
•	spring.jpa.hibernate.ddl-auto=update
You only need to create the database manually in PostgreSQL.
Example:
CREATE DATABASE investments;
________________________________________
🤝 Contribution
Contributions are welcome! To contribute:
1.	Fork the repository.
2.	Create a new branch (git checkout -b feature/your-feature).
3.	Commit your changes (git commit -m 'Add some feature').
4.	Push to the branch (git push origin feature/your-feature).
5.	Open a Pull Request.
________________________________________
🪪 License
This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.________________________________________
📩 Contact
•	Author: Victor Paiva
•	[LinkedIn](https://www.linkedin.com/in/victor-paiva-b4392ab7/)
