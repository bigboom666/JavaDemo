
public class TestStatic {
	static int i = 47; // ���徲̬��Ա����
    int j =666;
	public void call() { // �����Ա����
		System.out.println("����call()����");
		for ( i= 0;  i< 3; i++) {                                                   //�������������Ҳ��ֱ����
			System.out.print(i+ " ");
			if (i== 2) {
				System.out.println("\n");
			}
		}
	}

	public TestStatic() { // ���幹�췽��
	}

	public static void main(String[] args) { // ����������
		TestStatic t1 = new TestStatic(); // ����һ������
		TestStatic t2 = new TestStatic(); // ������һ������
		i = 60; // �����Ա������ֵΪ60
		int j =0;
		// ʹ�õ�һ������������Ա����
		System.out.println("��һ��ʵ��������ñ���i�Ľ����" + (++TestStatic.i));
		t1.call(); // ʹ�õ�һ������������Ա����
		// ʹ�õڶ�������������Ա����
		System.out.println("�ڶ���ʵ��������ñ���i�Ľ����" + TestStatic.i);
		t2.call(); // ʹ�õڶ�������������Ա����
	}

}
