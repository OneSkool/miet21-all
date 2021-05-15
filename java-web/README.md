# Application Setup

This application use Java as primary language of development but you can always add any JVM based
language to the mix by adding dependencies to the Gradle build file.

# Build & Run Application

On a Mac/Linux system:

```
 $ cd ./java-web
 $ ./gradlew build
 $ ./gradlew bootRun
```

On a Windows system

```
 c:\ cd .\java-web
 c:\ gradlew build
 c:\ gradlew bootRun
```

Verify Application is running

http://localhost:8080/health/ping

# Package and Containerize

## Package application as Fat Jar

A fat jar file that contains an embedded container and all dependencies is the best way to publish our application.
Prefix ./ for linux systems to following commands to be executed from project root.

Build fat jar

```
gradlew bootJar
```

Build a Docker image

```
docker build -f toolbox/docker/Dockerfile -t java-web .
```

Run container. Use -rm flag to remove container after it is stopped.

```
docker run -rm --name appcontainer -p 8080:8080 -p 27017:27017 -i java-web:latest
```

> validate

```
http://localhost:8080/health/ping
```

# Useful Containers Commands

## Stop/Start a running container

```
docker stop appcontainer
docker start appcontainer
```

## Delete Container

Delete container. Stop container first or use -f flag to force it.

```
docker rm -f appcontainer
```

Delete all orphaned containers and images. They can accumulate due to partial or failed builds and eat resources
(For Linux/Mac, Bash shell ONLY. Not tested on Windows.)

```
docker ps -a -q | xargs -n 1 -I {} docker rm {}

docker rmi $( docker images | grep '<none>' | tr -s ' ' | cut -d ' ' -f 3)
```
