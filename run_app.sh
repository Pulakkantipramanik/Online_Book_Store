#!/bin/bash
mvn clean package -DskipTests
if [ $? -ne 0 ]; then
  echo "Build failed"
  exit 1
fi
java -jar target/bookstore-0.0.1-SNAPSHOT.jar
