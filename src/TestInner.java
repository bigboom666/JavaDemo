
public class TestInner {

    private class InsideClass implements Incrementable{
         void test(){
            System.out.println("����һ������");
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