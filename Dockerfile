    FROM openjdk:11-jre-slim as builder
    WORKDIR /application
    ARG JAR_FILE=target/*.jar
    COPY ${JAR_FILE} application.jar
    RUN java -Djarmode=layertools -jar application.jar extract
    FROM openjdk:11-jre-slim
    WORKDIR /application
    COPY --from=builder application/dependencies/ ./
    COPY --from=builder application/spring-boot-loader/ ./
    COPY --from=builder application/snapshot-dependencies/ ./
    COPY --from=builder application/application/ ./
    ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
    # build --> sudo docker build . --tag nano-communicator
    # run   --> sudo docker run -it -p8081:8081 nano-communicator:latest
    # delete containers --> sudo docker rm -f $(sudo docker ps -a -q)
    # delete images --> sudo docker rmi -f $(sudo docker images -a -q)
    # copy error.log --> sudo docker cp container_name:/application/logs/error.log .
