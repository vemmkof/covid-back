drop database if exists Encuestas;
create database Encuestas;
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
  idGrupo int(11) not null AUTO_INCREMENT,
  secuencia char(7) not null,
  nivelSemestre int(11) not null,
  idUnidadAprendizaje char(5) not null,
  noBoleta char(11) not null,
  primary key (idGrupo),
  INDEX idUnidadAprendizaje (idUnidadAprendizaje asc),
  INDEX noBoleta (noBoleta asc),
  constraint Grupo_ibfk_1
    foreign key (idUnidadAprendizaje)
    references UnidadAprendizaje (idUnidadAprendizaje)
    on delete CascADE
    on update CascADE,
  constraint Grupo_ibfk_2
    foreign key (noBoleta)
    references Alumno (noBoleta)
    on delete CascADE
    on update CascADE
);


-- ******************************************************************
-- Estructura de la Tabla Plataforma
-- ******************************************************************
drop table if exists Plataforma;
create table Plataforma (
  idPlataforma int not null AUTO_INCREMENT,
  nombrePlataforma varchar(100) not null,
  primary key (idPlataforma)
);


-- ******************************************************************
-- Estructura de la Tabla MedioComunicacion
-- ******************************************************************
drop table if exists MedioComunicacion;
create table MedioComunicacion (
  idMedioComunicacion int not null AUTO_INCREMENT,
  nombreMedioComunicacion varchar(100) not null,
  primary key (idMedioComunicacion)
);


-- ******************************************************************
-- Estructura de la Tabla Porcentaje
-- ******************************************************************
drop table if exists Porcentaje;
create table Porcentaje (
  idPorcentaje int not null,
  cantidad varchar(15) not null,
  primary key (idPorcentaje)
);


-- ******************************************************************
-- Estructura de la Tabla Grupo_has_Plataforma
-- ******************************************************************
drop table if exists Grupo_has_Plataforma;
create table Grupo_has_Plataforma (
  Grupo_idGrupo int(11) not null,
  Plataforma_idPlataforma int not null,
  primary key (Grupo_idGrupo, Plataforma_idPlataforma),
  INDEX fk_Grupo_has_Plataforma_Plataforma1_idx (Plataforma_idPlataforma asc),
  INDEX fk_Grupo_has_Plataforma_Grupo1_idx (Grupo_idGrupo asc),
  constraint fk_Grupo_has_Plataforma_Grupo1
    foreign key (Grupo_idGrupo)
    references Grupo (idGrupo)
    on delete NO ACTION
    on update NO ACTION,
  constraint fk_Grupo_has_Plataforma_Plataforma1
    foreign key (Plataforma_idPlataforma)
    references Plataforma (idPlataforma)
    on delete NO ACTION
    on update NO ACTION
);


-- ******************************************************************
-- Estructura de la Tabla Grupo_has_MedioComunicacion
-- ******************************************************************
drop table if exists Grupo_has_MedioComunicacion;
create table Grupo_has_MedioComunicacion (
  Grupo_idGrupo int(11) not null,
  MedioComunicacion_idMedioComunicacion int not null,
  primary key (Grupo_idGrupo, MedioComunicacion_idMedioComunicacion),
  INDEX fk_Grupo_has_MedioComunicacion_MedioComunicacion1_idx (MedioComunicacion_idMedioComunicacion asc),
  INDEX fk_Grupo_has_MedioComunicacion_Grupo1_idx (Grupo_idGrupo asc),
  constraint fk_Grupo_has_MedioComunicacion_Grupo1
    foreign key (Grupo_idGrupo)
    references Grupo (idGrupo)
    on delete NO ACTION
    on update NO ACTION,
  constraint fk_Grupo_has_MedioComunicacion_MedioComunicacion1
    foreign key (MedioComunicacion_idMedioComunicacion)
    references MedioComunicacion (idMedioComunicacion)
    on delete NO ACTION
    on update NO ACTION
);


-- ******************************************************************
-- Estructura de la Tabla Grupo_has_Porcentaje
-- ******************************************************************
drop table if exists Grupo_has_Porcentaje;
create table Grupo_has_Porcentaje (
  Grupo_idGrupo int(11) not null,
  Porcentaje_idPorcentaje int not null,
  primary key (Grupo_idGrupo, Porcentaje_idPorcentaje),
  INDEX fk_Grupo_has_Porcentaje_Porcentaje1_idx (Porcentaje_idPorcentaje asc),
  INDEX fk_Grupo_has_Porcentaje_Grupo1_idx (Grupo_idGrupo asc),
  constraint fk_Grupo_has_Porcentaje_Grupo1
    foreign key (Grupo_idGrupo)
    references Grupo (idGrupo)
    on delete NO ACTION
    on update NO ACTION,
  constraint fk_Grupo_has_Porcentaje_Porcentaje1
    foreign key (Porcentaje_idPorcentaje)
    references Porcentaje (idPorcentaje)
    on delete NO ACTION
    on update NO ACTION
);