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
CONF_FILE=${DEPLOY_DIR}/conf/application-prod.properties
LOG_FILE=${DEPLOY_DIR}/conf/logback-spring.xml

# , spring.config.location vs spring.config.additional-location
SPRING_BOOT_OPTS="${SPRING_BOOT_OPTS} --spring.config.additional-location=${CONF_FILE}"
SPRING_BOOT_OPTS="${SPRING_BOOT_OPTS} --logging.config=${LOG_FILE}"

RUN_JAR=$(ls -t "${DEPLOY_DIR}"/lineage-server/*.jar |head -n 1)
echo "Starting the $APP_NAME ..."

# shellcheck disable=SC2086
nohup java -Xmx2g -Xms2g -jar "$RUN_JAR" $SPRING_BOOT_OPTS &> "$JAVA_OUT" & echo $! > "$PID_FILE"

sleep 3

printf "\n\n"
echo "Please check the std_out files: $JAVA_OUT"
echo "Please check the log files: $LOG_FILE"
printf "\n"