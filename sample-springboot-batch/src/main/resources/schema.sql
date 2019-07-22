CREATE TABLE `student` (
  `seq` INT(11) NOT NULL AUTO_INCREMENT COMMENT '번호',
  `name` VARCHAR(50) NOT NULL COMMENT '이름',
  `grade` INT(11) NULL DEFAULT NULL COMMENT '학년',
  `age` INT(11) NULL DEFAULT NULL COMMENT '나이',
  `reg_date` VARCHAR(50) NULL DEFAULT NULL COMMENT '등록일',
  PRIMARY KEY (`seq`)
);
