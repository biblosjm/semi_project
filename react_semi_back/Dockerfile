FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app
COPY . .
# 윈도우 환경에서 작성된 mvnw 스크립트의 줄바꿈(CRLF)을 리눅스(LF) 호환으로 변환
RUN sed -i 's/\r$//' mvnw
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/react_semi_back-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
