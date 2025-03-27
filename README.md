# scalable-tracking-number-generator

## 📌 Project Overview
The Tracking ID Generator is a highly scalable and distributed system designed to generate unique tracking numbers efficiently. The application leverages Redis Cluster to ensure high availability, fault tolerance, and low-latency ID generation, making it ideal for handling high-concurrency environments.

## ⚡ Key Features
✔ Unique ID Generation – Ensures every tracking ID is globally unique.
✔ High Scalability – Supports horizontal scaling for distributed environments.
✔ Low Latency – Efficient ID generation using Redis Cluster.
✔ Fault Tolerance – Redis replication ensures availability even during node failures.
✔ Dockerized Setup – Runs Redis Cluster and the Spring Boot application in containers.

## 🛠️ Tech Stack
- Java 11+ – Core application logic
- Spring Boot 3.3.5 – Framework for backend services
- Redis Cluster – Distributed cache and ID generation
- Docker & Docker Compose – Containerized Redis and application
- Maven – Dependency management

🚀 Getting Started
- Ensure you have the following installed:
- Docker & Docker Compose
- Java 17
- Maven

## Local Testing
1. Run `docker-compose up -d` (If Docker not available local redis setup is required).
2. Build application using `mvn clean install`.
3. Start spring boot application using embedded tomcat server using `mvn spring-boot:run`.
4. Run curl command `curl --location 'http://localhost:8080/api/tracking/generate` to generate tracking id.
5. To view tracking id in the redis cli run `docker exec -it redis-server redis-cli`. Now run `KEYS *` in redis-cli you should see printed output to the console like below:
    ```
         1) "tracking_numbers"
    ```
6. Now run command `GET tracking_numbers` to see tracking ids into the terminal.

***Note: If you are not using docker based redis server then you can alternatively skip docker commands but the redis commands will be same for non docker redis server. Also, you can use GUI application for redis.***