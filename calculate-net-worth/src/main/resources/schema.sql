create table portfolio_details (portfolio_id int primary key);

create table asset_details (tid int primary key,asset_id varchar(20),portfolio_id int,type varchar(10),units int, foreign key(portfolio_id) references portfolio_details(portfolio_id));