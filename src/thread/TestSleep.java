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

    //sleep��Ȼ���ֶ��������
    class MyThread   extends Thread {  //������throws�׳���ԭ����дrun�������׳����쳣���Ͳ��ܱȸ����׳����쳣���͸�����
        @Override
        public void run( ) {
            synchronized (object) {
                i++;
                System.out.println("i:"+i);
                try {
                    System.out.println("�߳�"+Thread.currentThread().getName()+"����˯��״̬");
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
                System.out.println("�߳�"+Thread.currentThread().getName()+"˯�߽���");
                i++;
                System.out.println("i:"+i);
            }
        }
    }




    //yield��Ȼ���ֶ��������
/*
    class MyThread extends Thread {  //������throws�׳���ԭ����дrun�������׳����쳣���Ͳ��ܱȸ����׳����쳣���͸�����
        @Override
        public void run() {
            //synchronized (object) {
                i++;
                System.out.println("i:" + i);

                System.out.println("�߳�" + Thread.currentThread().getName() + "����yield");
                Thread.currentThread().yield();

                System.out.println("�߳�" + Thread.currentThread().getName() + "����yield����");
                i++;
                System.out.println("i:" + i);
            //}
        }
    }
*/


}
