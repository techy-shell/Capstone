#!/usr/bin/env bash

docker build . -t techyshell/capstone

docker image ls

docker run -p 8000:80 techyshell/capstone
