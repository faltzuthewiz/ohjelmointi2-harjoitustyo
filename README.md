# Ohjelmointi2 practice project


Tämä Git-repositorio sisältää valmiin Eclipse-projektin, jota voit käyttää Java-kielisen web-sovelluksen pohjana. Projekti on tarkoitettu pohjaksi verkkosovellusten koodaamiseen Haaga-Helian Ohjelmointi 2 -opintojaksolla. 

Projektissa hyödynnetään Javan Servlet- sekä JSP-teknologioita yhdessä [Apachen Tomcat](http://tomcat.apache.org/) -sovelluspalvelimen kanssa. Projekti sisältää valmiit asetustiedostot sen tuomiseksi Eclipse-sovelluskehittimeen, mutta voit käyttää sitä soveltaen myös muilla kehitystyökaluilla, kuten [VS Code](https://code.visualstudio.com/) tai [IntelliJ IDEA](https://www.jetbrains.com/idea/).


## Files in the project

The project has following directory structure:

```tree
embedded-tomcat
│   pom.xml
│   README.md
│
├───src
│   ├───main
│   │   ├───java
│   │   │   ├───launch
│   │   │   │       Main.java
│   │   │   │
│   │   │   └───servlet
│   │   │           IndexServlet.java
│   │   │
│   │   ├───resources
│   │   └───webapp
│   │       ├───styles
│   │       │       demo.css
│   │       │
│   │       └───WEB-INF
│   │               index.jsp
│   │
│   └───test
│       ├───java
│       │   ├───servlet
│       │   │       IndexServletTest.java
│       │   │
│       │   └───testserver
│       │           TestServer.java
│       │
│       └───resources
```



Location                                | Usage
----------------------------------------|---------------------
[README.md](README.md)                                                  | This file
[pom.xml](pom.xml)                                                      | "[Project Object Model](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)" file for eq. to define dependencies
[src/main/java](src/main/java)                                          | Java-pakettien juurihakemisto
[src/main/resources](src/main/resources)                                | Hakemisto esimerkiksi .properties-tiedostoille
[src/main/java/launch/Main.java](src/main/java/launch/Main.java)        | Luokka Tomcat-palvelimen käynnistämiseksi
[src/main/java/servlet/IndexServlet.java](src/main/java/servlet/IndexServlet.java) | Esimerkki HTTP-liikennettä tukevasta Java-luokasta
[src/main/webapp](src/main/webapp)                                      | Hakemisto staattisille tiedostoille (css, kuvat, JS)
[src/main/webapp/WEB-INF](src/main/webapp/WEB-INF)                      | Erityinen hakemisto, jonne on estetty suora pääsy selaimilta ¹
[src/main/webapp/WEB-INF/index.jsp](src/main/webapp/WEB-INF/index.jsp)  | IndexServlet-luokan käyttämä sivupohja
[src/test/java](src/test/java)                                          | JUnit-testiluokkien pakettien juurihakemisto
[src/test/java/servlet/IndexServletTest.java](src/test/java/servlet/IndexServletTest.java)  | IndexServlet-luokan JUnit-testit
[src/test/java/testserver/TestServer.java](src/test/java/testserver/TestServer.java)  | Apuluokka palvelimen testaamiseksi
[src/test/resources](src/test/resources)                                | Hakemisto esimerkiksi testien .properties-tiedostoille

¹ "No file contained in the WEB-INF directory may be served directly to a client by the container. However, the contents of the WEB-INF directory are visible to servlet code..." [Java Servlet Specification Version 2.4](http://download.oracle.com/otn-pub/jcp/servlet-2.4-fr-spec-oth-JSpec/servlet-2_4-fr-spec.pdf)



## Riippuvuuksien asentaminen

Servlet-pohjaiset sovellukset tarvitsevat aina jonkin suoritusympäristön, joka tällä esimerkkiprojektilla on nimeltään [Tomcat](http://tomcat.apache.org/). Tomcat ja muut sovelluksen riippuvuudet on suoraviivaista määrittää projektin pom.xml-tiedostoon, jolloin Eclipsen Maven-plugin asentaa riippuvuudet automaattisesti.

Kun riippuvuudet on asennettu, on Tomcat-palvelinohjelmisto käytettävissä projektissasi ja voit ryhtyä kehittämään verkkosovelluksia Javalla.

*Tämän projektin `pom.xml` on rakennettu noudattaen Heroku-pilvialustan esimerkkiä ["Create a Java Web Application Using Embedded Tomcat"](https://devcenter.heroku.com/articles/create-a-java-web-application-using-embedded-tomcat).*


## Palvelinohjelmiston käynnistäminen

Tomcat-palvelin voidaan käynnistää lukuisilla eri tavoilla, esimerkiksi erillisenä ohjelmana tai Eclipsen hallinnoimana palvelimena. Voimme käyttää sitä myös ohjelmallisesti, eli kirjoittamalla tavallista Java-koodia.

Tämä yksinkertaistettu esimerkki näyttää, miten uusi Tomcat-olio luodaan, miten sen käyttämä portti määritellään ja miten palvelin käynnistetään odottamaan HTTP-pyyntöjä:

```java
import org.apache.catalina.startup.Tomcat;

public class Main {

    public static void main(String[] args) throws Exception {

        // Luodaan uusi palvelinolio:
        Tomcat tomcat = new Tomcat();

        // Asetetaan kuunneltava portti (http://localhost:8080)
        tomcat.setPort(8080);

        // ...muiden asetusten määrittely...

        // Palvelimen käynnistäminen:
        tomcat.start();
        tomcat.getServer().await();
    }
}
```

## Main.java-tiedosto

Tässä projektissa Tomcatin käynnistämiseksi ja sen asetusten asettamiseksi tarvittavat komennot on kirjoitettu valmiiksi tiedostoon [`src/main/java/launch/Main.java`](src/main/java/launch/Main.java). Voit käynnistää Tomcat-palvelimen suorittamalla tämän tiedoston aivan kuten olet tähänkin asti suorittanut Java-ohjelmiasi Eclipsessä.

Ohjelman suoritus tulostaa lokitietoja Eclipsen konsoliin, ja onnistunut käynnistys näyttää pääpiirteittäin tältä:

```log
configuring app with basedir: C:\workspace\embedded-tomcat\.\src\main\webapp
tammik. 28, 2020 10:13:05 AP. org.apache.coyote.AbstractProtocol init
INFO: Initializing ProtocolHandler ["http-nio-8080"]
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
INFO: Starting ProtocolHandler ["http-nio-8080"]
```

Voit nyt navigoida selaimellasi osoitteeseen [http://localhost:8080](http://localhost:8080)! Mikäli kaikki toimii, näet sivun joka näyttää tältä:

### Staattiset tiedostot

Edellä esitellyssä sivupohjassa hyödynnetään ulkoista CSS-tiedostoa:

```html
<link rel="stylesheet" href="/styles/demo.css">
```

Tämä tiedosto sijaitsee projektin hakemistossa `src/main/webapp`, jonka alla olevat tiedostot tarjotaan selaimelle staattisina tiedostoina (poikkeuksena `WEB-INF`).

Selaimen pyytäessä osoitetta http://localhost:8080/styles/demo.css Tomcat tarjoaa vastauksesi CSS-tiedostomme. Vastaavalla tavalla voisimme asettaa saataville myös kuvat ja JavaScript-tiedostot sijoittamalla ne `src/main/webapp` hakemiston alle.



---

Tämän oppimateriaalin on kehittänyt Teemu Havulinna ja se on lisensoitu [Creative Commons BY-NC-SA](https://creativecommons.org/licenses/by-nc-sa/4.0/) -lisenssillä. 


