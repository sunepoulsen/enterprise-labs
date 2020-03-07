FROM httpd:2.4-alpine

# Change default port as port 80 requires root priviliges
RUN sed -i s/"Listen 80"/"Listen 8080"/g /usr/local/apache2/conf/httpd.conf

# Allow any user to access the logs directory
RUN chmod 777 /usr/local/apache2/logs

COPY docker-entrypoint.sh /usr/local/apache2/

RUN chmod a+x /usr/local/apache2/docker-entrypoint.sh

# Add version properties
# COPY build/version.properties /Manifest/

# Add the application artifact
COPY dist /usr/local/apache2/htdocs/

RUN chmod -R 7777 /usr/local/apache2/htdocs/js
#RUN mv /usr/local/apache2/htdocs/js/app.js /usr/local/apache2/htdocs/js/app.js.tmp
#RUN mv /usr/local/apache2/htdocs/js/app.js.map /usr/local/apache2/htdocs/js/app.js.map.tmp

ENTRYPOINT [ "/usr/local/apache2/docker-entrypoint.sh" ]
CMD [ "httpd-foreground" ]
EXPOSE 8080
