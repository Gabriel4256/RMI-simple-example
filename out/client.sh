#! /bin/sh
JAVA_HOME=$3/bin/
if [ -z "$3" ]
 then
    JAVA_HOME=""
fi
${JAVA_HOME}java -Djava.security.policy=client.policy  client.DateClient $1 $2