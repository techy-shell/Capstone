#!/usr/bin/env bash

docker build . -t techyshell/project4

docker image ls

docker run -p 8000:80 techyshell/project4
