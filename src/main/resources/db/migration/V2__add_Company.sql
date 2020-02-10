CREATE TABLE `company` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE INDEX `UK_fwiwp4lwjl6p5tjkb1puiaael` (`name`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;


INSERT INTO `demospring`.`company` (`name`) VALUES ('Migration');

ALTER TABLE `contacts`  ADD COLUMN `company_id` BIGINT(20) NOT NULL ;

UPDATE `contacts`  SET `contacts`.`company_id` = (select id from `company` where  name='Migration');

ALTER TABLE `contacts`  ADD CONSTRAINT `FKikleje15jest6sdgnbxyp7rm0` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`);

