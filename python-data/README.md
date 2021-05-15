# Build and Run app in container

## Installation
Install Desktop version for your OS from here
https://www.docker.com/get-started

# Build an image and name it 'pyapp'
docker build -t pyapp:v1 . 

# Run a container using 'pyapp' image. If you don't use --rm flag, container will be saved and can be used again
docker run --rm -it pyapp:v1

# Useful commands
## List all containers
docker ps -a 

## Delete a container
docker rm <containerId | containername>

## List all images
docker images

## Delete an image
docker rmi <image id>

## Learn more
https://www.docker.com/play-with-docker

https://docker-curriculum.com/
https://www.youtube.com/watch?v=fqMOX6JJhGo

