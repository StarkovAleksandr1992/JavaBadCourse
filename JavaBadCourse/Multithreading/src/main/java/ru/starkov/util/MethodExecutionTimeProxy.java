package ru.starkov.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MethodExecutionTimeProxy implements InvocationHandler {
    private Object target;
    private long totalExecutionTime;

    public MethodExecutionTimeProxy(Object target) {
        this.target = target;
    }

    public Object createProxy() {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader, interfaces, this);
    }

    public long getTotalExecutionTime() {
        return totalExecutionTime;
    }

    public void setTotalExecutionTime(long totalExecutionTime) {
        this.totalExecutionTime = totalExecutionTime;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = method.invoke(target, args);
        long end = System.currentTimeMillis();
//        System.out.printf("Время выполнения метода %s: %d секунд \n", method.getName(), (end - start) / 1000);
        totalExecutionTime += (end - start);
        return result;
    }
}
