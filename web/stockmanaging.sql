-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Jeu 05 Mars 2015 à 16:29
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `stockmanaging`
--
CREATE DATABASE IF NOT EXISTS `stockmanaging` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `stockmanaging`;

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `idCategory` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idCategory`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `category`
--

INSERT INTO `category` (`idCategory`, `label`) VALUES
(1, 'Football'),
(2, 'Tennis'),
(3, 'Ping-Pong'),
(4, 'Basketball');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `command`
--

CREATE TABLE IF NOT EXISTS `command` (
  `idCommand` int(11) NOT NULL AUTO_INCREMENT,
  `client` tinyblob,
  `dateCde` datetime DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `total` float NOT NULL,
  PRIMARY KEY (`idCommand`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `commandline`
--

CREATE TABLE IF NOT EXISTS `commandline` (
  `idCommandLine` int(11) NOT NULL AUTO_INCREMENT,
  `amount` float DEFAULT NULL,
  `Command` int(11) DEFAULT NULL,
  `Product` int(11) DEFAULT NULL,
  PRIMARY KEY (`idCommandLine`),
  KEY `FK_oaxxei0xgbd8yp5hvdd4ejkak` (`Command`),
  KEY `FK_g32kv2nf4tsjadxt446afr6x6` (`Product`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `idEmployee` int(11) NOT NULL AUTO_INCREMENT,
  `mail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idEmployee`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `employee`
--

INSERT INTO `employee` (`idEmployee`, `mail`, `name`, `password`, `surname`) VALUES
(1, NULL, NULL, NULL, NULL),
(2, 'john@free.fr', 'Doe', 'John', 'jojo'),
(3, 'tintin@free.fr', 'le reporter', 'tintin', 'toi'),
(4, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `idProduct` int(11) NOT NULL AUTO_INCREMENT,
  `color` varchar(255) DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  `price` float NOT NULL,
  `productSize` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `idSupplier` int(11) DEFAULT NULL,
  PRIMARY KEY (`idProduct`),
  KEY `FK_o6in9qh20voprkrksfjmusxts` (`type`),
  KEY `FK_th40yg4ju6f41bjjywdtjbc0j` (`idSupplier`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `productcategory`
--

CREATE TABLE IF NOT EXISTS `productcategory` (
  `idCategory` int(11) NOT NULL,
  `idProduct` int(11) NOT NULL,
  KEY `FK_dtj0pvc0no4wxjhsccgwdwo1a` (`idProduct`),
  KEY `FK_i4c9t1qindv2b9sutxs0ufd1i` (`idCategory`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `producttype`
--

CREATE TABLE IF NOT EXISTS `producttype` (
  `idProductType` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idProductType`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `producttype`
--

INSERT INTO `producttype` (`idProductType`, `label`) VALUES
(1, 'Chaussure'),
(2, 'Balle'),
(3, 'Raquette'),
(4, 'Maillot');

-- --------------------------------------------------------

--
-- Structure de la table `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
  `id_supplier` int(11) NOT NULL AUTO_INCREMENT,
  `brand` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_supplier`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `supplier`
--

INSERT INTO `supplier` (`id_supplier`, `brand`, `mail`, `name`, `password`, `surname`) VALUES
(1, 'SONY', 'sony@free.fr', 'John', 'Sony', 'Sony'),
(2, 'siemens', 'siemens@free.fr', 'Mark', 'Mark', 'Bill');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `commandline`
--
ALTER TABLE `commandline`
  ADD CONSTRAINT `FK_g32kv2nf4tsjadxt446afr6x6` FOREIGN KEY (`Product`) REFERENCES `product` (`idProduct`),
  ADD CONSTRAINT `FK_oaxxei0xgbd8yp5hvdd4ejkak` FOREIGN KEY (`Command`) REFERENCES `command` (`idCommand`);

--
-- Contraintes pour la table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK_th40yg4ju6f41bjjywdtjbc0j` FOREIGN KEY (`idSupplier`) REFERENCES `supplier` (`id_supplier`),
  ADD CONSTRAINT `FK_o6in9qh20voprkrksfjmusxts` FOREIGN KEY (`type`) REFERENCES `producttype` (`idProductType`);

--
-- Contraintes pour la table `productcategory`
--
ALTER TABLE `productcategory`
  ADD CONSTRAINT `FK_i4c9t1qindv2b9sutxs0ufd1i` FOREIGN KEY (`idCategory`) REFERENCES `category` (`idCategory`),
  ADD CONSTRAINT `FK_dtj0pvc0no4wxjhsccgwdwo1a` FOREIGN KEY (`idProduct`) REFERENCES `product` (`idProduct`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
