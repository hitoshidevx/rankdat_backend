create table account (id number(19,0) generated as identity, descricao_conta varchar2(40 char), icone_conta varchar2(255 char), nome_conta varchar2(30 char), primary key (id));
create table game (id number(19,0) generated as identity, data_lancamento date not null, descricao_jogo varchar2(255 char), nome_jogo varchar2(50 char), valor_jogo number(38,2) check (valor_jogo>=0), account_id number(19,0) not null, primary key (id));
create table review (id number(19,0) generated as identity, descricao_review varchar2(255 char), titulo_review varchar2(50 char), primary key (id));
create table account (id number(19,0) generated as identity, descricao_conta varchar2(40 char), icone_conta varchar2(255 char), nome_conta varchar2(30 char), primary key (id));
create table game (id number(19,0) generated as identity, data_lancamento date not null, descricao_jogo varchar2(255 char), nome_jogo varchar2(50 char), valor_jogo number(38,2) check (valor_jogo>=0), account_id number(19,0) not null, primary key (id));
create table review (id number(19,0) generated as identity, descricao_review varchar2(255 char), titulo_review varchar2(50 char), primary key (id));
alter table game add constraint FKgli7y8ycvjhbixubb1rq0d9cx foreign key (account_id) references account;
create table account (id number(19,0) generated as identity, descricao_conta varchar2(40 char), icone_conta varchar2(255 char), nome_conta varchar2(30 char), primary key (id));
create table game (id number(19,0) generated as identity, data_lancamento date not null, descricao_jogo varchar2(255 char), nome_jogo varchar2(50 char), valor_jogo number(38,2) check (valor_jogo>=0), account_id number(19,0) not null, primary key (id));
create table review (id number(19,0) generated as identity, descricao_review varchar2(255 char), titulo_review varchar2(50 char), primary key (id));
alter table game add constraint FKgli7y8ycvjhbixubb1rq0d9cx foreign key (account_id) references account;
create table account (id number(19,0) generated as identity, descricao_conta varchar2(40 char), icone_conta varchar2(255 char), nome_conta varchar2(30 char), primary key (id));
create table game (id number(19,0) generated as identity, data_lancamento date not null, descricao_jogo varchar2(255 char), nome_jogo varchar2(50 char), valor_jogo number(38,2) check (valor_jogo>=0), account_id number(19,0) not null, primary key (id));
create table review (id number(19,0) generated as identity, descricao_review varchar2(255 char), titulo_review varchar2(50 char), primary key (id));
alter table game add constraint FKgli7y8ycvjhbixubb1rq0d9cx foreign key (account_id) references account;
create table account (id number(19,0) generated as identity, descricao_conta varchar2(40 char), icone_conta varchar2(255 char), nome_conta varchar2(30 char), primary key (id));
create table game (id number(19,0) generated as identity, data_lancamento date not null, descricao_jogo varchar2(255 char), nome_jogo varchar2(50 char), valor_jogo number(38,2) check (valor_jogo>=0), account_id number(19,0) not null, primary key (id));
create table review (id number(19,0) generated as identity, descricao_review varchar2(255 char), titulo_review varchar2(50 char), primary key (id));
alter table game add constraint FKgli7y8ycvjhbixubb1rq0d9cx foreign key (account_id) references account;
