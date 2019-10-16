-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-10-2019 a las 01:24:05
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `catalogodocentesop`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `course`
--

CREATE TABLE `course` (
  `idCourse` int(11) NOT NULL,
  `idTeacher` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `themes` varchar(100) NOT NULL,
  `project` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `course`
--

INSERT INTO `course` (`idCourse`, `idTeacher`, `name`, `themes`, `project`) VALUES
(4, 1733920948, 'Matematicas diferenciales', 'Calculo diferencial', 'examen final 1'),
(8, 1331231241, 'Escenas 3', 'Creatividad', 'examen final 1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `social_media`
--

CREATE TABLE `social_media` (
  `idSocialMedia` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `icon` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `social_media`
--

INSERT INTO `social_media` (`idSocialMedia`, `name`, `icon`) VALUES
(3, 'los guerreros', 'IMG-20171031-WA0003.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `teacher`
--

CREATE TABLE `teacher` (
  `idTeacher` int(11) NOT NULL,
  `cedula` varchar(255) NOT NULL,
  `name` varchar(50) NOT NULL,
  `avatar` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `teacher`
--

INSERT INTO `teacher` (`idTeacher`, `cedula`, `name`, `avatar`) VALUES
(9, '1733920948', 'Sebastian', 'IMG-20171031-WA0007.jpg'),
(10, '4775993800', 'Juan felipe', 'IMG-20171031-WA0008.jpg'),
(11, '1331231241', 'Rodrigo', 'IMG-20171031-WA0010.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tsocialmedia`
--

CREATE TABLE `tsocialmedia` (
  `idTeacherSocialMedia` int(11) NOT NULL,
  `idTeacher` int(11) NOT NULL,
  `idSocialMedia` int(11) NOT NULL,
  `nickname` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`idCourse`),
  ADD KEY `idTeacher` (`idTeacher`);

--
-- Indices de la tabla `social_media`
--
ALTER TABLE `social_media`
  ADD PRIMARY KEY (`idSocialMedia`);

--
-- Indices de la tabla `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`idTeacher`);

--
-- Indices de la tabla `tsocialmedia`
--
ALTER TABLE `tsocialmedia`
  ADD PRIMARY KEY (`idTeacherSocialMedia`),
  ADD KEY `idTeacher` (`idTeacher`,`idSocialMedia`),
  ADD KEY `idSocialMedia` (`idSocialMedia`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `course`
--
ALTER TABLE `course`
  MODIFY `idCourse` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `social_media`
--
ALTER TABLE `social_media`
  MODIFY `idSocialMedia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `teacher`
--
ALTER TABLE `teacher`
  MODIFY `idTeacher` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `tsocialmedia`
--
ALTER TABLE `tsocialmedia`
  MODIFY `idTeacherSocialMedia` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_1` FOREIGN KEY (`idTeacher`) REFERENCES `teacher` (`idTeacher`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `tsocialmedia`
--
ALTER TABLE `tsocialmedia`
  ADD CONSTRAINT `tsocialmedia_ibfk_1` FOREIGN KEY (`idTeacher`) REFERENCES `teacher` (`idTeacher`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tsocialmedia_ibfk_2` FOREIGN KEY (`idSocialMedia`) REFERENCES `social_media` (`idSocialMedia`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
