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

setsid script.sh

exit
