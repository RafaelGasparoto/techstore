CREATE TABLE IF NOT EXISTS `products`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `category_id` SMALLINT NOT NULL,
    `name` VARCHAR(150) NOT NULL,
    `description` VARCHAR(300),
    `price` DECIMAL(6, 2) NOT NULL,
    `promo_price` DECIMAL(6, 2),
    `stock` INT NOT NULL,
    PRIMARY KEY (`id`)
)