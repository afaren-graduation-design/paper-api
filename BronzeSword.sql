-- MySQL dump 10.13  Distrib 5.7.11, for Linux (x86_64)
--
-- Host: localhost    Database: BronzeSword
-- ------------------------------------------------------
-- Server version	5.7.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `basicBlankQuiz`
--

DROP TABLE IF EXISTS `basicBlankQuiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `basicBlankQuiz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(128) NOT NULL,
  `type` varchar(128) NOT NULL,
  `answer` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basicBlankQuiz`
--

LOCK TABLES `basicBlankQuiz` WRITE;
/*!40000 ALTER TABLE `basicBlankQuiz` DISABLE KEYS */;
INSERT INTO `basicBlankQuiz` VALUES (1,'这是第一道填空题','BASIC_BLANK_QUIZ','javaScript'),(2,'这是第二道填空题','BASIC_BLANK_QUIZ','java');
/*!40000 ALTER TABLE `basicBlankQuiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blankQuiz`
--

DROP TABLE IF EXISTS `blankQuiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blankQuiz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hardCount` int(11) NOT NULL,
  `normalCount` int(11) NOT NULL,
  `easyCount` int(11) NOT NULL,
  `exampleCount` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blankQuiz`
--

LOCK TABLES `blankQuiz` WRITE;
/*!40000 ALTER TABLE `blankQuiz` DISABLE KEYS */;
INSERT INTO `blankQuiz` VALUES (1,3,3,4,2),(2,3,3,4,2),(3,3,2,4,2),(4,3,3,4,2),(5,3,3,4,2),(6,3,5,4,2);
/*!40000 ALTER TABLE `blankQuiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blankQuizSubmit`
--

DROP TABLE IF EXISTS `blankQuizSubmit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `blankQuizSubmit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blankQuizId` int(11) NOT NULL,
  `scoreSheetId` int(11) NOT NULL,
  `startTime` int(11) DEFAULT NULL,
  `endTime` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `blankQuizId` (`blankQuizId`,`scoreSheetId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blankQuizSubmit`
--

LOCK TABLES `blankQuizSubmit` WRITE;
/*!40000 ALTER TABLE `blankQuizSubmit` DISABLE KEYS */;
INSERT INTO `blankQuizSubmit` VALUES (1,1,1,1451581261,1451581361),(2,1,2,1451581261,1451581360),(3,2,3,1451581261,1451581365),(4,1,4,1451581261,1451581364);
/*!40000 ALTER TABLE `blankQuizSubmit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homeworkPostHistory`
--

DROP TABLE IF EXISTS `homeworkPostHistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `homeworkPostHistory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userAnswerRepo` varchar(512) NOT NULL,
  `homeworkSubmitId` int(11) NOT NULL,
  `version` varchar(512) DEFAULT NULL,
  `branch` varchar(32) NOT NULL,
  `status` int(11) NOT NULL,
  `commitTime` int(11) DEFAULT NULL,
  `startTime` int(11) DEFAULT NULL,
  `result` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homeworkPostHistory`
--

LOCK TABLES `homeworkPostHistory` WRITE;
/*!40000 ALTER TABLE `homeworkPostHistory` DISABLE KEYS */;
INSERT INTO `homeworkPostHistory` VALUES (1,'github.com/purple/1',1,'d8160f56ebbb5d40368048f271328eefa87cb97d','master',4,1563287441,1453287441,'jasmine not found'),(2,'github.com/purple/2',2,'d8160f56ebbb5d40368048f271328eefa87cb97d','master',4,1563287500,1453287500,'jasmine not found'),(3,'github.com/purple/3',3,'d8160f56ebbb5d40368048f271328eefa87cb97d','master',4,1563287610,1453287610,'jasmine not found'),(4,'github.com/purple/4',4,'d8160f56ebbb5d40368048f271328eefa87cb97d','dev',4,1563287711,1453287711,'jasmine not found');
/*!40000 ALTER TABLE `homeworkPostHistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homeworkQuiz`
--

DROP TABLE IF EXISTS `homeworkQuiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `homeworkQuiz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(300) NOT NULL,
  `evaluateScript` varchar(2048) NOT NULL,
  `templateRepository` varchar(512) NOT NULL,
  `makerId` int(11) NOT NULL,
  `createTime` int(11) DEFAULT NULL,
  `homeworkName` varchar(120) NOT NULL,
  `answerPath` varchar(255) NOT NULL,
  `stackId` int(11) NOT NULL DEFAULT '1',
  `rawId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homeworkQuiz`
--

LOCK TABLES `homeworkQuiz` WRITE;
/*!40000 ALTER TABLE `homeworkQuiz` DISABLE KEYS */;
INSERT INTO `homeworkQuiz` VALUES (1,'## 编程题答题说明\n点击编程题进入答题页面后，您可以看到导航栏处三个标签，分别为：**题目说明**，**提交作业**，**运行结果**\n### 题目说明\n题目说明标签内包含：\n![All text](https://raw.githubusercontent.com/sialvsic/TwicePic/master/desc1.jpg)\n![Alt text](https://raw.githubusercontent.com/sialvsic/TwicePic/master/desc2.jpg)\n![Alt text](https://raw.githubusercontent.com/s','/homework-script/check-readme.sh','',1,123456,'homework1','/homework-answer/check-readme',1,1),(2,'## 题目要求\n- 请用JavaScript语言完成此题\n- 请在开始答题后 `7` 天内完成\n\n------------------\n## 题目描述\n写一个函数，使该函数返回输入数组中所有第偶数个元素的中位数：\n\n```\n输入&&输出：\n当输入数据为 [1,2,3,4]时      输出为 3\n```\n	\n**NOTE：**请注意数据格式\n\n------------\n\n## 答题流程\n1. 请用户仔细阅读题目要求和题目描述\n\n2. 在命令行中使用以下命令在用户本地任意目录下clone此题目库\n	\n	```	\n	$ git clone https://github.com/simpletrai','/homework-script/calculate_median.sh','https://github.com/simpletrain/easy-calculate.git',2,123457,'homework2','/homework-answer/calculate_median',2,2),(3,'## 题目要求\n- 请用JavaScript语言完成此题\n- 请在开始答题后 `7` 天内完成\n\n------------------\n## 题目描述\n写一个函数，使该函数返回输入数组中所有第偶数个元素的中位数：\n\n```\n输入&&输出：\n当输入数据为 [1,2,3,4]时      输出为 3\n```\n	\n**NOTE：**请注意数据格式\n\n------------\n\n## 答题流程\n1. 请用户仔细阅读题目要求和题目描述\n\n2. 在命令行中使用以下命令在用户本地任意目录下clone此题目库\n	\n	```	\n	$ git clone https://github.com/simpletrai','/homework-script/calculate_median.sh','https://github.com/simpletrain/easy-calculate.git',2,123458,'homework3','/homework-answer/calculate_median',2,3),(4,'## 题目要求\n- 请用javascript语言完成此题\n- 请在开始答题后 `7` 天内完成\n\n------------------\n## 题目描述\n实现src/collect_all_even.js中的collect_same_elements函数，使该函数满足如下要求：\n\n选出A集合中元素的key属性，跟B对象中value属性中的元素相同的元素\n```\n输入&&输出：\n输入: \nA = [{key: \"a\"}, {key: \"e\"}, {key: \"h\"}, {key: \"t\"}, {key: \"f\"}, {key: \"c\"}, {key: \"g\"}, {key: \"b\"}, {key:','/homework-script/configure.sh','https://github.com/purpletianjing/test-post.git',1,123459,'homework4','/homework-answer/configure',1,4),(5,'## 题目要求\n- 请用javascript语言完成此题\n- 请在开始答题后 `7` 天内完成\n\n------------------   \n## 题目描述\n分别写两个函数，使函数分别满足以下要求：\n```\n1.把二维数组变成一维数组\n输入：[1, [2], [3, 4]]\n输出：[1, 2, 3, 4]\n2.消除重复,按照第一次出现的顺序排列最后的输出结果\n输入：[[1, 2, 3], [5, 2, 1, 4], [2, 1]]\n输出：[1, 2, 3, 5, 4]\n```\n**NOTE：**请注意数据格式\n\n------------\n\n## 答题流程\n1. 请用户仔细阅读题目要求和题目描述','/homework-script/collection-calculate-camp.sh','https://github.com/wengjiaojiao/empty-flaten.git',1,123450,'homework5','/homework-answer/collection-calculate-camp',1,5),(6,'## 题目要求\n- 请用javascript语言完成此题\n- 请在开始答题后 `7` 天内完成\n\n------------------\n\n## 题目描述\n题目：集合运算\n\n写一个函数，使该函数满足如下要求：\n选出A集合中与B集合中相同的元素\n\n```\n输入&&输出：\n输入为：\n[\"a\", \"e\", \"h\", \"t\", \"f\", \"c\", \"g\", \"b\", \"d\"];\n[\"a\", \"d\", \"e\", \"f\"];\n\n输出为：\n[\"a\", \"e\", \"f\", \"d\"]\n```\n\n**NOTE：**请注意数据格式\n\n\n------------\n\n## 答题流程\n1. 请用户仔细阅读题目要求和题目描述','/homework-script/prepos.sh','https://github.com/Lucky-LengYi/pre-pos-sec-1.git',1,123450,'homework6','/homework-answer/prepos',3,6),(7,'## 题目要求\n- 请用javascript语言完成此题\n- 请在开始答题后 `7` 天内完成\n\n------------------\n\n## 题目描述\n题目：菲波那切数列  0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55\n写出一个生成前n+1个菲波那切数列的函数：\n```\n输入&&输出：\n当输入为1时      输出为 [0,1]\n当输入为2时      输出为 [0,1,1]\n当输入为10时     输出为 [0,1,1,2,3,5,8,13,21,34,55]\n```\n\n**NOTE：**请注意数据格式\n\n------------\n\n## 答题流程\n1. 请用户仔','/homework-script/fibonacci_series.sh','https://github.com/sialvsic/fibonacci_series.git',1,123450,'homework7','/homework-answer/fibonacci_series',3,7),(8,'## 题目要求\n- 请用javascript语言完成此题\n- 请在开始答题后 `7` 天内完成\n\n------------------\n## 题目描述\n写一个可以取出集合中所有偶数的函数，使该函数满足如下要求：\n```\n输入&&输出：\n当输入集合为 [1,2]        输出为 [2]\n当输入集合为 [0,1,2]      输出为 [0,2]\n当输入集合为 [2,4,6]      输出为 [2,4,6]\n```\n\n**NOTE：**请注意数据格式\n\n------------\n\n## 答题流程\n1. 请用户仔细阅读题目要求和题目描述\n\n2. 在命令行中使用以下命令在用户本地任意目录下cl','/homework-script/collection.sh','https://github.com/AnliHuer/collection.git',1,123450,'homework8','/homework-answer/collection',3,8);
/*!40000 ALTER TABLE `homeworkQuiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homeworkQuizOperation`
--

DROP TABLE IF EXISTS `homeworkQuizOperation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `homeworkQuizOperation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `operationType` enum('DELETE') DEFAULT NULL,
  `operatorId` int(11) NOT NULL,
  `operatingTime` int(11) NOT NULL,
  `homeworkQuizId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homeworkQuizOperation`
--

LOCK TABLES `homeworkQuizOperation` WRITE;
/*!40000 ALTER TABLE `homeworkQuizOperation` DISABLE KEYS */;
INSERT INTO `homeworkQuizOperation` VALUES (1,'DELETE',1,1453287441,1),(2,'DELETE',1,1453287441,2),(3,'DELETE',1,1453287441,3),(4,'DELETE',1,1453287441,4);
/*!40000 ALTER TABLE `homeworkQuizOperation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homeworkSubmit`
--

DROP TABLE IF EXISTS `homeworkSubmit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `homeworkSubmit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `homeworkQuizId` int(11) NOT NULL,
  `scoreSheetId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homeworkSubmit`
--

LOCK TABLES `homeworkSubmit` WRITE;
/*!40000 ALTER TABLE `homeworkSubmit` DISABLE KEYS */;
INSERT INTO `homeworkSubmit` VALUES (1,1,1),(2,2,1),(3,3,1),(4,1,2),(5,2,3),(6,4,4),(7,5,4);
/*!40000 ALTER TABLE `homeworkSubmit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemPost`
--

DROP TABLE IF EXISTS `itemPost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itemPost` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blankQuizSubmitId` int(11) NOT NULL,
  `quizItemId` int(11) NOT NULL,
  `userAnswer` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemPost`
--

LOCK TABLES `itemPost` WRITE;
/*!40000 ALTER TABLE `itemPost` DISABLE KEYS */;
INSERT INTO `itemPost` VALUES (1,1,1,'23'),(2,1,2,'16'),(3,1,3,'20'),(4,2,2,'13'),(5,3,3,'9'),(6,4,4,'10');
/*!40000 ALTER TABLE `itemPost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loginDetail`
--

DROP TABLE IF EXISTS `loginDetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loginDetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `token` varchar(32) NOT NULL,
  `loginDate` int(11) NOT NULL,
  `logoutDate` int(11) DEFAULT NULL,
  `flag` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loginDetail`
--

LOCK TABLES `loginDetail` WRITE;
/*!40000 ALTER TABLE `loginDetail` DISABLE KEYS */;
INSERT INTO `loginDetail` VALUES (1,1,'ce08446f20b3b3aa4bee97298a1392b7',1453287441,1453287441,0),(2,1,'e652621b9bd77a2ea4a4495ab03e3cc8',1453287541,NULL,1),(3,3,'8c87895409e7e8c6f7d3f4a42ee0ae15',1453387441,1453387451,0);
/*!40000 ALTER TABLE `loginDetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `multipleChoice`
--

DROP TABLE IF EXISTS `multipleChoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `multipleChoice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(128) NOT NULL,
  `options` varchar(128) NOT NULL,
  `type` varchar(128) NOT NULL,
  `answer` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `multipleChoice`
--

LOCK TABLES `multipleChoice` WRITE;
/*!40000 ALTER TABLE `multipleChoice` DISABLE KEYS */;
INSERT INTO `multipleChoice` VALUES (1,'这是第一道多选题','1,2,3,4','MULTIPLE_CHOICE','3,4'),(2,'这是第二道多选题','5,6,7,8','MULTIPLE_CHOICE','5,6');
/*!40000 ALTER TABLE `multipleChoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paper`
--

DROP TABLE IF EXISTS `paper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `makerId` int(11) NOT NULL,
  `paperName` varchar(128) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `createTime` int(11) DEFAULT NULL,
  `programId` int(11) DEFAULT NULL,
  `paperType` enum('practice','exam') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paper`
--

LOCK TABLES `paper` WRITE;
/*!40000 ALTER TABLE `paper` DISABLE KEYS */;
INSERT INTO `paper` VALUES (1,1,'简单的试卷','simple',2016,1,'practice'),(2,2,'一般的试卷','standard',2016,3,'practice'),(4,2,'测试试卷','f',2016,6,'practice'),(5,3,'java','a',2017,6,'exam'),(6,2,'js','b',2014,6,'exam'),(7,2,'c++','c',2013,6,'practice'),(8,5,'c','d',2016,6,'exam'),(9,2,'ruby','e',2015,6,'practice'),(10,3,'scale','e',2015,6,'exam'),(11,7,'react','e',2015,6,'exam');
/*!40000 ALTER TABLE `paper` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paperOperation`
--

DROP TABLE IF EXISTS `paperOperation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paperOperation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `operatorId` int(11) NOT NULL,
  `operatingTime` int(11) NOT NULL,
  `paperId` int(11) NOT NULL,
  `operationType` enum('DELETE','DISTRIBUTION','UNDISTRIBUTION') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paperOperation`
--

LOCK TABLES `paperOperation` WRITE;
/*!40000 ALTER TABLE `paperOperation` DISABLE KEYS */;
INSERT INTO `paperOperation` VALUES (1,1,1453287441,1,'DISTRIBUTION'),(2,1,1453287441,2,'DISTRIBUTION'),(3,1,1453287441,3,'UNDISTRIBUTION'),(4,2,1453287441,4,'DELETE'),(5,2,1453287441,5,'DISTRIBUTION'),(6,1,1453287442,5,'UNDISTRIBUTION');
/*!40000 ALTER TABLE `paperOperation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passwordRetrieveDetail`
--

DROP TABLE IF EXISTS `passwordRetrieveDetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passwordRetrieveDetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `token` varchar(32) DEFAULT NULL,
  `retrieveDate` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passwordRetrieveDetail`
--

LOCK TABLES `passwordRetrieveDetail` WRITE;
/*!40000 ALTER TABLE `passwordRetrieveDetail` DISABLE KEYS */;
INSERT INTO `passwordRetrieveDetail` VALUES (1,'test@163.com','ce08446f20b3b3aa4bee97298a1392b7',1451581261),(2,'wjj@qq.com','e652621b9bd77a2ea4a4495ab03e3cc8',1487324305),(3,'test2@qq.com',NULL,NULL);
/*!40000 ALTER TABLE `passwordRetrieveDetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programs`
--

DROP TABLE IF EXISTS `programs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `programs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `uriEnable` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programs`
--

LOCK TABLES `programs` WRITE;
/*!40000 ALTER TABLE `programs` DISABLE KEYS */;
INSERT INTO `programs` VALUES (1,'一年级',1),(2,'二年级',1),(3,'三年级',0),(4,'四年级',0);
/*!40000 ALTER TABLE `programs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quizItem`
--

DROP TABLE IF EXISTS `quizItem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `quizItem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `initializedBox` varchar(128) NOT NULL,
  `stepsString` varchar(2048) NOT NULL,
  `count` int(11) NOT NULL,
  `questionZh` varchar(128) NOT NULL,
  `stepsLength` int(11) NOT NULL,
  `maxUpdateTimes` int(11) NOT NULL,
  `answer` varchar(128) DEFAULT NULL,
  `descriptionZh` varchar(2048) NOT NULL,
  `chartPath` varchar(128) NOT NULL,
  `infoPath` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quizItem`
--

LOCK TABLES `quizItem` WRITE;
/*!40000 ALTER TABLE `quizItem` DISABLE KEYS */;
INSERT INTO `quizItem` VALUES (1,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0APut(number_in_box(4),%20into_box(4)),%0AChange_Box_Number(the_instruction_box(step_number(9),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(9),%202),%20number_in_box(2)),%20then_go_to_step(7),%20then_go_to_step(6)),%0AOperation(Multiply(),%20number_in_box(6),%20number_in_box(9),%20put_result_into_box(6)),%0AVerify(greater_than(instruction_box_number(step_number(9),%201),%20number_in_box(5)),%20then_go_to_step(3),%20then_go_to_step(2)),%0AVerify(greater_than(instruction_box_number(step_number(9),%202),%20number_in_box(2)),%20then_go_to_step(8),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(9),%201),%20increase(1)),%0AChange_Box_Number(the_instruction_box(step_number(1),%202),%20increase(1)),%0APut(number_in_box(4),%20into_box(2)),%20End())',33,'经过以上操作之后，现在6号盒子中的数字是多少?',11,5,'229376','[\"\",\"将4号盒子中的数字放在4号盒子中\",\"更改指令9：将该指令中的第2个盒子的编号加1\",\"判断：指令9中第2个盒子的编号比2号盒子中的数字大吗\",\"相乘：6号盒子中的数字*9号盒子中的数字，将结果放在6号盒子中。\",\"判断：指令9中第1个盒子的编号比5号盒子中的数字大吗\",\"判断：指令9中第2个盒子的编号比2号盒子中的数字大吗\",\"更改指令9：将该指令中的第1个盒子的编号加1\",\"更改指令1：将该指令中的第2个盒子的编号加1\",\"将4号盒子中的数字放在2号盒子中\",\"\"]','logic-puzzle/1.png','logic-puzzle/1.json'),(2,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AOperation(Multiply(),%20number_in_box(1),%20number_in_box(5),%20put_result_into_box(3)),%0APut(number_in_box(8),%20into_box(1)),%0AVerify(greater_than(instruction_box_number(step_number(1),%201),%20number_in_box(8)),%20then_go_to_step(6),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(1),%201),%20increase(2)),%0AVerify(greater_than(instruction_box_number(step_number(7),%201),%20number_in_box(5)),%20then_go_to_step(7),%20then_go_to_step(1)),%0AVerify(greater_than(instruction_box_number(step_number(2),%201),%20number_in_box(1)),%20then_go_to_step(7),%20then_go_to_step(1)),%0APut(number_in_box(5),%20into_box(3)),%0AChange_Box_Number(the_instruction_box(step_number(1),%202),%20increase(1)),%0AChange_Box_Number(the_instruction_box(step_number(1),%201),%20increase(1)),%20End())',19,'经过以上操作之后，现在3号盒子中的数字是多少?',11,4,'5','[\"\",\"相乘：1号盒子中的数字*5号盒子中的数字，将结果放在3号盒子中。\",\"将8号盒子中的数字放在1号盒子中\",\"判断：指令1中第1个盒子的编号比8号盒子中的数字大吗\",\"更改指令1：将该指令中的第1个盒子的编号加2\",\"判断：指令7中第1个盒子的编号比5号盒子中的数字大吗\",\"判断：指令2中第1个盒子的编号比1号盒子中的数字大吗\",\"将5号盒子中的数字放在3号盒子中\",\"更改指令1：将该指令中的第2个盒子的编号加1\",\"更改指令1：将该指令中的第1个盒子的编号加1\",\"\"]','logic-puzzle/10.png','logic-puzzle/10.json'),(3,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AOperation(Multiply(),%20number_in_box(6),%20number_in_box(3),%20put_result_into_box(7)),%0APut(number_in_box(2),%20into_box(8)),%0AVerify(greater_than(instruction_box_number(step_number(1),%202),%20number_in_box(8)),%20then_go_to_step(7),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(1),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(7),%202),%20number_in_box(6)),%20then_go_to_step(1),%20then_go_to_step(6)),%0AVerify(greater_than(instruction_box_number(step_number(7),%201),%20number_in_box(7)),%20then_go_to_step(8),%20then_go_to_step(1)),%0APut(number_in_box(7),%20into_box(7)),%0AChange_Box_Number(the_instruction_box(step_number(2),%201),%20increase(2)),%0AChange_Box_Number(the_instruction_box(step_number(1),%201),%20increase(1)),%20End())',38,'经过以上操作之后，现在7号盒子中的数字是多少?',11,6,'49','[\"\",\"相乘：6号盒子中的数字*3号盒子中的数字，将结果放在7号盒子中。\",\"将2号盒子中的数字放在8号盒子中\",\"判断：指令1中第2个盒子的编号比8号盒子中的数字大吗\",\"更改指令1：将该指令中的第2个盒子的编号加1\",\"判断：指令7中第2个盒子的编号比6号盒子中的数字大吗\",\"判断：指令7中第1个盒子的编号比7号盒子中的数字大吗\",\"将7号盒子中的数字放在7号盒子中\",\"更改指令2：将该指令中的第1个盒子的编号加2\",\"更改指令1：将该指令中的第1个盒子的编号加1\",\"\"]','logic-puzzle/11.png','logic-puzzle/11.json'),(4,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0APut(number_in_box(1),%20into_box(1)),%0AOperation(Multiply(),%20number_in_box(8),%20number_in_box(8),%20put_result_into_box(2)),%0AVerify(greater_than(instruction_box_number(step_number(1),%201),%20number_in_box(5)),%20then_go_to_step(7),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(1),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(1),%201),%20number_in_box(3)),%20then_go_to_step(1),%20then_go_to_step(6)),%0AVerify(greater_than(instruction_box_number(step_number(1),%202),%20number_in_box(4)),%20then_go_to_step(6),%20then_go_to_step(1)),%0APut(number_in_box(7),%20into_box(5)),%0AChange_Box_Number(the_instruction_box(step_number(2),%202),%20increase(1)),%0AChange_Box_Number(the_instruction_box(step_number(1),%202),%20increase(1)),%20End())',34,'经过以上操作之后，现在1号盒子中的数字是多少?',11,5,'7','[\"\",\"将1号盒子中的数字放在1号盒子中\",\"相乘：8号盒子中的数字*8号盒子中的数字，将结果放在2号盒子中。\",\"判断：指令1中第1个盒子的编号比5号盒子中的数字大吗\",\"更改指令1：将该指令中的第1个盒子的编号加1\",\"判断：指令1中第1个盒子的编号比3号盒子中的数字大吗\",\"判断：指令1中第2个盒子的编号比4号盒子中的数字大吗\",\"将7号盒子中的数字放在5号盒子中\",\"更改指令2：将该指令中的第2个盒子的编号加1\",\"更改指令1：将该指令中的第2个盒子的编号加1\",\"\"]','logic-puzzle/12.png','logic-puzzle/12.json'),(5,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0APut(number_in_box(3),%20into_box(9)),%0AOperation(Multiply(),%20number_in_box(3),%20number_in_box(3),%20put_result_into_box(9)),%0AVerify(greater_than(instruction_box_number(step_number(7),%202),%20number_in_box(5)),%20then_go_to_step(6),%20then_go_to_step(6)),%0AChange_Box_Number(the_instruction_box(step_number(2),%202),%20increase(2)),%0AVerify(greater_than(instruction_box_number(step_number(7),%201),%20number_in_box(6)),%20then_go_to_step(1),%20then_go_to_step(1)),%0AVerify(greater_than(instruction_box_number(step_number(2),%202),%20number_in_box(8)),%20then_go_to_step(7),%20then_go_to_step(4)),%0APut(number_in_box(5),%20into_box(1)),%0AChange_Box_Number(the_instruction_box(step_number(7),%201),%20increase(2)),%0AChange_Box_Number(the_instruction_box(step_number(7),%201),%20increase(2)),%20End())',15,'经过以上操作之后，现在9号盒子中的数字是多少?',11,4,'10','[\"\",\"将3号盒子中的数字放在9号盒子中\",\"相乘：3号盒子中的数字*3号盒子中的数字，将结果放在9号盒子中。\",\"判断：指令7中第2个盒子的编号比5号盒子中的数字大吗\",\"更改指令2：将该指令中的第2个盒子的编号加2\",\"判断：指令7中第1个盒子的编号比6号盒子中的数字大吗\",\"判断：指令2中第2个盒子的编号比8号盒子中的数字大吗\",\"将5号盒子中的数字放在1号盒子中\",\"更改指令7：将该指令中的第1个盒子的编号加2\",\"更改指令7：将该指令中的第1个盒子的编号加2\",\"\"]','logic-puzzle/13.png','logic-puzzle/13.json'),(6,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(6),%201),%20increase(2)),%0AChange_Box_Number(the_instruction_box(step_number(8),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(4)),%20then_go_to_step(4),%20then_go_to_step(2)),%0AChange_Box_Number(the_instruction_box(step_number(9),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(9),%201),%20number_in_box(5)),%20then_go_to_step(8),%20then_go_to_step(6)),%0AOperation(Multiply(),%20number_in_box(6),%20number_in_box(1),%20put_result_into_box(8)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(7)),%20then_go_to_step(3),%20then_go_to_step(5)),%0APut(number_in_box(2),%20into_box(2)),%0APut(number_in_box(1),%20into_box(3)),%20End())',29,'经过以上操作之后，现在8号盒子中的数字是多少?',11,4,'64','[\"\",\"更改指令6：将该指令中的第1个盒子的编号加2\",\"更改指令8：将该指令中的第2个盒子的编号加1\",\"判断：指令6中第1个盒子的编号比4号盒子中的数字大吗\",\"更改指令9：将该指令中的第1个盒子的编号加1\",\"判断：指令9中第1个盒子的编号比5号盒子中的数字大吗\",\"相乘：6号盒子中的数字*1号盒子中的数字，将结果放在8号盒子中。\",\"判断：指令6中第1个盒子的编号比7号盒子中的数字大吗\",\"将2号盒子中的数字放在2号盒子中\",\"将1号盒子中的数字放在3号盒子中\",\"\"]','logic-puzzle/14.png','logic-puzzle/14.json'),(7,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(9),%201),%20increase(2)),%0AChange_Box_Number(the_instruction_box(step_number(8),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(4),%202),%20number_in_box(6)),%20then_go_to_step(8),%20then_go_to_step(4)),%0AOperation(Multiply(),%20number_in_box(1),%20number_in_box(1),%20put_result_into_box(3)),%0AVerify(greater_than(instruction_box_number(step_number(9),%201),%20number_in_box(8)),%20then_go_to_step(6),%20then_go_to_step(5)),%0AChange_Box_Number(the_instruction_box(step_number(4),%202),%20increase(2)),%0AVerify(greater_than(instruction_box_number(step_number(8),%201),%20number_in_box(2)),%20then_go_to_step(3),%20then_go_to_step(2)),%0APut(number_in_box(4),%20into_box(5)),%0APut(number_in_box(5),%20into_box(4)),%20End())',30,'经过以上操作之后，现在3号盒子中的数字是多少?',11,4,'2','[\"\",\"更改指令9：将该指令中的第1个盒子的编号加2\",\"更改指令8：将该指令中的第1个盒子的编号加1\",\"判断：指令4中第2个盒子的编号比6号盒子中的数字大吗\",\"相乘：1号盒子中的数字*1号盒子中的数字，将结果放在3号盒子中。\",\"判断：指令9中第1个盒子的编号比8号盒子中的数字大吗\",\"更改指令4：将该指令中的第2个盒子的编号加2\",\"判断：指令8中第1个盒子的编号比2号盒子中的数字大吗\",\"将4号盒子中的数字放在5号盒子中\",\"将5号盒子中的数字放在4号盒子中\",\"\"]','logic-puzzle/15.png','logic-puzzle/15.json'),(8,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(4),%201),%20increase(1)),%0AChange_Box_Number(the_instruction_box(step_number(9),%202),%20increase(2)),%0AVerify(greater_than(instruction_box_number(step_number(4),%201),%20number_in_box(6)),%20then_go_to_step(4),%20then_go_to_step(6)),%0AOperation(Multiply(),%20number_in_box(1),%20number_in_box(3),%20put_result_into_box(4)),%0AVerify(greater_than(instruction_box_number(step_number(4),%202),%20number_in_box(2)),%20then_go_to_step(8),%20then_go_to_step(6)),%0AChange_Box_Number(the_instruction_box(step_number(4),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(4),%201),%20number_in_box(5)),%20then_go_to_step(1),%20then_go_to_step(4)),%0APut(number_in_box(8),%20into_box(8)),%0APut(number_in_box(6),%20into_box(4)),%20End())',27,'经过以上操作之后，现在4号盒子中的数字是多少?',11,5,'28','[\"\",\"更改指令4：将该指令中的第1个盒子的编号加1\",\"更改指令9：将该指令中的第2个盒子的编号加2\",\"判断：指令4中第1个盒子的编号比6号盒子中的数字大吗\",\"相乘：1号盒子中的数字*3号盒子中的数字，将结果放在4号盒子中。\",\"判断：指令4中第2个盒子的编号比2号盒子中的数字大吗\",\"更改指令4：将该指令中的第2个盒子的编号加1\",\"判断：指令4中第1个盒子的编号比5号盒子中的数字大吗\",\"将8号盒子中的数字放在8号盒子中\",\"将6号盒子中的数字放在4号盒子中\",\"\"]','logic-puzzle/16.png','logic-puzzle/16.json'),(9,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(9),%201),%20increase(1)),%0AChange_Box_Number(the_instruction_box(step_number(4),%202),%20increase(2)),%0AVerify(greater_than(instruction_box_number(step_number(4),%201),%20number_in_box(4)),%20then_go_to_step(4),%20then_go_to_step(7)),%0AOperation(Multiply(),%20number_in_box(3),%20number_in_box(2),%20put_result_into_box(4)),%0AVerify(greater_than(instruction_box_number(step_number(9),%202),%20number_in_box(4)),%20then_go_to_step(6),%20then_go_to_step(8)),%0APut(number_in_box(5),%20into_box(4)),%0AVerify(greater_than(instruction_box_number(step_number(4),%202),%20number_in_box(8)),%20then_go_to_step(8),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(9),%202),%20increase(1)),%0APut(number_in_box(4),%20into_box(3)),%20End())',13,'经过以上操作之后，现在4号盒子中的数字是多少?',11,4,'5','[\"\",\"更改指令9：将该指令中的第1个盒子的编号加1\",\"更改指令4：将该指令中的第2个盒子的编号加2\",\"判断：指令4中第1个盒子的编号比4号盒子中的数字大吗\",\"相乘：3号盒子中的数字*2号盒子中的数字，将结果放在4号盒子中。\",\"判断：指令9中第2个盒子的编号比4号盒子中的数字大吗\",\"将5号盒子中的数字放在4号盒子中\",\"判断：指令4中第2个盒子的编号比8号盒子中的数字大吗\",\"更改指令9：将该指令中的第2个盒子的编号加1\",\"将4号盒子中的数字放在3号盒子中\",\"\"]','logic-puzzle/17.png','logic-puzzle/17.json'),(10,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(9),%202),%20increase(2)),%0AChange_Box_Number(the_instruction_box(step_number(4),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(6),%202),%20number_in_box(7)),%20then_go_to_step(6),%20then_go_to_step(1)),%0AOperation(Multiply(),%20number_in_box(8),%20number_in_box(1),%20put_result_into_box(6)),%0AVerify(greater_than(instruction_box_number(step_number(9),%202),%20number_in_box(6)),%20then_go_to_step(8),%20then_go_to_step(2)),%0APut(number_in_box(8),%20into_box(6)),%0AVerify(greater_than(instruction_box_number(step_number(9),%201),%20number_in_box(6)),%20then_go_to_step(5),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(4),%201),%20increase(1)),%0APut(number_in_box(4),%20into_box(5)),%20End())',23,'经过以上操作之后，现在6号盒子中的数字是多少?',11,5,'4','[\"\",\"更改指令9：将该指令中的第2个盒子的编号加2\",\"更改指令4：将该指令中的第2个盒子的编号加1\",\"判断：指令6中第2个盒子的编号比7号盒子中的数字大吗\",\"相乘：8号盒子中的数字*1号盒子中的数字，将结果放在6号盒子中。\",\"判断：指令9中第2个盒子的编号比6号盒子中的数字大吗\",\"将8号盒子中的数字放在6号盒子中\",\"判断：指令9中第1个盒子的编号比6号盒子中的数字大吗\",\"更改指令4：将该指令中的第1个盒子的编号加1\",\"将4号盒子中的数字放在5号盒子中\",\"\"]','logic-puzzle/18.png','logic-puzzle/18.json'),(11,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(6),%202),%20increase(2)),%0AChange_Box_Number(the_instruction_box(step_number(6),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(5)),%20then_go_to_step(4),%20then_go_to_step(4)),%0AOperation(Multiply(),%20number_in_box(9),%20number_in_box(4),%20put_result_into_box(9)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(6)),%20then_go_to_step(8),%20then_go_to_step(6)),%0APut(number_in_box(1),%20into_box(7)),%0AVerify(greater_than(instruction_box_number(step_number(4),%201),%20number_in_box(2)),%20then_go_to_step(2),%20then_go_to_step(7)),%0AChange_Box_Number(the_instruction_box(step_number(9),%201),%20increase(2)),%0APut(number_in_box(4),%20into_box(6)),%20End())',45,'经过以上操作之后，现在9号盒子中的数字是多少?',11,6,'1','[\"\",\"更改指令6：将该指令中的第2个盒子的编号加2\",\"更改指令6：将该指令中的第1个盒子的编号加1\",\"判断：指令6中第1个盒子的编号比5号盒子中的数字大吗\",\"相乘：9号盒子中的数字*4号盒子中的数字，将结果放在9号盒子中。\",\"判断：指令6中第1个盒子的编号比6号盒子中的数字大吗\",\"将1号盒子中的数字放在7号盒子中\",\"判断：指令4中第1个盒子的编号比2号盒子中的数字大吗\",\"更改指令9：将该指令中的第1个盒子的编号加2\",\"将4号盒子中的数字放在6号盒子中\",\"\"]','logic-puzzle/19.png','logic-puzzle/19.json'),(12,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0APut(number_in_box(9),%20into_box(2)),%0AChange_Box_Number(the_instruction_box(step_number(4),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(9),%201),%20number_in_box(8)),%20then_go_to_step(5),%20then_go_to_step(4)),%0AOperation(Multiply(),%20number_in_box(2),%20number_in_box(3),%20put_result_into_box(3)),%0AVerify(greater_than(instruction_box_number(step_number(4),%201),%20number_in_box(6)),%20then_go_to_step(7),%20then_go_to_step(6)),%0AVerify(greater_than(instruction_box_number(step_number(1),%202),%20number_in_box(5)),%20then_go_to_step(7),%20then_go_to_step(1)),%0AChange_Box_Number(the_instruction_box(step_number(9),%201),%20increase(1)),%0AChange_Box_Number(the_instruction_box(step_number(9),%201),%20increase(1)),%0APut(number_in_box(4),%20into_box(6)),%20End())',40,'经过以上操作之后，现在3号盒子中的数字是多少?',11,4,'560','[\"\",\"将9号盒子中的数字放在2号盒子中\",\"更改指令4：将该指令中的第1个盒子的编号加1\",\"判断：指令9中第1个盒子的编号比8号盒子中的数字大吗\",\"相乘：2号盒子中的数字*3号盒子中的数字，将结果放在3号盒子中。\",\"判断：指令4中第1个盒子的编号比6号盒子中的数字大吗\",\"判断：指令1中第2个盒子的编号比5号盒子中的数字大吗\",\"更改指令9：将该指令中的第1个盒子的编号加1\",\"更改指令9：将该指令中的第1个盒子的编号加1\",\"将4号盒子中的数字放在6号盒子中\",\"\"]','logic-puzzle/2.png','logic-puzzle/2.json'),(13,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(6),%202),%20increase(1)),%0AChange_Box_Number(the_instruction_box(step_number(4),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(4),%201),%20number_in_box(5)),%20then_go_to_step(8),%20then_go_to_step(4)),%0APut(number_in_box(1),%20into_box(4)),%0AVerify(greater_than(instruction_box_number(step_number(4),%202),%20number_in_box(3)),%20then_go_to_step(6),%20then_go_to_step(6)),%0AOperation(Multiply(),%20number_in_box(1),%20number_in_box(3),%20put_result_into_box(8)),%0AVerify(greater_than(instruction_box_number(step_number(4),%202),%20number_in_box(2)),%20then_go_to_step(7),%20then_go_to_step(1)),%0AChange_Box_Number(the_instruction_box(step_number(6),%202),%20increase(2)),%0APut(number_in_box(1),%20into_box(7)),%20End())',35,'经过以上操作之后，现在8号盒子中的数字是多少?',11,4,'2','[\"\",\"更改指令6：将该指令中的第2个盒子的编号加1\",\"更改指令4：将该指令中的第1个盒子的编号加1\",\"判断：指令4中第1个盒子的编号比5号盒子中的数字大吗\",\"将1号盒子中的数字放在4号盒子中\",\"判断：指令4中第2个盒子的编号比3号盒子中的数字大吗\",\"相乘：1号盒子中的数字*3号盒子中的数字，将结果放在8号盒子中。\",\"判断：指令4中第2个盒子的编号比2号盒子中的数字大吗\",\"更改指令6：将该指令中的第2个盒子的编号加2\",\"将1号盒子中的数字放在7号盒子中\",\"\"]','logic-puzzle/20.png','logic-puzzle/20.json'),(14,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(6),%201),%20increase(1)),%0AChange_Box_Number(the_instruction_box(step_number(4),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(4),%202),%20number_in_box(1)),%20then_go_to_step(6),%20then_go_to_step(3)),%0APut(number_in_box(5),%20into_box(2)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(4)),%20then_go_to_step(8),%20then_go_to_step(7)),%0AOperation(Multiply(),%20number_in_box(2),%20number_in_box(8),%20put_result_into_box(3)),%0AVerify(greater_than(instruction_box_number(step_number(4),%202),%20number_in_box(5)),%20then_go_to_step(4),%20then_go_to_step(2)),%0AChange_Box_Number(the_instruction_box(step_number(4),%202),%20increase(2)),%0APut(number_in_box(7),%20into_box(5)),%20End())',23,'经过以上操作之后，现在3号盒子中的数字是多少?',11,4,'512','[\"\",\"更改指令6：将该指令中的第1个盒子的编号加1\",\"更改指令4：将该指令中的第2个盒子的编号加1\",\"判断：指令4中第2个盒子的编号比1号盒子中的数字大吗\",\"将5号盒子中的数字放在2号盒子中\",\"判断：指令6中第1个盒子的编号比4号盒子中的数字大吗\",\"相乘：2号盒子中的数字*8号盒子中的数字，将结果放在3号盒子中。\",\"判断：指令4中第2个盒子的编号比5号盒子中的数字大吗\",\"更改指令4：将该指令中的第2个盒子的编号加2\",\"将7号盒子中的数字放在5号盒子中\",\"\"]','logic-puzzle/21.png','logic-puzzle/21.json'),(15,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(6),%201),%20increase(1)),%0AChange_Box_Number(the_instruction_box(step_number(9),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(9),%201),%20number_in_box(6)),%20then_go_to_step(8),%20then_go_to_step(6)),%0APut(number_in_box(9),%20into_box(2)),%0AVerify(greater_than(instruction_box_number(step_number(9),%202),%20number_in_box(5)),%20then_go_to_step(2),%20then_go_to_step(5)),%0AOperation(Multiply(),%20number_in_box(6),%20number_in_box(6),%20put_result_into_box(7)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(6)),%20then_go_to_step(3),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(6),%201),%20increase(1)),%0APut(number_in_box(2),%20into_box(6)),%20End())',37,'经过以上操作之后，现在7号盒子中的数字是多少?',11,5,'16807','[\"\",\"更改指令6：将该指令中的第1个盒子的编号加1\",\"更改指令9：将该指令中的第1个盒子的编号加1\",\"判断：指令9中第1个盒子的编号比6号盒子中的数字大吗\",\"将9号盒子中的数字放在2号盒子中\",\"判断：指令9中第2个盒子的编号比5号盒子中的数字大吗\",\"相乘：6号盒子中的数字*6号盒子中的数字，将结果放在7号盒子中。\",\"判断：指令6中第1个盒子的编号比6号盒子中的数字大吗\",\"更改指令6：将该指令中的第1个盒子的编号加1\",\"将2号盒子中的数字放在6号盒子中\",\"\"]','logic-puzzle/22.png','logic-puzzle/22.json'),(16,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(9),%202),%20increase(2)),%0AOperation(Multiply(),%20number_in_box(1),%20number_in_box(2),%20put_result_into_box(7)),%0AVerify(greater_than(instruction_box_number(step_number(2),%201),%20number_in_box(5)),%20then_go_to_step(8),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(2),%201),%20increase(2)),%0AVerify(greater_than(instruction_box_number(step_number(2),%202),%20number_in_box(6)),%20then_go_to_step(3),%20then_go_to_step(6)),%0AChange_Box_Number(the_instruction_box(step_number(2),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(9),%201),%20number_in_box(4)),%20then_go_to_step(1),%20then_go_to_step(1)),%0APut(number_in_box(3),%20into_box(2)),%0APut(number_in_box(1),%20into_box(1)),%20End())',21,'经过以上操作之后，现在7号盒子中的数字是多少?',11,4,'2','[\"\",\"更改指令9：将该指令中的第2个盒子的编号加2\",\"相乘：1号盒子中的数字*2号盒子中的数字，将结果放在7号盒子中。\",\"判断：指令2中第1个盒子的编号比5号盒子中的数字大吗\",\"更改指令2：将该指令中的第1个盒子的编号加2\",\"判断：指令2中第2个盒子的编号比6号盒子中的数字大吗\",\"更改指令2：将该指令中的第1个盒子的编号加1\",\"判断：指令9中第1个盒子的编号比4号盒子中的数字大吗\",\"将3号盒子中的数字放在2号盒子中\",\"将1号盒子中的数字放在1号盒子中\",\"\"]','logic-puzzle/23.png','logic-puzzle/23.json'),(17,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(8),%201),%20increase(1)),%0AOperation(Multiply(),%20number_in_box(6),%20number_in_box(5),%20put_result_into_box(1)),%0AVerify(greater_than(instruction_box_number(step_number(9),%202),%20number_in_box(6)),%20then_go_to_step(8),%20then_go_to_step(6)),%0AChange_Box_Number(the_instruction_box(step_number(9),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(2),%202),%20number_in_box(7)),%20then_go_to_step(2),%20then_go_to_step(6)),%0AChange_Box_Number(the_instruction_box(step_number(2),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(2),%202),%20number_in_box(5)),%20then_go_to_step(4),%20then_go_to_step(4)),%0APut(number_in_box(7),%20into_box(7)),%0APut(number_in_box(5),%20into_box(5)),%20End())',25,'经过以上操作之后，现在1号盒子中的数字是多少?',11,4,'28','[\"\",\"更改指令8：将该指令中的第1个盒子的编号加1\",\"相乘：6号盒子中的数字*5号盒子中的数字，将结果放在1号盒子中。\",\"判断：指令9中第2个盒子的编号比6号盒子中的数字大吗\",\"更改指令9：将该指令中的第2个盒子的编号加1\",\"判断：指令2中第2个盒子的编号比7号盒子中的数字大吗\",\"更改指令2：将该指令中的第2个盒子的编号加1\",\"判断：指令2中第2个盒子的编号比5号盒子中的数字大吗\",\"将7号盒子中的数字放在7号盒子中\",\"将5号盒子中的数字放在5号盒子中\",\"\"]','logic-puzzle/24.png','logic-puzzle/24.json'),(18,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(6),%201),%20increase(1)),%0AOperation(Multiply(),%20number_in_box(2),%20number_in_box(3),%20put_result_into_box(1)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(2)),%20then_go_to_step(4),%20then_go_to_step(6)),%0AChange_Box_Number(the_instruction_box(step_number(9),%202),%20increase(2)),%0AVerify(greater_than(instruction_box_number(step_number(2),%202),%20number_in_box(2)),%20then_go_to_step(2),%20then_go_to_step(8)),%0APut(number_in_box(2),%20into_box(8)),%0AVerify(greater_than(instruction_box_number(step_number(9),%201),%20number_in_box(7)),%20then_go_to_step(1),%20then_go_to_step(7)),%0AChange_Box_Number(the_instruction_box(step_number(2),%202),%20increase(1)),%0APut(number_in_box(4),%20into_box(4)),%20End())',34,'经过以上操作之后，现在8号盒子中的数字是多少?',11,5,'1','[\"\",\"更改指令6：将该指令中的第1个盒子的编号加1\",\"相乘：2号盒子中的数字*3号盒子中的数字，将结果放在1号盒子中。\",\"判断：指令6中第1个盒子的编号比2号盒子中的数字大吗\",\"更改指令9：将该指令中的第2个盒子的编号加2\",\"判断：指令2中第2个盒子的编号比2号盒子中的数字大吗\",\"将2号盒子中的数字放在8号盒子中\",\"判断：指令9中第1个盒子的编号比7号盒子中的数字大吗\",\"更改指令2：将该指令中的第2个盒子的编号加1\",\"将4号盒子中的数字放在4号盒子中\",\"\"]','logic-puzzle/25.png','logic-puzzle/25.json'),(19,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(2),%202),%20increase(1)),%0APut(number_in_box(1),%20into_box(3)),%0AVerify(greater_than(instruction_box_number(step_number(2),%201),%20number_in_box(8)),%20then_go_to_step(8),%20then_go_to_step(6)),%0AChange_Box_Number(the_instruction_box(step_number(6),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(9),%202),%20number_in_box(7)),%20then_go_to_step(3),%20then_go_to_step(8)),%0AOperation(Multiply(),%20number_in_box(5),%20number_in_box(1),%20put_result_into_box(2)),%0AVerify(greater_than(instruction_box_number(step_number(6),%202),%20number_in_box(6)),%20then_go_to_step(8),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(2),%201),%20increase(2)),%0APut(number_in_box(5),%20into_box(2)),%20End())',44,'经过以上操作之后，现在2号盒子中的数字是多少?',11,8,'5','[\"\",\"更改指令2：将该指令中的第2个盒子的编号加1\",\"将1号盒子中的数字放在3号盒子中\",\"判断：指令2中第1个盒子的编号比8号盒子中的数字大吗\",\"更改指令6：将该指令中的第2个盒子的编号加1\",\"判断：指令9中第2个盒子的编号比7号盒子中的数字大吗\",\"相乘：5号盒子中的数字*1号盒子中的数字，将结果放在2号盒子中。\",\"判断：指令6中第2个盒子的编号比6号盒子中的数字大吗\",\"更改指令2：将该指令中的第1个盒子的编号加2\",\"将5号盒子中的数字放在2号盒子中\",\"\"]','logic-puzzle/26.png','logic-puzzle/26.json'),(20,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(9),%202),%20increase(1)),%0APut(number_in_box(4),%20into_box(3)),%0AVerify(greater_than(instruction_box_number(step_number(2),%201),%20number_in_box(1)),%20then_go_to_step(7),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(6),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(6)),%20then_go_to_step(8),%20then_go_to_step(6)),%0AOperation(Multiply(),%20number_in_box(2),%20number_in_box(1),%20put_result_into_box(2)),%0AVerify(greater_than(instruction_box_number(step_number(2),%202),%20number_in_box(8)),%20then_go_to_step(1),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(6),%202),%20increase(2)),%0APut(number_in_box(5),%20into_box(7)),%20End())',30,'经过以上操作之后，现在2号盒子中的数字是多少?',11,4,'2','[\"\",\"更改指令9：将该指令中的第2个盒子的编号加1\",\"将4号盒子中的数字放在3号盒子中\",\"判断：指令2中第1个盒子的编号比1号盒子中的数字大吗\",\"更改指令6：将该指令中的第1个盒子的编号加1\",\"判断：指令6中第1个盒子的编号比6号盒子中的数字大吗\",\"相乘：2号盒子中的数字*1号盒子中的数字，将结果放在2号盒子中。\",\"判断：指令2中第2个盒子的编号比8号盒子中的数字大吗\",\"更改指令6：将该指令中的第2个盒子的编号加2\",\"将5号盒子中的数字放在7号盒子中\",\"\"]','logic-puzzle/27.png','logic-puzzle/27.json'),(21,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(9),%201),%20increase(1)),%0APut(number_in_box(6),%20into_box(5)),%0AVerify(greater_than(instruction_box_number(step_number(2),%201),%20number_in_box(3)),%20then_go_to_step(6),%20then_go_to_step(7)),%0AChange_Box_Number(the_instruction_box(step_number(2),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(2),%201),%20number_in_box(6)),%20then_go_to_step(8),%20then_go_to_step(1)),%0AOperation(Multiply(),%20number_in_box(2),%20number_in_box(8),%20put_result_into_box(5)),%0AVerify(greater_than(instruction_box_number(step_number(2),%202),%20number_in_box(7)),%20then_go_to_step(4),%20then_go_to_step(7)),%0AChange_Box_Number(the_instruction_box(step_number(2),%202),%20increase(1)),%0APut(number_in_box(3),%20into_box(2)),%20End())',18,'经过以上操作之后，现在5号盒子中的数字是多少?',11,4,'28','[\"\",\"更改指令9：将该指令中的第1个盒子的编号加1\",\"将6号盒子中的数字放在5号盒子中\",\"判断：指令2中第1个盒子的编号比3号盒子中的数字大吗\",\"更改指令2：将该指令中的第1个盒子的编号加1\",\"判断：指令2中第1个盒子的编号比6号盒子中的数字大吗\",\"相乘：2号盒子中的数字*8号盒子中的数字，将结果放在5号盒子中。\",\"判断：指令2中第2个盒子的编号比7号盒子中的数字大吗\",\"更改指令2：将该指令中的第2个盒子的编号加1\",\"将3号盒子中的数字放在2号盒子中\",\"\"]','logic-puzzle/28.png','logic-puzzle/28.json'),(22,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(2),%202),%20increase(1)),%0AOperation(Multiply(),%20number_in_box(3),%20number_in_box(6),%20put_result_into_box(7)),%0AVerify(greater_than(instruction_box_number(step_number(6),%202),%20number_in_box(7)),%20then_go_to_step(8),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(6),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(8),%202),%20number_in_box(8)),%20then_go_to_step(6),%20then_go_to_step(1)),%0APut(number_in_box(3),%20into_box(2)),%0AVerify(greater_than(instruction_box_number(step_number(2),%202),%20number_in_box(5)),%20then_go_to_step(2),%20then_go_to_step(2)),%0APut(number_in_box(7),%20into_box(5)),%0AChange_Box_Number(the_instruction_box(step_number(6),%202),%20increase(1)),%20End())',37,'经过以上操作之后，现在7号盒子中的数字是多少?',11,7,'4','[\"\",\"更改指令2：将该指令中的第2个盒子的编号加1\",\"相乘：3号盒子中的数字*6号盒子中的数字，将结果放在7号盒子中。\",\"判断：指令6中第2个盒子的编号比7号盒子中的数字大吗\",\"更改指令6：将该指令中的第2个盒子的编号加1\",\"判断：指令8中第2个盒子的编号比8号盒子中的数字大吗\",\"将3号盒子中的数字放在2号盒子中\",\"判断：指令2中第2个盒子的编号比5号盒子中的数字大吗\",\"将7号盒子中的数字放在5号盒子中\",\"更改指令6：将该指令中的第2个盒子的编号加1\",\"\"]','logic-puzzle/29.png','logic-puzzle/29.json'),(23,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AOperation(Multiply(),%20number_in_box(1),%20number_in_box(9),%20put_result_into_box(1)),%0AChange_Box_Number(the_instruction_box(step_number(1),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(1),%201),%20number_in_box(5)),%20then_go_to_step(4),%20then_go_to_step(6)),%0APut(number_in_box(1),%20into_box(9)),%0AVerify(greater_than(instruction_box_number(step_number(1),%201),%20number_in_box(5)),%20then_go_to_step(7),%20then_go_to_step(1)),%0AVerify(greater_than(instruction_box_number(step_number(4),%202),%20number_in_box(4)),%20then_go_to_step(1),%20then_go_to_step(2)),%0AChange_Box_Number(the_instruction_box(step_number(8),%201),%20increase(1)),%0APut(number_in_box(1),%20into_box(2)),%0AChange_Box_Number(the_instruction_box(step_number(4),%201),%20increase(1)),%20End())',26,'经过以上操作之后，现在1号盒子中的数字是多少?',11,5,'40','[\"\",\"相乘：1号盒子中的数字*9号盒子中的数字，将结果放在1号盒子中。\",\"更改指令1：将该指令中的第1个盒子的编号加1\",\"判断：指令1中第1个盒子的编号比5号盒子中的数字大吗\",\"将1号盒子中的数字放在9号盒子中\",\"判断：指令1中第1个盒子的编号比5号盒子中的数字大吗\",\"判断：指令4中第2个盒子的编号比4号盒子中的数字大吗\",\"更改指令8：将该指令中的第1个盒子的编号加1\",\"将1号盒子中的数字放在2号盒子中\",\"更改指令4：将该指令中的第1个盒子的编号加1\",\"\"]','logic-puzzle/3.png','logic-puzzle/3.json'),(24,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(8),%201),%20increase(1)),%0AOperation(Multiply(),%20number_in_box(4),%20number_in_box(3),%20put_result_into_box(3)),%0AVerify(greater_than(instruction_box_number(step_number(2),%202),%20number_in_box(6)),%20then_go_to_step(8),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(2),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(2),%201),%20number_in_box(5)),%20then_go_to_step(7),%20then_go_to_step(6)),%0APut(number_in_box(2),%20into_box(3)),%0AVerify(greater_than(instruction_box_number(step_number(6),%202),%20number_in_box(1)),%20then_go_to_step(2),%20then_go_to_step(3)),%0APut(number_in_box(6),%20into_box(7)),%0AChange_Box_Number(the_instruction_box(step_number(2),%201),%20increase(2)),%20End())',37,'经过以上操作之后，现在3号盒子中的数字是多少?',11,8,'4','[\"\",\"更改指令8：将该指令中的第1个盒子的编号加1\",\"相乘：4号盒子中的数字*3号盒子中的数字，将结果放在3号盒子中。\",\"判断：指令2中第2个盒子的编号比6号盒子中的数字大吗\",\"更改指令2：将该指令中的第2个盒子的编号加1\",\"判断：指令2中第1个盒子的编号比5号盒子中的数字大吗\",\"将2号盒子中的数字放在3号盒子中\",\"判断：指令6中第2个盒子的编号比1号盒子中的数字大吗\",\"将6号盒子中的数字放在7号盒子中\",\"更改指令2：将该指令中的第1个盒子的编号加2\",\"\"]','logic-puzzle/30.png','logic-puzzle/30.json'),(25,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(2),%202),%20increase(1)),%0AOperation(Multiply(),%20number_in_box(3),%20number_in_box(2),%20put_result_into_box(2)),%0AVerify(greater_than(instruction_box_number(step_number(2),%202),%20number_in_box(6)),%20then_go_to_step(8),%20then_go_to_step(6)),%0APut(number_in_box(2),%20into_box(6)),%0AVerify(greater_than(instruction_box_number(step_number(4),%201),%20number_in_box(3)),%20then_go_to_step(4),%20then_go_to_step(2)),%0AChange_Box_Number(the_instruction_box(step_number(2),%201),%20increase(2)),%0AVerify(greater_than(instruction_box_number(step_number(8),%202),%20number_in_box(5)),%20then_go_to_step(2),%20then_go_to_step(4)),%0APut(number_in_box(6),%20into_box(5)),%0AChange_Box_Number(the_instruction_box(step_number(4),%201),%20increase(1)),%20End())',25,'经过以上操作之后，现在2号盒子中的数字是多少?',11,4,'16','[\"\",\"更改指令2：将该指令中的第2个盒子的编号加1\",\"相乘：3号盒子中的数字*2号盒子中的数字，将结果放在2号盒子中。\",\"判断：指令2中第2个盒子的编号比6号盒子中的数字大吗\",\"将2号盒子中的数字放在6号盒子中\",\"判断：指令4中第1个盒子的编号比3号盒子中的数字大吗\",\"更改指令2：将该指令中的第1个盒子的编号加2\",\"判断：指令8中第2个盒子的编号比5号盒子中的数字大吗\",\"将6号盒子中的数字放在5号盒子中\",\"更改指令4：将该指令中的第1个盒子的编号加1\",\"\"]','logic-puzzle/31.png','logic-puzzle/31.json'),(26,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(2),%202),%20increase(1)),%0AOperation(Multiply(),%20number_in_box(5),%20number_in_box(2),%20put_result_into_box(8)),%0AVerify(greater_than(instruction_box_number(step_number(2),%201),%20number_in_box(2)),%20then_go_to_step(4),%20then_go_to_step(6)),%0APut(number_in_box(1),%20into_box(9)),%0AVerify(greater_than(instruction_box_number(step_number(2),%201),%20number_in_box(6)),%20then_go_to_step(8),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(2),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(8),%202),%20number_in_box(1)),%20then_go_to_step(1),%20then_go_to_step(5)),%0APut(number_in_box(4),%20into_box(8)),%0AChange_Box_Number(the_instruction_box(step_number(2),%202),%20increase(2)),%20End())',24,'经过以上操作之后，现在8号盒子中的数字是多少?',11,5,'1','[\"\",\"更改指令2：将该指令中的第2个盒子的编号加1\",\"相乘：5号盒子中的数字*2号盒子中的数字，将结果放在8号盒子中。\",\"判断：指令2中第1个盒子的编号比2号盒子中的数字大吗\",\"将1号盒子中的数字放在9号盒子中\",\"判断：指令2中第1个盒子的编号比6号盒子中的数字大吗\",\"更改指令2：将该指令中的第1个盒子的编号加1\",\"判断：指令8中第2个盒子的编号比1号盒子中的数字大吗\",\"将4号盒子中的数字放在8号盒子中\",\"更改指令2：将该指令中的第2个盒子的编号加2\",\"\"]','logic-puzzle/32.png','logic-puzzle/32.json'),(27,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(8),%202),%20increase(1)),%0AOperation(Multiply(),%20number_in_box(5),%20number_in_box(3),%20put_result_into_box(5)),%0AVerify(greater_than(instruction_box_number(step_number(4),%202),%20number_in_box(8)),%20then_go_to_step(8),%20then_go_to_step(6)),%0APut(number_in_box(7),%20into_box(4)),%0AVerify(greater_than(instruction_box_number(step_number(4),%201),%20number_in_box(2)),%20then_go_to_step(3),%20then_go_to_step(1)),%0AChange_Box_Number(the_instruction_box(step_number(4),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(8),%202),%20number_in_box(7)),%20then_go_to_step(4),%20then_go_to_step(3)),%0APut(number_in_box(4),%20into_box(3)),%0AChange_Box_Number(the_instruction_box(step_number(8),%201),%20increase(2)),%20End())',14,'经过以上操作之后，现在5号盒子中的数字是多少?',11,4,'1','[\"\",\"更改指令8：将该指令中的第2个盒子的编号加1\",\"相乘：5号盒子中的数字*3号盒子中的数字，将结果放在5号盒子中。\",\"判断：指令4中第2个盒子的编号比8号盒子中的数字大吗\",\"将7号盒子中的数字放在4号盒子中\",\"判断：指令4中第1个盒子的编号比2号盒子中的数字大吗\",\"更改指令4：将该指令中的第2个盒子的编号加1\",\"判断：指令8中第2个盒子的编号比7号盒子中的数字大吗\",\"将4号盒子中的数字放在3号盒子中\",\"更改指令8：将该指令中的第1个盒子的编号加2\",\"\"]','logic-puzzle/33.png','logic-puzzle/33.json'),(28,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(4),%202),%20increase(2)),%0AOperation(Multiply(),%20number_in_box(8),%20number_in_box(1),%20put_result_into_box(3)),%0AVerify(greater_than(instruction_box_number(step_number(2),%202),%20number_in_box(2)),%20then_go_to_step(8),%20then_go_to_step(6)),%0APut(number_in_box(1),%20into_box(4)),%0AVerify(greater_than(instruction_box_number(step_number(4),%201),%20number_in_box(2)),%20then_go_to_step(1),%20then_go_to_step(2)),%0AChange_Box_Number(the_instruction_box(step_number(2),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(4),%202),%20number_in_box(2)),%20then_go_to_step(2),%20then_go_to_step(4)),%0APut(number_in_box(8),%20into_box(4)),%0AChange_Box_Number(the_instruction_box(step_number(2),%201),%20increase(1)),%20End())',49,'经过以上操作之后，现在3号盒子中的数字是多少?',11,8,'16','[\"\",\"更改指令4：将该指令中的第2个盒子的编号加2\",\"相乘：8号盒子中的数字*1号盒子中的数字，将结果放在3号盒子中。\",\"判断：指令2中第2个盒子的编号比2号盒子中的数字大吗\",\"将1号盒子中的数字放在4号盒子中\",\"判断：指令4中第1个盒子的编号比2号盒子中的数字大吗\",\"更改指令2：将该指令中的第2个盒子的编号加1\",\"判断：指令4中第2个盒子的编号比2号盒子中的数字大吗\",\"将8号盒子中的数字放在4号盒子中\",\"更改指令2：将该指令中的第1个盒子的编号加1\",\"\"]','logic-puzzle/34.png','logic-puzzle/34.json'),(29,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(4),%202),%20increase(1)),%0APut(number_in_box(9),%20into_box(4)),%0AVerify(greater_than(instruction_box_number(step_number(2),%202),%20number_in_box(5)),%20then_go_to_step(8),%20then_go_to_step(4)),%0AOperation(Multiply(),%20number_in_box(1),%20number_in_box(2),%20put_result_into_box(5)),%0AVerify(greater_than(instruction_box_number(step_number(2),%202),%20number_in_box(1)),%20then_go_to_step(6),%20then_go_to_step(5)),%0AChange_Box_Number(the_instruction_box(step_number(4),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(8),%201),%20number_in_box(7)),%20then_go_to_step(2),%20then_go_to_step(1)),%0APut(number_in_box(4),%20into_box(6)),%0AChange_Box_Number(the_instruction_box(step_number(2),%202),%20increase(2)),%20End())',49,'经过以上操作之后，现在5号盒子中的数字是多少?',11,7,'2','[\"\",\"更改指令4：将该指令中的第2个盒子的编号加1\",\"将9号盒子中的数字放在4号盒子中\",\"判断：指令2中第2个盒子的编号比5号盒子中的数字大吗\",\"相乘：1号盒子中的数字*2号盒子中的数字，将结果放在5号盒子中。\",\"判断：指令2中第2个盒子的编号比1号盒子中的数字大吗\",\"更改指令4：将该指令中的第1个盒子的编号加1\",\"判断：指令8中第1个盒子的编号比7号盒子中的数字大吗\",\"将4号盒子中的数字放在6号盒子中\",\"更改指令2：将该指令中的第2个盒子的编号加2\",\"\"]','logic-puzzle/35.png','logic-puzzle/35.json'),(30,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(6),%202),%20increase(2)),%0AOperation(Multiply(),%20number_in_box(4),%20number_in_box(6),%20put_result_into_box(3)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(8)),%20then_go_to_step(4),%20then_go_to_step(8)),%0APut(number_in_box(3),%20into_box(6)),%0AVerify(greater_than(instruction_box_number(step_number(4),%202),%20number_in_box(5)),%20then_go_to_step(6),%20then_go_to_step(4)),%0APut(number_in_box(6),%20into_box(2)),%0AVerify(greater_than(instruction_box_number(step_number(4),%201),%20number_in_box(6)),%20then_go_to_step(3),%20then_go_to_step(1)),%0AChange_Box_Number(the_instruction_box(step_number(2),%202),%20increase(1)),%0AChange_Box_Number(the_instruction_box(step_number(2),%201),%20increase(2)),%20End())',28,'经过以上操作之后，现在3号盒子中的数字是多少?',11,4,'2401','[\"\",\"更改指令6：将该指令中的第2个盒子的编号加2\",\"相乘：4号盒子中的数字*6号盒子中的数字，将结果放在3号盒子中。\",\"判断：指令6中第1个盒子的编号比8号盒子中的数字大吗\",\"将3号盒子中的数字放在6号盒子中\",\"判断：指令4中第2个盒子的编号比5号盒子中的数字大吗\",\"将6号盒子中的数字放在2号盒子中\",\"判断：指令4中第1个盒子的编号比6号盒子中的数字大吗\",\"更改指令2：将该指令中的第2个盒子的编号加1\",\"更改指令2：将该指令中的第1个盒子的编号加2\",\"\"]','logic-puzzle/36.png','logic-puzzle/36.json'),(31,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(4),%202),%20increase(1)),%0AOperation(Multiply(),%20number_in_box(7),%20number_in_box(4),%20put_result_into_box(2)),%0AVerify(greater_than(instruction_box_number(step_number(2),%201),%20number_in_box(6)),%20then_go_to_step(2),%20then_go_to_step(4)),%0APut(number_in_box(6),%20into_box(2)),%0AVerify(greater_than(instruction_box_number(step_number(4),%202),%20number_in_box(6)),%20then_go_to_step(8),%20then_go_to_step(6)),%0APut(number_in_box(8),%20into_box(2)),%0AVerify(greater_than(instruction_box_number(step_number(2),%202),%20number_in_box(7)),%20then_go_to_step(1),%20then_go_to_step(1)),%0AChange_Box_Number(the_instruction_box(step_number(6),%202),%20increase(1)),%0AChange_Box_Number(the_instruction_box(step_number(2),%201),%20increase(2)),%20End())',44,'经过以上操作之后，现在2号盒子中的数字是多少?',11,11,'49','[\"\",\"更改指令4：将该指令中的第2个盒子的编号加1\",\"相乘：7号盒子中的数字*4号盒子中的数字，将结果放在2号盒子中。\",\"判断：指令2中第1个盒子的编号比6号盒子中的数字大吗\",\"将6号盒子中的数字放在2号盒子中\",\"判断：指令4中第2个盒子的编号比6号盒子中的数字大吗\",\"将8号盒子中的数字放在2号盒子中\",\"判断：指令2中第2个盒子的编号比7号盒子中的数字大吗\",\"更改指令6：将该指令中的第2个盒子的编号加1\",\"更改指令2：将该指令中的第1个盒子的编号加2\",\"\"]','logic-puzzle/37.png','logic-puzzle/37.json'),(32,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(2),%202),%20increase(1)),%0APut(number_in_box(5),%20into_box(4)),%0AVerify(greater_than(instruction_box_number(step_number(4),%201),%20number_in_box(6)),%20then_go_to_step(4),%20then_go_to_step(4)),%0AOperation(Multiply(),%20number_in_box(8),%20number_in_box(5),%20put_result_into_box(7)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(8)),%20then_go_to_step(6),%20then_go_to_step(4)),%0APut(number_in_box(6),%20into_box(4)),%0AVerify(greater_than(instruction_box_number(step_number(2),%202),%20number_in_box(2)),%20then_go_to_step(8),%20then_go_to_step(1)),%0AChange_Box_Number(the_instruction_box(step_number(2),%201),%20increase(2)),%0AChange_Box_Number(the_instruction_box(step_number(4),%201),%20increase(1)),%20End())',32,'经过以上操作之后，现在7号盒子中的数字是多少?',11,4,'25','[\"\",\"更改指令2：将该指令中的第2个盒子的编号加1\",\"将5号盒子中的数字放在4号盒子中\",\"判断：指令4中第1个盒子的编号比6号盒子中的数字大吗\",\"相乘：8号盒子中的数字*5号盒子中的数字，将结果放在7号盒子中。\",\"判断：指令6中第1个盒子的编号比8号盒子中的数字大吗\",\"将6号盒子中的数字放在4号盒子中\",\"判断：指令2中第2个盒子的编号比2号盒子中的数字大吗\",\"更改指令2：将该指令中的第1个盒子的编号加2\",\"更改指令4：将该指令中的第1个盒子的编号加1\",\"\"]','logic-puzzle/38.png','logic-puzzle/38.json'),(33,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AChange_Box_Number(the_instruction_box(step_number(4),%201),%20increase(1)),%0APut(number_in_box(6),%20into_box(1)),%0AVerify(greater_than(instruction_box_number(step_number(6),%202),%20number_in_box(8)),%20then_go_to_step(4),%20then_go_to_step(4)),%0AOperation(Multiply(),%20number_in_box(1),%20number_in_box(8),%20put_result_into_box(1)),%0AVerify(greater_than(instruction_box_number(step_number(4),%201),%20number_in_box(5)),%20then_go_to_step(8),%20then_go_to_step(6)),%0APut(number_in_box(8),%20into_box(5)),%0AVerify(greater_than(instruction_box_number(step_number(2),%201),%20number_in_box(8)),%20then_go_to_step(1),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(4),%201),%20increase(1)),%0AChange_Box_Number(the_instruction_box(step_number(2),%201),%20increase(1)),%20End())',30,'经过以上操作之后，现在1号盒子中的数字是多少?',11,8,'16','[\"\",\"更改指令4：将该指令中的第1个盒子的编号加1\",\"将6号盒子中的数字放在1号盒子中\",\"判断：指令6中第2个盒子的编号比8号盒子中的数字大吗\",\"相乘：1号盒子中的数字*8号盒子中的数字，将结果放在1号盒子中。\",\"判断：指令4中第1个盒子的编号比5号盒子中的数字大吗\",\"将8号盒子中的数字放在5号盒子中\",\"判断：指令2中第1个盒子的编号比8号盒子中的数字大吗\",\"更改指令4：将该指令中的第1个盒子的编号加1\",\"更改指令2：将该指令中的第1个盒子的编号加1\",\"\"]','logic-puzzle/39.png','logic-puzzle/39.json'),(34,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AOperation(Multiply(),%20number_in_box(2),%20number_in_box(6),%20put_result_into_box(2)),%0AChange_Box_Number(the_instruction_box(step_number(1),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(4),%202),%20number_in_box(4)),%20then_go_to_step(4),%20then_go_to_step(4)),%0APut(number_in_box(1),%20into_box(1)),%0AVerify(greater_than(instruction_box_number(step_number(8),%201),%20number_in_box(6)),%20then_go_to_step(1),%20then_go_to_step(6)),%0AVerify(greater_than(instruction_box_number(step_number(1),%201),%20number_in_box(2)),%20then_go_to_step(7),%20then_go_to_step(1)),%0AChange_Box_Number(the_instruction_box(step_number(1),%202),%20increase(1)),%0APut(number_in_box(4),%20into_box(7)),%0AChange_Box_Number(the_instruction_box(step_number(8),%201),%20increase(1)),%20End())',41,'经过以上操作之后，现在2号盒子中的数字是多少?',11,6,'7','[\"\",\"相乘：2号盒子中的数字*6号盒子中的数字，将结果放在2号盒子中。\",\"更改指令1：将该指令中的第1个盒子的编号加1\",\"判断：指令4中第2个盒子的编号比4号盒子中的数字大吗\",\"将1号盒子中的数字放在1号盒子中\",\"判断：指令8中第1个盒子的编号比6号盒子中的数字大吗\",\"判断：指令1中第1个盒子的编号比2号盒子中的数字大吗\",\"更改指令1：将该指令中的第2个盒子的编号加1\",\"将4号盒子中的数字放在7号盒子中\",\"更改指令8：将该指令中的第1个盒子的编号加1\",\"\"]','logic-puzzle/4.png','logic-puzzle/4.json'),(35,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AOperation(Multiply(),%20number_in_box(1),%20number_in_box(9),%20put_result_into_box(8)),%0AChange_Box_Number(the_instruction_box(step_number(6),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(6),%202),%20number_in_box(1)),%20then_go_to_step(4),%20then_go_to_step(5)),%0AChange_Box_Number(the_instruction_box(step_number(1),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(1),%201),%20number_in_box(5)),%20then_go_to_step(8),%20then_go_to_step(6)),%0APut(number_in_box(7),%20into_box(2)),%0AVerify(greater_than(instruction_box_number(step_number(9),%202),%20number_in_box(3)),%20then_go_to_step(1),%20then_go_to_step(5)),%0AChange_Box_Number(the_instruction_box(step_number(9),%202),%20increase(1)),%0APut(number_in_box(4),%20into_box(7)),%20End())',30,'经过以上操作之后，现在8号盒子中的数字是多少?',11,4,'1','[\"\",\"相乘：1号盒子中的数字*9号盒子中的数字，将结果放在8号盒子中。\",\"更改指令6：将该指令中的第2个盒子的编号加1\",\"判断：指令6中第2个盒子的编号比1号盒子中的数字大吗\",\"更改指令1：将该指令中的第1个盒子的编号加1\",\"判断：指令1中第1个盒子的编号比5号盒子中的数字大吗\",\"将7号盒子中的数字放在2号盒子中\",\"判断：指令9中第2个盒子的编号比3号盒子中的数字大吗\",\"更改指令9：将该指令中的第2个盒子的编号加1\",\"将4号盒子中的数字放在7号盒子中\",\"\"]','logic-puzzle/40.png','logic-puzzle/40.json'),(36,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AOperation(Multiply(),%20number_in_box(1),%20number_in_box(9),%20put_result_into_box(9)),%0AChange_Box_Number(the_instruction_box(step_number(6),%201),%20increase(2)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(4)),%20then_go_to_step(6),%20then_go_to_step(8)),%0AChange_Box_Number(the_instruction_box(step_number(9),%202),%20increase(2)),%0AVerify(greater_than(instruction_box_number(step_number(1),%201),%20number_in_box(6)),%20then_go_to_step(6),%20then_go_to_step(2)),%0APut(number_in_box(3),%20into_box(4)),%0AVerify(greater_than(instruction_box_number(step_number(9),%202),%20number_in_box(6)),%20then_go_to_step(1),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(6),%201),%20increase(1)),%0APut(number_in_box(2),%20into_box(7)),%20End())',23,'经过以上操作之后，现在9号盒子中的数字是多少?',11,4,'7','[\"\",\"相乘：1号盒子中的数字*9号盒子中的数字，将结果放在9号盒子中。\",\"更改指令6：将该指令中的第1个盒子的编号加2\",\"判断：指令6中第1个盒子的编号比4号盒子中的数字大吗\",\"更改指令9：将该指令中的第2个盒子的编号加2\",\"判断：指令1中第1个盒子的编号比6号盒子中的数字大吗\",\"将3号盒子中的数字放在4号盒子中\",\"判断：指令9中第2个盒子的编号比6号盒子中的数字大吗\",\"更改指令6：将该指令中的第1个盒子的编号加1\",\"将2号盒子中的数字放在7号盒子中\",\"\"]','logic-puzzle/41.png','logic-puzzle/41.json'),(37,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0APut(number_in_box(3),%20into_box(1)),%0AChange_Box_Number(the_instruction_box(step_number(6),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(6),%202),%20number_in_box(2)),%20then_go_to_step(8),%20then_go_to_step(6)),%0AChange_Box_Number(the_instruction_box(step_number(6),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(1),%202),%20number_in_box(7)),%20then_go_to_step(7),%20then_go_to_step(2)),%0AOperation(Multiply(),%20number_in_box(3),%20number_in_box(2),%20put_result_into_box(7)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(5)),%20then_go_to_step(5),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(6),%201),%20increase(1)),%0APut(number_in_box(4),%20into_box(1)),%20End())',35,'经过以上操作之后，现在7号盒子中的数字是多少?',11,5,'343','[\"\",\"将3号盒子中的数字放在1号盒子中\",\"更改指令6：将该指令中的第2个盒子的编号加1\",\"判断：指令6中第2个盒子的编号比2号盒子中的数字大吗\",\"更改指令6：将该指令中的第1个盒子的编号加1\",\"判断：指令1中第2个盒子的编号比7号盒子中的数字大吗\",\"相乘：3号盒子中的数字*2号盒子中的数字，将结果放在7号盒子中。\",\"判断：指令6中第1个盒子的编号比5号盒子中的数字大吗\",\"更改指令6：将该指令中的第1个盒子的编号加1\",\"将4号盒子中的数字放在1号盒子中\",\"\"]','logic-puzzle/42.png','logic-puzzle/42.json'),(38,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0APut(number_in_box(8),%20into_box(7)),%0AChange_Box_Number(the_instruction_box(step_number(6),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(1),%202),%20number_in_box(8)),%20then_go_to_step(4),%20then_go_to_step(2)),%0AChange_Box_Number(the_instruction_box(step_number(6),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(4)),%20then_go_to_step(6),%20then_go_to_step(4)),%0AOperation(Multiply(),%20number_in_box(1),%20number_in_box(3),%20put_result_into_box(1)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(7)),%20then_go_to_step(8),%20then_go_to_step(3)),%0AChange_Box_Number(the_instruction_box(step_number(6),%201),%20increase(2)),%0APut(number_in_box(4),%20into_box(7)),%20End())',26,'经过以上操作之后，现在1号盒子中的数字是多少?',11,4,'5','[\"\",\"将8号盒子中的数字放在7号盒子中\",\"更改指令6：将该指令中的第2个盒子的编号加1\",\"判断：指令1中第2个盒子的编号比8号盒子中的数字大吗\",\"更改指令6：将该指令中的第1个盒子的编号加1\",\"判断：指令6中第1个盒子的编号比4号盒子中的数字大吗\",\"相乘：1号盒子中的数字*3号盒子中的数字，将结果放在1号盒子中。\",\"判断：指令6中第1个盒子的编号比7号盒子中的数字大吗\",\"更改指令6：将该指令中的第1个盒子的编号加2\",\"将4号盒子中的数字放在7号盒子中\",\"\"]','logic-puzzle/43.png','logic-puzzle/43.json'),(39,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AOperation(Multiply(),%20number_in_box(1),%20number_in_box(1),%20put_result_into_box(5)),%0AChange_Box_Number(the_instruction_box(step_number(1),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(1),%201),%20number_in_box(4)),%20then_go_to_step(4),%20then_go_to_step(6)),%0AChange_Box_Number(the_instruction_box(step_number(8),%202),%20increase(2)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(6)),%20then_go_to_step(6),%20then_go_to_step(1)),%0APut(number_in_box(5),%20into_box(3)),%0AVerify(greater_than(instruction_box_number(step_number(8),%202),%20number_in_box(6)),%20then_go_to_step(8),%20then_go_to_step(4)),%0APut(number_in_box(5),%20into_box(2)),%0AChange_Box_Number(the_instruction_box(step_number(8),%202),%20increase(1)),%20End())',30,'经过以上操作之后，现在3号盒子中的数字是多少?',11,4,'2','[\"\",\"相乘：1号盒子中的数字*1号盒子中的数字，将结果放在5号盒子中。\",\"更改指令1：将该指令中的第2个盒子的编号加1\",\"判断：指令1中第1个盒子的编号比4号盒子中的数字大吗\",\"更改指令8：将该指令中的第2个盒子的编号加2\",\"判断：指令6中第1个盒子的编号比6号盒子中的数字大吗\",\"将5号盒子中的数字放在3号盒子中\",\"判断：指令8中第2个盒子的编号比6号盒子中的数字大吗\",\"将5号盒子中的数字放在2号盒子中\",\"更改指令8：将该指令中的第2个盒子的编号加1\",\"\"]','logic-puzzle/44.png','logic-puzzle/44.json'),(40,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AOperation(Multiply(),%20number_in_box(3),%20number_in_box(3),%20put_result_into_box(9)),%0AChange_Box_Number(the_instruction_box(step_number(6),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(1),%202),%20number_in_box(5)),%20then_go_to_step(8),%20then_go_to_step(6)),%0AChange_Box_Number(the_instruction_box(step_number(1),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(1),%202),%20number_in_box(1)),%20then_go_to_step(2),%20then_go_to_step(6)),%0APut(number_in_box(2),%20into_box(9)),%0AVerify(greater_than(instruction_box_number(step_number(1),%201),%20number_in_box(3)),%20then_go_to_step(4),%20then_go_to_step(5)),%0APut(number_in_box(6),%20into_box(2)),%0AChange_Box_Number(the_instruction_box(step_number(1),%201),%20increase(1)),%20End())',25,'经过以上操作之后，现在9号盒子中的数字是多少?',11,4,'5','[\"\",\"相乘：3号盒子中的数字*3号盒子中的数字，将结果放在9号盒子中。\",\"更改指令6：将该指令中的第1个盒子的编号加1\",\"判断：指令1中第2个盒子的编号比5号盒子中的数字大吗\",\"更改指令1：将该指令中的第2个盒子的编号加1\",\"判断：指令1中第2个盒子的编号比1号盒子中的数字大吗\",\"将2号盒子中的数字放在9号盒子中\",\"判断：指令1中第1个盒子的编号比3号盒子中的数字大吗\",\"将6号盒子中的数字放在2号盒子中\",\"更改指令1：将该指令中的第1个盒子的编号加1\",\"\"]','logic-puzzle/45.png','logic-puzzle/45.json'),(41,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AOperation(Multiply(),%20number_in_box(5),%20number_in_box(6),%20put_result_into_box(9)),%0AChange_Box_Number(the_instruction_box(step_number(8),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(1)),%20then_go_to_step(2),%20then_go_to_step(6)),%0AChange_Box_Number(the_instruction_box(step_number(6),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(8),%202),%20number_in_box(7)),%20then_go_to_step(6),%20then_go_to_step(1)),%0APut(number_in_box(2),%20into_box(4)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(2)),%20then_go_to_step(8),%20then_go_to_step(4)),%0APut(number_in_box(7),%20into_box(5)),%0AChange_Box_Number(the_instruction_box(step_number(6),%201),%20increase(1)),%20End())',33,'经过以上操作之后，现在4号盒子中的数字是多少?',11,6,'4','[\"\",\"相乘：5号盒子中的数字*6号盒子中的数字，将结果放在9号盒子中。\",\"更改指令8：将该指令中的第1个盒子的编号加1\",\"判断：指令6中第1个盒子的编号比1号盒子中的数字大吗\",\"更改指令6：将该指令中的第1个盒子的编号加1\",\"判断：指令8中第2个盒子的编号比7号盒子中的数字大吗\",\"将2号盒子中的数字放在4号盒子中\",\"判断：指令6中第1个盒子的编号比2号盒子中的数字大吗\",\"将7号盒子中的数字放在5号盒子中\",\"更改指令6：将该指令中的第1个盒子的编号加1\",\"\"]','logic-puzzle/46.png','logic-puzzle/46.json'),(42,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AOperation(Multiply(),%20number_in_box(6),%20number_in_box(8),%20put_result_into_box(6)),%0AChange_Box_Number(the_instruction_box(step_number(6),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(6),%202),%20number_in_box(8)),%20then_go_to_step(4),%20then_go_to_step(6)),%0AChange_Box_Number(the_instruction_box(step_number(6),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(6),%202),%20number_in_box(5)),%20then_go_to_step(2),%20then_go_to_step(6)),%0APut(number_in_box(2),%20into_box(3)),%0AVerify(greater_than(instruction_box_number(step_number(1),%202),%20number_in_box(4)),%20then_go_to_step(4),%20then_go_to_step(8)),%0APut(number_in_box(1),%20into_box(7)),%0AChange_Box_Number(the_instruction_box(step_number(6),%202),%20increase(1)),%20End())',25,'经过以上操作之后，现在4号盒子中的数字是多少?',11,4,'28','[\"\",\"相乘：6号盒子中的数字*8号盒子中的数字，将结果放在6号盒子中。\",\"更改指令6：将该指令中的第2个盒子的编号加1\",\"判断：指令6中第2个盒子的编号比8号盒子中的数字大吗\",\"更改指令6：将该指令中的第1个盒子的编号加1\",\"判断：指令6中第2个盒子的编号比5号盒子中的数字大吗\",\"将2号盒子中的数字放在3号盒子中\",\"判断：指令1中第2个盒子的编号比4号盒子中的数字大吗\",\"将1号盒子中的数字放在7号盒子中\",\"更改指令6：将该指令中的第2个盒子的编号加1\",\"\"]','logic-puzzle/47.png','logic-puzzle/47.json'),(43,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0APut(number_in_box(5),%20into_box(1)),%0AChange_Box_Number(the_instruction_box(step_number(8),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(8),%201),%20number_in_box(4)),%20then_go_to_step(6),%20then_go_to_step(8)),%0AChange_Box_Number(the_instruction_box(step_number(6),%202),%20increase(2)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(2)),%20then_go_to_step(1),%20then_go_to_step(8)),%0AOperation(Multiply(),%20number_in_box(6),%20number_in_box(3),%20put_result_into_box(3)),%0AVerify(greater_than(instruction_box_number(step_number(8),%202),%20number_in_box(8)),%20then_go_to_step(4),%20then_go_to_step(2)),%0APut(number_in_box(2),%20into_box(1)),%0AChange_Box_Number(the_instruction_box(step_number(1),%202),%20increase(1)),%20End())',23,'经过以上操作之后，现在3号盒子中的数字是多少?',11,4,'4802','[\"\",\"将5号盒子中的数字放在1号盒子中\",\"更改指令8：将该指令中的第2个盒子的编号加1\",\"判断：指令8中第1个盒子的编号比4号盒子中的数字大吗\",\"更改指令6：将该指令中的第2个盒子的编号加2\",\"判断：指令6中第1个盒子的编号比2号盒子中的数字大吗\",\"相乘：6号盒子中的数字*3号盒子中的数字，将结果放在3号盒子中。\",\"判断：指令8中第2个盒子的编号比8号盒子中的数字大吗\",\"将2号盒子中的数字放在1号盒子中\",\"更改指令1：将该指令中的第2个盒子的编号加1\",\"\"]','logic-puzzle/48.png','logic-puzzle/48.json'),(44,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0APut(number_in_box(5),%20into_box(4)),%0AChange_Box_Number(the_instruction_box(step_number(1),%201),%20increase(2)),%0AVerify(greater_than(instruction_box_number(step_number(6),%201),%20number_in_box(6)),%20then_go_to_step(8),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(6),%201),%20increase(2)),%0AVerify(greater_than(instruction_box_number(step_number(8),%202),%20number_in_box(5)),%20then_go_to_step(2),%20then_go_to_step(6)),%0AOperation(Multiply(),%20number_in_box(3),%20number_in_box(8),%20put_result_into_box(3)),%0AVerify(greater_than(instruction_box_number(step_number(8),%201),%20number_in_box(4)),%20then_go_to_step(3),%20then_go_to_step(1)),%0APut(number_in_box(2),%20into_box(3)),%0AChange_Box_Number(the_instruction_box(step_number(6),%202),%20increase(2)),%20End())',24,'经过以上操作之后，现在3号盒子中的数字是多少?',11,4,'7','[\"\",\"将5号盒子中的数字放在4号盒子中\",\"更改指令1：将该指令中的第1个盒子的编号加2\",\"判断：指令6中第1个盒子的编号比6号盒子中的数字大吗\",\"更改指令6：将该指令中的第1个盒子的编号加2\",\"判断：指令8中第2个盒子的编号比5号盒子中的数字大吗\",\"相乘：3号盒子中的数字*8号盒子中的数字，将结果放在3号盒子中。\",\"判断：指令8中第1个盒子的编号比4号盒子中的数字大吗\",\"将2号盒子中的数字放在3号盒子中\",\"更改指令6：将该指令中的第2个盒子的编号加2\",\"\"]','logic-puzzle/49.png','logic-puzzle/49.json'),(45,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0APut(number_in_box(7),%20into_box(4)),%0AChange_Box_Number(the_instruction_box(step_number(4),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(4),%202),%20number_in_box(5)),%20then_go_to_step(7),%20then_go_to_step(6)),%0AOperation(Multiply(),%20number_in_box(3),%20number_in_box(1),%20put_result_into_box(6)),%0AVerify(greater_than(instruction_box_number(step_number(8),%202),%20number_in_box(1)),%20then_go_to_step(2),%20then_go_to_step(7)),%0AVerify(greater_than(instruction_box_number(step_number(8),%202),%20number_in_box(1)),%20then_go_to_step(4),%20then_go_to_step(8)),%0AChange_Box_Number(the_instruction_box(step_number(1),%202),%20increase(2)),%0APut(number_in_box(2),%20into_box(6)),%0AChange_Box_Number(the_instruction_box(step_number(1),%201),%20increase(2)),%20End())',28,'经过以上操作之后，现在6号盒子中的数字是多少?',11,5,'7','[\"\",\"将7号盒子中的数字放在4号盒子中\",\"更改指令4：将该指令中的第2个盒子的编号加1\",\"判断：指令4中第2个盒子的编号比5号盒子中的数字大吗\",\"相乘：3号盒子中的数字*1号盒子中的数字，将结果放在6号盒子中。\",\"判断：指令8中第2个盒子的编号比1号盒子中的数字大吗\",\"判断：指令8中第2个盒子的编号比1号盒子中的数字大吗\",\"更改指令1：将该指令中的第2个盒子的编号加2\",\"将2号盒子中的数字放在6号盒子中\",\"更改指令1：将该指令中的第1个盒子的编号加2\",\"\"]','logic-puzzle/5.png','logic-puzzle/5.json'),(46,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AOperation(Multiply(),%20number_in_box(3),%20number_in_box(1),%20put_result_into_box(3)),%0AChange_Box_Number(the_instruction_box(step_number(1),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(9),%202),%20number_in_box(6)),%20then_go_to_step(5),%20then_go_to_step(4)),%0APut(number_in_box(4),%20into_box(3)),%0AVerify(greater_than(instruction_box_number(step_number(1),%202),%20number_in_box(8)),%20then_go_to_step(6),%20then_go_to_step(1)),%0AChange_Box_Number(the_instruction_box(step_number(1),%202),%20increase(2)),%0AVerify(greater_than(instruction_box_number(step_number(1),%201),%20number_in_box(2)),%20then_go_to_step(7),%20then_go_to_step(8)),%0AChange_Box_Number(the_instruction_box(step_number(4),%202),%20increase(1)),%0APut(number_in_box(1),%20into_box(7)),%20End())',26,'经过以上操作之后，现在3号盒子中的数字是多少?',11,4,'1','[\"\",\"相乘：3号盒子中的数字*1号盒子中的数字，将结果放在3号盒子中。\",\"更改指令1：将该指令中的第2个盒子的编号加1\",\"判断：指令9中第2个盒子的编号比6号盒子中的数字大吗\",\"将4号盒子中的数字放在3号盒子中\",\"判断：指令1中第2个盒子的编号比8号盒子中的数字大吗\",\"更改指令1：将该指令中的第2个盒子的编号加2\",\"判断：指令1中第1个盒子的编号比2号盒子中的数字大吗\",\"更改指令4：将该指令中的第2个盒子的编号加1\",\"将1号盒子中的数字放在7号盒子中\",\"\"]','logic-puzzle/50.png','logic-puzzle/50.json'),(47,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0AOperation(Multiply(),%20number_in_box(2),%20number_in_box(4),%20put_result_into_box(4)),%0AChange_Box_Number(the_instruction_box(step_number(1),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(1),%201),%20number_in_box(6)),%20then_go_to_step(4),%20then_go_to_step(1)),%0APut(number_in_box(2),%20into_box(4)),%0AVerify(greater_than(instruction_box_number(step_number(7),%201),%20number_in_box(8)),%20then_go_to_step(6),%20then_go_to_step(6)),%0AVerify(greater_than(instruction_box_number(step_number(4),%201),%20number_in_box(6)),%20then_go_to_step(7),%20then_go_to_step(7)),%0APut(number_in_box(8),%20into_box(1)),%0AChange_Box_Number(the_instruction_box(step_number(4),%201),%20increase(2)),%0AChange_Box_Number(the_instruction_box(step_number(1),%201),%20increase(1)),%20End())',26,'经过以上操作之后，现在4号盒子中的数字是多少?',11,6,'7','[\"\",\"相乘：2号盒子中的数字*4号盒子中的数字，将结果放在4号盒子中。\",\"更改指令1：将该指令中的第1个盒子的编号加1\",\"判断：指令1中第1个盒子的编号比6号盒子中的数字大吗\",\"将2号盒子中的数字放在4号盒子中\",\"判断：指令7中第1个盒子的编号比8号盒子中的数字大吗\",\"判断：指令4中第1个盒子的编号比6号盒子中的数字大吗\",\"将8号盒子中的数字放在1号盒子中\",\"更改指令4：将该指令中的第1个盒子的编号加2\",\"更改指令1：将该指令中的第1个盒子的编号加1\",\"\"]','logic-puzzle/6.png','logic-puzzle/6.json'),(48,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0APut(number_in_box(1),%20into_box(3)),%0AOperation(Multiply(),%20number_in_box(9),%20number_in_box(2),%20put_result_into_box(7)),%0AVerify(greater_than(instruction_box_number(step_number(1),%201),%20number_in_box(8)),%20then_go_to_step(6),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(1),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(1),%202),%20number_in_box(2)),%20then_go_to_step(1),%20then_go_to_step(1)),%0AVerify(greater_than(instruction_box_number(step_number(1),%202),%20number_in_box(5)),%20then_go_to_step(7),%20then_go_to_step(7)),%0AChange_Box_Number(the_instruction_box(step_number(1),%202),%20increase(2)),%0APut(number_in_box(6),%20into_box(3)),%0AChange_Box_Number(the_instruction_box(step_number(8),%201),%20increase(2)),%20End())',29,'经过以上操作之后，现在3号盒子中的数字是多少?',11,4,'7','[\"\",\"将1号盒子中的数字放在3号盒子中\",\"相乘：9号盒子中的数字*2号盒子中的数字，将结果放在7号盒子中。\",\"判断：指令1中第1个盒子的编号比8号盒子中的数字大吗\",\"更改指令1：将该指令中的第1个盒子的编号加1\",\"判断：指令1中第2个盒子的编号比2号盒子中的数字大吗\",\"判断：指令1中第2个盒子的编号比5号盒子中的数字大吗\",\"更改指令1：将该指令中的第2个盒子的编号加2\",\"将6号盒子中的数字放在3号盒子中\",\"更改指令8：将该指令中的第1个盒子的编号加2\",\"\"]','logic-puzzle/7.png','logic-puzzle/7.json'),(49,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0APut(number_in_box(3),%20into_box(2)),%0AOperation(Multiply(),%20number_in_box(3),%20number_in_box(4),%20put_result_into_box(4)),%0AVerify(greater_than(instruction_box_number(step_number(2),%201),%20number_in_box(4)),%20then_go_to_step(5),%20then_go_to_step(6)),%0AChange_Box_Number(the_instruction_box(step_number(1),%202),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(1),%202),%20number_in_box(6)),%20then_go_to_step(7),%20then_go_to_step(2)),%0AVerify(greater_than(instruction_box_number(step_number(8),%202),%20number_in_box(3)),%20then_go_to_step(4),%20then_go_to_step(7)),%0AChange_Box_Number(the_instruction_box(step_number(1),%201),%20increase(2)),%0APut(number_in_box(8),%20into_box(6)),%0AChange_Box_Number(the_instruction_box(step_number(8),%202),%20increase(2)),%20End())',39,'经过以上操作之后，现在4号盒子中的数字是多少?',11,7,'128','[\"\",\"将3号盒子中的数字放在2号盒子中\",\"相乘：3号盒子中的数字*4号盒子中的数字，将结果放在4号盒子中。\",\"判断：指令2中第1个盒子的编号比4号盒子中的数字大吗\",\"更改指令1：将该指令中的第2个盒子的编号加1\",\"判断：指令1中第2个盒子的编号比6号盒子中的数字大吗\",\"判断：指令8中第2个盒子的编号比3号盒子中的数字大吗\",\"更改指令1：将该指令中的第1个盒子的编号加2\",\"将8号盒子中的数字放在6号盒子中\",\"更改指令8：将该指令中的第2个盒子的编号加2\",\"\"]','logic-puzzle/8.png','logic-puzzle/8.json'),(50,'[0,2,7,2,1,5,7,1,4,8]','Steps(%20Begin(),%20%0APut(number_in_box(7),%20into_box(2)),%0AOperation(Multiply(),%20number_in_box(3),%20number_in_box(1),%20put_result_into_box(3)),%0AVerify(greater_than(instruction_box_number(step_number(2),%201),%20number_in_box(6)),%20then_go_to_step(7),%20then_go_to_step(4)),%0AChange_Box_Number(the_instruction_box(step_number(2),%201),%20increase(1)),%0AVerify(greater_than(instruction_box_number(step_number(1),%202),%20number_in_box(1)),%20then_go_to_step(1),%20then_go_to_step(6)),%0AVerify(greater_than(instruction_box_number(step_number(8),%201),%20number_in_box(2)),%20then_go_to_step(7),%20then_go_to_step(2)),%0AChange_Box_Number(the_instruction_box(step_number(1),%201),%20increase(1)),%0APut(number_in_box(1),%20into_box(3)),%0AChange_Box_Number(the_instruction_box(step_number(1),%202),%20increase(1)),%20End())',33,'经过以上操作之后，现在3号盒子中的数字是多少?',11,7,'2','[\"\",\"将7号盒子中的数字放在2号盒子中\",\"相乘：3号盒子中的数字*1号盒子中的数字，将结果放在3号盒子中。\",\"判断：指令2中第1个盒子的编号比6号盒子中的数字大吗\",\"更改指令2：将该指令中的第1个盒子的编号加1\",\"判断：指令1中第2个盒子的编号比1号盒子中的数字大吗\",\"判断：指令8中第1个盒子的编号比2号盒子中的数字大吗\",\"更改指令1：将该指令中的第1个盒子的编号加1\",\"将1号盒子中的数字放在3号盒子中\",\"更改指令1：将该指令中的第2个盒子的编号加1\",\"\"]','logic-puzzle/9.png','logic-puzzle/9.json');
/*!40000 ALTER TABLE `quizItem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schema_version`
--

DROP TABLE IF EXISTS `schema_version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schema_version` (
  `version_rank` int(11) NOT NULL,
  `installed_rank` int(11) NOT NULL,
  `version` varchar(50) NOT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int(11) DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int(11) NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`version`),
  KEY `schema_version_vr_idx` (`version_rank`),
  KEY `schema_version_ir_idx` (`installed_rank`),
  KEY `schema_version_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schema_version`
--

LOCK TABLES `schema_version` WRITE;
/*!40000 ALTER TABLE `schema_version` DISABLE KEYS */;
INSERT INTO `schema_version` VALUES (1,1,'1','Merged constructure','SQL','V1__Merged_constructure.sql',1730853196,'BronzeSword','2017-03-29 15:37:11',1249,1),(2,2,'1.1','Add test data for merged constructure','SQL','V1_1__Add_test_data_for_merged_constructure.sql',-567776499,'BronzeSword','2017-03-29 15:37:12',585,1),(20,20,'10','Create single choice table','SQL','V10__Create_single_choice_table.sql',899459341,'BronzeSword','2017-03-29 15:37:13',53,1),(21,21,'10.1','Add test data for single choice table','SQL','V10_1__Add_test_data_for_single_choice_table.sql',-1664258179,'BronzeSword','2017-03-29 15:37:13',10,1),(22,22,'11','Create multiple choice table','SQL','V11__Create_multiple_choice_table.sql',-979097843,'BronzeSword','2017-03-29 15:37:13',52,1),(23,23,'11.1','Add test data for mutiple choice table','SQL','V11_1__Add_test_data_for_mutiple_choice_table.sql',-1076857136,'BronzeSword','2017-03-29 15:37:13',12,1),(24,24,'11.2','Add test data for homework post history table','SQL','V11_2__Add_test_data_for_homework_post_history_table.sql',270153697,'BronzeSword','2017-03-29 15:37:13',11,1),(25,25,'12','Modify single choice table structure','SQL','V12__Modify_single_choice_table_structure.sql',-524157193,'BronzeSword','2017-03-29 15:37:13',16,1),(26,26,'12.1','Add test data for homework post history table','SQL','V12_1__Add_test_data_for_homework_post_history_table.sql',-1624348009,'BronzeSword','2017-03-29 15:37:13',12,1),(27,27,'13','Modify multiple choice table structure','SQL','V13__Modify_multiple_choice_table_structure.sql',-978994137,'BronzeSword','2017-03-29 15:37:13',24,1),(28,28,'13.1','Add test data for blankQuizSubmit table','SQL','V13_1__Add_test_data_for_blankQuizSubmit_table.sql',113181894,'BronzeSword','2017-03-29 15:37:13',11,1),(29,29,'14','Modify homeworkQuiz table structure','SQL','V14__Modify_homeworkQuiz_table_structure.sql',41031293,'BronzeSword','2017-03-29 15:37:14',136,1),(30,30,'14.1','Add test data for homeworkQuiz table','SQL','V14_1__Add_test_data_for_homeworkQuiz_table.sql',-1362626087,'BronzeSword','2017-03-29 15:37:14',13,1),(31,31,'15','Modify homeworkQuizOperation table structure','SQL','V15__Modify_homeworkQuizOperation_table_structure.sql',940740023,'BronzeSword','2017-03-29 15:37:14',155,1),(32,32,'15.1','Add test data for homeworkQuiz operation constructure','SQL','V15_1__Add_test_data_for_homeworkQuiz_operation_constructure.sql',-1985012529,'BronzeSword','2017-03-29 15:37:14',14,1),(33,33,'16','Modify homeworkQuiz table','SQL','V16__Modify_homeworkQuiz_table.sql',1672399339,'BronzeSword','2017-03-29 15:37:14',19,1),(34,34,'16.1','Add test data for mutiple choice table','SQL','V16_1__Add_test_data_for_mutiple_choice_table.sql',792429212,'BronzeSword','2017-03-29 15:37:14',13,1),(35,35,'17','Modify homeworkQuizOperation table','SQL','V17__Modify_homeworkQuizOperation_table.sql',52740694,'BronzeSword','2017-03-29 15:37:14',144,1),(36,36,'18','Modify users table structure','SQL','V18__Modify_users_table_structure.sql',-1340972118,'BronzeSword','2017-03-29 15:37:14',137,1),(37,37,'19','Create user role table structure','SQL','V19__Create_user_role_table_structure.sql',972322368,'BronzeSword','2017-03-29 15:37:14',57,1),(38,38,'19.1','Add test data for users role table','SQL','V19_1__Add_test_data_for_users_role_table.sql',1733171609,'BronzeSword','2017-03-29 15:37:14',28,1),(3,3,'2','Modify paper structure table','SQL','V2__Modify_paper_structure_table.sql',-551534843,'BronzeSword','2017-03-29 15:37:12',129,1),(4,4,'2.1','Add test data for paper table','SQL','V2_1__Add_test_data_for_paper_table.sql',1973912295,'BronzeSword','2017-03-29 15:37:12',18,1),(5,5,'3','Modify paper structure table','SQL','V3__Modify_paper_structure_table.sql',1842693123,'BronzeSword','2017-03-29 15:37:12',134,1),(6,6,'4','Modify paperOperation structure table','SQL','V4__Modify_paperOperation_structure_table.sql',-1005969377,'BronzeSword','2017-03-29 15:37:12',275,1),(7,7,'4.1','Add test data for paperOperation table','SQL','V4_1__Add_test_data_for_paperOperation_table.sql',-2042518183,'BronzeSword','2017-03-29 15:37:12',15,1),(8,8,'5','Modify programs structure table','SQL','V5__Modify_programs_structure_table.sql',1375641066,'BronzeSword','2017-03-29 15:37:12',131,1),(9,9,'5.1','Add test data for programs table','SQL','V5_1__Add_test_data_for_programs_table.sql',372907345,'BronzeSword','2017-03-29 15:37:12',14,1),(10,10,'6','Modify user table structure table','SQL','V6__Modify_user_table_structure_table.sql',1002948276,'BronzeSword','2017-03-29 15:37:13',141,1),(11,11,'6.1','Add test data for user table ','SQL','V6_1__Add_test_data_for_user_table_.sql',2033244149,'BronzeSword','2017-03-29 15:37:13',15,1),(12,12,'7','Modify user table structure table','SQL','V7__Modify_user_table_structure_table.sql',-1896658631,'BronzeSword','2017-03-29 15:37:13',154,1),(13,13,'7.1','Add test data for user table','SQL','V7_1__Add_test_data_for_user_table.sql',865529483,'BronzeSword','2017-03-29 15:37:13',10,1),(14,14,'7.2','Add test data for stack table ','SQL','V7_2__Add_test_data_for_stack_table_.sql',-1779018552,'BronzeSword','2017-03-29 15:37:13',16,1),(15,15,'8','Create homework quiz operation table','SQL','V8__Create_homework_quiz_operation_table.sql',-1438083498,'BronzeSword','2017-03-29 15:37:13',48,1),(16,16,'8.1','Add test data for homework quiz operation table ','SQL','V8_1__Add_test_data_for_homework_quiz_operation_table_.sql',-923891522,'BronzeSword','2017-03-29 15:37:13',17,1),(17,17,'8.2','Add test data for stack table ','SQL','V8_2__Add_test_data_for_stack_table_.sql',1010611196,'BronzeSword','2017-03-29 15:37:13',17,1),(18,18,'9','Create basic blank quiz table','SQL','V9__Create_basic_blank_quiz_table.sql',1378404057,'BronzeSword','2017-03-29 15:37:13',52,1),(19,19,'9.1','Add test data for basic blank quiz table','SQL','V9_1__Add_test_data_for_basic_blank_quiz_table.sql',765567263,'BronzeSword','2017-03-29 15:37:13',18,1);
/*!40000 ALTER TABLE `schema_version` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scoreSheet`
--

DROP TABLE IF EXISTS `scoreSheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scoreSheet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `examerId` int(11) NOT NULL,
  `paperId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scoreSheet`
--

LOCK TABLES `scoreSheet` WRITE;
/*!40000 ALTER TABLE `scoreSheet` DISABLE KEYS */;
INSERT INTO `scoreSheet` VALUES (1,1,1),(2,2,1),(3,4,2),(4,3,2);
/*!40000 ALTER TABLE `scoreSheet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section`
--

DROP TABLE IF EXISTS `section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `section` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paperId` int(11) NOT NULL,
  `description` varchar(256) NOT NULL,
  `type` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section`
--

LOCK TABLES `section` WRITE;
/*!40000 ALTER TABLE `section` DISABLE KEYS */;
INSERT INTO `section` VALUES (1,1,'这是描述','blankQuizzes'),(2,1,'这是描述','homeworkQuizzes'),(3,2,'这是描述','blankQuizzes'),(4,2,'这是第一套','homeworkQuizzes'),(5,2,'这是第二套','homeworkQuizzes'),(6,3,'这是描述','blankQuizzes'),(7,3,'这是第一套','homeworkQuizzes'),(8,2,'这是描述','blankQuizzes'),(9,2,'这是第一套','homeworkQuizzes'),(10,2,'这是第二套','homeworkQuizzes'),(11,3,'这是描述','blankQuizzes'),(12,3,'这是第一套','homeworkQuizzes');
/*!40000 ALTER TABLE `section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sectionQuiz`
--

DROP TABLE IF EXISTS `sectionQuiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sectionQuiz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sectionId` int(11) NOT NULL,
  `quizId` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sectionQuiz`
--

LOCK TABLES `sectionQuiz` WRITE;
/*!40000 ALTER TABLE `sectionQuiz` DISABLE KEYS */;
INSERT INTO `sectionQuiz` VALUES (1,1,1),(2,1,2),(3,2,1),(4,2,2),(5,2,3),(6,2,4),(7,2,5),(8,2,6),(9,2,7),(10,2,8),(11,3,1),(12,3,2),(13,3,4),(14,4,1),(15,4,2),(16,4,3),(17,5,1),(18,5,2),(19,5,3),(20,5,4),(21,5,5),(22,6,5),(23,7,1),(24,7,2),(25,7,3),(26,7,4),(27,7,5),(28,7,6);
/*!40000 ALTER TABLE `sectionQuiz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `singleChoice`
--

DROP TABLE IF EXISTS `singleChoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `singleChoice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(128) NOT NULL,
  `options` varchar(128) NOT NULL,
  `type` varchar(128) NOT NULL,
  `answer` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `singleChoice`
--

LOCK TABLES `singleChoice` WRITE;
/*!40000 ALTER TABLE `singleChoice` DISABLE KEYS */;
INSERT INTO `singleChoice` VALUES (1,'这是第一道单选题','1,2,3,4','SINGLE_CHOICE','3'),(2,'这是第二道单选题','5,6,7,8','SINGLE_CHOICE','5');
/*!40000 ALTER TABLE `singleChoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stack`
--

DROP TABLE IF EXISTS `stack`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stack` (
  `stackId` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) NOT NULL,
  `description` varchar(128) NOT NULL,
  `definition` varchar(128) NOT NULL,
  PRIMARY KEY (`stackId`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stack`
--

LOCK TABLES `stack` WRITE;
/*!40000 ALTER TABLE `stack` DISABLE KEYS */;
INSERT INTO `stack` VALUES (1,'PHP','这是Php','php:5'),(2,'Python','这是Python','python:2'),(3,'Ruby','这是Ruby','ruby:1');
/*!40000 ALTER TABLE `stack` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentMentor`
--

DROP TABLE IF EXISTS `studentMentor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentMentor` (
  `mentorId` int(11) NOT NULL,
  `studentId` int(11) NOT NULL,
  PRIMARY KEY (`studentId`,`mentorId`),
  KEY `mentorId` (`mentorId`),
  CONSTRAINT `studentMentor_ibfk_1` FOREIGN KEY (`studentId`) REFERENCES `users` (`id`),
  CONSTRAINT `studentMentor_ibfk_2` FOREIGN KEY (`mentorId`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentMentor`
--

LOCK TABLES `studentMentor` WRITE;
/*!40000 ALTER TABLE `studentMentor` DISABLE KEYS */;
INSERT INTO `studentMentor` VALUES (1,2),(1,3),(2,1),(2,3),(2,4),(3,1);
/*!40000 ALTER TABLE `studentMentor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thirdParty`
--

DROP TABLE IF EXISTS `thirdParty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thirdParty` (
  `thirdPartyUserId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `type` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thirdParty`
--

LOCK TABLES `thirdParty` WRITE;
/*!40000 ALTER TABLE `thirdParty` DISABLE KEYS */;
/*!40000 ALTER TABLE `thirdParty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userDetail`
--

DROP TABLE IF EXISTS `userDetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userDetail` (
  `userId` int(11) NOT NULL,
  `school` varchar(128) NOT NULL,
  `name` varchar(128) NOT NULL,
  `major` varchar(128) NOT NULL,
  `degree` varchar(128) NOT NULL,
  `gender` enum('F','M') DEFAULT NULL,
  `schoolProvince` varchar(128) DEFAULT NULL,
  `schoolCity` varchar(128) DEFAULT NULL,
  `entranceYear` varchar(128) DEFAULT NULL,
  UNIQUE KEY `userId` (`userId`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userDetail`
--

LOCK TABLES `userDetail` WRITE;
/*!40000 ALTER TABLE `userDetail` DISABLE KEYS */;
INSERT INTO `userDetail` VALUES (1,'思沃学院','测试一','计算机','本科','F','陕西','西安','2016'),(2,'思沃大讲堂','测试二','电工','本科','M',NULL,NULL,NULL),(3,'思沃学院','测试三','计算机','本科','F','陕西','咸阳','2016'),(4,'思沃大讲堂','测试四','电工','本科','M','陕西','汉中','2017');
/*!40000 ALTER TABLE `userDetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userPrivilege`
--

DROP TABLE IF EXISTS `userPrivilege`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userPrivilege` (
  `userId` int(11) NOT NULL,
  `privilege` enum('MENTOR','OPERATOR') NOT NULL,
  PRIMARY KEY (`userId`,`privilege`),
  CONSTRAINT `userPrivilege_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userPrivilege`
--

LOCK TABLES `userPrivilege` WRITE;
/*!40000 ALTER TABLE `userPrivilege` DISABLE KEYS */;
INSERT INTO `userPrivilege` VALUES (1,'MENTOR'),(2,'MENTOR'),(3,'MENTOR');
/*!40000 ALTER TABLE `userPrivilege` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userProgram`
--

DROP TABLE IF EXISTS `userProgram`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userProgram` (
  `userId` int(11) NOT NULL,
  `programId` int(11) NOT NULL,
  PRIMARY KEY (`userId`,`programId`),
  KEY `programId` (`programId`),
  CONSTRAINT `userProgram_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userProgram_ibfk_2` FOREIGN KEY (`programId`) REFERENCES `programs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userProgram`
--

LOCK TABLES `userProgram` WRITE;
/*!40000 ALTER TABLE `userProgram` DISABLE KEYS */;
INSERT INTO `userProgram` VALUES (1,1),(2,1),(3,1),(1,2),(2,3),(2,4);
/*!40000 ALTER TABLE `userProgram` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userRole`
--

DROP TABLE IF EXISTS `userRole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userRole` (
  `userId` int(11) NOT NULL,
  `role` int(11) DEFAULT NULL,
  KEY `userId_id_1` (`userId`),
  CONSTRAINT `userId_id_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userRole`
--

LOCK TABLES `userRole` WRITE;
/*!40000 ALTER TABLE `userRole` DISABLE KEYS */;
INSERT INTO `userRole` VALUES (1,0),(1,1),(2,NULL),(3,1),(4,4),(5,3),(6,2),(7,9),(8,1);
/*!40000 ALTER TABLE `userRole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(128) NOT NULL,
  `mobilePhone` varchar(64) NOT NULL,
  `password` varchar(128) NOT NULL,
  `createDate` int(11) NOT NULL,
  `userName` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'test@163.com','18798037893','550e1bafe077ff0b0b67f4e32f29d751',1451117203,'章三'),(2,'test2@qq.com','18087839393','550e1bafe077ff0b0b67f4e32f29d751',1451117300,'李四'),(3,'wjj@qq.com','18740404040','550e1bafe077ff0b0b67f4e32f29d751',1451368017,'王五'),(4,'ydp@qq.com','18730304826','550e1bafe077ff0b0b67f4e32f29d751',1451370576,'马红'),(5,'lwj@qq.com','18740362964','550e1bafe077ff0b0b67f4e32f29d751',1451370686,'陈有'),(6,'z@z.com','18291895012','550e1bafe077ff0b0b67f4e32f29d751',1452491001,'张梦'),(7,'admin@admin.com','18711110000','550e1bafe077ff0b0b67f4e32f29d751',1452491001,'赵思'),(8,'teacher@teacher.com','18711110001','550e1bafe077ff0b0b67f4e32f29d751',1452491002,'孙衵');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-29 15:37:45
