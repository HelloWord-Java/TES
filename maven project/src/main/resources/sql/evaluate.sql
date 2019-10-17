# Host: localhost  (Version 5.1.28-rc-community)
# Date: 2018-10-09 15:21:19
# Generator: MySQL-Front 6.0  (Build 3.3)


#
# Structure for table "action"
#

DROP TABLE IF EXISTS `action`;
CREATE TABLE `action` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `actionName` varchar(50) DEFAULT NULL COMMENT '功能名',
  `actionUrl` varchar(255) DEFAULT NULL COMMENT '功能地址',
  `parentId` int(11) DEFAULT NULL COMMENT '父节点',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='功能表';

#
# Data for table "action"
#

INSERT INTO `action` VALUES (1,'在线评教系统',NULL,0),(2,'系统管理',NULL,1),(3,'业务管理',NULL,1),(4,'其他',NULL,1),(5,'用户管理','/TCES1/moduls/user/userManager.jsp',2),(6,'角色管理',' \r\n\r\n/TCES1/moduls/scale/scaleManager.jsp',2),(7,'功能管理','/TCES1/moduls/action/actionManager.jsp',2),(8,'指标管理','/TCES1/initQuotaTree',2),(9,'授课管理','/TCES1/moduls/Teachinginfo/teachingManager.jsp',3),(10,'课程管理','/TCES1/moduls/course/ReadCourse.jsp',3),(11,'评教管理','/TCES1/moduls/State/StateManger.jsp',3),(12,'班级管理','/TCES1/moduls/Classinfo/ClassinfoManger.jsp',3),(13,'批次管理','/TCES1/moduls/Batchinfo/BatchManger.jsp',3),(14,'在线评教','/TCES1/fallbatch',4),(15,'查看成绩','/TCES1/moduls/Score/score.jsp',4),(16,'院系管理','/TCES1/moduls/Department/DepartmentManger.jsp',3);

#
# Structure for table "avgscores"
#

DROP TABLE IF EXISTS `avgscores`;
CREATE TABLE `avgscores` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `teacherId` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `avgscore` float(5,2) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "avgscores"
#

/*!40000 ALTER TABLE `avgscores` DISABLE KEYS */;
INSERT INTO `avgscores` VALUES (7,2,1,0.52);
/*!40000 ALTER TABLE `avgscores` ENABLE KEYS */;

#
# Structure for table "batch"
#

DROP TABLE IF EXISTS `batch`;
CREATE TABLE `batch` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `batchName` varchar(100) DEFAULT NULL COMMENT '批次名',
  `state` int(11) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='批次表';

#
# Data for table "batch"
#

INSERT INTO `batch` VALUES (1,'大一上学期',0),(2,'大一下学期',0),(3,'大二上学期',0),(4,'大二下学期',0),(5,'大三上学期',0),(6,'大三下学期',0),(7,'大四上学期',0),(8,'大四下学期',0);

#
# Structure for table "book"
#

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_title` varchar(30) NOT NULL DEFAULT '',
  `isbn` varchar(20) NOT NULL DEFAULT '',
  `date_of_printing` varchar(20) DEFAULT NULL,
  `author` varchar(15) DEFAULT NULL,
  `press` varchar(15) DEFAULT NULL,
  `category` char(1) DEFAULT NULL,
  `unit_price` float DEFAULT NULL,
  PRIMARY KEY (`book_title`,`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "book"
#


#
# Structure for table "classinfo"
#

