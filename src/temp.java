import java.util.ArrayList;

class Test4 {
  public static void main(String[] args) {
    ArrayList<String> arrayList1=new ArrayList<String>();
    arrayList1.add("abc");
    ArrayList<Integer> arrayList2=new ArrayList<Integer>();
    arrayList2.add(123);
    System.out.println(arrayList1.getClass());
    System.out.println(arrayList1.getClass()==arrayList2.getClass());
  }
}
//class java.util.ArrayList
//true


public class Test2<T> {
  public static T one;   //编译错误
  public static  T show(T one){ //编译错误
    return null;
  }
}