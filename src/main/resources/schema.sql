CREATE TABLE IF NOT EXISTS "product"
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    price double NOT NULL
);

INSERT INTO "product" (name, price) values ('apple', 120.0);
INSERT INTO "product" (name, price) values ('banana', 130.0);
INSERT INTO "product" (name, price) values ('orange', 150.0);