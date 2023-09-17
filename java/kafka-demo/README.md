# Kafka Demo
Simple demo on using Kafka with Spring Boot 3.

## Requirements
- Java 17
- Docker

## Setup
From the root of this project, run
```bash
docker compose up -d
```

Run the application
```bash
.\\gradlew bootRun # Windows
```
```bash
# Linux
./gradlew bootRun 
```

## Usage
Visit http://localhost:8080/swagger-ui/index.html to see and try out the endpoints.

HTTP Payload
```json
{
  "message": "A message"
}
```

cURL
```shell
curl -X POST "http://localhost:8080/messages/publish" 
-H "accept: */*" 
-H "Content-Type: application/json" 
--data "{\"message\": \"A message\"}"
```

See the opened terminal for output from the listener.

Also see [MessageListeners](src/main/java/org/kafka/demo/MessageListeners.java)
## Compose Down
To stop the application, press `Ctrl+C` in the terminal.

To stop and remove the containers, run
```bash
docker compose down -v
```
