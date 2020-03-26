#!/usr/bin/env bash

mvn -N install:install-file -Dpackaging=pom -Dfile=../../../pom.xml -DpomFile=../../../pom.xml
mvn -N install:install-file -Dpackaging=pom -Dfile=../../pom.xml -DpomFile=../../pom.xml
mvn -N install:install-file -Dpackaging=pom -Dfile=../pom.xml -DpomFile=../pom.xml
mvn -N install:install-file -Dpackaging=pom -Dfile=pom.xml -DpomFile=pom.xml
mvn -N install:install-file -Dpackaging=pom -Dfile=client/pom.xml -DpomFile=client/pom.xml
mvn -N install:install-file -Dpackaging=pom -Dfile=service/pom.xml -DpomFile=service/pom.xml
