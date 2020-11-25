#!/usr/bin/env sh
arg=$1
##directory###
dir=target
##jar file##
jar_name=0.0.1-SNAPSHOT.jar

./gradlew clean build && java -jar ./target/0.0.1-SNAPSHOT.jar

if [ -z "$1" ] ; then
      java -jar $dir/$jar_name
      exit 1
else
  java -jar $dir/$jar_name $arg

fi