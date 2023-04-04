create database TrackingLi;
use TrackingLi;
create table Livreurs(
id int auto_increment primary key,
Nom varchar(20) not null,
Prenom varchar(20) not null,
Telephone varchar(20) not null
);

insert into Livreurs(Nom, Prenom , Telephone) values("Rommel", "erwin","+491933192");

