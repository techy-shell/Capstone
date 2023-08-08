#!/usr/bin/env bash

dockerpath=techyshell/project4
docker tag techyshell/project4 techyshell/project4:v1.0.0
echo "Docker ID and Image: $dockerpath"
docker images
docker login
docker tag techyshell/project4 techyshell/project4:v1.0.0
docker push techyshell/project4:v1.0.0