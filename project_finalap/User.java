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
import java.io.Serializable;

@Entity
public class User implements Serializable {
    
    @Id
    @Column(name = "User_ID")
    private int userID;
    
    @Column(name = "FirstName")
    private String firstName;
    
    @Column(name = "LastName")
    private String lastName;
    
    @Column(name = "DateOfBirth")
    private String dateOfBirth;
    
    @Column(name = "PhoneNum")
    private int phoneNum;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "Password")
    private String password;

    public User()
    {
        
    }
    
    public User(String firstName, String lastName, String dateOfBirth, int phoneNum, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNum = phoneNum;
        this.email = email;
        this.password = password;
    }

    public User(String firstName, String dateOfBirth, int phoneNum, String email, String password) {
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNum = phoneNum;
        this.email = email;
        this.password = password;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    
}
