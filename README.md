# Simple JAVA Spring Boot Application of Students

This is a simple Java SpringBoot API that serves as a template for building RESTful APIs using SpringBoot framework.
In this first application, we will not cover the security aspect of the API, but we will cover the basic topics, such
as:
controller, service, repository, and model.

## Installation

- Clone the repository
- Install Java 11
- Install Maven
- Build the project using the following command:

    ```
    mvn clean install
    ```
- Run the application using the following command:

    ```
    mvn spring-boot:run
    ```

or

```
java -jar target/StudentsAPI-0.0.1-SNAPSHOT.jar
```

## Run an instance of Postgres Database using Docker

- Install Docker
- Run the following command:

 ```
 docker run --name postgres -e POSTGRES_DB=students -e POSTGRES_PASSWORD=postgres -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 -d postgres
 ```

## Usage

Once the application is up and running, you can access the API at the following URL:

    http://localhost:8080/api/v1

The API has the following endpoints:

- GET /hello: returns a simple hello message
- GET /hello-list: returns a simple hello message in a JSON List


- GET /students: returns a list of students
- GET /students/{id}: returns a student with the given id
- POST /students: adds a new student to the list
- PUT /students/{id}: updates a student with the given id
- DELETE /students/{id}: deletes a student with the given id

- GET /calculator/{num1}/{num2}: returns the sum of the num1 and num2

## Contributing

If you wish to contribute to this project, feel free to create a pull request.

## License

This project is licensed under the
[MIT](https://choosealicense.com/licenses/mit/) License. See the LICENSE file for more details.

