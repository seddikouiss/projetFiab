
CREATE TABLE IF NOT EXISTS `Etudiant` (
  `idEtud` varchar(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  PRIMARY KEY (`idEtud`)
);
CREATE TABLE IF NOT EXISTS `Prof` (
  `idUniv` int(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  PRIMARY KEY (`idUniv`)
);
CREATE TABLE IF NOT EXISTS `UE` (
  `nom` varchar(30) NOT NULL,
  PRIMARY KEY (`nom`)
);

CREATE TABLE IF NOT EXISTS `Noter` (
	`id_Etudiant` varchar(30) NOT NULL,
  	`id_Ue` varchar(30) NOT NULL,
  	`Note` int(3) NOT NULL,
	PRIMARY KEY (`id_Etudiant`,`id_Ue`),
   	FOREIGN KEY (id_Etudiant) REFERENCES Etudiant(idEtud),
	FOREIGN KEY (id_Ue) REFERENCES UE(nom)
);
CREATE TABLE IF NOT EXISTS `Enseigner` (
	`id_Ue` varchar(30) NOT NULL,
  	`id_Prof` int(30) NOT NULL,
	PRIMARY KEY (`id_Ue`,`id_Prof`),
   	FOREIGN KEY (id_Ue) REFERENCES UE(nom),
	FOREIGN KEY (id_Prof) REFERENCES Prof(idUniv)
);

INSERT INTO `Etudiant`  VALUES
('M1', 'BEN NASR', 'MERIEM'),
('C1', 'AMRANI', 'CHIBLA'),
('P1', 'BRUNET', 'PIERRE'),
('S1', 'OUISS', 'SEDDIK');


INSERT INTO `Prof`  VALUES
(1, 'LUGIEZ', 'DENIS'),
(2, 'MASSAT', 'JEAN-LUC'),
(3, 'AGOPIAN', 'ROLAND'),
(4, 'BROCHE', 'MARTINE');

INSERT INTO `UE`  VALUES
( 'FIABILITE 1'),
('JEE'),
('SYSTEME HETEROGENE'),
('COMMUNICATION');

INSERT INTO `Noter`  VALUES
('C1', 'FIABILITE 1', 20),
('M1', 'FIABILITE 1', 20),
('P1', 'FIABILITE 1', 20),
('S1', 'FIABILITE 1', 20);

INSERT INTO `Enseigner`  VALUES
('FIABILITE 1', 1),
('JEE',2),
('SYSTEME HETEROGENE', 3),
('COMMUNICATION', 4);

