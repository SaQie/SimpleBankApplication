CREATE TABLE account(
    id SERIAL PRIMARY KEY ,
    account_number VARCHAR(255) NOT NULL,
    account_balance NUMERIC NOT NULL ,
    account_created_date DATE NOT NULL
);

CREATE TABLE transaction(
    id SERIAL PRIMARY KEY ,
    target_account_transaction VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    created_date TIMESTAMP NOT NULL ,
    value NUMERIC NOT NULL,
    transaction_type VARCHAR(255) NOT NULL
);

ALTER TABLE transaction add account_id_from INT,
    ADD FOREIGN KEY (account_id_from) REFERENCES account(id);

ALTER TABLE account add user_id INT UNIQUE,
    ADD FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE users add account_id INT UNIQUE,
    ADD FOREIGN KEY (account_id) REFERENCES account(id);

