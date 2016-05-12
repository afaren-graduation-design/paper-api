#!/usr/bin/env bash

set -eo pipefail
PS4="command: "
set -x

if [ -z $REMOTE_SERVER_IP ]
then
  echo "Please Set the REMOTE_SERVER_IP"
  exit 1
fi

if [ -z $CONFIG_FILE_DIR ]
then
  echo "Please Set the REMOTE_SERVER_IP"
  exit 1
fi

if [ -f $CONFIG_FILE_DIR/gradle.properties ]
then
	echo "Failed with no gradle.properties in $CONFIG_FILE_DIR"
fi

cp $CONFIG_FILE_DIR/config.properties src/main/resources/config.properties
./gradlew clean
./gradlew war
cp paper-api/build/libs/paper-api.war

scp paper-api/build/libs/paper-api.war $REMOTE_SERVER_IP:/home/ubuntu/twars/paper-api