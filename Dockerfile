FROM openjdk:8-jdk-alpine

LABEL mentainer="baisongxx@gmail.com"

COPY lineage-dist/dist/flink-sql-lineage-1.0.0.tgz /opt/workspace/

RUN cd /opt/workspace && \
    tar -xvzf flink-sql-lineage-1.0.0.tgz && \
    chmod +x flink-sql-lineage-1.0.0/sbin/*.sh

WORKDIR /opt/workspace/flink-sql-lineage-1.0.0

EXPOSE 8194

# add `tail -f /dev/null` to keep the container from exiting
ENTRYPOINT ["/bin/sh", "-c", "sbin/start.sh && tail -f /dev/null"]
