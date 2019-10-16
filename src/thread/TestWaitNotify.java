package thread;

public class TestWaitNotify {
    public static Object object = new Object();

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();

        try {
            System.out.println("线程" + Thread.currentThread().getName() + " sleep");
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                try {
                    System.out.println("线程" + Thread.currentThread().getName() + "wait前");
                    object.wait();
                    System.out.println("线程" + Thread.currentThread().getName() + "wait后");
                } catch (InterruptedException e) {
                }
                System.out.println("线程" + Thread.currentThread().getName() + "结束");
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("线程" + Thread.currentThread().getName() + "notify前");
                object.notify();
                System.out.println("线程" + Thread.currentThread().getName() + "notify后");;
            }
            System.out.println("线程" + Thread.currentThread().getName() + "结束");
        }
    }
}