# CursosLibres
Proyecto elaborado por: Jose David Flores Rodriguez, Roy Fernando Rojas Salazar y Luis Diego Brenes Luna

## Pre-requisitos

Para la ejecucion de este proyecto se necesita Netbeans con java JDK 8, el servidor web GlassFish y MySQL.

Links para descargar los programas necesarios: 

- Java JDK 8: https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html

- Netbeans se puede descargar: https://netbeans.apache.org/download/index.html

- GlassFish: https://javaee.github.io/glassfish/

- MySQL Workbench: https://dev.mysql.com/downloads/workbench/


## Setup de la base de datos

Primero se debe ejecutar el siguiente comando MySQL con WorkBench o desde consola para crear la base de datos:

```sql
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema CursosLibres
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CursosLibres
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CursosLibres` ;
USE `CursosLibres` ;

-- -----------------------------------------------------
-- Table `CursosLibres`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CursosLibres`.`curso` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `tematica` VARCHAR(45) NOT NULL,
  `costo` VARCHAR(45) NOT NULL,
  `oferta` INT NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CursosLibres`.`profesor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CursosLibres`.`profesor` (
  `idProfesor` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido1` VARCHAR(45) NOT NULL,
  `apellido2` VARCHAR(45) NULL,
  `correo` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `especialidad` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProfesor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CursosLibres`.`grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CursosLibres`.`grupo` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `Curso_codigo` INT NOT NULL,
  `profesor_idProfesor` INT NOT NULL,
  `fecha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_grupo_Curso_idx` (`Curso_codigo` ASC) VISIBLE,
  INDEX `fk_grupo_profesor1_idx` (`profesor_idProfesor` ASC) VISIBLE,
  CONSTRAINT `fk_grupo_Curso`
    FOREIGN KEY (`Curso_codigo`)
    REFERENCES `CursosLibres`.`curso` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_grupo_profesor1`
    FOREIGN KEY (`profesor_idProfesor`)
    REFERENCES `CursosLibres`.`profesor` (`idProfesor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CursosLibres`.`administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CursosLibres`.`administrador` (
  `idAdministrador` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido1` VARCHAR(45) NOT NULL,
  `apellido2` VARCHAR(45) NULL,
  `correo` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAdministrador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CursosLibres`.`estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CursosLibres`.`estudiante` (
  `idEstudiante` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido1` VARCHAR(45) NOT NULL,
  `apellido2` VARCHAR(45) NULL,
  `correo` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEstudiante`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CursosLibres`.`grupo_has_estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CursosLibres`.`grupo_has_estudiante` (
  `grupo_codigo` INT NOT NULL,
  `codigo` INT NOT NULL,
  `nota` INT NULL,
  INDEX `fk_grupo_has_estudiante_estudiante1_idx` (`codigo` ASC) VISIBLE,
  INDEX `fk_grupo_has_estudiante_grupo1_idx` (`grupo_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_grupo_has_estudiante_grupo1`
    FOREIGN KEY (`grupo_codigo`)
    REFERENCES `CursosLibres`.`grupo` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_grupo_has_estudiante_estudiante1`
    FOREIGN KEY (`codigo`)
    REFERENCES `CursosLibres`.`estudiante` (`idEstudiante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
```

## Crear usuario admin para el sistema

Una vez creada la base de datos, se debera crear un usuario administrador el cual permita administrar el sistema. Este usuario se creara con el siguiente comando:

```sql
INSERT INTO `cursoslibres`.`administrador` (`idAdministrador`, `nombre`, `apellido1`, `correo`, `telefono`, `password`) VALUES ('123', 'Admin', 'Admin', 'Admin@admin.com', '123', '123');
```

Usuario: 123.
Contraseña: 123.

## Lo que falta

Seguidamente simplemente se debe abrir el proyecto en Netbeans, localizar la carpeta de GlassFish (Se debio descomprimir previamente despues de descargar) y ejecutar el sistema.
