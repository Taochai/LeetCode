package basicKnowledge.enumDemo;

public enum Season {
    /*
     * 定义了的对象。
     * 如果enum类implements了接口，可以在enum类里实现，也可以在每一个enum对象里实现。
     * */
    SPRING("春天"),
    SUMMER("夏天");

    Season(String description) {
    }
}
