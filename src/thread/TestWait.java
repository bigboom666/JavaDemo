package thread;

public class TestWait implements Runnable {   
	  
    private String name;   
    private Object prev;   
    private Object self;   
  
    private TestWait(String name, Object prev, Object self) {   
        this.name = name;   
        this.prev = prev;   
        this.self = self;   
    }   
  
    @Override  
    public void run() {   
        int count = 10;   
        while (count > 0) {   
            synchronized (prev) 
            {   
                synchronized (self) 
                {   
                    System.out.print(name);   
                    count--;  
                    
                    self.notify();   
                }   
                try 
                {   
                    prev.wait();   
                } catch (InterruptedException e)
                {   
                    e.printStackTrace();   
                }   
            }   
  
        }   
    }   


    
	static void test01() throws Exception {
		 Object a = new Object();   
	        Object b = new Object();   
	        Object c = new Object();   
	        TestWait pa = new TestWait("A", c, a);   
	        TestWait pb = new TestWait("B", a, b);   
	        TestWait pc = new TestWait("C", b, c);   
	           
	           
	        new Thread(pa).start();
	        Thread.sleep(100);  //ȷ����˳��A��B��Cִ��
	        new Thread(pb).start();
	        Thread.sleep(100);  
	        new Thread(pc).start();   
	        Thread.sleep(100);  
	        }   




}
