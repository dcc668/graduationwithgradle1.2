
20170401004
/*------------------------------------������������------------------------------------------------------*/
create sequence SEQ_COURSE
start with 1
increment by 1 
minvalue 1 
nomaxvalue ;

create sequence SEQ_MAJOR
start with 1
increment by 1 
minvalue 1 
nomaxvalue ;

create sequence SEQ_PAPER
start with 1
increment by 1 
minvalue 1 
nomaxvalue ;

create sequence SEQ_PROJECT
start with 1
increment by 1 
minvalue 1 
nomaxvalue ;

create sequence SEQ_STUDENT
start with 1
increment by 1 
minvalue 1 
nomaxvalue ;

create sequence SEQ_STUDENTCOURSE
start with 1
increment by 1 
minvalue 1 
nomaxvalue ;

create sequence SEQ_TEACHER
start with 1
increment by 1 
minvalue 1 
nomaxvalue ;

create sequence SEQ_TEACHERCOURSE
start with 1
increment by 1 
minvalue 1 
nomaxvalue ;

create sequence SEQ_TEACHERPROJECT
start with 1
increment by 1 
minvalue 1 
nomaxvalue ;

create sequence SEQ_TEACHERSTUDENT
start with 1
increment by 1 
minvalue 1 
nomaxvalue ;

/*------------------------------------ɾ��������������------------------------------------------------------*/
select * from user_sequences;
select  'drop sequence  '||sequence_name||' ;' 
        from user_sequences where sequence_name in
             (select upper(sequence_name) from user_sequences);

drop sequence  SEQ_COURSE ;
drop sequence  SEQ_MAJOR ;
drop sequence  SEQ_PAPER ;
drop sequence  SEQ_PROJECT ;
drop sequence  SEQ_STUDENT ;
drop sequence  SEQ_STUDENTCOURSE ;
drop sequence  SEQ_TEACHER ;
drop sequence  SEQ_TEACHERCOURSE ;
drop sequence  SEQ_TEACHERPROJECT ;
drop sequence  SEQ_TEACHERSTUDENT ;



select * from t_major;
select * from t_course;
select * from t_student;
select * from t_stu_course;
select * from t_teacher for update;
insert into t_teacher values(122701,'�Ϻ�','140@163.com','���','123','��ʦ'��'465438','��','13193494142');
insert into t_teacher values(122702,'�Ϻ�','140@163.com','����','123','��ʦ'��'465438','Ů','14193494142');
insert into t_teacher values(122703,'�Ϻ�','140@163.com','��Ӣ','123','��ʦ'��'465438','��','15193494142');
insert into t_teacher values(122704,'�Ϻ�','140@163.com','����','123','����'��'465438','Ů','16193494142');
insert into t_teacher values(122705,'�Ϻ�','140@163.com','���ʽ�','123','����'��'465438','��','17193494142');
insert into t_teacher values(122706,'�Ϻ�','140@163.com','�º���','123','����'��'465438','��','18193494142');
insert into t_teacher values(122707,'�Ϻ�','140@163.com','����','123','������'��'465438','��','18193494142');
insert into t_teacher values(122708,'�Ϻ�','140@163.com','����','123','������'��'465438','Ů','18193494142');
insert into t_teacher values(122709,'�Ϻ�','140@163.com','���','123','������'��'465438','��','18193494142');
insert into t_teacher values(122710,'�Ϻ�','140@163.com','����','123','Ժ��'��'465438','��','18193494142');

update t_paper set pahostunit='��ͨѧԺ' where 1=1

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------������Ŀ--------------------------------------------------------
select * from t_project for update;
--Ԥ����
alter table t_project drop column pr_premoney ;
alter table t_project modify(prendtime date);
alter table t_project modify(prstarttime date);
alter table t_project add(prpremoney float);

drop table t_project cascade constraints

insert into t_project (prid,prdate,prmoney,prname,prsource,prstarttime,prstate,prpremoney,prendtime,prresultinfo,prusefulmoney,teid)
        values(1001,6,72,'�й���ҵ�߳�ȥ���Ļ�������ƽ̨����','���Ҽ�',to_date('2012/4/11','yyyy/mm/dd'),'�����',3.1,to_date('2013/4/11','yyyy/mm/dd'),'��**ԭ�л����ϣ�̽������һ���ܹ���Ч����**�����ۣ�������ģʽ�ͷ���',2.1,122701); 
