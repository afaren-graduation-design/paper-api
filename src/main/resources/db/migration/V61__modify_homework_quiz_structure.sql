ALTER TABLE `homeworkPostHistory` CHANGE COLUMN `homeworkURL` `userAnswerRepo` VARCHAR(512) NOT NULL;
ALTER TABLE `homeworkPostHistory` ADD COLUMN `result` text;