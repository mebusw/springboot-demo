# SpringBoot Demo

![](https://travis-ci.org/mebusw/springboot-demo.svg?branch=master)

This is an sample starter project with:
* SpringBoot as framework
* FreeMarker as frontend templates
* Jackson as json parser
* Ebean as ORM
* H2 as database engine

# Installations

Install H2 database:

    brew install h2

Start up H2 (no need for embedded mode, only if you use server mode):

    h2

Download the code and run tests:

    mvn test

Start the web application and view <http://localhost:8080>:

    mvn spring-boot:run

Only to manage H2 database, start H2 in console and change it to `server` mode which supports multiple connections:

    h2


# Tips

1. All of your application components (@Component, @Service, @Repository, @Controller etc.) will be automatically registered as Spring Beans.
2. You need to press Ctrl/Cmd+F9 to compile the classes first before refresh the display when `springloaded` enabled.
