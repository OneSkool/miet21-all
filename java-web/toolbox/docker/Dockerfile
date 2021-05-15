# Dockerfile to compile, build and run gradle project without any local installation
ARG JDK_VERSION=${JDK_VERSION:-15}

FROM amazoncorretto:${JDK_VERSION}-alpine
RUN apk add curl

RUN set -x && \
    addgroup -g 1000 appuser && \
    adduser -u 1000 -D -G appuser appuser


COPY ./build/libs/*.jar /app/webapp.jar
WORKDIR /app
USER appuser
EXPOSE 8080
RUN alias ll='ls -ltr'

ENTRYPOINT ["/bin/sh","-c"]

CMD ["java -jar webapp.jar"]