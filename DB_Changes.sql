--13-05-2014: Adding gender column in user_details table
ALTER TABLE `user_details`
	CHANGE COLUMN `gender` `gender` VARCHAR(25) AFTER `avatar`;
	
UPDATE user_details SET gender = 'Male' WHERE gender IS NULL;