# Spring Boot REST API
This is a sample Java / Gradle / Spring Boot REST API.

### Installation
You'll need:
- JDK 8.
### Instructions
To run the app:
```sh
./gradlew build
```
### Sample
```sh
curl -i -X POST -H "Content-Type: application/json" -d '{"dna":["ATGCGA","CAGTGC","TTATGT","AGCAAG","CCTCTA","TCACTG"]}' http://localhost:8080/mutant
```
