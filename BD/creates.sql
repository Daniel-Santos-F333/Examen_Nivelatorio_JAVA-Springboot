create database examen_nivelatorio;

use examen_nivelatorio;

create table estudiantes(
    id int not null auto_increment, 
    nombre varchar(50) not null, 
    email varchar(200) not null, 
    edad int not null, 
    primary key(id)
);

create table cursos(
    id int not null auto_increment, 
    nombre varchar(50) not null, 
    descripcion varchar(200), 
    fecha Date, 
    activo boolean not null, 
    primary key (id)
);

create table curso_estudiante(
    id int not null auto_increment, 
    curso_id int not null, 
    estudiante_id int not null,
    primary key (id),
    foreign key (curso_id) references cursos(id), 
    foreign key (estudiante_id) references estudiantes(id)
);