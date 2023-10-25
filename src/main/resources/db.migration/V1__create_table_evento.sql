create table `evento` (
    `id` bigint not null primary key auto_increment,
    `data` date not null,
    `data_inicio_insc` datetime(6) not null,
    `data_fim_insc` datetime(6) not null,
    `descricao` varchar(255) default null,
    `nome` varchar(255) not null,
    `status` enum('ABERTO', 'CANCELADO', 'ENCERRADO', 'PREVISTO') default null,
);