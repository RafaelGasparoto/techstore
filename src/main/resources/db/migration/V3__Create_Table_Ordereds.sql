CREATE TABLE
    IF NOT EXISTS `ordereds` (
        `id` INT NOT NULL AUTO_INCREMENT,
        `user_id` INT NOT NULL,
        `quantity_itens` SMALLINT,
        `discount` DECIMAL(6, 2),
        `total` DECIMAL(6, 2),
        PRIMARY KEY (`id`)
    )