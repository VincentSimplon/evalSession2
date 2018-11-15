#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: region
#------------------------------------------------------------

CREATE TABLE region(
        regionId Int  Auto_increment  NOT NULL ,
        nom      Varchar (50) NOT NULL
	,CONSTRAINT region_PK PRIMARY KEY (regionId)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Apprenant
#------------------------------------------------------------

CREATE TABLE Apprenant(
        apprenantId   Int  Auto_increment  NOT NULL ,
        nom           Varchar (50) NOT NULL ,
        prenom        Varchar (50) NOT NULL ,
        dateNaissance Date NOT NULL ,
        mail          Varchar (50) NOT NULL ,
        photo         Varchar (50) NOT NULL ,
        regionId      Int NOT NULL
	,CONSTRAINT Apprenant_PK PRIMARY KEY (apprenantId)

	,CONSTRAINT Apprenant_region_FK FOREIGN KEY (regionId) REFERENCES region(regionId)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: activite
#------------------------------------------------------------

CREATE TABLE activite(
        activiteId     Int  Auto_increment  NOT NULL ,
        numeroActivite Varchar (50) NOT NULL ,
        nomActivite    Varchar (50) NOT NULL
	,CONSTRAINT activite_PK PRIMARY KEY (activiteId)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Avoir
#------------------------------------------------------------

CREATE TABLE Avoir(
        activiteId  Int NOT NULL ,
        apprenantId Int NOT NULL
	,CONSTRAINT Avoir_PK PRIMARY KEY (activiteId,apprenantId)

	,CONSTRAINT Avoir_activite_FK FOREIGN KEY (activiteId) REFERENCES activite(activiteId)
	,CONSTRAINT Avoir_Apprenant0_FK FOREIGN KEY (apprenantId) REFERENCES Apprenant(apprenantId)
)ENGINE=InnoDB;

INSERT INTO region (`regionId`,`nom`) VALUES
( 1, 'Ile de France'),
( 2, 'Pays de la Loire'),
( 3, 'Aquitaine');

SELECT * FROM region;

INSERT INTO activite ( `activiteId` , `numeroActivite` , `nomActivite` ) VALUES
( 1, '001', 'Programmer en java'),
( 2, '002', 'Ecouter les mouches'),
( 3, '003', 'Jouer au bilboquet'),
( 4, '004', 'Dormir pendant le cours'),
( 5, '005', 'Chercher un stage à Haiti'),
( 6, '006', 'Attendre les vacances'),
( 7, '007', 'Prendre le goûter'),
( 8, '008', 'Caresser le chat'),
( 9, '009', 'Ecouter de la musique'),
( 10, '010', 'Rien faire'),
( 11, '011', 'Jouer à Angular'),
( 12, '012', 'Rever'),
( 13, '013', 'Travailler jour et nuit');

SELECT * FROM activite;

INSERT INTO apprenant ( `apprenantId` , `nom` , `prenom` , `dateNaissance` , `mail` , `photo` , `regionId` ) VALUES
( 2, 'Filine', 'Nicolas', '1986-08-07','nicolas.filine@laposte.fr', ' ' , 1),
( 3, 'Gorce', 'Pierre', '1976-01-05','pierrexgorce@gmail.com', ' ' , 1),
( 4, 'Joblon', 'Samuel', '1973-10-18','samuel.joblon@gmail.com', ' ' , 1),
( 5, 'Phoneprasong', 'Khamvongsa', '1985-05-26','pomlao@hotmail.com', ' ' , 2),
( 6, 'Lebegue', 'Vincent', '1986-08-13','vincent.lebegue@labanquepostale.fr', ' ' , 1),
( 7, 'Londeix', 'Matthieu', '1981-05-19','matthieu.londeix@laposte.fr', ' ' , 2),
( 8, 'Longueville', 'Thomas', '1972-04-26','thomas.longueville@laposte.fr', ' ' , 2),
( 9, 'Métivier', 'Christine', '1980-04-29','christine.pereira@laposte.fr', ' ' , 1),
( 10, 'Laurent', 'Picard', '1972-05-23', 'laurent2.picard@laposte.fr', '', 1),
( 11, 'David', 'Pouline','1982-07-07', 'david.pouline@facteo.fr', '', 3),
( 12, 'Julien', 'Prod homme','1990-08-31', 'prodhomme.julien@gmail.com', '', 1),
( 13, 'Samuel', 'Sabot','1980-04-10', 'samuel.sabot@facteo.fr', '', 3),
( 14, 'Sancesario', 'Salvatore', '1975-05-10','salvatore.sancesario@facteo.fr', ' ' , 1),
( 15, 'Sylvestre', 'David', '1986-07-06','david.sylvestre@mfacteur.fr', ' ' , 2),
( 16, 'Tressous', 'Cedric', '1984-08-08','cedric.tressous@gmail.com', ' ' , 2),
( 17, 'Zébutruc', 'Zébulon', '1977-03-13','zebulonzeb@free.fr', ' ' , 2);

SELECT * FROM apprenant;

INSERT INTO avoir (activiteId, apprenantId)
Values
(1,1),
(3,1),
(5,1),
(2,2),
(4,2),
(6,2),
(7,3),
(8,4),
(10,4),
(6,5),
(4,5),
(2,5),
(1,6),
(3,6),
(5,6),
(2,7),
(4,7),
(6,7),
(8,8),
(10,8),
(9,8),
(1,9),
(3,9),
(5,9),
(11,10),
(2,11),
(4,11),
(6,11),
(1,12),
(3,12),
(5,12),
(11,13),
(8,14),
(10,14),
(1,15),
(3,15),
(5,15),
(8,16);