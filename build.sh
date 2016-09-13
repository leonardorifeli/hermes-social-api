#!/bin/bash

cd ~/projects/hermes-social-api
mvn clean install
cd ~/projects/hermes-social-api/api-public
mvn tomcat7:run

