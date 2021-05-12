CREATE DATABASE IF NOT EXISTS `bd-hibernate-parcial`;
USE `bd-hibernate-parcial`;

create table sistema(
	idSistema int(11) not null auto_increment,
    nombre varchar(20) not null,
    primary key (idSistema)
);

create table servicio(
	idServicio int(11) not null auto_increment,
    porcentajeDescuento double not null,
    enPromocion bit not null,
    idSistema int(11) not null,
    primary key (idServicio),
    foreign key (idSistema) references sistema(idSistema)
);

create table gastronomia(
	idGastronomia int(11) not null,
    precio double not null,
    diaSemDesc int(5) not null,
    primary key (idGastronomia),
    foreign key (idGastronomia) references servicio(idServicio)
);

create table hospedaje(
	idHospedaje int(11) not null,
    hospedaje varchar(30) not null,
    precioPorNoche double not null,
    primary key (idHospedaje),
    foreign key (idHospedaje) references servicio(idServicio)
);

create table cliente(
	idCliente int(11) not null auto_increment,
    nombre varchar(20) not null,
    apellido varchar(20) not null,
    dni varchar(20) not null,
    primary key (idCliente)
);

create table clientesHospedaje(
	idCliente int(11) not null,
    idHospedaje int(11) not null,
    primary key (idCliente, idHospedaje),
    foreign key (idCliente) references cliente(idCliente),
    foreign key (idHospedaje) references hospedaje(idHospedaje)
);
