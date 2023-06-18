use Novel;

show tables;

show columns from comment;


delimiter //
create or replace trigger insert_comment
	after insert
	on comment 
	for each ROW 
BEGIN 
	INSERT  INTO ccfg values(NEW.cno, curdate(), curdate());
END //
Delimiter ;

delimiter //
create or replace trigger update_comment
	after UPDATE 
	on comment
	for each ROW 
BEGIN 
	UPDATE ccfg set edate = curdate() where ccfg.cno = old.cno;
END //
delimiter ;

delimiter //
create or replace trigger delete_comment
	after DELETE 
	on comment
	for EACH ROW 
BEGIN 
	DELETE from ccfg WHERE ccfg.cno = old.cno;
END //
delimiter ;


delimiter //
create or replace trigger insert_feedback
	after insert 
	on feedback
	for each ROW 
BEGIN 
	insert into fvote values(NEW.fid, 0, 0, false);
END //
delimiter ;

delimiter //
create or replace trigger delete_feedback
	after delete 
	on feedback
	for each ROW 
BEGIN 
	delete from fvote where fvote.fid = OLD.fid;
END //
delimiter ;
