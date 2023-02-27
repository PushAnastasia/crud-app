# Spring Boot CRUD application

---
[Java - Maven - Spring Boot - Docker]
---

#### Summary:

This a basic example of the CRUD application on Java.
It includes only API for several endpoints.
The application is adapted to be run in the Docker container or directly from the CLI using Maven
#### System Requirements:

* JDK 1.8 or above
* Maven 3.8.7 or above
* Docker 20.10.22 or above

#### How to run the application from the CLI
Run in the root directory following command:

    mvn spring-boot:run

The application is now accessible at the http://localhost:9000/user

#### How to shut down the application
Send the POST request to http://localhost:9000/actuator/shutdown

    curl -X POST localhost:9000/actuator/shutdown

#### How to run the application inside the Docker container
Run in the root directory following commands one by one:

    docker build -t app .

    docker run -d --network "external-api" --name "crud" -p 9000:9000 app

The application is now accessible at the http://localhost:9000/user

#### How to stop the Docker container with application
Run the following docker command:

    docker stop crud

For the image deletion run:

    docker rm crud
    docker image rm app
