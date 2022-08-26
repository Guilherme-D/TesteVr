set foreign_key_checks=0;

CREATE TABLE cards (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR (16) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    balance DECIMAL(20,2) NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL
);

CREATE TABLE transactions (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    card_id BIGINT UNSIGNED NOT NULL,
    value DECIMAL(20,2) UNSIGNED NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMP NULL DEFAULT NULL,

    CONSTRAINT FK_card_id FOREIGN KEY (card_id) REFERENCES cards(id)
);

set foreign_key_checks=1;