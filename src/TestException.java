import java.util.logging.Logger;

public class TestException {
	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		int[] intArray = new int[3];
		try {
			for (int i = 0; i <= intArray.length; i++) {
				intArray[i] = i;
				Logger.getGlobal().info("info:"+intArray[i]);
				System.out.println("intArray[" + i + "] = " + intArray[i]);
				System.out.println("intArray[" + i + "]模 " + (i - 2) + "的值:  " + intArray[i] % (i - 2));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("intArray数组下标越界异常。");
		} catch (ArithmeticException e) {
			System.out.println("除数为0异常。");
		}
		System.out.println("程序正常结束。");
	}

	public static void test2() {
		int i = 0;
		String greetings[] = { " Hello world !", " Hello World !! ", " HELLO WORLD !!!" };
		while (i < 4) {
			try {
				// 特别注意循环控制变量i的设计，避免造成无限循环
				System.out.println(greetings[i++]);
				//System.out.println (greetings[i]); i++;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("数组下标越界异常");
			} finally {
				System.out.println("--------------------------");
			}
		}
	}
}
