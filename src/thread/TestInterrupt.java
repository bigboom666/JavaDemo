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


    //����interrupt�ܷ��ж������е��쳣
    class MyThreadA extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("����˯��״̬");
                Thread.currentThread().sleep(10000);
                System.out.println("˯�����");
            } catch (InterruptedException e) {
                System.out.println("�õ��ж��쳣");
            }
            System.out.println("run����ִ�����");
        }
    }

    //����interrupt�ܷ��жϷ��������쳣
    class MyThreadB extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (i < Integer.MAX_VALUE) {
                System.out.println(i + " whileѭ��");
                i++;
            }
        }
    }


    //����interrupt���isinterrupt�жϷ��������쳣
    class MyThreadC extends Thread{
        @Override
        public void run() {
            int i = 0;
            while(!isInterrupted() && i<Integer.MAX_VALUE){
                System.out.println(i+" whileѭ��");
                i++;
            }
        }
    }


}