/*create database sistemaEstoque;
use sistemaEstoque;*/

create table IF NOT EXISTS  tb_categoria (
cd_categoria int not null auto_increment,
nm_categoria varchar(255) not null,
constraint pk_categoria
	primary key(cd_categoria));
    
create table IF NOT EXISTS tb_produto(
cd_produto int not null auto_increment,
cd_categoria int not null,
nm_produto varchar(255) not null,
nm_marca_produto varchar(255) not null,
vl_produto decimal(9,2) not null,
constraint pk_produto
	primary key(cd_produto),
constraint fk_produto_categoria
	foreign key(cd_categoria)
		references tb_categoria(cd_categoria));