# Käyttöohje

Lataa seuraava tiedosto: [Lammitysmuotolaskuri-1.0-SNAPSHOT.jar](https://github.com/armijuha/ot-harjoitustyo/releases/tag/loppupalautus)

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla
> java -jar Lammitysmuotolaskuri-1.0-SNAPSHOT.jar


## Lämmitysmuotojen parametrien muuttaminen

Käyttöliittymä tarjoaa komentovaihtoehdot, joilla haluamiaan parametrejä voi muuttaa. 
Voidaan esimerkiksi muuttaa sähkön siirtohintaa tai puulämmitjseen käytettävien halkojen energiasisältöä valitsemalla tätä
vastaava komennon numero. Alla käyttöliittymän aloitusnäkymä jossa eri komentovaihtoehdot ovat nähtävillä.

*************************************************************************
Lämmitysmuotolaskuri - laskee millä lämmität asuntosi edullisimmin tänään
*************************************************************************

Kaikille hinnoille, hyötysuhteille ja energiasisällöille on annettu oletusarvo.
Kuitenkin vain syöttämällä omat ajantasaiset tietosi voidaan laskea juuri sinulle ja tähän hetkeen edullisin lämmitysmuoto.


Valitse toiminto syöttämällä jokin seuraavista komennoista:

1 Näytä lämmitysmuotojen hinnat senttiä/kWh

2 Tulosta ohjeet näytölle

3 Tee uusi käyttäjänimi jolle tallennetaan muuttamasi hintatiedot

4 Tallenna muuttamasi hintatiedot olemassa olevalle käyttäjänimellesi

5 Lataa tallennetut hintatietosi käyttäjänimesi avulla

6 Poista käyttäjänimesi tiedot

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

## Muutettujen parametrien tallennus tai lataus pysyväismuistista sekä käyttäjän poisto

Käyttöliittymä tarjoaa komentovaihtoehdon muutettujen lämmityshintatietojen tietokantatallennukseen omalle käyttäjänimelle.

Käyttäjänimen on oltava uniikki. Vastaavasti voidaan myös ladata aiemmin tallennetut tiedot käyttäjänimellä hakemalla tai päivittää niitä. Käyttäjä voidaan myös poistaa, jolloin kaikki käyttäjänimelle tallennetut tiedot häviävät pysyväismuistista.
