# Arkkitehtuurikuvaus

## Rakenne
Ohjelmassa on kolmitasoinen kerrosarkkitehtuuri alla näkyvällä pakkausrakenteella:

![](http://yuml.me/673fd24f.jpg)

## Käyttöliittymä
Tekstipohjainen käyttöliittymä ainakin toistaiseksi. Käyttöliittymä on erotettu sovelluslogiikasta ja kutsuu käyttäjän antamilla parametreillä sovelluslogiikan toteuttavien luokkien metodeja.

## Sovelluslogiikka 
Sovelluslogiikka muodostuu luokista User, ElectricHeating, Firewood, Oil ja AirHeatPump. Luokkaa User tarvitaan vain pysyväistalletuksen yhteydessä, joten jos käyttäjä ei halua pysyväistallentaa tai ladata tietojaan tietokantaan sitä ei käytetä. Muut sovelluslogiikan luokat vastaavat nimensä mukaisen lämmitysenergialähteen hinnan laskennasta ja siihen liittyvistä tiedoista. Alla ohjelman osien suhdetta kuvaava luokkakaavio.

![Alt Text](https://yuml.me/6da124cd.jpg)

## Tietojen pysyväistallennus
Luokka UserDao hoitaa tietojen tallennuksen tietokantaan. Koska luokka noudattaa Data Access Object -suunnittelumallia, voidaan se korvata toisella toteutuksella mikäki datan tallennustapaa tarvitsee vaihtaa.
Sovellus käyttää tietokantaa nimeltä Lammitysmuototietokanta, jonka rakenne voidaan nähdä tietokannan muodostavasta SQL käskystä alla: 
> CREATE TABLE Lammitysmuoto (id serial, name varchar(255), electricprice numeric(9,4), electrictransferprice numeric(9,4), woodprice numeric(9,4), woodefficiency numeric(9,4), woodenergycontent numeric(9,4), oilprice numeric(9,4), oilefficiency numeric(9,4), oilenergycontent numeric(9,4), pumpefficiency numeric (9,4));"

## Päätoiminnallisuudet
### Sekvenssikaavio
![](https://github.com/armijuha/ot-harjoitustyo/blob/master/dokumentaatio/sekvenssi%201.png)
