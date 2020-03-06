CREATE DATABASE HotelManager
CREATE TABLE Users
(
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT NULL,
  roleUser VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  statusUser VARCHAR(50) NOT NULL,
  dateCreate DATETIME NOT NULL,
  fullName VARCHAR(50) NOT NULL,
  addressUser VARCHAR(50) NOT NULL,
  numberPhone VARCHAR(50) NOT NULL,
  PRIMARY KEY (username)
);

CREATE TABLE Hotel
(
  hotelID VARCHAR(50) NOT NULL,
  nameHotel VARCHAR(50) NOT NULL,
  addressHotel VARCHAR(50) NOT NULL,
  numberOfRoomHotel INT NOT NULL,
  rateHotel INT NOT NULL,
  statusHotel VARCHAR(50) NOT NULL,
  desHotel VARCHAR(50)  NULL,
  PRIMARY KEY (hotelID)
);

CREATE TABLE KindOfRoom
(
  IdKindRoom VARCHAR(50) NOT NULL,
  nameKindRoom VARCHAR(50) NOT NULL,
  numberOfPeopleRoom INT NOT NULL,
  desRoom VARCHAR(50)  NULL,
  priceOfRoom VARCHAR(50) NOT NULL,
  PRIMARY KEY (IdKindRoom)
);

CREATE TABLE statusDiscount
(
  codeDiscount VARCHAR(50) NOT NULL,
  percentDiscount INT NOT NULL,
  dateDisFrom DATETIME NOT NULL,
  dateDisTo DATETIME NOT NULL,
  desDiscount VARCHAR(50)  NULL,
  PRIMARY KEY (codeDiscount)
);

CREATE TABLE Booking
(
  IdBooking VARCHAR(50) NOT NULL,
  dateBookingFrom DATETIME NOT NULL,
  dateBookingTo DATETIME NOT NULL,
  statusBooking VARCHAR(50) NOT NULL,
  desBooking VARCHAR(50)  NULL,
  totalBooking VARCHAR(50) NOT NULL,
  numberOfNice INT NOT NULL,
  username VARCHAR(50) NOT NULL,
  PRIMARY KEY (IdBooking),
  FOREIGN KEY (username) REFERENCES Users(username)
);

CREATE TABLE RoomInHotel
(
  codeRoom VARCHAR(10) NOT NULL,
  numberOfRoom INT NOT NULL,
  dateRoomFrom DATETIME NOT NULL,
  dateRoomTo DATE NOT NULL,
  statusRoom VARCHAR(50) NOT NULL,
  hotelID VARCHAR(50) NOT NULL,
  IdKindRoom VARCHAR(50) NOT NULL,
  PRIMARY KEY (hotelID, IdKindRoom),
  FOREIGN KEY (hotelID) REFERENCES Hotel(hotelID),
  FOREIGN KEY (IdKindRoom) REFERENCES KindOfRoom(IdKindRoom)
);

CREATE TABLE UserHaveDiscount
(
  statusUserDis VARCHAR(50) NOT NULL,
  username VARCHAR(50) NOT NULL,
  codeDiscount VARCHAR(50) NOT NULL,
  PRIMARY KEY (username, codeDiscount),
  FOREIGN KEY (username) REFERENCES Users(username),
  FOREIGN KEY (codeDiscount) REFERENCES statusDiscount(codeDiscount)
);

CREATE TABLE DetailBooking
(
  codeRoom VARCHAR(10) NOT NULL,
  numberOfRoom INT NOT NULL,
  priceDetail VARCHAR(50) NOT NULL,
  hotelID VARCHAR(50) NOT NULL,
  IdBooking VARCHAR(50) NOT NULL,
  PRIMARY KEY (hotelID, IdBooking),
  FOREIGN KEY (hotelID) REFERENCES Hotel(hotelID),
  FOREIGN KEY (IdBooking) REFERENCES Booking(IdBooking)
);

