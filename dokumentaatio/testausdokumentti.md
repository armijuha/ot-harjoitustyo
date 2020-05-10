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

![](https://github.com/armijuha/ot-harjoitustyo/blob/master/dokumentaatio/testauskattavuus.png)
