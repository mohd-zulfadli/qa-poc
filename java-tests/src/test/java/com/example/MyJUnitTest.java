import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyJUnitTest {
    @Test
    public void additionTest() {
        int result = 2 + 3;
        assertEquals(5, result, "2 + 3 should equal 5");
    }
}
