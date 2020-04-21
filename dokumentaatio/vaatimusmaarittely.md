# Vaatimusmäärittely


## Sovelluksen tarkoitus

Sovellus on suunnattu omakotiasujalle, jolla on mahdollisuus lämmittää taloaan useammalla lämmönlähteellä.
Sovelluksen avulla käyttäjä voi laskea edullisimman lämmitysmuodon, eli esim. onko tänään kannattavampaa polttaa puita takassa vai käyttää sähköä. Tai tuleeko kevään 2020 hinnoilla kenties halvimmaksi polttaa öljyä?

## Käyttäjät

Sovelluksella on ainoastaan yksi käyttäjärooli eli normaali käyttäjä. Suuremmilla oikeuksilla varustetun pääkäyttäjän lisääminen on mahdollista myöhemmin, mikäli se koetaan tarpeelliseksi.

## Perusversion tarjoama toiminnallisuus

### Ennen kirjautumista

* Käyttäjä voi syöttää oman sähköenergiansa sekä siirron tämänhetkisen hinnan per kWh. TEHTY
* Käyttäjä voi syöttää oman öljynsä hinnan per litra sekä öljyn lämpöarvon ja polttamisen hyötysuhteen. TEHTY
* Käyttäjä voi syöttää oman polttopuunsa lämpöarvon ja hinnan per heittokuutio sekä takan hyötysuhteen. TEHTY
* Kayttäjä voi luoda järjestelmään käyttäjätunnuksen joka täytyy olla uniikki. TEHTY (mutta ei vielä uniiki)
* Käyttäjä voi kirjautua järjestelmään syöttämällä olemassa olevan käyttäjätunnuksen. Järjestelmä ilmoittaa jos käyttäjää ei ole olemassa.

### Kirjautumisen jälkeen

* Käyttäjä näkee oman sähkönsä, öljynsä ja polttopuunsa hinnan, mikäli hän on ne aiemmin syöttänyt. TEHTY 
* Järjestelmä antaa suosituksen edullisimmasta lämmitysmuodosta perustuen näiden hintaeroon.

## Jatkokehitysideoita

Järjestelmää voidaan jatkossa täydentää ao. ominaisuuksilla.
* Salasanan vaatiminen sisäänkirjautuessa.
* Lämpöarvot eri puulajeille voisivat olla järjestelmässä valmiina, jolloin valittaisiin esim. koivu tai kuusi.
* Pörssisähköä käyttäville olisi hieno ominaisuus hakea sähkön hetkellinen hinta automaattisesti, toteutus voi olla hankalaa.
* Ilmalämpöpumpun lisäys, jolloin tarvitaan tietoa ainakin pumpun hyötysuhdearvoista ja ehkä myös ulkoilman lämpötilasta. TEHTY
