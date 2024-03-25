public class User {
    private String userName; // User's username
    private String password; // User's password

    // Constructor for initializing user details with userName and password
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

// Getter and setter methods for userName attribute

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

// Getter and setter methods for password attribute

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
