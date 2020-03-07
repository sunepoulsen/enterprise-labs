#!/bin/bash

echo "Build application for production"

cd ../.. || exit

yarn install || exit
yarn build || exit

cd - || exit

echo "Synchonizing files"

rsync -a -v docker-entrypoint.sh build/ || exit
rsync -a -v Dockerfile build/ || exit
rsync -a -v ../../dist build || exit

echo "Build docker image"

docker build -t tech-enterprise-labs-web:latest build || exit
