/*
select * from retailstore.ref_cd_grps;
select * from retailstore.ref_cd_vals;
select * from retailstore.stores;
select * from retailstore.employee;
select * from retailstore.customers;
select * from retailstore.products;
*/

DROP SCHEMA retailstore;
CREATE SCHEMA `retailstore`;

CREATE TABLE retailstore.ref_cd_grps (
    id BIGINT NOT NULL AUTO_INCREMENT,
    grp_code VARCHAR(10) NOT NULL UNIQUE,
    grp_desc VARCHAR(100) NOT NULL,
    grp_shrt_desc VARCHAR(30) NOT NULL,
    is_active INTEGER NOT NULL DEFAULT 1,
    created_dt DATETIME(6) NOT NULL,
    created_by VARCHAR(30) NOT NULL,
    modified_by VARCHAR(30),
    modified_dt VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE retailstore.ref_cd_vals (
    id BIGINT NOT NULL AUTO_INCREMENT,
    grp_code VARCHAR(10) NOT NULL,
    val_code VARCHAR(10) NOT NULL,
    val_desc VARCHAR(100) NOT NULL,
    val_shrt_desc VARCHAR(30) NOT NULL,
    is_active INTEGER NOT NULL DEFAULT 1,
    created_dt DATETIME(6) NOT NULL,
    created_by VARCHAR(30) NOT NULL,
    modified_by VARCHAR(30),
    modified_dt VARCHAR(255),
    PRIMARY KEY (id)
);
       
alter table retailstore.ref_cd_vals 
   add constraint FK_REF_CD_GRP_VAL_UNIQ 
   unique (grp_code, val_code);
   
alter table retailstore.ref_cd_vals
   add constraint FK_REF_CD_GRP_VAL_CODE 
   foreign key (grp_code) 
   references ref_cd_grps (grp_code);


insert into retailstore.ref_cd_grps (id, grp_code, grp_desc, grp_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(1, '0001', 'Store Types', 'ST', 1, 'script', now(), ' ', now());
-- ****************
insert into retailstore.ref_cd_vals (id, grp_code, val_code, val_desc, val_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(1, '0001', '0001', 'Electronic Store', 'ES', 1, 'script', now(), ' ', now());

insert into retailstore.ref_cd_vals (id, grp_code, val_code, val_desc, val_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(2, '0001', '0002', 'Grocericies Store', 'GS', 1, 'script', now(), ' ', now());

insert into retailstore.ref_cd_vals (id, grp_code, val_code, val_desc, val_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(3, '0001', '0003', 'Garments Store', 'ES', 1, 'script', now(), ' ', now());
-- ****************


CREATE TABLE retailstore.stores (
    id BIGINT NOT NULL AUTO_INCREMENT,
    ref_val_store_type_id BIGINT NOT NULL,
    store_code VARCHAR(10) NOT NULL,
    store_name VARCHAR(100) NOT NULL,
    email VARCHAR(30) NOT NULL,
    address VARCHAR(255),
    phone VARCHAR(15),
    area VARCHAR(20) NOT NULL,
    city VARCHAR(20) NOT NULL,
    country VARCHAR(20) NOT NULL,
    is_active INTEGER NOT NULL DEFAULT 1,
    created_dt DATETIME(6) NOT NULL,
    created_by VARCHAR(30) NOT NULL,
    modified_by VARCHAR(30),
    modified_dt VARCHAR(255),
    PRIMARY KEY (id)
);

alter table retailstore.stores 
   add constraint FKj9xr2p0s4pwisxkx3e4yxmvif 
   foreign key (ref_val_store_type_id) 
   references ref_cd_vals (id);
   
insert into retailstore.stores(id, ref_val_store_type_id, store_code, store_name, email, address, area, city, country, is_active, created_by, created_dt, modified_by, modified_dt)
values(1, 1, '0001', 'Souk', 'dummy@dummy.com', '21-03', 'Sentul', 'KL', 'Thailand', 1, 'script', now(), ' ', now());

insert into retailstore.stores(id, ref_val_store_type_id, store_code, store_name, email, address, area, city, country, is_active, created_by, created_dt, modified_by, modified_dt)
values(2, 2, '0002', 'Lowyat', 'dummy@dummy.com', '21-03', 'Sentul', 'KL', 'Thailand', 1, 'script', now(), ' ', now());
-- ****************

CREATE TABLE retailstore.employee (
    id BIGINT NOT NULL,
    store_id BIGINT NOT NULL,
    customer_id BIGINT,
    ref_val_designation_id BIGINT NOT NULL,
    full_name VARCHAR(30) NOT NULL,
    user_login VARCHAR(30) NOT NULL UNIQUE,
    user_password VARCHAR(50) NOT NULL,
    issue_dt DATETIME(6) NOT NULL,
    expiry_dt DATETIME(6) NOT NULL,
    no_of_login_attempts INT(1) DEFAULT 3 NOT NULL,
    last_login_dt DATETIME(6) NOT NULL,
    manager_id BIGINT,
    is_active INTEGER NOT NULL DEFAULT 1,
    created_dt DATETIME(6) NOT NULL,
    created_by VARCHAR(30) NOT NULL,
    modified_by VARCHAR(30),
    modified_dt VARCHAR(255),
    PRIMARY KEY (id)
);

alter table retailstore.employee 
   add constraint FKghecv11ypswk5w7mmcof2dscg 
   foreign key (manager_id) 
   references employee (id);

alter table retailstore.employee 
   add constraint FKi5stpfyuad4u92m9yhjtw3r3r 
   foreign key (ref_val_designation_id) 
   references ref_cd_vals (id);

alter table retailstore.employee 
   add constraint FKm3axtut6m0io9h2ke2we28vi3 
   foreign key (store_id) 
   references stores (id);
   
insert into retailstore.ref_cd_grps (id, grp_code, grp_desc, grp_shrt_desc,  is_active, created_by, created_dt, modified_by, modified_dt)
values(2, '0002', 'Employee Designations', 'ED', 1, 'script', now(), ' ', now());
-- ****************
insert into retailstore.ref_cd_vals (id, grp_code, val_code, val_desc, val_shrt_desc,  is_active, created_by, created_dt, modified_by, modified_dt)
values(4, '0002', '0001', 'Garments Store', 'ES',  1, 'script', now(), ' ', now());
-- ****************
insert into retailstore.employee(id, store_id, customer_id, manager_id, ref_val_designation_id, full_name, user_login, user_password, issue_dt, expiry_dt, last_login_dt, no_of_login_attempts, is_active, created_by, created_dt, modified_by, modified_dt)
values(1, 1, null, null, 4, 'Zohaib Asim', 'zohaib.asim', 'zohaib@123', now(), (now() + interval 10 year), now(), 3,  1, 'script', now(), ' ', now());
-- ----------------


CREATE TABLE retailstore.customers (
    id BIGINT NOT NULL,
    ref_val_customer_type_id BIGINT NOT NULL,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    modile_no VARCHAR(15) NOT NULL,
    phone_no VARCHAR(15) NOT NULL,
    email VARCHAR(30) NOT NULL UNIQUE,
    address VARCHAR(255) NOT NULL,
    is_active INTEGER NOT NULL DEFAULT 1,
    created_dt DATETIME(6) NOT NULL,
    created_by VARCHAR(30) NOT NULL,
    modified_by VARCHAR(30),
    modified_dt VARCHAR(255),
    PRIMARY KEY (id)
);

alter table retailstore.employee 
   add constraint FK5k1x33qu519mtk945opdk67g6 
   foreign key (customer_id) 
   references customers (id);
   
alter table retailstore.customers 
   add constraint FKi1xil1ls30ni4x3djh4vlaih 
   foreign key (ref_val_customer_type_id) 
   references ref_cd_vals (id);
       
insert into retailstore.ref_cd_grps (id, grp_code, grp_desc, grp_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(3, '0003', 'Customer Type', 'CT',  1, 'script', now(), ' ', now());
-- ****************
insert into retailstore.ref_cd_vals (id, grp_code, val_code, val_desc, val_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(5, '0003', '0001', 'Employee', 'EMP', 1, 'script', now(), ' ', now());

insert into retailstore.ref_cd_vals (id, grp_code, val_code, val_desc, val_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(6, '0003', '0002', 'Card Holder', 'CH', 1, 'script', now(), ' ', now());

insert into retailstore.ref_cd_vals (id, grp_code, val_code, val_desc, val_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(7, '0003', '0003', 'Regular', 'REG', 1, 'script', now(), ' ', now());
-- ****************
insert into retailstore.customers(id, ref_val_customer_type_id, first_name, last_name, email, phone_no, modile_no, address, is_active, created_by, created_dt, modified_by, modified_dt)
values(1, 5, 'Zohaib', 'Asim', 'dummy@dummy.com', ' ', '601172585540', '21-03', 1, 'script', now(), ' ', now());

insert into retailstore.customers(id, ref_val_customer_type_id, first_name, last_name, email, phone_no, modile_no, address, is_active, created_by, created_dt, modified_by, modified_dt)
values(2, 6, 'Xohaib', 'Asim', 'dummy1@dummy.com', ' ', '601172585541', '21-03', 1, 'script', now(), ' ', now());

insert into retailstore.customers(id, ref_val_customer_type_id, first_name, last_name, email, phone_no, modile_no, address, is_active, created_by, created_dt, modified_by, modified_dt)
values(3, 7, 'Zaib', 'Asim', 'dummy2@dummy.com', ' ', '601172585542', '21-03', 1, 'script', now(), ' ', now());
-- ****************

CREATE TABLE retailstore.products (
    id BIGINT NOT NULL,
    ref_val_prd_category_id BIGINT NOT NULL,
    ref_val_prd_type_id BIGINT NOT NULL,
    prd_desc VARCHAR(100) NOT NULL,
    buy_price DECIMAL(10 , 3 ) DEFAULT 0 NOT NULL,
    retail_price DECIMAL(10 , 3 ) DEFAULT 0 NOT NULL,
    quantity_in_stock BIGINT DEFAULT 0 NOT NULL,
    is_active INTEGER NOT NULL DEFAULT 1,
    created_dt DATETIME(6) NOT NULL,
    created_by VARCHAR(30) NOT NULL,
    modified_by VARCHAR(30),
    modified_dt VARCHAR(255),
    PRIMARY KEY (id)
);

alter table retailstore.products 
   add constraint FK88rcgb7vf3feidmr9jsa7x48o 
   foreign key (ref_val_prd_category_id) 
   references ref_cd_vals (id);

alter table retailstore.products 
   add constraint FKcxutky0h3fy10saeieawu5n7w 
   foreign key (ref_val_prd_type_id) 
   references ref_cd_vals (id);
-- ****************************
insert into retailstore.ref_cd_grps (id, grp_code, grp_desc, grp_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(4, '0004', 'Product Category', 'CT',  1, 'script', now(), ' ', now());

insert into retailstore.ref_cd_grps (id, grp_code, grp_desc, grp_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(5, '0005', 'Product Type', 'CT',  1, 'script', now(), ' ', now());
-- ****************************
insert into retailstore.ref_cd_vals (id, grp_code, val_code, val_desc, val_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(8, '0004', '0001', 'Electronic', 'ELEC', 1, 'script', now(), ' ', now());
insert into retailstore.ref_cd_vals (id, grp_code, val_code, val_desc, val_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(9, '0004', '0002', 'Clothing', 'Cloth', 1, 'script', now(), ' ', now());
insert into retailstore.ref_cd_vals (id, grp_code, val_code, val_desc, val_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(10, '0004', '0003', 'Grocery', 'Grocery', 1, 'script', now(), ' ', now());

insert into retailstore.ref_cd_vals (id, grp_code, val_code, val_desc, val_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(11, '0005', '0001', 'Head Phones', 'Grocery', 1, 'script', now(), ' ', now());
insert into retailstore.ref_cd_vals (id, grp_code, val_code, val_desc, val_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(12, '0005', '0002', 'Meat', 'Grocery', 1, 'script', now(), ' ', now());
insert into retailstore.ref_cd_vals (id, grp_code, val_code, val_desc, val_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(13, '0005', '0003', 'Vegetables', 'Grocery', 1, 'script', now(), ' ', now());
-- ****************************
insert into retailstore.products (id, ref_val_prd_category_id, ref_val_prd_type_id, prd_desc, buy_price, retail_price, 
	quantity_in_stock, is_active, created_dt, created_by, modified_by, modified_dt)
values(1, 8, 11, 'Sony', 25.50, 45.50, 100, 1, now(),'script',  ' ', now());
insert into retailstore.products (id, ref_val_prd_category_id, ref_val_prd_type_id, prd_desc, buy_price, retail_price, 
	quantity_in_stock, is_active, created_dt, created_by, modified_by, modified_dt)
values(2, 8, 11, 'Audionic', 30.25, 60.00, 100, 1, now(),'script',  ' ', now());
insert into retailstore.products (id, ref_val_prd_category_id, ref_val_prd_type_id, prd_desc, buy_price, retail_price, 
	quantity_in_stock, is_active, created_dt, created_by, modified_by, modified_dt)
values(3, 10, 13, 'Egg Plant', 25.50, 45.50, 100, 1, now(),'script',  ' ', now());
insert into retailstore.products (id, ref_val_prd_category_id, ref_val_prd_type_id, prd_desc, buy_price, retail_price, 
	quantity_in_stock, is_active, created_dt, created_by, modified_by, modified_dt)
values(4, 10, 13, 'Potato', 30.25, 60.00, 100, 1, now(),'script',  ' ', now());
insert into retailstore.products (id, ref_val_prd_category_id, ref_val_prd_type_id, prd_desc, buy_price, retail_price, 
	quantity_in_stock, is_active, created_dt, created_by, modified_by, modified_dt)
values(5, 8, 11, 'Samsung', 30.25, 60.00, 100, 1, now(),'script',  ' ', now());
insert into retailstore.products (id, ref_val_prd_category_id, ref_val_prd_type_id, prd_desc, buy_price, retail_price, 
	quantity_in_stock, is_active, created_dt, created_by, modified_by, modified_dt)
values(6, 8, 11, 'TCL', 30.25, 60.00, 100, 1, now(),'script',  ' ', now());


CREATE TABLE retailstore.orders (
    id BIGINT NOT NULL,
    ref_val_status_id BIGINT NOT NULL,
    order_dt DATETIME(6) NOT NULL,
    order_shipment_dt DATETIME(6) NOT NULL,
    order_total DECIMAL(10 , 3 ) DEFAULT 0 NOT NULL,
    discount BIGINT NOT NULL DEFAULT 0,
    grand_total DECIMAL(10 , 3 ) DEFAULT 0 NOT NULL,
    is_active INTEGER NOT NULL DEFAULT 1,
    created_dt DATETIME(6) NOT NULL,
    created_by VARCHAR(30) NOT NULL,
    modified_by VARCHAR(30),
    modified_dt VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE retailstore.orders_seq (
    next_val BIGINT
);
insert into retailstore.orders_seq values ( 1 );

alter table retailstore.orders 
       add constraint FKm1sxgmhvc2cgybfan3d1f598q 
       foreign key (ref_val_status_id) 
       references ref_cd_vals (id);

insert into retailstore.ref_cd_grps (id, grp_code, grp_desc, grp_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(6, '0006', 'Order Status', 'OS',  1, 'script', now(), ' ', now());
insert into retailstore.ref_cd_vals (id, grp_code, val_code, val_desc, val_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(14, '0006', '0001', 'In Process', 'In Process', 1, 'script', now(), ' ', now());
insert into retailstore.ref_cd_vals (id, grp_code, val_code, val_desc, val_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(15, '0006', '0002', 'Submitted', 'Submitted', 1, 'script', now(), ' ', now());
insert into retailstore.ref_cd_vals (id, grp_code, val_code, val_desc, val_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(16, '0006', '0003', 'Cancelled', 'Cancelled', 1, 'script', now(), ' ', now());
insert into retailstore.ref_cd_vals (id, grp_code, val_code, val_desc, val_shrt_desc, is_active, created_by, created_dt, modified_by, modified_dt)
values(17, '0006', '0004', 'Shipped', 'Shipped', 1, 'script', now(), ' ', now());


CREATE TABLE retailstore.order_details (
    id BIGINT NOT NULL,
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    price_per_prd DECIMAL(10 , 3 ) DEFAULT 0 NOT NULL,
    quantity BIGINT DEFAULT 0 NOT NULL,
    created_dt DATETIME(6) NOT NULL,
    created_by VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);

alter table retailstore.order_details 
       add constraint FKjyu2qbqt8gnvno9oe9j2s2ldk 
       foreign key (order_id) 
       references orders (id);

    alter table retailstore.order_details 
       add constraint FK4q98utpd73imf4yhttm3w0eax 
       foreign key (product_id) 
       references products (id);

CREATE TABLE retailstore.invoice (
    id BIGINT NOT NULL,
    order_id BIGINT NOT NULL,
    invoice_dt DATETIME(6) NOT NULL,
    ref_val_status_id BIGINT NOT NULL,
    is_active INTEGER NOT NULL DEFAULT 1,
    created_dt DATETIME(6) NOT NULL,
    created_by VARCHAR(30) NOT NULL,
    modified_by VARCHAR(30),
    modified_dt VARCHAR(255),
    PRIMARY KEY (id)
);

alter table retailstore.invoice 
   add constraint FKthf5w8xuexpjinfl7xheakhqn 
   foreign key (order_id) 
   references orders (id);

alter table retailstore.invoice 
   add constraint FK6t6e9lvsw4r8or578smwg0um3 
   foreign key (ref_val_status_id) 
   references ref_cd_vals (id);