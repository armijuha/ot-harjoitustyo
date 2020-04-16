## Lämmitysmuotolaskuri

Sovellus on suunnattu omakotiasujalle, jolla on mahdollisuus lämmittää taloaan useammalla lämmönlähteellä. Sovelluksen avulla käyttäjä voi laskea edullisimman lämmitysmuodon, eli esim. onko kannattavampaa polttaa puita takassa vai käyttää sähköä.

### Dokumentaatio

[Arkkitehtuuri](https://github.com/armijuha/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Vaatimusmäärittely](https://github.com/armijuha/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/armijuha/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

### Komentorivitoiminnot

#### Ohjelman suoritus terminaalista

Projektin koodin pystyy suorittamaan komennolla 
> mvn compile exec:java -Dexec.mainClass=fi.lammitysmuotolaskuri.logics.Main

#### Testaus

Testit suoritetaan komennolla

> mvn test

Testikattavuusraportti luodaan komennolla

> mvn jacoco:report

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto target/site/jacoco/index.html
