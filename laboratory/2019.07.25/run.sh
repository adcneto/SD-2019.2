export ZK=~/Documentos/2019.07.25/zookeeper-3.4.14
#echo "ZK=$ZK"
echo "$ZK/zookeeper-3.4.14.jar"
export CP=.:$ZK'/zookeeper-3.4.14.jar':$ZK'/lib/slf4j-log4j12-1.7.25.jar':$ZK'/lib/slf4j-api-1.7.25.jar':$ZK'/lib/log4j-1.2.17.jar'
echo $CP
java -cp $CP -Dlog4j.configuration=file:$ZK/conf/log4j.properties Executor 127.0.0.1 /mcta025/ex4 out.txt ./lista.sh
