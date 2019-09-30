
public class TestStatic {
	static int i = 47; // 定义静态成员变量
    int j =666;
	public void call() { // 定义成员方法
		System.out.println("调用call()方法");
		for ( i= 0;  i< 3; i++) {                                                   //类变量不加类名也能直接用
			System.out.print(i+ " ");
			if (i== 2) {
				System.out.println("\n");
			}
		}
	}

	public TestStatic() { // 定义构造方法
	}

	public static void main(String[] args) { // 定义主方法
		TestStatic t1 = new TestStatic(); // 创建一个对象
		TestStatic t2 = new TestStatic(); // 创建另一个对象
		i = 60; // 将类成员变量赋值为60
		int j =0;
		// 使用第一个对象调用类成员变量
		System.out.println("第一个实例对象调用变量i的结果：" + (++TestStatic.i));
		t1.call(); // 使用第一个对象调用类成员方法
		// 使用第二个对象调用类成员变量
		System.out.println("第二个实例对象调用变量i的结果：" + TestStatic.i);
		t2.call(); // 使用第二个对象调用类成员方法
	}

}
