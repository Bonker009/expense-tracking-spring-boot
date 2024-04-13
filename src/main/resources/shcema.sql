CREATE DATABASE expense_tracking;
CREATE TABLE Users
(
    user_id       uuid  PRIMARY KEY,
    email         VARCHAR(255) NOT NULL UNIQUE,
    password      VARCHAR(255) NOT NULL,
    profile_image VARCHAR(255)
);

CREATE TABLE Categories
(
    category_id uuid PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    user_id     uuid,
    FOREIGN KEY (user_id) REFERENCES Users (user_id)
);

CREATE TABLE Expenses
(
    expense_id  uuid PRIMARY KEY,
    amount      DECIMAL(10, 2) NOT NULL,
    description TEXT,
    date        DATE           NOT NULL,
    user_id     uuid,
    category_id uuid,
    FOREIGN KEY (user_id) REFERENCES Users (user_id),
    FOREIGN KEY (category_id) REFERENCES Categories (category_id)
);

CREATE TABLE Otps
(
    otp_id     uuid PRIMARY KEY,
    opt_code   VARCHAR(255) NOT NULL,
    issued_at  TIMESTAMP    NOT NULL,
    expiration TIMESTAMP    NOT NULL,
    verified   BOOLEAN      NOT NULL,
    user_id    uuid,
    FOREIGN KEY (user_id) REFERENCES Users (user_id)
);
