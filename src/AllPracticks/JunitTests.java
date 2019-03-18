package AllPracticks;

import org.junit.Assert;
import org.junit.Test;

public class JunitTests {

    @Test
    public void palindrome() {
        String someValue = "Ага";

        String value1 = someValue.replaceAll("\\s+","").toLowerCase();
        StringBuilder reversValue = new StringBuilder(value1);
        reversValue.reverse();

        Assert.assertEquals(someValue + " is not palindrome", value1, reversValue.toString());
    }
}
