FROM lushan123888/javaee:1.0

MAINTAINER Cian LuShan123888@Gmail.com

EXPOSE 8080
RUN rm -rf  /usr/local/tomcat/webapps/ROOT/*
COPY target/Tally-1.0/ /usr/local/tomcat/webapps/ROOT/
CMD /usr/local/tomcat/bin/catalina.sh run
