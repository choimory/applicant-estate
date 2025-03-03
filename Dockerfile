FROM openjdk:17-slim

EXPOSE 9090

COPY build/libs/applicant-estate-0.0.1-SNAPSHOT.jar applicant-estate.jar

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=${PROFILE}","/applicant-estate.jar"]