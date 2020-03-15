/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linhnd.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import linhnd.daos.BookingDAO;
import linhnd.daos.DetailBookingDAO;
import linhnd.daos.HotelDAO;
import linhnd.daos.KindOfRoomDAO;
import linhnd.daos.RoomInHotelDAO;
import linhnd.dtos.Booking;
import linhnd.dtos.Hotel;
import linhnd.dtos.KindOfRoom;

/**
 *
 * @author Duc Linh
 */
public class SearchController implements Serializable {

    public List<Hotel> getListHotelVaild(String textSearch, Date dateFrom, Date dateTo) throws Exception {
        Map<String, String> resultMapIdBookIdHotel = null;
        List<Booking> resultBooking = null;
        List<String> listIdHotelNoVaild = new ArrayList<>();
        List<Hotel> listHotelValid = null;
        try {
            BookingDAO bookingDAO = new BookingDAO();
            HotelDAO hotelDAO = new HotelDAO();
            DetailBookingDAO detailBookingDAO = new DetailBookingDAO();
            RoomInHotelDAO roomInHotelDAO = new RoomInHotelDAO();
            resultBooking = bookingDAO.getListBookingNotValid(dateFrom, dateTo);
            resultMapIdBookIdHotel = hotelDAO.getIdHotelByIdBooking(resultBooking);
            for (Booking booking : resultBooking) {
                String idHotel = resultMapIdBookIdHotel.get(booking.getIdBooking());
                int countRoomBook = detailBookingDAO.countRoomInDetailByIdBooking(booking.getIdBooking());
                int countRoomInHotel = roomInHotelDAO.countRoomInHotelByHotelid(idHotel);
                if (countRoomInHotel <= countRoomBook) {
                    listIdHotelNoVaild.add(idHotel);
                }
            }
            listHotelValid = hotelDAO.getlistHotelSearch(listIdHotelNoVaild, textSearch);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHotelValid;
    }

    public List<Hotel> getListHotelVaildNow() throws Exception {
        Map<String, String> resultMapIdBookIdHotel = null;
        List<Booking> resultBooking = null;
        List<String> listIdHotelNoVaild = new ArrayList<>();
        List<Hotel> listHotelValid = null;
        try {
            BookingDAO bookingDAO = new BookingDAO();
            HotelDAO hotelDAO = new HotelDAO();
            DetailBookingDAO detailBookingDAO = new DetailBookingDAO();
            RoomInHotelDAO roomInHotelDAO = new RoomInHotelDAO();
            resultBooking = bookingDAO.getListBookingNow();
            resultMapIdBookIdHotel = hotelDAO.getIdHotelByIdBooking(resultBooking);
            for (Booking booking : resultBooking) {
                String idHotel = resultMapIdBookIdHotel.get(booking.getIdBooking());
                int countRoomBook = detailBookingDAO.countRoomInDetailByIdBooking(booking.getIdBooking());
                int countRoomInHotel = roomInHotelDAO.countRoomInHotelByHotelid(idHotel);
                if (countRoomInHotel <= countRoomBook) {
                    listIdHotelNoVaild.add(idHotel);
                }
            }
            listHotelValid = hotelDAO.getListHotelVaildNow(listIdHotelNoVaild);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHotelValid;
    }

    public List<KindOfRoom> checkKindOfRoom(Date dateFrom, Date dateTo, String idHotel) throws Exception {
        List<Booking> resultBooking = null;
        List<KindOfRoom> listKindOfRoomlValid = new ArrayList<>();
        List<KindOfRoom> listKindOfRoomlInHotel = null;
        try {
            BookingDAO bookingDAO = new BookingDAO();
            RoomInHotelDAO roomInHotelDAO = new RoomInHotelDAO();
            KindOfRoomDAO kindOfRoomDAO = new KindOfRoomDAO();
            resultBooking = bookingDAO.getListBookingInHotel(dateFrom, dateTo, idHotel);
            listKindOfRoomlInHotel = kindOfRoomDAO.getListKindOfRoom(idHotel);
            for (KindOfRoom kindOfRoom : listKindOfRoomlInHotel) {
                int countKindOfRoomBooking = 0;
                int countKindOfRoom = roomInHotelDAO.countOfRoomInHotel(kindOfRoom.getIdKindRoom());
                for (Booking booking : resultBooking) {
                    countKindOfRoomBooking = countKindOfRoomBooking + roomInHotelDAO.countKindOfRoomBooking(kindOfRoom.getIdKindRoom(), idHotel, booking.getIdBooking());
                }
                if (countKindOfRoom > countKindOfRoomBooking) {
                    listKindOfRoomlValid.add(kindOfRoom);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKindOfRoomlValid;
    }
}
