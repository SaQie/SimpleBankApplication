CREATE TABLE bank_account(
    id SERIAL PRIMARY KEY ,
    account_number VARCHAR(255) NOT NULL,
    account_balance NUMERIC NOT NULL ,
    account_number_of_recipients INT NOT NULL ,
    account_number_of_expenses INT NOT NULL ,
    all_incomes NUMERIC NOT NULL,
    all_expenses NUMERIC NOT NULL,
    account_created_date DATE NOT NULL
);

CREATE TABLE transaction(
    id SERIAL PRIMARY KEY ,
    description VARCHAR(255),
    created_date TIMESTAMP NOT NULL ,
    value NUMERIC NOT NULL
);

ALTER TABLE transaction add account_from_id INT,
    ADD FOREIGN KEY (account_from_id) REFERENCES bank_account(id);

ALTER TABLE transaction add account_to_id INT,
    ADD FOREIGN KEY (account_to_id) REFERENCES bank_account(id);

ALTER TABLE bank_account add user_id INT UNIQUE,
    ADD FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE users add bank_account_id INT UNIQUE,
    ADD FOREIGN KEY (bank_account_id) REFERENCES bank_account(id);

