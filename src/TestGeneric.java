
//�˴�T�������дΪ�����ʶ����������T��E��K��V����ʽ�Ĳ��������ڱ�ʾ����
//��ʵ����������ʱ������ָ��T�ľ�������
public class TestGeneric<T> {
	// key�����Ա����������ΪT,T���������ⲿָ��
	private T key;

	public TestGeneric(T key) { // ���͹��췽���β�key������ҲΪT��T���������ⲿָ��
		this.key = key;
	}

	public T getKey() { // ���ͷ���getKey�ķ���ֵ����ΪT��T���������ⲿָ��
		return key;
	}

	public static void test1() {
		// ���͵����Ͳ���ֻ���������ͣ������Զ����ࣩ�������Ǽ�����
		// �����ʵ���������뷺�͵����Ͳ���������ͬ����ΪInteger.
		TestGeneric<Integer> genericInteger = new TestGeneric<Integer>(123456);

		// �����ʵ���������뷺�͵����Ͳ���������ͬ����ΪString.
		TestGeneric<String> genericString = new TestGeneric<String>("key_vlaue");
		System.out.println("���Ͳ���:key is " + genericInteger.getKey());
		System.out.println("���Ͳ���:key is " + genericString.getKey());

	}
	
	//δ���뷺�Ͳ���
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
