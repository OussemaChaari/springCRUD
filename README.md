# springCRUD
A simple CRUD web app for managing Customers

This project is considered as handshake with the springMVC/hibernate.\
Funcionality: The function call goes from the controller to the Service layer, which delegates the interaction with the database to
the DAO (this refactoring might be skipped in this project, but it's a good practice to have a Service->DAO in case of multiple DBs).

# Please note
-please wrap all the repository in a "crud-app" folder (first time java project push).\
-The SQL is included in the project files. (don't forget to change the web.xml for the db connection).\
-this project is heavily inspired from Chad Darby's Spring course on udemy.\
