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
import linhnd.daos.RoomInHotelDAO;
import linhnd.dtos.Booking;
import linhnd.dtos.Hotel;

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
}
