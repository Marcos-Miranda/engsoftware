/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  marki
 * Created: 17/09/2017
 */


    
create table Aluno(
    RA int,
    Nome varchar(150) not null,
    Senha varchar(20) not null,
    constraint PkAluno primary key(RA)
); 

create table Professor(
    IdProfessor int,
    Nome varchar(150) not null,
    Senha varchar(20) not null,
    constraint PkProfessor primary key(IdProfessor)
);

create table Horario(
    IdHorario varchar(2),
    Inicio varchar(5) not null,
    Termino varchar(5) not null,
    constraint PkHorario primary key(IdHorario)
);

create table Sala(
    IdSala varchar(6),
    Categoria varchar(45) not null,
    constraint PkSala primary key(IdSala)
);

create table Reserva(
    IdSala varchar(6),
    RA int,
    IdProfessor int,
    Data date,
    Motivacao varchar(200),
    IdHorario varchar(2),
    constraint PkReserva primary key(IdSala,Data,IdHorario),
    constraint FkProfessor foreign key(IdProfessor) references Professor(IdProfessor)on update cascade on delete cascade,
    constraint FkAluno foreign key(RA) references Aluno(RA)on update cascade on delete cascade,
    constraint FkSala foreign key(IdSala) references Sala(IdSala)on update cascade on delete cascade,
    constraint FkHorario foreign key(IdHorario) references Horario(IdHorario) on update cascade on delete cascade
);


insert into Aluno values(1693190,'Adalberto Ribeiro','aaa123'),(1708561,'João Marcos Arruda Sampaio','345543efdsf@@'),
(982346,'Samira Oliveira','abcd4321'),(1903134,'Josimar Antônio Gallardo dos Santos Júnior','$$@@$$66624');

insert into Professor values(113,'José Fernando Antônio','123321'),(40,'Sandra Mara','aBaBaBC'),
(2,'Fabio Campos Poderoso','666'),(25,'Gabriel Canhadas Gengivir','age3');