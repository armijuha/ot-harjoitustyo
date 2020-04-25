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
* Kayttäjä voi luoda järjestelmään käyttäjätunnuksen joka täytyy olla uniikki. VALMIS vk6 release, tietokantatoiminnallisuus ei vielä lopullinen
* Käyttäjä voi tunnuksen ja salasanan avulla tallentaa ja ladata tietonsa tietokantaan. Järjestelmä ilmoittaa jos käyttäjää ei ole olemassa.
* Ohjelma ei kaadu käyttäjän virheellisiin syötteisiin vaan ne käsitellään ja ohjeistetaan käyttäjää. VALMIS vk6 release

### Kirjautumisen jälkeen

* Käyttäjä näkee oman sähkönsä, öljynsä ja polttopuunsa hinnan, mikäli hän on ne aiemmin syöttänyt.
* Järjestelmä antaa suosituksen edullisimmasta lämmitysmuodosta perustuen näiden hintaeroon.

## Jatkokehitysideoita

Järjestelmää voidaan jatkossa täydentää ao. ominaisuuksilla.
* Lämpöarvot eri puulajeille voisivat olla järjestelmässä valmiina, jolloin valittaisiin esim. koivu tai kuusi.
* Pörssisähköä käyttäville olisi hieno ominaisuus hakea sähkön hetkellinen hinta automaattisesti, toteutus voi olla hankalaa(?).
* Ilmalämpöpumpun hyötysuhteen määrittely ulkoilman lämpötilasta. Pumpun malli ja sisäilman lämpötila vaikuttavat toki myös.
* Käyttäjän talon koko ja energialuokka mahdollistaisi suoraan arvion päivä- tai vuosikohtaisesta lämmitysenergian hinnasta eri lämmitysmuodoilla.
