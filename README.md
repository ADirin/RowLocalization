The LocalizationDemo application is a Java program designed to demonstrate localization of strings for different languages using a MySQL database. It allows users to input employee data such as name, age, and salary in their preferred language, and stores this information in the database. The application supports English, Japanese, and Farsi languages.

Setup Instructions:
To set up and run the LocalizationDemo application, follow these steps:

•	Ensure you have Java Development Kit (JDK) installed on your system.
•	Install and configure MySQL database on your local machine.
•	Download and configure MySQL Connector/J for Java to enable JDBC connectivity to the MySQL database.
•	Clone or download the LocalizationDemo project repository from GitHub.
•	Open the project in your preferred Java IDE (e.g., IntelliJ IDEA).
•	Make sure to include the necessary dependencies in the project's Maven configuration (pom.xml).
•	Set up the database schema by executing the provided SQL script to create the required table (localized_strings).
•	Compile and run the LocalizationDemo application.
•	Follow the prompts to select a language and input employee data.
•	Verify that the data is successfully stored in the database.
Challenges:
•	Setting up the LocalizationDemo application and configuring the environment posed several challenges:

•	Dependency Management: Ensuring that all required dependencies, including MySQL Connector/J and SLF4J, are properly configured in the Maven project.
•	Database Configuration: Configuring MySQL database settings such as connection URL, username, and password in the application code and ensuring they are correct.
•	Localization Support: Implementing support for multiple languages (English, Japanese, Farsi) and managing localized strings and resource bundles.
•	SQL Interception: Implementing SQL interception to log SQL statements executed by the application and ensuring compatibility with different versions of MySQL drivers.
•	Testing: Ensuring that the application behaves as expected under different scenarios, including language selection and data input.
By addressing these challenges and following the setup instructions, users can successfully run the LocalizationDemo application and observe the localization of strings in action.
