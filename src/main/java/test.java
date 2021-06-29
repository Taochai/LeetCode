import java.util.ArrayList;

public class test {


    public static void main(String[] args) throws RuntimeException {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(123);
        array.add("123123");

        ArrayList<String> array1 = new ArrayList<>();


        test test = new test();
        try {
            test.func1();
            test.func2();

        } catch (Exception e) {
            System.out.println("***********" + e);
        }
    }

    public int func1() throws ChildException {
        func2();
        return 1;
    }

    public int func2() {
//        throw new ParentException();
        return 2;
    }

}

class ParentException extends Exception {
}

class ChildException extends ParentException {

}



