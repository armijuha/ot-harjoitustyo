## Lämmitysmuotolaskuri

Sovellus on suunnattu omakotiasujalle, jolla on mahdollisuus lämmittää taloaan useammalla lämmönlähteellä. Sovelluksen avulla käyttäjä voi laskea edullisimman lämmitysmuodon, eli esim. onko kannattavampaa polttaa puita takassa vai käyttää sähköä.

### Release viikko 5 ja 6
[Viikon 5 release](https://github.com/armijuha/ot-harjoitustyo/releases/tag/viikko5)
[Viikon 6 release](https://github.com/armijuha/ot-harjoitustyo/releases/tag/viikko6)

### Dokumentaatio

[Arkkitehtuuri](https://github.com/armijuha/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Vaatimusmäärittely](https://github.com/armijuha/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Käyttöohje](https://github.com/armijuha/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Työaikakirjanpito](https://github.com/armijuha/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

### Komentorivitoiminnot

#### Ohjelman suoritus terminaalista

Projektin koodin pystyy suorittamaan komennolla 
> mvn compile exec:java -Dexec.mainClass=fi.lammitysmuotolaskuri.logics.Main

Jar-tiedoston voi luoda komennolla
> mvn package

jolloin saadun tiedoston voi edelleen suorittaa komennolla
> java -jar Lammitysmuotolaskuri-1.0-SNAPSHOT.jar

#### Testaus

Testit suoritetaan komennolla

> mvn test

Testikattavuusraportti luodaan komennolla

> mvn jacoco:report

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto target/site/jacoco/index.html

#### Checkstyle

Checkstyle tarkastelun voi suorittaa komennolla
> mvn jxr:jxr checkstyle:checkstyle

#### JavaDoc

JavaDoc voidaan generoida komennolla
> mvn javadoc:javadoc
