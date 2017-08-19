-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 19, 2017 at 06:23 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sistem_za_rezervaciju_karata`
--

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE `film` (
  `id` int(11) NOT NULL,
  `drzava` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `duzina_trajanja` int(3) DEFAULT NULL,
  `godina` varchar(4) COLLATE utf8mb4_bin DEFAULT NULL,
  `naslov` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `originalni_naslov` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `pocetak_prikazivanja` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `zanr` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `opis` varchar(4000) COLLATE utf8mb4_bin DEFAULT NULL,
  `youtube_url` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`id`, `drzava`, `duzina_trajanja`, `godina`, `naslov`, `originalni_naslov`, `pocetak_prikazivanja`, `zanr`, `opis`, `youtube_url`) VALUES
(10, 'USA', 90, '2017', 'Grozan ja 3', 'Despicable Me 3', '2017-06-29', NULL, 'Nakon Ã?Â¡to je otpuÃ?Â¡ten iz Lige protiv zlikovaca, zbog neuspeha da uhvati poslednjeg loÃ?Â¡eg momka koji je pripretio celom Ã??oveÃ??anstvu, Gru ulazi u veliku krizu identiteta. Ali kada se misteriozni stranac pojavi kako bi obavestio Grua da ima davno izgubljenog brata blizanca Ã¢?? koji oÃ??ajniÃ??ki Ã?Â¾eli da krene stopama svog brata Grua Ã¢?? nekadaÃ?Â¡nji super negativac Ã??e ponovo otkriti kako je dobro biti loÃ?Â¡. NebojÃ?Â¡a DugaliÃ?? (Stiv Karel) ne samo da nam ponovo na fantastiÃ??an naÃ??in doÃ??arava Grua, ovaj put ga zatiÃ??emo i u drugoj ulozi Ã¢?? Drua, Gruovog davno izgubljenog brata blizanca. Mina LazareviÃ?? (Kristen Vig) vraÃ??a nam se kao super Ã?Â¡pijun Lusi, dok je u ulozi novog glavnog negativca Baltazara Breta, bivÃ?Â¡e zvezde programa za decu, koji je postao opsednut zlim TV likom koga je igrao 80-ih, Ã?Â½ika MilenkoviÃ?? (Trej Parker). Gruov najimpresivniji protivnik do sada, Bret je odluÃ??an da pokori HolivudÃ¢?Â¦i svakoga ko mu se naÃ??e na putu.', 'https://www.youtube.com/embed/3rRIuk0ZwL0'),
(11, 'USA', 133, '2017', 'Spajdermen: Povratak kuci', 'Spider-Man: Homecoming', '2017-07-06', NULL, 'Mladi britanski glumac Tom Holand odliÃ??no se snaÃ?Â¡ao u ulozi Pitera Parkera/Spajdermena. Senzacionalni debi u ovoj ulozi ostvario je u hitu Ã¢??Kapetan Amerika: GraÃ??anski ratÃ¢??, kako ujedno i poÃ??inje njegov prvi samostalni film Ã¢??Spajdermen: Povratak kuÃ??iÃ¢??. UzbuÃ??en zbog iskustva koje je doÃ?Â¾iveo sa Osvetnicima, Piter se vraÃ??a kuÃ??i u kojoj Ã?Â¾ivi sa tetkom Mej (Marisa Tomej), gde ga pod budnim okom Ã??uva njegov novi mentor Toni Stark (Robert Dauni DÃ?Â¾unior). Piter pokuÃ?Â¡ava da se vrati svojoj normalnoj svakodnevnoj rutini, iako ga u tome spreÃ??avaju misli kako joÃ?Â¡ uvek mora da se dokaÃ?Â¾e kao pravi superherojÃ¢?Â¦ A pravi trenutak za to Ã??e moÃ?Â¾da doÃ??i i mnogo ranije nego Ã?Â¡to se Piter nadao, kada se u gradu pojavi novi zlikovac - LeÃ?Â¡inar (Majkl Kiton).', 'https://www.youtube.com/embed/oNE0zRNyXuc'),
(12, 'Srbija', 30, '2017', 'title', 'orig', '2017-12-31', 'Akcija', 'test', 'a');

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `id` int(11) NOT NULL,
  `datum_rodjenja` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `ime` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `pol` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `prezime` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`id`, `datum_rodjenja`, `email`, `ime`, `password`, `pol`, `prezime`, `username`) VALUES
(29, '1994-03-30', 'darkomisic94@gmail.com', 'Darko', 'darko', 'MuÅ¡ki', 'Misic', 'darko'),
(31, '1994-09-12', 'mary.mary_94@hotmail.com', 'Marija', 'maria12', 'Å½enski', 'Misic', 'makica12');

-- --------------------------------------------------------

--
-- Table structure for table `projekcija`
--

CREATE TABLE `projekcija` (
  `id` int(11) NOT NULL,
  `slobodno_sedista` int(11) DEFAULT NULL,
  `film_id` int(11) DEFAULT NULL,
  `sala_id` int(11) DEFAULT NULL,
  `datum` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `vreme` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `projekcija`
--

INSERT INTO `projekcija` (`id`, `slobodno_sedista`, `film_id`, `sala_id`, `datum`, `vreme`) VALUES
(14, 27, 10, 3, '2017-08-18', '12:00'),
(17, 37, 10, 1, '2017-08-17', '12:00'),
(18, 0, 10, 2, '2017-08-18', '12:00'),
(19, 8, 11, 4, '2017-08-21', '15:00');

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

CREATE TABLE `rezervacija` (
  `id` int(11) NOT NULL,
  `broj_karata` int(11) DEFAULT NULL,
  `korisnik_id` int(11) DEFAULT NULL,
  `projekcija_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`id`, `broj_karata`, `korisnik_id`, `projekcija_id`) VALUES
