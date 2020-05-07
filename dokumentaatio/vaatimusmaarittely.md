# Vaatimusmäärittely


## Sovelluksen tarkoitus

Sovellus on suunnattu omakotiasujalle, jolla on mahdollisuus lämmittää taloaan useammalla lämmönlähteellä.
Sovelluksen avulla käyttäjä voi laskea edullisimman lämmitysmuodon, eli esim. onko tänään kannattavampaa polttaa puita takassa vai käyttää sähköä. Tai tuleeko kevään 2020 hinnoilla kenties halvimmaksi polttaa öljyä?

## Käyttäjät

Sovelluksella on ainoastaan yksi käyttäjärooli eli normaali käyttäjä. Suuremmilla oikeuksilla varustetun pääkäyttäjän lisääminen on mahdollista myöhemmin, mikäli se koetaan tarpeelliseksi.

## Perusversion tarjoama toiminnallisuus

### Ennen kirjautumista

* Laskurin kaikki toiminnallisuus poislukien omien tietojen tallennus ja lataus on heti käytössä ilman kirjautumista.
* Käyttäjä voi syöttää oman sähköenergiansa sekä siirron tämänhetkisen hinnan per kWh.
* Käyttäjä voi syöttää oman öljynsä hinnan per litra sekä öljyn lämpöarvon ja polttamisen hyötysuhteen.
* Käyttäjä voi syöttää oman polttopuunsa lämpöarvon ja hinnan per heittokuutio sekä takan hyötysuhteen.
* Käyttäjä voi syöttää ilmalämpöpumpun hyötysuhteen.
* Kayttäjä voi luoda järjestelmään käyttäjätunnuksen joka täytyy olla uniikki ja 1-100 merkkiä pitkä.
* Käyttäjä voi käyttäjätunnuksen avulla tallentaa ja ladata tietonsa tietokantaan. Järjestelmä ilmoittaa jos käyttäjää ei ole olemassa.
* Ohjelma ei missään tilanteessa voi kaatua käyttäjän virheellisiin syötteisiin vaan ne kaikki käsitellään ja ohjeistetaan käyttäjää.

### Kirjautumisen jälkeen

* Käyttäjä näkee oman sähkönsä, öljynsä ja polttopuunsa hinnan tietokantaan tallentamiensa tietojen perusteella.
* Järjestelmä antaa suosituksen edullisimmasta lämmitysmuodosta perustuen näiden hintaeroon.

## Jatkokehitysideoita

Järjestelmää voidaan jatkossa täydentää ao. ominaisuuksilla.
* Salasanan lisäys onnistuisi melko helposti. Toisaalta käyttäjä voi jo nyt valita hyvin monimutkaisen käyttäjätunnuksen jota on vaikea arvata.
* Lämpöarvot eri puulajeille voisivat olla järjestelmässä valmiina, jolloin valittaisiin esim. koivu tai kuusi.
* Pörssisähköä käyttäville olisi hieno ominaisuus hakea sähkön hetkellinen hinta automaattisesti, esiselvityksen perusteella toteutus saattaisi onnistua Fingridin tarjoaman avoimen datan avulla.
* Ilmalämpöpumpun hyötysuhteen määrittelyn voisi tehdä ulkoilman lämpötilasta. Pumpun malli ja sisäilman lämpötila vaikuttavat toki myös.
* Käyttäjän talon koko ja energialuokka mahdollistaisi suoraan arvion päivä- tai vuosikohtaisesta lämmitysenergian hinnasta eri lämmitysmuodoilla.
