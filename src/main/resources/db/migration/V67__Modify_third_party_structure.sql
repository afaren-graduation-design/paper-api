ALTER TABLE `thirdParty` DROP COLUMN id;
ALTER TABLE `thirdParty` CHANGE `thirdPartyId` `thirdPartyUserId` int;
ALTER TABLE `thirdParty` CHANGE `thirdType` `type` varchar(128);