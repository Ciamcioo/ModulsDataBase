package dataBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class UserTest {
    private static final String DEFAULT_DATA_BASE_USER = "guest", DEFAULT_USER_PASSWORD = "password";
    private static User def_usr = new User();
    private static User usr = new User("postgres", "password1"); 


    @Test
    public void threeArgumentConstructorTest() {
        assertEquals("postgres", usr.getUsername());    
        assertEquals("password1", usr.getPassword());
        assertEquals(false, usr.equals(def_usr));
        assertEquals(true, usr.equals(new User("postgres", "password1")) );
    }
    @Test
    public void userSettingTest() {
        String username = "guest123";
        def_usr.setUsername(null);
        assertEquals(DEFAULT_DATA_BASE_USER, def_usr.getUsername());
        def_usr.setUsername(username);
        assertEquals(username, def_usr.getUsername());
    }

    @Test
    public void passwordSettingTest() {
        String password = "password1";
        def_usr.setPassword(null);
        assertEquals(DEFAULT_USER_PASSWORD, def_usr.getPassword());
        def_usr.setPassword(password);
        assertEquals(password, def_usr.getPassword());
    }

    @Test
    public void testEqualsMethod() {
        assertEquals(true, def_usr.equals(new User()));
        assertNotEquals(true, def_usr.equals(usr));
        assertEquals(true, usr.equals(new User("postgres", "password1")));
    }


    @Test
    public void testHashCode() {
        assertEquals(def_usr.hashCode(), new User().hashCode());
        assertNotEquals(def_usr.hashCode(), usr.hashCode());
    }
    
    
    
}