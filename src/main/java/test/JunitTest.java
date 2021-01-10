package test;

import org.junit.Test;

public class JunitTest {
    @Test
    public void test1() {
        String s1 = "mm";
        String s2 = "mm";
        System.out.println(s1.equals(s2));

    }

    @Test
    public void test2() {
        String s1 = "mmss";
        String s2 = "mmss";
        System.out.println(s1.equals(s2));

    }


}
