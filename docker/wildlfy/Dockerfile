FROM h2m/rp3-java

MAINTAINER Heinz Marti <raspberry@h2m.ch>

ENV WILDFLY_VERSION 10.1.0.Final
ENV JBOSS_HOME /opt/jboss/wildfly
# Ensure signals are forwarded to the JVM process correctly for graceful shutdown
ENV LAUNCH_JBOSS_IN_BACKGROUND true

# Add the WildFly distribution to /opt, and make wildfly the owner of the extracted tar content
# Make sure the distribution is available from a well-known place
RUN cd $HOME \
    && wget https://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz \
    && tar xf wildfly-$WILDFLY_VERSION.tar.gz
 
RUN cd $HOME \
    && mkdir -p $JBOSS_HOME \
    && mv $HOME/wildfly-$WILDFLY_VERSION/* $JBOSS_HOME \
    && rm wildfly-$WILDFLY_VERSION.tar.gz

RUN /opt/jboss/wildfly/bin/add-user.sh admin raspberry --silent

EXPOSE 8080 9990

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-c", "standalone-full.xml", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]


