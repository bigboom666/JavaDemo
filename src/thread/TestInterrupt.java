package thread;

import java.io.IOException;

public class TestInterrupt {

    public static void main(String[] args) throws IOException {
        TestInterrupt test = new TestInterrupt();
        //MyThreadA thread = test.new MyThreadA();
        //MyThreadB thread = test.new MyThreadB();
        MyThreadC thread = test.new MyThreadC();
        thread.start();
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {

        }
        thread.interrupt();
    }


    //测试interrupt能否中断阻塞中的异常
    class MyThreadA extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("进入睡眠状态");
                Thread.currentThread().sleep(10000);
                System.out.println("睡眠完毕");
            } catch (InterruptedException e) {
                System.out.println("得到中断异常");
            }
            System.out.println("run方法执行完毕");
        }
    }

    //测试interrupt能否中断非阻塞的异常
    class MyThreadB extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (i < Integer.MAX_VALUE) {
                System.out.println(i + " while循环");
                i++;
            }
        }
    }


    //测试interrupt配合isinterrupt中断非阻塞的异常
    class MyThreadC extends Thread{
        @Override
        public void run() {
            int i = 0;
            while(!isInterrupted() && i<Integer.MAX_VALUE){
                System.out.println(i+" while循环");
                i++;
            }
        }
    }


}