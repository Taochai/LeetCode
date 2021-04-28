import org.junit.Test;

import java.util.Arrays;

public class RegexTest {

    @Test
    public void test_regex() {
        String s = "/home/";
        String[] split = s.split("[/]+");
//        System.out.println(split.length);
//        System.out.println(split[0]);
        System.out.println(Arrays.toString(split));
    }
}
