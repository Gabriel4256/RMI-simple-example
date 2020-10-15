#! /bin/sh

# JAVA_HOME=/opt/java/jdk-11.0.8/
JAVA_HOME=$1
echo "##############################"
echo "# Starting rmiregistry  "
echo "##############################"
$JAVA_HOME/bin/rmiregistry -J-Djava.rmi.server.codebase=file:${PWD}
echo "##############################"
echo "# Starting rmi server"
echo "##############################"
$JAVA_HOME/bin/java -Djava.security.policy=server.policy -Djava.rmi.server.codebase=file:${PWD} server.DateServer