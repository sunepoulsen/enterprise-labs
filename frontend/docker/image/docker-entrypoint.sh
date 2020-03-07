#!/bin/bash
set -e

#cp /usr/local/apache2/htdocs/js/app.js.tmp /usr/local/apache2/htdocs/js/app.js
#cp /usr/local/apache2/htdocs/js/app.js.map.tmp /usr/local/apache2/htdocs/js/app.js.map

# Update registrering backend host:port
#sed -i s/"registrering-backend-route-osm2.ocpt.ccta.dk"/${REGISTRERING_BACKEND_URL:-"localhost:8080"}/g /usr/local/apache2/htdocs/js/app.js
#sed -i s/"registrering-backend-route-osm2.ocpt.ccta.dk"/${REGISTRERING_BACKEND_URL:-"localhost:8080"}/g /usr/local/apache2/htdocs/js/app.js.map

# Update authentication backend host:port
#sed -i s/"authentication-backend-route-osm2.ocpt.ccta.dk"/${AUTHENTICATION_BACKEND_URL:-"localhost:8080"}/g /usr/local/apache2/htdocs/js/app.js
#sed -i s/"authentication-backend-route-osm2.ocpt.ccta.dk"/${AUTHENTICATION_BACKEND_URL:-"localhost:8080"}/g /usr/local/apache2/htdocs/js/app.js.map

exec "$@"