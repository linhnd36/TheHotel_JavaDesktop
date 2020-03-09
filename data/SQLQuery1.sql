SELECT DISTINCT Hotel.hotelID,nameHotel,rateHotel FROM dbo.RoomInHotel,dbo.Hotel   WHERE dateRoomFrom >= '2020-04-03' OR dateRoomTo <= '2020-04-02' OR statusRoom = 'ready' 
						AND dbo.Hotel.hotelID = dbo.RoomInHotel.hotelID AND statusHotel = 'active' ORDER BY dbo.Hotel.rateHotel DESC;





SELECT * FROM dbo.Hotel,dbo.RoomInHotel WHERE Hotel.hotelID = RoomInHotel.hotelID AND dateRoomFrom >= '2020-04-01' AND statusRoom = 'checking';

SELECT * FROM dbo.Booking WHERE IdBooking NOT IN (SELECT IdBooking FROM dbo.Booking WHERE dateBookingFrom >= '2020-04-02' OR dateBookingTo <= '2020-04-01');


SELECT COUNT(codeRoom) FROM dbo.DetailBooking WHERE IdBooking = 'BOOK1';
SELECT COUNT(codeRoom) FROM dbo.RoomInHotel WHERE hotelID = '09R0XJZ'