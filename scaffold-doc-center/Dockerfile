FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER 1379864599@qq.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /scaffold-doc-center

WORKDIR /scaffold-doc-center

EXPOSE 10000

ADD ./scaffold-doc-center/target/scaffold-doc-center.jar ./

CMD java -Djava.security.egd=file:/dev/./urandom -jar scaffold-doc-center.jar
