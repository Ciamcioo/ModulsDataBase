package dataBase;

public class User {
    private static final String DEFAULT_USERNAME = "guest", DEFAULT_USER_PASSWORD = "password";
    private String username = null;
    private String password = null;


    /**
     * Default user constructor which sets the user to default user
     */
    public User() {
        this.setUsername(DEFAULT_USERNAME);
        this.setPassword(DEFAULT_USER_PASSWORD); 
    }

    /**
     * User consturctor which creates objcet representing user in data base who has specific username and password
     * @param username - provided name which will be username in database
     * @param password - password provided for specific username
     */
    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }


    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        if (username == null)
            this.username = DEFAULT_USERNAME; 
        else
            this.username = username; 
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        if (password == null)
            this.password = DEFAULT_USER_PASSWORD;
        else
            this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        User user = (User) obj;
        if (user.username == null && this.username != null)
            return false;
        else if (!this.username.equals(user.username))
            return false;
        if (user.password == null && this.password != null)
            return false;
        else if (!this.password.equals(user.password))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result; 
    }
}