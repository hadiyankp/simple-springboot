CREATE TABLE inventory (
                           id BIGSERIAL PRIMARY KEY,
                           item_name VARCHAR(255) NOT NULL,
                           quantity INTEGER NOT NULL,
                           type CHAR(1) NOT NULL CHECK (type IN ('T', 'W'))
);

INSERT INTO inventory (item_name, quantity, type) VALUES
                                                      ('Pulsa Telkomsel', 10, 'T'),
                                                      ('Pulsa Telkomsel', 5, 'W'),
                                                      ('Pulsa XL', 20, 'T'),
                                                      ('Pulsa XL', 7, 'W'),
                                                      ('Pulsa Indosat', 30, 'T'),
                                                      ('Pulsa Indosat', 10, 'W'),
                                                      ('Voucher Game', 50, 'T'),
                                                      ('Voucher Game', 15, 'W'),
                                                      ('Token Listrik', 40, 'T'),
                                                      ('Token Listrik', 12, 'W'),
                                                      ('Pulsa Smartfren', 25, 'T'),
                                                      ('Pulsa Smartfren', 8, 'W'),
                                                      ('Pulsa Axis', 35, 'T'),
                                                      ('Pulsa Axis', 10, 'W'),
                                                      ('Pulsa Tri', 45, 'T'),
                                                      ('Pulsa Tri', 20, 'W'),
                                                      ('Pulsa By.U', 60, 'T'),
                                                      ('Pulsa By.U', 18, 'W'),
                                                      ('Voucher Streaming', 70, 'T'),
                                                      ('Voucher Streaming', 22, 'W');
