CREATE TABLE userLogicPuzzle (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userID INT NOT NULL ,
  logicPuzzleID INT NOT NULL ,
  userAnswer VARCHAR(128) NOT NULL
);