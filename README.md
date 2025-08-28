💰 FinanceManager

FinanceManager is a simple Java-based finance tracking application that helps you manage incomes and expenses directly from the command line.
It is built using Maven for dependency management and easy builds.

🚀 Features

Add and view incomes 💵

Add and view expenses 💳

Calculate and display net balance 📊

Lightweight, runs on any system with Java

🛠️ Prerequisites

Before running this project, ensure you have the following installed:

Java JDK 17+

Apache Maven 3.8+

Git

Verify installations with:

java -version
mvn -version
git --version

📥 Installation & Setup

Clone the Repository

git clone https://github.com/YOUR_USERNAME/FinanceManager.git
cd FinanceManager


Build the Project

mvn clean install


Run the Application

mvn exec:java -Dexec.mainClass="com.financemanager.App"

🎮 Usage

Once you run the app, you’ll see a command-line interface where you can:

Enter incomes and expenses

View your balance

Exit when done

Example:

Welcome to Finance Manager!
1. Add Income
2. Add Expense
3. View Balance
4. Exit
Enter your choice: 1
Enter income amount: 1000
Income added successfully!

🧪 Running Tests

This project uses JUnit for unit testing.
Run all tests with:

mvn test

🤝 Contributing

Fork the repository

Create a new branch (feature/your-feature-name)

Commit changes (git commit -m "Added new feature")

Push to your branch (git push origin feature/your-feature-name)

Open a Pull Request

📜 License

This project is licensed under the MIT License – feel free to use and modify it.

👉 Replace YOUR_USERNAME in the clone URL with your GitHub username once you push the repo.
