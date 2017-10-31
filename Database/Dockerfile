FROM mysql/mysql-server:latest

ENV MYSQL_RANDOM_ROOT_PASSWORD yes
ENV MYSQL_ONETIME_PASSWORD yes
ENV MYSQL_ROOT_HOST %

ADD ./CreateThirdMealDB.sql /docker-entrypoint-initdb.d/CreateThirdMealDB.sql