DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` INT AUTO_INCREMENT  PRIMARY KEY,
  `username` VARCHAR(250) NOT NULL,
  `password` VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` INT AUTO_INCREMENT  PRIMARY KEY,
  `name` VARCHAR(250) NOT NULL,
  `user_id` INT,
  constraint `fk_user_id` foreign key(`user_id`) references user(`id`)
);

insert into `user`(`id`,`username`,`password`) values(1,'amar','admin');
insert into `user`(`id`,`username`,`password`) values(2,'rama','admin');
insert into `user`(`id`,`username`,`password`) values(3,'aadi','admin');


insert into `roles`(`name`,`user_id`) values('ADMIN',1);
insert into `roles`(`name`,`user_id`) values('GUEST',2);
insert into `roles`(`name`,`user_id`) values('USER',3);





