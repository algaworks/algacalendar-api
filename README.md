# AlgaCalendar

## Links importantes
[OpenAPI Swagger](https://app.swaggerhub.com/apis/AlgaWorks/AlgaCalendar/1.0)

[Docker Image](https://hub.docker.com/r/algaworks/algacalendar-api)

## Execução do projeto

### Via Docker
```shell
docker run -p 8080:8080 -it algaworks/algacalendar-api
```

### Via Jar
Na pasta raiz do projeto, execute:
```shell
java -jar algacalendar-0.0.1.jar
```

### Build com Maven
Em alternativa ao Jar, também é possível executar com o Maven, fazendo o build:
```shell
mvn spring-boot:run
```
