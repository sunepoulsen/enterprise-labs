FROM openjdk:11-jdk-oracle
MAINTAINER Sune Thomas Poulsen <sunepoulsen@gmail.com>

ENV JAVA_OPTS              ""
ENV TIME_ZONE              Europe/Copenhagen
ENV JAR_FILENAME           ""

ENV WIREMOCK_OPTS          ""
ENV WIREMOCK_DOWNLOAD_URL  https://repo1.maven.org/maven2/com/github/tomakehurst/wiremock-standalone/2.8.0/wiremock-standalone-2.8.0.jar
ENV WIREMOCK_FILENAME wiremock-standalone-2.8.0.jar

RUN echo "$TIME_ZONE" > /etc/timezone
#RUN dpkg-reconfigure -f noninteractive tzdata

RUN yum install wget -y
RUN mkdir -p /opt/app/config && chmod -R ugo+rw /opt/app && wget -O /opt/app/$WIREMOCK_FILENAME $WIREMOCK_DOWNLOAD_URL

WORKDIR /opt/app

EXPOSE 8080 8000

CMD java -jar $JAVA_OPTS /opt/app/$WIREMOCK_FILENAME --port 8080 --root-dir /opt/app/config $WIREMOCK_OPTS
