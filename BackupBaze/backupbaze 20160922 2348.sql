-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.22-rc-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema bpprivatnabolnica
--

CREATE DATABASE IF NOT EXISTS bpprivatnabolnica;
USE bpprivatnabolnica;

--
-- Definition of table `bolest`
--

DROP TABLE IF EXISTS `bolest`;
CREATE TABLE `bolest` (
  `Bolest_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Naziv_bolesti` varchar(35) NOT NULL,
  `Moguce_pruzanje_zdravstvenih_usluga` tinyint(1) NOT NULL,
  PRIMARY KEY (`Bolest_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=226 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bolest`
--

/*!40000 ALTER TABLE `bolest` DISABLE KEYS */;
INSERT INTO `bolest` (`Bolest_ID`,`Naziv_bolesti`,`Moguce_pruzanje_zdravstvenih_usluga`) VALUES 
 (1,'Tuberkuloza',0),
 (2,'Virus',1),
 (3,'Astma',0),
 (4,'Diabetes',1),
 (5,'Diskus hernija',0),
 (6,'Kolera',1),
 (7,'Tifusna groznica',1),
 (8,'Trbusni tifus',1),
 (9,'Salmonela',1),
 (10,'Zapaljenje tankog creva',1),
 (11,'Sigeloza',1),
 (12,'Sepsa',0),
 (13,'Eserihija',1),
 (14,'Botulizam',1),
 (15,'Trovanje hranom',1),
 (16,'Amebijaza koze',0),
 (17,'Djardijaza',0),
 (18,'Izosporijaza',0),
 (19,'Kuga',0),
 (20,'Tularemija',0),
 (21,'Sakagija',1),
 (22,'Groznica',1),
 (23,'Lepra',1),
 (24,'Listeroza koze',0),
 (25,'Veliki kasalj',1),
 (26,'Sarlah',0),
 (27,'Gasna gangrena',1),
 (28,'Urodjeni sifilis',1),
 (29,'Anogenitalne bradavice',1),
 (30,'Pinta',0),
 (31,'Lajmska bolest',0),
 (32,'Prehlada',1),
 (33,'Trahom',1),
 (34,'Kju-groznica',1),
 (35,'Besnilo',0),
 (36,'Rociova bolest',1),
 (37,'Zapaljenje mozga',1),
 (38,'Zapaljenje pluca',0),
 (39,'Denga groznica',1),
 (40,'Groznica zapadnog Nila',0),
 (41,'Sumska groznica',1),
 (42,'Prehlada',1),
 (43,'Zuta groznica',1),
 (44,'Ebola',0),
 (45,'Herpes',1),
 (46,'Ovcije boginje',1),
 (47,'Male boginje',1),
 (48,'Zarazno crvenilo',0),
 (49,'Hepatitis',0),
 (50,'Sida',0),
 (51,'Zauske',1),
 (52,'Hromomikoza koze',0),
 (53,'Aspergiloza',0),
 (54,'Micetom',1),
 (55,'Eumicetom',1),
 (56,'Malarija',0),
 (57,'Toksoplazmoza oka',0),
 (58,'Infekcija',1),
 (59,'Zlocudni tumor',0),
 (60,'Leukemija',0),
 (61,'Karcinom',0),
 (62,'Dobrocudni tumor',1),
 (63,'Mladez',1),
 (64,'Tumor',0),
 (65,'Anemija',1),
 (66,'Krvarenje',1),
 (67,'Alergija',1),
 (68,'Cista',1),
 (69,'Tireoktoksicna kriza',1),
 (70,'Zapaljenje stitne zelzde',1),
 (71,'Nedostatak vitamina',1),
 (72,'Hipervitaminoza',1),
 (73,'Gojaznost',1),
 (74,'Depresija',1),
 (75,'Anksioznost',1),
 (76,'Gilbertov sindrom',0),
 (77,'Psihoticki poremecaji',0),
 (78,'Paranoja',0),
 (79,'Akutna oboljenja',1),
 (80,'Hipomanija',0),
 (81,'Poremecaji licnosti',1),
 (82,'Nocne more',1),
 (83,'Deciji autizam',0),
 (84,'Tikovi',0),
 (85,'Mucanje',1),
 (86,'Meningitis',1),
 (87,'Epilepsija',1),
 (88,'Ostecenjenje zivca',0),
 (89,'Distrofija misica',1),
 (90,'Povremena oduzetost',1),
 (91,'Paraliza',0),
 (92,'Ocne bolesti',0),
 (93,'Razrokost',0),
 (94,'Skleroza',1),
 (95,'Akutni infrakt',1),
 (96,'Plucna embolija',1),
 (97,'Hipertenzija',1),
 (98,'Arteroskleroza',1),
 (99,'Flebitis',1),
 (100,'Hemoroidi',1),
 (101,'Prosirene vene',1),
 (102,'Grip',1),
 (103,'Bolesti zuba',0),
 (104,'Fistula slepog creva',1),
 (105,'Uvrtanje creva',1),
 (106,'Bolest jetre',1),
 (107,'Kamen u bubregu',1),
 (108,'Kamen u zuci',1),
 (109,'Povracanje krvi',1),
 (110,'Besnierov svrab',1),
 (111,'Psorijaza',0),
 (112,'Akne',1),
 (113,'Pege',1),
 (114,'Gnoj',1),
 (115,'Giht',1),
 (116,'Iscasenje',1),
 (117,'Otvoreni prelom kostiju',1),
 (118,'Zatvoreni prelom kostiju',1),
 (119,'Grcenje misica',1),
 (120,'Nervni cvor',1),
 (121,'Rastapanje hrskavice',1),
 (122,'Zapaljenje misica',1),
 (123,'Inverzije hromozoma',0),
 (124,'Kariotip',1),
 (125,'Lupanje srca',1),
 (126,'Gorusica',1),
 (127,'Oteklina koze',1),
 (128,'Bledilo',1),
 (129,'Pospanost',1),
 (130,'Poremecaji glasa',1),
 (131,'Glavobolja',1),
 (132,'Gubitak apetita',1),
 (133,'Ovorena rana glave',1),
 (134,'Opekotine',1),
 (135,'Otklanjanje stranog tela',1),
 (136,'Promrzline',1),
 (137,'Povisenost telesne temperature',1),
 (138,'Gusenje',1),
 (139,'Bolest kretanja',0),
 (140,'Fiksiranje delova tela',1),
 (141,'Pucanje arkade',1),
 (142,'Pad sa odredjene visine',1),
 (143,'Ugruvanost',1),
 (144,'Prignjecenost',1),
 (145,'Ukljestenost',1),
 (146,'Ujed',1),
 (147,'Davljenje',1),
 (148,'Izlaganje struji',1),
 (149,'Kontakt sa vrelim isparenjima',1),
 (150,'Ubod pcele',1),
 (151,'Ubod ose',1),
 (152,'Trovanje alkoholom',1),
 (153,'Trovanje lekovima',1),
 (154,'Trovanje opijatima',1),
 (155,'Trovanje pesticidima',1),
 (156,'Ranjavanje oruzijem',1),
 (157,'Ubod ostrim predmetom',1),
 (158,'Lake telesne povrede',1),
 (159,'Teske telesne povrede',0),
 (160,'Gubitak svesti',1),
 (161,'Potreba za imunizacijom',1),
 (162,'Izolacija',1),
 (163,'Vestacki otvor',1),
 (164,'Povreda ahilove tetive',0),
 (165,'Razjedi',1),
 (166,'Zdrobljavanje',1),
 (167,'Povreda misica',0),
 (168,'Prelom vrata',1),
 (169,'Povreda zivca kicmene mozdine',0),
 (170,'Trenutna smrt',0),
 (171,'Abnormalni nalaz testa',1),
 (172,'Prekomerna zedj',1),
 (173,'Edem',0),
 (174,'Klonulost i umor',1),
 (175,'Bolno mokrenje',1),
 (176,'Koprivnjaca',0),
 (177,'Mucnina i povracanje',1),
 (178,'Povecani nivo vode u organizmu',0),
 (179,'Himerizam',0),
 (180,'Obrnuti polozaj organa',0),
 (181,'Urasline dlake',1),
 (182,'Nezadrzavanje pigmenta',0),
 (183,'Lako lomljiva kost',0),
 (184,'Vratno rebro',0),
 (185,'Rascepi kicmenog stuba',0),
 (186,'Prekobrojni bubreg',0),
 (187,'Potterov sindrom',1),
 (188,'Hirschsprungova bolest',0),
 (189,'Suzenost aorte',1),
 (190,'Zacepljenost aorte',1),
 (191,'Ebsteinova anomalija',0),
 (192,'Niska temperatura',1),
 (193,'Zutica',1),
 (194,'Spondilopatija',1),
 (195,'Behcetova bolest',0),
 (196,'Reumtaski bolovi u misicima',0),
 (197,'CREST sindrom',0),
 (198,'Kaschin-Beckova bolest',0),
 (199,'Feltyjev sindrom',0),
 (200,'Strije',1),
 (201,'Urastao nokat',1),
 (202,'Plikoviti pemfigoid',0),
 (203,'Tropski spru',1),
 (204,'Celijacna bolest',0),
 (205,'Fibroza i ciroza jetre',1),
 (206,'Peritonitis',0),
 (207,'Zatvor',1),
 (208,'Kolitis',1),
 (209,'Prosirenje zeluca',1),
 (210,'Angina pektoris',0),
 (211,'Baretov jednjak',1),
 (212,'Poviseni krvni pritisak',1),
 (213,'Ruptura arterije',1),
 (214,'Raynaudova bolest',0),
 (215,'Bauergerova bolest',0),
 (216,'Moyamoya bolest',0),
 (217,'Infarkt mozga',0),
 (218,'Srcana insuficijencija',1),
 (219,'Horeja',1),
 (220,'Zastoj srca',1),
 (221,'Perikarditis',0),
 (222,'Zapuseni krvni sud',1),
 (223,'Membrane pupile',0),
 (224,'Alzheimerova bolest',0),
 (225,'Oduzetost nogu',1);
/*!40000 ALTER TABLE `bolest` ENABLE KEYS */;


--
-- Definition of table `dijagnoza`
--

DROP TABLE IF EXISTS `dijagnoza`;
CREATE TABLE `dijagnoza` (
  `Pregled_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Redni_broj` int(10) unsigned NOT NULL,
  `Bolest_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Pregled_ID`,`Redni_broj`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dijagnoza`
--

/*!40000 ALTER TABLE `dijagnoza` DISABLE KEYS */;
INSERT INTO `dijagnoza` (`Pregled_ID`,`Redni_broj`,`Bolest_ID`) VALUES 
 (1,1,197),
 (1,2,204),
 (1,3,66),
 (3,1,2),
 (3,2,197),
 (4,3,171),
 (4,4,14),
 (5,5,197),
 (6,1,197),
 (6,2,65),
 (6,3,175),
 (8,1,67),
 (8,2,131),
 (8,3,126),
 (8,4,124),
 (11,1,79),
 (11,2,96),
 (12,1,173),
 (12,2,126),
 (12,3,63),
 (12,4,161),
 (12,5,96),
 (13,1,16),
 (13,2,107),
 (13,3,129),
 (13,4,161),
 (13,5,161),
 (13,6,2),
 (14,1,97),
 (14,2,72),
 (14,3,123);
/*!40000 ALTER TABLE `dijagnoza` ENABLE KEYS */;


--
-- Definition of table `faktura`
--

DROP TABLE IF EXISTS `faktura`;
CREATE TABLE `faktura` (
  `Faktura_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Pregled_ID` int(10) unsigned NOT NULL,
  `Iznos_fakture` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Faktura_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `faktura`
--

/*!40000 ALTER TABLE `faktura` DISABLE KEYS */;
INSERT INTO `faktura` (`Faktura_ID`,`Pregled_ID`,`Iznos_fakture`) VALUES 
 (1,1,0),
 (2,2,0),
 (3,3,14375),
 (4,4,16000),
 (5,5,0),
 (6,6,12850),
 (8,8,0),
 (10,10,0),
 (11,11,0),
 (12,12,43765),
 (13,13,0),
 (14,14,33000);
/*!40000 ALTER TABLE `faktura` ENABLE KEYS */;


--
-- Definition of table `izvrsene_usluge`
--

DROP TABLE IF EXISTS `izvrsene_usluge`;
CREATE TABLE `izvrsene_usluge` (
  `Pregled_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Redni_broj` int(10) unsigned NOT NULL,
  `Usluga_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Pregled_ID`,`Redni_broj`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `izvrsene_usluge`
--

/*!40000 ALTER TABLE `izvrsene_usluge` DISABLE KEYS */;
INSERT INTO `izvrsene_usluge` (`Pregled_ID`,`Redni_broj`,`Usluga_ID`) VALUES 
 (1,1,50),
 (3,1,31),
 (3,2,30),
 (3,3,33),
 (3,4,87),
 (4,5,22),
 (4,6,159),
 (4,7,62),
 (4,8,135),
 (5,9,22),
 (6,1,22),
 (6,2,107),
 (6,3,23),
 (6,4,43),
 (8,1,66),
 (8,2,180),
 (8,3,121),
 (11,1,58),
 (11,2,52),
 (11,3,66),
 (11,4,73),
 (12,1,210),
 (12,2,11),
 (12,3,113),
 (12,4,35),
 (12,5,212),
 (12,6,73),
 (13,1,30),
 (13,2,43),
 (13,3,51),
 (13,4,58),
 (13,5,73),
 (14,1,59);
/*!40000 ALTER TABLE `izvrsene_usluge` ENABLE KEYS */;


--
-- Definition of table `lek`
--

DROP TABLE IF EXISTS `lek`;
CREATE TABLE `lek` (
  `Lek_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Proizvodjac_ID` int(10) unsigned NOT NULL,
  `Naziv_leka` varchar(30) NOT NULL,
  `Jacina` varchar(10) NOT NULL,
  PRIMARY KEY (`Lek_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `lek`
--

/*!40000 ALTER TABLE `lek` DISABLE KEYS */;
INSERT INTO `lek` (`Lek_ID`,`Proizvodjac_ID`,`Naziv_leka`,`Jacina`) VALUES 
 (1,3,'Bromazepamm ','75mg'),
 (2,1,'Diazepam','50mg'),
 (3,1,'Alfacet','25mg'),
 (4,2,'Trodon','200mg'),
 (5,2,'Brufen','500mg'),
 (6,3,'Viekvin','25mg'),
 (7,3,'Vaxigrip','25mg'),
 (8,4,'Pentaxim','25mg'),
 (9,4,'Immunorho','25mg'),
 (10,5,'Amoksicilin','250mg'),
 (11,5,'Sinacilin','250mg'),
 (12,6,'Sinacilin','500mg'),
 (13,6,'Panklav','250mg'),
 (14,7,'Cefaleksin','500mg'),
 (15,7,'Cefaleksin','250mg'),
 (16,8,'Palitrex','500mg'),
 (17,8,'Alfacet','250mg'),
 (18,9,'Tridox','100mg'),
 (19,9,'Aksef','250mg'),
 (20,10,'Cedax','250mg'),
 (21,10,'Amracin','500mg'),
 (22,1,'Hemomycin','250mg'),
 (23,1,'Azibiot','100mg'),
 (24,2,'Klaritromicin','250mg'),
 (25,2,'Ketek','200mg'),
 (26,1,'Omicral','75mg'),
 (27,2,'Noxafil','50mg'),
 (28,3,'Zeffix','125mg'),
 (29,3,'Viramune','200mg'),
 (30,3,'Ciprofloxacin','500mg'),
 (31,4,'Levoxa','750mg'),
 (32,4,'Forteca','1000mg'),
 (33,4,'Nitroxin forte','250mg'),
 (34,5,'Vancomycin-MIP','1000mg'),
 (35,5,' Lastet Cap. 50','50mg'),
 (36,5,'Carboplasin','45mg'),
 (37,6,'Calumid','150mg'),
 (38,6,'Alprodex','125mg'),
 (39,6,'Hidroksikarbamid','500mg'),
 (40,7,'Thyrozol','10mg'),
 (41,7,'Diaprel MR','60mg'),
 (42,7,'Oglition','15mg'),
 (43,8,'Nirypan','4mg'),
 (44,8,'Bedoxin','20mg'),
 (45,8,'Beviplex','100mg'),
 (46,9,' Kalcijum karbonat Alkaloid','2mg'),
 (47,9,'Xyzal','5mg'),
 (48,9,'Pressing','10mg'),
 (49,9,'Heferol','350mg'),
 (50,10,'Referum','100mg'),
 (51,10,'Folacin','5mg'),
 (52,10,'Haemoctin','10mg'),
 (53,1,'Beriplast','90mg'),
 (54,1,'Plavix','75mg'),
 (55,1,'Klopidogrel','75mg'),
 (56,2,'Aranesp','200mg'),
 (57,2,'Mircera','50mg'),
 (58,2,'Haloperidol','2mg'),
 (59,3,'Seroquel','100mg'),
 (60,3,'Kvetiapin','300mg'),
 (61,3,'Onzapin','15mg'),
 (62,4,'Speridan','3mg'),
 (63,4,'Rispen','2mg'),
 (64,4,'Rispolept','2mg'),
 (65,5,'Risperidon','5mg'),
 (66,5,'Bensedin','5mg'),
 (67,5,'Diazepam','2mg'),
 (68,6,'Dormicum','7mg'),
 (69,6,'Citalex','20mg'),
 (70,6,'Cystocain 2%','2mg'),
 (71,7,'Analgin','500mg'),
 (72,7,'Febricet','500mg'),
 (73,7,'Zomig','3mg'),
 (74,8,'Metadon','40mg'),
 (75,8,'Trodon','100mg'),
 (76,8,'Zyban','150mg'),
 (77,9,'Amlodipin','10mg'),
 (78,9,'Pralip','20mg'),
 (79,9,'Simvax','40mg'),
 (80,10,'Aminofilin','350mg'),
 (81,10,'Durofilin','250mg'),
 (82,10,'Folkodin Alkaloid','10mg'),
 (83,1,'Lazol','15mg'),
 (84,1,'Omeprazol','10mg'),
 (85,1,'Buscopan','10mg'),
 (86,2,'Ranitidin','300mg'),
 (87,2,'Ulcodin','150mg'),
 (88,2,'Urorec','8mg'),
 (89,3,'Veregen','15mg'),
 (90,3,'Detrusitol','2mg'),
 (91,3,'Rozamet','25mg'),
 (92,4,'Gentamicin','25mg'),
 (93,4,'Esperson','30mg'),
 (94,4,'Beloderm','15mg'),
 (95,5,'Sinoderm','15mg'),
 (96,5,'Hydrocyclin','2mg'),
 (97,5,'Sona','5mg'),
 (98,6,'Daktanol','5mg'),
 (99,6,'Protopic','30mg'),
 (100,6,'Melogal','15mg'),
 (101,7,'Diklofen','50mg'),
 (102,7,'Diklofenak','100mg'),
 (103,7,'Zodol','10mg'),
 (104,8,'Flugalin','50mg'),
 (105,8,'Ibuprofen','600mg'),
 (106,8,' Rantudil forte','60mg'),
 (107,9,'Fastum gel','10mg'),
 (108,9,'Sirdalud','4mg'),
 (109,9,'Folcasin','10mg'),
 (110,10,'Exjade','500mg'),
 (111,10,'Helicobacter','75mg'),
 (112,10,'Daktanol','10mg'),
 (113,1,'Tetanus gamma','2mg'),
 (114,2,'Pamecil','10mg'),
 (115,3,'Amomicin','200mg'),
 (116,4,'Gentamicin','50mg'),
 (117,5,'Herceptin','100mg'),
 (118,6,'Rextol','5mg'),
 (119,7,'Atenativ 500','500mg'),
 (120,8,'Atenativ 1000','1000mg'),
 (121,9,'Emoclot','150mg'),
 (122,10,'Propofol','2mg'),
 (123,1,'Tracirum','75mg'),
 (124,2,'Ranitidin','125mg'),
 (125,3,'Dipeptiven','4mg'),
 (129,9,'Nerilex','29fgf');
/*!40000 ALTER TABLE `lek` ENABLE KEYS */;


--
-- Definition of table `lekar`
--

DROP TABLE IF EXISTS `lekar`;
CREATE TABLE `lekar` (
  `Jmbg_lekar` varchar(13) NOT NULL,
  `PTT` int(10) unsigned NOT NULL,
  `Zvanje_ID` int(10) unsigned NOT NULL,
  `Ime` varchar(15) NOT NULL,
  `Prezime` varchar(30) NOT NULL,
  `Korisnicko_ime` varchar(15) NOT NULL,
  `Sifra` int(10) unsigned NOT NULL,
  `Datum_rodjenja` datetime NOT NULL,
  `Ulica_i_broj` varchar(45) NOT NULL,
  `Broj_telefona` varchar(20) NOT NULL,
  PRIMARY KEY (`Jmbg_lekar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `lekar`
--

/*!40000 ALTER TABLE `lekar` DISABLE KEYS */;
INSERT INTO `lekar` (`Jmbg_lekar`,`PTT`,`Zvanje_ID`,`Ime`,`Prezime`,`Korisnicko_ime`,`Sifra`,`Datum_rodjenja`,`Ulica_i_broj`,`Broj_telefona`) VALUES 
 ('1831231123211',23000,729073,'Svetlana','Jovanovic','SJovanovic',2332,'1978-03-15 00:00:00','Cara Dusana 21','065/4390439'),
 ('2230291000211',23000,719001,'Branislav','Pajic','BPajic',6542,'1973-05-05 00:00:00','Njegoseva 19','060/3349032'),
 ('2453145631234',23000,729087,'Gaja','Pozojevic','GPozojevic',7778,'1967-04-21 00:00:00','Mileticeva 66','061/4343431'),
 ('3312020112311',23000,729073,'Branislav','Martinov','BMartinov',5454,'1979-04-20 00:00:00','Solunska 112','066/4303443'),
 ('4301102302311',23000,729087,'Milos','Vukmirovic','MVukmirovic',6454,'1986-07-10 00:00:00','Nemanjina 55','064/4331123'),
 ('5444524131234',23000,729000,'Marijana','Jokic','MJokic',2398,'1967-07-14 00:00:00','Pupinova 6','063/4334341'),
 ('5930301112311',23000,729087,'Mile','Kovacevic','MKovacevic',7621,'1964-03-21 00:00:00','Nikole Tesle 10','065/4341131'),
 ('6293100123000',23000,809000,'Vesna','Djordjevic','VDjordjevic',4443,'1965-02-11 00:00:00','Zarka Zrenjanina 153','060/9493911'),
 ('6334031197300',23000,729073,'Dragan','Velickovic','DVelickovic',6541,'1969-07-10 00:00:00','Cvijiceva 8','069/5512000'),
 ('7885042197901',23000,729000,'Ivana','Zogovic','IZogovic',6953,'1979-11-11 00:00:00','Takovska 20','065/6556565'),
 ('7939210023002',23000,729073,'Snezana','Jerinic','SJerinic',9911,'1985-11-12 00:00:00','Baranjska 9','069/9091123'),
 ('9930201190212',23000,729073,'Milica','Dautovic','MDautovic',2398,'1977-02-23 00:00:00','Koce Kolarova 15','065/3349032');
/*!40000 ALTER TABLE `lekar` ENABLE KEYS */;


--
-- Definition of table `mesto`
--

DROP TABLE IF EXISTS `mesto`;
CREATE TABLE `mesto` (
  `PTT` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Naziv_mesta` varchar(30) NOT NULL,
  `Region_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`PTT`)
) ENGINE=InnoDB AUTO_INCREMENT=38221 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mesto`
--

/*!40000 ALTER TABLE `mesto` DISABLE KEYS */;
INSERT INTO `mesto` (`PTT`,`Naziv_mesta`,`Region_ID`) VALUES 
 (11000,'Beograd',10),
 (11235,'Mali Pozarevac',6),
 (11300,'Smederevo',6),
 (11317,'Lozovik',6),
 (11460,'Barajevo',10),
 (11500,'Obrenovac',10),
 (12000,'Pozarevac',7),
 (12220,'Veliko Gradiste',7),
 (12223,'Golubac',7),
 (12300,'Petrovac',6),
 (14000,'Valjevo',5),
 (14200,'Ub',5),
 (14240,'Ljig',5),
 (15000,'Sabac',4),
 (15225,'Vladimirci',5),
 (15300,'Loznica',5),
 (15314,'Krupanj',5),
 (15350,'Bogatic',4),
 (16210,'Vlasotince',8),
 (17500,'Vranje',8),
 (17520,'Bujanovac',8),
 (17523,'Presevo',8),
 (18000,'Nis',8),
 (18220,'Aleksinac',8),
 (18230,'Soko Banja',8),
 (18310,'Bela Palanka',8),
 (18330,'Babusnica',8),
 (18360,'Svrljig',8),
 (18400,'Prokuplje',6),
 (18430,'Kursumlija',6),
 (18433,'Prolom',8),
 (18437,'Lukovo',6),
 (19000,'Zajecar',7),
 (19210,'Bor',7),
 (19257,'Rudna Glava',7),
 (19259,'Majdanpek',7),
 (19300,'Negotin',7),
 (19325,'Tekija',7),
 (19370,'Boljevac',7),
 (20000,'Prizren',9),
 (21000,'Novi Sad',2),
 (21200,'Becej',1),
 (21235,'Temerin',2),
 (21400,'Backa Palanka',2),
 (21410,'Futog',2),
 (21460,'Vrbas',2),
 (21470,'Backi Petrovac',2),
 (21480,'Srbobran',2),
 (22000,'Sremska Mitrovica',3),
 (22240,'Sid',3),
 (22251,'Batrovci',3),
 (22300,'Stara Pazova',3),
 (22320,'Indjija',3),
 (22400,'Ruma',3),
 (22406,'Irig',3),
 (23000,'Zrenjanin',1),
 (23210,'Zitiste',1),
 (23220,'Srpska Crnja',1),
 (23240,'Secanj',1),
 (23270,'Melenci',1),
 (23300,'Kikinda',1),
 (23305,'Mokrin',1),
 (24000,'Subotica',2),
 (24210,'Bajmok',2),
 (24300,'Backa Toplola',2),
 (24400,'Senta',1),
 (24430,'Ada',1),
 (25000,'Sombor',2),
 (25223,'Sivac',2),
 (25230,'Kula',2),
 (25250,'Odzaci',2),
 (25260,'Apatin',2),
 (26000,'Pancevo',1),
 (26300,'Vrsac',1),
 (30000,'Pec',9),
 (31000,'Uzice',5),
 (31210,'Pozega',5),
 (31250,'Bajina Basta',5),
 (31260,'Kosjeric',5),
 (31300,'Prijepolje',5),
 (31305,'Brodarevo',5),
 (31315,'Zlatibor',5),
 (31320,'Nova Varos',5),
 (31330,'Priboj',5),
 (32000,'Cacak',5),
 (32230,'Guca',5),
 (32258,'Kusici',5),
 (32300,'Gornji MIlanovac',5),
 (34000,'Kragujevac',6),
 (34220,'Lapovo',6),
 (34240,'Knic',6),
 (34303,'Arandjelovac',6),
 (35000,'Jagodina',6),
 (35213,'Despotovac',6),
 (35224,'Medvedja',8),
 (35250,'Paracin',6),
 (36000,'Kraljevo',6),
 (36300,'Novi Pazar',6),
 (36310,'Sjenica',5),
 (36320,'Tutin',6),
 (36350,'Raska',6),
 (37000,'Krusevac',6),
 (37229,'Brus',6),
 (37230,'Aleksandrovac',6),
 (38128,'Leposavic',9),
 (38220,'Kosovska Mitrovica',9);
/*!40000 ALTER TABLE `mesto` ENABLE KEYS */;


--
-- Definition of table `pacijent`
--

DROP TABLE IF EXISTS `pacijent`;
CREATE TABLE `pacijent` (
  `Jmbg_pacijent` varchar(13) NOT NULL,
  `PTT` int(10) unsigned NOT NULL,
  `Ime_oca` varchar(20) NOT NULL,
  `Ime` varchar(20) NOT NULL,
  `Prezime` varchar(25) NOT NULL,
  `Broj_telefona` varchar(25) NOT NULL,
  `Ulica_i_broj` varchar(45) NOT NULL,
  `Broj_zdravstvene_knjizice` int(10) unsigned NOT NULL,
  `Datum_Rodjenja` datetime NOT NULL,
  PRIMARY KEY (`Jmbg_pacijent`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pacijent`
--

/*!40000 ALTER TABLE `pacijent` DISABLE KEYS */;
INSERT INTO `pacijent` (`Jmbg_pacijent`,`PTT`,`Ime_oca`,`Ime`,`Prezime`,`Broj_telefona`,`Ulica_i_broj`,`Broj_zdravstvene_knjizice`,`Datum_Rodjenja`) VALUES 
 ('0842300505977',24430,'Dragan','Milos','Milivojevic','065/5019431','Nikole Tesle 8',439483,'1992-10-10 00:00:00'),
 ('1431144212241',21200,'Milutin','Petar','Djordjevic','060/4343131','Jovana Cvijica 19',943430,'1993-11-11 00:00:00'),
 ('2922331144112',23000,'Dusan','David','Milivojev','069/5015421','Zarka Zrenjanina 23',23211,'1954-04-05 00:00:00'),
 ('3012214221221',21000,'Dragica','Vesna','Jevremov','064/5012222','Milutina Milankovica 88',343312,'1996-05-12 00:00:00'),
 ('4229142454123',23210,'Dragan','Dunja','Djukic','067/5043423','Narodnog Fronta 5',653232,'1980-01-19 00:00:00'),
 ('4834934831341',23000,'Dimitrije','Dalibor','Pesic','064/1423211','Stevana Musica 6',955312,'1991-03-05 00:00:00'),
 ('5043933144112',24430,'Vukasin','Ognjen','Levajic','062/5023121','Cara Dusana 15',553421,'1977-03-21 00:00:00'),
 ('5343112232325',23220,'Viktor','Ana','Balos','065/0905444','Pupinova 99',362123,'1994-10-08 00:00:00'),
 ('5453413213551',23000,'Marko','Dimitrije','Pavlovic','062/3231231','Laze Kostica 10',394342,'1976-06-10 00:00:00'),
 ('6393951111249',23220,'Igor','Marijan','Markovic','064/9430943','Kralja Aleksandra 67',832812,'1973-05-20 00:00:00'),
 ('7419890004245',24430,'Milorad','Nenad','Kasas','063/5930212','Kralja Petra 1',445123,'1989-04-17 00:00:00'),
 ('7431911221121',23240,'Zoran','Stefan','Petrovic','069/4322312','Branka Bajica 55',893912,'1992-02-02 00:00:00'),
 ('7778889991110',23000,'Zeljko','Darko','Govedar','061/1213221','Nusiceva 16',512331,'1989-10-07 00:00:00'),
 ('7940334331341',23270,'Zoran','Natasa','Pupin','060/4343112','Stevana Sremca 16',969212,'1987-04-15 00:00:00');
/*!40000 ALTER TABLE `pacijent` ENABLE KEYS */;


--
-- Definition of table `pregled`
--

DROP TABLE IF EXISTS `pregled`;
CREATE TABLE `pregled` (
  `Pregled_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Jmbg_lekar` varchar(13) NOT NULL,
  `Jmbg_pacijent` varchar(13) NOT NULL,
  `Datum_pregleda` date NOT NULL,
  PRIMARY KEY (`Pregled_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `pregled`
--

/*!40000 ALTER TABLE `pregled` DISABLE KEYS */;
INSERT INTO `pregled` (`Pregled_ID`,`Jmbg_lekar`,`Jmbg_pacijent`,`Datum_pregleda`) VALUES 
 (1,'3312020112311','0842300505977','2016-09-22'),
 (2,'3312020112311','2922331144112','2016-09-22'),
 (3,'3312020112311','7431911221121','2016-09-22'),
 (4,'3312020112311','7778889991110','2016-09-22'),
 (5,'3312020112311','1431144212241','2016-09-22'),
 (6,'3312020112311','6393951111249','2016-09-22'),
 (8,'3312020112311','4834934831341','2016-09-22'),
 (10,'3312020112311','4834934831341','2016-09-22'),
 (11,'2453145631234','5453413213551','2016-09-22'),
 (12,'2453145631234','5453413213551','2016-09-22'),
 (13,'3312020112311','5453413213551','2016-09-22'),
 (14,'3312020112311','0842300505977','2016-09-22');
/*!40000 ALTER TABLE `pregled` ENABLE KEYS */;


--
-- Definition of table `proizvodjac`
--

DROP TABLE IF EXISTS `proizvodjac`;
CREATE TABLE `proizvodjac` (
  `Proizvodjac_ID` int(10) unsigned NOT NULL,
  `Naziv_proizvodjaca` varchar(45) NOT NULL,
  PRIMARY KEY (`Proizvodjac_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `proizvodjac`
--

/*!40000 ALTER TABLE `proizvodjac` DISABLE KEYS */;
INSERT INTO `proizvodjac` (`Proizvodjac_ID`,`Naziv_proizvodjaca`) VALUES 
 (1,'Hemofarm AD'),
 (2,'Galenika a.d.'),
 (3,'Srbolek'),
 (4,'Habit Pharm'),
 (5,'Jugoremedija'),
 (6,'Pharmanova'),
 (7,'Zorka pharma'),
 (8,'Panfarma'),
 (9,'Bayer'),
 (10,'UFAR pharmaceuticals');
/*!40000 ALTER TABLE `proizvodjac` ENABLE KEYS */;


--
-- Definition of table `recept`
--

DROP TABLE IF EXISTS `recept`;
CREATE TABLE `recept` (
  `Recept_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Lek_ID` int(10) unsigned NOT NULL,
  `Pregled_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Recept_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `recept`
--

/*!40000 ALTER TABLE `recept` DISABLE KEYS */;
INSERT INTO `recept` (`Recept_ID`,`Lek_ID`,`Pregled_ID`) VALUES 
 (1,35,3),
 (2,105,14);
/*!40000 ALTER TABLE `recept` ENABLE KEYS */;


--
-- Definition of table `region`
--

DROP TABLE IF EXISTS `region`;
CREATE TABLE `region` (
  `Region_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Naziv_regiona` varchar(45) NOT NULL,
  PRIMARY KEY (`Region_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `region`
--

/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` (`Region_ID`,`Naziv_regiona`) VALUES 
 (1,'Banat'),
 (2,'Backa'),
 (3,'Srem'),
 (4,'Macva'),
 (5,'Zapadni region'),
 (6,'Centralni region'),
 (7,'Istocni region'),
 (8,'Juzni region'),
 (9,'Kosovo i Metohija'),
 (10,'Beogradski region');
/*!40000 ALTER TABLE `region` ENABLE KEYS */;


--
-- Definition of table `stavka_fakture`
--

DROP TABLE IF EXISTS `stavka_fakture`;
CREATE TABLE `stavka_fakture` (
  `Faktura_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Redni_broj` int(10) unsigned NOT NULL,
  `Usluga_ID` int(10) unsigned NOT NULL,
  `Cena` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Faktura_ID`,`Redni_broj`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stavka_fakture`
--

/*!40000 ALTER TABLE `stavka_fakture` DISABLE KEYS */;
INSERT INTO `stavka_fakture` (`Faktura_ID`,`Redni_broj`,`Usluga_ID`,`Cena`) VALUES 
 (1,1,50,6000),
 (3,1,31,120),
 (3,2,30,130),
 (3,3,33,125),
 (3,4,87,14000),
 (4,5,22,650),
 (4,6,159,1200),
 (4,7,62,1550),
 (4,8,135,12600),
 (5,9,22,650),
 (6,1,22,650),
 (6,2,107,7000),
 (6,3,23,200),
 (6,4,43,5000),
 (8,1,66,2000),
 (8,2,180,175),
 (8,3,121,12000),
 (11,1,58,3000),
 (11,2,52,5000),
 (11,3,66,2000),
 (11,4,73,34000),
 (12,1,210,500),
 (12,2,11,435),
 (12,3,113,8000),
 (12,4,35,80),
 (12,5,212,750),
 (12,6,73,34000),
 (13,1,30,130),
 (13,2,43,5000),
 (13,3,51,4000),
 (13,4,58,3000),
 (13,5,73,34000),
 (14,1,59,33000);
/*!40000 ALTER TABLE `stavka_fakture` ENABLE KEYS */;


--
-- Definition of table `uput`
--

DROP TABLE IF EXISTS `uput`;
CREATE TABLE `uput` (
  `Uput_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Zdravstvena_ustanova_ID` int(10) unsigned NOT NULL,
  `Pregled_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Uput_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `uput`
--

/*!40000 ALTER TABLE `uput` DISABLE KEYS */;
INSERT INTO `uput` (`Uput_ID`,`Zdravstvena_ustanova_ID`,`Pregled_ID`) VALUES 
 (1,8671923,3),
 (2,8877556,5),
 (3,8671923,6);
/*!40000 ALTER TABLE `uput` ENABLE KEYS */;


--
-- Definition of table `usluga`
--

DROP TABLE IF EXISTS `usluga`;
CREATE TABLE `usluga` (
  `Usluga_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Naziv_usluge` varchar(100) NOT NULL,
  `Cena` int(10) unsigned NOT NULL,
  PRIMARY KEY (`Usluga_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=226 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usluga`
--

/*!40000 ALTER TABLE `usluga` DISABLE KEYS */;
INSERT INTO `usluga` (`Usluga_ID`,`Naziv_usluge`,`Cena`) VALUES 
 (1,'Pregled',500),
 (2,'Lokalna anestezija',120),
 (3,'Merenje difuzijskog kapaciteta pluca',2660),
 (4,'Merenje totalnog plucnog volumena',2600),
 (5,'Merenje disajnog ili plucnog otopora',2400),
 (6,'Inhalacioni provokativni test',2500),
 (7,'Inhalacija',1500),
 (8,'Ostala merenja respiratorne funkcije',2200),
 (9,'EKG',3000),
 (10,'Test kozne osteljivosti sa 20 alergena',750),
 (11,'Vadjenje krvi u dijagnosticke svrhe',435),
 (12,'Brohoskopija sa biopsijom',4800),
 (13,'Bronhodilatatorni test',50),
 (14,'Oksimetrija',100),
 (15,'Savetovanje o  oporavku',1700),
 (16,'Terapija celog tela vezvanjem',175),
 (17,'Vezbe u lecenju respiratornih boleseti',45),
 (18,'Pratnja ili transport klijenta',250),
 (19,'Davanje farmakoloskog sredstva',170),
 (20,'Bolnicki dan',2500),
 (21,'Uzorkovanje krvi (Venepunkcija)',1000),
 (22,'Acidobazni status',650),
 (23,'Bilirubin u serumu',200),
 (24,'Glukoza u serumu',100),
 (25,'Kalijum u serumu',120),
 (26,'Kreatin u serumu',150),
 (27,'Natrijum u serumu',130),
 (28,'Protein u serumu',200),
 (29,'Celokupni pregled urina',250),
 (30,'Bakteroloski pregled brisa nosa',130),
 (31,'Bakteroloski pregled  brisa zdrela',120),
 (32,'Bakteroloski pregled duboke rane',140),
 (33,'Bakteroloski pregled iskasljaja',125),
 (34,'Izolacija mikroorganizma  subkulturom',175),
 (35,'Urinokultura',80),
 (36,'Uklanjanje naslaga',547),
 (37,'Vitalna amputacija',2500),
 (38,'Uklanjanje tumora usne duplje',2000),
 (39,'Uklanjanje konaca ',770),
 (40,'Kraniogram i profil lobanje',3000),
 (41,'Sijalografija',3400),
 (42,'Ultrazvucni pregled',4000),
 (43,'CT pregled',5000),
 (44,'Antisok terapija',2700),
 (45,'Davanje inekcije u dijagnosticke svrhe',350),
 (46,'Obucavanje u odrzavanju licne higijene',1000),
 (47,'Delerova maska',3500),
 (48,'Psihoterapija po seansi',2000),
 (49,'Procena organskog ostecenja',2500),
 (50,'EEG',6000),
 (51,'EMG',4000),
 (52,'Holter',5000),
 (53,'Bojenje krvi',2600),
 (54,'Test motalilteta jajnika',1800),
 (55,'Analna manometrija',4200),
 (56,'Test za ispitivanje stitne zelzde',2500),
 (57,'Logjebergov test',2000),
 (58,'Hemodijaliza',3000),
 (59,'Hemoperfuzija',33000),
 (60,'Transfuzija pune krvi ',1600),
 (61,'Direktna implatacija tkvia',1500),
 (62,'Implantacija hormona',1550),
 (63,'Zracenje celog tela',5000),
 (64,'Zracenje polovine tela',3000),
 (65,'Interni CTG',600),
 (66,'Infuzija',2000),
 (67,'Terapija hladnocom',170),
 (68,'Izrada programa imunizacije',750),
 (69,'Izrada programa ishrane',1200),
 (70,'Uklanjanje bradavica',3500),
 (71,'Laserske terapije',7000),
 (72,'Operacija ciste',8800),
 (73,'Operacija laserom',34000),
 (74,'Splenotomija',10500),
 (75,'Gastrostomija',10200),
 (76,'Hirursko resavanje debelog creva',10700),
 (77,'Laparoskopija',4500),
 (78,'Loboktomija jetre',32000),
 (79,'Trisegmentna resekcija jetre',39000),
 (80,'Holedoskopija',3570),
 (81,'Plasiranje sonde u tanko crevo',5300),
 (82,'Gastricni bajpas',25000),
 (83,'Redukcija zeluca',22000),
 (84,'Pankreaktektomija',36000),
 (85,'Pankreatikojejunostomija',38000),
 (86,'Eksploracija spremicne vrpce',12000),
 (87,'Biopsija testisa',14000),
 (88,'Endoskopski ultrazvuk',7000),
 (89,'Kiseonicki pritisak',190),
 (90,'Tonografija',220),
 (91,'Kapilaroskopija',670),
 (92,'Ekscizija cira na kozi',3500),
 (93,'Radikalna ekscizija limfnih cvorova',4200),
 (94,'Biopsija dojke',8400),
 (95,'Hemoroidektomija',12000),
 (96,'Anorektalni pregled',1700),
 (97,'Karotidni bajpas pomocu vene',27800),
 (98,'Aorto-femoralna endarterektomija',36000),
 (99,'Karotidna endarterektomija',22000),
 (100,'Venska gaft zakrpa',11000),
 (101,'Direktno zatvaranje aksilarne arterije',19000),
 (102,'Direktno zatvaranje aksilarne vene',19000),
 (103,'Direktno zatvaranje tibijalne arterije',19000),
 (104,'Direktno zatvaranje parenoalne arterije',19000),
 (105,'Biopsija temporalne arterije',5500),
 (106,'Transplantacija vene',35000),
 (107,'Angioskopija',7000),
 (108,'Himenektomija',18000),
 (109,'Ginekoloski pregled',1600),
 (110,'Transplatacija bubrega',34000),
 (111,'Zatvorena biopsija bubrega',3500),
 (112,'Ekscizija ciste bubrega otvorena hirurgija',17000),
 (113,'Ureteroskopija',8000),
 (114,'Cistoskopija',8900),
 (115,'Intrakavernozna injekcija',900),
 (116,'Kateterizacija desne strane srca',9200),
 (117,'Kateterizacija leve strane srca',11200),
 (118,'Impnlantacija generatora pejsmejkera',7700),
 (119,'Zamena generatora pejsmejkera',7800),
 (120,'Uklanjanje generatora pejsmejkera',7900),
 (121,'Karioplegija',12000),
 (122,'Mitomija srca',40000),
 (124,'Miektomija srca',42000),
 (125,'Odvajanje priraslica u grudnom kosu',49000),
 (126,'Reparacija aorte',38540),
 (127,'Lumbalna punkcija',1520),
 (128,'Transpozicija nerva',12500),
 (129,'Aspiracija ciste u mozgu',13240),
 (130,'Ugradnja bajpasa',43700),
 (131,'Etmoidotomija',9000),
 (132,'Sinusokopija',2350),
 (133,'Endoskopija nosa',2500),
 (134,'Laringofisura',12590),
 (135,'Laringoplastika',12600),
 (136,'Amputacija iznad linije kolena',17200),
 (137,'Amputacija ispod linije kolena',17200),
 (138,'Amputacija prsta na nozi',3500),
 (139,'Dezartikulacija u kolenu',18200),
 (140,'Portoenterostomija',39400),
 (141,'Transplantat koze i masnog tkiva',13640),
 (142,'Rekonstrukcija bradavice',14000),
 (143,'Rekonstrukcija arote',15200),
 (144,'Liposukcija',18381),
 (145,'Lifting cela,obrva, obostrano',25767),
 (146,'Lifting cela,obrva, jednostrano',16252),
 (147,'Totalna rinoplastika',23690),
 (148,'Revizija rinoplastika',2200),
 (149,'Redukcija velicine usne',5800),
 (150,'Redukcija velicine jezika',9700),
 (151,'Rekonstrukcija ocnog kapka ',4700),
 (152,'Faringoplastika',16100),
 (153,'Opustanje tetive ovojnice sake ',4800),
 (154,'Ostektomija prsta',6300),
 (155,'Imobilizacija preloma tela ',7150),
 (156,'Primena zavoja',4400),
 (157,'Uklanjanje nokta na prstu stopala',2180),
 (158,'Obrada nokta na prstu stopala',2180),
 (159,'Incizija stopala zbog paronihije',1200),
 (160,'Presadjivanje kosti',17400),
 (161,'Osektomija',7360),
 (162,'Fuzija kicme',24820),
 (163,'Ekscizija prsljena',33700),
 (164,'Artrodeza lakta',18100),
 (165,'Patelektomija',9420),
 (166,'Osetoplastika kolena',9350),
 (167,'Rekonstrukcija kolena',19440),
 (168,'Ekscizija trna petne kosti',5390),
 (169,'Plantarna fasciotomija',7640),
 (170,'Produzenje ekstremiteta',37980),
 (171,'Kompjuterizovana tomografija',5700),
 (172,'Holecistografija',1680),
 (173,'Defektografija',2890),
 (174,'Bronhografija',2880),
 (175,'Flebografija',2900),
 (176,'Histerosalpingografija',2880),
 (177,'Dakriocistografija',2900),
 (178,'Radiografska pelvimetrija',2380),
 (179,'Elektrostimulacija',260),
 (180,'Interferentne struje',175),
 (181,'Transcerebralna elektroforeza',360),
 (182,'Blokada gangliona',400),
 (183,'Aortografija',2300),
 (184,'Limfangiografija',4590),
 (185,'Infrazvuk',250),
 (186,'Sonoforeza',200),
 (187,'Hidro-kinezi terapija',450),
 (188,'Vibromasaza',250),
 (189,'Nyllin-ov stepenik',250),
 (190,'Plantogram',300),
 (191,'Vezbe relaksacije',330),
 (192,'Senzitivna hronaksija',300),
 (193,'Rad sa ortopedskim bolesnicima',1750),
 (194,'Direktna ciklopeksija',2000),
 (195,'Lamelarna skleroplastija',6700),
 (196,'Ugradnja sonde za hranjenje',25000),
 (197,'Transplatacija jetre',87000),
 (198,'Operacija pseudociste pankreasa',17500),
 (199,'Sivenje',900),
 (200,'Totalna hepatektomija',34300),
 (201,'Unutrasnji okret ploda',5200),
 (202,'SPECT',6600),
 (203,'Telemetrija',2500),
 (204,'Bi-insulin u serumu',400),
 (205,'Digitoksin u serumu',700),
 (206,'D-ksiloza u serumu',350),
 (207,'Fruktozamin u serumu',400),
 (208,'Folna kiselina u serumu',650),
 (209,'Imunoglobulin',1700),
 (210,'VDRL test',500),
 (211,'RPR test',500),
 (212,'RVK',750),
 (213,'Izolacija virusa gripa',8500),
 (214,'Izolacija enterovirusa',14200),
 (215,'PCR',2780),
 (216,'Pregled celog zeluca',4800),
 (217,'Postavljanje proteze za nogu',1000),
 (218,'Raskidanje blefarorafije',4000),
 (219,'Simerov test',770),
 (220,'Uklanjanje cepa iz punktuma',4220),
 (221,'Konjunktivoplastika',9700),
 (222,'Amputacija usne skoljke',14730),
 (223,'Biopsija nerva',6260),
 (224,'Stavljanje i vadjenje spirale',2000),
 (225,'Ispiranje cerumena',450);
/*!40000 ALTER TABLE `usluga` ENABLE KEYS */;


--
-- Definition of table `zdravstvena_ustanova`
--

DROP TABLE IF EXISTS `zdravstvena_ustanova`;
CREATE TABLE `zdravstvena_ustanova` (
  `Zdravstvena_ustanova_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Naziv_zdravstvene_ustanove` varchar(60) NOT NULL,
  PRIMARY KEY (`Zdravstvena_ustanova_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8887536 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `zdravstvena_ustanova`
--

/*!40000 ALTER TABLE `zdravstvena_ustanova` DISABLE KEYS */;
INSERT INTO `zdravstvena_ustanova` (`Zdravstvena_ustanova_ID`,`Naziv_zdravstvene_ustanove`) VALUES 
 (8671923,'Plucna bolnica Zrenjanin \"Dr Vasa Savic\"'),
 (8877556,'Dom zdravlja Zrenjanin \"Dr Bosko Vrebalov\"'),
 (8887535,'Opsta bolnica Zrenjanin \"Djordje Jovanovic\"');
/*!40000 ALTER TABLE `zdravstvena_ustanova` ENABLE KEYS */;


--
-- Definition of table `zvanje`
--

DROP TABLE IF EXISTS `zvanje`;
CREATE TABLE `zvanje` (
  `Zvanje_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Zvanje` varchar(50) NOT NULL,
  PRIMARY KEY (`Zvanje_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=809001 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `zvanje`
--

/*!40000 ALTER TABLE `zvanje` DISABLE KEYS */;
INSERT INTO `zvanje` (`Zvanje_ID`,`Zvanje`) VALUES 
 (719001,'Dr. Med (Lekar opste prakse)'),
 (729000,'Mr. sc med. (Magistar Medicinskih nauka)'),
 (729073,'Dr. Spec (Lekar specijalista)'),
 (729087,'Prim.dr (Primarijus)'),
 (809000,'Dr. sc. (Doktor Medicinskih nauka)');
/*!40000 ALTER TABLE `zvanje` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
