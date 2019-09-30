package thread;

public class MyRunnable implements Runnable {

	public void run() {
		System.out.println("This Is MyRunnable");
	}
	
	static void test01() {
		Runnable runnable = new MyRunnable();
		Thread thread = new Thread(runnable);
		thread.start();
		System.out.println("ÔËĞĞ½áÊø");
	}
	
	
}
