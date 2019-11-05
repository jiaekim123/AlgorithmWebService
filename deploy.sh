#!/bin/bash
APPLICATION="AlgorithmWebService"
REPOSITORY="/home/ec2-user/app/git/$APPLICATION"
FILE_NAME="src/main/resources/application.properties src/test/java/com/algorithm/mySQLConnectionTest.java"

cd $REPOSITORY
echo "Git Pull"
git pull
echo "프로젝트 Build 시작"
sudo ./mvnw clean package

echo "구동 중인 appilcation의 pid 확인"
CURRENT_PID=$(pgrep -f $APPLICATION)

echo "$CURRENT_PID"
if [ -z $CURRENT_PID ]; then
	echo ">현재 구동 중인 어플리케이션이 없으므로 종료하지 않습니다."
else
	echo ">kill -9 $CURRENT_PID"
	sudo kill -9 $CURRENT_PID
fi

echo "파라미터값 수정"
FILE_NAME="src/main/resources/application.properties src/test/java/com/algorithm/mySQLConnectionTest.java"
sed -i "s/@@@DATABASE_USERNAME@@@/$DATABASE_USERNAME/g" $FILE_NAME
sed -i "s/@@@DATABASE_PASSWORD@@@/$DATABASE_PASSWORD/g" $FILE_NAME
sed -i "s/@@@DATABASE_SERVER@@@/$DATABASE_SERVER/g" $FILE_NAME

echo "새 어플리케이션 배포"
JAR_NAME=$(find target -name "*.jar")

echo "spring boot 시작"
sudo nohup java -jar $REPOSITORY/$JAR_NAME &
