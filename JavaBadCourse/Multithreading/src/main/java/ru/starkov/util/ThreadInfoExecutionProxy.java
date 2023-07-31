package ru.starkov.util;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ThreadInfoExecutionProxy implements InvocationHandler {

    private Object target;
    public static final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    public ThreadInfoExecutionProxy(Object target) {
        this.target = target;
    }

    public Object createProxy() {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader, interfaces, this);
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long[] allThreadIds = threadMXBean.getAllThreadIds();
        ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(allThreadIds);
        for (ThreadInfo threadInfo : threadInfos) {
            if (threadInfo.getThreadName().contains("pool")) {
                System.out.println("Thread ID: " + threadInfo.getThreadId());
                System.out.println("Thread Name: " + threadInfo.getThreadName());
                System.out.println("Thread State: " + threadInfo.getThreadState());

            }
        }
        System.out.println("-------------------------------------------------------");

        Object invoke = method.invoke(target, args);

        return invoke;
    }
}
