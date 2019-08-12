
INSERT INTO `ADDRESS` (id, city, state, status, street, zip_code) VALUES (1, 'Fairfield', 'IA', 'Shipping', '1000 North 4th', '52557');
INSERT INTO `ADDRESS` (id, city, state, status, street, zip_code) VALUES (2, 'Fairfield-Shipping', 'IA', 'Shipping', '9874 North 10th', '52557');
INSERT INTO `ADDRESS` (id, city, state, status, street, zip_code) VALUES (3, 'Fairfield', 'IA', 'Shipping', '1000 North 4th', '52557');

INSERT INTO `USER` (id, name, email, billing_address_id, shipping_address_id, type) VALUES (1, 'First User', 'first.user@gmail.com', 1, 2, 'SELLER');
INSERT INTO `USER` (id, name, email, billing_address_id, shipping_address_id, type) VALUES (2, 'Second User', 'second.user@gmail.com', 1, 2, 'SELLER');
INSERT INTO `USER` (id, name, email, billing_address_id, shipping_address_id, type) VALUES (3, 'Third User', 'third.user@gmail.com', 1, 2, 'SELLER');


INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy) VALUES (1, 'Product01', 'Product01 description', 10, 1, 2);
INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy) VALUES (2, 'Product02', 'Product02 description', 10, 1, 3);
INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy) VALUES (3, 'Product03', 'Product03 description', 10, 1, 2);
INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy) VALUES (4, 'Product04', 'Product04 description', 10, 1, 3);
INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy) VALUES (5, 'Product05', 'Product05 description', 10, 3, 3);
INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy) VALUES (6, 'Product06', 'Product06 description', 10, 3, 3);
INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy) VALUES (7, 'Product07', 'Product07 description', 10, 3, 3);
INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy) VALUES (8, 'Product08', 'Product08 description', 10, 3, 3);



INSERT INTO `CART` (id, total_price, active) VALUES (1, 30, true);
INSERT INTO `CART` (id, total_price, active) VALUES (2, 30, false);

INSERT INTO `CART_PRODUCT_LIST` (cart_id, product_list_id) VALUES (1, 1);
INSERT INTO `CART_PRODUCT_LIST` (cart_id, product_list_id) VALUES (1, 2);
INSERT INTO `CART_PRODUCT_LIST` (cart_id, product_list_id) VALUES (1, 7);
INSERT INTO `CART_PRODUCT_LIST` (cart_id, product_list_id) VALUES (1, 8);

INSERT INTO `CART_PRODUCT_LIST` (cart_id, product_list_id) VALUES (2, 3);
INSERT INTO `CART_PRODUCT_LIST` (cart_id, product_list_id) VALUES (2, 4);

INSERT INTO `REVIEW` (id, create_date,description,status,product_id,user_id) VALUES (1,'2019-2-2','Very Good',null,1,1);
INSERT INTO `REVIEW` (id, create_date,description,status,product_id,user_id) VALUES (2,'2019-3-7',' Good',null,2,1);


-- INSERT INTO `USER_ORDER` (id, status, cart_id, seller_id, create_date, total) VALUES (1, 'waiting', 1, 1, '2019-08-10', 20);
-- INSERT INTO `USER_ORDER` (id, status, cart_id, seller_id, create_date, total) VALUES (2, 'waiting', 1, 3, '2019-08-10', 20);




--
--
-- INSERT INTO `USER` (id, name, email, billing_address_id, shipping_address_id, type) VALUES (1, 'First User', 'first.user@gmail.com', 1, 2, 'SELLER');
-- INSERT INTO `USER` (id, name, email, billing_address_id, shipping_address_id, type) VALUES (2, 'Second User', 'second.user@gmail.com', 1, 2, 'SELLER');
-- INSERT INTO `USER` (id, name, email, billing_address_id, shipping_address_id, type) VALUES (3, 'Third User', 'third.user@gmail.com', 1, 2, 'SELLER');
--
--
--
-- INSERT INTO `ADDRESS` (id, city, state, status, street, zip_code, user_id) VALUES (1, 'Fairfield', 'IA', 'Shipping', '1000 North 4th', '52557', 1);
-- INSERT INTO `ADDRESS` (id, city, state, status, street, zip_code, user_id) VALUES (2, 'Fairfield', 'IA', 'Shipping', '1000 North 4th', '52557', 2);
-- INSERT INTO `ADDRESS` (id, city, state, status, street, zip_code, user_id) VALUES (3, 'Fairfield', 'IA', 'Shipping', '1000 North 4th', '52557', 3);
--
-- INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy) VALUES (1, 'Product01', 'Product01 description', 10, 1, 2);
-- INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy) VALUES (2, 'Product02', 'Product02 description', 10, 1, 3);
-- INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy) VALUES (3, 'Product03', 'Product03 description', 10, 1, 2);
-- INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy) VALUES (4, 'Product04', 'Product04 description', 10, 1, 3);
-- INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy) VALUES (5, 'Product05', 'Product05 description', 10, 3, 3);
-- INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy) VALUES (6, 'Product06', 'Product06 description', 10, 3, 3);
-- INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy) VALUES (7, 'Product07', 'Product07 description', 10, 3, 3);
-- INSERT INTO `PRODUCT` (id, name, description, price, seller_id, quantiy) VALUES (8, 'Product08', 'Product08 description', 10, 3, 3);
--
--
--
-- INSERT INTO `CART` (id, total_price, buyer_id, active) VALUES (1, 30, 2, true);
-- INSERT INTO `CART` (id, total_price, buyer_id, active) VALUES (2, 50, 2, false);
--
-- INSERT INTO `USER_ORDER` (id, status, cart_id, seller_id, create_date, total) VALUES (1, 'waiting', 1, 1, '2019-08-10', 20);
-- INSERT INTO `USER_ORDER` (id, status, cart_id, seller_id, create_date, total) VALUES (2, 'waiting', 1, 3, '2019-08-10', 20);
--
--
--
--
--
-- INSERT INTO `USER_ORDER` (id, status, create_date) VALUES (1, 'waiting', '2019-08-10');
--

INSERT INTO `REVIEW`(id, description, status, create_date,  product_id, user_id) VALUES (5,'Product is amazing', '','2019-05-01',1,2 );
INSERT INTO `REVIEW`(id, description, status, create_date,  product_id, user_id) VALUES (3,'I loved it', 'approved','2019-05-02',1,1 );
INSERT INTO `REVIEW`(id, description, status, create_date,  product_id, user_id) VALUES (7,'Not Good', 'approved','2019-05-11',1,1 );
INSERT INTO `REVIEW`(id, description, status, create_date,  product_id, user_id) VALUES (4,'Good I m happy', 'approved','2019-06-11',1,1 );
INSERT INTO `REVIEW`(id, description, status, create_date,  product_id, user_id) VALUES (2,'Not so Good Please', 'approved','2019-07-11',1,1 );


