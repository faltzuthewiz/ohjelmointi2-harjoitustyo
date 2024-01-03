# Ohjelmointi 2 practice project

This Git repository contains my practice project for Haaga-Helia UAS' 'Ohjelmointi 2 (Programming 2)' course. The project uses Chinook sample database (not contained in this repository, needs to be fetched separately), Java Servlets, JSPs, Maven and [Apache Tomcat](http://tomcat.apache.org/).

The project contains a list of all the artists that is contained in Chinook database. A user can post a new artist to the database by filling up a form. A user can also locate to a list of albums by selected artist by clicking the artist on the project's frontpage. The Main.java class starts the project on [http://localhost:5050](http://localhost:5050) .

## Files in the project

The project has a following directory structure:

```tree
embedded-tomcat
.
|-- README.md
`-- screenshots
    |-- ohjelmointi2-all-artists.PNG
    |-- ohjelmointi2-artistpage.png
|-- lib
|   `-- sqlite-jdbc-3.41.2.1.jar
|-- pom.xml
`-- src
    |-- main
    |   |-- java
    |   |   |-- database
    |   |   |   |-- AlbumDao.java
    |   |   |   |-- ArtistDao.java
    |   |   |   `-- Database.java
    |   |   |-- launch
    |   |   |   `-- Main.java
    |   |   |-- model
    |   |   |   |-- Album.java
    |   |   |   `-- Artist.java
    |   |   `-- servlet
    |   |       |-- AlbumServlet.java
    |   |       `-- ArtistListServlet.java
    |   |-- resources
    |   `-- webapp
    |       |-- WEB-INF
    |       |   |-- albums.jsp
    |       |   `-- artistList.jsp
    |       `-- styles
    `-- test
        |-- java
        |   |-- model
        |   |   |-- AlbumDaoTest.java
        |   |   `-- ArtistDaoTest.java
        |   |-- servlet
        |   `-- testserver
        |       `-- TestServer.java
        `-- resources

```



Location                                | Usage
----------------------------------------|---------------------
[README.md](README.md)                                                  | This file
[pom.xml](pom.xml)                                                      | "[Project Object Model](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)" file for eq. to define dependencies
[src/main/java](src/main/java)                                          | Root directory for Java packages
[src/main/resources](src/main/resources)                                | A directory for eg. .properties files
[src/main/java/launch/Main.java](src/main/java/launch/Main.java)        | A class which starts Tomcat server
[src/main/webapp](src/main/webapp)                                      | Directory for JS (could be used to storage CSS and pictures, too)
[src/main/webapp/WEB-INF](src/main/webapp/WEB-INF)                      | A special directory to which direct access from browsers is blocked ¹
[src/test/java](src/test/java)                                          | A root directory for JUnit test packages
[src/test/java/testserver/TestServer.java](src/test/java/testserver/TestServer.java)  | Helper class for testing the server
[src/test/resources](src/test/resources)                                | A directory for eg. .properties files for tests
[src/main/database/AlbumDao.java](src/main/database/AlbumDao.java)      | A Java class for album-related methods (eg. get all albums from certain artist listed in the database)
[src/main/database/ArtistDao.java](src/main/database/ArtistDao.java)    | A Java class for artist-related methods (eg. get all artists from database)
[src/main/database/Database.java](src/main/database/Database.java)      | A Java class for maintaining database connection
[src/main/model/Album.java](src/main/model/Album.java)                  | Album object
[src/main/model/Artist.java](src/main/model/Artist.java)                | Artist object
[src/main/servlet/AlbumServlet.java](src/main/servlet/AlbumServlet.java) | A servlet that takes the artistId as a request and provides albums based on that id.
[src/main/servlet/ArtistListServlet.java](src/main/servlet/ArtistListServlet.java)   | A servlet that requests all the artist information provided
[src/main/test/java/model/AlbumDaoTest.java](src/main/test/java/model/AlbumDaoTest.java)  | A JUnit test to check if the Album method is working
[src/main/test/java/model/ArtistDaoTest.java](src/main/test/java/model/ArtistDaoTest.java)   | A JUnit test to check if the Artist methods are working 
[src/main/webapp/WEB-INF/albums.jsp](src/main/webapp/WEB-INF/albums.jsp)   | Album.jsp shows a html page with the name and albums of the selected artist
[src/main/webapp/WEB-INF/albums.jsp](src/main/webapp/WEB-INF/albums.jsp)   | Artist.jsp shows a html page with a list of all the artists and a form to add a new artist.

¹ "No file contained in the WEB-INF directory may be served directly to a client by the container. However, the contents of the WEB-INF directory are visible to servlet code..." [Java Servlet Specification Version 2.4](http://download.oracle.com/otn-pub/jcp/servlet-2.4-fr-spec-oth-JSpec/servlet-2_4-fr-spec.pdf)

## Screenshots
![Alt text](https://raw.githubusercontent.com/faltzuthewiz/ohjelmointi2-harjoitustyo/master/screenshots/ohjelmointi2-all-artists.PNG "a form to add a new artist and a numbered list of all artists.")
![Alt text](https://raw.githubusercontent.com/faltzuthewiz/ohjelmointi2-harjoitustyo/master/screenshots/ohjelmointi2-artistpage.png "an example artist page. Shows artist name 'Queen' and three of their albums.")

## Main.java

The project is launched by running Main.java file located in [`src/main/java/launch/Main.java`](src/main/java/launch/Main.java). The project is launched now on [http://localhost:5050](http://localhost:5050) .

Successfull launch looks about this in Eclipse's console: 


```log
configuring app with basedir: C:\workspace\embedded-tomcat\.\src\main\webapp
tammik. 28, 2020 10:13:05 AP. org.apache.coyote.AbstractProtocol init
INFO: Initializing ProtocolHandler ["http-nio-5050"]
tammik. 28, 2020 10:13:05 AP. org.apache.tomcat.util.net.NioSelectorPool getSharedSelector
INFO: Using a shared selector for servlet write/read
tammik. 28, 2020 10:13:05 AP. org.apache.catalina.core.StandardService startInternal
INFO: Starting service [Tomcat]
tammik. 28, 2020 10:13:05 AP. org.apache.catalina.core.StandardEngine startInternal
INFO: Starting Servlet Engine: Apache Tomcat/8.5.50
tammik. 28, 2020 10:13:06 AP. org.apache.catalina.startup.ContextConfig getDefaultWebXmlFragment
INFO: No global web.xml found
tammik. 28, 2020 10:13:06 AP. org.apache.jasper.servlet.TldScanner scanJars
INFO: At least one JAR was scanned for TLDs yet contained no TLDs. Enable debug logging for this logger for a complete list of JARs that were scanned but no TLDs were found in them. Skipping unneeded JARs during scanning can improve startup time and JSP compilation time.
tammik. 28, 2020 10:13:06 AP. org.apache.catalina.util.SessionIdGeneratorBase createSecureRandom
WARNING: Creation of SecureRandom instance for session ID generation using [SHA1PRNG] took [308] milliseconds.
tammik. 28, 2020 10:13:06 AP. org.apache.coyote.AbstractProtocol start
INFO: Starting ProtocolHandler ["http-nio-5050"]
```


### CSS

The following [CSS Framework by yegor256](https://github.com/yegor256/tacit) is used in the project. 

```html
 <link rel="stylesheet" href="tacit-css.min.css"/>
```

---
The original project base is created by Teemu Havulinna and it is licenced under [Creative Commons BY-NC-SA](https://creativecommons.org/licenses/by-nc-sa/4.0/)
