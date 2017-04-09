
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


select * from t_project;
select * from   t_paper for update; 
alter table t_paper modify(pastarttime datetime);

insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1001,'��ͨѧԺ','����Gabor�����ֽ�ĸ�˹��Ϸ����Թ��˲���',3,'NO122791','�Ƽ�ͨ��','2016/4/11','SCI',122701);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1002,'��ͨѧԺ','�����������ʵ�����ڰ�װ����е�Ӧ��',3,'NO122791','�й����ѧ','2011/4/11','EI',122701);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1003,'��ͨѧԺ','������������������ֲ㼼��������֮�о�',3,'NO122791','�������','2016/4/11','ISTP',122701);    
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1004,'��ͨѧԺ','���ڼ���˼ά��ģ����Ӽ���ʵ��γ̽�ѧ�о�',3,'NO122791','�������','2016/4/11','SSCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1005,'��ͨѧԺ','C�����������Լ��������������ɵ�̽��',3,'NO122791','�й�������ҵ���','2015/4/11','CSCD',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1006,'��ͨѧԺ','����MRS-GARCHģ�͵��ҹ��ƽ�۸񲨶�',3,'NO122791','�ƾ������о�','2015/4/11','SCI',122702);       
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1007,'��ͨѧԺ','����Haltion���е��������Biproitģ�͹��Ƽ���Ӧ��',3,'NO122791','��ѧ��ʵ������ʶ','2015/4/11','EI',122703);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1008,'��ͨѧԺ','��Ƶ���ݻع�ģ�͵ķ�����������Ӧ��',3,'NO122791','�й�������ҵ���','2015/4/11','ISTP',122703);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1009,'��ͨѧԺ','����MRS-GARCHģ�͵��ҹ��ƽ�۸񲨶�',3,'NO122791','�ƾ������о�','2014/4/11','SSCI',122703);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1010,'��ͨѧԺ','������������������ֲ㼼��������֮�о�',3,'NO122791','�ִ������','2011/4/11','SSCI',122703);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1011,'��ͨѧԺ','�����Ƽ���Ľ�ѧ��Դ����ϵͳ�����о�',3,'NO122791','�ִ������','2014/4/11','CSCD',122704);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1012,'��ͨѧԺ','Cauchy���жิ��΢�ַ����Իع����Խ��ֵ����',3,'NO122791','�Ƽ�ͨ��','2014/4/11','SCI',122704);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1013,'��ͨѧԺ','ѧ������Ը�У�����������Ҫ��ǳ̸',3,'NO122791','�γ̽����о�','2013/4/11','EI',122704);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1014,'��ͨѧԺ','�����������ʵ�����ڰ�װ����е�Ӧ��',3,'NO122791','��Դ��������','2013/4/11','ISTP',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1015,'��ͨѧԺ','Study on the Performance and Routing Algorithm of Wireless Sensor Networks',3,'NO122791','Journal of Computational Information Systems','2012/4/11','SSCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1016,'��ͨѧԺ','�����Ƽ���Ľ�ѧ��Դ����ϵͳ�����о�',3,'NO122791','��Ȩ�����������о�','2012/4/11','CSCD',122705);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1017,'��ͨѧԺ','����SLBS�ƶ�����ƽ̨ģʽ�ķ���',3,'NO122791','�Ϻ���ѧԺѧ��','2012/4/11','SCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1018,'��ͨѧԺ','���зֶ������Ķ�Ӱ����۶��о�',3,'NO122791','�Ƽ�ͨ��','2011/4/11','EI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1019,'��ͨѧԺ','Simulation of Pedestrian Evacuation Based on the Propagation of Pedestrian Flow',3,'NO122791','CICTP 2015','2011/4/11','ISTP',122706);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1020,'��ͨѧԺ','Distrbuted finite-time consensus tracing control for second-order nonolinear multi-agent systems',3,'NO122791','CICTP 2015','2011/4/11','SSCI',122707);      

insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1021,'��ͨѧԺ','����Gabor�����ֽ�ĸ�˹��Ϸ����Թ��˲���',3,'NO122791','�Ƽ�ͨ��','2016/4/11','CSCD',122707);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1022,'��ͨѧԺ','������������������ֲ㼼��������֮�о�',3,'NO122791','�й����ѧ','2011/4/11','EI',122708);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1023,'��ͨѧԺ','���ڼ���˼ά��ģ����Ӽ���ʵ��γ̽�ѧ�о�',3,'NO122791','�������','2016/4/11','SCI',122708);    
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1024,'��ͨѧԺ','�����Ƽ���Ľ�ѧ��Դ����ϵͳ�����о�',3,'NO122791','�������','2016/4/11','ISTP',122708);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1025,'��ͨѧԺ','EUETS������̼�۸����������������',3,'NO122791','�й�������ҵ���','2015/4/11','SSCI',122709);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1026,'��ͨѧԺ','����MRS-GARCHģ�͵��ҹ��ƽ�۸񲨶�',3,'NO122791','�ƾ������о�','2015/4/11','SCI',122709);       
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1027,'��ͨѧԺ','����Haltion���е��������Biproitģ�͹��Ƽ���Ӧ��',3,'NO122791','��ѧ��ʵ������ʶ','2015/4/11','SCI',122710);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1028,'��ͨѧԺ','��Ƶ���ݻع�ģ�͵ķ�����������Ӧ��',3,'NO122791','�й�������ҵ���','2015/4/11','ISTP',122710);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1029,'��ͨѧԺ','����MRS-GARCHģ�͵��ҹ��ƽ�۸񲨶�',3,'NO122791','�ƾ������о�','2014/4/11','SCI',122710);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1030,'��ͨѧԺ','�����Ƽ���Ľ�ѧ��Դ����ϵͳ�����о�',3,'NO122791','�ִ������','2014/4/11','SCI',122701);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1031,'��ͨѧԺ','Cauchy���жิ��΢�ַ����Իع����Խ��ֵ����',3,'NO122791','�Ƽ�ͨ��','2014/4/11','SCI',122701);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1032,'��ͨѧԺ','ѧ������Ը�У�����������Ҫ��ǳ̸',3,'NO122791','�������','2013/4/11','ISTP',122703);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1033,'��ͨѧԺ','RS�����ڿ����ر���ݼ���е��о���չ',3,'NO122791','�������','2013/4/11','SCI',122703);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1034,'��ͨѧԺ','Study on the Performance and Routing Algorithm of Wireless Sensor Networks',3,'NO122791','Journal of Computational Information Systems','2012/4/11','SCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1035,'��ͨѧԺ','Ӧ���ͱ���ԺУ���繤��רҵ�γ�Ⱥ����̽��',3,'NO122791','��Ȩ�����������о�','2012/4/11','SCI',122705);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1036,'��ͨѧԺ','�����������ʵ�����ڰ�װ����е�Ӧ��',3,'NO122791','�Ϻ���ѧԺѧ��','2012/4/11','SCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1037,'��ͨѧԺ','���зֶ������Ķ�Ӱ����۶��о�',3,'NO122791','�Ƽ�ͨ��','2011/4/11','SCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1038,'��ͨѧԺ','Simulation of Pedestrian Evacuation Based on the Propagation of Pedestrian Flow',3,'NO122791','CICTP 2015','2011/4/11','SCI',122707);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1039,'��ͨѧԺ','Distrbuted finite-time consensus tracing control for second-order nonolinear multi-agent systems',3,'NO122791','CICTP 2015','2011/4/11','SCI',122707);      
     
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1040,'��ͨѧԺ','����Gabor�����ֽ�ĸ�˹��Ϸ����Թ��˲���',3,'NO122791','�Ƽ�ͨ��','2016/4/11','SCI',122709);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1041,'��ͨѧԺ','������������������ֲ㼼��������֮�о�',3,'NO122791','�й����ѧ','2011/4/11','EI',122709);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1042,'��ͨѧԺ','���ڼ���˼ά��ģ����Ӽ���ʵ��γ̽�ѧ�о�',3,'NO122791','��̨����','2016/4/11','SCI',122709);    
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1043,'��ͨѧԺ','����ģʽ��ũ����Ӫ��˼·��̽��',3,'NO122791','�й�ͳ��','2016/4/11','EI',122710);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1044,'��ͨѧԺ','̽��C++������������Ƶļ���˼��',3,'NO122791','�й�������ҵ���','2015/4/11','SSCI',122710);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1045,'��ͨѧԺ','Ӧ���ͱ���ԺУ���繤��רҵ�γ�Ⱥ����̽��',3,'NO122791','��Ȩ�����������о�','2014/4/11','SCI',122703);        
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1046,'��ͨѧԺ','����Haltion���е��������Biproitģ�͹��Ƽ���Ӧ��',3,'NO122791','��ѧ��ʵ������ʶ','2015/4/11','SCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1047,'��ͨѧԺ','��Ƶ���ݻع�ģ�͵ķ�����������Ӧ��',3,'NO122791','�й�������ҵ���','2011/4/11','SCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1048,'��ͨѧԺ','����MRS-GARCHģ�͵��ҹ��ƽ�۸񲨶�',3,'NO122791','�ƾ������о�','2014/4/11','SCI',122704);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1049,'��ͨѧԺ','����ģʽ��ũ����Ӫ��˼·��̽��',3,'NO122791','�ִ������','2014/4/11','SCI',122704);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1050,'��ͨѧԺ','Cauchy���жิ��΢�ַ����Իع����Խ��ֵ����',3,'NO122791','�Ƽ�ͨ��','2014/4/11','SCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1051,'��ͨѧԺ','ѧ������Ը�У�����������Ҫ��ǳ̸',3,'NO122791','�γ̽����о�','2011/4/11','SCI',122706);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1052,'��ͨѧԺ','RS�����ڿ����ر���ݼ���е��о���չ',3,'NO122791','��Դ��������','2011/4/11','SCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1053,'��ͨѧԺ','Study on the Performance and Routing Algorithm of Wireless Sensor Networks',3,'NO122791','Journal of Computational Information Systems','2012/4/11','SCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1054,'��ͨѧԺ','̽��C++������������Ƶļ���˼��',3,'NO122791','��Ȩ�����������о�','2012/4/11','SCI',122708);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1055,'��ͨѧԺ','����ģʽ��ũ����Ӫ��˼·��̽��',3,'NO122791','�Ϻ���ѧԺѧ��','2012/4/11','SCI',122708);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1056,'��ͨѧԺ','���зֶ������Ķ�Ӱ����۶��о�',3,'NO122791','�Ƽ�ͨ��','2011/4/11','SCI',1227001);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1057,'��ͨѧԺ','Simulation of Pedestrian Evacuation Based on the Propagation of Pedestrian Flow',3,'NO122791','CICTP 2015','2011/4/11','SCI',1227001);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1058,'��ͨѧԺ','Distrbuted finite-time consensus tracing control for second-order nonolinear multi-agent systems',3,'NO122791','CICTP 2015','2011/4/11','SCI',1227001);      
     
                      

              
       
       
--alter table t_paper add(filePath varchar2(20),mark varchar2(20));
--Alter Table t_paper modify(filepath varchar2(120));
--alter Table t_paper modify(mark varchar2(120));
select * from t_teacher_project;
select * from t_teacher_course for update;
select * from t_teacher_project;
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