insert into t_project (prid,prdate,prmoney,prname,prsource,prstarttime,prstate,prpremoney,prendtime,prresultinfo,prusefulmoney,teid)
        values(1002,3,92,'������ʷ���ǳ����¼���С˵��������ʶ��̬�����о�','���Ҽ�',to_date('2012/4/11','yyyy/mm/dd'),'�����',3.1,to_date('2013/4/11','yyyy/mm/dd'),'��**ԭ�л����ϣ�̽������һ���ܹ���Ч����**�����ۣ�������ģʽ�ͷ���',2.1,122701); 
insert into t_project (prid,prdate,prmoney,prname,prsource,prstarttime,prstate,prpremoney,prendtime,prresultinfo,prusefulmoney,teid)
        values(1003,2,72,'���Ȩ����������ʳƷ��ȫЭͬ��������о�','���Ҽ�',to_date('2012/4/11','yyyy/mm/dd'),'�����',3.1,to_date('2013/4/11','yyyy/mm/dd'),'��**ԭ�л����ϣ�̽������һ���ܹ���Ч����**�����ۣ�������ģʽ�ͷ���',2.1,122701); 

insert into t_project (prid,prdate,prmoney,prname,prsource,prstarttime,prstate,prpremoney,prendtime,prresultinfo,prusefulmoney,teid)
        values(1004,3,62,'˿��֮·�����⽻�����µ��а��ǿ�����о�','���Ҽ�',to_date('2013/4/11','yyyy/mm/dd'),'�����',3.1,to_date('2013/4/11','yyyy/mm/dd'),'��**ԭ�л����ϣ�̽������һ���ܹ���Ч����**�����ۣ�������ģʽ�ͷ���',2.1,122701); 
insert into t_project (prid,prdate,prmoney,prname,prsource,prstarttime,prstate,prpremoney,prendtime,prresultinfo,prusefulmoney,teid)
        values(1005,4,32,'������������ͬ�γɻ��Ƽ���Σ��Ԥ����Ӧ���о�','���Ҽ�',to_date('2014/4/11','yyyy/mm/dd'),'�����',3.1,to_date('2013/4/11','yyyy/mm/dd'),'��**ԭ�л����ϣ�̽������һ���ܹ���Ч����**�����ۣ�������ģʽ�ͷ���',2.1,122701); 
insert into t_project (prid,prdate,prmoney,prname,prsource,prstarttime,prstate,prpremoney,prendtime,prresultinfo,prusefulmoney,teid)
        values(1006,5,4.2,'G20��۾������߹���Э���Ĺ������й���ɫ�о�','���Ҽ�',to_date('2012/4/11','yyyy/mm/dd'),'�����',3.1,to_date('2013/4/11','yyyy/mm/dd'),'��**ԭ�л����ϣ�̽������һ���ܹ���Ч����**�����ۣ�������ģʽ�ͷ���',2.1,122701); 






---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------������Ŀ Ԥ����ϸ-------------------------

select * from t_PreMoneyItem for update;
drop table t_PreMoneyItem;


---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------������Ŀ ����ʹ����ϸ-------------------------

select * from t_MoneyItem for update;
drop table t_MoneyItem;
select sum(summoney) from t_moneyitem;

insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1001,'�칫��Ʒ,ˮ','��Ŀ����������ʹ��',23000,122701,to_date('2016-2-3','yyyy-MM-dd'),1001);
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1002,'ˮ���','�칫�ص�ˮ���',3000,122701,to_date('2016-3-3','yyyy-MM-dd'),1001);
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1003,'���޷�','�칫�ص㷿��',9000,122701,to_date('2016-3-3','yyyy-MM-dd'),1001);
       
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1004,'����,�鱨,����','��Ŀ�������������Ϸ�',2000,122701,to_date('2016-2-4','yyyy-MM-dd'),1001);
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1005,'���Ϸ�','��Ŀ���������в��Ϸ�',5000,122701,to_date('2016-5-3','yyyy-MM-dd'),1001);
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1006,'ӡˢ�ѣ�����','��Ŀ����������ʹ��',23000,122701,to_date('2016-2-5','yyyy-MM-dd'),1001);
       
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1007,'���ѣ���·�ѣ��ͷ�','��Ŀ������ʹ��',7000,122701,to_date('2016-2-6','yyyy-MM-dd'),1001);
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1008,'���÷�','��Ŀ������ʹ��',9000,122701,to_date('2016-6-3','yyyy-MM-dd'),1001);
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1009,'�豸�ѹ���','��Ŀ���������й����豸����',50000,122701,to_date('2016-2-7','yyyy-MM-dd'),1001);       
       
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1010,'�д���','��Ŀ������ʹ��',7000,122701,to_date('2016-2-6','yyyy-MM-dd'),1001);
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1011,'Э����','��Ƹר��ʹ��',9000,122701,to_date('2016-6-3','yyyy-MM-dd'),1001);
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1012,'����ר�÷�','��ɢ����',5000,122701,to_date('2016-2-7','yyyy-MM-dd'),1001);   
       
