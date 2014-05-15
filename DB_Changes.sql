--13-05-2014: Adding gender column in user_details table
ALTER TABLE `user_details`
	CHANGE COLUMN `gender` `gender` VARCHAR(25) AFTER `avatar`;	
UPDATE user_details SET gender = 'Male' WHERE gender IS NULL;

--15-05-2014: Adding role column in user_details table
ALTER TABLE `user_details`
	ADD COLUMN `role` VARCHAR(25) NULL DEFAULT NULL AFTER `gender`;
UPDATE `spring_db`.`user_details` SET `role`='ADMIN' WHERE  `user_id`=11;	