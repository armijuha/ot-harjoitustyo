# Arkkitehtuurikuvaus

## Rakenne
Ohjelmassa on kolmitasoinen kerrosarkkitehtuuri alla näkyvällä pakkausrakenteella:

## Käyttöliittymä
Tekstipohjainen käyttöliittymä ainakin toistaiseksi. Käyttöliittymä on erotettu sovelluslogiikasta ja kutsuu käyttäjän antamilla parametreillä sovelluslogiikan toteuttavien luokkien metodeja.

## Sovelluslogiikka 
Sovelluslogiikka muodostuu luokista User, ElectricHeating, Firewood, Oil ja AirHeatPump. Alla ohjelman osien suhdetta kuvaava luokkakaavio.
![Alt Text](https://yuml.me/6da124cd.jpg)

### Sekvenssikaavio
![](https://www.websequencediagrams.com/?png=msc761947722)
