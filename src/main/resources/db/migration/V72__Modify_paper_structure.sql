ALTER TABLE `paper` ADD COLUMN description VARCHAR(128);
ALTER TABLE `paper` ADD COLUMN createTime VARCHAR(128);
ALTER TABLE `paper` ADD COLUMN isDistribution BOOLEAN DEFAULT NULL;