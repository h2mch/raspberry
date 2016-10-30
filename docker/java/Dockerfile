FROM resin/raspberrypi3-debian:latest

MAINTAINER Heinz Marti <raspberry@h2m.ch>

ENV DEBIAN_FRONTEND=noninteractive 
ENV JAVA_HOME=/usr/lib/jvm/java-8-oracle 

# Install Java 
RUN     echo "deb http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main" | tee /etc/apt/sources.list.d/webupd8team-java.list && \
        echo "deb-src http://ppa.launchpad.net/webupd8team/java/ubuntu trusty main" | tee -a /etc/apt/sources.list.d/webupd8team-java.list && \
        echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 select true" | debconf-set-selections && \
        apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv-keys EEA14886 && \
        apt-get update && \ 
        apt-get install -y --force-yes --no-install-recommends ca-certificates oracle-java8-installer && \
        apt-get install oracle-java8-set-default && \
        apt-get clean all && \
        rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/* && \
        rm -rf /var/cache/oracle-jdk8-installer

