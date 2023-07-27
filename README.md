## Frameworks and Language used:

The Music Stream API project is developed using the following technologies:


* Java
* Spring Boot
* SQL database
* Postman
* Swagger
##  Data Flow:

1) Client Request: The data flow begins when a client sends an HTTP request to the API. The request can include various operations such as retrieving music tracks, creating playlists, or managing user accounts.

2) Controller: The Spring Boot controller receives the incoming request and maps it to a specific method within the controller class based on the defined routes or endpoints. The controller is responsible for handling the request and extracting any relevant data from the request parameters or body.

3) Service Layer: Once the controller receives the request, it delegates the business logic and data processing tasks to the service layer. The service layer contains the application's core logic and is responsible for performing operations such as retrieving data from the database, validating inputs, and applying business rules.

4) Data Repository: The service layer interacts with the data repository to perform database operations. The data repository, often implemented using an object-relational mapping (ORM) framework like Spring Data JPA, provides an abstraction layer for working with the database. It handles tasks such as querying the database, persisting data, and managing transactions.

5) Data Processing: The service layer processes the data retrieved from the data repository, applies business logic, and performs any necessary calculations or transformations.

6) Response Generation: After the data processing is complete, the service layer prepares the response data. It may format the data into a specific structure or serialize it into a suitable format, such as JSON, before returning it to the controller.

7) Controller Response: The controller receives the response from the service layer and sends it back to the client as an HTTP response. The response may include the requested data or an appropriate status code indicating the success or failure of the operation.

Project Summery:
-
This project is a music streaming service API that allows two types of users: Normal and Admin users. Admin users have the authority to perform CRUD (Create, Read, Update, and Delete) operations on songs, while normal users can only add songs to their playlists and perform CRUD operations on their playlists.

The API is built using MySQL database to store songs and user playlists, and its IP address of the deployment link must be static to ensure its availability. Additionally, the API uses annotation-based validation to ensure that all user inputs are valid before being processed.

The project structure includes a controller service and a repository, providing a clear separation of concerns and making the code more modular. Furthermore.

To ensure data security and user data privacy, normal users cannot create or do CRUD operations on songs, and only Admin users have the necessary permissions to perform these actions. This ensures that the API is both secure and user-friendly.

Overall, this project provides a scalable and secure API for music streaming services that allows users to manage their playlists effectively while ensuring the safety of their data.






