create table `inscricao` (
    `id` bigint not null primary key auto_increment,
    `data` datetime(6) not null,
    `evento_id` bigint not null,
    `usuario_id` bigint not null,

    foreign key(`evento_id`) references `evento` (`id`),
    foreign key(`usuario_id`) references `usuario` (`id`)
);