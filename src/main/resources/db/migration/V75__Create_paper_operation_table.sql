create table paperOperation (
    id int not null primary key AUTO_INCREMENT,
    operationType varchar(100) not null,
    operatorId int(11) not null,
    operatingTime int not null,
    paperId int(11) not null
);
