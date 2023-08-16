#!/usr/bin/env bash

docker build -t capstone .
docker run -d -p 8000:8000
docker ps
docker images
