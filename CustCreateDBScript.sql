use Customers;
select count(*) as `Customer Count` from customers;

select count(distinct company)as 'Distinct Companies' from customers ;

alter table customers add CompanyID int;

select companyID, company from customers;

create table Company (
companyID int NOT NULL AUTO_INCREMENT,
Company varchar(50),
primary key (companyID)
);

select * from Company;

describe Company;

insert into Company(company)values ('Dave Company');

select * from Company;

insert into Company (company) select distinct company from customers;

select * from Company;

update customers c set c.companyID = (select t.companyID from
Company t where t.company=c.company);

select c.companyID,c.company,t.companyID,t.Company from
customers c inner join Company t on c.CompanyID=t.CompanyID;

alter table customers drop column company;

alter table customers drop column FullName;

select * from customers;

select company from customers 
inner join Company on 
customers.companyid=Company.companyid;

select * from customers;





alter table customers add AddressID varchar(50);

select * from customers;

create table Address(
	AddressID int NOT NULL auto_increment,
    StreetAddress varchar(50),
    City varchar(50),
    State varchar(50),
    ZipCode varchar(50),
    primary key(AddressID)
    )

select * from Company;

alter table Address drop column Company;

insert into Address(StreetAddress, City, State, ZipCode)
Values('pizza','gburg','MD','20878');

select * from Address;


insert into Address(StreetAddress, City, State, ZipCode) select distinct StreetAddress, City, State, ZipCode from customers;  

update customers c set c.AddressID = (select t.AddressID from
Address t where t.State=c.State AND t.StreetAddress=c.StreetAddress);

select c.AddressID,t.AddressID,t.StreetAddress from
customers c inner join Address t on c.AddressID=t.AddressID;

alter table customers drop column StreetAddress;
alter table customers drop column City;
alter table customers drop column State;
alter table customers drop column ZipCode;

alter table customers add column PositionID varchar(50);

create table tblPosition(
	PositionID int not null auto_increment,
    Position varchar(100),
    primary key(PositionID)
    );
    
insert into tblPosition(Position)values('benchwarmer');
select * from tblPosition;

insert into tblPosition (Position) select distinct Position from customers;
update customers c set c.PositionID = (select t.PositionID from
tblPosition t where t.Position=c.Position);

select c.PositionID,t.PositionID,t.Position from
customers c inner join tblPosition t on c.Position=t.Position;

alter table customers drop column Position;

select  Title, FirstName, LastName from customers where LastName="Smith";

select Title, FirstName, LastName, customers.CompanyID, Company.CompanyID, tblPosition.PositionID, customers.PositionID, City from customers, Company, tblPosition where ,