Makersharks Supplier Management API
This project provides a Spring Boot application for managing suppliers with different business natures and manufacturing processes.

Dependencies
This application uses the following libraries:

Spring Boot
Spring Data JPA
Lombok
Make sure you have these dependencies available in your environment.

Running the application
Clone the repository:
git clone https://github.com/your-username/makersharks-supplier-management.git
Install dependencies:
Use a dependency management tool like Maven or Gradle to install the necessary dependencies.

Configure database connection:
Update the application.properties file with your database connection details. This file will typically be located in the src/main/resources folder.

Run the application:
Use your preferred method to run a Spring Boot application. You can either:

Run the main class (com.example.makersharks.MakersharksSupplierManagementApplication) using your IDE.
Package the application as a jar file using Maven or Gradle and then run:
java -jar makersharks-supplier-management.jar
Using the API
The application exposes a REST API for searching suppliers based on various criteria.

Endpoint: /api/supplier/query

Method: POST

Request Parameters:

location: (String) - Location of the supplier
natureOfBusiness: (String) - Nature of the supplier's business (SMALL_SCALE, MEDIUM_SCALE, LARGE_SCALE)
manufacturingProcess: (String) - Manufacturing process the supplier uses (MOULDING, D_PRINTING, CASTING, COATING)
page: (int, optional, default 0) - Pagination page number
size: (int, optional, default 10) - Number of suppliers per page
Response:

The response will be a paginated list of suppliers matching the search criteria.

Example Usage:

curl -X POST http://localhost:8080/api/supplier/query \
  -H "Content-Type: application/json" \
  -d '{ "location": "California", "natureOfBusiness": "MEDIUM_SCALE", "manufacturingProcess": "MOULDING", "page": 1, "size": 5 }'
This request searches for suppliers located in California, with a medium-scale business, that use moulding as a manufacturing process. It retrieves the second page (page number 1) with a maximum of 5 suppliers per page.

Additional Notes:

The GlobalExceptionHandler class handles any IllegalArgumentException thrown by the application and returns a bad request (400) status code with the error message.
You can extend the GlobalExceptionHandler to handle other exceptions specific to your application.