DROP TABLE IF EXISTS `classinfo`;
CREATE TABLE `classinfo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(50) DEFAULT NULL COMMENT '班级名',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='班级信息表';

#
# Data for table "classinfo"
#

INSERT INTO `classinfo` VALUES (1,'1590001'),(2,'1590002'),(3,'1590003'),(14,'1590004');

#
# Structure for table "course"
#

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `Id` varchar(30) NOT NULL DEFAULT '',
  `courseName` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "course"
#

INSERT INTO `course` VALUES ('1','计算机原理'),('2','java设计');

#
# Structure for table "department"
#

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "department"
#

INSERT INTO `department` VALUES (1,'软件学院'),(2,'土木学院');

#
# Structure for table "grades"
#

DROP TABLE IF EXISTS `grades`;
CREATE TABLE `grades` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) NOT NULL DEFAULT '0' COMMENT '外键学生来自user',
  `teachingId` int(11) NOT NULL DEFAULT '0' COMMENT '授课id',
  `score` float(5,2) NOT NULL DEFAULT '0.00' COMMENT '成绩',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='成绩表';

#
# Data for table "grades"
#

INSERT INTO `grades` VALUES (185,10,9,0.13),(186,10,9,0.27),(187,10,9,0.36),(188,10,9,0.42),(189,10,9,0.46),(190,10,9,0.51),(191,10,9,0.54),(192,10,9,0.63),(193,10,9,0.69),(194,10,9,0.76),(195,11,11,0.13),(196,11,11,0.36),(197,11,11,0.42),(198,11,11,0.51),(199,11,11,0.54),(200,11,11,0.59),(201,11,11,0.68),(202,11,11,0.74),(203,11,11,0.83),(204,11,11,0.87);

#
# Structure for table "order_book"
#

DROP TABLE IF EXISTS `order_book`;
CREATE TABLE `order_book` (
  `staff_id` varchar(30) NOT NULL DEFAULT '',
  `sec_id` int(11) NOT NULL DEFAULT '0',
  `book_title` varchar(30) NOT NULL DEFAULT '',
  `isbn` varchar(20) NOT NULL DEFAULT '',
  `remark` varchar(30) DEFAULT NULL,
  `approval` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`staff_id`,`sec_id`,`book_title`,`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "order_book"
#


#
# Structure for table "quota"
#

DROP TABLE IF EXISTS `quota`;
CREATE TABLE `quota` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `quotaName` varchar(100) NOT NULL DEFAULT '' COMMENT '指标名',
  `type` int(11) NOT NULL DEFAULT '0' COMMENT '指标类型：0(无选项)，1(有选项)',
  `weight` float(5,2) DEFAULT '0.00' COMMENT '权重',
  `parentId` int(11) DEFAULT NULL COMMENT '父节点',
  `isLeaf` bit(1) NOT NULL DEFAULT '\0' COMMENT '是否叶子节点：0(否)，1(是)',
  `formula` varchar(255) DEFAULT NULL COMMENT '叶子节点权值计算公式',
  `remark` varchar(255) DEFAULT NULL,
  `isDelete` bit(1) DEFAULT '\0' COMMENT '是否删除：0(否)，1(是)',
  `sort` int(11) DEFAULT '0' COMMENT '排序值',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='指标表';

#
# Data for table "quota"
#

