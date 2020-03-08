SELECT DISTINCT Hotel.hotelID,nameHotel,rateHotel FROM dbo.RoomInHotel,dbo.Hotel   WHERE dateRoomFrom >= '2020-04-03' OR dateRoomTo <= '2020-04-02' OR statusRoom = 'ready' 
						AND dbo.Hotel.hotelID = dbo.RoomInHotel.hotelID AND statusHotel = 'active' ORDER BY dbo.Hotel.rateHotel DESC;





SELECT * FROM dbo.Hotel,dbo.RoomInHotel WHERE Hotel.hotelID = RoomInHotel.hotelID AND dateRoomFrom >= '2020-04-01' AND statusRoom = 'checking'