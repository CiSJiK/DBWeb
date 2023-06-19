create or replace table novel (
	nnum int not null auto_increment primary key,
	nname char(50) not null
)engine=innodb;

create or replace table context(
	cid int not null auto_increment primary key,
	nnum int not null,
	ctext text not null,
	cdate date not null default NOW(),
	uid char(20) not null,
	foreign key (uid) references account(uid),
	foreign key (nnum) references novel(nnum)
)engine=innodb;

create or replace table ndone (
	nnum int not null,
	done bool not null default false,
	foreign key (nnum) references novel(nnum)
)engine=innodb;

create or replace table ncfg(
	nnum int not null,
	cdate date not null default NOW(),
	edate date not null default NOW(),
	foreign key (nnum) references novel(nnum)
) engine=innodb;

create or replace table account(
	uid char(20) primary key,
	upw char(20) not null
)engine=innodb;

create or replace table feedback(
	fid int not null auto_increment primary key,
	nnum int not null,
	fname char(50) not null,
	fcon text not null,
	uid char(20) not null,
	foreign key (nnum) references novel(nnum) on delete cascade,
	foreign key (uid) references account(uid) on delete cascade
)engine=innodb;

create table flis (
	fid int(11) not null,
	fdate date not null default NOW(),
	foreign key (fid) references feedback(fid) on delete cascade
)engine=innodb;

#create or replace table fvote(
#	fid int not null,
#	flike int not null default 0,
#	fhate int not null default 0,
#	foreign key (fid) references feedback(fid) on delete cascade
#)engine=innodb;

#create or replace table fselected (
#	fid int not null,
#	isSelected int not null default false,
#	foreign key (fid) references feedback(fid) on delete cascade
#)engine=innodb;



