create database basedatosneoris;

create table persona (
	id int primary key not null ,
    nombre varchar(50),
    genero varchar(9),
	edad int,
    identificacion varchar(10),
    direccion varchar(60),
    telefono varchar(10)
);

create table cliente (
	id int primary key not null ,
    contrasena varchar(4),
    estado boolean,
    id_persona int not null unique,
    foreign key (id_persona) references persona(id)
);


create table cuenta (
	id int primary key not null ,
    numero_cuenta varchar(6),
    tipo_cuenta varchar(9),
	saldo_inicial numeric,
    estado boolean,
    id_cliente int not null,
    foreign key (id_cliente) references cliente(id)
);


create table movimientos (
	id int primary key not null ,
    fecha TIMESTAMP,
    tipo_movimiento varchar(20),
	valor numeric,
    saldo numeric,
    id_cuenta int not null,
	foreign key (id_cuenta) references cuenta(id)
);