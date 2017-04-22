
20170401004
/*------------------------------------创建主键序列------------------------------------------------------*/
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

/*------------------------------------删除所有主键序列------------------------------------------------------*/
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
insert into t_teacher values(122701,'上海','140@163.com','李广','123','讲师'，'465438','男','13193494142');
insert into t_teacher values(122702,'上海','140@163.com','郭涛','123','讲师'，'465438','女','14193494142');
insert into t_teacher values(122703,'上海','140@163.com','曹英','123','讲师'，'465438','男','15193494142');
insert into t_teacher values(122704,'上海','140@163.com','王五','123','教授'，'465438','女','16193494142');
insert into t_teacher values(122705,'上海','140@163.com','彭仁杰','123','教授'，'465438','男','17193494142');
insert into t_teacher values(122706,'上海','140@163.com','陈海鸿','123','教授'，'465438','男','18193494142');
insert into t_teacher values(122707,'上海','140@163.com','李四','123','副教授'，'465438','男','18193494142');
insert into t_teacher values(122708,'上海','140@163.com','文丽','123','副教授'，'465438','女','18193494142');
insert into t_teacher values(122709,'上海','140@163.com','刘岐','123','副教授'，'465438','男','18193494142');
insert into t_teacher values(122710,'上海','140@163.com','张三','123','院长'，'465438','男','18193494142');

update t_paper set pahostunit='计通学院' where 1=1

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------科研项目--------------------------------------------------------
select * from t_project for update;
--预算金额
alter table t_project drop column pr_premoney ;
alter table t_project modify(prendtime date);
alter table t_project modify(prstarttime date);
alter table t_project add(prpremoney float);

drop table t_project cascade constraints

insert into t_project (prid,prdate,prmoney,prname,prsource,prstarttime,prstate,prpremoney,prendtime,prresultinfo,prusefulmoney,teid)
        values(1001,6,72,'中国企业走出去跨文化大数据平台建设','国家级',to_date('2012/4/11','yyyy/mm/dd'),'已完成',3.1,to_date('2013/4/11','yyyy/mm/dd'),'在**原有基础上，探索出了一套能够有效提升**的理论，技术，模式和方法',2.1,122701); 
insert into t_project (prid,prdate,prmoney,prname,prsource,prstarttime,prstate,prpremoney,prendtime,prresultinfo,prusefulmoney,teid)
        values(1002,3,92,'美国历史“非常”事件的小说再现与意识形态批判研究','国家级',to_date('2012/4/11','yyyy/mm/dd'),'已完成',3.1,to_date('2013/4/11','yyyy/mm/dd'),'在**原有基础上，探索出了一套能够有效提升**的理论，技术，模式和方法',2.1,122701); 
insert into t_project (prid,prdate,prmoney,prname,prsource,prstarttime,prstate,prpremoney,prendtime,prresultinfo,prusefulmoney,teid)
        values(1003,2,72,'监管权纵向配置与食品安全协同治理机制研究','国家级',to_date('2012/4/11','yyyy/mm/dd'),'已完成',3.1,to_date('2013/4/11','yyyy/mm/dd'),'在**原有基础上，探索出了一套能够有效提升**的理论，技术，模式和方法',2.1,122701); 

insert into t_project (prid,prdate,prmoney,prname,prsource,prstarttime,prstate,prpremoney,prendtime,prresultinfo,prusefulmoney,teid)
        values(1004,3,62,'丝绸之路人文外交背景下的中阿智库合作研究','国家级',to_date('2013/4/11','yyyy/mm/dd'),'已完成',3.1,to_date('2013/4/11','yyyy/mm/dd'),'在**原有基础上，探索出了一套能够有效提升**的理论，技术，模式和方法',2.1,122701); 
insert into t_project (prid,prdate,prmoney,prname,prsource,prstarttime,prstate,prpremoney,prendtime,prresultinfo,prusefulmoney,teid)
        values(1005,4,32,'网络社会国家认同形成机制及其危机预警与应对研究','国家级',to_date('2014/4/11','yyyy/mm/dd'),'已完成',3.1,to_date('2013/4/11','yyyy/mm/dd'),'在**原有基础上，探索出了一套能够有效提升**的理论，技术，模式和方法',2.1,122701); 
