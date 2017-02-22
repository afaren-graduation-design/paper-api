UPDATE paperOperation SET operationType = 'DELETE' WHERE id = 1;
UPDATE paperOperation SET operationType = 'DISTRIBUTION' WHERE id = 2;
UPDATE paperOperation SET operationType = 'UNDISTRIBUTION' WHERE id = 3;
UPDATE paperOperation SET operationType = 'DELETE' WHERE id = 4;
UPDATE paperOperation SET operationType = 'DISTRIBUTION' WHERE id = 5;
UPDATE paperOperation SET operationType = 'UNDISTRIBUTION' WHERE id = 6;
UPDATE paperOperation SET operatingTime = 1453287442 WHERE id = 6;

INSERT INTO paperOperation(id,operatorId,operatingTime,paperId,operationType)
VALUES (8,1,1453287441,5,'DISTRIBUTION');

INSERT INTO paperOperation(id,operatorId,operatingTime,paperId,operationType)
VALUES (9,1,1453287441,6,'UNDISTRIBUTION');

INSERT INTO paperOperation(id,operatorId,operatingTime,paperId,operationType)
VALUES (10,1,1453287441,7,'DISTRIBUTION');

INSERT INTO paperOperation(id,operatorId,operatingTime,paperId,operationType)
VALUES (11,1,1453287441,8,'UNDISTRIBUTION');