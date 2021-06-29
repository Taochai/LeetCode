import org.junit.Test;

public class testCode {

    @Test
    public void testNumber() {
        int a = 10 ^ 9;
        int b = 1000000000;
        int c = (int) Math.pow(10, 9);
        System.out.println(a == b);

    }

    @Test
    public void test_string_compareTo() {
        System.out.println("123".compareTo("321"));
        System.out.println("123".compareTo("123"));
        System.out.println("1234".compareTo("123"));


    }
}
