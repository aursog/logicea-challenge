create table tbl_user(
    uuid binary(16) primary key,
    username varchar(100) not null unique,
    passwd varchar(255) not null,
    role varchar(255) not null
);

create table tbl_card(
    uuid binary(16) primary key,
    name varchar(255) not null,
    description text null,
    color varchar(7) null,
    card_state varchar(20) not null,
    user_uuid binary(16) not null,
    created_at timestamp,
    updated_at timestamp
);

alter table tbl_card add constraint fk_user_uuid_card
foreign key (user_uuid) references tbl_user(uuid);