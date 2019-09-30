package thread;

public class MyThread extends Thread {

	//用了父类的run方法
	public void run() {
		super.run();
		System.out.println("This Is MyThread");
	}

	static void test01() {
		MyThread mythread = new MyThread();
		mythread.start();
		System.out.println("运行结束");
	}

}
