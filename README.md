# microserviceApi
Fake microservice Rest Api

Commands to generated trace in Elasric APM

java \
 -javaagent:elastic-apm-agent-1.18.0.RC1.jar\
 -Delastic.apm.service_name=microserviceApi\
 -Delastic.apm.server_urls= <URL OF ELASTIC APM SERVER>
 -Delastic.apm.secret_token= <TOKEN OF ELASTIC APM SERVER> \
 -Delastic.apm.application_packages=br.microserviceapi \
 -jar