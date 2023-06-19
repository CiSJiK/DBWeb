##use Novel;

##show tables;

##show columns from comment;

delimiter //
create or replace trigger insert_feedback
	after insert
	on feedback
	for each ROW
BEGIN
	insert into flis(fid) values(otNEW.fid);
END //
delimiter ;

delimiter //
create or replace trigger delete_feedback
	after delete 
	on feedback
	for each ROW 
BEGIN 
	delete from flis where flis.fid = OLD.fid;
END //
delimiter ;

delimiter //
create or replace trigger insert_novel
	after insert 
	on novel
	for each ROW 
BEGIN 
	insert into ndone(nnum) values(otNEW.nnum);
	insert into ncfg(nnum) values(otNEW.nnum);
END //
delimiter ;

delimiter //
create or replace trigger update_novel
	after update
	on novel
	for each ROW
BEGIN
	update ncfg set edate = NOW() where ncfg.nnum = OLD.nnum;
END //
delimiter ;
