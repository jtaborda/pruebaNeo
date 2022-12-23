#FROM openjdk:11-jre-slim
#RUN useradd javams && addgroup devopsc && adduser javams devopsc
#USER javams:devopsc
#ENV JAVA_OPTS=""
#ARG JAR_FILE
#ENTRYPOINT ${JAR_FILE}
#ADD ${JAR_FILE} /app.jar
#COPY ${JAR_FILE} app.jar
# use a volume is mor efficient and speed that filesystem
#VOLUME /tmp
#EXPOSE 7280
#ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app.jar
EXPOSE 7280
ENTRYPOINT ["java","-jar","/app.jar"]
