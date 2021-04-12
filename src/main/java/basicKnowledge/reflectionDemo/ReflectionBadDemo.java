package basicKnowledge.reflectionDemo;

public class ReflectionBadDemo {

    public static void main(String[] args) {
        Object[] StringArr = new Object[]{"test1111", "test2222"};
        String[] newArr = (String[]) StringArr;
        /*
         * 强转报错！
         *
         * */
    }

}
