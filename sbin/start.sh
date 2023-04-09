#!/bin/sh

APP_NAME=lineage-server

cd $(dirname "$0") || exit
cd .. || exit
DEPLOY_DIR=$(pwd)

LOGS_DIR=${DEPLOY_DIR}/logs
if [ ! -d "${LOGS_DIR}" ]; then
  mkdir "${LOGS_DIR}"
fi

LOG_FILE=${LOGS_DIR}/lineage-server.log
JAVA_OUT=${DEPLOY_DIR}/${APP_NAME}_std_out.log
PID_FILE=${DEPLOY_DIR}/${APP_NAME}.pid
LOG_CONFIG=${DEPLOY_DIR}/conf/logback-spring.xml

SPRING_CONFIG=$(ls -t "${DEPLOY_DIR}"/conf/*.properties | head -n 1)

# , spring.config.location vs spring.config.additional-location
SPRING_BOOT_OPTS="${SPRING_BOOT_OPTS} --spring.config.additional-location=${SPRING_CONFIG}"
SPRING_BOOT_OPTS="${SPRING_BOOT_OPTS} --logging.config=${LOG_CONFIG}"

RUN_JAR=$(ls -t "${DEPLOY_DIR}"/lineage-server/*.jar | head -n 1)

printf "\n"
echo "Spring config file: $SPRING_CONFIG"
echo "Logback config file: $LOG_CONFIG"
printf "\n"
echo "Starting the $APP_NAME ..."

# shellcheck disable=SC2086
nohup java -Xmx2g -Xms2g -jar "$RUN_JAR" $SPRING_BOOT_OPTS &>"$JAVA_OUT" &
echo $! >"$PID_FILE"

sleep 30

printf "\n\n"
echo "Please check the std_out file: $JAVA_OUT"
echo "Please check the log file: $LOG_FILE"
printf "\n"
