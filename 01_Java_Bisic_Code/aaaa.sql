DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` int(10) NOT NULL COMMENT 'ID',
  `deleted` int(10) NOT NULL ,
  `creation_datetime` char(32) NOT NULL COMMENT 'creation_datetime',
  `title` varchar(256) NOT NULL COMMENT 'title',
  `content` varchar(64) NOT NULL COMMENT 'content',
  `modification_datetime` varchar(64) NOT NULL COMMENT 'modification_datetime',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

COMMIT;

SELECT user_name,user_code FROM SYS_USER
 WHERE USER_CODE = 'm0003' OR USER_ID = 6;
 
 
SELECT * FROM SYS_USER WHERE USER_CODE = 'm0003' AND USER_ID = '6';


SELECT * FROM SYS_USER where USER_CODE in ('m0002','m0003');
insert into SYS_USER value (9,'mj0004','a','a','b');


update SYS_USER set USER_name = 'aaaa' where USER_CODE = 'm0002';
delete from SYS_USER where USER_CODE = 'mj0004';

