#!/bin/bash

REPOSITORY="/home/ec2-user/app/git/AlgorithmWebService"
FILE_NAME="src/main/resources/application.properties src/test/java/com/algorithm/mySQLConnectionTest.java"
DATABASE_USERNAME="@@USERNAME@@"
DATABASE_PASSWORD="@@PASSWORD@@"
DATABASE_SERVER="@@SERVER@@"

cd $REPOSITORY
echo "> Git Pull"
git pull
echo "> 프로젝트 Build 시작"
sudo ./mvnw clean package

echo "> 파라미터값 수정"
FILE_NAME="src/main/resources/application.properties src/test/java/com/algorithm/mySQLConnectionTest.java"
sed -i "s/@@@DATABASE_USERNAME@@@/$DATABASE_USERNAME/g" $FILE_NAME
sed -i "s/@@@DATABASE_PASSWORD@@@/$DATABASE_PASSWORD/g" $FILE_NAME
sed -i "s/@@@DATABASE_SERVER@@@/$DATABASE_SERVER/g" $FILE_NAME

echo "> spring boot 시작"
sudo nohup ./mvnw spring-boot:run

#cp ./build/libs/*.jar $REPOSITORY/
#echo "> 현재 구동중인 애플리케이션 pid 확인"
#CURRENT_PID=$(pgrep -f springboot-webservice)
#echo "$CURRENT_PID"
#if [ -z $CURRENT_PID ]; then
#    echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
#else
#    echo "> kill -2 $CURRENT_PID"
#    kill -9 $CURRENT_PID
#    sleep 5
#fi
#echo "> 새 어플리케이션 배포"
#JAR_NAME=$(ls $REPOSITORY/ |grep 'springboot-webservice' | tail -n 1)
#echo "> JAR Name: $JAR_NAME"
#nohup java -jar $REPOSITORY/$JAR_NAME &
