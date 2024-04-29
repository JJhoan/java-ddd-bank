CREATE TABLE IF NOT EXISTS accounts (
    id char(36) NOT NULL,
    number VARCHAR(50) NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    primary key (id)
);