
create table users(username varchar(20),password varchar(20))

create table consumer(conno varchar(20)primary key,areacode varchar(20),mrcode varchar(20),tariff varchar(20),phase varchar(20),posetno varchar(20),connectedload varchar(20),conname varchar(25),address varchar(200),connectiondate varchar(30),tariffid varchar(20))

create table demand(areacode varchar(20),mrcode varchar(20),conno varchar(20),previousreading numeric,presentreading numeric,unitconsumed numeric,demandid varchar(20),fixedcharge numeric,energycharge integer,duty numeric,mtrrent numeric,reconfee numeric,demand numeric,subsidy numeric,advancepaid numeric,previousarrears numeric,total numeric,intrestoncd numeric, netamt numeric,bd varchar(20),dd varchar(20),disd varchar(20))


create table meterdetails(conno varchar(20)not null,meterno varchar(20),noofdigits varchar(5),initialreading varchar(20))

create table depositdetails(conno varchar(20),deposit varchar(20),adldeposit varchar(20),oyceamt varchar(20),totinstalments varchar(10),endingmonth varchar(20),endingyear varchar(20),cdrtno varchar(10),cddate varchar(5),cdmonth varchar(5),cdyear varchar(10),acdrtno varchar(10),acddate varchar(5),acdmonth varchar(5),acdyear varchar(10),instalmentamt varchar(10),paidinstalments varchar(5),balnceinstalments varchar(5))

create table mg(conno varchar(20),lemgamt numeric,scmgamt numeric,lramt numeric,ilemg numeric,iscmg numeric,ilr numeric,mgendingdate varchar(200))

create table meterchange(conno varchar(20),presentmtrno varchar(20),fr varchar(20),newmtrno varchar(20),noofdigits varchar(20),initialreading varchar(20),dch varchar(5),mch varchar(5),ych varchar(10))

create table demandwithdrawal(conno varchar(20)not null,demandid varchar(20)not null,totaldemand numeric,withrawals numeric)

create table demandadjustment(conno varchar(20)not null,demandid varchar(20)not null,nameofoffice varchar(20),demandtobeadjusted numeric)

create table tariff(conno varchar(20),tariff varchar(20), tariffid varchar(20))

create table changetariff(conno varchar(20),areacode varchar(20),tariffid varchar(20),oldtariff varchar(20),newtariff varchar(20),finalreading numeric,chdate varchar(20),note varchar(200))

create table cd(conno varchar(20),cdid varchar(20),cdneeded numeric,cdavilable numeric,acd numeric, intrestoncd numeric)



create table cdadjustment(cdid varchar(20),cdadjustedforcc numeric, cdrefunded numeric)

create table advancepayment(conno varchar(20)primary key,areacode varchar(20),mtrcode varchar(20),period numeric, expectedcc numeric,expectedmr numeric, rebate numeric,total numeric)

create table sbcollection(conno varchar(20),areacode varchar(20),mrcode varchar(20),amtcollected numeric)

create table collection(conno varchar(20),demand numeric,amtcollected numeric,advance numeric,balance numeric )


create table acdcollection(conno varchar(20),acdcollected numeric)


create table depositdetails(conno varchar(20),deposit varchar(20),adldeposit varchar(20),oyceamt varchar(20),totinstalments varchar(10),endingmonthandyear varchar(20),cdrtno varchar(10),cddate varchar(20),acdrtno varchar(10),acddate varchar(20),instalmentamt varchar(10),paidinstalments varchar(5),balnceinstalments varchar(5))


drop table collection

drop table acdcollection

drop table depositdetails


drop table cdadjustment

drop table advancepayment

drop table sbcollection


select * from depositdetails

select * from mg