# Käyttöohje

## Konfigurointi

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla
> java -jar Lammitysmuotolaskuri-1.0-SNAPSHOT.jar


## Lämmitysmuotojen parametrien muuttaminen

Käyttöliittymä tarjoaa komentovaihtoehdot, joilla haluamiaan parametrejä voi muuttaa. 
Voidaan esimerkiksi muuttaa sähkön siirtohintaa tai puulämmitjseen käytettävien halkojen energiasisältöä valitsemalla tätä
vastaava komennon numero. Alla käyttöliitymän aloitusnäkymä jossa eri komentovaihtoehdot ovat nähtävillä.

*************************************************************************
Lämmitysmuotolaskuri - laskee millä lämmität asuntosi edullisimmin tänään
*************************************************************************


Valitse toiminto syöttämällä jokin seuraavista komennoista: 
1 Näytä lämmitysmuotojen hinnat senttiä/kWh
2 Tulosta ohjeet näytölle
3 Tallenna muuttamasi hintatiedot omalle käyttäjänimellesi
4 Lataa tallennetut hintatietosi käyttäjänimesi avulla
10 Muuta sähköenergian hintaa
11 Muuta sähkön siirtohintaa
20 Muuta polttopuun hintaa
21 Muuta puun polttamisen hyötysuhdetta
22 Muuta puun energiasisältöä
30 Muuta öljyn/polttonesteen hintaa
31 Muuta öljyn/polttonesteen polttamisen hyötysuhdetta
32 Muuta öljyn/polttonesteen energiasisältöä
40 Muuta ilmalämpöpumpun hyötysuhdetta
x Lopeta ohjelma

Anna komento:

## Muutettujen parametrien tallennus tai lataus pysyväismuistista

Käyttöliittymä tarjoaa komentovaihtoehdon muutettujen lämmitystietojen tietokantatallennukseen omalle käyttäjänimelle.
Käyttäjänimen on oltava uniikki. Vastaavasti voidaan myös ladata aiemmin tallennetut tiedot käyttäjänimellä hakemalla.
