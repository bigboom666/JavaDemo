package thread;

public class TestWaitNotify {
    public static Object object = new Object();

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();

        try {
            System.out.println("�߳�" + Thread.currentThread().getName() + " sleep");
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
                    System.out.println("�߳�" + Thread.currentThread().getName() + "waitǰ");
                    object.wait();
                    System.out.println("�߳�" + Thread.currentThread().getName() + "wait��");
                } catch (InterruptedException e) {
                }
                System.out.println("�߳�" + Thread.currentThread().getName() + "����");
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("�߳�" + Thread.currentThread().getName() + "notifyǰ");
                object.notify();
                System.out.println("�߳�" + Thread.currentThread().getName() + "notify��");;
            }
            System.out.println("�߳�" + Thread.currentThread().getName() + "����");
        }
    }
}