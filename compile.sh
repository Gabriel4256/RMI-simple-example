#! /bin/sh
# JAVA_HOME=/opt/java/jdk-11.0.8/
JAVA_HOME=$1
DST="${PWD}/out"

echo "##############################"
echo "# Compile Start...  "
echo "##############################"
echo "Script executed from: ${PWD}"
# PWD=`pwd` 

$JAVA_HOME/bin/javac -d $DST $PWD/interface/rdate/*.java
$JAVA_HOME/bin/javac -classpath $DST/:. -d $DST ${PWD}/server/*.java
$JAVA_HOME/bin/javac -classpath $DST/ -d $DST ${PWD}/client/*.java
cp server.policy $DST

# for DIR_NAME in `find ./ -type d`
# do
#     if [ -d ${DIR_NAME} ]
#     then
#         $JAVA_HOME/bin/javac -d ${DST} ${PWD}/${DIR_NAME}/*.java  
#     fi
# done

echo "##############################"
echo "# Compile Done.  "
echo "##############################"