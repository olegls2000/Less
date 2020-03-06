package Lesson19;

import Lesson9.homeWork.Car;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;
import utils.CarUtils;

import java.util.List;

public class Lesson19 {
    private static void printRangeAsync(int from, int to) {
        new Thread(() -> {
            for (int i = from; i <= to; i++) {
                System.out.println(i);
            }
        }).start();
    }

    private static volatile int price = 100;

    private synchronized static int incrementPrice(int increment) {
        return price += increment;
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1FRC = () -> {
            try {
                Thread.sleep(1000);
                System.out.println("before Increment R1: " + price);
                incrementPrice(1);
                System.out.println("after increment R1: " + price);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable runnable2FRC = () -> {
            System.out.println("before Increment R2: " + price);
            incrementPrice(2);
            System.out.println("after increment R2: " + price);
        };
        new Thread(runnable1FRC).start();
        new Thread(runnable2FRC).start();

        System.out.println("Hello from main Thread!!!");
        Runnable playMusic = () -> {
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Play music");
        };
        MyThread myThread1 = new MyThread(playMusic, "Thread Number 1");
        MyThread myThread2 = new MyThread(() -> System.out.println("Print my documents"),
                "Thread Number 1");
        System.out.println("Drink coffee...");
        myThread1.start();
        myThread2.start();
        myThread1.join();
        myThread2.join();
        System.out.println("Come back");

        printRangeAsync(0, 10);
        printRangeAsync(11, 20);
        printRangeAsync(21, 30);

        List<Car> cars = CarUtils.generateListOfCar(600);
        printCarsInTwoThreads(cars);
    }

    private static void printCarsInTwoThreads(List<Car> cars) {
        List<Car> part1 = cars.subList(0, cars.size() / 2);
        Runnable runnable1 = () -> part1.forEach(car -> {
            System.out.println("Print from Tr1:");
            System.out.println(car);
        });
        Thread tread1 = new Thread(runnable1);
        tread1.start();

        List<Car> part2 = cars.subList(cars.size() / 2, cars.size());
        Runnable runnable2 = () -> part2.forEach(car -> {
            System.out.println("Print from Tr2:");
            System.out.println(car);
        });
        Thread tread2 = new Thread(runnable2);
        tread2.start();
    }
}
