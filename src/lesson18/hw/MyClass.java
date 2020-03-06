package lesson18.hw;

import java.util.stream.Stream;

@MyProfile
public class MyClass {
    @MyProfile
    public void do1() {
        Stream.iterate(1, i -> i + 1).parallel()
                .limit(100000)
                .forEach(i -> System.out.print("iteration"));
    }

    @MyProfile
    public void do2() {
        for (int j = 0; j < 100000; j++) {
            System.out.print("iteration");
        }
    }

    @MyProfile
    public void do3() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
