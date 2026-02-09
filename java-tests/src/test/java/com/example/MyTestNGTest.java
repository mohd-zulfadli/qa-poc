import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTestNGTest {
    @Test
    public void multiplicationTest() {
        int result = 4 * 5;
        Assert.assertEquals(result, 20, "4 * 5 should equal 20");
    }
}
