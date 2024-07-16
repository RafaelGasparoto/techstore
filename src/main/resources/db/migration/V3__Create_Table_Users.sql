CREATE TABLE
    IF NOT EXISTS `users` (
        `id` INT NOT NULL AUTO_INCREMENT,
        `full_name` VARCHAR(80) NOT NULL,
        `username` VARCHAR(20) NOT NULL,
        `password` VARCHAR(20) NOT NULL,
        `email` VARCHAR(80) NOT NULL,
        PRIMARY KEY (`id`),
        UNIQUE KEY `uk_username` (`username`),
        UNIQUE KEY `uk_email` (`email`)
    )