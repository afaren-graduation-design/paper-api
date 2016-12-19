create table userMentor (
    mentorId int(11)NOT NULL,
    userId int(11) NOT NULL ,
    foreign key(userId) references users(id) ,
    foreign key(mentorId) references users(id),
    primary key(userId,mentorId)
);
