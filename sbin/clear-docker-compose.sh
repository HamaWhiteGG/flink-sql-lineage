#!/bin/sh

cd $(dirname "$0") || exit
cd .. || exit
DEPLOY_DIR=$(pwd)

echo 'Stop containers'
docker-compose stop

echo 'Delete containers'
docker-compose rm -f

echo 'Delete the images containing "lineage-server"'
docker rmi $(docker images | grep lineage-server | awk '{print $3}')

MYSQL_DATA_DIR=${DEPLOY_DIR}/data/storage/mysql

if [ -d "${MYSQL_DATA_DIR}" ]; then
  echo "Delete mysql data dir $MYSQL_DATA_DIR"
  rm -rf "${MYSQL_DATA_DIR}"
fi