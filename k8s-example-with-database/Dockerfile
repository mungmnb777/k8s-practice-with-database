FROM openjdk:17-jdk-alpine
ENV ARTIFACT_NAME=k8s-0.0.1-SNAPSHOT.jar
ENV WORKDIR=/home

COPY ./k8s-server/build/libs/$ARTIFACT_NAME ${WORKDIR}/.

EXPOSE 8080
ENTRYPOINT java -jar ${WORKDIR}/${ARTIFACT_NAME}