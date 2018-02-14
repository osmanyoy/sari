package com.training.ee.ejb;

public class SingletonExample {
    private static volatile SingletonExample instance;

    private SingletonExample() {
    }

    public static SingletonExample getInstance() {
        if (instance == null) {
            synchronized (SingletonExample.class) {
                if (instance == null) {
                    instance = new SingletonExample();
                }
            }
        }
        return instance;
    }

}