INSERT INTO `quota` VALUES (1,'指标管理',0,0.00,0,b'0',NULL,NULL,b'0',0),(2,'学生方面',0,0.30,1,b'0',NULL,NULL,b'0',0),(3,'系部方面',0,0.70,1,b'0',NULL,NULL,b'0',0),(4,'同行方面',0,0.00,1,b'0',NULL,NULL,b'0',0),(5,'教师个人方面',0,0.00,1,b'0',NULL,NULL,b'0',0),(6,'概念的讲解',0,0.15,2,b'0',NULL,NULL,b'0',0),(7,'重点和难点',0,0.15,2,b'0',NULL,NULL,b'0',0),(8,'逻辑性和条理性',0,0.10,2,b'0',NULL,NULL,b'0',0),(9,'趣味性和生动性',0,0.10,2,b'0',NULL,NULL,b'0',0),(10,'板书',0,0.05,2,b'0',NULL,NULL,b'0',0),(11,'辅导（阅读指导）',0,0.08,2,b'0',NULL,NULL,b'0',0),(12,'作业与批改',0,0.10,2,b'0',NULL,NULL,b'0',0),(13,'能力培养',0,0.10,2,b'0',NULL,NULL,b'0',0),(14,'教书育人',0,0.10,2,b'0',NULL,NULL,b'0',0),(16,'量考核',0,0.30,3,b'0',NULL,NULL,b'0',0),(17,'质考核',0,0.70,3,b'0',NULL,NULL,b'0',0),(18,'教学工作量',0,0.75,16,b'0',NULL,NULL,b'0',0),(19,'社会工作量',0,0.15,16,b'0',NULL,NULL,b'0',0),(20,'任课班级',0,0.10,16,b'0',NULL,NULL,b'0',0),(21,'工作态度',0,0.40,17,b'0',NULL,NULL,b'0',0),(22,'完成任务情况',0,0.05,17,b'0',NULL,NULL,b'0',0),(23,'学术研究水平',0,0.15,17,b'0',NULL,NULL,b'0',0),(24,'教学反映',0,0.15,17,b'0',NULL,NULL,b'0',0),(25,'参加教研活动',0,0.05,17,b'0',NULL,NULL,b'0',0),(26,'考试命题',0,0.05,17,b'0',NULL,NULL,b'0',0),(27,'接受任务态度',0,0.10,21,b'0',NULL,NULL,b'0',0),(28,'教学常规',0,0.90,21,b'0',NULL,NULL,b'0',0),(29,'授课计划制定',0,0.10,28,b'0',NULL,NULL,b'0',0),(30,'教案首页',0,0.20,28,b'0',NULL,NULL,b'0',0),(31,'备课余量',0,0.10,28,b'0',NULL,NULL,b'0',0),(32,'教学日志的填写',0,0.10,28,b'0',NULL,NULL,b'0',0),(33,'教学表格的填写',0,0.10,28,b'0',NULL,NULL,b'0',0),(34,'辅导',0,0.20,28,b'0',NULL,NULL,b'0',0),(35,'教学秩序的掌握',0,0.20,28,b'0',NULL,NULL,b'0',0),(36,'概念的讲解',0,0.15,22,b'0',NULL,NULL,b'0',0),(37,'重点和难点',0,0.15,22,b'0',NULL,NULL,b'0',0),(38,'逻辑性、条理性',0,0.10,22,b'0',NULL,NULL,b'0',0),(39,'趣味性、生动性',0,0.10,22,b'0',NULL,NULL,b'0',0),(40,'板书',0,0.05,22,b'0',NULL,NULL,b'0',0),(41,'能力培养',0,0.15,22,b'0',NULL,NULL,b'0',0),(42,'理论联系实际',0,0.10,22,b'0',NULL,NULL,b'0',0),(43,'辅导（阅读指导）',0,0.10,22,b'0',NULL,NULL,b'0',0),(44,'作业与批改',0,0.10,22,b'0',NULL,NULL,b'0',0),(45,'职称',0,0.20,23,b'0',NULL,NULL,b'0',0),(46,'运用新知识、新技术的能力',0,0.50,23,b'0',NULL,NULL,b'0',0),(47,'论文撰写、教材编写能力',0,0.30,23,b'0',NULL,NULL,b'0',0),(48,'汲取新信息新技术',0,0.05,17,b'0',NULL,NULL,b'0',0),(49,'能力培养',0,0.10,17,b'0',NULL,NULL,b'0',0),(50,'为人师表',0,0.07,2,b'0',NULL,NULL,b'0',0);

#
# Structure for table "quotaoptions"
#

DROP TABLE IF EXISTS `quotaoptions`;
CREATE TABLE `quotaoptions` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `quotaId` int(11) NOT NULL DEFAULT '0' COMMENT '外键指标id',
  `optionsName` varchar(255) DEFAULT NULL COMMENT '指标选项名',
  `score` float(5,2) DEFAULT NULL COMMENT '分数',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=154 DEFAULT CHARSET=utf8 COMMENT='指标选项表';

#
# Data for table "quotaoptions"
#

