create table userPrivilege(
    userId int not null,
    privilege enum("MENTOR","OPERATOR"),
    foreign key(userId) references users(id) ,
    primary key(userId,privilege)
);
