
# Api REST com Spring boot
### Desafio Diel Energia
#### foi ultilizada a versão 2.7.5 do spring
#### obs: É necessário configurar o banco de dados mysql e o arquivo application.yaml que está localizado dentro de src/main/resources

## Tabela
### Estrutura do banco de dados para calender_api

>CREATE DATABASE IF NOT EXISTS `calender_api`

### Estrutura para tabela task
> CREATE TABLE IF NOT EXISTS `task` (
`id` bigint NOT NULL AUTO_INCREMENT,
`data` date NOT NULL,
`description` varchar(250) DEFAULT NULL,
`duration` int DEFAULT NULL,
`hour` int NOT NULL,
`title` varchar(80) NOT NULL,
PRIMARY KEY (`id`)
);

### Dados para a tabela task

>INSERT INTO `task` (`id`, `data`, `description`, `duration`, `hour`, `title`) VALUES
(1, '2022-11-25', 'testando um cadastro', NULL, 925, 'Desenvolvedor mobile'),
(2, '2022-11-07', 'passa na padaria tal tal tal', NULL, 840, 'comprar bolo de cenoura'),
(3, '2022-11-07', '', NULL, 1250, 'passar no petshop'),
(4, '2022-11-07', '', NULL, 599, 'compar na feira');