INSERT INTO `quotaoptions` VALUES (1,6,'语言精练，深入浅出，讲解准确',5.00),(2,6,'讲解清晰，容易接受',3.00),(4,6,'讲解基本准确，但不易接受',2.00),(5,6,'概念紊乱，时有差错',1.00),(6,7,'重点突出，讲清难点，举一反三',5.00),(7,7,'能把握重点、难点，但讲解不够明确',3.00),(8,7,'重点不明显，难点讲不透',2.00),(9,7,'重点一言而过，难点草率了事',1.00),(10,8,'非常满意',5.00),(11,8,'满意',3.00),(12,8,'一般',2.00),(13,8,'不满意',1.00),(14,9,'非常满意',5.00),(15,9,'满意',3.00),(16,9,'一般',2.00),(17,9,'不满意',1.00),(18,10,'非常满意',5.00),(19,10,'满意',3.00),(20,10,'一般',2.00),(21,10,'不满意',1.00),(22,11,'非常满意',5.00),(23,11,'满意',3.00),(24,11,'一般',2.00),(25,11,'不满意',1.00),(26,12,'非常满意',5.00),(27,12,'满意',3.00),(28,12,'一般',2.00),(29,12,'不满意',1.00),(30,13,'非常满意',5.00),(31,13,'满意',3.00),(32,13,'一般',2.00),(33,13,'不满意',1.00),(34,14,'非常满意',5.00),(35,14,'满意',3.00),(36,14,'一般',2.00),(37,14,'不满意',1.00),(38,15,'非常满意',5.00),(39,15,'满意',3.00),(40,15,'一般',2.00),(41,15,'不满意',1.00),(42,18,'非常满意',5.00),(43,18,'满意',3.00),(44,18,'一般',2.00),(45,18,'不满意',1.00),(46,19,'非常满意',5.00),(47,19,'满意',3.00),(48,19,'一般',2.00),(49,19,'不满意',1.00),(50,20,'非常满意',5.00),(51,20,'满意',3.00),(52,20,'一般',2.00),(53,20,'不满意',1.00),(54,27,'非常满意',5.00),(55,27,'满意',3.00),(56,27,'一般',2.00),(57,27,'不满意',1.00),(58,29,'非常满意',5.00),(59,29,'满意',3.00),(60,29,'一般',2.00),(61,29,'不满意',1.00),(62,30,'非常满意',5.00),(63,30,'满意',3.00),(64,30,'一般',2.00),(65,30,'不满意',1.00),(66,31,'非常满意',5.00),(67,31,'满意',3.00),(68,31,'一般',2.00),(69,31,'不满意',1.00),(70,32,'非常满意',5.00),(71,32,'满意',3.00),(72,32,'一般',2.00),(73,32,'不满意',1.00),(74,33,'非常满意',5.00),(75,33,'满意',3.00),(76,33,'一般',2.00),(77,33,'不满意',1.00),(78,34,'非常满意',5.00),(79,34,'满意',3.00),(80,34,'一般',2.00),(81,34,'不满意',1.00),(82,35,'非常满意',5.00),(83,35,'满意',3.00),(84,35,'一般',2.00),(85,35,'不满意',1.00),(86,36,'非常满意',5.00),(87,36,'满意',3.00),(88,36,'一般',2.00),(89,36,'不满意',1.00),(90,37,'非常满意',5.00),(91,37,'满意',3.00),(92,37,'一般',2.00),(93,37,'不满意',1.00),(94,38,'非常满意',5.00),(95,38,'满意',3.00),(96,38,'一般',2.00),(97,38,'不满意',1.00),(98,39,'非常满意',5.00),(99,39,'满意',3.00),(100,39,'一般',2.00),(101,39,'不满意',1.00),(102,40,'非常满意',5.00),(103,40,'满意',3.00),(104,40,'一般',2.00),(105,40,'不满意',1.00),(106,41,'非常满意',5.00),(107,41,'满意',3.00),(108,41,'一般',2.00),(109,41,'不满意',1.00),(110,42,'非常满意',5.00),(111,42,'满意',3.00),(112,42,'一般',2.00),(113,42,'不满意',1.00),(114,43,'非常满意',5.00),(115,43,'满意',3.00),(116,43,'一般',2.00),(117,43,'不满意',1.00),(118,44,'非常满意',5.00),(119,44,'满意',3.00),(120,44,'一般',2.00),(121,44,'不满意',1.00),(122,45,'非常满意',5.00),(123,45,'满意',3.00),(124,45,'一般',2.00),(125,45,'不满意',1.00),(126,46,'非常满意',5.00),(127,46,'满意',3.00),(128,46,'一般',2.00),(129,46,'不满意',1.00),(130,47,'非常满意',5.00),(131,47,'满意',3.00),(132,47,'一般',2.00),(133,47,'不满意',1.00),(134,24,'非常满意',5.00),(135,24,'满意',3.00),(136,24,'一般',2.00),(137,24,'不满意',1.00),(138,25,'非常满意',5.00),(139,25,'满意',3.00),(140,25,'一般',2.00),(141,25,'不满意',1.00),(142,26,'非常满意',5.00),(143,26,'满意',3.00),(144,26,'一般',2.00),(145,26,'不满意',1.00),(146,48,'非常满意',5.00),(147,48,'满意',3.00),(148,48,'一般',2.00),(149,48,'不满意',1.00),(150,49,'非常满意',5.00),(151,49,'满意',3.00),(152,49,'一般',2.00),(153,49,'不满意',1.00),(154,50,'非常满意',5.00),(155,50,'满意',3.00),(156,50,'一般',2.00),(157,50,'不满意',1.00);

