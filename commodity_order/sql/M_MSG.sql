TRUNCATE TABLE `M_MSG`;

--
-- Dumping data for table `M_MSG`
--
INSERT INTO `M_MSG` (`CATALOG_ID`,`MSG_NO`,`MSG_KEISAI_KBN`,`KEISAI_FROM`,`KEISAI_TO`,`MSG_HEADER`,`MSG_NAIYOU`,`KOUSHIN_BI`,`KOUSHIN_USERID`,`TOUROKU_BI`,`TOUROKU_USERID`) VALUES
 ('1000005','1','1','2010-11-01','2010-12-01','チャット用のお知らせヘッダです。','チャット用のお知らせです','2010-11-19 00:00:00','test','2010-11-19 00:00:00','test'),
 ('1000005','2','1','2010-11-30','2010-12-31','11末からのお知らせです。','　E　１末からのお知らせです','2010-11-19 00:00:00','test','2010-11-19 00:00:00','test'),
 ('1000005','3','1','2010-11-02','2010-12-31','二日からのお知らせです。','二日からのお知らせです','2010-11-19 00:00:00','test','2010-11-19 00:00:00','test');
