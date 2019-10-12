package thread;

public class MyThread extends Thread {

	private String name;
	
	
	public MyThread () {
		
	}
	
	public MyThread (String name) {
		super(name);
		this.name = name;
	}
	
	
	//重写父类的run方法
	public void run()
	{
		System.out.println(name);
	}
	
	
	

	static void test01() {
		MyThread mythread = new MyThread("A");
		mythread.start();
		
		
		
		System.out.println("运行结束");
	}

}
