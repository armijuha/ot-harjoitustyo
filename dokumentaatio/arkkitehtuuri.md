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

## Päätoiminnallisuudet
### Sekvenssikaavio
![](https://www.websequencediagrams.com/?png=msc761947722)
