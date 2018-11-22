Pre requisites:
- Java 8
- Maven 3+
- Mongo client for loading the seed data
- Docker (Docker and docker-compose)


First run:
mvn clean install           // build the jar
docker-compose build        // build the images (spring and mongo)
docker-compose up           // spin up both images (spring and mongo)
mongo mongo-seed-data.js    // load the seed data to the mongo DB (Mongo data files will be stored in ./data/db/)

curl http://localhost:8080/api/v1/users

Subsequent runs:
- If no changes to the java:
    docker-compose up

    curl http://localhost:8080/api/v1/users

- If there are changes to the java code:
    mvn clean install
    docker-compose build
    docker-compose up

    curl http://localhost:8080/api/v1/users

