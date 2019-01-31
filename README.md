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
* Use "docker run -v /home/admin/usr/pictures:/pictures --network="host" members" command to run app container.
Command '/-v /home/admin/usr/images:/images' for using local directory '/home/admin/usr/pictures' as container directory '/pictures' in docker. Write your own absolute directory path so you will be able to use '/pictures/photo1.png' as picturePath and saving picture to db.
Command '--network="host"' for possible connection from docker outside with the mongodb.

Spring Security
* App uses inMemoryAuthentication with Basic Auth user: username=test_user, password=qwerty123, role=ROLE_USER
* Use SpringSecurityTest class for testing basic user authentication

#Possible improvements
* There could be added JUnit\Mockito unit testing for basic methods;

* MongoDB running locally. It could be added like another container to Docker. But sometimes it's not best practice.


