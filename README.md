
Download the project using github link.
Pre-requisites:
1) Java and JDK must be setup and JAVA_HOME must be added in the path

Project can be explored and debugging can be done using intelliJ or eclispe. Open the pom.xml as a project in INtelliJ.

Go to the base directory and Use following instructions to launch the project
1) mvn package
2) mvn clean install
3) mvn exec:java -Dexec.mainClass=com.interview.CreditCardMgmt.CreditCardMgmtApplication

After successfully starting the server, launch the application using: http://localhost:8081/creditcards

Admin Username and Password:
Username: admin
password: admin

Backend for all functionalities is complete except custom login. Current login functionality is provided by spring security module.
Explore all the API developed using Swagger: http://localhost:8081/swagger-ui.html


Functionalities:
Adding user functionality is not linked with the main application yet. Users can be added using :
1) Add users : http://localhost:8081/addUser
2) Add creidt cards : http://localhost:8081/addCreditCards
3) Check credit card details: http://localhost:8081/creditcards

Issues:
Login adds users, but does not validate according to them. Custom validator and password matcher needs to be implemented. Login works using, admin, admin as username and password.
Form Validations 
Expiry date while adding credit card does not work in Mozilla, but works in chrome

New update!!
