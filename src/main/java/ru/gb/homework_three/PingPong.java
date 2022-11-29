package ru.gb.homework_three;

public class PingPong {
    private static boolean flag;
    private static final Object object = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (object) {
                while (true) {
                    if (flag) {
                        System.out.println("Ping");
                        try {
                            Thread.sleep(500);
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        object.notify();
                        flag = true;
                    }
                }
            }


        }).start();
        new Thread(() -> {
            synchronized (object) {
                while (true) {
                    if (!flag) {
                        System.out.println("Pong");
                        try {
                            Thread.sleep(500);
                            object.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        object.notify();
                        flag = false;
                    }
                }
            }
        }
    ).start();
}
}
