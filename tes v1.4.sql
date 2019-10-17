# Host: localhost  (Version 5.0.96-community-nt)
# Date: 2018-10-08 15:19:42
# Generator: MySQL-Front 6.0  (Build 2.29)


#
# Structure for table "classes"
#

DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `ClassID` int(11) NOT NULL auto_increment,
  `ClassCode` varchar(255) default NULL,
  `ClassMajor` varchar(255) default NULL,
  `State` char(1) default '0',
  PRIMARY KEY  (`ClassID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#
# Data for table "classes"
#

INSERT INTO `classes` VALUES (1,'1590001','软件工程','1'),(2,'1590004','金融管理','2'),(3,'1590007','对外贸易','3'),(4,'1590002','软件工程','1'),(5,'1590003','软件工程','1'),(6,'1590005','金融管理','2'),(7,'1590006','金融管理','2'),(8,'1590008','对外贸易','3'),(9,'1590009','对外贸易','3');

#
# Structure for table "curriculum"
#

DROP TABLE IF EXISTS `curriculum`;
CREATE TABLE `curriculum` (
  `CurriculumID` int(11) NOT NULL auto_increment,
  `CurriculumCode` int(11) default NULL,
  `CurriculumName` varchar(255) default NULL,
  `State` char(1) default '0',
  PRIMARY KEY  (`CurriculumID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

#
# Data for table "curriculum"
#

INSERT INTO `curriculum` VALUES (1,101,'数据结构','1'),(2,201,'国际经济学','2'),(3,301,'国际商务英语','3'),(4,102,'安卓','1'),(5,103,'JAVA','1'),(6,302,'涉外经济法','3'),(7,303,'企业会计学','3'),(8,202,'世界经济概论','2'),(9,203,'财政学','2');

#
# Structure for table "department"
#

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `DeptID` int(11) NOT NULL auto_increment,
  `DeptCode` int(11) default NULL,
  `DeptName` varchar(255) default NULL,
  `DeptDesn` varchar(255) default NULL,
  `State` char(1) default '0',
  PRIMARY KEY  (`DeptID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "department"
#

INSERT INTO `department` VALUES (1,159,'软件系',NULL,'1'),(2,158,'金融系',NULL,'2'),(3,157,'贸易系',NULL,'3');

#
# Structure for table "menu"
#

DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `MenuID` int(11) NOT NULL auto_increment,
  `MenuName` varchar(255) default NULL,
  `ParentID` int(11) default NULL,
  `Url` varchar(255) default NULL,
  `State` char(1) default '0',
  PRIMARY KEY  (`MenuID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "menu"
#


#
# Structure for table "relation"
#

DROP TABLE IF EXISTS `relation`;
CREATE TABLE `relation` (
  `Id` int(11) NOT NULL auto_increment,
  `StudentCode` varchar(255) default NULL,
  `ClassCode` varchar(255) default NULL,
  `CurriculumCode` varchar(255) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "relation"
#


#
# Structure for table "rolepermissions"
#

DROP TABLE IF EXISTS `rolepermissions`;
CREATE TABLE `rolepermissions` (
  `RoleID` int(11) NOT NULL default '0',
  `TreeID` int(11) default NULL,
  `ParentID` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "rolepermissions"
#

INSERT INTO `rolepermissions` VALUES (1,8,7),(2,10,10),(3,9,7),(4,1,0),(2,9,7),(3,8,7),(1,10,0),(1,7,0),(3,8,7),(3,10,10),(4,2,1),(4,3,1),(4,4,1),(4,5,0),(4,6,0);

#
# Structure for table "roles"
#

DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `RoleID` int(11) NOT NULL auto_increment,
  `RoleName` varchar(255) default NULL,
  `RoleDesc` varchar(255) default NULL,
  `PerMission` varchar(255) default NULL,
  `Baoliu` char(1) default '1',
  PRIMARY KEY  (`RoleID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "roles"
#

INSERT INTO `roles` VALUES (1,'学生','学生','三级','1'),(2,'教师','教师','二级','1'),(3,'主任','主任','二级','1'),(4,'教务处','管理员','一级','1');

#
# Structure for table "score"
#

DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `Id` int(11) NOT NULL auto_increment,
  `weight` varchar(255) default NULL,
  `txt` varchar(255) default NULL,
  `parent_id` varchar(255) default NULL,
  `is_leaf` varchar(255) default NULL,
  `score` varchar(255) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=utf8;

#
# Data for table "score"
#

INSERT INTO `score` VALUES (1,'0.3','学生方面评价',NULL,'0',NULL),(2,'0.25','系(部)方面评价',NULL,'0',NULL),(3,'0.2','教师同行方面评价',NULL,'0',NULL),(4,'0.15','概念的讲解','1','0',NULL),(5,NULL,'语言精练，深入浅出，讲解准确','4','1','1'),(6,NULL,'讲解清晰，容易接受','4','1','0.85'),(7,NULL,'讲解基本准确，但不易接受','4','1','0.65'),(8,NULL,'概念紊乱，时有差错','4','1','0.45'),(9,'0.15','重点和难点','1','0',NULL),(10,NULL,'重点突出，讲清难点，举一反三','9','1','1'),(11,NULL,'能把握重点、难点，但讲解不够明确','9','1','0.85'),(12,NULL,'重点不明显，难点讲不透','9','1','0.65'),(13,NULL,'重点一言而过，难点草率了事','9','1','0.45'),(14,'0.1','逻辑性和条理性','1','0',NULL),(15,NULL,'层次分明，融会贯通','14','1','1'),(16,NULL,'条目较清楚，有分析归纳','14','1','0.85'),(17,NULL,'平淡叙述，缺乏连贯性','14','1','0.65'),(18,NULL,'杂乱无章，前后矛盾','14','1','0.45'),(19,'0.1','趣味性和生动性','1','0',NULL),(20,NULL,'讲解方法新颖，举例生动，有吸引力','19','1','1'),(21,NULL,'讲解较熟练，语言通俗','19','1','0.85'),(22,NULL,'讲解平淡，语言单调','19','1','0.65'),(23,NULL,'讲解生疏，远离课题，语言枯燥','19','1','0.45'),(24,'0.05','板书','1','0',NULL),(25,NULL,'简繁适度，清楚醒目','24','1','1'),(26,NULL,'条目明白，书写整洁','24','1','0.85'),(27,NULL,'布局较差，详略失当','24','1','0.65'),(28,NULL,'次序凌乱，书写潦草','24','1','0.45'),(29,'0.08','辅导（阅读指导）','1','0',''),(30,NULL,'辅导及时、并指导课外阅读','29','1','1'),(31,NULL,'定期辅导，并布置课外阅读','29','1','0.85'),(32,NULL,'辅导较少','29','1','0.65'),(33,NULL,'没有辅导','29','1','0.45'),(34,'0.1','作业与批改','1','0',NULL),(35,NULL,'选题得当，批改及时，注意讲评','34','1','1'),(36,NULL,'作业适量，批改及时','34','1','0.85'),(37,NULL,'注意学生能力培养，并在教学中有所体现','34','1','0.65'),(38,NULL,'选题随便，批改马虎','34','1','0.45'),(39,'0.1','能力培养','1','0',NULL),(40,NULL,'思路开阔，鼓励创新，注意能力培养、效果明显','39','1','1'),(41,NULL,'注意学生能力培养，并在教学中有所体现','39','1','0.85'),(42,NULL,'能提出能力培养的要求，但缺乏具体的办法','39','1','0.65'),(43,NULL,'忽视能力培养，单纯灌输书本知识','39','1','0.45'),(44,'0.1','教书育人','1','0',NULL),(45,NULL,'全面关心学生，经常接触学生，亲切、严格','44','1','1'),(46,NULL,'关心学生的学业，引导学生学好本门课程','44','1','0.85'),(47,NULL,'单纯完成上课任务，与同学接触较少','44','1','0.65'),(48,NULL,'对学生漠不关心，放任自流','44','1','0.45'),(49,'0.07','为人师表','1','0',NULL),(50,NULL,'严于律己，以身作则，堪称楷模','49','1','1'),(51,NULL,'举止文明，待人热情','49','1','0.85'),(52,NULL,'注意礼貌，待人和气','49','1','0.65'),(53,NULL,'要求不严，言谈失当','49','1','0.45'),(54,'0.3','量考核','2','0',NULL),(55,'0.75','教学工作量','54','0',NULL),(56,NULL,'超工作量','55','1','1'),(57,NULL,'满工作量','55','1','0.85'),(58,NULL,'接近完成（70%）','55','1','0.65'),(59,NULL,'差距较大','55','1','0.45'),(60,'0.15','社会工作量','54','0',NULL),(61,NULL,'担任教研室主任','60','1','1'),(62,NULL,'担任办公室、工作室主任','60','1','0.85'),(63,NULL,'担任专业班主任（辅导员）等其他工作0.65','60','1','0.65'),(64,NULL,'未承担','60','1','0.45'),(65,'0.1','任课班级','54','0',NULL),(66,NULL,'任4个班级以上，或双进度','65','1','1'),(67,NULL,'任3个班级','65','1','0.85'),(68,NULL,'任2个班级','65','1','0.65'),(69,NULL,'任1个班级','65','1','0.45'),(70,'0.7','质考核','2','0',NULL),(71,'0.4','工作态度','70','0',NULL),(72,'0.1','接受任务态度','71','0',NULL),(73,NULL,'勇挑重担','72','1','1'),(74,NULL,'主动承担','72','1','0.85'),(75,NULL,'一般','72','1','0.65'),(76,NULL,'较差','72','1','0.45'),(77,'0.9','教学常规','71','0',NULL),(78,'0.15','授课计划制定','77','0',NULL),(79,NULL,'清晰','78','1','1'),(80,NULL,'完整','78','1','0.85'),(81,NULL,'一般','78','1','0.65'),(82,NULL,'潦草','78','1','0.45'),(83,'0.15','教案首页','77','0',NULL),(84,NULL,'完整','83','1','1'),(85,NULL,'缺一项','83','1','0.85'),(86,NULL,'缺二项','83','1','0.65'),(87,NULL,'缺二项以上','83','1','0.45'),(88,'0.15','备课余量','77','0',NULL),(89,NULL,'一周以上','88','1','1'),(90,NULL,'一周','88','1','0.85'),(91,NULL,'接近一周','88','1','0.65'),(92,NULL,'没有余量','88','1','0.45'),(93,'0.1','教学日志的填写','77','0',NULL),(94,NULL,'清楚、准确','93','1','1'),(95,NULL,'正确、及时','93','1','0.85'),(96,NULL,'填写缺项','93','1','0.65'),(97,NULL,'填写马虎','93','1','0.45'),(98,'0.1','教学表格的填写','77','0',NULL),(99,NULL,'认真且有见解','98','1','1'),(100,NULL,'详尽、整洁','98','1','0.85'),(101,NULL,'正确','98','1','0.65'),(102,NULL,'潦草、拖拉','98','1','0.45'),(103,'0.15','辅导、作业','77','0',NULL),(104,NULL,'每周有辅导','103','1','1'),(105,NULL,'辅导较经常','103','1','0.85'),(106,NULL,'辅导较少','103','1','0.65'),(107,NULL,'不辅导','103','1','0.45'),(108,'0.2','教学秩序的掌握','77','0',NULL),(109,NULL,'严格','108','1','1'),(110,NULL,'较严格','108','1','0.85'),(111,NULL,'一般','108','1','0.65'),(112,NULL,'出现教学事故','108','1','0.45'),(113,'0.15','组织教学','3','0',NULL),(114,NULL,'教学组织安排得当，气氛活跃，纪律良好','113','1','1'),(115,NULL,'注意学生动态，教学有条不紊','113','1','0.85'),(116,NULL,'忽视教学步骤，师生双边活动较差','113','1','0.65'),(117,NULL,'只顾自己讲，不管学生情况','113','1','0.45'),(118,'0.15','教学要求、教学内容','3','0',NULL),(119,NULL,'切合教学大纲要求与实际，内容组织科学严密','118','1','1'),(120,NULL,'符合教学大纲要求，内容正确','118','1','0.85'),(121,NULL,'基本达到教学大纲要求，内容偶有差错','118','1','0.65'),(122,NULL,'降低教学标准，内容时有差错','118','1','0.45'),(123,'0.1','概念讲解','3','0',NULL),(124,NULL,'语言精练，深入浅出，讲解准确','123','1','1'),(125,NULL,'讲解清晰，容易接受','123','1','0.85'),(126,NULL,'讲解基本准确，但不易接受','123','1','0.65'),(127,NULL,'概念紊乱，时有差错','123','1','0.45'),(128,'0.1','重点和难点','3','0',NULL),(129,NULL,'重点突出，讲清难点，举一反三','128','1','1'),(130,NULL,'能把握重点、难点，但讲解不够明确','128','1','0.85'),(131,NULL,'重点不明显，难点讲不透','128','1','0.65'),(132,NULL,'重点一言而过，难点草率了事','128','1','0.45'),(133,'0.08','趣味性与生动性','3','0',NULL),(134,NULL,'讲解方法新颖，举例生动，有吸引力','133','1','1'),(135,NULL,'讲解较熟练，语言通俗','133','1','0.85'),(136,NULL,'讲解平淡，语言单调','133','1','0.65'),(137,NULL,'讲解生疏，远离课题，语言枯燥','133','1','0.45'),(138,'0.07','直观教学与板书','3','0',NULL),(139,NULL,'教具使用合理，板书清晰，示教形象、直观','138','1','1'),(140,NULL,'注意直观教学，板书条目明白、整洁','138','1','0.85'),(141,NULL,'教具使用失当，板书布局较差','138','1','0.65'),(142,NULL,'忽视直观教学，板书凌乱','138','1','0.45'),(143,'0.1','智力能力的培养','3','0',NULL),(144,NULL,'运用各种方法，调动学生积极思维，注重能力培养','143','1','1'),(145,NULL,'注意调动学生思维和能力培养，方法和效果欠佳','143','1','0.85'),(146,NULL,'缺乏启发式方法和能力培养手段','143','1','0.65'),(147,NULL,'照本宣科，不搞启发式教学','143','1','0.45'),(148,'0.1','理论联系实际','3','0',NULL),(149,NULL,'理论与实例、实验、实际密切结合','148','1','1'),(150,NULL,'理论能结合实际进行教学','148','1','0.85'),(151,NULL,'理论与实际结合不理想','148','1','0.65'),(152,NULL,'理论与实际严重脱节','148','1','0.45'),(153,'0.15','教材处理','3','0',NULL),(154,NULL,'科学的处理教材，繁简增删适当，收事半功倍之效','153','1','1'),(155,NULL,'对教材的处理，有助于学生理解和掌握内在联系','153','1','0.85'),(156,NULL,'基本按照教材讲课，没有给学生什么新东西','153','1','0.65'),(157,NULL,'对教材毫无处理，完全重复课本内容','153','1','0.45');

#
# Structure for table "student"
#

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `StudentID` int(11) NOT NULL auto_increment,
  `StudentCode` int(11) default NULL,
  `StudentName` varchar(255) default NULL,
  `SudentSex` int(1) default NULL,
  `State` char(1) default '0',
  PRIMARY KEY  (`StudentID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "student"
#

INSERT INTO `student` VALUES (1,159000713,'李达尧',0,'0'),(2,159000701,'牟博维',0,'0'),(3,159000720,'江震宇',0,'0');

#
# Structure for table "teacher"
#

DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `TeacherID` int(11) NOT NULL auto_increment,
  `TeacherCode` int(11) default NULL,
  `TeacherName` varchar(255) default NULL,
  `TeacherSex` char(1) default NULL,
  `level` varchar(255) default NULL,
  `State` char(1) default '0',
  PRIMARY KEY  (`TeacherID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "teacher"
#

INSERT INTO `teacher` VALUES (1,12123,'木子','0','2','0'),(2,12121,'子木','1','1','0'),(3,12122,'木木子','1','3','0');

#
# Structure for table "tree"
#

DROP TABLE IF EXISTS `tree`;
CREATE TABLE `tree` (
  `TreeID` int(11) NOT NULL auto_increment,
  `Text` varchar(255) default NULL,
  `Desn` varchar(255) default NULL,
  `ParentID` int(11) default NULL,
  `Url` varchar(255) default NULL,
  PRIMARY KEY  (`TreeID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

#
# Data for table "tree"
#

INSERT INTO `tree` VALUES (1,'用户管理','用户信息管理',0,'11'),(2,'学生管理','学生信息管理',1,'22'),(3,'教师管理','教师信息管理',1,'33'),(4,'主任管理','主任信息管理',1,'44'),(5,'问卷管理','问卷信息管理',0,'55'),(6,'问题管理','问题信息管理',0,'44'),(7,'评教管理','评教信息管理',0,'11'),(8,'评价教师','评价教师',7,'11'),(9,'评价同行','评价同行',7,'11'),(10,'个人信息','个人信息管理',0,'11');

#
# Structure for table "userroles"
#

DROP TABLE IF EXISTS `userroles`;
CREATE TABLE `userroles` (
  `RoleID` int(11) NOT NULL default '0',
  `UserID` int(11) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "userroles"
#

INSERT INTO `userroles` VALUES (1,1),(1,2),(4,3),(2,4),(3,5);

#
# Structure for table "users"
#

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `UserID` int(11) NOT NULL default '0',
  `UserName` varchar(255) default NULL,
  `Password` varchar(255) default NULL,
  `UserType` int(11) default NULL,
  `RealName` varchar(255) default NULL,
  `Email` varchar(255) default NULL,
  `State` int(11) default '0',
  `Baoliu` char(1) default '1',
  PRIMARY KEY  (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "users"
#

INSERT INTO `users` VALUES (1,'159000701','123',NULL,'mbw','123',0,'1'),(2,'159000713','123',NULL,'dsa','123',0,'1'),(3,'123','123',NULL,'qwfd','123',0,'1'),(4,'12123','123',NULL,'wdq','123',0,'1'),(5,'213','123',NULL,'wwqw','123',0,'1');
