#!/bin/sh

ssh ec2-user@172.31.22.130 "cd /home/ec2-user/gs-spring-boot/complete/; git pull origin master; ./gradlew test --rerun-tasks --stacktrace; ./gradlew bootRun"
