package lesson18.hw;

public class Main {
    public static void main(String[] args) {
        MyProfileProcessor processor = new MyProfileProcessor();
        MyClass object = new MyClass();
        processor.executeWithProfile(object, "do1");
        processor.executeWithProfile(object, "do2");
        processor.executeWithProfile(object, "do3");
    }
}
