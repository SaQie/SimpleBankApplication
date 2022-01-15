CREATE TABLE bank_account(
    id SERIAL PRIMARY KEY ,
    account_number VARCHAR(255) NOT NULL,
    account_balance NUMERIC NOT NULL ,
    account_number_of_recipients INT NOT NULL ,
    account_number_of_expenses INT NOT NULL ,
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
    ADD FOREIGN KEY (account_id_from) REFERENCES bank_account(id);

ALTER TABLE bank_account add user_id INT UNIQUE,
    ADD FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE users add bank_account_id INT UNIQUE,
    ADD FOREIGN KEY (bank_account_id) REFERENCES bank_account(id);

