FROM ubuntu:latest
LABEL authors="3448614"
# Etapa de build
FROM gradle:8.5-jdk21 AS builder
# Baixar wait-for-it
RUN curl -o /wait-for-it.sh https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh \
    && chmod +x /wait-for-it.sh

# Adicionar seu código e dependências
COPY . /app
WORKDIR /app

# Rodar o comando de build após garantir que o banco de dados está disponível
CMD /wait-for-it.sh db:3306 -- gradle build --no-daemon && java -jar build/libs/atividadeavaliativa.jar

COPY . .
RUN gradle build --no-daemon

# Etapa final
FROM openjdk:21-jdk-slim AS base
WORKDIR /app
COPY --from=builder /app/build/libs/atividadeavaliativa-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
