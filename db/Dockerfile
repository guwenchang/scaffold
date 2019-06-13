FROM mysql:5.7

MAINTAINER guwenchang

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

COPY ./db/schema.sql /docker-entrypoint-initdb.d

COPY ./db/scaffold.sql /docker-entrypoint-initdb.d
