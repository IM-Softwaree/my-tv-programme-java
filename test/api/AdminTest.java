package api;

import api.Admin;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdminTest {

    @Test
    public void testAdminConstructor() {
        Admin admin = new Admin("admin123", "adminPass");
        assertEquals("admin123", admin.getUserame());
        assertEquals("adminPass", admin.getPassword());
    }

    @Test
    public void testInheritedMethods() {
        Admin admin = new Admin("admin456", "adminPass456");

        // Test inherited methods from Person
        assertEquals("admin456", admin.getUserame());
        assertEquals("adminPass456", admin.getPassword());
    }
}

