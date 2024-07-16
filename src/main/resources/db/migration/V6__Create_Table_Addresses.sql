CREATE TABLE
    IF NOT EXISTS `addresses` (
        `id` INT NOT NULL AUTO_INCREMENT,
        `street` VARCHAR(150) NOT NULL,
        `number` INT NOT NULL,
        `city` VARCHAR(150) NOT NULL,
        `cep` VARCHAR(9) NOT NULL,
        `uf` VARCHAR(2) NOT NULL,
        `user_id` INT NOT NULL,
        PRIMARY KEY (`id`),
        INDEX `fk_addresses_users_idx` (`user_id`),
        CONSTRAINT `fk_addresses_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
    )