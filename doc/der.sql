-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema dbweb2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbweb2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbweb2` DEFAULT CHARACTER SET utf8 ;
USE `dbweb2` ;

-- -----------------------------------------------------
-- Table `dbweb2`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbweb2`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbweb2`.`albums`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbweb2`.`albums` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `description` TEXT NULL,
  `cover_path` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbweb2`.`photos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbweb2`.`photos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NULL,
  `path` VARCHAR(255) NOT NULL,
  `albums_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_photo_albums_idx` (`albums_id` ASC),
  CONSTRAINT `fk_photo_albums`
    FOREIGN KEY (`albums_id`)
    REFERENCES `dbweb2`.`albums` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dbweb2`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbweb2`.`comments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `content` VARCHAR(45) NOT NULL,
  `albums_id` INT NOT NULL,
  `author_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comments_albums1_idx` (`albums_id` ASC),
  CONSTRAINT `fk_comments_albums1`
    FOREIGN KEY (`albums_id`)
    REFERENCES `dbweb2`.`albums` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
