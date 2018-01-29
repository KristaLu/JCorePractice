package lesson180126;

public class ReflectionTest {

    private final String str = null;

    @MyTest
    public void testBaseCase(){
        System.out.println("base case " + str);
    }

    @MyTest
    public void testLowerBound(){
        System.out.println("lower bound " + str);
    }

}