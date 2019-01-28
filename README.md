# Members
CRUD rest application for working with Members. Application has no UI, only REST API for requests.

Technologies: Spring Boot, MVC, Security, MongoDB, Docker, Swagger, Maven

Member entity:
- Id
- First Name
- Last Name
- Date of Birth
- Postal Code
- Picture

Swagger
* Use /swagger-ui.html to get REST API info.

Docker
* Use "docker build -t members ." command for building app, based on Dockerfile
* Use "docker run --env mongo_uri=mongodb://localhost:27017/TestDB --network="host" members" command to run app, 
with environment variable for connection to mongo db. Use your host, port and db name. 
Default value of uri (if it will be no 'mongo_uri' env variable when app starts) - "mongodb://localhost:27017/TestDB".
Command '--network="host"' for possible connection from docker outside with the mongodb.

Spring Security
* App uses inMemoryAuthentication with Basic Auth user: username=test_user, password=qwerty123, role=ROLE_USER

#Possible improvements
* Picture is saved like a simple base64 String. There are different ways how to save picture: 
1) It could be link to file, which saved locally;
2) It could be link to file, which saved in some data storage (getting by api);
3) It could be Id of file, which saved in some data storage (getting by api);
4) It could be Base64 type saved in DB, with convertation to file while getting on UI.
5) It could be another table of files with columns: Id - ObjectId, Data - String. 
  And Member table will have foreign key for this picture table.

* There are no tests in app. There should be added:
1) JUnit\Mockito unit testing for basic methods;
2) Integration tests for testing security.

* MongoDB running locally. It could be added like another container to Docker. But sometimes it's not best practice.
* Only entity object exists. For web apps it will be good to have entity and it's dto object for working with UI part.


