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
import javax.persistence.Table;
@Entity
@Table(name="payment")
public class Payment implements java.io.Serializable{
    @Column(name = "NameOnCard")
    private String NameOnCard;
    @Id
    @Column(name = "CreditCardNum")
    private int CreditCardNum;
    @Column(name = "SecurityCode")
    private int SecurityCode;
    @Column(name = "month")
    private String  month;
    @Column(name = " year")
    private String year;
    
    
    public Payment() {
    }

    public Payment(String Name_OnCard, int CreditCard_Num, int Security_Code, String  month,String year) {

        this.NameOnCard = Name_OnCard;
        this.CreditCardNum = CreditCard_Num;
        this.SecurityCode = Security_Code;
        this.month = month;
        this.year = year;



    }
//
//    public int getId() {
//        return this.id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

//    public int getBooking_id() {
//        return B_ID;
//    }
//
//    public void setBooking_id(int booking_id) {
//        this.B_ID = booking_id;
//    }

    public String getNameOnCard() {
        return NameOnCard;
    }

    public void setNameOnCard(String NameOnCard) {
        this.NameOnCard = NameOnCard;
    }

    public int getCreditCardNum() {
        return CreditCardNum;
    }

    public void setCreditCardNum(int CreditCardNum) {
        this.CreditCardNum = CreditCardNum;
    }

    public int getSecurityCode() {
        return SecurityCode;
    }

    public void setSecurityCode(int SecurityCode) {
        this.SecurityCode = SecurityCode;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
 
    
    
}

