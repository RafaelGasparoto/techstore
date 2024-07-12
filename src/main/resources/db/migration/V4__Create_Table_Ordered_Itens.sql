CREATE TABLE
    IF NOT EXISTS `ordered_itens` (
        `id` INT NOT NULL AUTO_INCREMENT,
        `order_id` INT NOT NULL,
        `product_id` INT NOT NULL,
        `product_name` VARCHAR(150) NOT NULL,
        `quantity` SMALLINT,
        `price` DECIMAL(6, 2),
        `discount` DECIMAL(6, 2),
        PRIMARY KEY (`id`)
    )