package ManajemenHotel;

public class Admin {
    public String username;
    public String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

}