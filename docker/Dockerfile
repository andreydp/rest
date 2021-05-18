FROM tomcat:8.0.51-jre8-alpine
LABEL maintainer="rest_maintainer@gmmail.com"
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ROOT.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh","run"]
