-- Role: techstore_role_rw
-- DROP ROLE techstore_role_rw;

CREATE ROLE techstore_role_rw WITH
  NOLOGIN
  NOSUPERUSER
  INHERIT
  NOCREATEDB
  NOCREATEROLE
  NOREPLICATION;
-----------------------------------------------------------------------

-- Role: techstore_user_rw
-- DROP ROLE techstore_user_rw;

CREATE ROLE techstore_user_rw WITH
  LOGIN
  NOSUPERUSER
  INHERIT
  NOCREATEDB
  NOCREATEROLE
  NOREPLICATION
  ENCRYPTED PASSWORD 'SCRAM-SHA-256$4096:K3A4Qd89NRDdavI+U58mew==$VmtHcBS+nb83FF7Rdw/BXu6N0WW5SLy8AZB8ngpiV1Q=:szkxmJCNmRKnhQhNsXWYSQuzuQDGmhDwY5D4CK9rtU4=';

GRANT techstore_role_rw TO techstore_user_rw WITH ADMIN OPTION;
-----------------------------------------------------------------------


-- SCHEMA: techstore

-- DROP SCHEMA techstore ;

CREATE SCHEMA techstore
    AUTHORIZATION postgres;

GRANT ALL ON SCHEMA techstore TO postgres;

GRANT ALL ON SCHEMA techstore TO techstore_role_rw;

-----------------------------------------------------------------------



-----------------------------------------------------------------------
-- Table: techstore.user

-- DROP TABLE techstore.user;

CREATE TABLE IF NOT EXISTS techstore.user
(
	userid serial NOT NULL ,
    email character(250) NOT NULL,
    fname character(250) NOT NULL,
    lname character(250) NOT NULL,
    password character(250) NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (userid)
);

ALTER TABLE techstore.user
    OWNER to postgres;

GRANT ALL ON TABLE techstore.user TO postgres;

GRANT ALL ON TABLE techstore.user TO techstore_role_rw;
-----------------------------------------------------------------------
-- Table: techstore.product

-- DROP TABLE techstore.product;

CREATE TABLE IF NOT EXISTS techstore.product
(
    productid serial NOT NULL,
    name character(250) NOT NULL,
    description character(250) NOT NULL,
    price numeric,
    ccy character(3) NOT NULL,
    CONSTRAINT product_pkey PRIMARY KEY (productid)
);

ALTER TABLE techstore.product
    OWNER to postgres;

GRANT ALL ON TABLE techstore.product TO postgres;

GRANT ALL ON TABLE techstore.product TO techstore_role_rw;
-----------------------------------------------------------------------

-- Table: techstore.cart

-- DROP TABLE techstore.cart;

CREATE TABLE IF NOT EXISTS techstore.cart
(
    userid integer NOT NULL,
    productid integer NOT NULL,
    quantity integer NOT NULL,
    CONSTRAINT cart_pkey PRIMARY KEY (userid, productid),
	CONSTRAINT cart_fk_userid FOREIGN KEY (userid)
	REFERENCES techstore.user (userid),
	CONSTRAINT cart_fk_productid FOREIGN KEY (productid)
	REFERENCES techstore.product (productid)

);

ALTER TABLE techstore.cart
    OWNER to postgres;

GRANT ALL ON TABLE techstore.cart TO postgres;

GRANT ALL ON TABLE techstore.cart TO techstore_role_rw;
-----------------------------------------------------------------------

-- Table: techstore.order

-- DROP TABLE techstore.order;

CREATE TABLE IF NOT EXISTS techstore.order
(
    orderid serial NOT NULL,
    userid integer NOT NULL,
    orderdate date,
    ordertime time with time zone,
    status character(10),
    expected_delivery_date date,
    actual_delivery_date date,
    CONSTRAINT order_pk PRIMARY KEY (orderid),
    CONSTRAINT order_fk_userid FOREIGN KEY (userid)
    REFERENCES techstore.user (userid)
);

ALTER TABLE techstore.order
    OWNER to postgres;

GRANT ALL ON TABLE techstore.order TO postgres;

GRANT ALL ON TABLE techstore.order TO techstore_role_rw;
-----------------------------------------------------------------------

-- Table: techstore.orderitem

-- DROP TABLE techstore.orderitem;

CREATE TABLE IF NOT EXISTS techstore.orderitem
(
    orderid integer NOT NULL,
    productid integer NOT NULL,
    quantity integer,
    price_per_item double precision,
    ccy character(3) ,
    CONSTRAINT orderitem_pkey PRIMARY KEY (orderid, productid),
    CONSTRAINT orderitem_fk_orderid FOREIGN KEY (orderid)
        REFERENCES techstore.order (orderid),
    CONSTRAINT orderitem_fk_productid FOREIGN KEY (productid)
        REFERENCES techstore.product (productid)
);

ALTER TABLE techstore.orderitem
    OWNER to postgres;

GRANT ALL ON TABLE techstore.orderitem TO postgres;

GRANT ALL ON TABLE techstore.orderitem TO techstore_role_rw;

-----------------------------------------------------------------------



