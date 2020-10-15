#! /bin/sh

# JAVA_HOME=/opt/java/jdk-11.0.8/
JAVA_HOME=$1/bin/
if [ -z "$1" ]
 then
    JAVA_HOME=""
fi
echo "##############################"
echo "# Starting rmiregistry  "
echo "##############################"
${JAVA_HOME}rmiregistry -J-Djava.rmi.server.codebase=file:${PWD} 2001 &
echo "##############################"
echo "# Starting rmi server"
echo "##############################"
${JAVA_HOME}java -Djava.security.policy=server.policy -Djava.rmi.server.codebase=file:${PWD} server.DateServer