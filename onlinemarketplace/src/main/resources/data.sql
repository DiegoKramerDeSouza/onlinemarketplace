
INSERT INTO `ADDRESS` (id, city, state, status, street, zip_code) VALUES (1, 'Fairfield', 'IA', 'Shipping', '1000 North 4th', '52557');
INSERT INTO `ADDRESS` (id, city, state, status, street, zip_code) VALUES (2, 'Fairfield-Shipping', 'IA', 'Shipping', '9874 North 10th', '52557');
INSERT INTO `ADDRESS` (id, city, state, status, street, zip_code) VALUES (3, 'Fairfield', 'IA', 'Shipping', '1000 North 4th', '52557');

INSERT INTO `CREDIT_CARD` (id, number, name, valid_date) VALUES (1, '1111444433339999', 'First User', '10/21');
INSERT INTO `CREDIT_CARD` (id, number, name, valid_date) VALUES (2, '2222555588889988', 'Second User', '09/21');
INSERT INTO `CREDIT_CARD` (id, number, name, valid_date) VALUES (3, '8888777766669977', 'Third User', '08/21');

INSERT INTO `CART` (id, total_price, active) VALUES (1, 0, true);
INSERT INTO `CART` (id, total_price, active) VALUES (2, 0, true);
INSERT INTO `CART` (id, total_price, active) VALUES (3, 0, true);


INSERT INTO `USER` (id, name, password, email, billing_address_id, shipping_address_id, type, credit_card_id, points, has_ads, cart_id) VALUES (1, 'First User', '123456', 'first.user@gmail.com', 1, 2, 'SELLER', 1, 0, false, 2);
INSERT INTO `USER` (id, name, password, email, billing_address_id, shipping_address_id, type, credit_card_id, points, has_ads, cart_id) VALUES (2, 'Second User', '123456', 'second.user@gmail.com', 1, 2, 'BUYER', 2, 0, false, 1);
INSERT INTO `USER` (id, name, password, email, billing_address_id, shipping_address_id, type, credit_card_id, points, has_ads, cart_id) VALUES (3, 'Third User', '123456', 'third.user@gmail.com', 1, 2, 'SELLER', 3, 0, true, 3);


INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy, product_image) VALUES (1, 'Madhur', 'Product01 description', 10, 1, 2,'madhur.jpg');
INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy, product_image) VALUES (2, 'Dream Catchers', 'Product02 description', 10, 1, 3,'dreamcatchers.jpg');
INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy, product_image) VALUES (3, 'Product03', 'Product03 description', 10, 1, 2,'sneakers.jpg');
INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy, product_image) VALUES (4, 'Green Tea', 'Product04 description', 10, 1, 3, 'greentea.jpg');
INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy, product_image) VALUES (5, 'Kissan', 'Product05 description', 10, 3, 3,'kissan.jpg');
INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy, product_image) VALUES (6, 'Odonil', 'Product06 description', 10, 3, 3,'odonil.jpg');
INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy, product_image) VALUES (7, 'Surf Excel', 'Product07 description', 10, 3, 3,'surfexcel.jpg');
INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy, product_image) VALUES (8, 'Scherwan Noodle', 'Product08 description', 10, 3, 3,'noodle.jpg');
INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy, product_image) VALUES (9, 'Almonds', 'Almonds is very good for health', 10, 3, 3,'almonds.jpg');

INSERT INTO `CART_PRODUCT_LIST` (cart_id, product_list_id) VALUES (1, 1);
INSERT INTO `CART_PRODUCT_LIST` (cart_id, product_list_id) VALUES (1, 2);
INSERT INTO `CART_PRODUCT_LIST` (cart_id, product_list_id) VALUES (1, 3);
INSERT INTO `CART_PRODUCT_LIST` (cart_id, product_list_id) VALUES (1, 7);

INSERT INTO `ADS` (id, user_id) VALUES (1, 3);
INSERT INTO `ADS` (id, user_id) VALUES (2, 1);


INSERT INTO `REVIEW` (id, create_date,description,status,product_id,user_id) VALUES (1,'2019-2-2','Very Good',null,1,1);



INSERT INTO `REVIEW`(id, description, status, create_date,  product_id, user_id) VALUES (5,'Product is amazing', '','2019-05-01',1,2 );
INSERT INTO `REVIEW`(id, description, status, create_date,  product_id, user_id) VALUES (3,'I loved it', 'approved','2019-05-02',1,1 );
INSERT INTO `REVIEW`(id, description, status, create_date,  product_id, user_id) VALUES (7,'Not Good', 'approved','2019-05-11',1,1 );
INSERT INTO `REVIEW`(id, description, status, create_date,  product_id, user_id) VALUES (4,'Good I m happy', 'approved','2019-06-11',1,1 );


INSERT INTO `REVIEW`(id, description, status, create_date,  product_id, user_id) VALUES (9,'Not so Good Please', 'approved','2019-07-11',1,1 );



