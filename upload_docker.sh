#!/usr/bin/env bash

dockerpath=techyshell/capstone
docker tag techyshell/capstone techyshell/capstone.v1
echo "Docker ID and Image: $dockerpath"
docker images
docker login
docker tag techyshell/capstone techyshell/capstone
docker push techyshell/capstone