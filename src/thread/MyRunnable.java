package thread;

public class MyRunnable implements Runnable {

	private String name;
	
	private  MyRunnable(String name)
	{
		this.name = name;
		
	}
	
	
	
	public void run() {
		System.out.println(name);
	}
	
	static void test01() {
		MyRunnable runnable = new MyRunnable("A");
		Thread mTh1=new Thread(runnable);
		mTh1.start();
		
		//new Thread(new MyRunnable("A")).start();
		System.out.println("ÔËĞĞ½áÊø");
	}
	
	
}
