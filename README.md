# 🏦 Bank System - Java OOP Project

A simple banking system developed in **Java**, focused on practicing **Object-Oriented Programming (OOP)** concepts such as inheritance, polymorphism, abstraction, and custom exceptions.

This project simulates basic bank operations including account creation, deposits, withdrawals, overdraft usage, and monthly updates.

---

## 🚀 Features

✅ Create bank accounts  
✅ Two account types supported:

- **Current Account** (with overdraft limit and withdrawal fee)
- **Savings Account** (with monthly interest)

✅ Deposit and withdraw money  
✅ Custom exception handling  
✅ Monthly update system for all accounts  
✅ Interactive menu system in console  

---

## 🏦 Account Types

### 💳 Current Account

- Supports overdraft limit (cheque especial)
- Withdrawal fee of **$2.50**
- Monthly interest applied if balance is negative

Example rule:

- Balance + overdraft must cover withdrawal
- Fee is always charged

---

### 💰 Savings Account

- Does not allow overdraft
- Monthly interest applied automatically
- Interest rate: **0.5% per month**

---

## ⚠️ Exception Handling

The system uses custom runtime exceptions:

- `InvalidAmountException` → Amount must be greater than zero  
- `InsufficientBalanceException` → Not enough balance for withdrawal  

---

## 📌 Menu Options

### Main Menu

1 - Create account
2 - Enter an account
3 - Apply monthly update
0 - Exit

### Account Menu


1 - Deposit
2 - Withdraw
3 - Check balance
0 - Back to main menu


---

## 🛠 Technologies Used

- Java  
- Object-Oriented Programming principles  
- Collections (`ArrayList`)  
- Custom Exceptions  
- Console-based interaction  

---

## 📚 OOP Concepts Applied

- **Inheritance** (`Account` → `CurrentAccount`, `SavingsAccount`)
- **Polymorphism** (`monthlyUpdate()` behaves differently for each account)
- **Abstraction** (abstract class `Account`)
- **Encapsulation** (getters and setters)
- **Exception Handling**

---

## ▶️ How to Run

1. Clone this repository:

```bash
git clone https://github.com/your-username/bank-system-java.git

Open in your favorite IDE (IntelliJ, Eclipse, VS Code)

Run the program:
