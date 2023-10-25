create table `usuario` (
    `id` bigint not null primary key auto_increment,
    `cidade` varchar(255) default null,
    `nome` varchar(255) not null,
    `telefone` varchar(255) default null,
);