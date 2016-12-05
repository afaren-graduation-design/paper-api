create table userProgram (
    userId int(11) NOT NULL ,
    programId int(11)NOT NULL,
    foreign key(userId) references users(id) on delete cascade on update cascade,
    foreign key(programId) references programs(id) on delete cascade on update cascade,
    primary key(userId,programId)
);
