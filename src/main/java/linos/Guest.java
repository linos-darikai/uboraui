package linos;
public class Guest extends User {
    private String phoneNumber;

    public Guest(String email, String name, String passWord, String phonenumber) {
        super(email, name, email, passWord);
        this.phoneNumber = phonenumber;

    }

}