insert into t_project (prid,prdate,prmoney,prname,prsource,prstarttime,prstate,prpremoney,prendtime,prresultinfo,prusefulmoney,teid)
        values(1006,5,4.2,'G20宏观经济政策国际协调的功能与中国角色研究','国家级',to_date('2012/4/11','yyyy/mm/dd'),'已完成',3.1,to_date('2013/4/11','yyyy/mm/dd'),'在**原有基础上，探索出了一套能够有效提升**的理论，技术，模式和方法',2.1,122701); 






---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------科研项目 预算明细-------------------------

select * from t_PreMoneyItem for update;
drop table t_PreMoneyItem;


---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------科研项目 经费使用明细-------------------------

select * from t_MoneyItem for update;
drop table t_MoneyItem;
select sum(summoney) from t_moneyitem;

insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1001,'办公用品,水','项目整个过程中使用',23000,122701,to_date('2016-2-3','yyyy-MM-dd'),1001);
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1002,'水电费','办公地点水电费',3000,122701,to_date('2016-3-3','yyyy-MM-dd'),1001);
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1003,'租赁费','办公地点房租',9000,122701,to_date('2016-3-3','yyyy-MM-dd'),1001);
       
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1004,'资料,书报,检索','项目开发过程中资料费',2000,122701,to_date('2016-2-4','yyyy-MM-dd'),1001);
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1005,'材料费','项目开发过程中材料费',5000,122701,to_date('2016-5-3','yyyy-MM-dd'),1001);
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1006,'印刷费，版面','项目整个过程中使用',23000,122701,to_date('2016-2-5','yyyy-MM-dd'),1001);
       
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1007,'车费，过路费，油费','项目调研中使用',7000,122701,to_date('2016-2-6','yyyy-MM-dd'),1001);
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1008,'差旅费','项目调研中使用',9000,122701,to_date('2016-6-3','yyyy-MM-dd'),1001);
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1009,'设备费购置','项目开发过程中购买设备费用',50000,122701,to_date('2016-2-7','yyyy-MM-dd'),1001);       
       
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1010,'招待费','项目调研中使用',7000,122701,to_date('2016-2-6','yyyy-MM-dd'),1001);
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1011,'协助费','外聘专家使用',9000,122701,to_date('2016-6-3','yyyy-MM-dd'),1001);
insert into t_moneyitem(moid,itemname,mark,summoney,teid,time,prid)
       values(1012,'其他专用费','零散费用',5000,122701,to_date('2016-2-7','yyyy-MM-dd'),1001);   
       
---------------------------------------------------------------------------------------------------------------------------------------------start-----------------------------------教师。科研项目 ------中间表-------------
select * from t_teacher_project for update;

insert into t_teacher_project values(1001,1001,122701);
insert into t_teacher_project values(1001,1002,122701);
insert into t_teacher_project values(1001,1003,122701);
insert into t_teacher_project values(1001,1004,122701);
insert into t_teacher_project values(1001,1005,122701);
insert into t_teacher_project values(1001,1006,122701);


----------------------------------------------------------------------------------------------------------------------------------------------end----------------------------------教师。科研项目 ------中间表-------------





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



---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------论文表-------------------------
select * from   t_paper for update; 
alter table t_paper modify(pastarttime datetime);
select * from t_paper where substr(to_char(pastarttime,'yyyy-mm-dd'),0,4)='2016';

insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1001,'计通学院','基于Gabor特征分解的高斯混合非线性过滤波器',3,'NO122791','科技通报',to_date('2016/4/11','yyyy-mm-dd'),'SCI',122701);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1002,'计通学院','计算机虚拟现实技术在包装设计中的应用',3,'NO122791','中国软科学',to_date('2011/4/11','yyyy-mm-dd'),'EI',122701);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1003,'计通学院','计算机软件开发语言与分层技术的运用之研究',3,'NO122791','软件导刊',to_date('2016/4/11','yyyy-mm-dd'),'ISTP',122701);    
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1004,'计通学院','基于计算思维的模拟电子技术实验课程教学研究',3,'NO122791','软件导刊',to_date('2010/4/11','yyyy-mm-dd'),'SSCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1005,'计通学院','C语言自增（自减）运算符运算规律的探讨',3,'NO122791','中国乡镇企业会计',to_date('2015/4/11','yyyy-mm-dd'),'CSCD',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1006,'计通学院','基于MRS-GARCH模型的我国黄金价格波动',3,'NO122791','财经理论研究',to_date('2015/4/11','yyyy-mm-dd'),'SCI',122702);       
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1007,'计通学院','基于Haltion序列的面板数据Biproit模型估计及其应用',3,'NO122791','数学的实践与认识',to_date('2015/4/11','yyyy-mm-dd'),'EI',122703);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1008,'计通学院','混频数据回归模型的分析技术及其应用',3,'NO122791','中国乡镇企业会计',to_date('2015/4/11','yyyy-mm-dd'),'ISTP',122703);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1009,'计通学院','基于MRS-GARCH模型的我国黄金价格波动',3,'NO122791','财经理论研究',to_date('2014/4/11','yyyy-mm-dd'),'SSCI',122703);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1010,'计通学院','计算机软件开发语言与分层技术的运用之研究',3,'NO122791','现代计算机',to_date('2011/4/11','yyyy-mm-dd'),'SSCI',122703);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1011,'计通学院','基于云计算的教学资源共享系统建设研究',3,'NO122791','现代计算机',to_date('2014/4/11','yyyy-mm-dd'),'CSCD',122704);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1012,'计通学院','Cauchy核中多复变微分方程自回归线性解初值问题',3,'NO122791','科技通报',to_date('2014/4/11','yyyy-mm-dd'),'SCI',122704);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1013,'计通学院','学籍管理对高校档案管理的重要性浅谈',3,'NO122791','课程教育研究',to_date('2013/4/11','yyyy-mm-dd'),'EI',122704);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1014,'计通学院','计算机虚拟现实技术在包装设计中的应用',3,'NO122791','能源环境保护',to_date('2013/4/11','yyyy-mm-dd'),'ISTP',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1015,'计通学院','Study on the Performance and Routing Algorithm of Wireless Sensor Networks',3,'NO122791','Journal of Computational Information Systems','2012/4/11','SSCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1016,'计通学院','基于云计算的教学资源共享系统建设研究',3,'NO122791','物权法疑难问题研究','2012/4/11','CSCD',122705);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1017,'计通学院','基于SLBS移动商务平台模式的分析',3,'NO122791','上海商学院学报','2012/4/11','SCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1018,'计通学院','词切分对蒙语阅读影响的眼动研究',3,'NO122791','科技通报',to_date('2011/4/11','yyyy-mm-dd'),'EI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1019,'计通学院','Simulation of Pedestrian Evacuation Based on the Propagation of Pedestrian Flow',3,'NO122791','CICTP 2015',to_date('2011/4/11','yyyy-mm-dd'),'ISTP',122706);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1020,'计通学院','Distrbuted finite-time consensus tracing control for second-order nonolinear multi-agent systems',3,'NO122791','CICTP 2015',to_date('2011/4/11','yyyy-mm-dd'),'SSCI',122707);      

insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1021,'计通学院','基于Gabor特征分解的高斯混合非线性过滤波器',3,'NO122791','科技通报',to_date('2016/4/11','yyyy-mm-dd'),'CSCD',122707);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1022,'计通学院','计算机软件开发语言与分层技术的运用之研究',3,'NO122791','中国软科学',to_date('2011/4/11','yyyy-mm-dd'),'EI',122708);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1023,'计通学院','基于计算思维的模拟电子技术实验课程教学研究',3,'NO122791','软件导刊',to_date('2016/4/11','yyyy-mm-dd'),'SCI',122708);    
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1024,'计通学院','基于云计算的教学资源共享系统建设研究',3,'NO122791','软件导刊',to_date('2016/4/11','yyyy-mm-dd'),'ISTP',122708);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1025,'计通学院','EUETS二氧化碳价格决定因素文献综述',3,'NO122791','中国乡镇企业会计',to_date('2015/4/11','yyyy-mm-dd'),'SSCI',122709);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1026,'计通学院','基于MRS-GARCH模型的我国黄金价格波动',3,'NO122791','财经理论研究',to_date('2015/4/11','yyyy-mm-dd'),'SCI',122709);       
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1027,'计通学院','基于Haltion序列的面板数据Biproit模型估计及其应用',3,'NO122791','数学的实践与认识',to_date('2015/4/11','yyyy-mm-dd'),'SCI',122710);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1028,'计通学院','混频数据回归模型的分析技术及其应用',3,'NO122791','中国乡镇企业会计',to_date('2015/4/11','yyyy-mm-dd'),'ISTP',122710);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1029,'计通学院','基于MRS-GARCH模型的我国黄金价格波动',3,'NO122791','财经理论研究',to_date('2014/4/11','yyyy-mm-dd'),'SCI',122710);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1030,'计通学院','基于云计算的教学资源共享系统建设研究',3,'NO122791','现代计算机',to_date('2014/4/11','yyyy-mm-dd'),'SCI',122701);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1031,'计通学院','Cauchy核中多复变微分方程自回归线性解初值问题',3,'NO122791','科技通报',to_date('2014/4/11','yyyy-mm-dd'),'SCI',122701);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1032,'计通学院','学籍管理对高校档案管理的重要性浅谈',3,'NO122791','软件导刊',to_date('2013/4/11','yyyy-mm-dd'),'ISTP',122703);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1033,'计通学院','RS技术在矿区地表沉陷监测中的研究进展',3,'NO122791','软件导刊',to_date('2013/4/11','yyyy-mm-dd'),'SCI',122703);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1034,'计通学院','Study on the Performance and Routing Algorithm of Wireless Sensor Networks',3,'NO122791','Journal of Computational Information Systems','2012/4/11','SCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1035,'计通学院','应用型本科院校网络工程专业课程群建设探索',3,'NO122791','物权法疑难问题研究','2012/4/11','SCI',122705);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1036,'计通学院','计算机虚拟现实技术在包装设计中的应用',3,'NO122791','上海商学院学报','2012/4/11','SCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1037,'计通学院','词切分对蒙语阅读影响的眼动研究',3,'NO122791','科技通报',to_date('2011/4/11','yyyy-mm-dd'),'SCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1038,'计通学院','Simulation of Pedestrian Evacuation Based on the Propagation of Pedestrian Flow',3,'NO122791','CICTP 2015',to_date('2011/4/11','yyyy-mm-dd'),'SCI',122707);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1039,'计通学院','Distrbuted finite-time consensus tracing control for second-order nonolinear multi-agent systems',3,'NO122791','CICTP 2015',to_date('2011/4/11','yyyy-mm-dd'),'SCI',122707);      
     
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1040,'计通学院','基于Gabor特征分解的高斯混合非线性过滤波器',3,'NO122791','科技通报',to_date('2016/4/11','yyyy-mm-dd'),'SCI',122709);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1041,'计通学院','计算机软件开发语言与分层技术的运用之研究',3,'NO122791','中国软科学',to_date('2011/4/11','yyyy-mm-dd'),'EI',122709);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1042,'计通学院','基于计算思维的模拟电子技术实验课程教学研究',3,'NO122791','兰台世界',to_date('2016/4/11','yyyy-mm-dd'),'SCI',122709);    
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1043,'计通学院','网络模式下农家乐营销思路的探索',3,'NO122791','中国统计',to_date('2016/4/11','yyyy-mm-dd'),'EI',122710);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1044,'计通学院','探究C++面向对象程序设计的几点思考',3,'NO122791','中国乡镇企业会计',to_date('2015/4/11','yyyy-mm-dd'),'SSCI',122710);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1045,'计通学院','应用型本科院校网络工程专业课程群建设探索',3,'NO122791','物权法疑难问题研究',to_date('2014/4/11','yyyy-mm-dd'),'SCI',122703);        
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1046,'计通学院','基于Haltion序列的面板数据Biproit模型估计及其应用',3,'NO122791','数学的实践与认识',to_date('2015/4/11','yyyy-mm-dd'),'SCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1047,'计通学院','混频数据回归模型的分析技术及其应用',3,'NO122791','中国乡镇企业会计',to_date('2011/4/11','yyyy-mm-dd'),'SCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1048,'计通学院','基于MRS-GARCH模型的我国黄金价格波动',3,'NO122791','财经理论研究',to_date('2014/4/11','yyyy-mm-dd'),'SCI',122704);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1049,'计通学院','网络模式下农家乐营销思路的探索',3,'NO122791','现代计算机',to_date('2014/4/11','yyyy-mm-dd'),'SCI',122704);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1050,'计通学院','Cauchy核中多复变微分方程自回归线性解初值问题',3,'NO122791','科技通报',to_date('2014/4/11','yyyy-mm-dd'),'SCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1051,'计通学院','学籍管理对高校档案管理的重要性浅谈',3,'NO122791','课程教育研究',to_date('2011/4/11','yyyy-mm-dd'),'SCI',122706);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1052,'计通学院','RS技术在矿区地表沉陷监测中的研究进展',3,'NO122791','能源环境保护',to_date('2011/4/11','yyyy-mm-dd'),'SCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1053,'计通学院','Study on the Performance and Routing Algorithm of Wireless Sensor Networks',3,'NO122791','Journal of Computational Information Systems','2012/4/11','SCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1054,'计通学院','探究C++面向对象程序设计的几点思考',3,'NO122791','物权法疑难问题研究','2012/4/11','SCI',122708);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1055,'计通学院','网络模式下农家乐营销思路的探索',3,'NO122791','上海商学院学报','2012/4/11','SCI',122708);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1056,'计通学院','词切分对蒙语阅读影响的眼动研究',3,'NO122791','科技通报',to_date('2011/4/11','yyyy-mm-dd'),'SCI',122701);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1057,'计通学院','Simulation of Pedestrian Evacuation Based on the Propagation of Pedestrian Flow',3,'NO122791','CICTP 2015',to_date('2011/4/11','yyyy-mm-dd'),'SCI',122701);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1058,'计通学院','Distrbuted finite-time consensus tracing control for second-order nonolinear multi-agent systems',3,'NO122791','CICTP 2015',to_date('2011/4/11','yyyy-mm-dd'),'SCI',122701);      
     
                      
  
       
       
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1059,'计通学院','基于Gabor特征分解的高斯混合非线性过滤波器',3,'NO122791','科技通报',convert(pastarttime,to_date('2005/4/11','yyyy-mm-dd'),121),'SCI',122702)
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1060,'计通学院','计算机虚拟现实技术在包装设计中的应用',3,'NO122791','中国软科学',to_date('2009/4/11','yyyy-mm-dd'),'EI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1061,'计通学院','计算机软件开发语言与分层技术的运用之研究',3,'NO122791','软件导刊',to_date('2010/4/11','yyyy-mm-dd'),'ISTP',122702);    
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1062,'计通学院','基于计算思维的模拟电子技术实验课程教学研究',3,'NO122791','软件导刊',to_date('2010/4/11','yyyy-mm-dd'),'SSCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1063,'计通学院','C语言自增（自减）运算符运算规律的探讨',3,'NO122791','中国乡镇企业会计',to_date('2006/4/11','yyyy-mm-dd'),'CSCD',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1064,'计通学院','基于MRS-GARCH模型的我国黄金价格波动',3,'NO122791','财经理论研究',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122702);       
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1065,'计通学院','基于Haltion序列的面板数据Biproit模型估计及其应用',3,'NO122791','数学的实践与认识',to_date('2006/4/11','yyyy-mm-dd'),'EI',122704);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1066,'计通学院','混频数据回归模型的分析技术及其应用',3,'NO122791','中国乡镇企业会计',to_date('2006/4/11','yyyy-mm-dd'),'ISTP',122704);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1067,'计通学院','基于MRS-GARCH模型的我国黄金价格波动',3,'NO122791','财经理论研究',to_date('2006/4/11','yyyy-mm-dd'),'SSCI',122704);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1068,'计通学院','计算机软件开发语言与分层技术的运用之研究',3,'NO122791','现代计算机',to_date('2009/4/11','yyyy-mm-dd'),'SSCI',122704);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1069,'计通学院','基于云计算的教学资源共享系统建设研究',3,'NO122791','现代计算机',to_date('2006/4/11','yyyy-mm-dd'),'CSCD',122703);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1070,'计通学院','Cauchy核中多复变微分方程自回归线性解初值问题',3,'NO122791','科技通报',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122703);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1071,'计通学院','学籍管理对高校档案管理的重要性浅谈',3,'NO122791','课程教育研究',to_date('2007/4/11','yyyy-mm-dd'),'EI',122703);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1072,'计通学院','计算机虚拟现实技术在包装设计中的应用',3,'NO122791','能源环境保护',to_date('2007/4/11','yyyy-mm-dd'),'ISTP',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1073,'计通学院','Study on the Performance and Routing Algorithm of Wireless Sensor Networks',3,'NO122791','Journal of Computational Information Systems',to_date('2008/4/11','yyyy-mm-dd'),'SSCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1074,'计通学院','基于云计算的教学资源共享系统建设研究',3,'NO122791','物权法疑难问题研究',to_date('2008/4/11','yyyy-mm-dd'),'CSCD',122706);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1075,'计通学院','基于SLBS移动商务平台模式的分析',3,'NO122791','上海商学院学报',to_date('2008/4/11','yyyy-mm-dd'),'SCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1076,'计通学院','词切分对蒙语阅读影响的眼动研究',3,'NO122791','科技通报',to_date('2009/4/11','yyyy-mm-dd'),'EI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1077,'计通学院','Simulation of Pedestrian Evacuation Based on the Propagation of Pedestrian Flow',3,'NO122791','CICTP 2006',to_date('2009/4/11','yyyy-mm-dd'),'ISTP',122705);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1078,'计通学院','Distrbuted finite-time consensus tracing control for second-order nonolinear multi-agent systems',3,'NO122791','CICTP 2006',to_date('2009/4/11','yyyy-mm-dd'),'SSCI',122708);      

insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1079,'计通学院','基于Gabor特征分解的高斯混合非线性过滤波器',3,'NO122791','科技通报',to_date('2005/4/11','yyyy-mm-dd'),'CSCD',122708);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1080,'计通学院','计算机软件开发语言与分层技术的运用之研究',3,'NO122791','中国软科学',to_date('2009/4/11','yyyy-mm-dd'),'EI',122707);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1081,'计通学院','基于计算思维的模拟电子技术实验课程教学研究',3,'NO122791','软件导刊',to_date('2010/4/11','yyyy-mm-dd'),'SCI',122707);    
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1082,'计通学院','基于云计算的教学资源共享系统建设研究',3,'NO122791','软件导刊',to_date('2005/4/11','yyyy-mm-dd'),'ISTP',122707);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1083,'计通学院','EUETS二氧化碳价格决定因素文献综述',3,'NO122791','中国乡镇企业会计',to_date('2006/4/11','yyyy-mm-dd'),'SSCI',122710);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1084,'计通学院','基于MRS-GARCH模型的我国黄金价格波动',3,'NO122791','财经理论研究',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122710);       
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1085,'计通学院','基于Haltion序列的面板数据Biproit模型估计及其应用',3,'NO122791','数学的实践与认识',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122709);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1086,'计通学院','混频数据回归模型的分析技术及其应用',3,'NO122791','中国乡镇企业会计',to_date('2006/4/11','yyyy-mm-dd'),'ISTP',122709);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1087,'计通学院','基于MRS-GARCH模型的我国黄金价格波动',3,'NO122791','财经理论研究',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122709);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1088,'计通学院','基于云计算的教学资源共享系统建设研究',3,'NO122791','现代计算机',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1089,'计通学院','Cauchy核中多复变微分方程自回归线性解初值问题',3,'NO122791','科技通报',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1090,'计通学院','学籍管理对高校档案管理的重要性浅谈',3,'NO122791','软件导刊',to_date('2007/4/11','yyyy-mm-dd'),'ISTP',122704);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1091,'计通学院','RS技术在矿区地表沉陷监测中的研究进展',3,'NO122791','软件导刊',to_date('2007/4/11','yyyy-mm-dd'),'SCI',122704);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1092,'计通学院','Study on the Performance and Routing Algorithm of Wireless Sensor Networks',3,'NO122791','Journal of Computational Information Systems',to_date('2008/4/11','yyyy-mm-dd'),'SCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1093,'计通学院','应用型本科院校网络工程专业课程群建设探索',3,'NO122791','物权法疑难问题研究',to_date('2008/4/11','yyyy-mm-dd'),'SCI',122706);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1094,'计通学院','计算机虚拟现实技术在包装设计中的应用',3,'NO122791','上海商学院学报',to_date('2008/4/11','yyyy-mm-dd'),'SCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1095,'计通学院','词切分对蒙语阅读影响的眼动研究',3,'NO122791','科技通报',to_date('2009/4/11','yyyy-mm-dd'),'SCI',122706);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1096,'计通学院','Simulation of Pedestrian Evacuation Based on the Propagation of Pedestrian Flow',3,'NO122791','CICTP 2006',to_date('2009/4/11','yyyy-mm-dd'),'SCI',122708);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1097,'计通学院','Distrbuted finite-time consensus tracing control for second-order nonolinear multi-agent systems',3,'NO122791','CICTP 2006',to_date('2009/4/11','yyyy-mm-dd'),'SCI',122708);      
     
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1098,'计通学院','基于Gabor特征分解的高斯混合非线性过滤波器',3,'NO122791','科技通报',to_date('2010/4/11','yyyy-mm-dd'),'SCI',122710);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1099,'计通学院','计算机软件开发语言与分层技术的运用之研究',3,'NO122791','中国软科学',to_date('2009/4/11','yyyy-mm-dd'),'EI',122710);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1100,'计通学院','基于计算思维的模拟电子技术实验课程教学研究',3,'NO122791','兰台世界',to_date('2010/4/11','yyyy-mm-dd'),'SCI',122710);    
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1101,'计通学院','网络模式下农家乐营销思路的探索',3,'NO122791','中国统计',to_date('2010/4/11','yyyy-mm-dd'),'EI',122709);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1102,'计通学院','探究C++面向对象程序设计的几点思考',3,'NO122791','中国乡镇企业会计',to_date('2006/4/11','yyyy-mm-dd'),'SSCI',122709);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1103,'计通学院','应用型本科院校网络工程专业课程群建设探索',3,'NO122791','物权法疑难问题研究',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122704);        
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1104,'计通学院','基于Haltion序列的面板数据Biproit模型估计及其应用',3,'NO122791','数学的实践与认识',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1105,'计通学院','混频数据回归模型的分析技术及其应用',3,'NO122791','中国乡镇企业会计',to_date('2009/4/11','yyyy-mm-dd'),'SCI',122702);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1106,'计通学院','基于MRS-GARCH模型的我国黄金价格波动',3,'NO122791','财经理论研究',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122703);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1107,'计通学院','网络模式下农家乐营销思路的探索',3,'NO122791','现代计算机',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122703);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1108,'计通学院','Cauchy核中多复变微分方程自回归线性解初值问题',3,'NO122791','科技通报',to_date('2006/4/11','yyyy-mm-dd'),'SCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1109,'计通学院','学籍管理对高校档案管理的重要性浅谈',3,'NO122791','课程教育研究',to_date('2009/4/11','yyyy-mm-dd'),'SCI',122705);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1110,'计通学院','RS技术在矿区地表沉陷监测中的研究进展',3,'NO122791','能源环境保护',to_date('2009/4/11','yyyy-mm-dd'),'SCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1111,'计通学院','Study on the Performance and Routing Algorithm of Wireless Sensor Networks',3,'NO122791','Journal of Computational Information Systems',to_date('2008/4/11','yyyy-mm-dd'),'SCI',122705);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1112,'计通学院','探究C++面向对象程序设计的几点思考',3,'NO122791','物权法疑难问题研究',to_date('2008/4/11','yyyy-mm-dd'),'SCI',122707);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1113,'计通学院','网络模式下农家乐营销思路的探索',3,'NO122791','上海商学院学报',to_date('2008/4/11','yyyy-mm-dd'),'SCI',122707);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1114,'计通学院','词切分对蒙语阅读影响的眼动研究',3,'NO122791','科技通报',to_date('2009/4/11','yyyy-mm-dd'),'SCI',122701);
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1115,'计通学院','Simulation of Pedestrian Evacuation Based on the Propagation of Pedestrian Flow',3,'NO122791','CICTP 2006',to_date('2009/4/11','yyyy-mm-dd'),'SCI',122701);      
insert into t_paper(paId,pahostunit,paname,papagenum,papublicationno,papublicationname,pastarttime,pastate,teid)
       values(1116,'计通学院','Distrbuted finite-time consensus tracing control for second-order nonolinear multi-agent systems',3,'NO122791','CICTP 2006',to_date('2009/4/11','yyyy-mm-dd'),'SCI',122701);      
     
                      





              
       
       
--alter table t_paper add(filePath varchar2(20),mark varchar2(20));
--Alter Table t_paper modify(filepath varchar2(120));
--alter Table t_paper modify(mark varchar2(120));


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------





