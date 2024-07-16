CREATE TABLE
    IF NOT EXISTS `ordered_items` (
        `id` INT NOT NULL AUTO_INCREMENT,
        `ordered_id` INT NOT NULL,
        `product_id` INT NOT NULL,
        `product_name` VARCHAR(150) NOT NULL,
        `quantity` SMALLINT,
        `price` DECIMAL(6, 2),
        `discount` DECIMAL(6, 2),
        PRIMARY KEY (`id`),
        INDEX `fk_ordered_itens_ordereds_idx` (`ordered_id`),
        CONSTRAINT `fk_ordered_itens_ordereds` FOREIGN KEY (`ordered_id`) REFERENCES `ordereds` (`id`)
    )