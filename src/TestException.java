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
				System.out.println("intArray[" + i + "]ģ " + (i - 2) + "��ֵ:  " + intArray[i] % (i - 2));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("intArray�����±�Խ���쳣��");
		} catch (ArithmeticException e) {
			System.out.println("����Ϊ0�쳣��");
		}
		System.out.println("��������������");
	}

	public static void test2() {
		int i = 0;
		String greetings[] = { " Hello world !", " Hello World !! ", " HELLO WORLD !!!" };
		while (i < 4) {
			try {
				// �ر�ע��ѭ�����Ʊ���i����ƣ������������ѭ��
				System.out.println(greetings[i++]);
				//System.out.println (greetings[i]); i++;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("�����±�Խ���쳣");
			} finally {
				System.out.println("--------------------------");
			}
		}
	}
}
