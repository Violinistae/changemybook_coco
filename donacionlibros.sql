-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-06-2018 a las 09:32:21
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `donacionlibros`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `Id_Compra` int(11) NOT NULL,
  `Comprador` int(11) NOT NULL,
  `Publicacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `foro`
--

CREATE TABLE `foro` (
  `Id_Mens` int(11) NOT NULL,
  `Mensaje` text NOT NULL,
  `Remitente` int(11) NOT NULL,
  `Fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `publicacion`
--

CREATE TABLE `publicacion` (
  `Id_Pub` int(11) NOT NULL,
  `Texto` text NOT NULL,
  `Publicador` int(11) NOT NULL,
  `Precio` int(11) NOT NULL,
  `Foto` varchar(120) NOT NULL,
  `EstadoP` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `res_foro`
--

CREATE TABLE `res_foro` (
  `Id_RF` int(11) NOT NULL,
  `RespuestaM` text NOT NULL,
  `Remitente` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `Mensaje` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Id_U` int(11) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(120) NOT NULL,
  `Creditos` varchar(120) NOT NULL,
  `Hash` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`Id_Compra`),
  ADD KEY `Comprador` (`Comprador`),
  ADD KEY `Publicacion` (`Publicacion`);

--
-- Indices de la tabla `foro`
--
ALTER TABLE `foro`
  ADD PRIMARY KEY (`Id_Mens`),
  ADD KEY `Remitente` (`Remitente`);

--
-- Indices de la tabla `publicacion`
--
ALTER TABLE `publicacion`
  ADD PRIMARY KEY (`Id_Pub`),
  ADD KEY `Publicador` (`Publicador`);

--
-- Indices de la tabla `res_foro`
--
ALTER TABLE `res_foro`
  ADD PRIMARY KEY (`Id_RF`),
  ADD KEY `Remitente` (`Remitente`),
  ADD KEY `Mensaje` (`Mensaje`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Id_U`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
  MODIFY `Id_Compra` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `foro`
--
ALTER TABLE `foro`
  MODIFY `Id_Mens` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `publicacion`
--
ALTER TABLE `publicacion`
  MODIFY `Id_Pub` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `res_foro`
--
ALTER TABLE `res_foro`
  MODIFY `Id_RF` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `Id_U` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`Comprador`) REFERENCES `usuario` (`Id_U`),
  ADD CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`Publicacion`) REFERENCES `publicacion` (`Id_Pub`);

--
-- Filtros para la tabla `foro`
--
ALTER TABLE `foro`
  ADD CONSTRAINT `foro_ibfk_1` FOREIGN KEY (`Remitente`) REFERENCES `usuario` (`Id_U`);

--
-- Filtros para la tabla `publicacion`
--
ALTER TABLE `publicacion`
  ADD CONSTRAINT `publicacion_ibfk_1` FOREIGN KEY (`Publicador`) REFERENCES `usuario` (`Id_U`);

--
-- Filtros para la tabla `res_foro`
--
ALTER TABLE `res_foro`
  ADD CONSTRAINT `res_foro_ibfk_1` FOREIGN KEY (`Remitente`) REFERENCES `usuario` (`Id_U`),
  ADD CONSTRAINT `res_foro_ibfk_2` FOREIGN KEY (`Mensaje`) REFERENCES `foro` (`Id_Mens`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
