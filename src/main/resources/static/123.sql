/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.31 : Database - lover
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lover` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `lover`;

/*Table structure for table `codesessionkey` */

DROP TABLE IF EXISTS `codesessionkey`;

CREATE TABLE `codesessionkey` (
                                  `uid` int NOT NULL AUTO_INCREMENT,
                                  `did` int NOT NULL,
                                  `sessionkey` varchar(256) NOT NULL,
                                  PRIMARY KEY (`uid`),
                                  KEY `did` (`did`),
                                  CONSTRAINT `codesessionkey_ibfk_1` FOREIGN KEY (`did`) REFERENCES `le_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `codesessionkey` */

/*Table structure for table `le_detail_information` */

DROP TABLE IF EXISTS `le_detail_information`;

CREATE TABLE `le_detail_information` (
                                         `id` int NOT NULL AUTO_INCREMENT,
                                         `user_id` int NOT NULL,
                                         `native_place` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                                         `shape` varchar(100) CHARACTER SET utf8mb3 DEFAULT NULL,
                                         `constellation` varchar(100) CHARACTER SET utf8mb3 DEFAULT NULL,
                                         `nation` varchar(100) CHARACTER SET utf8mb3 DEFAULT NULL,
                                         `is_have_child` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                                         `is_want_child` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                                         `when_marry` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                                         `weight` int DEFAULT NULL,
                                         `create_time` datetime DEFAULT NULL,
                                         `modify_time` datetime DEFAULT NULL,
                                         `version` int NOT NULL DEFAULT '0',
                                         `deleted` int NOT NULL DEFAULT '0',
                                         PRIMARY KEY (`id`),
                                         KEY `did` (`user_id`),
                                         CONSTRAINT `le_detail_information_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `le_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `le_detail_information` */

insert  into `le_detail_information`(`id`,`user_id`,`native_place`,`shape`,`constellation`,`nation`,`is_have_child`,`is_want_child`,`when_marry`,`weight`,`create_time`,`modify_time`,`version`,`deleted`) values (1,86,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2022-11-16 16:33:53','2022-11-16 16:33:53',0,0);

/*Table structure for table `le_heart_word` */

DROP TABLE IF EXISTS `le_heart_word`;

CREATE TABLE `le_heart_word` (
                                 `id` int NOT NULL AUTO_INCREMENT,
                                 `user_id` int NOT NULL,
                                 `heart_words` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                                 `create_time` datetime NOT NULL,
                                 `modify_time` datetime NOT NULL,
                                 `version` int NOT NULL DEFAULT '0',
                                 `deleted` int NOT NULL DEFAULT '0',
                                 PRIMARY KEY (`id`),
                                 KEY `did` (`user_id`),
                                 CONSTRAINT `le_heart_word_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `le_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

/*Data for the table `le_heart_word` */

insert  into `le_heart_word`(`id`,`user_id`,`heart_words`,`create_time`,`modify_time`,`version`,`deleted`) values (2,86,'','2022-11-16 14:30:01','2022-11-16 16:33:32',6,0);

/*Table structure for table `le_hobby` */

DROP TABLE IF EXISTS `le_hobby`;

CREATE TABLE `le_hobby` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `user_id` int NOT NULL,
                            `favorite_food` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                            `favorite_person` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                            `favorite_song` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                            `favorite_book` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                            `favorite_doing` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
                            `create_time` datetime DEFAULT NULL,
                            `modify_time` datetime DEFAULT NULL,
                            `version` int NOT NULL DEFAULT '0',
                            `deleted` int NOT NULL DEFAULT '0',
                            PRIMARY KEY (`id`),
                            KEY `did` (`user_id`),
                            CONSTRAINT `le_hobby_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `le_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `le_hobby` */

insert  into `le_hobby`(`id`,`user_id`,`favorite_food`,`favorite_person`,`favorite_song`,`favorite_book`,`favorite_doing`,`create_time`,`modify_time`,`version`,`deleted`) values (1,86,NULL,NULL,NULL,NULL,NULL,'2022-11-16 16:33:40','2022-11-16 16:33:40',0,0);

/*Table structure for table `le_user` */

DROP TABLE IF EXISTS `le_user`;

CREATE TABLE `le_user` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `user_name` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                           `password` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                           `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           `version` int NOT NULL,
                           `deleted` int NOT NULL,
                           `jurisdiction` varchar(256) COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'user',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `le_user` */

insert  into `le_user`(`id`,`user_name`,`password`,`create_time`,`modify_time`,`version`,`deleted`,`jurisdiction`) values (67,'1302861385','$2a$10$q1IFmH5OpfiUn3/AfXyOwewQBbBwEBGnxx1MKtTm68i9wiEFD3xEK','2022-11-12 23:24:53','2022-11-13 04:06:18',2,0,'user'),(86,'la1302861385','$2a$10$V6wBeYjHa/NzjNzhcFUJa.H5pDkan5Bd4GQDM7wPiamkoZzYFzMyG','2022-11-13 11:26:55','2022-11-13 11:28:26',2,0,'user'),(87,'la13028613851','$2a$10$PkrTaZz9zZyT9vPgV4d6zuQm27BIhLsVdOotQHGDD5xLbUjAItfoS','2022-11-13 11:30:11','2022-11-13 11:30:11',0,0,'user'),(88,'llkla00000','$2a$10$.5QbO/A2DxFcY7bCG7RxmO/IBpWh7JiABatui3VpUwBzjQUpFFp06','2022-11-13 11:30:24','2022-11-13 11:30:24',0,0,'user'),(89,'130286138512','$2a$10$jqWTrRZYxMv0X5mP6/qD8u2TI5gRkBjMtFmo5puDk4Ui306SBjdx6','2022-11-13 11:33:57','2022-11-13 11:33:57',0,0,'user'),(90,'fasfsafsafsa','$2a$10$3DXTVjBSKU4DyvXtYo/0jOg3mu5.nZSMDD6bq9TtVM6n2jB4.DKrW','2022-11-13 11:34:14','2022-11-13 11:34:28',1,0,'user'),(91,'kaki125806','$2a$10$DuAJuKpiX0F4fAtDtuEeGu3lCWYu4s31Fui./cgH2Uo4sjHS8cA/a','2022-11-14 22:15:07','2022-11-14 22:15:07',0,0,'user');

/*Table structure for table `le_user_detail` */

DROP TABLE IF EXISTS `le_user_detail`;

CREATE TABLE `le_user_detail` (
                                  `id` int NOT NULL AUTO_INCREMENT,
                                  `user_id` int NOT NULL,
                                  `nick_name` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                                  `work_place` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                                  `income` int NOT NULL,
                                  `height` int NOT NULL,
                                  `education` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                                  `sex` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                                  `is_marry` varchar(256) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
                                  `birthday` date NOT NULL,
                                  `create_time` datetime NOT NULL,
                                  `modify_time` datetime NOT NULL,
                                  `version` int NOT NULL DEFAULT '0',
                                  `deleted` int NOT NULL DEFAULT '0',
                                  `profile_picture` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL,
                                  PRIMARY KEY (`id`),
                                  KEY `did` (`user_id`),
                                  CONSTRAINT `le_user_detail_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `le_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `le_user_detail` */

insert  into `le_user_detail`(`id`,`user_id`,`nick_name`,`work_place`,`income`,`height`,`education`,`sex`,`is_marry`,`birthday`,`create_time`,`modify_time`,`version`,`deleted`,`profile_picture`) values (151,87,'小明','山东',9000,175,'本科','男','离异有孩子','1995-11-12','2022-11-14 10:32:44','2022-11-14 10:42:35',2,0,NULL),(152,86,'洒洒水','[\"370000\",\"370400\",\"370403\"]',3,186,'研究生','男','离异有孩子','1999-08-05','2022-11-14 21:32:04','2022-11-16 19:24:35',10,0,NULL),(153,91,'哇哈哈','[\"370000\",\"370100\",\"370124\"]',5,164,'博士及以上','女','未婚','1990-10-31','2022-11-14 22:16:36','2022-11-14 22:17:39',1,0,NULL);

/*Table structure for table `le_work_life` */

DROP TABLE IF EXISTS `le_work_life`;

CREATE TABLE `le_work_life` (
                                `id` int NOT NULL AUTO_INCREMENT,
                                `user_id` int NOT NULL,
                                `occupation` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
                                `house_situation` varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL,
                                `is_smoking` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
                                `is_drinking` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
                                `create_time` date DEFAULT NULL,
                                `modify_time` date DEFAULT NULL,
                                `version` int NOT NULL DEFAULT '0',
                                `deleted` int NOT NULL DEFAULT '0',
                                PRIMARY KEY (`id`),
                                KEY `le_work_life_ibfk_1` (`user_id`),
                                CONSTRAINT `le_work_life_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `le_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `le_work_life` */

insert  into `le_work_life`(`id`,`user_id`,`occupation`,`house_situation`,`is_smoking`,`is_drinking`,`create_time`,`modify_time`,`version`,`deleted`) values (1,86,NULL,NULL,'不吸烟',NULL,'2022-11-16','2022-11-16',1,0);

/*Table structure for table `spousepreference` */

DROP TABLE IF EXISTS `spousepreference`;

CREATE TABLE `spousepreference` (
                                    `uid` int NOT NULL AUTO_INCREMENT,
                                    `did` int NOT NULL,
                                    `agebefor` int DEFAULT NULL,
                                    `ageafter` int DEFAULT NULL,
                                    `heightbefor` int DEFAULT NULL,
                                    `heightafter` int DEFAULT NULL,
                                    `incomebefor` int DEFAULT NULL,
                                    `incomeafter` int DEFAULT NULL,
                                    `edcation` varchar(100) DEFAULT NULL,
                                    `shape` varchar(100) DEFAULT NULL,
                                    `workplace` varchar(100) DEFAULT NULL,
                                    `ishavechild` varchar(100) DEFAULT NULL,
                                    `iswantchild` varchar(100) DEFAULT NULL,
                                    `issmoking` varchar(100) DEFAULT NULL,
                                    `isdrink` varchar(100) DEFAULT NULL,
                                    `ishaveimg` varchar(100) DEFAULT NULL,
                                    PRIMARY KEY (`uid`),
                                    KEY `did` (`did`),
                                    CONSTRAINT `spousepreference_ibfk_1` FOREIGN KEY (`did`) REFERENCES `le_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `spousepreference` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
