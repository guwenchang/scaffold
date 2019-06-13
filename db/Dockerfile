FROM mysql:5.7

MAINTAINER guwenchang

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

COPY ./db/1schema.sql /docker-entrypoint-initdb.d

COPY ./db/2scaffold.sql /docker-entrypoint-initdb.d
