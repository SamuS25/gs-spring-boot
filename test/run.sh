#!/bin/sh
cd $(dirname $0)

cd ../complete

./gradlew check
ret=$?
if [ $ret -ne 0 ]; then
    exit $ret
fi

./gradlew test --rerun-tasks --stacktrace
ret=$?
if [ $ret -ne 0 ]; then
    exit $ret
fi
rm -rf build

ssh ec2-user@172.31.22.130 "cd /home/ec2-user/gs-spring-boot/complete/; git pull origin master; ./gradlew test --rerun-tasks --stacktrace; ./gradlew bootRun"

exit
