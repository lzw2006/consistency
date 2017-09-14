create table tb_platform
(
  id int auto_increment
    primary key,
  service varchar(128) null,
  seq int null,
  status varchar(45) null,
  update_time datetime null,
  tb_name varchar(45) null
);

create table tb_event
(
  id int not null
    primary key,
  event varchar(45) null,
  time datetime null
);