#! /bin/sh

# JAVA_HOME=/opt/java/jdk-11.0.8/
JAVA_HOME=$3/bin/
HOST_NAME=$1
PORT=$2
# if [ -z "$1" ]
#     then
#         HOST_NAME=127.1.1.0
# fi
if [ -z "$2" ]
    then
        PORT=1109
fi
if [ -z "$3" ]
 then
    JAVA_HOME=""
fi
echo "##############################"
echo "# Starting rmiregistry  "
echo "##############################"
# ${JAVA_HOME}rmiregistry -J-Djava.rmi.server.codebase=file:${PWD} ${PORT} &
${JAVA_HOME}rmiregistry -J-Djava.class.path=${PWD} ${PORT} &

echo "##############################"
echo "# Starting rmi server"
echo "##############################"
${JAVA_HOME}java -Djava.security.policy=server.policy -Djava.rmi.server.codebase=file:${PWD} -Djava.rmi.server.hostname=${HOST_NAME} server.DateServer