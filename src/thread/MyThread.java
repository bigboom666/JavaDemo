package thread;

public class MyThread extends Thread {

	//���˸����run����
	public void run() {
		super.run();
		System.out.println("This Is MyThread");
	}

	static void test01() {
		MyThread mythread = new MyThread();
		mythread.start();
		System.out.println("���н���");
	}

}
