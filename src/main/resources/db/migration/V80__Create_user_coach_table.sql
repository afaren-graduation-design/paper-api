create table userCoach (
    coachId int(11)NOT NULL,
    userId int(11) NOT NULL ,
    foreign key(userId) references users(id) ,
    foreign key(coachId) references users(id),
    primary key(userId,coachId)
);
