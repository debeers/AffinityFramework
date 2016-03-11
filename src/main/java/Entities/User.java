package Entities;

/**
 * Created by DeBeers on 08.03.2016.
 */
public class User {

    private String phoneNumber = "";
    private String email = "";
    private String password = "";


    public User(){}

    public User(String phoneNumber, String email, String password) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        userLog();
    }


    public void userLog(){
        System.out.println("_____________:::USER PARAMETERS LOG:::_____________");
        System.out.println();
        System.out.println("USER PHONE NUMBER......" + this.getPhoneNumber());
        System.out.println("USER PASSWORD.........." + this.getPassword());
        System.out.println("USER EMAIL............." + this.getEmail());
        System.out.println();
        System.out.println("___________________________________________________");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
