SELECT DISTINCT Hotel.hotelID,nameHotel,rateHotel FROM dbo.RoomInHotel,dbo.Hotel   WHERE dateRoomFrom >= '2020-04-03' OR dateRoomTo <= '2020-04-02' OR statusRoom = 'ready' 
						AND dbo.Hotel.hotelID = dbo.RoomInHotel.hotelID AND statusHotel = 'active' ORDER BY dbo.Hotel.rateHotel DESC;





SELECT * FROM dbo.Hotel,dbo.RoomInHotel WHERE Hotel.hotelID = RoomInHotel.hotelID AND dateRoomFrom >= '2020-04-01' AND statusRoom = 'checking';

SELECT * FROM dbo.Booking WHERE IdBooking NOT IN (SELECT IdBooking FROM dbo.Booking WHERE dateBookingFrom >= '2020-04-02' OR dateBookingTo <= '2020-04-01');


SELECT COUNT(codeRoom) FROM dbo.DetailBooking WHERE IdBooking = 'BOOK1';
SELECT COUNT(codeRoom) FROM dbo.RoomInHotel WHERE hotelID = '09R0XJZ';

SELECT * FROM dbo.Hotel h WHERE hotelID NOT IN ('09R0XJZ') AND nameHotel LIKE 's' OR addressHotel LIKE 's' ORDER BY h.rateHotel;
SELECT * FROM dbo.Booking WHERE dateBookingFrom < '2020-03-10' AND '2020-03-10' < dateBookingTo;
SELECT dbo.KindOfRoom.nameKindRoom FROM dbo.KindOfRoom WHERE IdKindRoom IN (SELECT DISTINCT (KindOfRoom.IdKindRoom)   FROM dbo.KindOfRoom,dbo.RoomInHotel WHERE KindOfRoom.IdKindRoom=RoomInHotel.IdKindRoom AND hotelID = '09R0XJZ'); 