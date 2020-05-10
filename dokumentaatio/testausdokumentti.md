# Testausdokumentti

Lämmitysmuotolaskuria on testattu paljon manuaalisesti järjestelmätasolla. 
Lisäksi on tehty automaattista yksikkö- ja integraatiotestausta JUnitin avulla.

## Yksikkö ja integraatiotestaus

### Sovelluslogiikka

Sovelluslogiikka eli pakkauksen fi.lammitysmuotolaskuri.logics sisältämiä luokkia AirHeatPump, ElectricHeating, Firewood, Oil ja User testaavat vastaavasti nimetyt testit AirHeatPumpTest, ElectricHeatingTest, FirewoodTest, OilTest ja UserTest.

Nämä testit eivät tarvitse eivätkä käytä pysyväistallennusta, joka on testattu erikseen.

### DAO

Pakkauksen fi.lammitysmuotolaskuri.dao luokkaa UserDao testaa UserDaoTest, joka käyttää tallennukseen erillistä testitietokantaa ja poistaa testaukseen käytetyn käyttäjänimen testien lopuksi.

### Testauskattavuus

Sovelluslogiikan testauksen rivikattavuus on 86% ja haarutumakattavuus 75%. DAO:n testauksen rivikattavuus on 92% ja haarautumakattavuus 75%. Käyttöliittymän toiminta on testattu manuaalisesti.
![](https://github.com/armijuha/ot-harjoitustyo/blob/master/dokumentaatio/testauskattavuus.png)

## Järjestelmätestaus

Lämmitysmuotolaskurin järjestelmätestausta on tehty manuaalisesti ja melko runsaasti. Kaikkia määrittelydokumentissa mainittuja ominaisuuksia on testattu oikeilla ja väärillä syötteillä. Sovellus tunnistaa väärän tyyppiset, tyhjät tai liian pitkät syötteet, eikä anna tehdä kahta samannimistä käyttäjää samaan aikaan pysyväistallennukseen. Tiedossa ei ole laatuongelmia näiden ominaisuuksien suhteen. Automaattisia testejä voisi lisätä testaamaan nyt manuaalisesti tehtyjä testejä.