(3, 5, 29, 17),
(4, 5, 29, 17),
(5, 5, 29, 18),
(6, 5, 29, 18),
(7, 5, 29, 18),
(8, 5, 29, 18),
(9, 5, 29, 18),
(10, 5, 29, 18),
(11, 5, 29, 18),
(12, 5, 29, 18),
(13, 5, 29, 18),
(14, 5, 29, 18),
(15, 5, 29, 18),
(16, 5, 29, 18),
(17, 3, 29, 17),
(18, 5, 29, 17),
(19, 3, 29, 14),
(20, 3, 31, 17),
(21, 2, 31, 19);

-- --------------------------------------------------------

--
-- Table structure for table `sala`
--

CREATE TABLE `sala` (
  `id` int(11) NOT NULL,
  `broj_sedista` int(11) DEFAULT NULL,
  `naziv` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `tehnologija` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `sala`
--

INSERT INTO `sala` (`id`, `broj_sedista`, `naziv`, `tehnologija`) VALUES
(1, 50, 'Sala 1', '3D'),
(2, 60, 'Sala 2', '2D'),
(3, 30, 'Sala 3', '2D'),
(4, 10, 'Sala 4', '2D');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(45) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(45) COLLATE utf8mb4_bin NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('aaa', 'aaa', 1),
('admin', 'admin', 1),
('darko', 'darko', 1),
('makica12', 'maria12', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL,
  `username` varchar(45) COLLATE utf8mb4_bin NOT NULL,
  `role` varchar(45) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_role_id`, `username`, `role`) VALUES
(2, 'admin', 'ROLE_ADMIN'),
(28, 'aaa', 'ROLE_USER'),
(1, 'admin', 'ROLE_USER'),
(27, 'darko', 'ROLE_USER'),
(29, 'makica12', 'ROLE_USER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `projekcija`
--
ALTER TABLE `projekcija`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8AFDCB6054A62AB4` (`sala_id`),
  ADD KEY `FK8AFDCB60B29B9714` (`film_id`);

--
-- Indexes for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKB0AC91DC345B4994` (`korisnik_id`),
  ADD KEY `FKB0AC91DC53C3AE14` (`projekcija_id`);

--
-- Indexes for table `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_role_id`),
  ADD UNIQUE KEY `uni_username_role` (`role`,`username`),
  ADD KEY `fk_username_idx` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `film`
--
ALTER TABLE `film`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT for table `projekcija`
--
ALTER TABLE `projekcija`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `rezervacija`
--
ALTER TABLE `rezervacija`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `sala`
--
ALTER TABLE `sala`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `user_roles`
--
ALTER TABLE `user_roles`
  MODIFY `user_role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD CONSTRAINT `FKB0AC91DC345B4994` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`id`),
  ADD CONSTRAINT `FKB0AC91DC53C3AE14` FOREIGN KEY (`projekcija_id`) REFERENCES `projekcija` (`id`);

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
