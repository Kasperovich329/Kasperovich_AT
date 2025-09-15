import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimpleTest {

    @Test
    void testAddition() {
        assertEquals(4, 2 + 2);
    }

    @Test
    void testString() {
        String text = "Hello";
        assertEquals("Hello", text);
    }
}