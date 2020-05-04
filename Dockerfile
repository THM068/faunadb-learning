FROM openjdk:14-alpine
COPY build/libs/faunadb-*-all.jar faunadb.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "faunadb.jar"]