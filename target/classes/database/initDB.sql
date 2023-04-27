DROP TABLE IF EXISTS users, card CASCADE ;

CREATE TABLE users
(
    user_id   BIGSERIAL PRIMARY KEY,
    username  VARCHAR NOT NULL,
    firstname VARCHAR NOT NULL,
    lastname  VARCHAR NOT NULL
);

CREATE TABLE card
(
    card_id     BIGSERIAL PRIMARY KEY,
    card_number BIGINT    NOT NULL,
    CVV         INT       NOT NULL,
    card_holder BIGSERIAL
)