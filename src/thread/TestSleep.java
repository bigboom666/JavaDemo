package thread;

import java.io.IOException;

public class TestSleep {
    private int i = 10;
    private Object object = new Object();
    private Object objectB = new Object();

    public static void main(String[] args) throws IOException {
        TestSleep test = new TestSleep();
        MyThread thread1 = test.new MyThread();
        MyThread thread2 = test.new MyThread();
        thread2.setPriority(10);

        thread1.start();
        thread2.start();
    }

    //sleep依然保持对象的锁。
    class MyThread   extends Thread {  //不能用throws抛出的原因：重写run，子类抛出的异常类型不能比父类抛出的异常类型更宽泛。
        @Override
        public void run( ) {
            synchronized (object) {
                i++;
                System.out.println("i:"+i);
                try {
                    System.out.println("线程"+Thread.currentThread().getName()+"进入睡眠状态");
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
                System.out.println("线程"+Thread.currentThread().getName()+"睡眠结束");
                i++;
                System.out.println("i:"+i);
            }
        }
    }




    //yield依然保持对象的锁。
/*
    class MyThread extends Thread {  //不能用throws抛出的原因：重写run，子类抛出的异常类型不能比父类抛出的异常类型更宽泛。
        @Override
        public void run() {
            //synchronized (object) {
                i++;
                System.out.println("i:" + i);

                System.out.println("线程" + Thread.currentThread().getName() + "调用yield");
                Thread.currentThread().yield();

                System.out.println("线程" + Thread.currentThread().getName() + "调用yield结束");
                i++;
                System.out.println("i:" + i);
            //}
        }
    }
*/


}
