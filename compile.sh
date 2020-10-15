#! /bin/sh
# JAVA_HOME=/opt/java/jdk-11.0.8/
JAVA_HOME=$1/bin/
if [ -z "$1" ]
 then
    JAVA_HOME=""
fi
DST="${PWD}/out"

echo "##############################"
echo "# Compile Start...  "
echo "##############################"
echo "Script executed from: ${JAVA_HOME}"

${JAVA_HOME}javac -d $DST $PWD/interface/rdate/*.java
${JAVA_HOME}javac -classpath $DST/:. -d $DST ${PWD}/server/*.java
${JAVA_HOME}javac -classpath $DST/ -d $DST ${PWD}/client/*.java
cp server.policy $DST

echo "##############################"
echo "# Compile Done.  "
echo "##############################"