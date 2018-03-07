create table userx (
username	varchar(100),
firstName	varchar(100),
lastName	varchar(100),
email		varchar(100),
password	varchar(100),
phone		varchar(100),
userStatus	varchar(100)
)
ALTER TABLE  userx ADD CONSTRAINT userx_pk PRIMARY KEY (username);
