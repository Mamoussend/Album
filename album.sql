-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 22 jan. 2022 à 21:44
-- Version du serveur :  10.4.19-MariaDB
-- Version de PHP : 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `album`
--

-- --------------------------------------------------------

--
-- Structure de la table `albums`
--

CREATE TABLE `albums` (
  `type` varchar(255) COLLATE armscii8_bin NOT NULL,
  `theme` varchar(255) COLLATE armscii8_bin NOT NULL,
  `proprietaire` varchar(255) COLLATE armscii8_bin NOT NULL,
  `id_album` int(11) NOT NULL,
  `nom` varchar(255) COLLATE armscii8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

--
-- Déchargement des données de la table `albums`
--

INSERT INTO `albums` (`type`, `theme`, `proprietaire`, `id_album`, `nom`) VALUES
('prive', 'momo', '7', 1, 'momo'),
('public', 'Vance au  caraibes', '7', 2, 'Vancances'),
('prive', 'Sortie', '7', 3, 'SORTIE'),
('prive', 'Mariage', '7', 4, 'Mariage'),
('public', 'Paris', '10', 5, 'Tour Effel'),
('public', 'Bankay', '10', 6, 'BlackList'),
('prive', 'wedding,heureux,couple', '7', 7, 'Mariage'),
('prive', 'project', '7', 8, 'jeu'),
('prive', 'Project Jee', '10', 9, 'AlbumAdmin');

-- --------------------------------------------------------

--
-- Structure de la table `image`
--

CREATE TABLE `image` (
  `titre` varchar(255) COLLATE armscii8_bin NOT NULL,
  `description` varchar(255) COLLATE armscii8_bin NOT NULL,
  `hauteur` varchar(255) COLLATE armscii8_bin NOT NULL,
  `largeur` varchar(255) COLLATE armscii8_bin NOT NULL,
  `id_img` int(11) NOT NULL,
  `id_alb` int(11) NOT NULL,
  `chemin` varchar(255) COLLATE armscii8_bin NOT NULL,
  `date_creation` varchar(255) COLLATE armscii8_bin NOT NULL,
  `date_mis_jour` varchar(255) COLLATE armscii8_bin DEFAULT NULL,
  `mots_cles` varchar(255) COLLATE armscii8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

--
-- Déchargement des données de la table `image`
--

INSERT INTO `image` (`titre`, `description`, `hauteur`, `largeur`, `id_img`, `id_alb`, `chemin`, `date_creation`, `date_mis_jour`, `mots_cles`) VALUES
('photos profil', 'cat14.jpg,idalbum', '3652', '2435', 23, 4, '/gesalbum/dossier/cat9.jpg', '20-janv.-22', NULL, 'cat14.jpg,idalbum'),
('Vacance au japon', 'japon,fete,ambiance', '1920', '1280', 24, 2, '/gesalbum/dossier/cat11.jpg', '21-janv.-22', NULL, 'kjnjkn'),
('profile', 'by me', '6016', '4016', 25, 1, '/gesalbum/dossier/cat6.jpg', '21-janv.-22', NULL, 'xfhnhgg'),
('HUssop', 'Profile de Hussop', '6379', '4253', 26, 5, '/gesalbum/dossier/cat21.jpg', '22-janv.-22', NULL, 'mangas,japon,mangakou'),
('Profil2', 'jolie sourrir', '6000', '4000', 27, 1, '/gesalbum/dossier/cat10.jpg', '22-janv.-22', NULL, 'profil,heureux,sourir');

-- --------------------------------------------------------

--
-- Structure de la table `permission`
--

CREATE TABLE `permission` (
  `id_album` int(11) NOT NULL,
  `id_utilisateur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

--
-- Déchargement des données de la table `permission`
--

INSERT INTO `permission` (`id_album`, `id_utilisateur`) VALUES
(1, 7),
(1, 7),
(1, 10),
(1, 7),
(1, 10),
(1, 13),
(1, 15),
(1, 16);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `prenom` varchar(255) COLLATE armscii8_bin NOT NULL,
  `nom` varchar(255) COLLATE armscii8_bin NOT NULL,
  `email` varchar(255) COLLATE armscii8_bin NOT NULL,
  `password` varchar(255) COLLATE armscii8_bin NOT NULL,
  `type` varchar(255) COLLATE armscii8_bin NOT NULL,
  `date_naiss` varchar(255) COLLATE armscii8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `prenom`, `nom`, `email`, `password`, `type`, `date_naiss`) VALUES
(7, 'omomo', 'momo', 'ndiaye@esp.sn', '4a31af7e3bf920239001120619dc794f', 'utilisateur', '2022-01-06 '),
(10, 'Mamousse', 'Ndiaye', 'momo@esp.sn', 'c0a0b02d51c17ae33e98b06d222ce86c', 'admin', '2002-06-01'),
(13, 'AHMET', 'DIOP', 'ahmet@diop.sn', '0c6cf40157cd06a1ce1a249ecd557b02', 'admin', '1981-04-27'),
(15, 'Mamadou', 'Ndiaye', 'mamadou@ndaiye.sn', '4a31af7e3bf920239001120619dc794f', 'utilisateur', '1985-06-11'),
(17, 'Ndiaye', 'Ababacar', 'aba@esp.sn', '3aa8bc2be13cdd5c83212445e43b0a6c', 'admin', '2022-01-05 ');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `albums`
--
ALTER TABLE `albums`
  ADD PRIMARY KEY (`id_album`);

--
-- Index pour la table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`id_img`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `albums`
--
ALTER TABLE `albums`
  MODIFY `id_album` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `image`
--
ALTER TABLE `image`
  MODIFY `id_img` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
