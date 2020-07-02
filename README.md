[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](license)


# This is a group project that builds cars into orders for purchase. The user can choose to display available vehicles, displaying existing orders, create orders, edit orders, delete orders, and to exit the application.  The application is a Java-based application that references a database via mysql queries embedded in the application.

---

## Installation

1. Clone this repository.
    ```
    git clone https://github.com/jgarcia-network/CRUD_APP.git
    ```
1. Install Eclipse IDE for Java and DSL Developers.
	https://www.eclipse.org/downloads/packages/
    ```
1. Download MySQL Connector (Choose Platform Independent > Then download the ZIP, extract to wherever is preferable on system).
	https://dev.mysql.com/downloads/connector
    ```
1. In Eclipse, create a new java project (name it and store in preferable location on system).
    ```
1. Right-click on the project in the left margin, go to New > Package > name the package “CRUD_APP” > click finish | Expand the src folder on the left side margin of Eclipse to make CRUD_APP package visible.
    ```
1. Right-click again on the project in the left margin, go to Build Path > Configure Build Path > Click Add External Jar > Navigate to the MySQL connector that was extracted from downloaded zip > Select the .jar file that appears there, click open, then click Apply and Close 
    ```
1. In computer folders, navigate into the cloned directory from Github > CRUD_APP-develop > mysql_week6_final_project > Select all files and drag them over the CRUD_APP package in Eclipse.
    ```
1. The MySQL connection this project defaults to is username: root password root, if the local system uses a different password, In Eclipse, open the DBConnection.java class file, and type in the password associated with that root connection. Close the DBConnection file.

1. Run script in cars.sql through preferred sql editor (Command Line, Termainal, Sql Workbench).

1. Open the Application.java class file > run it > Use the menu on the Eclipse console for further operation.
    ```
---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
