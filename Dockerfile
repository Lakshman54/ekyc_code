FROM openjdk:21

WORKDIR /ekyc

ARG JAR_FILE=target/*.jar
ENV JAVA_OPTS=$JAVA_OPTS

COPY ${JAR_FILE} ekyc.jar

CMD ["java", "-jar", "ekyc.jar", "${JAVA_OPTS:-}"]