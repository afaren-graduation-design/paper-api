create table stack(
   stackId INT not null primary key AUTO_INCREMENT,
   title VARCHAR(128) NOT NULL  UNIQUE,
   description VARCHAR(128) NOT NULL,
   definitionFile VARCHAR(128) NOT NULL
) DEFAULT CHARSET=utf8;
