FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER 1379864599@qq.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /scaffold-log-center

WORKDIR /scaffold-log-center

EXPOSE 10010

ADD ./scaffold-log-center/target/scaffold-log-center.jar ./

CMD java -Djava.security.egd=file:/dev/./urandom -jar scaffold-log-center.jar
