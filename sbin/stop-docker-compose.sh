#!/bin/sh

cd $(dirname "$0") || exit
cd .. || exit

echo 'Stop containers'
docker-compose stop