#
# Structure for table "resource"
#

DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(100) DEFAULT NULL,
  `permission` varchar(100) DEFAULT NULL,
  `available` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_resource_parent_id` (`parent_id`),
  KEY `idx_resource_parent_ids` (`parent_ids`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "resource"
#


#
# Structure for table "scale"
#

DROP TABLE IF EXISTS `scale`;
CREATE TABLE `scale` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `scaleName` varchar(255) DEFAULT NULL COMMENT '角色名',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';

#
# Data for table "scale"
#

INSERT INTO `scale` VALUES (1,'管理员'),(2,'教师'),(3,'学生');

#
# Structure for table "scaleaction"
#

DROP TABLE IF EXISTS `scaleaction`;
CREATE TABLE `scaleaction` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `scaleId` int(11) NOT NULL DEFAULT '0' COMMENT '外键角色id',
  `actionId` int(11) NOT NULL DEFAULT '0' COMMENT '外键功能id',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='角色功能表';

#
# Data for table "scaleaction"
#

INSERT INTO `scaleaction` VALUES (25,1,1),(26,1,2),(27,1,3),(28,1,4),(29,1,5),(30,1,6),(31,1,7),(32,1,8),(33,1,9),(34,1,10),(35,1,11),(36,1,12),(37,1,13),(39,3,14),(40,2,14),(41,2,15),(42,2,1),(43,2,4),(44,3,1),(45,3,4),(46,1,16);

#
# Structure for table "scalequota"
#

DROP TABLE IF EXISTS `scalequota`;
CREATE TABLE `scalequota` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `scaleId` int(11) NOT NULL DEFAULT '0' COMMENT '外键角色id',
  `quotaId` int(11) NOT NULL DEFAULT '0' COMMENT '外键指标id',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='角色指标表';

#
# Data for table "scalequota"
#

INSERT INTO `scalequota` VALUES (1,1,1),(2,2,4),(3,3,2),(4,1,2),(5,1,3),(6,1,4),(7,1,5),(8,1,6),(9,1,7),(10,1,8),(11,1,9),(12,1,10),(14,1,11),(15,1,12),(16,1,13),(17,1,14),(18,1,15),(19,1,16),(20,1,17),(21,1,18),(22,1,19),(23,1,20),(24,1,21),(25,1,22),(26,1,23),(27,1,24),(29,1,25),(31,1,26),(32,1,27),(33,1,28),(34,1,29),(35,1,30),(36,1,31),(37,1,32),(38,1,33),(39,1,34),(40,1,35),(41,1,36),(42,1,37),(43,1,38),(44,1,39),(45,1,40),(46,1,41),(47,1,42),(48,1,43),(49,1,44),(50,1,45),(51,1,46),(52,1,47);

#
# Structure for table "section"
#

DROP TABLE IF EXISTS `section`;
CREATE TABLE `section` (
  `sec_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_title` varchar(15) DEFAULT NULL,
  `year` varchar(5) DEFAULT NULL,
  `limitCount` int(11) DEFAULT NULL,
  `staff_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "section"
