# Members
CRUD rest application for working with Members. Application has no UI, only REST API for requests.

Technologies: Java 1.8, Spring Boot, MVC, Security, MongoDB, Docker, Swagger, Maven

Member entity:
- Id
- First Name
- Last Name
- Date of Birth
- Postal Code
- Picture (saving by GridFSTemplate with creating ObjectId)

Swagger
* Use /swagger-ui.html to get REST API info.

Docker
* Use "docker build -t members ." command for building app image, based on Dockerfile. Write your own spring.data.mongodb.uri parameter in Dockerfile for connection to db.
* Use "docker run -v /home/admin/usr/images:/images --network="host" members" command to run app container.
Command '--network="host"' for possible connection from docker outside with the mongodb.
Write your own absolute local directory with images '/home/admin/usr/images' for writing picturePath in query like a '/images/photo1.png' andsaving picture to db.

Spring Security
* App uses inMemoryAuthentication with Basic Auth user: username=test_user, password=qwerty123, role=ROLE_USER

#Possible improvements
* There are no tests in app. There should be added:
1) JUnit\Mockito unit testing for basic methods;
2) Integration tests for testing security.

* MongoDB running locally. It could be added like another container to Docker. But sometimes it's not best practice.


