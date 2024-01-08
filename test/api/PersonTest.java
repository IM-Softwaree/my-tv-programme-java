package api;

import api.Person;
import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void testGetPassword() {
        Person person = new Person("lebron", "miami");
        assertEquals("miami", person.getPassword());
    }

    @Test
    public void testSetPassword() {
        Person person = new Person();
        person.setPassword("newPassword");
        assertEquals("newPassword", person.getPassword());
    }

    @Test
    public void testGetUsername() {
        Person person = new Person("LebronJames", "pass123");
        assertEquals("LebronJames", person.getUserame()); // Correcting the typo
    }

    @Test
    public void testSetUsername() {
        Person person = new Person();
        person.setUserame("newUsername");
        assertEquals("newUsername", person.getUserame());
    }

    @Test
    public void testDefaultConstructor() {
        Person person = new Person();
        assertNull(person.getPassword());
        assertNull(person.getUserame());
    }

    @Test
    public void testParameterizedConstructor() {
        Person person = new Person("user123", "pass456");
        assertEquals("user123", person.getUserame());
        assertEquals("pass456", person.getPassword());
    }
}
