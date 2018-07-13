CREATE DATABASE enterprise;

CREATE TABLE t_users(
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL ,
  `password` VARCHAR(255) NOT NULL ,
  `phone` VARCHAR(255),
  `create_at` DATETIME,
  `update_at` DATETIME,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_users_username` (`username`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE t_roles(
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_roles_name` (`name`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `t_user_roles` (
  `user_id` INT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_roles_role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_categories` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL ,
  `img` VARCHAR(1024) NOT NULL ,
  `order` INT,
  `create_at` DATETIME,
  `update_at` DATETIME,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_carousels` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL ,
  `img` VARCHAR(1024) NOT NULL ,
  `order` INT,
  `product_id` INT,
  `create_at` DATETIME,
  `update_at` DATETIME,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `t_products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category_id` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL ,
  `desc` VARCHAR(1024) NOT NULL ,
  `size` VARCHAR(255) NOT NULL ,
  `img` VARCHAR(1024) NOT NULL ,
  `order` INT,
  `create_at` DATETIME,
  `update_at` DATETIME,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT IGNORE INTO t_roles(name) VALUES('ROLE_USER');
INSERT IGNORE INTO t_roles(name) VALUES('ROLE_ADMIN');