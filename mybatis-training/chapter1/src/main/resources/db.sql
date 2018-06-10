 create table country(
   id int not null AUTO_INCREMENT,
   countryName varchar(255) NULL,
   countryCode varchar(255) null,
   PRIMARY KEY (id)
 );


 insert  country (countryName, countryCode) values('中国','CN'),
   ('美国','US'),('俄罗斯','RU'),('英国','GB'),('法国','FR'),('哈萨克斯坦','KAZ'),('乌兹别克斯坦','UZB')