-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2018-07-07 03:28:02
-- 服务器版本： 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studentselect`
--

-- --------------------------------------------------------

--
-- 表的结构 `house`
--

CREATE TABLE `house` (
  `houId` int(11) NOT NULL,
  `houAddress` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `population` varchar(255) NOT NULL,
  `rentPrice` decimal(10,2) NOT NULL,
  `renOrNot` varchar(2) NOT NULL,
  `reason` varchar(255) NOT NULL,
  `postTime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `house`
--

INSERT INTO `house` (`houId`, `houAddress`, `type`, `population`, `rentPrice`, `renOrNot`, `reason`, `postTime`) VALUES
(1, '厦门市集美区集美大道224号', '单间', '2', '1200.00', '可以', '无', '2018-07-02 00:00:00'),
(2, '厦门市集美区集美大道225号', '套间', '3', '1500.00', '可以', '无', '2018-07-03 00:00:00'),
(6, '厦门集美区集美大道100号', '单间', '2', '1200.00', '可以', '无', '2018-07-02 00:00:00'),
(10, '集美区集美大道130号', '套间', '4', '2000.00', '可以', '无', '2018-07-06 00:00:00'),
(32, '集美区集美大道130号', '套间', '4', '2000.00', '可以', '无', '2018-07-06 00:00:00');

-- --------------------------------------------------------

--
-- 表的结构 `landlord`
--

CREATE TABLE `landlord` (
  `lanName` varchar(8) NOT NULL,
  `lanId` int(10) NOT NULL,
  `lanAddress` varchar(255) NOT NULL,
  `lanPhoneNumber` varchar(11) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `landlord`
--

INSERT INTO `landlord` (`lanName`, `lanId`, `lanAddress`, `lanPhoneNumber`, `password`) VALUES
('张西安西', 14785, '集美大道441号', '15623567441', '123456'),
('严先问', 147855, '集美大道558号', '15623567478', '123456'),
('李大贤', 152585, '集美大道58号', '15858792585', '123456');

-- --------------------------------------------------------

--
-- 表的结构 `notice`
--

CREATE TABLE `notice` (
  `time` datetime NOT NULL,
  `place` varchar(255) NOT NULL,
  `landlordName` varchar(255) NOT NULL,
  `studentName` varchar(255) NOT NULL,
  `houseId` int(11) NOT NULL,
  `landlordTel` varchar(11) NOT NULL,
  `studentTel` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `notice`
--

INSERT INTO `notice` (`time`, `place`, `landlordName`, `studentName`, `houseId`, `landlordTel`, `studentTel`) VALUES
('2018-07-24 12:00:00', '西街41号', '张三', '李四', 14785, '15785238589', '15789562320'),
('2018-07-12 10:00:00', '西街老塞', '张大仙', '雁先闻', 145663, '15785236989', '15789562352');

-- --------------------------------------------------------

--
-- 表的结构 `student`
--

CREATE TABLE `student` (
  `stuName` varchar(255) NOT NULL,
  `stuId` int(11) NOT NULL,
  `stuAddress` varchar(255) NOT NULL,
  `stuPhoneNumber` varchar(11) NOT NULL,
  `birthDate` date NOT NULL,
  `gender` varchar(4) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `student`
--

INSERT INTO `student` (`stuName`, `stuId`, `stuAddress`, `stuPhoneNumber`, `birthDate`, `gender`, `password`) VALUES
('李四', 162513, '集美大道668号', '17889657485', '1997-07-22', '男', '12345'),
('张大仙', 162516, '集美大道668号', '17859713925', '1996-10-04', '男', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `house`
--
ALTER TABLE `house`
  ADD PRIMARY KEY (`houId`);

--
-- Indexes for table `landlord`
--
ALTER TABLE `landlord`
  ADD PRIMARY KEY (`lanId`);

--
-- Indexes for table `notice`
--
ALTER TABLE `notice`
  ADD PRIMARY KEY (`houseId`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`stuId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
