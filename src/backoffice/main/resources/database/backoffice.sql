create TABLE IF NOT EXISTS accounts (
    id char(36) NOT NULL,
    number VARCHAR(50) NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    primary key (id)
);

CREATE TABLE IF NOT EXISTS transactions (
    id char(36) NOT NULL,
    account_from char(36) NOT NULL,
    account_to char(36) NOT NULL,
    amount DOUBLE PRECISION NOT NULL,
    primary key (id)
);
