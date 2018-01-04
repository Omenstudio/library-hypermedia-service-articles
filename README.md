# Articles library web service

Hypermedia-driven Web API that supports Hydra (http://www.hydra-cg.com/), json-ld (http://json-ld.org/) and popular vocabulary http://schema.org/


## Working example

Server runned on (Heroku|https://ya.ru)

API endpoint: https://library-service-articles.herokuapp.com/mega-api/

You can also restart DB by running https://library-service-articles.herokuapp.com/resetdb. It will clean all database tables and add some simple entities.

Server on Heroku shotdowns after 30 minutes of inactivity, so you can open https://library-service-articles.herokuapp.com/iamalive to check if application is running. If app is not running, it will start automatically.


## Getting started
You need locally installed Java 8 SDK, Postgres 9+ (or other DBMS) and Maven 3+.

1. `git clone https://github.com/Omenstudio/library-hypermedia-service-articles.git`
2. `cd library-hypermedia-service-articles/`
3. `mvn install && java -jar target/service-articles-1.0.0.jar`
4. or just `mvn spring-boot:run`

Server will be started at localhost and you can access API.

Project use Spring (Core, Boot, MVC, Data JPA), Hibernate, AspectJ, Json-ld.

To customize application you need to change DB connection and server url in `resources/application.properties`


## See also
- Another hypermedia web API service, which also use Hydra and Json-ld: https://github.com/Omenstudio/library-hypermedia-service-books
- WEB UI application based on HydraConsole, which allow you work with hypermedia services: https://github.com/Omenstudio/hypermedia-library-web-ui

Working application: https://library-service-articles.herokuapp.com/mega-api/
