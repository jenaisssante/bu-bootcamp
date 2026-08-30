import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    public void setUp() {
        contact = new Contact("Alice Smith", "555-1234");
    }

    @Test
    public void testGetName() {
        assertEquals("Alice Smith", contact.getName());
    }

    @Test
    public void testGetPhone() {
        assertEquals("555-1234", contact.getPhone());
    }

    @Test
    public void testToStringFormat() {
        assertEquals("Alice Smith | 555-1234", contact.toString());
    }

    @Test
    public void testConstructorWithDifferentValues() {
        Contact other = new Contact("Bob Jones", "555-9999");
        assertEquals("Bob Jones", other.getName());
        assertEquals("555-9999", other.getPhone());
    }

    @Test
    public void testTwoContactsAreNotTheSameObject() {
        Contact other = new Contact("Alice Smith", "555-1234");
        assertNotSame(contact, other);
        assertEquals(contact.toString(), other.toString());
    }
}
