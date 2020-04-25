package d.androidapps.ecommerceapp;

public class User {
    private long phone;
    private String password;
    private String name;
    private String email;
    private Integer earning;    //Integer promitive type is used in order to make it nullable when we sending phone and password for login.
    private String gender;

    public User(long phone, String password)    //Constructs object to send login info to API and JSON ignores nulled attributes of class.
    {
        this.phone = phone;
        this.password = password;
    }

    public User(long phone, String password, String name, String email, String gender)
    {
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.email = email;
        this.earning = earning;
        this.gender = gender;
    }

    public long getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getEarning() {
        return earning;
    }
}
