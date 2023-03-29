#!/bin/sh

LOCAL_IP=127.0.0.1

cd $(dirname "$0") || exit
cd .. || exit
DEPLOY_DIR=$(pwd)

echo 'Start maven packaging'
mvn clean package -Pdocker
echo 'Finish maven package'

MYSQL_DATA_DIR=${DEPLOY_DIR}/data/storage/mysql
if [ ! -d "${MYSQL_DATA_DIR}" ]; then
  echo "Created mysql data dir $MYSQL_DATA_DIR"
  mkdir -p "${MYSQL_DATA_DIR}"
fi

echo 'Build, create, and start containers with Docker Compose'
docker-compose up -d

echo 'Lists all container information'
docker-compose ps

printf "\n\nDeployment completed\n"
printf "It takes tens of seconds for the service to start, please wait a moment.\n\n"

printf "Swagger API: http://%s:8194/swagger-ui/index.html\n" "${LOCAL_IP}"
printf "Knife4j API: http://%s:8194/doc.html\n" "${LOCAL_IP}"
printf "Quick Catalog API: http://%s:8194/catalogs/1\n" "${LOCAL_IP}"
printf "Index Page: http://%s:8194/index.html\n" "${LOCAL_IP}"
