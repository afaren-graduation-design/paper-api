create table studentMentor (
    mentorId int(11)NOT NULL,
    studentId int(11) NOT NULL ,
    foreign key(studentId) references users(id) ,
    foreign key(mentorId) references users(id),
    primary key(studentId,mentorId)
);