---------------------------------------------------------------------------------------------------------------------------------------------start-----------------------------------��ʦ��������Ŀ ------�м��-------------
select * from t_teacher_project for update;

insert into t_teacher_project values(1001,1001,122701);
insert into t_teacher_project values(1001,1002,122701);
insert into t_teacher_project values(1001,1003,122701);
insert into t_teacher_project values(1001,1004,122701);
insert into t_teacher_project values(1001,1005,122701);
insert into t_teacher_project values(1001,1006,122701);


----------------------------------------------------------------------------------------------------------------------------------------------end----------------------------------��ʦ��������Ŀ ------�м��-------------





select * from t_teacher_course for update;
select * from t_teacher_project for update;
select * from t_teacher_student;


select  'drop table  '||table_name||' cascade constraints;' 
        from user_tables where table_name in
             (select upper(table_name) from user_tables);

drop table  T_COURSE cascade constraints;
drop table  T_MAJOR cascade constraints;
drop table  T_PAPER cascade constraints;
drop table  T_PROJECT cascade constraints;
drop table  T_STUDENT cascade constraints;
drop table  T_TEACHER cascade constraints;
drop table  T_TEACHER_COURSE cascade constraints;
drop table  T_TEACHER_PROJECT cascade constraints;
drop table  T_TEACHER_STUDENT cascade constraints;
drop table  T_STU_COURSE cascade constraints;



---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------���ı�-------------------------
select * from   t_paper for update; 
alter table t_paper modify(pastarttime datetime);
select * from t_paper where substr(to_char(pastarttime,'yyyy-mm-dd'),0,4)='2016';

insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1001,'��ͨѧԺ','����Gabor�����ֽ�ĸ�˹��Ϸ����Թ��˲���',3,'NO122791','�Ƽ�ͨ��',to_date('2016/4/11','yyyy-mm-dd'),'SCI',122701);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1002,'��ͨѧԺ','�����������ʵ�����ڰ�װ����е�Ӧ��',3,'NO122791','�й����ѧ',to_date('2011/4/11','yyyy-mm-dd'),'EI',122701);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1003,'��ͨѧԺ','������������������ֲ㼼��������֮�о�',3,'NO122791','�������',to_date('2016/4/11','yyyy-mm-dd'),'ISTP',122701);    
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1004,'��ͨѧԺ','���ڼ���˼ά��ģ����Ӽ���ʵ��γ̽�ѧ�о�',3,'NO122791','�������',to_date('2010/4/11','yyyy-mm-dd'),'SSCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1005,'��ͨѧԺ','C�����������Լ��������������ɵ�̽��',3,'NO122791','�й�������ҵ���',to_date('2015/4/11','yyyy-mm-dd'),'CSCD',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1006,'��ͨѧԺ','����MRS-GARCHģ�͵��ҹ��ƽ�۸񲨶�',3,'NO122791','�ƾ������о�',to_date('2015/4/11','yyyy-mm-dd'),'SCI',122702);       
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1007,'��ͨѧԺ','����Haltion���е��������Biproitģ�͹��Ƽ���Ӧ��',3,'NO122791','��ѧ��ʵ������ʶ',to_date('2015/4/11','yyyy-mm-dd'),'EI',122703);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1008,'��ͨѧԺ','��Ƶ���ݻع�ģ�͵ķ�����������Ӧ��',3,'NO122791','�й�������ҵ���',to_date('2015/4/11','yyyy-mm-dd'),'ISTP',122703);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1009,'��ͨѧԺ','����MRS-GARCHģ�͵��ҹ��ƽ�۸񲨶�',3,'NO122791','�ƾ������о�',to_date('2014/4/11','yyyy-mm-dd'),'SSCI',122703);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1010,'��ͨѧԺ','������������������ֲ㼼��������֮�о�',3,'NO122791','�ִ������',to_date('2011/4/11','yyyy-mm-dd'),'SSCI',122703);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1011,'��ͨѧԺ','�����Ƽ���Ľ�ѧ��Դ����ϵͳ�����о�',3,'NO122791','�ִ������',to_date('2014/4/11','yyyy-mm-dd'),'CSCD',122704);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1012,'��ͨѧԺ','Cauchy���жิ��΢�ַ����Իع����Խ��ֵ����',3,'NO122791','�Ƽ�ͨ��',to_date('2014/4/11','yyyy-mm-dd'),'SCI',122704);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1013,'��ͨѧԺ','ѧ������Ը�У�����������Ҫ��ǳ̸',3,'NO122791','�γ̽����о�',to_date('2013/4/11','yyyy-mm-dd'),'EI',122704);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1014,'��ͨѧԺ','�����������ʵ�����ڰ�װ����е�Ӧ��',3,'NO122791','��Դ��������',to_date('2013/4/11','yyyy-mm-dd'),'ISTP',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1015,'��ͨѧԺ','Study on the Performance and Routing Algorithm of Wireless Sensor Networks',3,'NO122791','Journal of Computational Information Systems','2012/4/11','SSCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1016,'��ͨѧԺ','�����Ƽ���Ľ�ѧ��Դ����ϵͳ�����о�',3,'NO122791','��Ȩ�����������о�','2012/4/11','CSCD',122705);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1017,'��ͨѧԺ','����SLBS�ƶ�����ƽ̨ģʽ�ķ���',3,'NO122791','�Ϻ���ѧԺѧ��','2012/4/11','SCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1018,'��ͨѧԺ','���зֶ������Ķ�Ӱ����۶��о�',3,'NO122791','�Ƽ�ͨ��',to_date('2011/4/11','yyyy-mm-dd'),'EI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1019,'��ͨѧԺ','Simulation of Pedestrian Evacuation Based on the Propagation of Pedestrian Flow',3,'NO122791','CICTP 2015',to_date('2011/4/11','yyyy-mm-dd'),'ISTP',122706);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1020,'��ͨѧԺ','Distrbuted finite-time consensus tracing control for second-order nonolinear multi-agent systems',3,'NO122791','CICTP 2015',to_date('2011/4/11','yyyy-mm-dd'),'SSCI',122707);      

insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1021,'��ͨѧԺ','����Gabor�����ֽ�ĸ�˹��Ϸ����Թ��˲���',3,'NO122791','�Ƽ�ͨ��',to_date('2016/4/11','yyyy-mm-dd'),'CSCD',122707);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1022,'��ͨѧԺ','������������������ֲ㼼��������֮�о�',3,'NO122791','�й����ѧ',to_date('2011/4/11','yyyy-mm-dd'),'EI',122708);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1023,'��ͨѧԺ','���ڼ���˼ά��ģ����Ӽ���ʵ��γ̽�ѧ�о�',3,'NO122791','�������',to_date('2016/4/11','yyyy-mm-dd'),'SCI',122708);    
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1024,'��ͨѧԺ','�����Ƽ���Ľ�ѧ��Դ����ϵͳ�����о�',3,'NO122791','�������',to_date('2016/4/11','yyyy-mm-dd'),'ISTP',122708);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1025,'��ͨѧԺ','EUETS������̼�۸����������������',3,'NO122791','�й�������ҵ���',to_date('2015/4/11','yyyy-mm-dd'),'SSCI',122709);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1026,'��ͨѧԺ','����MRS-GARCHģ�͵��ҹ��ƽ�۸񲨶�',3,'NO122791','�ƾ������о�',to_date('2015/4/11','yyyy-mm-dd'),'SCI',122709);       
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1027,'��ͨѧԺ','����Haltion���е��������Biproitģ�͹��Ƽ���Ӧ��',3,'NO122791','��ѧ��ʵ������ʶ',to_date('2015/4/11','yyyy-mm-dd'),'SCI',122710);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1028,'��ͨѧԺ','��Ƶ���ݻع�ģ�͵ķ�����������Ӧ��',3,'NO122791','�й�������ҵ���',to_date('2015/4/11','yyyy-mm-dd'),'ISTP',122710);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1029,'��ͨѧԺ','����MRS-GARCHģ�͵��ҹ��ƽ�۸񲨶�',3,'NO122791','�ƾ������о�',to_date('2014/4/11','yyyy-mm-dd'),'SCI',122710);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1030,'��ͨѧԺ','�����Ƽ���Ľ�ѧ��Դ����ϵͳ�����о�',3,'NO122791','�ִ������',to_date('2014/4/11','yyyy-mm-dd'),'SCI',122701);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1031,'��ͨѧԺ','Cauchy���жิ��΢�ַ����Իع����Խ��ֵ����',3,'NO122791','�Ƽ�ͨ��',to_date('2014/4/11','yyyy-mm-dd'),'SCI',122701);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1032,'��ͨѧԺ','ѧ������Ը�У�����������Ҫ��ǳ̸',3,'NO122791','�������',to_date('2013/4/11','yyyy-mm-dd'),'ISTP',122703);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1033,'��ͨѧԺ','RS�����ڿ����ر���ݼ���е��о���չ',3,'NO122791','�������',to_date('2013/4/11','yyyy-mm-dd'),'SCI',122703);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1034,'��ͨѧԺ','Study on the Performance and Routing Algorithm of Wireless Sensor Networks',3,'NO122791','Journal of Computational Information Systems','2012/4/11','SCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1035,'��ͨѧԺ','Ӧ���ͱ���ԺУ���繤��רҵ�γ�Ⱥ����̽��',3,'NO122791','��Ȩ�����������о�','2012/4/11','SCI',122705);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1036,'��ͨѧԺ','�����������ʵ�����ڰ�װ����е�Ӧ��',3,'NO122791','�Ϻ���ѧԺѧ��','2012/4/11','SCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1037,'��ͨѧԺ','���зֶ������Ķ�Ӱ����۶��о�',3,'NO122791','�Ƽ�ͨ��',to_date('2011/4/11','yyyy-mm-dd'),'SCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1038,'��ͨѧԺ','Simulation of Pedestrian Evacuation Based on the Propagation of Pedestrian Flow',3,'NO122791','CICTP 2015',to_date('2011/4/11','yyyy-mm-dd'),'SCI',122707);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1039,'��ͨѧԺ','Distrbuted finite-time consensus tracing control for second-order nonolinear multi-agent systems',3,'NO122791','CICTP 2015',to_date('2011/4/11','yyyy-mm-dd'),'SCI',122707);      
     
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1040,'��ͨѧԺ','����Gabor�����ֽ�ĸ�˹��Ϸ����Թ��˲���',3,'NO122791','�Ƽ�ͨ��',to_date('2016/4/11','yyyy-mm-dd'),'SCI',122709);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1041,'��ͨѧԺ','������������������ֲ㼼��������֮�о�',3,'NO122791','�й����ѧ',to_date('2011/4/11','yyyy-mm-dd'),'EI',122709);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1042,'��ͨѧԺ','���ڼ���˼ά��ģ����Ӽ���ʵ��γ̽�ѧ�о�',3,'NO122791','��̨����',to_date('2016/4/11','yyyy-mm-dd'),'SCI',122709);    
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1043,'��ͨѧԺ','����ģʽ��ũ����Ӫ��˼·��̽��',3,'NO122791','�й�ͳ��',to_date('2016/4/11','yyyy-mm-dd'),'EI',122710);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1044,'��ͨѧԺ','̽��C++������������Ƶļ���˼��',3,'NO122791','�й�������ҵ���',to_date('2015/4/11','yyyy-mm-dd'),'SSCI',122710);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1045,'��ͨѧԺ','Ӧ���ͱ���ԺУ���繤��רҵ�γ�Ⱥ����̽��',3,'NO122791','��Ȩ�����������о�',to_date('2014/4/11','yyyy-mm-dd'),'SCI',122703);        
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1046,'��ͨѧԺ','����Haltion���е��������Biproitģ�͹��Ƽ���Ӧ��',3,'NO122791','��ѧ��ʵ������ʶ',to_date('2015/4/11','yyyy-mm-dd'),'SCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1047,'��ͨѧԺ','��Ƶ���ݻع�ģ�͵ķ�����������Ӧ��',3,'NO122791','�й�������ҵ���',to_date('2011/4/11','yyyy-mm-dd'),'SCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1048,'��ͨѧԺ','����MRS-GARCHģ�͵��ҹ��ƽ�۸񲨶�',3,'NO122791','�ƾ������о�',to_date('2014/4/11','yyyy-mm-dd'),'SCI',122704);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1049,'��ͨѧԺ','����ģʽ��ũ����Ӫ��˼·��̽��',3,'NO122791','�ִ������',to_date('2014/4/11','yyyy-mm-dd'),'SCI',122704);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1050,'��ͨѧԺ','Cauchy���жิ��΢�ַ����Իع����Խ��ֵ����',3,'NO122791','�Ƽ�ͨ��',to_date('2014/4/11','yyyy-mm-dd'),'SCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1051,'��ͨѧԺ','ѧ������Ը�У�����������Ҫ��ǳ̸',3,'NO122791','�γ̽����о�',to_date('2011/4/11','yyyy-mm-dd'),'SCI',122706);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1052,'��ͨѧԺ','RS�����ڿ����ر���ݼ���е��о���չ',3,'NO122791','��Դ��������',to_date('2011/4/11','yyyy-mm-dd'),'SCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1053,'��ͨѧԺ','Study on the Performance and Routing Algorithm of Wireless Sensor Networks',3,'NO122791','Journal of Computational Information Systems','2012/4/11','SCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1054,'��ͨѧԺ','̽��C++������������Ƶļ���˼��',3,'NO122791','��Ȩ�����������о�','2012/4/11','SCI',122708);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1055,'��ͨѧԺ','����ģʽ��ũ����Ӫ��˼·��̽��',3,'NO122791','�Ϻ���ѧԺѧ��','2012/4/11','SCI',122708);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1056,'��ͨѧԺ','���зֶ������Ķ�Ӱ����۶��о�',3,'NO122791','�Ƽ�ͨ��',to_date('2011/4/11','yyyy-mm-dd'),'SCI',122701);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1057,'��ͨѧԺ','Simulation of Pedestrian Evacuation Based on the Propagation of Pedestrian Flow',3,'NO122791','CICTP 2015',to_date('2011/4/11','yyyy-mm-dd'),'SCI',122701);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1058,'��ͨѧԺ','Distrbuted finite-time consensus tracing control for second-order nonolinear multi-agent systems',3,'NO122791','CICTP 2015',to_date('2011/4/11','yyyy-mm-dd'),'SCI',122701);      
     
                      
  
       
       
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1059,'��ͨѧԺ','����Gabor�����ֽ�ĸ�˹��Ϸ����Թ��˲���',3,'NO122791','�Ƽ�ͨ��',convert(pastarttime,to_date('2005/4/11','yyyy-mm-dd'),121),'SCI',122702)
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1060,'��ͨѧԺ','�����������ʵ�����ڰ�װ����е�Ӧ��',3,'NO122791','�й����ѧ',to_date('2009/4/11','yyyy-mm-dd'),'EI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1061,'��ͨѧԺ','������������������ֲ㼼��������֮�о�',3,'NO122791','�������',to_date('2010/4/11','yyyy-mm-dd'),'ISTP',122702);    
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1062,'��ͨѧԺ','���ڼ���˼ά��ģ����Ӽ���ʵ��γ̽�ѧ�о�',3,'NO122791','�������',to_date('2010/4/11','yyyy-mm-dd'),'SSCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1063,'��ͨѧԺ','C�����������Լ��������������ɵ�̽��',3,'NO122791','�й�������ҵ���',to_date('2006/4/11','yyyy-mm-dd'),'CSCD',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1064,'��ͨѧԺ','����MRS-GARCHģ�͵��ҹ��ƽ�۸񲨶�',3,'NO122791','�ƾ������о�',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122702);       
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1065,'��ͨѧԺ','����Haltion���е��������Biproitģ�͹��Ƽ���Ӧ��',3,'NO122791','��ѧ��ʵ������ʶ',to_date('2006/4/11','yyyy-mm-dd'),'EI',122704);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1066,'��ͨѧԺ','��Ƶ���ݻع�ģ�͵ķ�����������Ӧ��',3,'NO122791','�й�������ҵ���',to_date('2006/4/11','yyyy-mm-dd'),'ISTP',122704);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1067,'��ͨѧԺ','����MRS-GARCHģ�͵��ҹ��ƽ�۸񲨶�',3,'NO122791','�ƾ������о�',to_date('2006/4/11','yyyy-mm-dd'),'SSCI',122704);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1068,'��ͨѧԺ','������������������ֲ㼼��������֮�о�',3,'NO122791','�ִ������',to_date('2009/4/11','yyyy-mm-dd'),'SSCI',122704);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1069,'��ͨѧԺ','�����Ƽ���Ľ�ѧ��Դ����ϵͳ�����о�',3,'NO122791','�ִ������',to_date('2006/4/11','yyyy-mm-dd'),'CSCD',122703);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1070,'��ͨѧԺ','Cauchy���жิ��΢�ַ����Իع����Խ��ֵ����',3,'NO122791','�Ƽ�ͨ��',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122703);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1071,'��ͨѧԺ','ѧ������Ը�У�����������Ҫ��ǳ̸',3,'NO122791','�γ̽����о�',to_date('2007/4/11','yyyy-mm-dd'),'EI',122703);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1072,'��ͨѧԺ','�����������ʵ�����ڰ�װ����е�Ӧ��',3,'NO122791','��Դ��������',to_date('2007/4/11','yyyy-mm-dd'),'ISTP',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1073,'��ͨѧԺ','Study on the Performance and Routing Algorithm of Wireless Sensor Networks',3,'NO122791','Journal of Computational Information Systems',to_date('2008/4/11','yyyy-mm-dd'),'SSCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1074,'��ͨѧԺ','�����Ƽ���Ľ�ѧ��Դ����ϵͳ�����о�',3,'NO122791','��Ȩ�����������о�',to_date('2008/4/11','yyyy-mm-dd'),'CSCD',122706);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1075,'��ͨѧԺ','����SLBS�ƶ�����ƽ̨ģʽ�ķ���',3,'NO122791','�Ϻ���ѧԺѧ��',to_date('2008/4/11','yyyy-mm-dd'),'SCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1076,'��ͨѧԺ','���зֶ������Ķ�Ӱ����۶��о�',3,'NO122791','�Ƽ�ͨ��',to_date('2009/4/11','yyyy-mm-dd'),'EI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1077,'��ͨѧԺ','Simulation of Pedestrian Evacuation Based on the Propagation of Pedestrian Flow',3,'NO122791','CICTP 2006',to_date('2009/4/11','yyyy-mm-dd'),'ISTP',122705);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1078,'��ͨѧԺ','Distrbuted finite-time consensus tracing control for second-order nonolinear multi-agent systems',3,'NO122791','CICTP 2006',to_date('2009/4/11','yyyy-mm-dd'),'SSCI',122708);      

insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1079,'��ͨѧԺ','����Gabor�����ֽ�ĸ�˹��Ϸ����Թ��˲���',3,'NO122791','�Ƽ�ͨ��',to_date('2005/4/11','yyyy-mm-dd'),'CSCD',122708);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1080,'��ͨѧԺ','������������������ֲ㼼��������֮�о�',3,'NO122791','�й����ѧ',to_date('2009/4/11','yyyy-mm-dd'),'EI',122707);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1081,'��ͨѧԺ','���ڼ���˼ά��ģ����Ӽ���ʵ��γ̽�ѧ�о�',3,'NO122791','�������',to_date('2010/4/11','yyyy-mm-dd'),'SCI',122707);    
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1082,'��ͨѧԺ','�����Ƽ���Ľ�ѧ��Դ����ϵͳ�����о�',3,'NO122791','�������',to_date('2005/4/11','yyyy-mm-dd'),'ISTP',122707);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1083,'��ͨѧԺ','EUETS������̼�۸����������������',3,'NO122791','�й�������ҵ���',to_date('2006/4/11','yyyy-mm-dd'),'SSCI',122710);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1084,'��ͨѧԺ','����MRS-GARCHģ�͵��ҹ��ƽ�۸񲨶�',3,'NO122791','�ƾ������о�',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122710);       
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1085,'��ͨѧԺ','����Haltion���е��������Biproitģ�͹��Ƽ���Ӧ��',3,'NO122791','��ѧ��ʵ������ʶ',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122709);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1086,'��ͨѧԺ','��Ƶ���ݻع�ģ�͵ķ�����������Ӧ��',3,'NO122791','�й�������ҵ���',to_date('2006/4/11','yyyy-mm-dd'),'ISTP',122709);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1087,'��ͨѧԺ','����MRS-GARCHģ�͵��ҹ��ƽ�۸񲨶�',3,'NO122791','�ƾ������о�',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122709);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1088,'��ͨѧԺ','�����Ƽ���Ľ�ѧ��Դ����ϵͳ�����о�',3,'NO122791','�ִ������',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1089,'��ͨѧԺ','Cauchy���жิ��΢�ַ����Իع����Խ��ֵ����',3,'NO122791','�Ƽ�ͨ��',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1090,'��ͨѧԺ','ѧ������Ը�У�����������Ҫ��ǳ̸',3,'NO122791','�������',to_date('2007/4/11','yyyy-mm-dd'),'ISTP',122704);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1091,'��ͨѧԺ','RS�����ڿ����ر���ݼ���е��о���չ',3,'NO122791','�������',to_date('2007/4/11','yyyy-mm-dd'),'SCI',122704);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1092,'��ͨѧԺ','Study on the Performance and Routing Algorithm of Wireless Sensor Networks',3,'NO122791','Journal of Computational Information Systems',to_date('2008/4/11','yyyy-mm-dd'),'SCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1093,'��ͨѧԺ','Ӧ���ͱ���ԺУ���繤��רҵ�γ�Ⱥ����̽��',3,'NO122791','��Ȩ�����������о�',to_date('2008/4/11','yyyy-mm-dd'),'SCI',122706);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1094,'��ͨѧԺ','�����������ʵ�����ڰ�װ����е�Ӧ��',3,'NO122791','�Ϻ���ѧԺѧ��',to_date('2008/4/11','yyyy-mm-dd'),'SCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1095,'��ͨѧԺ','���зֶ������Ķ�Ӱ����۶��о�',3,'NO122791','�Ƽ�ͨ��',to_date('2009/4/11','yyyy-mm-dd'),'SCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1096,'��ͨѧԺ','Simulation of Pedestrian Evacuation Based on the Propagation of Pedestrian Flow',3,'NO122791','CICTP 2006',to_date('2009/4/11','yyyy-mm-dd'),'SCI',122708);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1097,'��ͨѧԺ','Distrbuted finite-time consensus tracing control for second-order nonolinear multi-agent systems',3,'NO122791','CICTP 2006',to_date('2009/4/11','yyyy-mm-dd'),'SCI',122708);      
     
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1098,'��ͨѧԺ','����Gabor�����ֽ�ĸ�˹��Ϸ����Թ��˲���',3,'NO122791','�Ƽ�ͨ��',to_date('2010/4/11','yyyy-mm-dd'),'SCI',122710);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1099,'��ͨѧԺ','������������������ֲ㼼��������֮�о�',3,'NO122791','�й����ѧ',to_date('2009/4/11','yyyy-mm-dd'),'EI',122710);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1100,'��ͨѧԺ','���ڼ���˼ά��ģ����Ӽ���ʵ��γ̽�ѧ�о�',3,'NO122791','��̨����',to_date('2010/4/11','yyyy-mm-dd'),'SCI',122710);    
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1101,'��ͨѧԺ','����ģʽ��ũ����Ӫ��˼·��̽��',3,'NO122791','�й�ͳ��',to_date('2010/4/11','yyyy-mm-dd'),'EI',122709);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1102,'��ͨѧԺ','̽��C++������������Ƶļ���˼��',3,'NO122791','�й�������ҵ���',to_date('2006/4/11','yyyy-mm-dd'),'SSCI',122709);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1103,'��ͨѧԺ','Ӧ���ͱ���ԺУ���繤��רҵ�γ�Ⱥ����̽��',3,'NO122791','��Ȩ�����������о�',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122704);        
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1104,'��ͨѧԺ','����Haltion���е��������Biproitģ�͹��Ƽ���Ӧ��',3,'NO122791','��ѧ��ʵ������ʶ',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1105,'��ͨѧԺ','��Ƶ���ݻع�ģ�͵ķ�����������Ӧ��',3,'NO122791','�й�������ҵ���',to_date('2009/4/11','yyyy-mm-dd'),'SCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1106,'��ͨѧԺ','����MRS-GARCHģ�͵��ҹ��ƽ�۸񲨶�',3,'NO122791','�ƾ������о�',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122703);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1107,'��ͨѧԺ','����ģʽ��ũ����Ӫ��˼·��̽��',3,'NO122791','�ִ������',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122703);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1108,'��ͨѧԺ','Cauchy���жิ��΢�ַ����Իع����Խ��ֵ����',3,'NO122791','�Ƽ�ͨ��',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1109,'��ͨѧԺ','ѧ������Ը�У�����������Ҫ��ǳ̸',3,'NO122791','�γ̽����о�',to_date('2009/4/11','yyyy-mm-dd'),'SCI',122705);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1110,'��ͨѧԺ','RS�����ڿ����ر���ݼ���е��о���չ',3,'NO122791','��Դ��������',to_date('2009/4/11','yyyy-mm-dd'),'SCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1111,'��ͨѧԺ','Study on the Performance and Routing Algorithm of Wireless Sensor Networks',3,'NO122791','Journal of Computational Information Systems',to_date('2008/4/11','yyyy-mm-dd'),'SCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1112,'��ͨѧԺ','̽��C++������������Ƶļ���˼��',3,'NO122791','��Ȩ�����������о�',to_date('2008/4/11','yyyy-mm-dd'),'SCI',122707);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1113,'��ͨѧԺ','����ģʽ��ũ����Ӫ��˼·��̽��',3,'NO122791','�Ϻ���ѧԺѧ��',to_date('2008/4/11','yyyy-mm-dd'),'SCI',122707);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1114,'��ͨѧԺ','���зֶ������Ķ�Ӱ����۶��о�',3,'NO122791','�Ƽ�ͨ��',to_date('2009/4/11','yyyy-mm-dd'),'SCI',122701);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1115,'��ͨѧԺ','Simulation of Pedestrian Evacuation Based on the Propagation of Pedestrian Flow',3,'NO122791','CICTP 2006',to_date('2009/4/11','yyyy-mm-dd'),'SCI',122701);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1116,'��ͨѧԺ','Distrbuted finite-time consensus tracing control for second-order nonolinear multi-agent systems',3,'NO122791','CICTP 2006',to_date('2009/4/11','yyyy-mm-dd'),'SCI',122701);      
     
                      





              
       
       
--alter table t_paper add(filePath varchar2(20),mark varchar2(20));
--Alter Table t_paper modify(filepath varchar2(120));
--alter Table t_paper modify(mark varchar2(120));


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------





