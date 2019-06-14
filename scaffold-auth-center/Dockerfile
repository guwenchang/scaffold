FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER 1379864599@qq.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /scaffold-auth-center

WORKDIR /scaffold-auth-center

EXPOSE 10030

ADD ./scaffold-auth-center/target/scaffold-auth-center.jar ./

CMD java -Djava.security.egd=file:/dev/./urandom -jar scaffold-auth-center.jar
