### 使用Docker 提供的Java镜像
FROM java
### 作者信息：用户名 + 邮箱
MAINTAINER "hwy"huangwenyi10@163.com
### 拷贝文件并且重命名为app.jar
ADD spring-boot-docker-0.0.1.jar app.jar
### 将8080端口设置为可暴露的接口
EXPOSE 8080
### 使用java -jar启动项目
CMD java -jar app.jar
