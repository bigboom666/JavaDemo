
public class TestInner {

    private class InsideClass implements Incrementable{
         void test(){
            System.out.println("这是一个测试");
        }
        
         public void increment() { };
   }
   public Incrementable getIn(){
       return new InsideClass();
   }


}


interface Incrementable{
	  void increment();
	}