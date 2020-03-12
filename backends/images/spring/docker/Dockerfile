FROM openjdk:11-jdk-oracle
MAINTAINER Sune Thomas Poulsen <sunepoulsen@gmail.com>

ENV JAVA_OPTS              ""
ENV TIME_ZONE              Europe/Copenhagen
ENV JAR_FILENAME           ""

RUN echo "$TIME_ZONE" > /etc/timezone
#RUN dpkg-reconfigure -f noninteractive tzdata

WORKDIR /opt/app

EXPOSE 8080 8000
