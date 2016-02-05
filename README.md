# SpringBoot Demo

This is an sample starter project with:
* SpringBoot as framework
* FreeMarker as frontend template
* Gson as json parser
* Ebean as ORM
* H2 as database engine

# Installations

Install H2 database:

    brew install h2

Download the code and run tests:

    h2
    gradle test

Start the web application and view <http://localhost:8080>:

    gradle bootRun

You can setup classpath properly for IntelliJ:

    gradle idea

# Tips

1. All of your application components (@Component, @Service, @Repository, @Controller etc.) will be automatically registered as Spring Beans.
