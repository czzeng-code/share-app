#FROM registry.cn-hangzhou.aliyuncs.com/library-bd/openjdk:8-jdk-alpine
## 指定工作目录
#WORKDIR /app
#COPY user-center-0.0.1-SNAPSHOT.jar ./app.jar
## 设置时区为上海
#ENV TZ Asia/Shanghai
## 设置时区为上海
#ENV JAVA_OPS -Duser.timezone=Asia/Shanghai
#EXPOSE 8014
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","./app.jar"]

# Docker image for springboot application
# VERSION 0.0.1
# Author: bolingcavalry

### 基础镜像，使用alpine操作系统，openjkd使用8u201
FROM openjdk:8u201-jdk-alpine3.9

#作者
MAINTAINER czzeng <czeng_ok@qq.com>

#系统编码
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8

#声明一个挂载点，容器内此路径会对应宿主机的某个文件夹
VOLUME /app

#应用构建成功后的jar文件被复制到镜像内，名字也改成了app.jar
COPY user-center-0.0.1-SNAPSHOT.jar ./app.jar


#启动容器时的进程
ENTRYPOINT ["java","-jar","/app.jar"]

#暴露8080端口
EXPOSE 8014