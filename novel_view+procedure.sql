create or replace view novelList
as
select nnum, nname from novel order by nnum asc;

create or replace view novelDoneList
as
select novel.nnum, novel.nname from novel, ndone where novel.nnum = ndone.nnum and ndone.done = true order by novel.nnum asc;

delimiter $$
create or replace procedure feedbackList(in novelNum int)
BEGIN 
	select fid, fname from feedback where nnum = novelNum;
END $$
delimiter ;

delimiter $$
create or replace procedure readNovel(in novelNum int, out name char(50))
BEGIN 
	select nname into name from novel where nnum = novelNum;
	select cid, ctext, cdate, uid from context where nnum = novelNum;
END $$
delimiter ;

delimiter $$
create or replace procedure readFeedback(in feedbackNum int, out name char(50))
BEGIN 
	select fname into name from feedback where fid = feedbackNum;
	select fcon from feedback where fid = feedbackNum;
END $$
delimiter ;