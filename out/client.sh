#! /bin/sh
JAVA_HOME=$1/bin/
if [ -z "$1" ]
 then
    JAVA_HOME=""
fi
${JAVA_HOME}java -Djava.security.policy=server.policy client.DateClient