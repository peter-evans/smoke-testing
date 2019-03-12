FROM openjdk:8-jdk-alpine

COPY /build/install/example-api /example-api
COPY /config /example-api/config

ENTRYPOINT ["/example-api/bin/example-api", "server", "/example-api/config/local.yml"]

EXPOSE 8080
