create database ttbs;
use ttbs;
create table loginTable(
loginId int primary key auto_increment,
UserName varchar(255) not null,
Pword varchar(20) not null,
Token varchar(20) unique,
AutherizationType varchar(6)
);

create table userDetailsTable(
UserId int primary key auto_increment,
loginId int,
FName varchar(255) not null,
LName varchar(255) ,
Phone  varchar(25) unique not null,
email varchar(255) unique,
city varchar(25),
foreign key(loginId) references loginTable(loginId)
);



create table ScreenDetails(
ScreenDetails_Id int primary key auto_increment,
Screen_no int not null,
ScreenType varchar(20) not null,
Seat int not null
);

create table MovieDetails(
MovieId int primary key auto_increment,
Movie_Name varchar(255) not null,
Duration_mins int not null 
);

create table TimingDetails(
TimingId int primary key auto_increment,
TimingName varchar(25) not null,
Timing int 
);

create table MovieTiming(
MovieTimingId int primary key auto_increment,
Screen_No int ,
Movie_Id int,
Timing_Id int,
foreign key(Screen_No) references ScreenDetails(Screen_no),
foreign key(Movie_Id) references MovieDetails(MovieId),
foreign key(Timing_Id) references TimingDetails(TimingId)
);

create table PricingDetails(
PricingId int primary key auto_increment,
MovieTiming_Id int,
Seat_type varchar(20) not null,
Price int,
foreign key(MovieTiming_Id) references MovieTiming(MovieTimingId)
);

create table BookingDetails(
BookingId int primary key auto_increment,
User_id int,
Movie_Id int,
Screen_Id int,
Timing_Id int,
foreign key(UserId) references userDetailsTable(User_Id),
foreign key(Screen_No) references ScreenDetails(Screen_no),
foreign key(Movie_Id) references MovieDetails(MovieId),
foreign key(Timing_Id) references TimingDetails(TimingId)
);

create table SeatDetails(
Booking_Id int,
Seat_no int,
foreign key(Booking_Id) references BookingDetails(BookingId)
);
