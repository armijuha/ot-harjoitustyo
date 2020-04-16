# Vaatimusmäärittely


## Sovelluksen tarkoitus

Sovellus on suunnattu omakotiasujalle, jolla on mahdollisuus lämmittää taloaan useammalla lämmönlähteellä.
Sovelluksen avulla käyttäjä voi laskea edullisimman lämmitysmuodon, eli esim. onko kannattavampaa polttaa puita takassa vai käyttää sähköä. 

## Käyttäjät

Sovelluksella on ainoastaan yksi käyttäjärooli eli normaali käyttäjä. Suuremmilla oikeuksilla varustetun pääkäyttäjän lisääminen on mahdollista myöhemmin, mikäli se koetaan tarpeelliseksi.

## Perusversion tarjoama toiminnallisuus

### Ennen kirjautumista

* Kayttäjä voi luoda järjestelmään käyttäjätunnuksen joka täytyy olla uniikki.
* Käyttäjä voi kirjautua järjestelmään syöttämällä olemassa olevan käyttäjätunnuksen. Järjestelmä ilmoittaa jos käyttäjää ei ole olemassa.

### Kirjautumisen jälkeen

* Käyttäjä näkee oman sähkönsä, öljynsä ja polttopuunsa hinnan, mikäli hän on ne aiemmin syöttänyt.
* Käyttäjä voi syöttää oman sähkönsä tämänhetkisen hinnan per kWh.
* Käyttäjä voi syöttää oman öljynsä hinnan per litra.
* Käyttäjä voi syöttää oman polttopuunsa lämpöarvon sekä hinnan per heittokuutio.
* Järjestelmä antaa suosituksen edullisimmasta lämmitysmuodosta perustuen näiden hintaeroon.
* Käyttäjä voi kirjautua järjestelmästä ulos.

## Jatkokehitysideoita

Järjestelmää voidaan jatkossa täydentää ao. ominaisuuksilla.
* Salasanan vaatiminen sisäänkirjautuessa.
* Lämpöarvot eri puulajeille voisivat olla järjestelmässä valmiina, jolloin valittaisiin esim. koivu tai kuusi.
* Pörssisähköä käyttäville olisi hieno ominaisuus hakea sähkön hetkellinen hinta automaattisesti, toteutus voi olla hankalaa.
* Ilmalämpöpumpun lisäys, jolloin tarvitaan tietoa ainakin pumpun hyötysuhdearvoista ja ehkä myös ulkoilman lämpötilasta.