#


#
# Structure for table "speciality"
#

DROP TABLE IF EXISTS `speciality`;
CREATE TABLE `speciality` (
  `spec_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(10) DEFAULT NULL,
  `spec_name` varchar(15) DEFAULT NULL,
  `year` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`spec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "speciality"
#


#
# Structure for table "staff"
#

DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `staff_id` varchar(30) NOT NULL DEFAULT '',
  `staff_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "staff"
#


#
# Structure for table "student"
#

DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` varchar(30) NOT NULL DEFAULT '',
  `student_name` varchar(20) DEFAULT NULL,
  `id_card` varchar(20) DEFAULT NULL,
  `year` varchar(5) DEFAULT NULL,
  `class_id` varchar(10) DEFAULT NULL,
  `telephone_number` varchar(20) DEFAULT NULL,
  `student_origin_base` varchar(10) DEFAULT NULL,
  `gender` varchar(4) DEFAULT NULL,
  `pic_path` varchar(45) DEFAULT NULL,
  `leave_of_absence` tinyint(1) DEFAULT NULL,
  `leave_school` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "student"
#


#
# Structure for table "takes"
#

DROP TABLE IF EXISTS `takes`;
CREATE TABLE `takes` (
  `student_id` varchar(30) NOT NULL DEFAULT '',
  `sec_id` varchar(30) NOT NULL DEFAULT '',
  `score` float DEFAULT NULL,
  PRIMARY KEY (`student_id`,`sec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "takes"
#


#
# Structure for table "teaching"
#

DROP TABLE IF EXISTS `teaching`;
CREATE TABLE `teaching` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `classId` int(11) DEFAULT NULL COMMENT '外键班级id',
  `courseId` int(11) DEFAULT NULL COMMENT '外键课程id',
  `teacherId` int(11) DEFAULT NULL COMMENT '外键教师id来自user',
  `batchId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='授课表';

#
# Data for table "teaching"
#

INSERT INTO `teaching` VALUES (9,1,1,2,1),(10,1,2,9,1),(11,2,1,2,1);

#
# Structure for table "timetable"
#

DROP TABLE IF EXISTS `timetable`;
CREATE TABLE `timetable` (
  `sec_id` int(11) DEFAULT NULL,
  `time` varchar(20) DEFAULT NULL,
  `weeks` varchar(20) DEFAULT NULL,
  `week` varchar(20) DEFAULT NULL,
  `classroom` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "timetable"
#


#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL DEFAULT '',
  `password` varchar(50) DEFAULT NULL,
  `classId` int(11) DEFAULT NULL,
  `depId` int(11) DEFAULT NULL,
  `salt` varchar(100) DEFAULT NULL,
  `role_ids` varchar(100) DEFAULT NULL,
  `locked` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'1','123',NULL,NULL,NULL,NULL,0),(2,'tea','123',0,1,NULL,NULL,0),(9,'tea2','123',0,1,NULL,NULL,0),(10,'159000101','123',1,1,NULL,NULL,0),(11,'159000201','123',2,1,NULL,NULL,0);

#
# Structure for table "userscale"
#

DROP TABLE IF EXISTS `userscale`;
CREATE TABLE `userscale` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0' COMMENT '外键用户id',
  `scaleId` int(11) NOT NULL DEFAULT '0' COMMENT '外键角色id',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='用户角色表';

#
# Data for table "userscale"
#

INSERT INTO `userscale` VALUES (1,2,2),(2,1,1),(14,9,2),(15,10,3),(18,11,3);
