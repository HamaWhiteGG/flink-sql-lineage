#!/bin/sh

APP_NAME=lineage-server

cd `dirname $0`
cd ..
DEPLOY_DIR=`pwd`

LOGS_DIR=${DEPLOY_DIR}/logs
if [ ! -d ${LOGS_DIR} ]; then
    mkdir ${LOGS_DIR}
fi
LOG_FILES=${LOGS_DIR}/lineage-server.log

JAVA_OUT=${DEPLOY_DIR}/${APP_NAME}_std_out.log
PID_FILE=${DEPLOY_DIR}/${APP_NAME}.pid

JAVA_OPTS=" -Xmx2g -Xms2g"
RUN_JAR=$(ls -t ${DEPLOY_DIR}/lineage-server/*.jar |head -n 1)
echo "Starting the $SERVER_NAME ..."
nohup java "$JAVA_OPTS" -jar "$RUN_JAR" & > $JAVA_OUT & echo $! > "$PID_FILE"
sleep 5
echo "Please check the log files: $LOG_FILES"