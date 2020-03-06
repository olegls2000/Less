package lesson18.hw;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

public class MyProfileProcessor {

    public void executeWithProfile(Object object, String methodName) {
        Class<?> clazz = object.getClass();
        Method[] methods = clazz.getMethods();

        Method method = Arrays.asList(methods).stream()
                .filter(m -> m.getName().equals(methodName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No Such Method in object: " + methodName));

        try {
            long timeBefore = System.currentTimeMillis();
            method.invoke(object);
            long timeAfter = System.currentTimeMillis();
            long executionTime = timeAfter - timeBefore;
            System.out.println("\n Execution time of " + methodName + ": " + executionTime);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
