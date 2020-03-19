1. Clone or download to your local directory.
2.  Build the project using 'mvn clean install'.
3.  Import as maven project to eclipse/intellij.
4.  Run as spring application.
5.  Test the REST services using ARC/Postman. 
 
 Use localhost:8080 as context-path.

Note. All the data that were stored will be lost on server restart. This is because the application uses in-memory H2 Db that lives as long as the server is up.
