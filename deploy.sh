#!/bin/sh
PROJECT=$1
PROFILE=$2
SHOWLOG=$3""
echo '部署项目[ '${PROJECT}' ], 环境 '${PROFILE}
mvn clean package -Dmaven.test.skip=true
ps aux | grep ${PROJECT}/target | awk '{print $2}' >> ${PROJECT}/tmp
cat ${PROJECT}/tmp | head -2 | xargs kill -9
cat ${PROJECT}/tmp | head -1 | xargs kill -9
rm ${PROJECT}/tmp

if [ ${PROJECT}"/target/${PROJECT}-0.0.1-SNAPSHOT.jar" ]; then
	if [ ! -d ${PROJECT}"/logs" ]; then
		mkdir ${PROJECT}"/logs"
	fi
	if [ -f ${PROJECT}"/logs/nohup.out" ]; then
		rm ${PROJECT}"/logs/nohup.out"
	fi
	touch ${PROJECT}"/logs/nohup.out"
	echo '启动中...'
	nohup java -jar ${PROJECT}/target/${PROJECT}-0.0.1-SNAPSHOT.jar --spring.profiles.active=${PROFILE} >> ${PROJECT}/logs/nohup.out &    
	if [ $SHOWLOG"" == "showlog" ]; then
		tail -f ${PROJECT}/logs/nohup.out
	else
	    echo '启动日志 '${PROJECT}'/logs/nohup.out'
	fi
fi
echo '部署完成.项目[ '${PROJECT}' ], 环境 '${PROFILE}
