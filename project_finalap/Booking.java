/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package in.project;

/**
 *
 * @author janawalaa
 */

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;

/**
 *
 * @author MMDAH
 */
@Entity
public class Booking implements java.io.Serializable {

    @Id
    @Column(name = "BookingID")
    private int bookingID;
//    @Column(name = "MovieID")
//    private int movieID;
//    @Column(name = "User_ID")
//    private int userID;
    @Column(name = "MoviePrice")
    private String movieprice;
    @Column(name = "SeatNum")
    private String seatNum;
    @Column(name = "Date")
    private String date;
 
    @Column(name = "Time")
    private String time;

    public Booking() {
    }

//    public Booking(int bookingID, int movieID, int userID, int movieprice, String seatNum, String date, String time) {
//        this.bookingID = bookingID;
//        this.movieID = movieID;
//        this.userID = userID;
//        this.movieprice = movieprice;
//        this.seatNum = seatNum;
//        this.date = date;
//        this.time = time;
//    }
    
        public Booking(int bookingID, String movieprice, String seatNum, String date, String time) {
        this.bookingID = bookingID;
        this.movieprice = movieprice;
        this.seatNum = seatNum;
        this.date = date;
        this.time = time;
    }



    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }
//
//    public int getMovieID() {
//        return movieID;
//    }
//
//    public void setMovieID(int movieID) {
//        this.movieID = movieID;
//    }
//
//    public int getUserID() {
//        return userID;
//    }
//
//    public void setUserID(int userID) {
//        this.userID = userID;
//    }

    public String getMovieprice() {
        return movieprice;
    }

    public void setMovieprice(String movieprice) {
        this.movieprice = movieprice;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}