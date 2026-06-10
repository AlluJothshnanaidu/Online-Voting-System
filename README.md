# Online Voting System 🗳️

A web-based **Online Voting System** developed using **Java, JDBC, Servlets, JSP, MySQL, Maven, and Apache Tomcat**. This application allows users to register, log in, cast their vote securely, and view election results.

---

## 📌 Project Overview

The Online Voting System is designed to automate the voting process and eliminate manual vote counting. Users can register, log in with valid credentials, vote for a candidate, and view election results in real time.

---

## 🚀 Features

### 👤 User Module

* User Registration
* User Login
* Session Management
* Logout Functionality

### 🗳️ Voting Module

* Display Candidate List
* Cast Vote
* One User = One Vote
* Prevent Duplicate Voting

### 📊 Result Module

* Display Vote Count
* Show Election Results
* Real-Time Result Generation

---

## 🛠️ Technologies Used

| Technology       | Purpose               |
| ---------------- | --------------------- |
| Java             | Backend Logic         |
| JDBC             | Database Connectivity |
| Servlets         | Request Processing    |
| JSP              | Frontend Pages        |
| MySQL            | Database              |
| Maven            | Dependency Management |
| Apache Tomcat 11 | Web Server            |
| HTML/CSS         | User Interface        |

---

## 📂 Project Structure

```text
VotingApp
│
├── src/main/java
│
│   ├── com.voting.dao
│   │     ├── DBConnection.java
│   │     ├── UserDAO.java
│   │     └── VoteDAO.java
│
│   ├── com.voting.model
│   │     ├── User.java
│   │     └── Candidate.java
│
│   ├── com.voting.servlet
│   │     ├── RegisterServlet.java
│   │     ├── LoginServlet.java
│   │     ├── VoteServlet.java
│   │     ├── ResultServlet.java
│   │     └── LogoutServlet.java
│
├── src/main/webapp
│   ├── index.jsp
│   ├── register.jsp
│   ├── login.jsp
│   ├── vote.jsp
│   ├── result.jsp
│   └── WEB-INF
│
└── pom.xml
```

---

## 🗄️ Database Setup

### Create Database

```sql
CREATE DATABASE online_voting_system;
```

### Use Database

```sql
USE online_voting_system;
```

### Create Voters Table

```sql
CREATE TABLE voters(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    mobile VARCHAR(20)
);
```

### Create Candidates Table

```sql
CREATE TABLE candidates(
    candidate_id INT PRIMARY KEY AUTO_INCREMENT,
    candidate_name VARCHAR(100)
);
```

### Insert Candidates

```sql
INSERT INTO candidates(candidate_name)
VALUES
('Narendra Modi'),
('Rahul Gandhi'),
('Arvind Kejriwal');
```

### Create Votes Table

```sql
CREATE TABLE votes(
    vote_id INT PRIMARY KEY AUTO_INCREMENT,
    voter_id INT,
    candidate_id INT,
    FOREIGN KEY(voter_id) REFERENCES voters(id),
    FOREIGN KEY(candidate_id) REFERENCES candidates(candidate_id)
);
```

---

## ⚙️ Maven Dependencies

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>9.3.0</version>
</dependency>

<dependency>
    <groupId>jakarta.servlet</groupId>
    <artifactId>jakarta.servlet-api</artifactId>
    <version>6.1.0</version>
    <scope>provided</scope>
</dependency>
```

---

## 🔗 Database Configuration

### DBConnection.java

```java
private static final String URL =
"jdbc:mysql://localhost:3306/online_voting_system";

private static final String USER = "root";
private static final String PASSWORD = "root";
```

Update username and password according to your MySQL configuration.

---

## ▶️ How to Run

### Step 1

Clone the repository:

```bash
git clone https://github.com/your-username/VotingApp.git
```

### Step 2

Import project into Eclipse as:

```text
Existing Maven Project
```

### Step 3

Configure MySQL database.

### Step 4

Update Maven Project:

```text
Right Click Project
→ Maven
→ Update Project
```

### Step 5

Add project to Tomcat Server.

### Step 6

Start Tomcat.

### Step 7

Open browser:

```text
http://localhost:8080/VotingApp
```

---

## 🔄 Application Workflow

### Registration

```text
User
 ↓
Register.jsp
 ↓
RegisterServlet
 ↓
UserDAO
 ↓
MySQL Database
```

### Login

```text
User
 ↓
Login.jsp
 ↓
LoginServlet
 ↓
UserDAO
 ↓
Session Creation
```

### Vote

```text
Vote.jsp
 ↓
VoteServlet
 ↓
VoteDAO
 ↓
Votes Table
```

### Results

```text
ResultServlet
 ↓
VoteDAO
 ↓
Result.jsp
```

---


## 🔐 Security Features

* Session Management
* Login Validation
* JDBC Prepared Statements
* SQL Injection Prevention
* One Vote Per User

---

## 🎯 Learning Outcomes

By building this project, you will learn:

* JDBC CRUD Operations
* Servlet Lifecycle
* JSP Development
* Session Tracking
* Database Connectivity
* Maven Dependency Management
* MVC Architecture
* Web Application Deployment on Tomcat

---

## 👩‍💻 Author

**Jothshna Allu**

Java Full Stack Developer

Email: `jothshnanaidu@gmail.com`

---
