import java.util.ArrayList;

//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class TestGeneric<T> {

	// key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public TestGeneric(T key) { // 泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }




	public TestGeneric( ) {

	}

    public T getKey() { // 泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }


    public static <T> T testT(T tempT) {
        System.out.println(tempT.getClass().getName());
        return tempT;
    }

    public static void test4() {
        TestGeneric.testT(6);
    }



/*        public static T one;   //编译错误
        public static T show(T one) { //编译错误
            return null;
        }*/



    public static void test1() {
        // 泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        // 传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        TestGeneric<Integer> genericInteger = new TestGeneric<Integer>(123456);

		TestGeneric<?> g = new TestGeneric<>();

		//TestGeneric<Integer>[] table = new TestGeneric<Integer>[10];
		System.out.println(g.key);

        // 传入的实参类型需与泛型的类型参数类型相同，即为String.
/*
        TestGeneric<String> genericString = new TestGeneric<String>("key_vlaue");
        System.out.println("泛型测试:key is " + genericInteger.getKey());
        System.out.println("泛型测试:key is " + genericString.getKey());
*/

    }

    //未传入泛型参数
    public static void test2() {
        int tempA = 001;
        TestGeneric gint = new TestGeneric(001);
        TestGeneric gstring = new TestGeneric("002");
        System.out.println(gint.key);
        System.out.println(gstring.key);
    }


    //泛型在编译阶段有效
    public static void test3() {

        ArrayList<String> a = new ArrayList<String>();  //创建泛型
        ArrayList<Integer> b = new ArrayList<Integer>();
        a.add("001");
        b.add(666);

        Class c1 = a.getClass();  //获取泛型的类型
        Class c2 = b.getClass();
        System.out.println(c1); //输出true
        System.out.println(c2);
    }


    public static void main(String[] args) {
        //TestGeneric.test3();
        test1();
    }

}
