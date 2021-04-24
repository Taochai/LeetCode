package basicKnowledge.dynamicProxy;

class UserImpl implements User {
    @Override
    public void hello() {
        System.out.println("hello user ..............");
    }

    @Override
    public void work() {
        System.out.println("user work ...................hard");
    }
}
