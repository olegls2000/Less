package Lesson19;

public class MyThread extends Thread {
    public MyThread(Runnable target, String name) {
        super(target);
        setName(name);
    }
}
