drop database if exists Encuestas;
create database if not exists Encuestas;
use Encuestas;

-- ******************************************************************
-- Estructura de las Tablas de la Base de Datos
-- ******************************************************************

-- ******************************************************************
-- Estructura de la Tabla UnidadAprendizaje
-- ******************************************************************
drop table if exists UnidadAprendizaje;

create table UnidadAprendizaje(
	idUnidadAprendizaje char(5) not null primary key,
	nombreUnidadAprendizaje varchar(100) 	
);


-- ******************************************************************
-- Estructura de la Tabla Alumno
-- ******************************************************************
drop table if exists Alumno;
create table Alumno(
	noBoleta char(11) not null primary key,
	apellidoPaterno varchar(50) not null,
	apellidoMaterno varchar(50) not null,
	nombre  varchar(50) not null,
    CURP varchar(30) not null,
	email  varchar(100) default 'sinemail@sinemail.com'
);


-- ******************************************************************
-- Estructura de la Tabla Grupos
-- ******************************************************************
drop table if exists Grupo;
create table Grupo(
	idGrupo int not null auto_increment primary key,
    secuencia char(7) not null,
    nivelSemestre int not null,
	idUnidadAprendizaje char(5) not null ,
	noBoleta char(11) not null,
	foreign key (idUnidadAprendizaje) references UnidadAprendizaje(idUnidadAprendizaje) on update cascade on delete cascade,
	foreign key (noBoleta) references Alumno(noBoleta) on update cascade on delete cascade	
);