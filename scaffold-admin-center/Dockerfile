FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER 1379864599@qq.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /scaffold-admin-center

WORKDIR /scaffold-admin-center

EXPOSE 10020

ADD ./scaffold-admin-center/target/scaffold-admin-center.jar ./

CMD java -Djava.security.egd=file:/dev/./urandom -jar scaffold-admin-center.jar
