package Lesson_7;

public class ClassTest {
    @BeforeSuite
    public void begin() {
        System.out.println("Begin!");
    }

    @Test(prioritet = 2)
    public void method1() {
        System.out.println("Method 1");
    }

    @Test
    public void method2() {
        System.out.println("Method 2");
    }

    @Test(prioritet = 8)
    public void method3() {
        System.out.println("Method 3");
    }

    @Test
    public void method4() {
        System.out.println("Method 4");
    }

    @Test(prioritet = 4)
    public void method5() {
        System.out.println("Method 5");
    }

    @AfterSuite
    public void end () {
        System.out.println("End!");
    }
}
