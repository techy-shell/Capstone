#!/usr/bin/env bash

# This tags and uploads an image to Docker Hub

# Step 1:
dockerpath=techyshell/capstone
echo "Docker ID and Image: $dockerpath"

# Step 2
kubectl run project --image=$dockerpath --port=80

# Step 3:
kubectl get pods

# Step 4:
sleep 60
kubectl port-forward project 8000:80

