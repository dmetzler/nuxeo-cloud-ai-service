FROM openjdk:8

ADD target/nuxeo-cloud-ai-service-1.0-SNAPSHOT.jar /opt/ai/nuxeo-cloud-ai-service.jar
ADD config.yml /opt/ai/config.yml
WORKDIR /opt/ai
ENTRYPOINT ["/usr/bin/java","-jar","nuxeo-cloud-ai-service.jar"]
CMD ["server", "config.yml"]