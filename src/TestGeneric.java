
//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class TestGeneric<T> {
	// key这个成员变量的类型为T,T的类型由外部指定
	private T key;

	public TestGeneric(T key) { // 泛型构造方法形参key的类型也为T，T的类型由外部指定
		this.key = key;
	}

	public T getKey() { // 泛型方法getKey的返回值类型为T，T的类型由外部指定
		return key;
	}

	public static void test1() {
		// 泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
		// 传入的实参类型需与泛型的类型参数类型相同，即为Integer.
		TestGeneric<Integer> genericInteger = new TestGeneric<Integer>(123456);

		// 传入的实参类型需与泛型的类型参数类型相同，即为String.
		TestGeneric<String> genericString = new TestGeneric<String>("key_vlaue");
		System.out.println("泛型测试:key is " + genericInteger.getKey());
		System.out.println("泛型测试:key is " + genericString.getKey());

	}
	
	//未传入泛型参数
	public static void test2()
	{
		int tempA=001;
		TestGeneric gint = new TestGeneric(001);
		TestGeneric gstring = new TestGeneric("002");
		System.out.println(gint.key);
		System.out.println(gstring.key);
	}
	
	

	public static void main(String[] args)
	{
		TestGeneric.test1();
	}
	
	
}
