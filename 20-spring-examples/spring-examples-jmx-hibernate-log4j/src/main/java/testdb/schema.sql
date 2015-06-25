drop table LETTRE if exists;
drop sequence LETTRE_SEQ if exists;

create table LETTRE (ID integer identity primary key, ADRESSE1 varchar(50), ADRESSE2 varchar(50), ADRESSE3 varchar(50), CODE_POSTAL varchar(10), VILLE varchar(50));

create sequence LETTRE_SEQ start with 1;
